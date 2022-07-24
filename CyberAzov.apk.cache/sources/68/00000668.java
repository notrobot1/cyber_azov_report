package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StreamingAeadDecryptingChannel implements ReadableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private byte[] aad;
    private ReadableByteChannel ciphertextChannel;
    private ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private final int firstCiphertextSegmentSize;
    private ByteBuffer header;
    private ByteBuffer plaintextSegment;
    private boolean headerRead = false;
    private boolean endOfCiphertext = false;
    private boolean endOfPlaintext = false;
    private int segmentNr = 0;
    private boolean definedState = true;

    public StreamingAeadDecryptingChannel(NonceBasedStreamingAead streamAead, ReadableByteChannel ciphertextChannel, byte[] associatedData) throws GeneralSecurityException, IOException {
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = ciphertextChannel;
        this.header = ByteBuffer.allocate(streamAead.getHeaderLength());
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
        int ciphertextSegmentSize = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        ByteBuffer allocate = ByteBuffer.allocate(ciphertextSegmentSize + 1);
        this.ciphertextSegment = allocate;
        allocate.limit(0);
        this.firstCiphertextSegmentSize = ciphertextSegmentSize - streamAead.getCiphertextOffset();
        ByteBuffer allocate2 = ByteBuffer.allocate(streamAead.getPlaintextSegmentSize() + 16);
        this.plaintextSegment = allocate2;
        allocate2.limit(0);
    }

    private void readSomeCiphertext(ByteBuffer buffer) throws IOException {
        int read;
        do {
            read = this.ciphertextChannel.read(buffer);
            if (read <= 0) {
                break;
            }
        } while (buffer.remaining() > 0);
        if (read == -1) {
            this.endOfCiphertext = true;
        }
    }

    private boolean tryReadHeader() throws IOException {
        if (this.endOfCiphertext) {
            throw new IOException("Ciphertext is too short");
        }
        readSomeCiphertext(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e) {
            setUndefinedState();
            throw new IOException(e);
        }
    }

    private void setUndefinedState() {
        this.definedState = false;
        this.plaintextSegment.limit(0);
    }

    private boolean tryLoadSegment() throws IOException {
        if (!this.endOfCiphertext) {
            readSomeCiphertext(this.ciphertextSegment);
        }
        byte b = 0;
        if (this.ciphertextSegment.remaining() <= 0 || this.endOfCiphertext) {
            if (!this.endOfCiphertext) {
                ByteBuffer byteBuffer = this.ciphertextSegment;
                b = byteBuffer.get(byteBuffer.position() - 1);
                ByteBuffer byteBuffer2 = this.ciphertextSegment;
                byteBuffer2.position(byteBuffer2.position() - 1);
            }
            this.ciphertextSegment.flip();
            this.plaintextSegment.clear();
            try {
                this.decrypter.decryptSegment(this.ciphertextSegment, this.segmentNr, this.endOfCiphertext, this.plaintextSegment);
                this.segmentNr++;
                this.plaintextSegment.flip();
                this.ciphertextSegment.clear();
                if (!this.endOfCiphertext) {
                    this.ciphertextSegment.clear();
                    this.ciphertextSegment.limit(this.ciphertextSegmentSize + 1);
                    this.ciphertextSegment.put(b);
                }
                return true;
            } catch (GeneralSecurityException e) {
                setUndefinedState();
                throw new IOException(e.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.segmentNr + " endOfCiphertext:" + this.endOfCiphertext, e);
            }
        }
        return false;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        if (!this.definedState) {
            throw new IOException("This StreamingAeadDecryptingChannel is in an undefined state");
        }
        if (!this.headerRead) {
            if (!tryReadHeader()) {
                return 0;
            }
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(this.firstCiphertextSegmentSize + 1);
        }
        if (this.endOfPlaintext) {
            return -1;
        }
        int position = dst.position();
        while (true) {
            if (dst.remaining() <= 0) {
                break;
            }
            if (this.plaintextSegment.remaining() == 0) {
                if (this.endOfCiphertext) {
                    this.endOfPlaintext = true;
                    break;
                } else if (!tryLoadSegment()) {
                    break;
                }
            }
            if (this.plaintextSegment.remaining() <= dst.remaining()) {
                this.plaintextSegment.remaining();
                dst.put(this.plaintextSegment);
            } else {
                int remaining = dst.remaining();
                ByteBuffer duplicate = this.plaintextSegment.duplicate();
                duplicate.limit(duplicate.position() + remaining);
                dst.put(duplicate);
                ByteBuffer byteBuffer = this.plaintextSegment;
                byteBuffer.position(byteBuffer.position() + remaining);
            }
        }
        int position2 = dst.position() - position;
        if (position2 == 0 && this.endOfPlaintext) {
            return -1;
        }
        return position2;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("StreamingAeadDecryptingChannel").append("\nsegmentNr:").append(this.segmentNr).append("\nciphertextSegmentSize:").append(this.ciphertextSegmentSize).append("\nheaderRead:").append(this.headerRead).append("\nendOfCiphertext:").append(this.endOfCiphertext).append("\nendOfPlaintext:").append(this.endOfPlaintext).append("\ndefinedState:").append(this.definedState).append("\nHeader").append(" position:").append(this.header.position()).append(" limit:").append(this.header.position()).append("\nciphertextSgement").append(" position:").append(this.ciphertextSegment.position()).append(" limit:").append(this.ciphertextSegment.limit()).append("\nplaintextSegment").append(" position:").append(this.plaintextSegment.position()).append(" limit:").append(this.plaintextSegment.limit());
        return sb.toString();
    }
}
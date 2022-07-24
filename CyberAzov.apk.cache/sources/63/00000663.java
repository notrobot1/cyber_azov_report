package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;
    private long plaintextPosition = 0;
    private boolean headerRead = false;
    private int currentSegmentNr = -1;
    private boolean isCurrentSegmentDecrypted = false;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead streamAead, SeekableByteChannel ciphertext, byte[] associatedData) throws IOException, GeneralSecurityException {
        this.decrypter = streamAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = ciphertext;
        this.header = ByteBuffer.allocate(streamAead.getHeaderLength());
        int ciphertextSegmentSize = streamAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize);
        int plaintextSegmentSize = streamAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize + 16);
        long size = ciphertext.size();
        this.ciphertextChannelSize = size;
        this.aad = Arrays.copyOf(associatedData, associatedData.length);
        this.isopen = ciphertext.isOpen();
        int i = (int) (size / ciphertextSegmentSize);
        int i2 = (int) (size % ciphertextSegmentSize);
        int ciphertextOverhead = streamAead.getCiphertextOverhead();
        if (i2 > 0) {
            this.numberOfSegments = i + 1;
            if (i2 < ciphertextOverhead) {
                throw new IOException("Invalid ciphertext size");
            }
            this.lastCiphertextSegmentSize = i2;
        } else {
            this.numberOfSegments = i;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize;
        }
        int ciphertextOffset = streamAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset;
        int headerLength = ciphertextOffset - streamAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j = (this.numberOfSegments * ciphertextOverhead) + ciphertextOffset;
        if (j > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.plaintextSize = size - j;
    }

    public synchronized String toString() {
        StringBuilder sb;
        String str;
        sb = new StringBuilder();
        try {
            str = "position:" + this.ciphertextChannel.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb.append("StreamingAeadSeekableDecryptingChannel").append("\nciphertextChannel").append(str).append("\nciphertextChannelSize:").append(this.ciphertextChannelSize).append("\nplaintextSize:").append(this.plaintextSize).append("\nciphertextSegmentSize:").append(this.ciphertextSegmentSize).append("\nnumberOfSegments:").append(this.numberOfSegments).append("\nheaderRead:").append(this.headerRead).append("\nplaintextPosition:").append(this.plaintextPosition).append("\nHeader").append(" position:").append(this.header.position()).append(" limit:").append(this.header.position()).append("\ncurrentSegmentNr:").append(this.currentSegmentNr).append("\nciphertextSgement").append(" position:").append(this.ciphertextSegment.position()).append(" limit:").append(this.ciphertextSegment.limit()).append("\nisCurrentSegmentDecrypted:").append(this.isCurrentSegmentDecrypted).append("\nplaintextSegment").append(" position:").append(this.plaintextSegment.position()).append(" limit:").append(this.plaintextSegment.limit());
        return sb.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        return this.plaintextPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long newPosition) {
        this.plaintextPosition = newPosition;
        return this;
    }

    private boolean tryReadHeader() throws IOException {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        this.ciphertextChannel.read(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e) {
            throw new IOException(e);
        }
    }

    private int getSegmentNr(long plaintextPosition) {
        return (int) ((plaintextPosition + this.ciphertextOffset) / this.plaintextSegmentSize);
    }

    private boolean tryLoadSegment(int segmentNr) throws IOException {
        int i;
        if (segmentNr < 0 || segmentNr >= (i = this.numberOfSegments)) {
            throw new IOException("Invalid position");
        }
        boolean z = segmentNr == i - 1;
        if (segmentNr == this.currentSegmentNr) {
            if (this.isCurrentSegmentDecrypted) {
                return true;
            }
        } else {
            int i2 = this.ciphertextSegmentSize;
            long j = segmentNr * i2;
            if (z) {
                i2 = this.lastCiphertextSegmentSize;
            }
            if (segmentNr == 0) {
                int i3 = this.ciphertextOffset;
                i2 -= i3;
                j = i3;
            }
            this.ciphertextChannel.position(j);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i2);
            this.currentSegmentNr = segmentNr;
            this.isCurrentSegmentDecrypted = false;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            this.ciphertextChannel.read(this.ciphertextSegment);
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, segmentNr, z, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e);
        }
    }

    private boolean reachedEnd() {
        return this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0;
    }

    public synchronized int read(ByteBuffer dst, long start) throws IOException {
        int read;
        long position = position();
        position(start);
        read = read(dst);
        position(position);
        return read;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer dst) throws IOException {
        long j;
        if (!this.isopen) {
            throw new ClosedChannelException();
        }
        if (!this.headerRead && !tryReadHeader()) {
            return 0;
        }
        int position = dst.position();
        while (dst.remaining() > 0) {
            long j2 = this.plaintextPosition;
            if (j2 < this.plaintextSize) {
                int segmentNr = getSegmentNr(j2);
                if (segmentNr == 0) {
                    j = this.plaintextPosition;
                } else {
                    j = (this.plaintextPosition + this.ciphertextOffset) % this.plaintextSegmentSize;
                }
                int i = (int) j;
                if (!tryLoadSegment(segmentNr)) {
                    break;
                }
                this.plaintextSegment.position(i);
                if (this.plaintextSegment.remaining() <= dst.remaining()) {
                    this.plaintextPosition += this.plaintextSegment.remaining();
                    dst.put(this.plaintextSegment);
                } else {
                    int remaining = dst.remaining();
                    ByteBuffer duplicate = this.plaintextSegment.duplicate();
                    duplicate.limit(duplicate.position() + remaining);
                    dst.put(duplicate);
                    this.plaintextPosition += remaining;
                    ByteBuffer byteBuffer = this.plaintextSegment;
                    byteBuffer.position(byteBuffer.position() + remaining);
                }
            } else {
                break;
            }
        }
        int position2 = dst.position() - position;
        if (position2 == 0 && reachedEnd()) {
            return -1;
        }
        return position2;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public synchronized long verifiedSize() throws IOException {
        if (tryLoadSegment(this.numberOfSegments - 1)) {
        } else {
            throw new IOException("could not verify the size");
        }
        return this.plaintextSize;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long size) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws NonWritableChannelException {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ciphertextChannel.close();
        this.isopen = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.isopen;
    }
}
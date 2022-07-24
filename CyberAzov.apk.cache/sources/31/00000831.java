package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KmsEnvelopeAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsEnvelopeAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}
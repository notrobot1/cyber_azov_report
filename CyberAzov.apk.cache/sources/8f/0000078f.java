package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KmsAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}
package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
/* loaded from: classes.dex */
public interface AeadFactory {
    Aead createAead(final byte[] symmetricKey) throws GeneralSecurityException;

    int getKeySizeInBytes();
}
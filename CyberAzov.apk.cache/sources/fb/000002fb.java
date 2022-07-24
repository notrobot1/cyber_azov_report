package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface EciesAeadHkdfDemHelper {
    Aead getAead(final byte[] symmetricKeyValue) throws GeneralSecurityException;

    int getSymmetricKeySizeInBytes();
}
package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface DeterministicAead {
    byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException;

    byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException;
}
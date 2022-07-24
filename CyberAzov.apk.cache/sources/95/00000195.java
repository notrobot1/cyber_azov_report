package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface HybridEncrypt {
    byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException;
}
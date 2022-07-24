package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public interface PrimitiveWrapper<B, P> {
    Class<B> getInputPrimitiveClass();

    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<B> set) throws GeneralSecurityException;
}
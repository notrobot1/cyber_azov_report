package com.google.crypto.tink;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class NoSecretKeysetHandle {
    @Deprecated
    public static final KeysetHandle parseFrom(final byte[] serialized) throws GeneralSecurityException {
        try {
            Keyset parseFrom = Keyset.parseFrom(serialized, ExtensionRegistryLite.getEmptyRegistry());
            validate(parseFrom);
            return KeysetHandle.fromKeyset(parseFrom);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final KeysetHandle read(KeysetReader reader) throws GeneralSecurityException, IOException {
        Keyset read = reader.read();
        validate(read);
        return KeysetHandle.fromKeyset(read);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void validate(com.google.crypto.tink.proto.Keyset r3) throws java.security.GeneralSecurityException {
        /*
            java.util.List r3 = r3.getKeyList()
            java.util.Iterator r3 = r3.iterator()
        L8:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L41
            java.lang.Object r0 = r3.next()
            com.google.crypto.tink.proto.Keyset$Key r0 = (com.google.crypto.tink.proto.Keyset.Key) r0
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL
            if (r1 == r2) goto L39
            com.google.crypto.tink.proto.KeyData r1 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = r1.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r2 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.SYMMETRIC
            if (r1 == r2) goto L39
            com.google.crypto.tink.proto.KeyData r0 = r0.getKeyData()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r0 = r0.getKeyMaterialType()
            com.google.crypto.tink.proto.KeyData$KeyMaterialType r1 = com.google.crypto.tink.proto.KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE
            if (r0 == r1) goto L39
            goto L8
        L39:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r0 = "keyset contains secret key material"
            r3.<init>(r0)
            throw r3
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.NoSecretKeysetHandle.validate(com.google.crypto.tink.proto.Keyset):void");
    }
};
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UShortArray.m386isEmptyimpl(this.$this_asList);
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public boolean m535containsxj2QHRw(short s) {
        return UShortArray.m379containsxj2QHRw(this.$this_asList, s);
    }

    /* renamed from: get-Mh2AYeg  reason: not valid java name */
    public short m536getMh2AYeg(int i) {
        return UShortArray.m383getMh2AYeg(this.$this_asList, i);
    }

    /* renamed from: indexOf-xj2QHRw  reason: not valid java name */
    public int m537indexOfxj2QHRw(short s) {
        return ArraysKt.indexOf(this.$this_asList, s);
    }

    /* renamed from: lastIndexOf-xj2QHRw  reason: not valid java name */
    public int m538lastIndexOfxj2QHRw(short s) {
        return ArraysKt.lastIndexOf(this.$this_asList, s);
    }
}
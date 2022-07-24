package androidx.security.crypto;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class MasterKey {
    public static final int DEFAULT_AES_GCM_MASTER_KEY_SIZE = 256;
    private static final int DEFAULT_AUTHENTICATION_VALIDITY_DURATION_SECONDS = 300;
    public static final String DEFAULT_MASTER_KEY_ALIAS = "_androidx_security_master_key_";
    static final String KEYSTORE_PATH_URI = "android-keystore://";
    private final String mKeyAlias;
    private final KeyGenParameterSpec mKeyGenParameterSpec;

    /* loaded from: classes.dex */
    public enum KeyScheme {
        AES256_GCM
    }

    public static int getDefaultAuthenticationValidityDurationSeconds() {
        return DEFAULT_AUTHENTICATION_VALIDITY_DURATION_SECONDS;
    }

    MasterKey(String keyAlias, Object keyGenParameterSpec) {
        this.mKeyAlias = keyAlias;
        if (Build.VERSION.SDK_INT >= 23) {
            this.mKeyGenParameterSpec = (KeyGenParameterSpec) keyGenParameterSpec;
        } else {
            this.mKeyGenParameterSpec = null;
        }
    }

    public boolean isKeyStoreBacked() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(this.mKeyAlias);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    public boolean isUserAuthenticationRequired() {
        KeyGenParameterSpec keyGenParameterSpec;
        return Build.VERSION.SDK_INT >= 23 && (keyGenParameterSpec = this.mKeyGenParameterSpec) != null && keyGenParameterSpec.isUserAuthenticationRequired();
    }

    public int getUserAuthenticationValidityDurationSeconds() {
        KeyGenParameterSpec keyGenParameterSpec;
        if (Build.VERSION.SDK_INT >= 23 && (keyGenParameterSpec = this.mKeyGenParameterSpec) != null) {
            return keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds();
        }
        return 0;
    }

    public boolean isStrongBoxBacked() {
        KeyGenParameterSpec keyGenParameterSpec;
        if (Build.VERSION.SDK_INT < 28 || (keyGenParameterSpec = this.mKeyGenParameterSpec) == null) {
            return false;
        }
        return keyGenParameterSpec.isStrongBoxBacked();
    }

    public String toString() {
        return "MasterKey{keyAlias=" + this.mKeyAlias + ", isKeyStoreBacked=" + isKeyStoreBacked() + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getKeyAlias() {
        return this.mKeyAlias;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean mAuthenticationRequired;
        private final Context mContext;
        private final String mKeyAlias;
        private KeyGenParameterSpec mKeyGenParameterSpec;
        private KeyScheme mKeyScheme;
        private boolean mRequestStrongBoxBacked;
        private int mUserAuthenticationValidityDurationSeconds;

        public Builder(Context context) {
            this(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS);
        }

        public Builder(Context context, String keyAlias) {
            this.mContext = context.getApplicationContext();
            this.mKeyAlias = keyAlias;
        }

        public Builder setKeyScheme(KeyScheme keyScheme) {
            if (AnonymousClass1.$SwitchMap$androidx$security$crypto$MasterKey$KeyScheme[keyScheme.ordinal()] == 1) {
                if (Build.VERSION.SDK_INT >= 23 && this.mKeyGenParameterSpec != null) {
                    throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
                }
                this.mKeyScheme = keyScheme;
                return this;
            }
            throw new IllegalArgumentException("Unsupported scheme: " + keyScheme);
        }

        public Builder setUserAuthenticationRequired(boolean authenticationRequired) {
            return setUserAuthenticationRequired(authenticationRequired, MasterKey.getDefaultAuthenticationValidityDurationSeconds());
        }

        public Builder setUserAuthenticationRequired(boolean authenticationRequired, int userAuthenticationValidityDurationSeconds) {
            this.mAuthenticationRequired = authenticationRequired;
            this.mUserAuthenticationValidityDurationSeconds = userAuthenticationValidityDurationSeconds;
            return this;
        }

        public Builder setRequestStrongBoxBacked(boolean requestStrongBoxBacked) {
            this.mRequestStrongBoxBacked = requestStrongBoxBacked;
            return this;
        }

        public Builder setKeyGenParameterSpec(KeyGenParameterSpec keyGenParameterSpec) {
            if (this.mKeyScheme != null) {
                throw new IllegalArgumentException("KeyGenParamSpec set after setting a KeyScheme");
            }
            if (!this.mKeyAlias.equals(keyGenParameterSpec.getKeystoreAlias())) {
                throw new IllegalArgumentException("KeyGenParamSpec's key alias does not match provided alias (" + this.mKeyAlias + " vs " + keyGenParameterSpec.getKeystoreAlias());
            }
            this.mKeyGenParameterSpec = keyGenParameterSpec;
            return this;
        }

        public MasterKey build() throws GeneralSecurityException, IOException {
            if (Build.VERSION.SDK_INT >= 23) {
                return buildOnM();
            }
            return new MasterKey(this.mKeyAlias, null);
        }

        private MasterKey buildOnM() throws GeneralSecurityException, IOException {
            KeyScheme keyScheme = this.mKeyScheme;
            if (keyScheme == null && this.mKeyGenParameterSpec == null) {
                throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
            }
            if (keyScheme == KeyScheme.AES256_GCM) {
                KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(this.mKeyAlias, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
                if (this.mAuthenticationRequired) {
                    keySize.setUserAuthenticationRequired(true).setUserAuthenticationValidityDurationSeconds(this.mUserAuthenticationValidityDurationSeconds);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.mRequestStrongBoxBacked && this.mContext.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                    keySize.setIsStrongBoxBacked(true);
                }
                this.mKeyGenParameterSpec = keySize.build();
            }
            KeyGenParameterSpec keyGenParameterSpec = this.mKeyGenParameterSpec;
            Objects.requireNonNull(keyGenParameterSpec, "KeyGenParameterSpec was null after build() check");
            return new MasterKey(MasterKeys.getOrCreate(keyGenParameterSpec), this.mKeyGenParameterSpec);
        }
    }

    /* renamed from: androidx.security.crypto.MasterKey$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$security$crypto$MasterKey$KeyScheme;

        static {
            int[] iArr = new int[KeyScheme.values().length];
            $SwitchMap$androidx$security$crypto$MasterKey$KeyScheme = iArr;
            try {
                iArr[KeyScheme.AES256_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
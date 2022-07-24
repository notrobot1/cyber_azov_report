package androidx.biometric.auth;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes.dex */
public class AuthPromptHost {
    private FragmentActivity mActivity;
    private Fragment mFragment;

    public AuthPromptHost(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    public AuthPromptHost(Fragment fragment) {
        this.mFragment = fragment;
    }

    public FragmentActivity getActivity() {
        return this.mActivity;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }
}
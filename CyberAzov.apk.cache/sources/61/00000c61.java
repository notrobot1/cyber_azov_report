package com.cyber.azov2.splash;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.cyber.azov2.MainActivity;
import com.example.guiproposal.databinding.ActivitySplashBinding;

/* loaded from: classes.dex */
public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    private final long shortAnimationDuration = 2000;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(17432576, 17432577);
        ActivitySplashBinding inflate = ActivitySplashBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView(inflate.getRoot());
        setupAnimation();
    }

    private void setupAnimation() {
        setupAlphaAnimation(this.binding.splashLogo, new AnimatorListenerAdapter() { // from class: com.cyber.azov2.splash.SplashActivity.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SplashActivity.this.startMainActivity();
            }
        });
        setupAlphaAnimation(this.binding.splashMotto, null);
    }

    private void setupAlphaAnimation(View view, Animator.AnimatorListener animatorListener) {
        view.setVisibility(8);
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(2000L).setListener(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(268468224);
        startActivity(intent);
    }
}
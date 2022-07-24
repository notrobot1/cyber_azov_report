package com.example.guiproposal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.cyber.azov2.R;

/* loaded from: classes.dex */
public final class ActivitySplashBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ImageView splashLogo;
    public final TextView splashMotto;

    private ActivitySplashBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.splashLogo = imageView;
        this.splashMotto = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySplashBinding bind(View view) {
        int i = R.id.splash_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.splash_logo);
        if (imageView != null) {
            i = R.id.splash_motto;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.splash_motto);
            if (textView != null) {
                return new ActivitySplashBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
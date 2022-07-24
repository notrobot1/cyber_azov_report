package com.example.guiproposal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.cyber.azov2.DeterminantCircularProgressBar;
import com.cyber.azov2.R;

/* loaded from: classes.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final BottomSheetBinding included;
    public final TextView levelLabel;
    public final TextView progressTv;
    public final DeterminantCircularProgressBar progressbar;
    private final ConstraintLayout rootView;

    private ActivityMainBinding(ConstraintLayout constraintLayout, BottomSheetBinding bottomSheetBinding, TextView textView, TextView textView2, DeterminantCircularProgressBar determinantCircularProgressBar) {
        this.rootView = constraintLayout;
        this.included = bottomSheetBinding;
        this.levelLabel = textView;
        this.progressTv = textView2;
        this.progressbar = determinantCircularProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = R.id.included;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.included);
        if (findChildViewById != null) {
            BottomSheetBinding bind = BottomSheetBinding.bind(findChildViewById);
            i = R.id.level_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.level_label);
            if (textView != null) {
                i = R.id.progress_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.progress_tv);
                if (textView2 != null) {
                    i = R.id.progressbar;
                    DeterminantCircularProgressBar determinantCircularProgressBar = (DeterminantCircularProgressBar) ViewBindings.findChildViewById(view, R.id.progressbar);
                    if (determinantCircularProgressBar != null) {
                        return new ActivityMainBinding((ConstraintLayout) view, bind, textView, textView2, determinantCircularProgressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
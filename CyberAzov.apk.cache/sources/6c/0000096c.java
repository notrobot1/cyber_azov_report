package com.example.guiproposal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.cyber.azov2.R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class BottomSheetBinding implements ViewBinding {
    public final RecyclerView attackRecyclerView;
    public final LinearLayout bottomSheetLayout;
    public final TextView performingAttackTv;
    private final LinearLayout rootView;
    public final MaterialButton startStopButton;

    private BottomSheetBinding(LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView, MaterialButton materialButton) {
        this.rootView = linearLayout;
        this.attackRecyclerView = recyclerView;
        this.bottomSheetLayout = linearLayout2;
        this.performingAttackTv = textView;
        this.startStopButton = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetBinding bind(View view) {
        int i = R.id.attack_recycler_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.attack_recycler_view);
        if (recyclerView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.performing_attack_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.performing_attack_tv);
            if (textView != null) {
                i = R.id.start_stop_button;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, R.id.start_stop_button);
                if (materialButton != null) {
                    return new BottomSheetBinding(linearLayout, recyclerView, linearLayout, textView, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
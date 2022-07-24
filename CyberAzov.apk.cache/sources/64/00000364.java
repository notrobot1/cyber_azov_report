package com.example.guiproposal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.cyber.azov2.R;

/* loaded from: classes.dex */
public final class RecyclerItemBinding implements ViewBinding {
    public final TextView attackUrlName;
    private final FrameLayout rootView;

    private RecyclerItemBinding(FrameLayout frameLayout, TextView textView) {
        this.rootView = frameLayout;
        this.attackUrlName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RecyclerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.recycler_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RecyclerItemBinding bind(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.attack_url_name);
        if (textView != null) {
            return new RecyclerItemBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.attack_url_name)));
    }
}
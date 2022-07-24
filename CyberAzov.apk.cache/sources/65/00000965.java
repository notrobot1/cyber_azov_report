package com.cyber.azov2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.guiproposal.databinding.RecyclerItemBinding;
import java.util.List;

/* loaded from: classes.dex */
public class TargetAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<String> targets;

    public TargetAdapter(List<String> list) {
        this.targets = list;
    }

    public void setTargets(List<String> list) {
        this.targets = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(i, this.targets);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.targets.size();
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerItemBinding binding;

        public ViewHolder(RecyclerItemBinding recyclerItemBinding) {
            super(recyclerItemBinding.getRoot());
            this.binding = recyclerItemBinding;
        }

        public void bind(int i, List<String> list) {
            this.binding.attackUrlName.setText("> " + list.get(i));
        }
    }
}
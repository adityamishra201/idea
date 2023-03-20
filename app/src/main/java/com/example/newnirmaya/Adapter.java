package com.example.newnirmaya;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PolicyViewHolder> {

    private List<ModelClass> mPolicyList;

    public Adapter(List<ModelClass> policyList) {
        mPolicyList = policyList;
    }

    @NonNull
    @Override
    public PolicyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_design, parent, false);
        return new PolicyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PolicyViewHolder holder, int position) {
        ModelClass policy = mPolicyList.get(position);
        holder.titleTextView.setText(policy.getInsurance_name_text_view());
        holder.descriptionTextView.setText(policy.getDescription_text_view());
    }

    @Override
    public int getItemCount() {
        return mPolicyList.size();
    }

    public static class PolicyViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImageView;
        TextView titleTextView;
        TextView descriptionTextView;

        public PolicyViewHolder(View view) {
            super(view);
            logoImageView=view.findViewById(R.id.logo_image_view);
            titleTextView = view.findViewById(R.id.insurance_name_text_view);
            descriptionTextView = view.findViewById(R.id.description_text_view);
        }
    }
}

package com.ariltw.composer.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected abstract void clear();

    public void onBind(int position) {
        clear();
    }

}

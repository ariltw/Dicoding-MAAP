package com.ariltw.composer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ariltw.composer.DetailActivity;
import com.ariltw.composer.R;
import com.ariltw.composer.model.Composer;
import com.bumptech.glide.Glide;

import java.util.List;

public class ComposerListAdapter extends RecyclerView.Adapter<ComposerListAdapter.ViewHolder> {

    private static final String TAG = ComposerListAdapter.class.getSimpleName();
    private final List<Composer> composerList;
    private final Context context;

    public ComposerListAdapter(List<Composer> composers, Context context) {
        this.composerList = composers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_composer, parent, false), context);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (composerList != null && composerList.size() > 0) {
            return composerList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {

        final TextView name;
        final ImageView img;
        final Context context;

        ViewHolder(View itemView, Context context) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.image);
            this.context = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /* move to activity with parcelable */
            Composer data = composerList.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, data);
            context.startActivity(intent);
        }

        @Override
        protected void clear() {
            Glide.with(context).clear(img);
        }

        public void onBind(int position) {
            super.onBind(position);

            final Composer composer = composerList.get(position);
            name.setText(composer.getName());
            Glide.with(this.context)
                    .load(composer.getImage())
                    .placeholder(R.color.colorPrimary)
                    .into(img);
        }
    }

}

package com.example.recylerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] titles = {"Chapter One",
            "Chapter Two", "Chapter Three",  "Chapter Four",  "Chapter Five",
            "Chapter Six",  "Chapter Seven",  "Chapter Eight"};

    private String[] details = {"Item one details",  "Item two details", "Item three details",
            "Item four details", "Item five details", "Item six details", "Item seven details",
            "Item eight details",};
    private int[] images = {R.drawable.android_image_1, R.drawable.android_image_2,
            R.drawable.android_image_3, R.drawable.android_image_4,
            R.drawable.android_image_5, R.drawable.android_image_6,
            R.drawable.android_image_7, R.drawable.android_image_8,};

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemTitle.setText(titles[position]);
        viewHolder.itemDetail.setText(details[position]);
        viewHolder.itemImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on item " + (position + 1),
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });
        }
    }
}

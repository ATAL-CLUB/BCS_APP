package com.example.davidkd.bcs1.Fragments;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidkd.bcs1.R;

/**
 * Created by davidg on 04/05/2017.
 */

class ImageAdapter2 extends RecyclerView.Adapter<ImageAdapter2.ViewHolder> {

    private String[] captions , info ;
    private int[] imageIds;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public ImageAdapter2(String[] captions, String[] info, int[] imageIds) {
        this.captions = captions;
        this.imageIds = imageIds;
        this.info = info;

    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public ImageAdapter2.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){

        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);

        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);

        TextView textView1 = (TextView)cardView.findViewById(R.id.info_text1);
        textView1.setText(info[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}

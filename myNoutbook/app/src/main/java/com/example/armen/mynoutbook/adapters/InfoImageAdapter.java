package com.example.armen.mynoutbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.models.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InfoImageAdapter extends RecyclerView.Adapter<InfoImageAdapter.ImageViewHolder> {
    private Context context;
    private List<ProductModel> imagList;

    public InfoImageAdapter(Context context, List<ProductModel> imagList) {
        this.context = context;
        this.imagList = imagList;
    }

    @NonNull
    @Override
    public InfoImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoImageAdapter.ImageViewHolder holder, int position) {
        ProductModel productModel = imagList.get(position);
        Picasso.get()
                .load(productModel.getImageUrl().get(1))
                .placeholder(R.drawable.ic_image_aspect_24dp)
                .into(holder.imgL);

    }

    @Override
    public int getItemCount() {
        return imagList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgL;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imgL = itemView.findViewById(R.id.image_list_view);
        }
    }
}

package com.example.armen.mynoutbook.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.activity.InfoActivity;
import com.example.armen.mynoutbook.models.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PrAdapter extends RecyclerView.Adapter<PrAdapter.ProductViewHolder> {
    public static final String INF_KEY ="inf" ;
    private Context context;
    private List<ProductModel> list;

    public PrAdapter(Context context, List<ProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PrAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final PrAdapter.ProductViewHolder holder, final int position) {
        final ProductModel prModel = list.get(position);
        holder.title.setText(prModel.getTitle());
        holder.description.setText(prModel.getDescription());
        Picasso.get().load(prModel.getImageUrl().get(0)).placeholder(R.drawable.ic_image_aspect_24dp).into(holder.image);
        holder.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fab.setRippleColor(Color.rgb(255, 0, 0));
                holder.fab.setImageResource(R.drawable.ic_favorite_24dp);
                holder.fab.setImageResource(R.drawable.ic_favorite_press_24dp);

                    prModel.setFavorite(true);

            }

        });
        holder.fabBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fabBy.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                prModel.setCardBy(true);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra(INF_KEY,position);
                context.startActivity(intent);
            }
        });

    }



    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView image;
        FloatingActionButton fab;
        ImageButton fabBy;


        public ProductViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.pr_title);
            description = itemView.findViewById(R.id.pr_description);
            image = itemView.findViewById(R.id.pr_img);
            fab = itemView.findViewById(R.id.pr_favorite_fab);
            fabBy = itemView.findViewById(R.id.pr_fabBy);
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));



        }

    }


}

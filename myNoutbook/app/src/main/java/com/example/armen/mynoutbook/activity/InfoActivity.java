package com.example.armen.mynoutbook.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.armen.mynoutbook.PrProvider;
import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.adapters.InfoImageAdapter;
import com.example.armen.mynoutbook.adapters.PrAdapter;
import com.example.armen.mynoutbook.models.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

public class InfoActivity extends AppCompatActivity {

    private Inflater inflater;
    private InfoImageAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new InfoImageAdapter(InfoActivity.this,PrProvider.getPrList());
        recyclerView = findViewById(R.id.info_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final int position = getIntent().getIntExtra(PrAdapter.INF_KEY,0);
        ProductModel prModel = PrProvider.getIntPosition(position);
        ImageView iImg = findViewById(R.id.title_image);
        Picasso.get()
                .load(prModel.getImageUrl().get(0))
                .placeholder(R.drawable.ic_image_aspect_24dp)
                .into(iImg);

    }
}

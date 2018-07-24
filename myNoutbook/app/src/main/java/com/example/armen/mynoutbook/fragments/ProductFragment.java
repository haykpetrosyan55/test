package com.example.armen.mynoutbook.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.armen.mynoutbook.PrProvider;
import com.example.armen.mynoutbook.R;
import com.example.armen.mynoutbook.adapters.PrAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {


    private RecyclerView recyclerView;
    private PrAdapter adapter;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_product, container, false);
        adapter = new PrAdapter(getContext(), PrProvider.getPrList());
        recyclerView = view.findViewById(R.id.pr_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);


        return view;
    }

    public void updateAdapter() {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void upDaListData(String category) {
        recyclerView.setAdapter(new PrAdapter(getActivity(), PrProvider.getListByCategory(category)));

    }

    public void setListByFavorite() {
        recyclerView.setAdapter(new PrAdapter(getActivity(), PrProvider.getListByFavorite()));
    }

    public void setListByCard() {
        recyclerView.setAdapter(new PrAdapter(getActivity(), PrProvider.getListByCard()));

    }


}



package iteso.com.rentstudio;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import iteso.com.rentstudio.beans.Rent;


public class Fragment_Main extends android.support.v4.app.Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Rent> myDataSet;

    public Fragment_Main(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        myDataSet = new ArrayList<>();

        myDataSet.add(new Rent("Bustamante #128", "Hector Toscano",
                new Date(2017, 5, 14)));
        myDataSet.add(new Rent("Pipíla #1", "Roberto Cortéz",
                new Date(2017, 6, 4)));
        myDataSet.add(new Rent("Manuel M. Dieguez #12", "Cynthia Garibay",
                new Date(2017, 7, 1)));

        mAdapter = new Adapter_Rent_Card(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

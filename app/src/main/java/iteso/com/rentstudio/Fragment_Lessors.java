package iteso.com.rentstudio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import iteso.com.rentstudio.beans.Lessor;
import iteso.com.rentstudio.beans.Rent;


public class Fragment_Lessors extends android.support.v4.app.Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Lessor> myDataSet;

    public Fragment_Lessors(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        myDataSet = new ArrayList<>();

        myDataSet.add(new Lessor("Hector", "341-430-9315", "h.toscano.145@gmail.com"));
        myDataSet.add(new Lessor("Cynthia", "331-015-6716", "cgaribaby@gmail.com"));
        myDataSet.add(new Lessor("Roberto", "686-228-3850", "rcortez@gmail.com"));

        mAdapter = new Adapter_Lessor_Card(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
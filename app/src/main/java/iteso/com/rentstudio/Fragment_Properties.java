package iteso.com.rentstudio;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import iteso.com.rentstudio.beans.Property;


public class Fragment_Properties extends android.support.v4.app.Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Property> myDataSet;

    public Fragment_Properties(){
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

        myDataSet.add(new Property("Manuel M. Dieguez #117", "2,000"));
        myDataSet.add(new Property("Calzada Central #230", "3,000"));
        myDataSet.add(new Property("Bustamante #128", "1,500"));

        mAdapter = new Adapter_Property_Card(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
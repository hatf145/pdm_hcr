package iteso.com.rentstudio;

import android.content.Context;
import android.net.Uri;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Main.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Main extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Rent> myDataSet;

    public Fragment_Main(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.main_recycler_view);

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
}
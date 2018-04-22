package iteso.com.rentstudio;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

import iteso.com.rentstudio.beans.Lessor;

public class Fragment_Lessors extends android.support.v4.app.Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Lessor> myDataSet = new ArrayList<>();
    DatabaseReference databaseReference;
    Lessor cynthia;

    public Fragment_Lessors(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myDataSet.clear();
                for(DataSnapshot snapshot : dataSnapshot.child("lessors").getChildren()){
                    cynthia = snapshot.getValue(Lessor.class);
                    if(!myDataSet.contains(cynthia)) {
                        myDataSet.add(cynthia);
                        mAdapter.notifyDataSetChanged();
                    }
                    System.out.println(cynthia.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        View view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_main_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new Adapter_Lessor_Card(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
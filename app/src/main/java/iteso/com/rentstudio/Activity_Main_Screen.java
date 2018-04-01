package iteso.com.rentstudio;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import iteso.com.rentstudio.beans.Rent;

public class Activity_Main_Screen extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Rent> myDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main__screen);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        myDataSet = new ArrayList<>();

        myDataSet.add(new Rent("Bustamante #128", "Hector Toscano",
                new Date(2017, 5, 14)));
        myDataSet.add(new Rent("Pipíla #1", "Roberto Cortéz",
                new Date(2017, 6, 4)));
        myDataSet.add(new Rent("Manuel M. Dieguez #12", "Cynthia Garibay",
                new Date(2017, 7, 1)));

        mAdapter = new Adapter_Rent_Card(this, myDataSet);
        recyclerView.setAdapter(mAdapter);
    }
}

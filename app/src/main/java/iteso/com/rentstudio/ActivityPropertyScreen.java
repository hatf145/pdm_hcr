package iteso.com.rentstudio;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import iteso.com.rentstudio.beans.Property;

public class ActivityPropertyScreen extends AppCompatActivity {
    public TextView address;
    public TextView cost;
    public TextView availability;
    public TextView name;
    public TextView payday;
    public TextView state;
    public TextView town;
    Property property;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_screen);
        address = findViewById(R.id.property_address);
       cost = findViewById(R.id.property_money);
        availability =findViewById(R.id.property_availability);
        name = findViewById(R.id.property_house);
        payday = findViewById(R.id.property_payday);
        state = findViewById(R.id.property_state);
        town = findViewById(R.id.property_town);
        if(getIntent().getExtras()!=null){
            property = getIntent().getParcelableExtra("ITEM");
            if (property != null) {
                 address.setText(property.getAddress());
                    cost.setText(Integer.toString(property.getCost()));
                 availability.setText(property.getLessor());
                name.setText(property.getName());
                payday.setText(Integer.toString(property.getPayday()));
                state.setText(property.getState());
                  town.setText(property.getTown());

            }}

    }
}

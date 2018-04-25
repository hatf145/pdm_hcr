package iteso.com.rentstudio;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import iteso.com.rentstudio.beans.Lessor;
import iteso.com.rentstudio.beans.Property;

public class Activity_Register_Rent extends AppCompatActivity {
    Spinner lessor, property;
    Calendar calendar;
    TextView date;
    int year, month, day;
    Button btnRent;
    ArrayList<String> lNames, pNames;

    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register_rent);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        date=findViewById(R.id.activity_rent_date);
        btnRent =findViewById(R.id.activity_brent_register);
        lessor=findViewById(R.id.activity_rent_lessor);
        property=findViewById(R.id.activity_rent_property);
        lNames = new ArrayList<>();
        pNames = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lNames.clear();
                pNames.clear();
                for(DataSnapshot snapshot : dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("lessors").getChildren()){
                    Lessor auxLessor = snapshot.getValue(Lessor.class);
                    lNames.add(auxLessor.getName());
                }

                for(DataSnapshot snapshot : dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("properties").getChildren()){
                    Property auxProperty = snapshot.getValue(Property.class);
                    pNames.add(auxProperty.getName());
                }

                ArrayAdapter<String> lessorAdapter = new ArrayAdapter<>(Activity_Register_Rent.this, android.R.layout.simple_spinner_item, lNames);
                lessorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                lessor.setAdapter(lessorAdapter);

                ArrayAdapter<String> propertyAdapter = new ArrayAdapter<>(Activity_Register_Rent.this, android.R.layout.simple_spinner_item, pNames);
                propertyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                property.setAdapter(propertyAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        calendar=Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        date.setText(day + "/" + month + "/" + year);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Activity_Register_Rent.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int iyear, int iday, int imonth) {
                        date.setText(iday+"/"+imonth+"/"+iyear);
                    }
                },year,month, day);
                datePickerDialog.show();
            }
        });

        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auxLessor = lessor.getSelectedItem().toString();
                String auxProperty = property.getSelectedItem().toString();
                createRent(auxLessor, auxProperty, day);
            }
        });
    }

    public void createRent(final String lessor, final String property, final int day){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("properties").getChildren()){
                    Property aux = snapshot.getValue(Property.class);
                    if(aux.getName() == property){
                        System.out.println("GOT HERE");
                        aux.setLessor(lessor);
                        aux.setPayday(day);
                        databaseReference.child(mAuth.getCurrentUser().getUid()).child("properties").child(snapshot.getKey()).setValue(aux);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child(mAuth.getCurrentUser().getUid()).child("properties").orderByChild("name").equalTo("property");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("date", date.getText().toString());
        outState.putString("lessor", lessor.getSelectedItem().toString());
        outState.putString("property", property.getSelectedItem().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getString("date") != null)
            date.setText(savedInstanceState.getString("date"));
        if(savedInstanceState.getString("property").equals(getString(R.string.available)))
            property.setSelection(0);
        else
            property.setSelection(1);
    }
}

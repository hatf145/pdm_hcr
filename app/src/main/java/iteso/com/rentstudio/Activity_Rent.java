package iteso.com.rentstudio;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Activity_Rent extends AppCompatActivity {
    Spinner lessor, property;
    Calendar calendar;
    TextView date;
    int year, month, day;
    Button brent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__rent);

        date=findViewById(R.id.activity_rent_date);
        brent=findViewById(R.id.activity_brent_register);
        lessor=findViewById(R.id.activity_rent_lessor);
        property=findViewById(R.id.activity_rent_property);

        calendar=Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        date.setText(day+"/"+month+"/"+year);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Activity_Rent.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int iyear, int iday, int imonth) {
                        date.setText(iday+"/"+imonth+"/"+iyear);
                    }
                },year,month, day);
                datePickerDialog.show();
            }
        });
    }
    //Sppiners tienen que se dinamicos-->
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

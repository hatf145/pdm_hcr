package iteso.com.rentstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity_Register_Property extends AppCompatActivity {
    Spinner available;
    EditText name, direction, town, state, rent;
    Button bproperty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register__property);
        available=findViewById(R.id.activity_register_property_spinner);
        name=findViewById(R.id.activity_registerProperty_name);
        direction=findViewById(R.id.activity_registerProperty_direction);
        town=findViewById(R.id.activity_registerProperty_town);
        state=findViewById(R.id.activity_registerProperty_state);
        rent=findViewById(R.id.activity_registerProperty_rent);
        available=findViewById(R.id.activity_register_property_spinner);
        bproperty=findViewById(R.id.activity_bregister_property);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("name", name.getText().toString());
        outState.putString("direction", direction.getText().toString());
        outState.putString("town", town.getText().toString());
        outState.putString("state", state.getText().toString());
        outState.putString("rent", rent.getText().toString());
        outState.putString("available", available.getSelectedItem().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getString("name") != null)
            name.setText(savedInstanceState.getString("name"));
        if(savedInstanceState.getString("town") != null)
            town.setText(savedInstanceState.getString("town"));
        if(savedInstanceState.getString("state") != null)
            state.setText(savedInstanceState.getString("state"));
        if(savedInstanceState.getString("rent") != null)
            rent.setText(savedInstanceState.getString("rent"));
        if(savedInstanceState.getString("rent").equals(getString(R.string.available)))
            available.setSelection(0);
        else
            available.setSelection(1);
    }
}

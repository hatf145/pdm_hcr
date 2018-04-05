package iteso.com.rentstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Activity_Edit_User extends AppCompatActivity {
    EditText password, cellphone,email, lastname,name;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__edit__user);
        name=findViewById(R.id.activity_editUser_name);
        password=findViewById(R.id.activity_editUser_password);
        cellphone=findViewById(R.id.activity_editUser_cellphone);
        email=findViewById(R.id.activity_editUser_email);
        lastname=findViewById(R.id.activity_editUser_lastname);
        save=findViewById(R.id.activity_editUser_Button);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("name", name.getText().toString());
        outState.putString("lastname", lastname.getText().toString());
        outState.putString("cellphone", cellphone.getText().toString());
        outState.putString("password", password.getText().toString());
        outState.putString("email", email.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getString("name") != null)
            name.setText(savedInstanceState.getString("name"));
        if(savedInstanceState.getString("lastname") != null)
            lastname.setText(savedInstanceState.getString("lastname"));
        if(savedInstanceState.getString("email") != null)
            email.setText(savedInstanceState.getString("email"));
        if(savedInstanceState.getString("password") != null)
            password.setText(savedInstanceState.getString("password"));
        if(savedInstanceState.getString("cellphone") != null)
            cellphone.setText(savedInstanceState.getString("cellphone"));
    }
}

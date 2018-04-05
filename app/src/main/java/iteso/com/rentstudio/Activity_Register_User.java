package iteso.com.rentstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity_Register_User extends AppCompatActivity {
    EditText etName, etLastname, etEmail, etPhone, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register__user);

        etName = findViewById(R.id.activity_registerUser_name);
        etLastname = findViewById(R.id.activity_registerUser_lastname);
        etEmail = findViewById(R.id.activity_registerUser_email);
        etPhone = findViewById(R.id.activity_registerUser_cellphone);
        etPassword = findViewById(R.id.activity_registerUser_password);

    }
public void registrar(){
    Intent registerIntent = new Intent(Activity_Register_User.this,
            Activity_Settings.class);

    startActivity(registerIntent);
}
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("name", etName.getText().toString());
        outState.putString("lastname", etLastname.getText().toString());
        outState.putString("email", etEmail.getText().toString());
        outState.putString("phone", etPhone.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getString("name") != null)
            etName.setText(savedInstanceState.getString("name"));

        if(savedInstanceState.getString("lastname") != null)
            etLastname.setText(savedInstanceState.getString("lastname"));

        if(savedInstanceState.getString("email") != null)
            etEmail.setText(savedInstanceState.getString("email"));

        if(savedInstanceState.getString("phone") != null)
            etPhone.setText(savedInstanceState.getString("phone"));
    }
}

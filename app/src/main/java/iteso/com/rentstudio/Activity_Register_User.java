package iteso.com.rentstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import iteso.com.rentstudio.beans.User;

public class Activity_Register_User extends AppCompatActivity {
    EditText etName, etLastname, etEmail, etPhone, etPassword;
    String sName, sLastname, sEmail, sPhone, sPassword;
    Boolean type;
    Button btnRegister;
    RadioGroup radioGroup;
    RadioButton radioButtonA, radioButtonB;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register__user);

        etName = findViewById(R.id.activity_registerUser_name);
        etLastname = findViewById(R.id.activity_registerUser_lastname);
        etEmail = findViewById(R.id.activity_registerUser_email);
        etPhone = findViewById(R.id.activity_registerUser_cellphone);
        etPassword = findViewById(R.id.activity_registerUser_password);
        radioGroup = findViewById(R.id.activity_registerUser_radioGroup);
        radioButtonA = findViewById(R.id.radio_lessor);
        radioButtonB = findViewById(R.id.radio_lesse);
        btnRegister = findViewById(R.id.activity_registerUser_register);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = etName.getText().toString();
                sLastname = etLastname.getText().toString();
                sEmail = etEmail.getText().toString();
                sPhone = etPhone.getText().toString();
                sPassword = etPassword.getText().toString();
                type = radioButtonA.isSelected();

                if(sName != null && sLastname != null && sEmail != null && sPhone != null && sPassword != null && type != null){
                    User aux = new User(sEmail, sLastname, sName, sPassword, sPhone, (type ? 1 : 0));
                    String key = databaseReference.push().getKey();
                    databaseReference.child("users").child(key).setValue(aux);
                }

                Intent intent = new Intent(Activity_Register_User.this, Activity_LogIn.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onClick(View v){

        Intent mainIntent = new Intent (Activity_Register_User.this, Activity_Main_Screen.class);
        startActivity(mainIntent);


    }

public void registrar(View v) {
    Intent registerIntent = new Intent(Activity_Register_User.this,
            Activity_Main_Screen.class);
    registerIntent.setFlags(registerIntent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(registerIntent);


}
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("etName", etName.getText().toString());
        outState.putString("lastname", etLastname.getText().toString());
        outState.putString("email", etEmail.getText().toString());
        outState.putString("phone", etPhone.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getString("etName") != null)
            etName.setText(savedInstanceState.getString("etName"));

        if(savedInstanceState.getString("lastname") != null)
            etLastname.setText(savedInstanceState.getString("lastname"));

        if(savedInstanceState.getString("email") != null)
            etEmail.setText(savedInstanceState.getString("email"));

        if(savedInstanceState.getString("phone") != null)
            etPhone.setText(savedInstanceState.getString("phone"));
    }
}

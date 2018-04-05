package iteso.com.rentstudio;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity_LogIn extends AppCompatActivity {
    EditText etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__log_in);

        etUserName = findViewById(R.id.activity_login_username);
        etPassword = findViewById(R.id.activity_login_password);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_login_registerButton:
                Intent registerIntent = new Intent(Activity_LogIn.this,
                    Activity_Register_User.class);
                startActivity(registerIntent);
                break;
            case R.id.activity_login_loginButton:
                Intent loginIntent = new Intent(Activity_LogIn.this,
                        Activity_Main_Screen.class);
                loginIntent.setFlags(loginIntent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(loginIntent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("username", etUserName.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.getString("username") != null)
            etUserName.setText(savedInstanceState.getString("username"));

    }
}

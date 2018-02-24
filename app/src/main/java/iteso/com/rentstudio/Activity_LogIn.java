package iteso.com.rentstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__log_in);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_login_registerButton:
                Intent registerIntent = new Intent(Activity_LogIn.this,
                    Activity_Register_User.class);
                startActivity(registerIntent);
        }
    }
}

package iteso.com.rentstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Settings extends AppCompatActivity {
TextView notifications,payment, help, use, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__settings);
        notifications=findViewById(R.id.activity_settings_not);
        payment=findViewById(R.id.activity_settings_payment);
        help=findViewById(R.id.activity_settings_help);
        use=findViewById(R.id.activity_settings_use);
        logout=findViewById(R.id.activity_settings_logout);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.activity_settings_not:
                Intent notIntent = new Intent(Activity_Settings.this,
                        Activity_Notifications.class);
                startActivity(notIntent);
                break;
            case R.id.activity_settings_help:
                Intent helpIntent = new Intent(Activity_Settings.this,
                        Activity_help.class);
                startActivity(helpIntent);
                break;
            case R.id.activity_settings_payment:
                Intent paymentIntent = new Intent(Activity_Settings.this,
                        Activity_Payment_Method.class);
                startActivity(paymentIntent);
                break;
            case R.id.activity_settings_use:
                Intent useIntent = new Intent(Activity_Settings.this,
                        Activity_Payment_Method.class);
                startActivity(useIntent);
                break;
            case R.id.activity_settings_logout:
                finish();
                break;
        }
    }
}

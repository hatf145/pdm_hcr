package iteso.com.rentstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;




import java.util.Timer;
import java.util.TimerTask;

public class Activity_Start extends AppCompatActivity {
ImageView icon;
TextView rent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        icon=findViewById(R.id.activity_start_logo);
        rent=findViewById(R.id.activity_start_title);
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                intent=new Intent(Activity_Start.this,
                            Activity_LogIn.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,2000);

    }
}



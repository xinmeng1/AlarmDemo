package com.iclockin.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnSetAlarm;
    Button btnCancelAlarm;
    TextView tvInfo;

    AlarmManager am;
    PendingIntent pi;
    BroadcastReceiver networkBroadcastReceiver =  new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            tvInfo.setText(intent.getStringExtra("action"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetAlarm = (Button)findViewById(R.id.btn_set_alarm);
        btnCancelAlarm = (Button) findViewById(R.id.btn_cancel_alarm);
        tvInfo = (TextView) findViewById(R.id.tv_alarm_end);


        this.registerReceiver(networkBroadcastReceiver, new IntentFilter("NetworkBroadcast"));

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.setText("--");
                am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                Intent intentAlarm = new Intent(getApplicationContext(), AlarmBroadcast.class);
                pi = PendingIntent.
                        getBroadcast(getApplicationContext(), 0, intentAlarm, 0);
                long triggerAtTime = System.currentTimeMillis() + 1000 * 10;
                am.set(AlarmManager.RTC_WAKEUP, triggerAtTime, pi);
            }
        });

        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean alarmUp = (PendingIntent.getBroadcast(getApplicationContext(), 0,
                        new Intent(getApplicationContext(), AlarmBroadcast.class),
                        PendingIntent.FLAG_NO_CREATE) != null);
                if (alarmUp) {
                    Log.i("TAG", "true");

                }else{
                    Log.i("TAG", "false");
                }
                AlarmManager am2 = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                Intent intentAlarm = new Intent(getApplicationContext(), AlarmBroadcast.class);
                PendingIntent pi2 = PendingIntent.
                        getBroadcast(getApplicationContext(), 0, intentAlarm, 0);
                am2.cancel(pi2);
            }
        });
    }
}

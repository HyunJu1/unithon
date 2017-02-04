package com.hardcopy.btchat;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hardcopy.btchat.naver.NaverActivity;

import java.util.Calendar;
public class Main0Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

       Button b = (Button) findViewById(R.id.nextBtn);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Main0Activity.this, MainActivity.class);
                Main0Activity.this.startActivity(intent);
            }
        });
        //--------------------------------------------------------------------
        Button bb =(Button) findViewById(R.id.button);
        bb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Main0Activity.this, Main2Activity.class);
                Main0Activity.this.startActivity(intent);
            }
        });
//----------------------------------------------------------------------------------




        //--------------------------------------------------------------------------
        Button button = (Button)findViewById(R.id.alarmBtn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationManager notificationManager= (NotificationManager)Main0Activity.this.getSystemService(Main0Activity.this.NOTIFICATION_SERVICE);
                Intent intent1 = new Intent(Main0Activity.this.getApplicationContext(),Main0Activity.class); //인텐트 생성.



                Notification.Builder builder = new Notification.Builder(getApplicationContext());
                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingNotificationIntent = PendingIntent.getActivity( Main0Activity.this,0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setSmallIcon(R.drawable.app_logo)
                        .setTicker("HETT")
                        .setWhen(System.currentTimeMillis())
                        .setContentTitle("문을 두드립니다")
                        .setContentText("들어가도될까요?")
                        .setVibrate(new long[]{1000,1000,1000,1000})
                        .setLights(Color.RED, 3000, 3000);
                       //  .setContentIntent(pendingNotificationIntent)
                       // .setUsesChronometer(true)
                       // .setOngoing(true);

//setSmallIcon - > 작은 아이콘 이미지
//setTicker - > 알람이 출력될 때 상단에 나오는 문구.
//setWhen -> 알림 출력 시간.
//setContentTitle-> 알림 제목
//setConentText->푸쉬내용
                notificationManager.notify(1, builder.build());
            }
        });
    }}
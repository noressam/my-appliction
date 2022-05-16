package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class Tips extends AppCompatActivity {

    Switch switch1;
    Boolean switchState;
    static int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
         switch1 = (Switch) findViewById(R.id.sw);

       // createNotificationChannel();
         switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked){
                     Toast.makeText(Tips.this, "تم تفعيل الاشعارات", Toast.LENGTH_SHORT).show();
                     startScheduling(Tips.this,5,40);
                    // startService( new Intent( Tips.this, NotificationService. class )) ;
                     /*
                     Intent intent=new Intent(Tips.this,ReminderBroadcast.class);
                     PendingIntent pendingIntent=PendingIntent.getBroadcast(Tips.this,0,intent,0);

                     AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

                     long time =System.currentTimeMillis();
                     long twentyTwoHOURS=1000*10;
                     alarmManager.set(AlarmManager.RTC_WAKEUP,
                             time+twentyTwoHOURS,pendingIntent);

                      */
                 }
                 else{
                     Intent intent=new Intent(getApplicationContext(),projectDetails.class);
                     startActivity(intent);
                 }
             }
         });
    }
   // @Override


       /* Intent intent=new Intent(getApplicationContext(),projectDetails.class);
        new AlertDialog.Builder(this)
                .setTitle("أضف الي معلوماتك.")
                .setMessage("هل تود تفعيل استقبال اشعارات بنصائح يومية!")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Tips.this, "تم تفعيل استقبال الاشعارات بنجاح", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                })
                .setNegativeButton("لأ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                    }
                })
                .setIcon(R.drawable.mail)
                .show();

        */
       public static void startScheduling(Context context , int hour , int min) {

           Calendar c = Calendar.getInstance();
           c.set(Calendar.HOUR_OF_DAY,hour);
           c.set(Calendar.MINUTE,min);
           c.set(Calendar.SECOND,0);

           AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

           Intent intent = new Intent(context, ReminderBroadcast.class);
           PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);

        /*

        // Launch pending intent after
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
        }
        */
           alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP
                   ,c.getTimeInMillis()
                   ,AlarmManager.INTERVAL_DAY
                   ,pendingIntent);

       }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            CharSequence name="TipsChannel";
            String description="Channel for Tips Reminder";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("TIPSFORYOU",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }




}
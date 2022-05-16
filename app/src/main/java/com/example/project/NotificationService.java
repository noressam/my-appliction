package com.example.project;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.security.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;
    Timer timer ;
    TimerTask timerTask ;
    String TAG = "Timers" ;
    int Your_X_SECS = 10*60 ;
    String[] arr =new String[]{"يجب التركيز على النشويات الجيدة والحبوب الكاملة وتجنب السكريات.","ينصح بتناول المكسرات النيئة والبيض يومياً.","ينصح بالحد من تناول الأطعمة المملّحة والمدخنة لأنها تزيد احتمالات الإصابة بسرطان المعدة عند الإفراط في تناولها.","يجب تناول 240 غ من السمك في الأسبوع أي ما يعادل مرتين أو ثلاثاً. كما يعتبر الدجاج مصدراً جيداً للبروتينات وينصح بتناوله مرتين في الأسبوع.","يمكن تناول اللحوم الحمراء استثنائياً فحتى تلك التي يقال إنها خالية من الدهون تحتوي على نسبة أعلى من الدهون من السمك الغني بالدهون.","يجب الحصول على 8 أو 10 حصص من الفاكهة والخضر في اليوم شرط أن تكون متنوعة للحصول على نسبة عالية من مضادات الأكسدة التي تحمي من السرطان. يتم تناول 3 حصص منها من الفاكهة والبقية من الخضر.","هل تعلم ان الإجهاد البدني والذهني من العوامل المؤثرة علي المناعة لأن الدراسات أثبتت أن الأشخاص المعرضون للإجهاد المستمر أكثر عرضة من غيرهم في الإصابة بالأمراض.","هل تعلم ان تناول السكر بكميات كبيرة من العوامل المؤثرة علي المناعة لأن السكر بيقوم بامتصاص الفيتامينات اللي بتحتاجها المناعة وده طبعا يضعفها أمام الفيروسات والميكروبات المختلفة.","هل تعلم ان التدخين من العوامل المؤثرة علي المناعة لأن امراض التدخين لا تتوقف فقط عند أمراض الرئة المزمنة بل كمان التدخين بيدمر المناعة وهذا لأنه بيضعف قدرة الجهاز المناعي على مواجهة الأمراض وكمان بيعكس استجابة المناعة وبدل مهاجمة الفيروسات بتقوم بمهاجمة خلايا الجسم الصحية .","هل تعلم ان السمنة من العوامل المؤثرة علي المناعة لأن السمنة بتمنع الشخص من الدخول في مرحلة النوم العميق وكمان الخلايا الدهنية بتمنع الخلايا المناعية من أنها تقوم بوظائفها على أكمل وجه عشان كده الأشخاص الرياضيين أكثر قدرة على مواجهة الأمراض من الأشخاص ذوي الوزن الزائد .","هل تعلم ان قلة النوم من العوامل المؤثرة علي المناعة لأن النوم يلعب دور كبير في قوة المناعة ده لأن خلال فترة النوم بيقوم جهاز المناعة بعملية البناء للخلايا وبالتالي قلة النوم بتسبب اضطراب في عدد خلايا الدم البيضاء اللي بتواجه الأمراض .","هل تعلم ان تناول الادوية بكثره من العوامل المؤثرة علي المناعة لأن كتير مننا بياخدوا المضادات الحيوية دون أي استشارة من طبيب وكمان بدون الالتزام بجرعات محددة وهذا للأسف بيسبب مقاومة أقل من الجسم للبكتيريا وبتزداد فرص الإصابة بالأمراض.","المناعة بتحتاج للتغذية السليمة ولما نقول سليمة ده معناه اننا محتاجين الفيتامينات والمعادن اللازمة لتقوية صحتنا ومنها فيتامين أ و ج و د وب2 وب6 والزنك وغيرهم والفيتامينات دي وجد العلماء أنها بتقوم بتعزيز الأسطح المخاطية الدفاعية والجلد كمان بتزيد من الخلايا المقاومة للعدوى والخلايا البلعمية وتقدر توفر احتياجات الجسم من الفيتامينات دي من خلال تناول اللحوم بأنواعها والألبان والخضروات الورقية والحمضيات والبقوليات والمكسرات والبيض" +
            "وعلى الجانب الآخر فنقص الفيتامينات والمعادن وعدم التغذية السليمة بيسب كتير من الأمراض الخطيرة زي فقر الدم والتهاب الجهاز الهضمي والجهاز التنفسي وجفاف الجلد والقرنية وتساقط الشعر.","تعتبر ممارسة الرياضة من الوسائل القوية لحماية جسم الإنسان من التعرض للأمراض ومهاجمة الفيروسات وبالتالي فهي تعتبر وسيلة رئيسية للحفاظ على المناعة وتقويتها  وعشان نوفر ده مش بنحتاج ممارسة الرياضة بشكل قوي بل بالعكس مجموعة من ابسط التمارين كافية أنها تقوينا جسدياً وصحيا."};
    Random random=new Random();
    int num;
    int length=arr.length;
    List <Integer>numbers=new ArrayList<Integer>(length);
    int x=0;

    @Override
    public int onStartCommand (Intent intent , int flags , int startId) {
        Log. e ( TAG , "onStartCommand" ) ;
        super .onStartCommand(intent , flags , startId) ;
        startTimer() ;
        return START_STICKY ;
    }
    @Override
    public void onCreate () {
        Log. e ( TAG , "onCreate" ) ;
    }
    @Override
    public void onDestroy () {
        Log. e ( TAG , "onDestroy" ) ;
        stopTimerTask() ;
        super .onDestroy() ;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //we are going to use a handler to be able to run in our TimerTask
    final Handler handler = new Handler() ;
    public void startTimer () {
        timer = new Timer() ;
        initializeTimerTask() ;
        timer .schedule( timerTask , 60000 , Your_X_SECS * 1000 ) ;
    }
    public void stopTimerTask () {
        if ( timer != null ) {
            timer .cancel() ;
            timer = null;
        }
    }
    public void initializeTimerTask () {
        timerTask = new TimerTask() {
            public void run () {
                handler .post( new Runnable() {
                    public void run () {
                        createNotification() ;
                    }
                }) ;
            }
        } ;
    }
    private void createNotification () {
        for(int i=0;i< length;i++)
            numbers.add(i);
        //Collections.shuffle(numbers);
        if(x<length) {
            num = numbers.get(x);
            x++;
        }
        else
            x=0;
        NotificationManager mNotificationManager = (NotificationManager)getSystemService( NOTIFICATION_SERVICE ) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , default_notification_channel_id ) ;
        mBuilder.setContentTitle( "نصيحة لك" ) ;
        //mBuilder.setContentText( arr[num] ) ;
        mBuilder.setTicker( "Notification Listener Service Example" ) ;
        mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(arr[num]));
        mBuilder.setSmallIcon(R.drawable.mail) ;
        mBuilder.setAutoCancel( true ) ;
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel) ;
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build()) ;
    }
}

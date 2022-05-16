package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class ContactUs_Activity extends AppCompatActivity {

    TextView fb;
    TextView insta;
    TextView gmaill;
    TextView phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        fb=findViewById(R.id.fb);
        insta=findViewById(R.id.insta);
        gmaill=findViewById(R.id.gmail);
        phone=findViewById(R.id.phone);
        fb.setClickable(true);
        insta.setClickable(true);
        gmaill.setClickable(true);
        phone.setClickable(true);
        fb.setMovementMethod(LinkMovementMethod.getInstance());
        insta.setMovementMethod(LinkMovementMethod.getInstance());
        gmaill.setMovementMethod(LinkMovementMethod.getInstance());
        String facebook="<a href='https://www.facebook.com/khatdifae22'>khatdifae22</a>";
        String instagram="<a href='https://www.instagram.com/khat_difae22/?igshid=YmMyMTA2M2Y=&fbclid=IwAR14O_cUz94y5skhabw2xwQ6fBSb_Yx3RC53qFl-sKYBzHcsSD8qN1G8KhU'>khatdifae22</a>";
        //String gmail="<a href='https://accounts.google.com/ServiceLogin?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService&followup=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService'>defenselinmasscomm@gmail.com</a>";
        fb.setText(Html.fromHtml(facebook));
        insta.setText(Html.fromHtml(instagram));
        gmaill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String []recp={"defenselinmasscomm@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,recp);
               // intent.putExtra(Intent.EXTRA_SUBJECT,"Subject Text here..");
                //intent.putExtra(Intent.EXTRA_TEXT,"Body of the content here..");
              //  intent.putExtra(Intent.EXTRA_CC,"Put your mail here..");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent,"Send mail"));
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01013930582"));
                startActivity(intent);
            }
        });
    }
}
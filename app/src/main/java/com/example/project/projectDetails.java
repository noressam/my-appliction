package com.example.project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class projectDetails extends AppCompatActivity {

    Button menuView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectdetails);
        Menu menu;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.silver)));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        LayoutInflater inflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.custom_image,null);
        getSupportActionBar().setCustomView(v);
        //menuView=findViewById(R.id.menu);
        //ListView lst=new ListView(this);
        //List<String> data=new ArrayList<>();
        //data.add("نصائح");
        //data.add("الفاعليات");
        //data.add("تواصل معنا");
       // data.add("الداعمون");
       // ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
      //  lst.setAdapter(adapter);



        /*

        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(projectDetails.this);
                builder.setView(lst);
                final AlertDialog dialog=builder.create();
           // if(menuView.getParent()!=null){
           //     ((ViewGroup)menuView.getParent()).removeView(menuView);
              //  menuView=findViewById(R.id.menu);
               // ((ViewGroup)menuView.getParent()).addView(menuView);
              //  }
                dialog.show();

            }
        });

         */
    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       // Intent intent;
        switch (item.getItemId()){
            case R.id.tips:
                Intent intent3=new Intent(projectDetails.this,Tips.class);
                startActivity(intent3);
                break;
            case R.id.t2:
                Intent intent=new Intent(projectDetails.this,InformationActivity.class);
                startActivity(intent);
                break;
            case R.id.t3:
                Intent intent2=new Intent(projectDetails.this,Sponser.class);
                startActivity(intent2);
                break;
            case R.id.t4:
                 Intent intent1=new Intent(projectDetails.this,ContactUs_Activity.class);
                 startActivity(intent1);
                break;
            default:

                Toast.makeText(this, "إختر", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
}
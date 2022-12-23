package com.ymca.helpinghands;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Splash extends Activity {
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.splash);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (    InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i=new Intent(Splash.this,HomeActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}

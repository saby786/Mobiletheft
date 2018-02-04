package com.example.mobiletheftsecurity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash extends Activity {
	SharedPreferences sp;
	SharedPreferences.Editor ed;
	
	private boolean mIsBackButtonPressed;
	String check_data="";
    private static final int SPLASH_DURATION = 5000; // 5 seconds
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.splash);
	    sp=getSharedPreferences("my_logindeatils", MODE_PRIVATE);
	    check_data=sp.getString("password","@@@@");
	    Handler handler = new Handler();
		 
        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {
 
            @Override
            public void run() {
 
                // make sure we close the splash screen so the user won't come back when it presses back key
 
                finish();
                 
                if (!mIsBackButtonPressed) {
                    // start the menu screen if the back button wasn't pressed already 
                    
						if(check_data.equals("@@@@"))
						{
						Intent intent = new Intent(Splash.this,CreateAccount.class);
						startActivity(intent);
						}
						else
						{
							Intent intent = new Intent(Splash.this,Login.class);
						    startActivity(intent);
						}
                }
                 
            }
 
        }, SPLASH_DURATION); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called
 
    }
 
    @Override
   public void onBackPressed() {
 
        // set the flag to true so the next activity won't start up
        mIsBackButtonPressed = true;
        super.onBackPressed();
 
    }
}

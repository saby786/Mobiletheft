
package com.example.mobiletheftsecurity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity {
	Button b1,b2,b3,b4;
    Button saby;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_options);
	    b1=(Button) findViewById(R.id.myaccount);
	    b2=(Button) findViewById(R.id.active);
	    b3=(Button) findViewById(R.id.configure);
	    b4=(Button) findViewById(R.id.changepassword);
	    b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in=new Intent(Home.this,MyAccount.class);
				startActivity(in);
				
			}
		});
	    
      b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent();
				in.setAction("prabha");
				sendBroadcast(in);
				
			}
		});
 
       b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in=new Intent(Home.this,Settings.class);
			startActivity(in);
			
		}
	});
 
       b4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in=new Intent(Home.this,ChangePassword.class);
			startActivity(in);
			
		}
	});

	}

}

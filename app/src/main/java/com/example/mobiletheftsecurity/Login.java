package com.example.mobiletheftsecurity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	SharedPreferences sp;
	Button b;
	EditText et1;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login);
	    b=(Button) findViewById(R.id.button1);
	    et1=(EditText) findViewById(R.id.editText1);
	    sp=getSharedPreferences("my_logindeatils", MODE_PRIVATE);
	    b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String password=et1.getText().toString();
				if(password.equals(sp.getString("password", null)))
				{
				Intent in=new Intent(Login.this,Home.class);
				startActivity(in);
				Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();

				}
				else
				{
					Toast.makeText(getApplicationContext(), "Password Incorrect",Toast.LENGTH_SHORT).show();
				}
			}
		});
	
	}

}

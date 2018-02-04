package com.example.mobiletheftsecurity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccount extends Activity {
	SharedPreferences sp;
	SharedPreferences.Editor ed;
	Button b;
	EditText et1,et2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    b=(Button) findViewById(R.id.save_password);
	    et1=(EditText) findViewById(R.id.new_password);
	    et2=(EditText) findViewById(R.id.conform_password);
	    sp=getSharedPreferences("my_logindeatils", MODE_PRIVATE);
	    ed=sp.edit();
	    b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ed.putString("password",et1.getText().toString());
				ed.commit();
				Intent in=new Intent(CreateAccount.this,Login.class);
				startActivity(in);
			}
		});
	}

}

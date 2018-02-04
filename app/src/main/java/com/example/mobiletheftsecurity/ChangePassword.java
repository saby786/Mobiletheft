package com.example.mobiletheftsecurity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends Activity {
	EditText et1,et2,et3;
	SharedPreferences sp;
	SharedPreferences.Editor ed;
	String p_old,p_new,p_confirm;
	Button b;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_resetpassword);
	    et1=(EditText) findViewById(R.id.old_password);
	    et2=(EditText) findViewById(R.id.new_password);
	    et3=(EditText) findViewById(R.id.conform_password);
        b=(Button) findViewById(R.id.change_password);
        sp=getSharedPreferences("my_logindeatils", MODE_PRIVATE);
	    ed=sp.edit();
	 b.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		p_old=et1.getText().toString();
	    p_new=et2.getText().toString();
	    p_confirm=et3.getText().toString();
		if(p_old.equals("")||(p_new.equals("")||p_confirm.equals("")))
		{
		  Toast.makeText(ChangePassword.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
		}
		else
		{
			
		    ed.putString("password",p_new);
			ed.commit();	
		}
	    

		
	}
  });
	    
	}

}

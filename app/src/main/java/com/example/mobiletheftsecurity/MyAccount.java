package com.example.mobiletheftsecurity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MyAccount extends Activity {
	TextView tv1,tv2,tv3,tv4;
	TelephonyManager tm;
	SharedPreferences sp;
	SharedPreferences.Editor ed;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.myaccount);
	    sp=getSharedPreferences("simDetails",MODE_PRIVATE);
	    ed=sp.edit();
	    tv1=(TextView) findViewById(R.id.textView1);
	    tv2=(TextView) findViewById(R.id.textView2);
	    tv3=(TextView) findViewById(R.id.textView3);
	    tv4=(TextView) findViewById(R.id.textView4);
	    tm=(TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
	    tv1.setText("Sim Serial No: "+tm.getSimSerialNumber());
	    tv2.setText("Network: "+tm.getNetworkOperatorName());
	    tv3.setText("Country Code: "+tm.getNetworkCountryIso());
	    tv4.setText("IMEI No: "+tm.getDeviceId());
	    ed.putString("simno",tm.getSimSerialNumber());
        ed.putString("network",tm.getNetworkOperatorName());
        ed.commit();

	
	}

}

package com.icode.viewandviewgroups;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.view.View.*;
import android.text.*;
import android.text.method.*;

public class MainActivity extends Activity 
{
	EditText edt_email;
	EditText edt_pass;
	Button btn_login;
	Button btn_exit;
	Switch switch1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		edt_email =(EditText)findViewById(R.id.edt_email);
		edt_pass =(EditText)findViewById(R.id.edt_pass);
		btn_login = (Button)findViewById(R.id.btn_login);
		btn_exit = (Button)findViewById(R.id.btn_exit);
		switch1 = (Switch)findViewById(R.id.switch1);
		
		switch1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if(switch1.isChecked()) {
						edt_pass.setTransformationMethod(null);
						//edt_pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
					} else {
						edt_pass.setTransformationMethod(new PasswordTransformationMethod());
						//edt_pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
					}
				}
			});

		btn_login.setOnClickListener(new View.OnClickListener() {

			private Intent intent;
			@Override
			public void onClick(View view) {
				if(edt_email.getText().toString().equals("") || edt_email.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "Email and password required", Toast.LENGTH_SHORT).show();
				} else {
					if(edt_email.getText().toString().equals("olalekanbello534@gmail.com") && edt_pass.getText().toString().equals("Jesus2005")) {
						Toast.makeText(getApplication(), "Logged in successfully", Toast.LENGTH_SHORT).show();
						Intent intent = new  Intent(MainActivity.this, chat.class);
						startActivity(intent);
					} else {
						Toast.makeText(getApplicationContext(), "invalid email or password", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
		
		btn_exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finishAffinity();
			}
		});
    }
}

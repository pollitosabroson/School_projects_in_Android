package com.opt.sam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Info extends Activity implements OnItemClickListener{
	public ListView lv_info;
	public String [] info; 
	

	
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		
		Bundle bundle = getIntent().getExtras().getBundle("bundle");
		
		info = new String [] {
				bundle.getString("usuario"),
				bundle.getString("contrasena"),
				bundle.getString("correo"),
				bundle.getString("tipo"),
				bundle.getString("sexo"),
				bundle.getString("privacidad"),
		};
		
		ArrayAdapter<String> adaptador = new
				ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,info);
		
		lv_info = (ListView) findViewById(R.id.lv_info);
		lv_info.setAdapter(adaptador);
		
		
	}



	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, info[arg2], Toast.LENGTH_SHORT).show();
		
	}
}

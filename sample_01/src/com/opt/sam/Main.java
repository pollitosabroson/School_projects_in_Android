package com.opt.sam;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	public EditText etNombre;
	public Button btSaludo;
	public TextView tvMensaje;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        etNombre= (EditText) findViewById(R.id.et_Nombre);
        btSaludo = (Button) findViewById(R.id.btSaludo);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
        
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btSaludo:
			Toast.makeText(this, 
				"Ya te dije hola " + etNombre.getText() + "!!!", Toast.LENGTH_SHORT).show();
			tvMensaje.setText(getString(R.string.hello) + " " + etNombre.getText());
			break;
		}
		
		
	}
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
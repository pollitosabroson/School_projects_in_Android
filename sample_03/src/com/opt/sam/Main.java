package com.opt.sam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Main extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	public EditText et_user;
	public EditText et_pass;
	public EditText et_email;
	
	public RadioGroup rg_sexo;
	public Spinner sp_tipo;
	public CheckBox ch_privacy;
	public RadioButton rbs1;
	public RadioButton rbs2;
	public Button boton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_email = (EditText) findViewById(R.id.et_email);
        rg_sexo = (RadioGroup) findViewById(R.id.rg_sexo);
        rbs1 = (RadioButton) findViewById(R.id.rbs1);
        rbs2 = (RadioButton) findViewById(R.id.rbs2);
        sp_tipo = (Spinner) findViewById(R.id.sp_tipo);
        String [] tipo_usuario = {"Gratuito", "Licencia", "Administrador", "Staff", "Invitado"};
        ArrayAdapter<String> adaptador = new 
        		ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipo_usuario);  
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tipo.setAdapter(adaptador);
        
        ch_privacy = (CheckBox) findViewById(R.id.ch_privacy);
        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(this);
        
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.boton:
			String sexo = "";
			Bundle bundle = new Bundle(); 
			bundle.putString("usuario", et_user.getText().toString());
			bundle.putString("contrasena", et_pass.getText().toString());
			bundle.putString("correo", et_email.getText().toString());
			if (rbs1.isChecked()) {
				sexo = "Femenino";
			}else if (rbs2.isChecked()){ 
				sexo = "Masculino";
			}
			bundle.putString("sexo", sexo);
			bundle.putString("tipo", sp_tipo.getSelectedItem().toString());
			bundle.putString("privacidad", ch_privacy.isChecked() + "");
			
			Intent intent = new Intent("com.opt.sam.Info");
			intent.putExtra("bundle", bundle);
			
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
}
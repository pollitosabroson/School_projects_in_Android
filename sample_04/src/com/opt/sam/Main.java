package com.opt.sam;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	public TextView etiqueta;
	public Button boton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etiqueta = (TextView) findViewById(R.id.etiqueta);
        setContentView(R.layout.main);
        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(this);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflador = getMenuInflater();
		inflador.inflate(R.menu.princiapal, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.opcion1:
			Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.opcion2:
			Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;

		case R.id.sub1:
			Toast.makeText(this,"sub" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.sub2:
			Toast.makeText(this,"sub" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;			
			
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {		
		// TODO Auto-generated method stub
		MenuInflater inflador = getMenuInflater();
		inflador.inflate(R.menu.contextual, menu);		
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.context1:
			Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			
			break;
			
		case R.id.context2:
			Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			
			break;			

		default:
			break;
		}
		return super.onContextItemSelected(item);
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		Dialog d = null;
		switch (v.getId()) {
		case R.id.boton:
			d = onCreateDialog(1);
			break;

		default:
			break;
		}
		d.show();
		
	}	
	
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		Dialog d = null;
		switch (id) {
		case 1:
			d = crearAlerta();
			break;

		default:
			break;
		}
		return d;
	}

	private Dialog crearAlerta() {
		// TODO Auto-generated method stub
		AlertDialog.Builder construye = new AlertDialog.Builder(this);
		construye.setTitle("Cuadro de dialogo");
		construye.setMessage("Mi mensaje");
		construye.setNegativeButton("Ok!", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		return construye.create();
	}
}
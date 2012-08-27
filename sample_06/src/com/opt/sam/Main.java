package com.opt.sam;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class Main<elementos> extends ListActivity {
	private ArrayList<CustomItem> elementos = null;
	private IconListViewAdapter adaptador;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        elementos = new ArrayList<CustomItem>();
        this.adaptador = new IconListViewAdapter(this, R.layout.customitem, elementos);
        setListAdapter(adaptador);
        initListView();
    }
    
    private void initListView() {
		// TODO Auto-generated method stub
		
		try {
			elementos = new ArrayList<CustomItem>();
			Resources res = getResources();
			
			CustomItem cu1 = new CustomItem(res.getDrawable(android.R.drawable.ic_dialog_email), "Primer titulo", "Primer subtitulo" );
			CustomItem cu2 = new CustomItem(res.getDrawable(android.R.drawable.ic_delete), "Segundo titulo", "Segundo subtitulo" );
			CustomItem cu3 = new CustomItem(res.getDrawable(android.R.drawable.ic_lock_power_off), "Tercer titulo", "Tercer subtitulo" );
			
			elementos.add(cu1);
			elementos.add(cu2);
			elementos.add(cu3);
		} catch (Exception e) {
			Log.e("BACKGROUND_PROC", e.getMessage());
		}
		
		if(elementos != null && elementos.size() > 0){
			for(int i = 0; i < elementos.size(); i++){
				adaptador.add(elementos.get(i));
			}
		}
		adaptador.notifyDataSetChanged();		
	}
	
	public class IconListViewAdapter extends ArrayAdapter<CustomItem>{
		
		private ArrayList<CustomItem> elementos;
		
		public IconListViewAdapter(Context context, int textViewResourceId,
				ArrayList<CustomItem> items) {
			super(context, textViewResourceId, items);
			// TODO Auto-generated constructor stub
			this.elementos = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View v = convertView;
			
			if(v == null){
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.customitem, null);
			}
		try {
			CustomItem e = this.elementos.get(position);
			
			if(e != null){
				TextView tit = (TextView) v.findViewById(R.id.ci_titulo);
				TextView sub = (TextView) v.findViewById(R.id.ci_subtitulo);
				ImageView img = (ImageView) v.findViewById(R.id.ci_icono);
				
				if(img != null){
					img.setImageDrawable(e.getIcono());
				}
				if(tit != null){
					tit.setText(e.getTitulo());
				}				
				if(tit != null){
					sub.setText(e.getSubtitulo());
				}				
			}
		}catch (Exception e){
			Log.e("Exception", e.getMessage());
		}
		
		return v;
		
	}
	}

	
}
    
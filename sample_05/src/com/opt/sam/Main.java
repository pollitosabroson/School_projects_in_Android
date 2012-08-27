package com.opt.sam;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Main extends Activity {
    /** Called when the activity is first created. */
	public TabHost tabhost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources();
        
        tabhost = (TabHost) findViewById(android.R.id.tabhost);
        tabhost.setup();
        
        TabHost.TabSpec spec = tabhost.newTabSpec("tab01");
        spec.setContent(R.id.tab1).setIndicator("Preferencias", 
        		res.getDrawable(android.R.drawable.ic_menu_preferences));
        
        tabhost.addTab(spec);
        
        spec = tabhost.newTabSpec("tab02");
        spec.setContent(R.id.tab2).setIndicator("Email", 
        		res.getDrawable(android.R.drawable.ic_dialog_email));
        
        tabhost.addTab(spec);
        
        spec = tabhost.newTabSpec("tab03");
        spec.setContent(R.id.tab3).setIndicator("Apagar", 
        		res.getDrawable(android.R.drawable.ic_lock_power_off));
        
        tabhost.addTab(spec);
        
        tabhost.setCurrentTab(0);
        
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				
			}        	
        });
    }
}
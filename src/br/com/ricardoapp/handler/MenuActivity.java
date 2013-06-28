package br.com.ricardoapp.handler;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] mStrings = new String[]{
			"Hello Handler",
			"Soma Thread",
			"Soma com Handler",
			"Soma com RunOnUiThread"
		};
		
		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		switch (position) {
		case 0:
			startActivity(new Intent(this, ExemploHandler.class));
			break;
		case 1:
			startActivity(new Intent(this, SomaThread.class));
			break;
		case 2:
			startActivity(new Intent(this, SomaComHandler.class));
			break;
		case 3:
			startActivity(new Intent(this, SomaComRunOnUiThread.class));
		default:
			finish();
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}

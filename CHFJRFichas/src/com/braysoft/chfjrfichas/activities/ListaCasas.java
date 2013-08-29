package com.braysoft.chfjrfichas.activities;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Casa;

public class ListaCasas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_casas);
		
		try
		{
			ListView lstCasas = (ListView)findViewById(R.id.lstCasas);
			List<Casa> casas = Casa.getAll();
			
			AdaptadorCasas adaptador =  new AdaptadorCasas(this,casas);
			lstCasas.setAdapter(adaptador);
			lstCasas.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					
					Casa casa = ((AdaptadorCasas)parent.getAdapter()).getItem(position);
					
					abrirEditCasa(casa);
					
				}
			});
			
			lstCasas.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
				
				@Override
				public void onCreateContextMenu(ContextMenu menu, View v,
						ContextMenuInfo menuInfo) {
					getMenuInflater().inflate(R.menu.lista_casas_popup_menu, menu);
				}
				
			});
		
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_casas_menu, menu);
		return true;
	}
	
	public void newHouse_onClick(MenuItem item)
	{
		abrirEditCasa(null);
	}
	
	public void del_onClick(MenuItem item)
	{
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		AdaptadorCasas adapter = (AdaptadorCasas)((ListView)this.findViewById(R.id.lstCasas)).getAdapter();
		Casa casa = adapter.getItem(info.position);
		
		casa.eliminar();
		adapter.remove(casa);

	}

	private void abrirEditCasa(Casa casa) 
	{
		Intent intent = new Intent(this, EditCasa.class);
		Bundle b = new Bundle();
		
		b.putSerializable("CASA", casa);
		intent.putExtras(b);
		
        startActivity(intent);	
	}

	
}



class AdaptadorCasas extends ArrayAdapter<Casa> 
{
	Activity _context;
	List<Casa> _datos;
	
	AdaptadorCasas(Activity context,List<Casa> datos) 
	{
		super(context, R.layout.lista_casas_layout, datos);
		this._context = context;
		this._datos = datos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View item = convertView;
		if (item == null) 
		{
			LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			item = inflater.inflate(R.layout.lista_casas_layout, null);
		}

		TextView lblNombreCasa = (TextView)item.findViewById(R.id.lblNombreCasa);
		lblNombreCasa.setText(_datos.get(position).getNombre());
		/*ImageView imgEscudo = (ImageView)item.findViewById(R.id.imgEscudoCasa);
		
		if (_datos[position].existeEscudo())
			lblEscudo.setBackground(_datos[position].getEscudo());
		else lblEscudo.setBackgroundResource(R.drawable.ic_launcher);*/

		return(item);
	}
}

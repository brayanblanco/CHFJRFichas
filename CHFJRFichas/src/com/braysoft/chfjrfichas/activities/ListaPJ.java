package com.braysoft.chfjrfichas.activities;

import java.io.IOException;
import java.util.List;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Personaje;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class ListaPJ extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_personajes);
		
		try
		{
			ListView lstPJ = (ListView)findViewById(R.id.lstPJ);
			List<Personaje> personajes = Personaje.getAll();
			
			AdaptadorPersonajes adaptador =  new AdaptadorPersonajes(this,personajes);
			lstPJ.setAdapter(adaptador);
			lstPJ.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					
					Personaje personaje = ((AdaptadorPersonajes)parent.getAdapter()).getItem(position);
					
					abrirEditPJ(personaje);
					
				}
			});
			
			lstPJ.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
				
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
		getMenuInflater().inflate(R.menu.lista_personajes_menu, menu);
		return true;
	}

	public void del_onClick(MenuItem item)
	{
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		AdaptadorPersonajes adapter = (AdaptadorPersonajes)((ListView)this.findViewById(R.id.lstPJ)).getAdapter();
		Personaje pj = adapter.getItem(info.position);
		
		pj.eliminar();
		adapter.remove(pj);

	}
	
	public void abrirEditPJ(Personaje personaje)
	{
		Intent intent = new Intent(this, EditPJ.class);
		Bundle b = new Bundle();
		
		b.putSerializable("PJ", personaje);
		intent.putExtras(b);
		
        startActivity(intent);	
	}
	
	public void newPJ_onClick(MenuItem item)
	{
		abrirEditPJ(null);
	}
}


class AdaptadorPersonajes extends ArrayAdapter<Personaje> 
{
	Activity _context;
	List<Personaje> _datos;
	
	AdaptadorPersonajes(Activity context,List<Personaje> datos) 
	{
		super(context, R.layout.lista_personajes_layout, datos);
		this._context = context;
		this._datos = datos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View item = convertView;
		if (item == null) 
		{
			LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			item = inflater.inflate(R.layout.lista_personajes_layout,null);
		}

		TextView lblNombrePJ = (TextView)item.findViewById(R.id.lblNombrePJ);
		lblNombrePJ.setText(_datos.get(position).getNombre());
		/*ImageView imgEscudo = (ImageView)item.findViewById(R.id.imgEscudoCasa);
		
		if (_datos[position].existeEscudo())
			lblEscudo.setBackground(_datos[position].getEscudo());
		else lblEscudo.setBackgroundResource(R.drawable.ic_launcher);*/

		return(item);
	}
}

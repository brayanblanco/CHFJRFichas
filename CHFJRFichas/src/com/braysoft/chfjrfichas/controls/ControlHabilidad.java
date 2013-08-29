package com.braysoft.chfjrfichas.controls;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Especializacion;
import com.braysoft.chfjrfichas.data.Habilidad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlHabilidad extends LinearLayout {

	boolean _peque–o;

	public ControlHabilidad(Context context) {
		super(context);
		
		_peque–o = false;
		inicializar();
	}
	
	public ControlHabilidad(Context context, boolean peque–o){
		super(context);
		
		_peque–o = peque–o;
		inicializar();
	}

	@SuppressWarnings("rawtypes")
	private void inicializar() 
	{
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_habilidad, this, true);
	    
	    Spinner spin = (Spinner)this.findViewById(R.id.spnHabilidad);
	    EditText txt = (EditText)this.findViewById(R.id.txtNivelHabilidad);
	    ArrayAdapter adapter;
	    
	    if(_peque–o)
	    {
	    	adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.str_abilitiesarray,R.layout.small_spinner);
	    	//txt.setWidth(25);
	    	txt.setTextSize(12);
	    	
	    	
	    	LinearLayout layEspec = (LinearLayout)this.findViewById(R.id.layEspecializacionesTXT);
			//this.findViewById(R.id.layEspecializaciones).setVisibility(INVISIBLE);
			layEspec.removeView(this.findViewById(R.id.lblEspecializaciones));
			//this.findViewById(R.id.lblEspecializaciones).setVisibility(INVISIBLE);
			layEspec.removeView(this.findViewById(R.id.btnAddEspecializacion));//
			//this.findViewById(R.id.btnAddEspecializacion).setVisibility(INVISIBLE);
	    	this.removeView(layEspec);
	   	}
	    else
	    {
	    	adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.str_abilitiesarray,android.R.layout.simple_spinner_item);
	   	}
	    
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spin.setAdapter(adapter);
        
	}

	public void setHabilidad(Habilidad habilidad) 
	{
		((Spinner)this.findViewById(R.id.spnHabilidad)).setSelection(habilidad.getIdHabilidad());
		((EditText)this.findViewById(R.id.txtNivelHabilidad)).setText(Integer.valueOf(habilidad.getValor()).toString());
		
		
		
		if(habilidad.getEspecializaciones() != null)
			for(Especializacion especializacion : habilidad.getEspecializaciones())
				this.addEspecializacion(especializacion);
			
		
	}

	private int obtenerIdArrayEspec(int idHabilidad) {
		int retValue;
		String habilidadesArray = App.getAppResources().getStringArray(R.array.str_abilitiesarray)[idHabilidad];
		
		if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_agi))) retValue = R.array.str_specagiarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_ath))) retValue = R.array.str_specatharray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_fig))) retValue = R.array.str_specfigarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_kno))) retValue = R.array.str_specknoarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_end))) retValue = R.array.str_specendarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_hea))) retValue = R.array.str_specheaarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_ste))) retValue = R.array.str_specstearray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_dec))) retValue = R.array.str_specdecarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_sta))) retValue = R.array.str_specstaarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_war))) retValue = R.array.str_specwararray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_lan))) retValue = R.array.str_speclanarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_cun))) retValue = R.array.str_speccunarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_awa))) retValue = R.array.str_specawaarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_per))) retValue = R.array.str_specperarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_thi))) retValue = R.array.str_specthiarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_mar))) retValue = R.array.str_specmararray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_sur))) retValue = R.array.str_specsurarray;
		else if(habilidadesArray.equals(App.getAppResources().getString(R.string.str_ani))) retValue = R.array.str_specaniarray;
		else retValue = R.array.str_specwilarray;
		
		return retValue;
	}

	public void addEspecializacion(Especializacion especializacion) 
	{
		LinearLayout layHabilidad = (LinearLayout)this.findViewById(R.id.ctrHabilidad);
		Spinner spn = (Spinner)layHabilidad.findViewById(R.id.spnHabilidad);
		int idArrayEspec = this.obtenerIdArrayEspec(spn.getSelectedItemPosition());
		ControlEspecializacion ctrNewEspec = new ControlEspecializacion(this.getContext(),idArrayEspec);
		
		//Eliminar especializacion
		((View)ctrNewEspec.findViewById(R.id.btnRemoveEspecializacion)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v3) {
				LinearLayout layEspecializacion = (LinearLayout)v3.getParent().getParent().getParent();
				layEspecializacion.removeView((LinearLayout)v3.getParent().getParent());
			}
		 });
		
		if(especializacion != null) ctrNewEspec.setEspecializacion(especializacion);
		
		layHabilidad.addView(ctrNewEspec,layHabilidad.getChildCount());
	}
}

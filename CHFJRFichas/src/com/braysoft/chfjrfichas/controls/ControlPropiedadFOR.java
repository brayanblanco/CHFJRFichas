package com.braysoft.chfjrfichas.controls;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.PropiedadFortuna;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlPropiedadFOR extends LinearLayout {

	public ControlPropiedadFOR(Context context) 
	{
		super(context);
		
		inicializar();
	}

	private void inicializar() 
	{
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_propiedad_fortuna, this, true);
	}

	public void setPropiedad(PropiedadFortuna propiedad) 
	{
		((Spinner)this.findViewById(R.id.spnPropiedad)).setSelection(propiedad.getIdTipo());
		
	}
}

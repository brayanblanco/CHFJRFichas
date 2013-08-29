package com.braysoft.chfjrfichas.controls;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.PropiedadDefensa;

public class ControlPropiedadDEF extends LinearLayout {

	public ControlPropiedadDEF(Context context) {
		super(context);
		
		inicializar();
	}

	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_propiedad_defensa, this, true);
	}

	public void setPropiedad(PropiedadDefensa propiedad) 
	{
		((Spinner)this.findViewById(R.id.spnPropiedad)).setSelection(propiedad.getIdTipo());
		((EditText)this.findViewById(R.id.txtNombrePropiedad)).setText(propiedad.getNombre());
		
	}
}

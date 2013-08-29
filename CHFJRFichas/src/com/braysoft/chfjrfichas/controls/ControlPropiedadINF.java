package com.braysoft.chfjrfichas.controls;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.PropiedadInfluencia;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlPropiedadINF extends LinearLayout {

	public ControlPropiedadINF(Context context) {
		super(context);
		
		inicializar();
	}

	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_propiedad_influencia, this, true);
	}

	public void setPropiedad(PropiedadInfluencia propiedad) {
		
		((Spinner)this.findViewById(R.id.spnPropiedad)).setSelection(propiedad.getIdTipo());
		
	}
}

package com.braysoft.chfjrfichas.controls;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Defecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlDefectos extends LinearLayout {

	public ControlDefectos(Context context) {
		super(context);
		
		inicializar();
	}

	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_defectos, this, true);
	}

	public void setDefecto(Defecto defecto) {
		
		((Spinner)this.findViewById(R.id.spnDefectos)).setSelection(defecto.getIdDefecto());
		
	}

}

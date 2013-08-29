package com.braysoft.chfjrfichas.controls;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Beneficio;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlBeneficios extends LinearLayout {

	public ControlBeneficios(Context context) {
		super(context);
		
		inicializar();
	}

	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_beneficios, this, true);
	}

	public void setBeneficio(Beneficio beneficio) {
		
		((Spinner)this.findViewById(R.id.spnBeneficio)).setSelection(beneficio.getIdBeneficio());
		
	}

}

package com.braysoft.chfjrfichas.controls;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.CaracteristicaTerreno;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlCaracteristicaTIE extends LinearLayout {

	public ControlCaracteristicaTIE(Context context) {
		super(context);
		
		inicializar();
	}

	@SuppressWarnings("rawtypes")
	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_caracteristica_tierra, this, true);
	    
	    Spinner spin = (Spinner)this.findViewById(R.id.spnCaracteristica);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext(),R.array.str_earfeatsarray,R.layout.small_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
	}

	public void setCaracteristica(CaracteristicaTerreno caracteristica) 
	{
		((Spinner)this.findViewById(R.id.spnCaracteristica)).setSelection(caracteristica.getIdCaracteristica());
		
	}
}

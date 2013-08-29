package com.braysoft.chfjrfichas.controls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.CaracteristicaTerreno;
import com.braysoft.chfjrfichas.data.PropiedadTierras;

public class ControlPropiedadTIE extends LinearLayout {

	public ControlPropiedadTIE(Context context) {
		super(context);
		
		inicializar();
	}

	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_propiedad_tierra, this, true);
	}

	public void setPropiedad(PropiedadTierras propiedad) 
	{
		((Spinner)this.findViewById(R.id.spnPropiedad)).setSelection(propiedad.getIdTipo());
		
		for(CaracteristicaTerreno caracteristica : propiedad.getCaracteristicas())
			this.addCaracteristica(caracteristica);
		
	}
	
	public void addCaracteristica(CaracteristicaTerreno caracteristica)
	{
		LinearLayout layPropiedad = (LinearLayout)this.findViewById(R.id.ctrPropiedadTIE);
		ControlCaracteristicaTIE ctrNewCarac = new ControlCaracteristicaTIE(this.getContext());
		
		//Eliminar caracter’stica tierra
		((View)ctrNewCarac.findViewById(R.id.btnRemoveTIECarac)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v3) {
				LinearLayout layTIECarac = (LinearLayout)v3.getParent().getParent();
				layTIECarac.removeView((LinearLayout)v3.getParent());
			}
		 });
		
		if(caracteristica != null) ctrNewCarac.setCaracteristica(caracteristica);
		
		layPropiedad.addView(ctrNewCarac,layPropiedad.getChildCount()-1);
	}
}

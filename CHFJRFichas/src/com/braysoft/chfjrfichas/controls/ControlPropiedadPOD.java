package com.braysoft.chfjrfichas.controls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Habilidad;
import com.braysoft.chfjrfichas.data.PropiedadPoder;

public class ControlPropiedadPOD extends LinearLayout {

	public ControlPropiedadPOD(Context context) {
		super(context);
		
		inicializar();
	}

	private void inicializar() {
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_propiedad_poder, this, true);
	}

	public void setPropiedad(PropiedadPoder propiedad) 
	{
		((Spinner)this.findViewById(R.id.spnUnidad)).setSelection(propiedad.getIdUnidad());
		((Spinner)this.findViewById(R.id.spnEntrenamiento)).setSelection(propiedad.getIdExperiencia());
		
		for(Habilidad habilidad : propiedad.getHabilidadesUnidad())
			this.addHabilidad(habilidad);
		
	}

	public void addHabilidad(Habilidad habilidad) 
	{
		LinearLayout layPropiedadPOD = (LinearLayout)this.findViewById(R.id.ctrPropiedadPOD);
		ControlHabilidad ctrNewHabil = new ControlHabilidad(this.getContext(),true);
		
		//Eliminar especializacion
		((View)ctrNewHabil.findViewById(R.id.btnRemoveHabilidad)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v3) {
				LinearLayout layHabilidad = (LinearLayout)v3.getParent().getParent().getParent().getParent();
				layHabilidad.removeView((LinearLayout)v3.getParent().getParent().getParent());
				((LinearLayout)layHabilidad).findViewById(R.id.btnAddHabilidad).setVisibility(View.VISIBLE);
			}
		 });
		
		if(habilidad != null) ctrNewHabil.setHabilidad(habilidad);
		
		layPropiedadPOD.addView(ctrNewHabil,layPropiedadPOD.getChildCount()-1);
		if(layPropiedadPOD.getChildCount() == 6) this.findViewById(R.id.btnAddHabilidad).setVisibility(View.INVISIBLE);
		
	}
}

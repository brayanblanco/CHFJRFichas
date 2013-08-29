package com.braysoft.chfjrfichas.controls;


import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.data.Especializacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class ControlEspecializacion extends LinearLayout {

	private int _idArrayEspec;
	
	public ControlEspecializacion(Context context,int idArrayEspec) {
		super(context);
		
		_idArrayEspec = idArrayEspec;
		inicializar();
	}
	
	public ControlEspecializacion(Context context)
	{
		super(context);
		_idArrayEspec = R.array.str_specagiarray;
	}

	@SuppressWarnings("rawtypes")
	private void inicializar() 
	{
		String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.ctr_especializacion, this, true);
	    //TODO Cambiar caracteristica por especializacion
	    Spinner spin = (Spinner)this.findViewById(R.id.spnEspecializacion);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext(),_idArrayEspec,R.layout.small_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
		
	}

	public void setEspecializacion(Especializacion especializacion) 
	{
		((Spinner)this.findViewById(R.id.spnEspecializacion)).setSelection(especializacion.getIdEspecializacion());
		((EditText)this.findViewById(R.id.txtNivelEspecializacion)).setText(Integer.valueOf(especializacion.getValor()).toString());
		
	}

}

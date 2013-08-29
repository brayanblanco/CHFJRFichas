package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class PropiedadInfluencia implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3407521540956211173L;
	private int _idTipo;
	
	public PropiedadInfluencia(int idTipo)
	{
		_idTipo = idTipo;
	}

	public int getIdTipo() {
		return _idTipo;
	}

	public String getTipo()
	{
		return App.getAppResources().getStringArray(R.array.str_infarray)[_idTipo];
	}
}

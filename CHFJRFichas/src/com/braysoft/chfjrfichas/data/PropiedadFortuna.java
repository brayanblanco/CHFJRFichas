package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class PropiedadFortuna implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3419632884845184106L;
	private int _idTipo;
	
	public PropiedadFortuna(int idTipo)
	{
		_idTipo = idTipo;
	}

	public int getIdTipo() {
		return _idTipo;
	}

	public String getTipo()
	{
		return App.getAppResources().getStringArray(R.array.str_forarray)[_idTipo];
	}
}

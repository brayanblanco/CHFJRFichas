package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class PropiedadDefensa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2624478486544096488L;
	private int _idTipo;
	private String _nombre;
	
	public PropiedadDefensa(int idTipo, String nombre)
	{
		_idTipo = idTipo;
		_nombre = nombre;
	}

	public int getIdTipo() {
		return _idTipo;
	}

	public String getTipo() {
		return App.getAppResources().getStringArray(R.array.str_defarray)[_idTipo];
	}

	public String getNombre() {
		return _nombre;
	}
	
	

}

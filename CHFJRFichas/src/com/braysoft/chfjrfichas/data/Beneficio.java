package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class Beneficio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1280672075972618954L;
	private int _idTipo;

	public Beneficio(int idBeneficio)
	{
		_idTipo = idBeneficio;
	}

	public int getIdBeneficio() {
		return _idTipo;
	}

	public String getNombre()
	{
		return App.getAppResources().getStringArray(R.array.beneficios_array)[_idTipo];
	}
}

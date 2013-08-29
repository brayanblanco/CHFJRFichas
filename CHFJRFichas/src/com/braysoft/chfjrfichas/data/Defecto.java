package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class Defecto implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8916608426891156965L;
	private int _idDefecto;

	public Defecto(int idDefecto)
	{
		_idDefecto = idDefecto;
	}

	public int getIdDefecto() {
		return _idDefecto;
	}

	public String getNombre()
	{
		return App.getAppResources().getStringArray(R.array.defectos_array)[_idDefecto];
	}
}

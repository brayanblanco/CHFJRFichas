package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class Reino implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8034777024298064742L;
	private int _id;
	
	public Reino(int id)
	{
		
		_id = id;
	}

	public int getId() {
		return _id;
	}

	public String getNombre() {
		return App.getAppResources().getStringArray(R.array.str_kingdomarray)[_id];
	}
}

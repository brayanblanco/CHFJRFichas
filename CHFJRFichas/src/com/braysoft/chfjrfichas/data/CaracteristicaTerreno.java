package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class CaracteristicaTerreno implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6745732524268272941L;
	private int _idCaracteristica;
	
	public CaracteristicaTerreno(int idCaracteristica)
	{
		_idCaracteristica = idCaracteristica;
	}

	public int getIdCaracteristica() {
		return _idCaracteristica;
	}
	
	public String getNombre()
	{
		return App.getAppResources().getStringArray(R.array.str_earfeatsarray)[_idCaracteristica];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _idCaracteristica;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaracteristicaTerreno other = (CaracteristicaTerreno) obj;
		if (_idCaracteristica != other._idCaracteristica)
			return false;
		return true;
	}
	
	

}

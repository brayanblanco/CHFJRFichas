package com.braysoft.chfjrfichas.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class Habilidad implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1693577152575167499L;
	private int _idHabilidad;
	private int _valor;
	private List<Especializacion> _especializaciones;
	
	
	public Habilidad(int idHabilidad, int valor)
	{
		_idHabilidad = idHabilidad;
		_valor = valor;
		_especializaciones = new ArrayList<Especializacion>();
	}


	public Habilidad(int idHabilidad) 
	{
		{
			_idHabilidad = idHabilidad;
			_valor = 2;
			_especializaciones = new ArrayList<Especializacion>();
		}
	}


	public int getValor() {
		return _valor;
	}


	public void setValor(int valor) {
		_valor = valor;
	}


	public int getIdHabilidad() {
		return _idHabilidad;
	}

	public List<Especializacion> getEspecializaciones()
	{
		return _especializaciones;
	}
	
	public String getNombre()
	{
		return App.getAppResources().getStringArray(R.array.str_abilitiesarray)[_idHabilidad];
	}
	
	/***
	 * A–ade una especializaci—n, no permite duplicados.
	 * @param especializacion
	 */
	public void addEspecializacion(Especializacion especializacion)
	{
		if(!_especializaciones.contains(especializacion))
			_especializaciones.add(especializacion);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _idHabilidad;
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
		Habilidad other = (Habilidad) obj;
		if (_idHabilidad != other._idHabilidad)
			return false;
		return true;
	}

	
}

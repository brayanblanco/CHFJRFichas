package com.braysoft.chfjrfichas.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class PropiedadPoder implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8963322553254191992L;
	private int _idUnidad;
	private int _idExperiencia;
	private List<Habilidad> _habilidadesUnidad;
	
	public PropiedadPoder(int idUnidad, int idExperiencia)
	{
		_idUnidad = idUnidad;
		_idExperiencia = idExperiencia;
		_habilidadesUnidad = new ArrayList<Habilidad>();
	}
	
	public PropiedadPoder(int idUnidad, int idExperiencia, List<Habilidad> habilidadesUnidad)
	{
		_idUnidad = idUnidad;
		_idExperiencia = idExperiencia;
		_habilidadesUnidad = habilidadesUnidad;
	}
	
	//Getters y Setters
	public int getIdExperiencia() {
		return _idExperiencia;
	}

	public void setIdExperiencia(int idExperiencia) {
		_idExperiencia = idExperiencia;
	}

	public int getIdUnidad() {
		return _idUnidad;
	}

	public List<Habilidad> getHabilidadesUnidad() {
		return _habilidadesUnidad;
	}
	
	//MŽtodos pœblicos
	public String getNombreUnidad()
	{
		return App.getAppResources().getStringArray(R.array.str_powunitsarray)[_idUnidad];
	}
	
	public String getNombreExperiencia()
	{
		return App.getAppResources().getStringArray(R.array.str_powtrainsarray)[_idExperiencia];
	}
	
	/***
	 * A–ade una habilidad entrenada a la unidad. No permite duplicados.
	 * @param habilidad
	 */
	public void addHabilidad(Habilidad habilidad)
	{
		if(!this.existeHabilidad(habilidad))
			_habilidadesUnidad.add(habilidad);
	}
	
	public void removeHabilidad(Habilidad habilidad)
	{
		if(this.existeHabilidad(habilidad))
			_habilidadesUnidad.remove(habilidad);
	}
	
	public boolean existeHabilidad(Habilidad habilidad)
	{
		return (_habilidadesUnidad.indexOf(habilidad) != -1);

	}
	public void cambiarValorHabilidad(Habilidad habilidad, int valor)
	{
		if(this.existeHabilidad(habilidad))
		{
			int indexHabilidad = _habilidadesUnidad.indexOf(habilidad);
			_habilidadesUnidad.get(indexHabilidad).setValor(valor);
		}
	}

}

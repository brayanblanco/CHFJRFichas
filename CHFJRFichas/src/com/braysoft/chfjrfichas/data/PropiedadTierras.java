package com.braysoft.chfjrfichas.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class PropiedadTierras implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7788854063566368565L;
	private int _idTipo;
	private List<CaracteristicaTerreno> _caracteristicasTerreno;
	
	public PropiedadTierras(int idTipo)
	{
		_idTipo = idTipo;
		_caracteristicasTerreno = new ArrayList<CaracteristicaTerreno>();
	}
	
	public PropiedadTierras(int idTipo, List<CaracteristicaTerreno> caracteristicas)
	{
		_idTipo = idTipo;
		_caracteristicasTerreno = caracteristicas;
	}

	//Getters y Setters
	public int getIdTipo() {
		return _idTipo;
	}

	public List<CaracteristicaTerreno> getCaracteristicas() {
		return _caracteristicasTerreno;
	}
	
	//MŽtodos pœblicos
	public String getTipo()
	{
		return App.getAppResources().getStringArray(R.array.str_eararray)[_idTipo];
	}
	
	/***
	 * A–ade una caracteristica al terreno. Permite duplicados.
	 * @param caracteristica
	 */
	public void addCaracteristica(CaracteristicaTerreno caracteristica)
	{
		_caracteristicasTerreno.add(caracteristica);
	}
	
	public boolean existeCaracteristica(CaracteristicaTerreno caracteristica)
	{
		return (_caracteristicasTerreno.indexOf(caracteristica) != -1);
	}
	
	public void removeCaracteristica(CaracteristicaTerreno caracteristica)
	{
		if(this.existeCaracteristica(caracteristica))
			_caracteristicasTerreno.remove(caracteristica);
	}
}

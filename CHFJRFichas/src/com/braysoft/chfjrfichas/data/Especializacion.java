package com.braysoft.chfjrfichas.data;

import java.io.Serializable;

public class Especializacion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6073535473182970889L;
	private int _idEspecializacion;
	private int _valor;
	
	public Especializacion(int idEspecializacion, int valor)
	{
		_idEspecializacion = idEspecializacion;
		_valor = valor;
	}

	public int getValor() {
		return _valor;
	}

	public void setValor(int valor) {
		_valor = valor;
	}

	public int getIdEspecializacion() {
		return _idEspecializacion;
	}
	
}

package com.braysoft.chfjrfichas.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;

public class Personaje implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6187821799597812521L;
	private String _nombre;
	private int _edad;
	private int _sexoID;
	private String _casa;
	private int _puntosDestino;
	
	private List<Habilidad> _habilidades;
	private List<Beneficio> _beneficios;
	private List<Defecto> _defectos;
	
	
	public Personaje()
	{
		_habilidades = new ArrayList<Habilidad>();
		_beneficios = new ArrayList<Beneficio>();
		_defectos = new ArrayList<Defecto>();
	}

	public String getNombre() {
		return _nombre;
	}
	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	public int getEdad() {
		return _edad;
	}
	public void setEdad(int edad) {
		_edad = edad;
	}
	public int getSexoID() {
		return _sexoID;
	}
	public void setSexoID(int sexoID) {
		_sexoID = sexoID;
	}
	public String getCasa() {
		return _casa;
	}
	public void setCasa(String casa) {
		_casa = casa;
	}
	public int getPuntosDestino() {
		return _puntosDestino;
	}
	public void setPuntosDestino(int puntosDestino) {
		_puntosDestino = puntosDestino;
	}
	public List<Habilidad> getHabilidades() {
		return _habilidades;
	}
	public List<Beneficio> getBeneficios() {
		return _beneficios;
	}
	public List<Defecto> getDefectos() {
		return _defectos;
	}
	
	public static Personaje nuevoPJDesdeFichero(File filePJ) throws IOException, ClassNotFoundException
	{
		FileInputStream fis;
		ByteArrayInputStream bais;
		ByteArrayOutputStream baos;
		
		ObjectInput in = null;
		byte[] buf = new byte[1024];
		
		try 
		{
			fis = new FileInputStream(filePJ);
			baos = new ByteArrayOutputStream();
			
			for(int readNum;(readNum = fis.read(buf)) != -1;)
			{
				baos.write(buf,0,readNum);
			}
			
			
			bais = new ByteArrayInputStream(baos.toByteArray());
			in = new ObjectInputStream(bais);
			
			fis.close();
			bais.close();
			baos.close();
			in.close();
			
			return (Personaje)in.readObject(); 
			
			

		}
		catch(IOException e)
		{
			Log.w("Casa.Class", e);
			throw new IOException("Se ha producido un eror durante la carga del fichero");
		} catch (ClassNotFoundException e) 
		{
			Log.w("Casa.Class", e);
			throw e;
		}
	}
	
	public static List<Personaje> getAll() throws IOException, ClassNotFoundException
	{
		try
		{
			List<Personaje> pjs = new ArrayList<Personaje>();
			File dirPJS = App.getDirectorioPersonajes();
			
			File[] filePJ = dirPJS.listFiles();
			for(File fileCasa : filePJ)
				pjs.add(Personaje.nuevoPJDesdeFichero(fileCasa));
			return pjs;
		}
		catch(IOException e)
		{
			Log.w("Casa.Class", e);
			throw e;
		} 
		catch (ClassNotFoundException e) 
		{
			Log.w("Casa.Class", e);
			throw e;
		}
	}
	
	public int getDefensaCombate()
	{
		int agi = 2;
		int agiIDX = 0;
		int brio = 2;
		int brioIDX = 0;
		int perc = 2;
		int percIDX = 0;

		Habilidad habiTemp;
		String[] habilidadesArr = App.getAppResources().getStringArray(R.array.str_abilitiesarray);
		for(int i=0;i<habilidadesArr.length;i++)
		{
			if (habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_agi)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					agiIDX = _habilidades.indexOf(habiTemp);
					agi = _habilidades.get(agiIDX).getValor();
				}
			}
			else if(habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_ath)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					brioIDX = _habilidades.indexOf(habiTemp);
					brio = _habilidades.get(brioIDX).getValor();
				}
			}
			else if(habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_awa)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					percIDX = _habilidades.indexOf(habiTemp);
					perc = _habilidades.get(percIDX).getValor();
				}
			}
		}

		return agi+brio+perc;
	}
	
	public int getDefensaIntriga()
	{
		int est = 2;
		int estIDX = 0;
		int ing = 2;
		int ingIDX = 0;
		int perc = 2;
		int percIDX = 0;

		Habilidad habiTemp;
		String[] habilidadesArr = App.getAppResources().getStringArray(R.array.str_abilitiesarray);
		for(int i=0;i<habilidadesArr.length;i++)
		{
			if (habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_sta)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					estIDX = _habilidades.indexOf(habiTemp);
					est = _habilidades.get(estIDX).getValor();
				}
			}
			else if(habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_cun)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					ingIDX = _habilidades.indexOf(habiTemp);
					ing = _habilidades.get(ingIDX).getValor();
				}
			}
			else if(habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_awa)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					percIDX = _habilidades.indexOf(habiTemp);
					perc = _habilidades.get(percIDX).getValor();
				}
			}
		}

		return est+ing+perc;
	}
	
	public int getCompostura()
	{
		int vol = 2;
		int volIDX = 0;
		
		Habilidad habiTemp;
		String[] habilidadesArr = App.getAppResources().getStringArray(R.array.str_abilitiesarray);
		for(int i=0;i<habilidadesArr.length;i++)
		{
			if (habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_wil)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					volIDX = _habilidades.indexOf(habiTemp);
					vol = _habilidades.get(volIDX).getValor();
				}
			}
		}
	
		return vol*3;
	}
	
	public int getSalud()
	{
		int con = 2;
		int conIDX = 0;
		
		Habilidad habiTemp;
		String[] habilidadesArr = App.getAppResources().getStringArray(R.array.str_abilitiesarray);
		for(int i=0;i<habilidadesArr.length;i++)
		{
			if (habilidadesArr[i].equals(App.getAppResources().getString(R.string.str_end)))
			{
				habiTemp = new Habilidad(i);
				if(_habilidades.contains(habiTemp))
				{
					conIDX = _habilidades.indexOf(habiTemp);
					con = _habilidades.get(conIDX).getValor();
				}
			}
		}
	
		return con*3;
	}
	
	public void addHabilidad(Habilidad habilidad)
	{
		if(!_habilidades.contains(habilidad))
			_habilidades.add(habilidad);
	}
	
	public void addBeneficio(Beneficio beneficio)
	{
		_beneficios.add(beneficio);
	}
	
	public void addDefecto(Defecto defecto)
	{
		_defectos.add(defecto);
	}

	public void guardarFichero() throws IOException
	{
		File filePJ;
		FileOutputStream fos;
		byte[] bArray; 
		
		
		try 
		{
			bArray = this.getByteArray();
			filePJ = new File(App.getDirectorioPersonajes(),this._casa + "-"+this._nombre.replace(" ", "_") + ".chf");
			filePJ.createNewFile();
			fos = new FileOutputStream(filePJ);
			
			fos.write(bArray);
			fos.flush();
			fos.close();
			
		} 
		catch (IOException e) 
		{
			Log.w("Personaje.Class", e);
			throw new IOException("Ha ocurrido un error guardando el fichero");
		}
		
	}

	private byte[] getByteArray() throws IOException 
	{
		ByteArrayOutputStream baos;
		ObjectOutput out = null;
		byte[] bArray;

		baos = new ByteArrayOutputStream();
		out = new ObjectOutputStream(baos);
		out.writeObject(this);
		
		bArray = baos.toByteArray();
		
		out.close();
		baos.close();
		
		return bArray;
  
	}

	public void eliminar() 
	{
		File filePJ = new File(App.getDirectorioPersonajes(),this._casa + "-"+this._nombre.replace(" ", "_") + ".chf");
		filePJ.delete();
		
	}
}

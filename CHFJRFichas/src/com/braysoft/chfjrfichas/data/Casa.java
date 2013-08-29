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

public class Casa implements Serializable
{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7776285320393312816L;
	//Datos
	//private BitmapDrawable _escudo;
	private String _nombre;
	private String _lema;
	private Reino _reino;
	private String _se–or;
	
	//Recursos
	private int _DEF;
	private int _INF;
	private int _TIE;
	private int _LEY;
	private int _POB;
	private int _POD;
	private int _FOR;
	//Propiedades
	private List<PropiedadDefensa> _propiedadesDefensa;
	private List<PropiedadInfluencia> _propiedadesInfluencia;
	private List<PropiedadTierras> _propiedadesTierras;
	private List<PropiedadPoder> _propiedadesPoder;
	private List<PropiedadFortuna> _propiedadesFortuna;
	
	public Casa()
	{
		_propiedadesDefensa = new ArrayList<PropiedadDefensa>();
		_propiedadesInfluencia = new ArrayList<PropiedadInfluencia>();
		_propiedadesPoder = new ArrayList<PropiedadPoder>();
		_propiedadesTierras = new ArrayList<PropiedadTierras>();
		_propiedadesFortuna = new ArrayList<PropiedadFortuna>();
	}
	
	//Setters y getters
	public Reino getReino() {
		return _reino;
	}

	public void setReino(Reino reino) {
		_reino = reino;
	}

	public String getSe–or() {
		return _se–or;
	}

	public void setSe–or(String se–or) {
		_se–or = se–or;
	}

	public int getDEF() {
		return _DEF;
	}

	public void setDEF(int DEF) {
		_DEF = DEF;
	}

	public int getINF() {
		return _INF;
	}

	public void setINF(int INF) {
		_INF = INF;
	}

	public int getTIE() {
		return _TIE;
	}

	public void setTIE(int TIE) {
		_TIE = TIE;
	}

	public int getLEY() {
		return _LEY;
	}

	public void setLEY(int LEY) {
		_LEY = LEY;
	}

	public int getPOB() {
		return _POB;
	}

	public void setPOB(int POB) {
		_POB = POB;
	}

	public int getPOD() {
		return _POD;
	}

	public void setPOD(int POD) {
		_POD = POD;
	}

	public int getFOR() {
		return _FOR;
	}

	public void setFOR(int FOR) {
		_FOR = FOR;
	}

	public List<PropiedadDefensa> getPropiedadesDefensa() {
		return _propiedadesDefensa;
	}

	public void setPropiedadesDefensa(List<PropiedadDefensa> propiedadesDefensa) {
		_propiedadesDefensa = propiedadesDefensa;
	}

	public List<PropiedadInfluencia> getPropiedadesInfluencia() {
		return _propiedadesInfluencia;
	}

	public void setPropiedadesInfluencia(
			List<PropiedadInfluencia> propiedadesInfluencia) {
		_propiedadesInfluencia = propiedadesInfluencia;
	}

	public List<PropiedadTierras> getPropiedadesTierras() {
		return _propiedadesTierras;
	}

	public void setPropiedadesTierras(List<PropiedadTierras> propiedadesTierras) {
		_propiedadesTierras = propiedadesTierras;
	}

	public List<PropiedadPoder> getPropiedadesPoder() {
		return _propiedadesPoder;
	}

	public void setPropiedadesPoder(List<PropiedadPoder> propiedadesPoder) {
		_propiedadesPoder = propiedadesPoder;
	}

	public List<PropiedadFortuna> getPropiedadesFortuna() {
		return _propiedadesFortuna;
	}

	public void setPropiedadesFortuna(List<PropiedadFortuna> propiedadesFortuna) {
		_propiedadesFortuna = propiedadesFortuna;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		this._nombre = nombre;
	}

	public String getLema() {
		return _lema;
	}

	public void setLema(String lema) {
		this._lema = lema;
	}

	/*public BitmapDrawable getEscudo() 
	{
		return _escudo;
	}

	public void setEscudo(BitmapDrawable escudo) {
		this._escudo = escudo;
	}*/

	//MŽtodos pœblicos
	/*public boolean existeEscudo() {
		return (null == _escudo);
	}*/	
	
	public void addPropiedadDefensa(PropiedadDefensa propiedad)
	{
		_propiedadesDefensa.add(propiedad);
	}

	public void addPropiedadInfluencia(PropiedadInfluencia propiedadInfluencia) 
	{
		_propiedadesInfluencia.add(propiedadInfluencia);
	}
	
	public void addPropiedadTierras(PropiedadTierras propiedadTierra)
	{
		_propiedadesTierras.add(propiedadTierra);
	}
	
	public void addPropiedadPoder(PropiedadPoder propiedadPoder)
	{
		_propiedadesPoder.add(propiedadPoder);
	}
	
	public void addPropiedadFortuna(PropiedadFortuna propiedadFortuna)
	{
		_propiedadesFortuna.add(propiedadFortuna);
	}

	public void guardarFichero() throws IOException 
	{
		File fileCasa;
		FileOutputStream fos;
		byte[] bArray; 
		
		
		try 
		{
			bArray = this.getByteArray();
			fileCasa = new File(App.getDirectorioCasas(),this._nombre + ".chf");
			fileCasa.createNewFile();
			fos = new FileOutputStream(fileCasa);
			
			fos.write(bArray);
			fos.flush();
			fos.close();
			
		} 
		catch (IOException e) 
		{
			Log.w("Casa.Class", e);
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
	
	public static Casa nuevaCasaDesdeFichero(File fileCasa) throws IOException, ClassNotFoundException
	{
		FileInputStream fis;
		ByteArrayInputStream bais;
		ByteArrayOutputStream baos;
		
		ObjectInput in = null;
		byte[] buf = new byte[1024];
		
		try 
		{
			fis = new FileInputStream(fileCasa);
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
			
			return (Casa)in.readObject(); 
			
			

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

	public static List<Casa> getAll() throws IOException, ClassNotFoundException 
	{
		try
		{
			List<Casa> casas = new ArrayList<Casa>();
			File dirCasas = App.getDirectorioCasas();
			
			File[] filesCasa = dirCasas.listFiles();
			for(File fileCasa : filesCasa)
				casas.add(Casa.nuevaCasaDesdeFichero(fileCasa));
			return casas;
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

	public void eliminar() 
	{
		File fileCasa = new File(App.getDirectorioCasas(),this._nombre + ".chf");
		fileCasa.delete();
		
	}
}


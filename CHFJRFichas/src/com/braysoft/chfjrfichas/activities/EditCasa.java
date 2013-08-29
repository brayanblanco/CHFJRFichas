package com.braysoft.chfjrfichas.activities;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.controls.ControlPropiedadDEF;
import com.braysoft.chfjrfichas.controls.ControlPropiedadFOR;
import com.braysoft.chfjrfichas.controls.ControlPropiedadINF;
import com.braysoft.chfjrfichas.controls.ControlPropiedadPOD;
import com.braysoft.chfjrfichas.controls.ControlPropiedadTIE;
import com.braysoft.chfjrfichas.data.CaracteristicaTerreno;
import com.braysoft.chfjrfichas.data.Casa;
import com.braysoft.chfjrfichas.data.Habilidad;
import com.braysoft.chfjrfichas.data.PropiedadDefensa;
import com.braysoft.chfjrfichas.data.PropiedadFortuna;
import com.braysoft.chfjrfichas.data.PropiedadInfluencia;
import com.braysoft.chfjrfichas.data.PropiedadPoder;
import com.braysoft.chfjrfichas.data.PropiedadTierras;
import com.braysoft.chfjrfichas.data.Reino;


public class EditCasa extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_casa);
		
		//txtLEY Listener
		((View)this.findViewById(R.id.txtLEY)).setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!hasFocus)
				{					
					calcularVicisitudLEY();
				}
				
			}
		});
		
		//txtPOB Listener
		((View)this.findViewById(R.id.txtPOB)).setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!hasFocus)
				{
					calcularVicisitudPOB();
				}
				
			}
		});
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null && b.containsKey(App.KEY_CASA))
		{
			Casa casa = (Casa) b.getSerializable(App.KEY_CASA);
			if(casa != null) this.objectToScreen(casa);
		}

	}
	
	private void calcularVicisitudLEY()
	{
		int intLeyValue;
		String strModificadorLey;
			
		intLeyValue = Integer.parseInt(((EditText)this.findViewById(R.id.txtLEY)).getText().toString());
		
		if(intLeyValue == 0)
			strModificadorLey = "-20";
		else if(intLeyValue > 0 && intLeyValue <= 10)
			strModificadorLey = "-10";
		else if(intLeyValue > 10 && intLeyValue <= 20)
			strModificadorLey = "-5";
		else if(intLeyValue > 20 && intLeyValue <= 30)
			strModificadorLey = "-2";
		else if(intLeyValue > 30 && intLeyValue <= 40)
			strModificadorLey = "-1";
		else if(intLeyValue > 40 && intLeyValue <= 50)
			strModificadorLey = "+0";
		else if(intLeyValue > 50 && intLeyValue <= 60)
			strModificadorLey = "+1";
		else if(intLeyValue > 60 && intLeyValue <= 70)
			strModificadorLey = "+2";
		else
			strModificadorLey = "+5";
		
		
		((TextView)this.findViewById(R.id.lblLeyVicisitud)).setText("Vicisitud " + strModificadorLey);
	}
	
	private void calcularVicisitudPOB()
	{
		int intPobValue;
		String strModificadorPob;
		
		intPobValue = Integer.parseInt(((EditText)this.findViewById(R.id.txtPOB)).getText().toString());
		
		if(intPobValue == 0)
			strModificadorPob = "-10";
		else if(intPobValue > 0 && intPobValue <= 10)
			strModificadorPob = "-5";
		else if(intPobValue > 10 && intPobValue <= 20)
			strModificadorPob = "+0";
		else if(intPobValue > 20 && intPobValue <= 30)
			strModificadorPob = "+1";
		else if(intPobValue > 30 && intPobValue <= 40)
			strModificadorPob = "+3";
		else if(intPobValue > 40 && intPobValue <= 50)
			strModificadorPob = "+1";
		else if(intPobValue > 50 && intPobValue <= 60)
			strModificadorPob = "+0";
		else if(intPobValue > 60 && intPobValue <= 70)
			strModificadorPob = "-5";
		else
			strModificadorPob = "-10";
		
		
		((TextView)this.findViewById(R.id.lblPobVicisitud)).setText("Vicisitud " + strModificadorPob);
	}
	
	

	//A–adir propiedades de defensa
	 public void btnAddDEF_onClick(View v)
	 {
		 this.addPropiedadDefensa(null);
	 }
	 
	 private void addPropiedadDefensa(PropiedadDefensa propiedad)
	 {
		 LinearLayout layDEFProps = (LinearLayout)this.findViewById(R.id.layDEFProps);
		 
		 ControlPropiedadDEF ctrNewProp = new ControlPropiedadDEF(this);
		 ((View)ctrNewProp.findViewById(R.id.btnRemoveDEF)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layDEFProps = (LinearLayout)v2.getParent().getParent();
				layDEFProps.removeView((LinearLayout)v2.getParent());
			}
		 });
		 
		 if(propiedad != null) ctrNewProp.setPropiedad(propiedad);
		 
		 layDEFProps.addView(ctrNewProp);
	 }
	 
	 //A–adir propiedades de influencia
	 public void btnAddINF_onClick(View v)
	 {
		 addPropiedadInfluencia(null);
	 }
	 
	 private void addPropiedadInfluencia(PropiedadInfluencia propiedad)
	 {
		 LinearLayout layINFProps = (LinearLayout)this.findViewById(R.id.layINFProps);
		 
		 ControlPropiedadINF ctrNewProp = new ControlPropiedadINF(this);
		 ((View)ctrNewProp.findViewById(R.id.btnRemoveINF)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layINFProps = (LinearLayout)v2.getParent().getParent();
				layINFProps.removeView((LinearLayout)v2.getParent());
			}
		 });
		 
		 if(propiedad != null)ctrNewProp.setPropiedad(propiedad);
		 
		 layINFProps.addView(ctrNewProp);
	 }
	 
	 //A–adir propiedades de tierra
	 public void btnAddTIE_onClick(View v)
	 {
		 addPropiedadTierras(null);
	 }
	 
	 private void addPropiedadTierras(PropiedadTierras propiedad)
	 {
		 LinearLayout layTIEProps = (LinearLayout)this.findViewById(R.id.layTIEProps);
		 ControlPropiedadTIE ctrNewProp = new ControlPropiedadTIE(this);
		 
		 //Eliminar propiedad tierra
		 ((View)ctrNewProp.findViewById(R.id.btnRemoveTIE)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layTIEProps = (LinearLayout)v2.getParent().getParent().getParent();
				layTIEProps.removeView((LinearLayout)v2.getParent().getParent());
			}
		 });
		 
		 //A–adir caracter’stica tierra
		 ((View)ctrNewProp.findViewById(R.id.btnAddCaracteristica)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v2) {
				//El control tiene un nivel m‡s de anidamiento debido a las caracter’sticas por eso las instrucciones tienen un getParent() m‡s que las anteriores.
				ControlPropiedadTIE layPropiedadTIE = (ControlPropiedadTIE)v2.getParent().getParent().getParent();
				
				layPropiedadTIE.addCaracteristica(null);
				
			}
		});
		
		if(propiedad != null) ctrNewProp.setPropiedad(propiedad);
		layTIEProps.addView(ctrNewProp);
	 }
	 
	 //A–adir propiedades de poder
	 public void btnAddPOD_onClick(View v)
	 {
		 this.addPropiedadPoder(null);
	 }
	 
	 private void addPropiedadPoder(PropiedadPoder propiedad)
	 {
		 
		 LinearLayout layPODProps = (LinearLayout)this.findViewById(R.id.layPODProps);
		 ControlPropiedadPOD ctrNewProp = new ControlPropiedadPOD(this);
		 
		 //Eliminar propiedad tierra
		 ((View)ctrNewProp.findViewById(R.id.btnRemovePOD)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layPODProps = (LinearLayout)v2.getParent().getParent().getParent();
				layPODProps.removeView((LinearLayout)v2.getParent().getParent());
			}
		 });
		 
		 //A–adir caracter’stica tierra
		 ((View)ctrNewProp.findViewById(R.id.btnAddHabilidad)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v2) 
			{
				//El control tiene un nivel m‡s de anidamiento debido a las caracter’sticas por eso las instrucciones tienen un getParent() m‡s que las anteriores.
				ControlPropiedadPOD layPropiedadPOD = (ControlPropiedadPOD)v2.getParent().getParent().getParent();
				
				layPropiedadPOD.addHabilidad(null);
			
			}
		 });
		
		 if(propiedad != null) ctrNewProp.setPropiedad(propiedad);
		 	 
		 layPODProps.addView(ctrNewProp);
	 }
	 

	 //A–adir propiedades de fortuna
	 public void btnAddFOR_onClick(View v)
	 {
		 this.addPropiedadFortuna(null);
	 }
	 
	 
	 private void addPropiedadFortuna(PropiedadFortuna propiedad)
	 {
		 LinearLayout layFORProps = (LinearLayout)this.findViewById(R.id.layFORProps);
		 
		 ControlPropiedadFOR ctrNewProp = new ControlPropiedadFOR(this);
		 ((View)ctrNewProp.findViewById(R.id.btnRemoveFOR)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layINFProps = (LinearLayout)v2.getParent().getParent();
				layINFProps.removeView((LinearLayout)v2.getParent());
			}
		 });
		 
		 if(propiedad != null) ctrNewProp.setPropiedad(propiedad);
		 
		 layFORProps.addView(ctrNewProp);
		
	 }

	//MENU
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) 
	 {
		// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.edit_casa_menu, menu);
			return true;
	 }	
	 
	 public void saveHouse_onClick(MenuItem sender)
	 {
		 try
		 {
			 Casa casa = this.screenToObject();
			 casa.guardarFichero();
		 }
		 catch(IOException ex)
		 {
			 AlertDialog alert = new AlertDialog.Builder(this).create();
			 alert.setMessage(ex.getMessage());
			 alert.show();
		 }
	 }
	 
	 private Casa screenToObject()
	 {
		 Casa casa = new Casa();
		 //ImageView imgAux;
		 EditText txtAux;
		 Spinner spnAux;
		 Spinner spnAux2;
		 LinearLayout layAux;
		 
		 //ESCUDO
		 /*imgAux = (ImageView)this.findViewById(R.id.imgEscudo); 
		 casa.setEscudo(new BitmapDrawable(getResources(), imgAux.getDrawingCache()));*/
		 //SE„OR
		 txtAux = (EditText)this.findViewById(R.id.txtLord);
		 casa.setSe–or(txtAux.getText().toString());
		 //NOMBRE
		 txtAux = (EditText)this.findViewById(R.id.txtNombreCasa);
		 casa.setNombre(txtAux.getText().toString());
		 //REINO
		 spnAux = (Spinner)this.findViewById(R.id.spnReino);
		 casa.setReino(new Reino(spnAux.getSelectedItemPosition()));
		 //LEMA
		 txtAux = (EditText)this.findViewById(R.id.txtLema);
		 casa.setLema(txtAux.getText().toString());
		 
		 //RECURSOS Y PROPIEDADES
		 //Defensa
		 txtAux = (EditText)this.findViewById(R.id.txtDEF);
		 if(!txtAux.getText().toString().equals("")) casa.setDEF(Integer.parseInt(txtAux.getText().toString()));
		 layAux = (LinearLayout)this.findViewById(R.id.layDEFProps);
		 for(int i=0;i<layAux.getChildCount();i++)
		 {
			 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
			 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
			 if(layTemp.getChildAt(0).getContentDescription() != null)
			 {
				LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
				if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_def))
				{
					spnAux = (Spinner)layPropTemp.findViewById(R.id.spnPropiedad);
					txtAux = (EditText)layPropTemp.findViewById(R.id.txtNombrePropiedad);
					
					casa.addPropiedadDefensa(new PropiedadDefensa(spnAux.getSelectedItemPosition(), txtAux.getText().toString()));
				}
				
			 }
		 }
		 //Influencia
		 txtAux = (EditText)this.findViewById(R.id.txtINF);
		 if(!txtAux.getText().toString().equals("")) casa.setINF(Integer.parseInt(txtAux.getText().toString()));
		 layAux = (LinearLayout)this.findViewById(R.id.layINFProps);
		 for(int i=0;i<layAux.getChildCount();i++)
		 {
			 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
			 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
			 if(layTemp.getChildAt(0).getContentDescription() != null)
			 {
				LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
				if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_inf))
				{
					spnAux = (Spinner)layPropTemp.findViewById(R.id.spnPropiedad);
					
					casa.addPropiedadInfluencia(new PropiedadInfluencia(spnAux.getSelectedItemPosition()));
				}
				
			 }
		 }
		 //Tierras
		 txtAux = (EditText)this.findViewById(R.id.txtTIE);
		 if(!txtAux.getText().toString().equals("")) casa.setTIE(Integer.parseInt(txtAux.getText().toString()));
		 layAux = (LinearLayout)this.findViewById(R.id.layTIEProps);
		 for(int i=0;i<layAux.getChildCount();i++)
		 {
			 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
			 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
			 if(layTemp.getChildAt(0).getContentDescription() != null)
			 {
				LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
				if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_ear))
				{
					spnAux = (Spinner)layPropTemp.findViewById(R.id.spnPropiedad);
					PropiedadTierras propTemp = new PropiedadTierras(spnAux.getSelectedItemPosition());
					//Caracter’sticas del terreno
					for(int j=2;j<layPropTemp.getChildCount()-1;j++)
					{
						LinearLayout layTemp2 = (LinearLayout)layPropTemp.getChildAt(j);
						if(layTemp2.getChildAt(0).getContentDescription() != null)
						{
							LinearLayout layCaracTemp = (LinearLayout)layTemp2.getChildAt(0);
							if(layCaracTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_features))
							{
								spnAux = (Spinner)layCaracTemp.findViewById(R.id.spnCaracteristica);
								propTemp.addCaracteristica(new CaracteristicaTerreno(spnAux.getSelectedItemPosition()));
							}
						}
					}
					casa.addPropiedadTierras(propTemp);
				}
				
			 }
		 }
		 //Ley
		 txtAux = (EditText)this.findViewById(R.id.txtLEY);
		 if(!txtAux.getText().toString().equals("")) casa.setLEY(Integer.parseInt(txtAux.getText().toString()));
		 //Poblaci—n
		 txtAux = (EditText)this.findViewById(R.id.txtPOB);
		 if(!txtAux.getText().toString().equals("")) casa.setPOB(Integer.parseInt(txtAux.getText().toString()));
		 //Poder
		 txtAux = (EditText)this.findViewById(R.id.txtPOD);
		 if(!txtAux.getText().toString().equals("")) casa.setPOD(Integer.parseInt(txtAux.getText().toString()));
		 layAux = (LinearLayout)this.findViewById(R.id.layPODProps);
		 for(int i=0;i<layAux.getChildCount();i++)
		 {
			 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
			 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
			 if(layTemp.getChildAt(0).getContentDescription() != null)
			 {
				LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
				if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_pow))
				{
					spnAux = (Spinner)layPropTemp.findViewById(R.id.spnUnidad);
					spnAux2 = (Spinner)layPropTemp.findViewById(R.id.spnEntrenamiento);
					PropiedadPoder propTemp = new PropiedadPoder(spnAux.getSelectedItemPosition(), spnAux2.getSelectedItemPosition());
					//Habilidades unidad
					for(int j=2;j<layPropTemp.getChildCount()-1;j++)
					{
						LinearLayout layTemp2 = (LinearLayout)layPropTemp.getChildAt(j);
						if(layTemp2.getChildAt(0).getContentDescription() != null)
						{
							LinearLayout layCaracTemp = (LinearLayout)layTemp2.getChildAt(0);
							if(layCaracTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_abilities))
							{
								spnAux = (Spinner)layCaracTemp.findViewById(R.id.spnHabilidad);
								txtAux = (EditText)layCaracTemp.findViewById(R.id.txtNivelHabilidad);
								if(!txtAux.getText().toString().equals("")) propTemp.addHabilidad((new Habilidad(spnAux.getSelectedItemPosition(), Integer.parseInt(txtAux.getText().toString()))));
							}
						}
					}
					casa.addPropiedadPoder(propTemp);
				}
				
			 }
		 }
		 //Fortuna
		 txtAux = (EditText)this.findViewById(R.id.txtFOR);
		 if(!txtAux.getText().toString().equals("")) casa.setFOR(Integer.parseInt(txtAux.getText().toString()));
		 layAux = (LinearLayout)this.findViewById(R.id.layFORProps);
		 for(int i=0;i<layAux.getChildCount();i++)
		 {
			 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
			 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
			 if(layTemp.getChildAt(0).getContentDescription() != null)
			 {
				LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
				if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_for))
				{
					spnAux = (Spinner)layPropTemp.findViewById(R.id.spnPropiedad);
					
					casa.addPropiedadFortuna(new PropiedadFortuna(spnAux.getSelectedItemPosition()));
				}
			 }
		 }
		 
		 //TODO: Historia y vicisitudes
				
		 return casa;
	 }
	 
	 private void objectToScreen(Casa casa)
	 {
		 //CAMPOS
		 //Nombre
		 ((EditText)this.findViewById(R.id.txtNombreCasa)).setText(casa.getNombre());
		 //Reino
		 ((Spinner)this.findViewById(R.id.spnReino)).setSelection(casa.getReino().getId());
		 //Se–or
		 ((EditText)this.findViewById(R.id.txtLord)).setText(casa.getSe–or());
		 //Lema
		 ((EditText)this.findViewById(R.id.txtLema)).setText(casa.getLema());
		 
		 //RECURSOS Y PROPIEDADES
		 //Defensa
		 ((EditText)this.findViewById(R.id.txtDEF)).setText(new Integer(casa.getDEF()).toString());
		 for(PropiedadDefensa propDef : casa.getPropiedadesDefensa())
			 this.addPropiedadDefensa(propDef);
		 
		 //Influencia
		 ((EditText)this.findViewById(R.id.txtINF)).setText(new Integer(casa.getINF()).toString());
		 for(PropiedadInfluencia propInf : casa.getPropiedadesInfluencia())
			 this.addPropiedadInfluencia(propInf);
		 
		 //Tierras
		 ((EditText)this.findViewById(R.id.txtTIE)).setText(new Integer(casa.getTIE()).toString());
		 for(PropiedadTierras propTie : casa.getPropiedadesTierras())
			 this.addPropiedadTierras(propTie);
		 
		 //Ley
		 ((EditText)this.findViewById(R.id.txtLEY)).setText(new Integer(casa.getLEY()).toString());
		 this.calcularVicisitudLEY();
		 
		 //Poblacion
		 ((EditText)this.findViewById(R.id.txtPOB)).setText(new Integer(casa.getPOB()).toString());
		 this.calcularVicisitudPOB();
		 
		 //Poder
		 ((EditText)this.findViewById(R.id.txtPOD)).setText(new Integer(casa.getPOD()).toString());
		 for(PropiedadPoder propiedad : casa.getPropiedadesPoder())
			 this.addPropiedadPoder(propiedad);
		 
		 //Fortuna
		 ((EditText)this.findViewById(R.id.txtFOR)).setText(new Integer(casa.getFOR()).toString());
		 for(PropiedadFortuna propiedad : casa.getPropiedadesFortuna())
			 this.addPropiedadFortuna(propiedad);
		 
		 
		 
		 
	 }
}

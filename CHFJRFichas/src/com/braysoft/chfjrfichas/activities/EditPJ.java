package com.braysoft.chfjrfichas.activities;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.braysoft.chfjrfichas.App;
import com.braysoft.chfjrfichas.R;
import com.braysoft.chfjrfichas.controls.ControlBeneficios;
import com.braysoft.chfjrfichas.controls.ControlDefectos;
import com.braysoft.chfjrfichas.controls.ControlHabilidad;
import com.braysoft.chfjrfichas.data.Beneficio;
import com.braysoft.chfjrfichas.data.Defecto;
import com.braysoft.chfjrfichas.data.Especializacion;
import com.braysoft.chfjrfichas.data.Habilidad;
import com.braysoft.chfjrfichas.data.Personaje;

public class EditPJ extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_personaje);
		
		Bundle b = this.getIntent().getExtras();
		if(b!=null && b.containsKey(App.KEY_PJ))
		{
			Personaje pj = (Personaje) b.getSerializable(App.KEY_PJ);
			if(pj != null) this.objectToScreen(pj);
		}
	}
	
	 

	@Override
	 public boolean onCreateOptionsMenu(Menu menu) 
	 {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.edit_personaje_menu, menu);
			return true;
	 }
	 
	 
	 public void savePJ_onClick(MenuItem item)
	 {
		 try
		 {
			 Personaje personaje = this.screenToObject();
			 personaje.guardarFichero();
		 }
		 catch(IOException ex)
		 {
			 AlertDialog alert = new AlertDialog.Builder(this).create();
			 alert.setMessage(ex.getMessage());
			 alert.show();
		 }
	 }
	 
	 

	public void btnAddHabilidad_onClick(View v)
	 {
		 addHabilidad(null);
	 }
	 
	 private void addHabilidad(Habilidad habilidad)
	 {
		 
		 LinearLayout layHabilidades = (LinearLayout)this.findViewById(R.id.layHabilidades);
		 ControlHabilidad ctrNewProp = new ControlHabilidad(this,false);
		 
		 //Eliminar Habilidad
		 ((View)ctrNewProp.findViewById(R.id.btnRemoveHabilidad)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layHabilidad = (LinearLayout)v2.getParent().getParent().getParent().getParent();
				layHabilidad.removeView((LinearLayout)v2.getParent().getParent().getParent());
			}
		 });
		 
		 //A–adir Especializacion
		 ((View)ctrNewProp.findViewById(R.id.btnAddEspecializacion)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v2) 
			{
				//El control tiene un nivel m‡s de anidamiento debido a las caracter’sticas por eso las instrucciones tienen un getParent() m‡s que las anteriores.
				ControlHabilidad layHabilidad = (ControlHabilidad)v2.getParent().getParent().getParent();
				
				layHabilidad.addEspecializacion(null);
			
			}
		 });
		
		 if(habilidad != null) ctrNewProp.setHabilidad(habilidad);
		 	 
		 layHabilidades.addView(ctrNewProp);
	 }
	 
	 public void btnAddBeneficio_onClick(View v)
	 {
		 addBeneficio(null);
	 }
	 
	 private void addBeneficio(Beneficio beneficio)
	 {
		 LinearLayout layBenef = (LinearLayout)this.findViewById(R.id.layBeneficios);	 
		 ControlBeneficios ctrNewBene = new ControlBeneficios(this);
		 
		 ((View)ctrNewBene.findViewById(R.id.btnRemoveBeneficio)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layBeneficios = (LinearLayout)v2.getParent().getParent();
				layBeneficios.removeView((LinearLayout)v2.getParent());
			}
		 });
		 
		 if(beneficio != null)ctrNewBene.setBeneficio(beneficio);
		 
		 layBenef.addView(ctrNewBene);
	 }
	 
	 public void btnAddDefecto_onClick(View v)
	 {
		 addDefecto(null);
	 }
	 
	 private void addDefecto(Defecto defecto)
	 {
		 LinearLayout layDefec = (LinearLayout)this.findViewById(R.id.layDefectos);
		 ControlDefectos ctrNewdefec = new ControlDefectos(this);
		 
		 ((View)ctrNewdefec.findViewById(R.id.btnRemoveDefecto)).setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v2) {
				LinearLayout layDefectos = (LinearLayout)v2.getParent().getParent();
				layDefectos.removeView((LinearLayout)v2.getParent());
			}
		 });
		 
		 if(defecto != null)ctrNewdefec.setDefecto(defecto);
		 
		 layDefec.addView(ctrNewdefec);
	 }
	 
	 
	 private Personaje screenToObject() 
	 {
			Personaje pj = new Personaje();
			LinearLayout layAux;
			
			pj.setNombre(((EditText)this.findViewById(R.id.txtNombre)).getText().toString());
			pj.setEdad(Integer.parseInt(((EditText)this.findViewById(R.id.txtEdad)).getText().toString()));
			pj.setSexoID(((Spinner)this.findViewById(R.id.spnSexo)).getSelectedItemPosition());
			pj.setCasa(((EditText)this.findViewById(R.id.txtNombreCasa)).getText().toString());
			pj.setPuntosDestino(Integer.parseInt(((EditText)this.findViewById(R.id.txtDestino)).getText().toString()));
			
			 //Habilidades
			 layAux = (LinearLayout)this.findViewById(R.id.layHabilidades);
			 for(int i=0;i<layAux.getChildCount();i++)
			 {
				 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
				 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
				 if(layTemp.getChildAt(0).getContentDescription() != null)
				 {
					LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
					if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_abilities))
					{
						Habilidad habiTemp = new Habilidad(((Spinner)layPropTemp.findViewById(R.id.spnHabilidad)).getSelectedItemPosition(), Integer.parseInt(((EditText)layPropTemp.findViewById(R.id.txtNivelHabilidad)).getText().toString()));
						//Especializaciones
						for(int j=2;j<layPropTemp.getChildCount();j++)
						{
							LinearLayout layTemp2 = (LinearLayout)layPropTemp.getChildAt(j);
							if(layTemp2.getChildAt(0).getContentDescription() != null)
							{
								LinearLayout layEspecTemp = (LinearLayout)layTemp2.getChildAt(0);
								if(layEspecTemp.getContentDescription().toString() == this.getResources().getString(R.string.str_specialicities))
								{
									if(!((EditText)layEspecTemp.findViewById(R.id.txtNivelEspecializacion)).getText().toString().equals("")) habiTemp.addEspecializacion((new Especializacion(((Spinner)layEspecTemp.findViewById(R.id.spnEspecializacion)).getSelectedItemPosition(), Integer.parseInt(((EditText)layEspecTemp.findViewById(R.id.txtNivelEspecializacion)).getText().toString()))));
								}
							}
						}
						pj.addHabilidad(habiTemp);
					}
					
				 }
			 }
			 
			 //Beneficios
			 layAux = (LinearLayout)this.findViewById(R.id.layBeneficios);
			 for(int i=0;i<layAux.getChildCount();i++)
			 {
				 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
				 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
				 if(layTemp.getChildAt(0).getContentDescription() != null)
				 {
					LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
					if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.beneficios))
					{
						
						pj.addBeneficio(new Beneficio( ((Spinner)layPropTemp.findViewById(R.id.spnBeneficio)).getSelectedItemPosition()));
					}
					
				 }
			 }
			 //Defectos
			 layAux = (LinearLayout)this.findViewById(R.id.layDefectos);
			 for(int i=0;i<layAux.getChildCount();i++)
			 {
				 LinearLayout layTemp = (LinearLayout)layAux.getChildAt(i);
				 //Al agregrar el control a–ade un nivel m‡s de anidaci—n. Tal vez pueda apa–arse esto de otra manera
				 if(layTemp.getChildAt(0).getContentDescription() != null)
				 {
					LinearLayout layPropTemp = (LinearLayout)layTemp.getChildAt(0);
					if(layPropTemp.getContentDescription().toString() == this.getResources().getString(R.string.defectos))
					{
						
						pj.addDefecto(new Defecto( ((Spinner)layPropTemp.findViewById(R.id.spnDefectos)).getSelectedItemPosition()));
					}
					
				 }
			 }
			
			return pj;
	 }
		 
	 private void objectToScreen(Personaje pj) 
	 {
		 ((EditText)this.findViewById(R.id.txtNombre)).setText(pj.getNombre());
		 ((Spinner)this.findViewById(R.id.spnSexo)).setSelection(pj.getSexoID());
		 ((EditText)this.findViewById(R.id.txtEdad)).setText(Integer.valueOf(pj.getEdad()).toString());
		 ((EditText)this.findViewById(R.id.txtNombreCasa)).setText(pj.getCasa());
		 ((EditText)this.findViewById(R.id.txtDestino)).setText(Integer.valueOf(pj.getPuntosDestino()).toString());

		 //Atributos
		 ((TextView)this.findViewById(R.id.lblDefCombate)).setText(Integer.valueOf(pj.getDefensaCombate()).toString());
		 ((TextView)this.findViewById(R.id.lblDefIntriga)).setText(Integer.valueOf(pj.getDefensaIntriga()).toString());
		 ((TextView)this.findViewById(R.id.lblSalud)).setText(Integer.valueOf(pj.getSalud()).toString());
		 ((TextView)this.findViewById(R.id.lblCompostura)).setText(Integer.valueOf(pj.getCompostura()).toString());
		 
		 //Habilidades
		 for(Habilidad habilidad : pj.getHabilidades())
			 this.addHabilidad(habilidad);
		 //Beneficios
		 for(Beneficio beneficio : pj.getBeneficios())
			 this.addBeneficio(beneficio);
		 //Defectos
		 for(Defecto defecto : pj.getDefectos())
			 this.addDefecto(defecto);
	 }

}

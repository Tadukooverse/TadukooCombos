package com.github.tadukoo.combos.ultimatepojo.pojofield;

import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.view.form.field.FormField;

public class UltimatePojoField<Type>{
	
	private final String key;
	private final FormField<Type> formField;
	private final ColumnDefinition columnDef;
	
	protected UltimatePojoField(String key, FormField<Type> formField, ColumnDefinition columnDef){
		this.key = key;
		this.formField = formField;
		this.columnDef = columnDef;
	}
	
	public String getKey(){
		return key;
	}
	
	public FormField<Type> getFormField(){
		return formField;
	}
	
	public ColumnDefinition getColumnDef(){
		return columnDef;
	}
}

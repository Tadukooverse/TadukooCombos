package com.github.tadukoo.combos.ultimatepojo.pojofield;

import com.github.tadukoo.combos.ultimatepojo.UltimatePojo;
import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.util.StringUtil;
import com.github.tadukoo.view.form.field.FormField;

import java.util.ArrayList;
import java.util.List;

/**
 * Ultimate Pojo Field is to be used in {@link UltimatePojo} to have fields that can be used as
 * both a {@link FormField} and a {@link ColumnDefinition} in one field.
 *
 * @param <Type> The type used for the {@link FormField}
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public class UltimatePojoField<Type>{
	
	/**
	 * A builder used to build a {@link UltimatePojoField}. It takes the following parameters:
	 *
	 * <table>
	 *     <caption>Ultimate Pojo Field Parameters</caption>
	 *     <tr>
	 *         <th>Parameter</th>
	 *         <th>Description</th>
	 *         <th>Default or Required</th>
	 *     </tr>
	 *     <tr>
	 *         <td>key</td>
	 *         <td>The key to use for the pojo field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>formField</td>
	 *         <td>The {@link FormField} to use for the pojo field</td>
	 *         <td>Required</td>
	 *     </tr>
	 *     <tr>
	 *         <td>columnDef</td>
	 *         <td>The {@link ColumnDefinition} to use for the pojo field</td>
	 *         <td>Required</td>
	 *     </tr>
	 * </table>
	 *
	 * @param <Type> The Type used in the {@link FormField}
	 * @author Logan Ferree (Tadukoo)
	 * @version Alpha v.0.1
	 */
	public static class UltimatePojoFieldBuilder<Type>{
		/** The key to use for the pojo field */
		private String key = null;
		/** The {@link FormField} to use for the pojo field */
		private FormField<Type> formField = null;
		/** The {@link ColumnDefinition} to use for the pojo field */
		private ColumnDefinition columnDef = null;
		
		/**
		 * @param key The key to use for the pojo field
		 * @return this, to continue building
		 */
		public UltimatePojoFieldBuilder<Type> key(String key){
			this.key = key;
			return this;
		}
		
		/**
		 * @param formField The {@link FormField} to use for the pojo field
		 * @return this, to continue building
		 */
		public UltimatePojoFieldBuilder<Type> formField(FormField<Type> formField){
			this.formField = formField;
			return this;
		}
		
		/**
		 * @param columnDef The {@link ColumnDefinition} to use for the pojo field
		 * @return this, to continue building
		 */
		public UltimatePojoFieldBuilder<Type> columnDef(ColumnDefinition columnDef){
			this.columnDef = columnDef;
			return this;
		}
		
		/**
		 * Checks for any errors in the set parameters and will throw an {@link IllegalArgumentException} if any
		 * errors are encountered
		 */
		private void checkForErrors(){
			List<String> errors = new ArrayList<>();
			
			// key is required
			if(StringUtil.isBlank(key)){
				errors.add("key is required!");
			}
			
			// formField is required
			if(formField == null){
				errors.add("formField is required!");
			}
			
			// columnDef is required
			if(columnDef == null){
				errors.add("columnDef is required!");
			}
			
			// Report any errors
			if(!errors.isEmpty()){
				throw new IllegalArgumentException("Errors encountered in making an UltimatePojoField: \n" +
						StringUtil.buildStringWithNewLines(errors));
			}
		}
		
		/**
		 * Builds a new {@link UltimatePojoField} using the set parameters after checking for any errors
		 *
		 * @return The newly built {@link UltimatePojoField}
		 */
		public UltimatePojoField<Type> build(){
			checkForErrors();
			
			return new UltimatePojoField<>(UltimatePojoFieldType.CUSTOM, key, formField, columnDef);
		}
	}
	
	/** The {@link UltimatePojoFieldType type} of pojo field */
	private final UltimatePojoFieldType type;
	/** The key to use for this pojo field */
	private final String key;
	/** The {@link FormField} to use for this pojo field */
	private final FormField<Type> formField;
	/** The {@link ColumnDefinition} to use for this pojo field */
	private final ColumnDefinition columnDef;
	
	/**
	 * Constructs a new {@link UltimatePojoField}. This can be used in subclasses
	 *
	 * @param type The {@link UltimatePojoFieldType type} of pojo field
	 * @param key The key to use for this pojo field
	 * @param formField The {@link FormField} to use for this pojo field
	 * @param columnDef The {@link ColumnDefinition} to use for this pojo field
	 */
	protected UltimatePojoField(
			UltimatePojoFieldType type, String key, FormField<Type> formField, ColumnDefinition columnDef){
		this.type = type;
		this.key = key;
		this.formField = formField;
		this.columnDef = columnDef;
	}
	
	/**
	 * @param <Type> The Type to use for the builder
	 * @return A {@link UltimatePojoFieldBuilder builder} to use to build a new {@link UltimatePojoField}
	 */
	public static <Type> UltimatePojoFieldBuilder<Type> builder(){
		return new UltimatePojoFieldBuilder<>();
	}
	
	/**
	 * @return The {@link UltimatePojoFieldType type} of pojo field
	 */
	public UltimatePojoFieldType getType(){
		return type;
	}
	
	/**
	 * @return The key to use for this pojo field
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * @return The {@link FormField} to use for this pojo field
	 */
	public FormField<Type> getFormField(){
		return formField;
	}
	
	/**
	 * @return The {@link ColumnDefinition} to use for this pojo field
	 */
	public ColumnDefinition getColumnDef(){
		return columnDef;
	}
}

package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.combos.ultimatepojo.pojofield.UltimatePojoField;
import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.view.form.SimpleForm;
import com.github.tadukoo.view.form.field.FormField;

import java.util.Map;
import java.util.Set;

/**
 * The Ultimate Simple Pojo - combining the powers of the {@link UltimatePojo} with those of
 * {@link SimpleForm} to allow using {@link UltimatePojoField UltimatePojoFields}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public interface UltimateSimplePojo extends UltimatePojo, SimpleForm{
	
	/**
	 * @return A Map of the {@link UltimatePojoField pojo fields} for this pojo
	 */
	Map<String, UltimatePojoField<?>> getPojoFieldMap();
	
	/**
	 * Adds the given {@link UltimatePojoField} to the {@link #getPojoFieldMap() pojoFieldMap}, along with
	 * adding the {@link FormField} and {@link ColumnDefinition} from it into their proper maps
	 *
	 * @param pojoField The {@link UltimatePojoField} to be added to this {@link UltimateSimplePojo}
	 */
	default void addPojoField(UltimatePojoField<?> pojoField){
		getPojoFieldMap().put(pojoField.getKey(), pojoField);
		addField(pojoField.getFormField());
		addColumnDef(pojoField.getColumnDef());
	}
	
	/**
	 * This method should be called by the constructor to set the default {@link UltimatePojoField UltimatePojoFields}
	 * to be used in this {@link UltimateSimplePojo} using the {@link #addPojoField(UltimatePojoField)} method.
	 *
	 * @throws Throwable If anything goes wrong in creating the fields
	 */
	void setDefaultPojoFields() throws Throwable;
	
	/**
	 * @return The keys of the {@link #getPojoFieldMap() pojoFieldMap}
	 */
	default Set<String> getPojoFieldKeys(){
		return getPojoFieldMap().keySet();
	}
	
	/**
	 * @param key The key for the {@link UltimatePojoField} to retrieve
	 * @return The {@link UltimatePojoField} found with the given key
	 */
	default UltimatePojoField<?> getPojoFieldByKey(String key){
		return getPojoFieldMap().get(key);
	}
}

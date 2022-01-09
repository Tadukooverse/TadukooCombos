package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.combos.ultimatepojo.pojofield.UltimatePojoField;
import com.github.tadukoo.database.mysql.pojo.SubPojoDefinition;
import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.database.mysql.syntax.ForeignKeyConstraint;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.AbstractSimpleForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Ultimate Simple Pojo is the default implementation of {@link UltimateSimplePojo}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public abstract class AbstractUltimateSimplePojo extends AbstractSimpleForm implements UltimateSimplePojo{
	/** The Map of {@link ColumnDefinition column definitions} for this pojo */
	private final Map<String, ColumnDefinition> columnDefs;
	/** The Map of {@link SubPojoDefinition subPojo definitions} for this pojo */
	private final Map<String, SubPojoDefinition> subPojoDefs;
	/** The List of any {@link ForeignKeyConstraint foreign keys} present for this pojo */
	private final List<ForeignKeyConstraint> foreignKeys;
	/** The Map of {@link UltimatePojoField pojo fields} for this pojo */
	private final Map<String, UltimatePojoField<?>> pojoFieldMap;
	
	/**
	 * Constructs a new {@link AbstractUltimateSimplePojo}. Sets the values map to a new empty HashMap, and
	 * initializes the other Maps and Lists involved in this pojo to be empty.
	 * <br>
	 * {@link #setDefaultFields()} and {@link #createComponents()} are then called, along with
	 * {@link #setDefaultColumnDefs()} and {@link #setDefaultPojoFields()}
	 *
	 * @throws Throwable If anything goes wrong in creating components
	 */
	protected AbstractUltimateSimplePojo() throws Throwable{
		super(new HashMap<>());
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		pojoFieldMap = new HashMap<>();
		setDefaultColumnDefs();
		setDefaultPojoFields();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateSimplePojo}. Sets the values map to the passed in map (used for forms
	 * that need the default values while running {@link #setDefaultFields()}), and initializes the other Maps and
	 * Lists involved in this pojo to be empty.
	 * <br>
	 * {@link #setDefaultFields()} and {@link #createComponents()} are then called, along with
	 * {@link #setDefaultColumnDefs()} and {@link #setDefaultPojoFields()}
	 *
	 * @param defaultValues The default values map, used for forms that need them during {@link #setDefaultFields()}
	 * @throws Throwable If anything goes wrong in creating components
	 */
	protected AbstractUltimateSimplePojo(Map<String, Object> defaultValues) throws Throwable{
		super(defaultValues);
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		pojoFieldMap = new HashMap<>();
		setDefaultColumnDefs();
		setDefaultPojoFields();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateSimplePojo}. Sets the values map to the map from the given pojo (used
	 * for forms that need the default values while running {@link #setDefaultFields()}), and initializes the other
	 * Maps and Lists involved in this pojo to be empty.
	 * <br>
	 * {@link #setDefaultFields()} and {@link #createComponents()} are then called, along with
	 * {@link #setDefaultColumnDefs()} and {@link #setDefaultPojoFields()}
	 *
	 * @param pojo The pojo containing a map, to be used for default values for forms
	 *             that need them during {@link #setDefaultFields()}
	 * @throws Throwable If anything goes wrong in creating components
	 */
	protected AbstractUltimateSimplePojo(MappedPojo pojo) throws Throwable{
		super(pojo);
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		pojoFieldMap = new HashMap<>();
		setDefaultColumnDefs();
		setDefaultPojoFields();
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, ColumnDefinition> getColumnDefs(){
		return columnDefs;
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, SubPojoDefinition> getSubPojoDefs(){
		return subPojoDefs;
	}
	
	/** {@inheritDoc} */
	@Override
	public List<ForeignKeyConstraint> getForeignKeys(){
		return foreignKeys;
	}
	
	/** {@inheritDoc} */
	@Override
	public Map<String, UltimatePojoField<?>> getPojoFieldMap(){
		return pojoFieldMap;
	}
	
	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("RedundantThrows")
	public void setDefaultFields() throws Throwable{
		// Default to doing nothing, can be overridden by subclasses
	}
	
	/** {@inheritDoc} */
	@Override
	public void setDefaultColumnDefs(){
		// Default to doing nothing, can be overridden by subclasses
	}
}

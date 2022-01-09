package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.combos.ultimatepojo.pojofield.UltimatePojoField;
import com.github.tadukoo.database.mysql.pojo.SubPojoDefinition;
import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.database.mysql.syntax.ForeignKeyConstraint;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.main.AbstractSimpleMainForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Ultimate Simple Main Pojo is the default implementation of {@link AbstractUltimateSimpleMainPojo}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public abstract class AbstractUltimateSimpleMainPojo extends AbstractSimpleMainForm implements UltimateSimpleMainPojo{
	/** The Map of {@link ColumnDefinition column definitions} for this pojo */
	private final Map<String, ColumnDefinition> columnDefs;
	/** The Map of {@link SubPojoDefinition subPojo definitions} for this pojo */
	private final Map<String, SubPojoDefinition> subPojoDefs;
	/** The List of any {@link ForeignKeyConstraint foreign keys} present for this pojo */
	private final List<ForeignKeyConstraint> foreignKeys;
	/** The Map of {@link UltimatePojoField pojo fields} for this pojo */
	private final Map<String, UltimatePojoField<?>> pojoFieldMap;
	
	/**
	 * Constructs a new {@link AbstractUltimateSimpleMainPojo} using an empty HashMap for the values map, and
	 * initializes other Maps and Lists involved in this pojo to be empty.
	 * <br>
	 * This also calls {@link #setDefaultFields()}, {@link #setDefaultColumnDefs()}, and {@link #setDefaultPojoFields()}
	 *
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractUltimateSimpleMainPojo() throws Throwable{
		super(new HashMap<>());
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		pojoFieldMap = new HashMap<>();
		setDefaultColumnDefs();
		setDefaultPojoFields();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateSimpleMainPojo} using the given default values (which are set so they
	 * can be used in {@link #setDefaultFields()}), and initializes other Maps and Lists involved in this pojo to
	 * be empty.
	 * <br>
	 * This also calls {@link #setDefaultFields()}, {@link #setDefaultColumnDefs()}, and {@link #setDefaultPojoFields()}
	 *
	 * @param defaultValues The Map of default values for this {@link UltimateSimpleMainPojo}
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractUltimateSimpleMainPojo(Map<String, Object> defaultValues) throws Throwable{
		super(defaultValues);
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		pojoFieldMap = new HashMap<>();
		setDefaultColumnDefs();
		setDefaultPojoFields();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateSimpleMainPojo} using the given {@link MappedPojo} for the default
	 * values (which are set so they can be used in {@link #setDefaultFields()}), and initializes other Maps and Lists
	 * involved in this pojo to be empty.
	 * <br>
	 * This also calls {@link #setDefaultFields()}, {@link #setDefaultColumnDefs()}, and {@link #setDefaultPojoFields()}
	 *
	 * @param pojo The {@link MappedPojo} to use for default fields
	 * @throws Throwable If anything goes wrong (in setting default fields or creating components)
	 */
	protected AbstractUltimateSimpleMainPojo(MappedPojo pojo) throws Throwable{
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

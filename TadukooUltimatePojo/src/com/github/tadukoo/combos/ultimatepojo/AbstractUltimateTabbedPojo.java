package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.database.mysql.pojo.SubPojoDefinition;
import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.database.mysql.syntax.ForeignKeyConstraint;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.tabbed.AbstractTabbedForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Ultimate Tabbed Pojo is the default implementation of {@link UltimateTabbedPojo}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public abstract class AbstractUltimateTabbedPojo extends AbstractTabbedForm implements UltimateTabbedPojo{
	/** The Map of {@link ColumnDefinition column definitions} for this pojo */
	private final Map<String, ColumnDefinition> columnDefs;
	/** The Map of {@link SubPojoDefinition subPojo definitions} for this pojo */
	private final Map<String, SubPojoDefinition> subPojoDefs;
	/** The List of any {@link ForeignKeyConstraint foreign keys} present for this pojo */
	private final List<ForeignKeyConstraint> foreignKeys;
	
	/**
	 * Constructs a new {@link AbstractUltimateTabbedPojo}. Sets the values map to a new empty HashMap and
	 * initializes the other Maps and Lists involved in this pojo to be empty.
	 * <br>
	 * {@link #configureSettings()} and {@link #setDefaultTabs()} are then called, along with
	 * {@link #setDefaultColumnDefs()}
	 *
	 * @throws Throwable If anything goes wrong in creating tabs
	 */
	protected AbstractUltimateTabbedPojo() throws Throwable{
		super(new HashMap<>());
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		setDefaultColumnDefs();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateTabbedPojo}. Sets the values map to the passed in map (used for tabs
	 * that need the default values while running {@link #setDefaultTabs()}), and initializes the other Maps and Lists
	 * involved in this pojo to be empty.
	 * <br>
	 * {@link #configureSettings()} and {@link #setDefaultTabs()} are then called, along with
	 * {@link #setDefaultColumnDefs()}
	 *
	 * @param defaultValues The default values map, used for tabs that need them during {@link #setDefaultTabs()}
	 * @throws Throwable If anything goes wrong in creating tabs
	 */
	protected AbstractUltimateTabbedPojo(Map<String, Object> defaultValues) throws Throwable{
		super(defaultValues);
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		setDefaultColumnDefs();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateTabbedPojo}. Sets the values map to the map from the given pojo (used
	 * for tabs that need the default values while running {@link #setDefaultTabs()}), and initializes the other Maps
	 * and Lists involved in this pojo to be empty.
	 * <br>
	 * {@link #configureSettings()} and {@link #setDefaultTabs()} are then called, along with
	 * {@link #setDefaultColumnDefs()}
	 *
	 * @param pojo The pojo containing a map, to be used for default values for tabs
	 *             that need them during {@link #setDefaultTabs()}
	 * @throws Throwable If anything goes wrong in creating tabs
	 */
	protected AbstractUltimateTabbedPojo(MappedPojo pojo) throws Throwable{
		super(pojo);
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		setDefaultColumnDefs();
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
	public void setDefaultColumnDefs(){
		// Default to doing nothing, can be overridden by subclasses
		// Do nothing because we may have no column defs as a tabbed pojo
	}
}

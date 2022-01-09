package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.database.mysql.pojo.SubPojoDefinition;
import com.github.tadukoo.database.mysql.syntax.ColumnDefinition;
import com.github.tadukoo.database.mysql.syntax.ForeignKeyConstraint;
import com.github.tadukoo.util.pojo.MappedPojo;
import com.github.tadukoo.view.form.main.AbstractTabbedMainForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Ultimate Tabbed Main Pojo is the default implementation of {@link UltimateTabbedMainPojo}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public abstract class AbstractUltimateTabbedMainPojo extends AbstractTabbedMainForm implements UltimateTabbedMainPojo{
	/** The Map of {@link ColumnDefinition column definitions} for this pojo */
	private final Map<String, ColumnDefinition> columnDefs;
	/** The Map of {@link SubPojoDefinition subPojo definitions} for this pojo */
	private final Map<String, SubPojoDefinition> subPojoDefs;
	/** The List of any {@link ForeignKeyConstraint foreign keys} present for this pojo */
	private final List<ForeignKeyConstraint> foreignKeys;
	
	/**
	 * Constructs a new {@link AbstractUltimateTabbedMainPojo} setting the values map to a new empty HashMap and
	 * initializes other Maps and Lists involved in this pojo to be empty.
	 * <br>
	 * Also calls {@link #configureSettings()}, {@link #configureFrameSettings()}, {@link #setDefaultTabs()}, and
	 * {@link #setDefaultColumnDefs()}
	 *
	 * @throws Throwable If anything goes wrong in {@link #setDefaultTabs()}
	 */
	protected AbstractUltimateTabbedMainPojo() throws Throwable{
		super(new HashMap<>());
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		setDefaultColumnDefs();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateTabbedMainPojo} using the given default values (which are set to be
	 * used in the {@link #setDefaultTabs()} method as needed) and initializes other Maps and Lists involved in this
	 * pojo to be empty.
	 * <br>
	 * Also calls {@link #configureSettings()}, {@link #configureFrameSettings()}, {@link #setDefaultTabs()}, and
	 * {@link #setDefaultColumnDefs()}
	 *
	 * @param defaultValues The Map of default values for this Tabbed Main Form
	 * @throws Throwable If anything goes wrong (in {@link #setDefaultTabs()})
	 */
	protected AbstractUltimateTabbedMainPojo(Map<String, Object> defaultValues) throws Throwable{
		super(defaultValues);
		columnDefs = new HashMap<>();
		subPojoDefs = new HashMap<>();
		foreignKeys = new ArrayList<>();
		setDefaultColumnDefs();
	}
	
	/**
	 * Constructs a new {@link AbstractUltimateTabbedMainPojo} using the given {@link MappedPojo} for default values
	 * (which are set to be used in the {@link #setDefaultTabs()} method as needed) and initializes other Maps and
	 * Lists involved in this pojo to be empty.
	 * <br>
	 * Also calls {@link #configureSettings()}, {@link #configureFrameSettings()}, {@link #setDefaultTabs()}, and
	 * {@link #setDefaultColumnDefs()}
	 *
	 * @param pojo The {@link MappedPojo} to use for default values
	 * @throws Throwable If anything goes wrong (in {@link #setDefaultTabs()})
	 */
	protected AbstractUltimateTabbedMainPojo(MappedPojo pojo) throws Throwable{
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

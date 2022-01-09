package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.database.mysql.pojo.SubPojoDefinition;
import com.github.tadukoo.database.mysql.syntax.ForeignKeyConstraint;
import com.github.tadukoo.view.form.tabbed.TabLabelType;
import com.github.tadukoo.view.form.tabbed.TabbedForm;

import java.awt.Component;

/**
 * The Ultimate Tabbed Pojo - combining the powers of the {@link UltimatePojo} with those of
 * {@link TabbedForm} to allow for using {@link UltimatePojo UltimatePojos} as tabs
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public interface UltimateTabbedPojo extends UltimatePojo, TabbedForm{
	
	/**
	 * Adds the given {@link UltimatePojo} tab to this {@link UltimateTabbedPojo}, using the default tab label type from
	 * {@link #defaultTabLabelType()} with the given title, and also adds it as a subPojo to this pojo
	 *
	 * @param title The title for the tab, also used as the key
	 * @param tab The {@link UltimatePojo} tab to be added
	 * @param subPojoDef The {@link SubPojoDefinition} to use for the given tab
	 * @param foreignKey The {@link ForeignKeyConstraint foreign key} for the subPojo (to use when setting up the table)
	 */
	default void addTabSubPojo(
			String title, UltimatePojo tab, SubPojoDefinition subPojoDef, ForeignKeyConstraint foreignKey){
		addTab(title, tab);
		addSubPojo(subPojoDef, tab, foreignKey);
	}
	
	/**
	 * Adds the given {@link UltimatePojo} tab to this Tabbed Form, using the given {@link TabLabelType} with
	 * the given title, and also adds it as a subPojo to this pojo
	 *
	 * @param title The title for the tab, also used as the key
	 * @param tab The {@link UltimatePojo} tab to be added
	 * @param subPojoDef The {@link SubPojoDefinition} to use for the given tab
	 * @param foreignKey The {@link ForeignKeyConstraint foreign key} for the subPojo (to use when setting up the table)
	 * @param tabLabelType The {@link TabLabelType} to be used to create the tab's label
	 */
	default void addTabSubPojo(
			String title, UltimatePojo tab, SubPojoDefinition subPojoDef, ForeignKeyConstraint foreignKey,
			TabLabelType tabLabelType){
		addTab(title, tab, tabLabelType);
		addSubPojo(subPojoDef, tab, foreignKey);
	}
	
	/**
	 * Adds the given {@link UltimatePojo} tab to this Tabbed Form, using the given tab label component
	 * and the given title, and also adds it as a subPojo to this pojo
	 *
	 * @param title The title for the tab, also used as the key
	 * @param tab The {@link UltimatePojo} tab to be added
	 * @param subPojoDef The {@link SubPojoDefinition} to use for the given tab
	 * @param foreignKey The {@link ForeignKeyConstraint foreign key} for the subPojo (to use when setting up the table)
	 * @param customTabLabel The component to use for the tab's label
	 */
	default void addTabSubPojo(
			String title, UltimatePojo tab, SubPojoDefinition subPojoDef, ForeignKeyConstraint foreignKey,
			Component customTabLabel){
		addTab(title, tab, customTabLabel);
		addSubPojo(subPojoDef, tab, foreignKey);
	}
}

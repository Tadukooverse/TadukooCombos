package com.github.tadukoo.combos.ultimatepojo;

import com.github.tadukoo.database.mysql.Database;
import com.github.tadukoo.database.mysql.pojo.DatabasePojo;
import com.github.tadukoo.parsing.json.JSONConverter;
import com.github.tadukoo.parsing.json.OrderedJSONClass;
import com.github.tadukoo.util.CollectionUtil;
import com.github.tadukoo.view.form.Form;

import java.sql.SQLException;
import java.util.Collection;

/**
 * The Ultimate Pojo - combining the JSON parsing power of {@link OrderedJSONClass}, the
 * viewing power of {@link Form}, and the {@link Database} power of {@link DatabasePojo}
 *
 * @author Logan Ferree (Tadukoo)
 * @version Alpha v.0.1
 */
public interface UltimatePojo extends OrderedJSONClass, Form, DatabasePojo{
	
	/** {@inheritDoc} */
	@Override
	default String convertToJSON(JSONConverter converter){
		// Pass in ordered keys instead of random(?) order keys (if we have them)
		Collection<String> keys = getKeyOrder();
		if(CollectionUtil.isBlank(keys)){
			keys = getKeys();
		}
		return buildJSON(keys, converter);
	}
	
	/**
	 * Updates the values in the form from the Component values and stores the values
	 * in the given {@link Database}
	 *
	 * @param database The {@link Database} to store values in
	 * @param storeSubPojos Whether to store values from subPojos or not
	 * @throws SQLException If anything goes wrong in storing values in the {@link Database}
	 */
	default void saveAndStoreValues(Database database, boolean storeSubPojos) throws SQLException{
		saveValues();
		storeValues(database, storeSubPojos);
	}
}

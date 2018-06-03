/*package utils;

import org.apache.johnzon.mapper.Converter;

import model.BudgetTable;

public class TableAdapter implements Converter<BudgetTable>{

	@Override
	public BudgetTable fromString(String arg0) {
		BudgetTable table = new BudgetTable(); 
		table.setId( Long.valueOf( arg0 ) ); 
        return table; 
	}

	@Override
	public String toString(BudgetTable arg0) {
		return String.valueOf(arg0.getId()); 
	}

}
*/
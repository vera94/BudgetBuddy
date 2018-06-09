package utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.BudgetItem;

public class CSVGenerator {
	private static final String CSV_SEPARATOR = ",";

	public static File writeToCSV(ArrayList<BudgetItem> items) {
		try {
			File file = new File("results.txt");
			PrintWriter pw = new PrintWriter(file, "UTF-8");
			StringBuilder columnNames = new StringBuilder();
			columnNames.append("ID");
			columnNames.append(CSV_SEPARATOR);
			columnNames.append("NAME");
			columnNames.append(CSV_SEPARATOR);
			columnNames.append("DATE");
			columnNames.append(CSV_SEPARATOR);
			columnNames.append("VALUE");
			columnNames.append(CSV_SEPARATOR);
			columnNames.append("CATEGORY");
			columnNames.append(CSV_SEPARATOR);
			columnNames.append("TYPE");
			columnNames.append('\n');
			pw.write(columnNames.toString());
			for (BudgetItem item : items) {
				StringBuilder oneLine = new StringBuilder();
				oneLine.append(item.getId());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(item.getName());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(item.getDate());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(item.getValue());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(item.getCategory().getName());
				oneLine.append(CSV_SEPARATOR);
				oneLine.append(item.getType());
				oneLine.append('\n');
				pw.write(oneLine.toString());
			}
			pw.flush();
			pw.close();
			return file;
		} catch (Exception e) {
		}
		return null;
		
	}
}

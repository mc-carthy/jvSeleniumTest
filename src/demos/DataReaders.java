package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
//		readCSV();
		readXLS();
	}
	
	public static void readCSV() {
		String filename = "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\UserAccounts.csv";
		List<String[]> records = utilities.CSV.get(filename);
		
		for (String[] record : records) {
			System.out.println("\nNEW RECORD");
			for (String field : record)
			{
				System.out.println(field);		
			}
		}
	}
	
	public static void readXLS() {
		String filename = "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\UserLogin.xls";
		String[][] data = utilities.Excel.get(filename);
		
		for (String[] record : data) {
			System.out.println("\nNEW RECORD");	
			for (String field : record) {
				System.out.println(field);				
			}
		}
	}

}

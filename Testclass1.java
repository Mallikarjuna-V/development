package org.bnymellon.efm.bn.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Testclass1 {

	public static void main(String[] args) throws IOException {

		/**     String[] tableNames = new String[]{"<table1>","table2"};
		 *String abc;

		 *String abc = "<column1>value</column1>";
		 *String[] columnNames = dogetValues(abc);

		 *String sql = "insert into employee values( "+columnNames[1]+" = '"+columnNames[0]+"')";
		 * System.out.println(sql);
		 * /

		/**
		 *String sql = doGetInsertQuery();
		 *System.out.println(sql);
		 */
		String[] arr = doReadFileAndStoreItInArray();
		/*for(int i = 0;i < arr.length ;i++){
			System.out.println("hiii "+arr[i]);
		}*/

		doInsertIntoTable(arr);

	}
	private static void doInsertIntoTable(String[] arr) {
		String[] tables = new String[]{"Table1","Table2","Table3"};
		String[] eachTableData = new String[]{};
		int min = 0;
		int max = 0;
		for(int i = max;i<arr.length;i++){
			for(int j = 0;j<tables.length;j++){
				if(arr[i].contains(tables[j])){
					if(arr[i].equals("<"+tables[j]+">")){
						min = i;
					}else if(arr[i].equals("</"+tables[j]+">")){
						max = i;
						eachTableData = new String[max-min+1];
						for(int k=0,l=min;k<=max-min && l<=max;k++,l++){
							eachTableData[k]=arr[l];
						}
						for(int m =0;m<eachTableData.length;m++){
							System.out.println(m+"--"+eachTableData[m]);
						}
						String sql = doCreateInsertQuery(eachTableData);
						//Insert Procedure
						//connection(sql);
					}
				}
			}
		}
	}
	public static String[] dogetValues(String abc){
		String[] split = null;
		split = abc.split(">");
		for(int i =0;i<split.length;i++) {
			if(i == 1) {
				split = split[i].split("</");
			}
		}
		return split;
	}

	public static String doCreateInsertQuery(String[] split){
		String sql = "insert into ";
		String tableName = "";
		for(int i =0;i<split.length;i++) {
			if(i == 0) {
				int length = split[0].length();
				tableName = split[0].substring(1, length-1);
				sql = sql + tableName +" values (";
			} else if(i < split.length-1) {
				String[] param = dogetValues(split[i]);
				sql = sql + " '"+param[0]+"',";
				if(i == split.length-2) {
					sql= sql.substring(0, sql.length()-1) + " )";
				}
			}
		}
		System.out.println(sql);
		return sql;
	}

	public static String[] doReadFileAndStoreItInArray() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("data.xml"));
		String str;

		List<String> list = new ArrayList<String>();
		while((str = in.readLine()) != null){
			list.add(str);
		}

		String[] stringArr = list.toArray(new String[0]);

		for(int i =0;i<stringArr.length;i++) {
			stringArr[i]=stringArr[i].trim();
		}
		return stringArr;
	}
}

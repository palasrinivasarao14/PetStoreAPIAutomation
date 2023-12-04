package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="data")
	public String[][] getAllData() throws IOException{
		
		String path = System.getProperty("user.dir")+"//TestData//UsersData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("sheet1");
		int colcounnt = xl.getCellCount("sheet1", 1);
		String apidata[][] = new String[rownum][colcounnt];
		
		for(int i=1; i<rownum; i++) {
			for(int j=0; j<colcounnt; j++) {
				apidata[i-1][j] = xl.getCellData("sheet1", i, j);
			}
			
		}
		
		return apidata;
	}
	
	@DataProvider(name="users")
	public String[] getUsers() throws IOException{
		String path = System.getProperty("user.dir")+"//TestData//UsersData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("sheet1");
		String apidata[] = new String[rownum];
		for(int i=1; i<rownum; i++) {
			apidata[i-1] = xl.getCellData("sheet1", i, 1);
		}
		
		return apidata;
	}
}

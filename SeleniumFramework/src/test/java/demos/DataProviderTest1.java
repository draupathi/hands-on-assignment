package demos;

import java.io.IOException;

import org.testng.annotations.Test;

import utils.DataProviderHolder;


public class DataProviderTest1{
	@Test(dataProvider="empLogin", dataProviderClass = DataProviderHolder.class)
	public void VerifyInvalidLogin(String userName, String password) throws IOException {
	System.out.println(userName);
	System.out.println(password);
	DataProviderHolder.writeIntoExcel();
}
}

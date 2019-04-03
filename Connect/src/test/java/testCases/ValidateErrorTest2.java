package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateErrorTest2 {

	@Test(dataProvider = "getData")
	public void x(String user, String pass) {
		System.out.println(user);
		System.out.println(pass);
	}

	@DataProvider(name = "getData")
	public Object[][] d() {
		Object[][] data = new Object[1][2];
		data[0][0] = "Sha";
		data[0][1] = "Test1234";
		return data;
	}
}

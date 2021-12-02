package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utiliy {
	
	public static void takescreenshot (TakesScreenshot driver,int testID) throws IOException {
		Date currentdate = new Date();
		String screenshotfilename = "Test_"+testID+currentdate.toString().replace(" ","-").replace(":","-");
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\DELL\\eclipse-workspace\\Angel\\test-output\\testscreenshots"+screenshotfilename+".jpg";
		File dest = new File(path);
		FileHandler.copy(source, dest);

}
}

package ApplicationPages;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DockerTest {
	
	@BeforeSuite
	  public void StartDockerGridTest() throws IOException, InterruptedException {
		  Runtime.getRuntime().exec("cmd /c start dockergrid_start.bat");
			Thread.sleep(15000);  }

	  @AfterSuite
	  public void StopDockerGrid() throws IOException, InterruptedException
		 {
			Runtime.getRuntime().exec("cmd /c stop dockergrid_stop.bat");
			Thread.sleep(15000);
		 }

}

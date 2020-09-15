package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import Resources.Base;

public class NewTest extends Base{
	
		public static Logger log = LogManager.getLogger(Base.class.getName());

		@BeforeClass
		public void InitiateDriverAndSite() throws IOException {
		
		driver =initializeDriver();
		log.info("Browser strated successfully");
		log.error("Browser could not be started");
		
		driver.get(prop.getProperty("url"));
		log.info("site intiatated");
		log.error("Site could not be found");
	}
	
	
	
	@Test
	public void branchTest() {
		
		System.out.println("Thisis to be filled out by other member");
		System.out.println("The team member has done the necessary changes");
	}

}

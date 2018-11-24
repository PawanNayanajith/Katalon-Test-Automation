package sikulitest;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class NewTest {
	Screen s=new Screen();
  @Test
  public void f() throws FindFailed {
	 s.doubleClick("C:\\Users\\Mayuran\\Documents\\SikuliTest.sikuli\\Chrome.png");
	 s.click("C:\\Users\\Mayuran\\Documents\\SikuliTest.sikuli\\search (2).png");
	 s.type("www.demoaut.com");
	 s.type(Key.ENTER);
	 s.click("C:\\Users\\Mayuran\\Documents\\SikuliTest.sikuli\\register.png");
	 s.type(Key.ENTER);
	 //Region r =new Region(1151, 50, 168, 46);
	// r.click("path of maximize image");
	 
	
	 
  }
}

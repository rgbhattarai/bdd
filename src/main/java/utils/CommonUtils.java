package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	
	
	public  String getEmailWtihTimeStamp() {
		  Date date = new Date();
		  return "rghimire"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		  
		 }
}

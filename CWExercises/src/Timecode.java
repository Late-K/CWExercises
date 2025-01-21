
public class Timecode {
	public static String fromSeconds(double seconds){
		// Place your code here...
		// Hint: Check String's methods to see if there is a printf equivalent:
		//     https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html
		
		double timecode = seconds;
		int hours = (int) (timecode/3600);
		int min = (int) ((timecode % 3600) /60);
		int sec = (int) (timecode % 60);
		int millisec = (int) ((timecode % 1) * 1000);

		return String.format("%02d:%02d:%02d:%03d", hours, min, sec, millisec);
	
	}
}
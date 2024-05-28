
public class Main {

	public static void main(String[] args) {
		String[] test = new String[]{ 
				"23.05.2014", 
				"16.06.2014", 
				"13.03.2011", 
				"", 
				null, 
				"22.04.2004", 
				"44-2-2013", 
				"44.02.2013", 
				"12.08.2128", 
				"29.02.2012", 
				"e per concludere" };
		int invalidString = 0;
		for (int i = 0; i < test.length; i++) {
			String stringToElaborate = test[i];
			try {
				Data data = Data.estrai(stringToElaborate);
			} catch (Exception e) {
				invalidString++;
			}
		}
		System.out.println(invalidString);
	}

}

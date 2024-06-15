import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src//fileTesto.txt");
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String line;
			do {
				line = reader.readLine();
				if (line != null) {
					System.out.println(line);
				}
			} while (line != null);
		} catch (IOException exception) {
			System.out.println("Problem opening the file: " + exception.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException exception) {
				System.out.println("Problem closing file");
			}
		}
	}

}

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = null;
		File file = new File("src//fileTesto.txt");
		
		try {
			reader = new Scanner(file);
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
			System.exit(0);
		}
		try {
			String line;
			while (reader.hasNextLine()) {
				line = reader.nextLine();
				System.out.println(line);
			}
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			reader.close();
		}
	}

}

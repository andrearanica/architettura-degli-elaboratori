import java.io.FileInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream reader = null;
		File file = new File("src//fileBinario.bin");
		
		try {
			reader = new FileInputStream(file.getAbsolutePath());
			int data;
			do {
				data = reader.read();
				if (data != -1) {
					System.out.print((char)data);
				}
			} while (data != -1);
		} catch (IOException exception) {
			System.out.println("Problem opening file " + exception.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
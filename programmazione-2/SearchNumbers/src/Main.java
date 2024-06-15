import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src"+File.separator+"numbers.txt");
		BufferedReader reader = null;
		ArrayList<Integer> numbers = null;
		
		try {
			reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			numbers = new ArrayList<Integer>();
			
			String line;
			do {
				line = reader.readLine();
				if (line != null) {
					try {
						numbers.add(Integer.parseInt(line));
					} catch (Exception exception) {
						System.out.println("File format not valid");
						System.exit(0);
					}	
				}
			} while (line != null);
			
			System.out.println("Min: " + getMin(numbers));
			System.out.println("Max: " + getMax(numbers));
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}	
			} catch (IOException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
	
	private static int getMin(ArrayList<Integer> numbers) {
		int min = numbers.get(0);
		for (Integer i: numbers) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}
	
	private static int getMax(ArrayList<Integer> numbers) {
		int max = numbers.get(0);
		for (Integer i: numbers) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}

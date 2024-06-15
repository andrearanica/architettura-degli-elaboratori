import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		List<String> boysNames = getAllNames("boysnames.txt");
		List<String> girlNames = getAllNames("girlsnames.txt");
		
		Set<String> notDuplicatedNames = new HashSet<String>();
		for(String name: boysNames) {
			notDuplicatedNames.add(name);
		}
		for(String name: girlNames) {
			if (notDuplicatedNames.contains(name)) {
				System.out.println(name + " è comune");ria 
			}
		}
	}
	
	public static List<String> getAllNames(String filePath) {
		List<String> names = new ArrayList<String>();
		try {
			File fileReader = new File(filePath);
			Scanner scanner = new Scanner(fileReader);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				names.add(data.split(" ")[0]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Attention: file not found");
		}
		return names;
	}
}

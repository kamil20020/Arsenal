import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	public static void saveObject(Object obj, String filePath) throws IOException{
		
		try(ObjectOutputStream outputStream = new ObjectOutputStream((new FileOutputStream(filePath)))) {
			
			outputStream.writeObject(obj);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readObject(String filePath) throws FileNotFoundException, IOException, 
														   ClassNotFoundException, ClassCastException  {
		
		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))){
			
			return (T) inputStream.readObject();
		}
	}
	
	public static void saveText(List <String> lines, String filePath) throws IOException {
		
		try(FileWriter writer = new FileWriter(filePath)){
			
			for(String line : lines)
				writer.write(line + System.lineSeparator());
		}
	}
	
	public static List <String> readText(String filePath) throws FileNotFoundException, IOException{
		
		List <String> readedLines = new ArrayList<>();
		
		String input;
		
		try(BufferedReader readed = new BufferedReader(new FileReader(filePath))){
			
			while(true) {
				
				input = readed.readLine();
				
				if(input == null)
					break;
				
				readedLines.add(input);
			}
		}
		
		return readedLines;
	}
}

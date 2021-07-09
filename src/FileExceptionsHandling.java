import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileExceptionsHandling {

	public static void saveObjectExceptionHandling(Object obj, String filePath) {
		
		try {
			
			FileService.saveObject(obj, filePath);
			
			System.out.println("Poprawnie zapisano do pliku");
		}
		catch (IOException e) {
			
			System.out.println("Wystapil blad podczas zapisu obiektu do pliku");
		}
	}
	
	public static <T> T readObjectExceptionHandling(String filePath) {
		
		try {
			
			T readedT =  FileService.readObject(filePath);
			
			System.out.println("Poprawnie odczytano z pliku");
			
			return readedT;
		}
		catch(FileNotFoundException e) {
			
			System.out.println("Plik nie istnieje");
		}
		catch (IOException e1) {
			
			System.out.println("Wystapil blad podczas zapisu obiektu do pliku");
		}
		catch(ClassNotFoundException e2) {
			
			System.out.println("W pliku znajduja sie nieodpowiednie dane");
		}
		catch(ClassCastException e3) {
			
			System.out.println("Udalo sie odczytac obiekt z pliku, ale nie udalo sie go rzutowac na dana klase");
		}
		
		return null;
	}
	
	public static void saveTextExceptionHandling(List <String> lines, String filePath) {
		
		try {
			
			FileService.saveText(lines, filePath);
			
			System.out.println("Poprawnie zapisano do pliku");
		}
		catch(IOException e) {
			
			System.out.println("Wystapil blad podczas zapisu do pliku");
		}
	}
	
	public static List<String> readTextExceptionHandling(String filePath){
		
		try {
			
			List <String> readedList = FileService.readText(filePath);
			
			System.out.println("Poprawnie odczytano z pliku");
			
			return readedList;
		}
		catch(FileNotFoundException e) {
			
			System.out.println("Plik nie istnieje");
		} 
		catch (IOException e1) {
			
			System.out.println("Wystapil blad podczad odczytu z pliku");
		}
		
		return null;
	}
}

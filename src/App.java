import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
	
	Scanner input;
	
	private List <Gun> guns;
	
	private void addGun() {
		
		System.out.print("Prosze wprowadzic nazwe broni: ");
		String name = input.next();
		
		System.out.print("Prosze wprowadzic wersje: ");
		int version = GunService.inputInt(input, true); 
		
		System.out.print("Prosze wprowadzic kaliber: ");
		double caliber = GunService.inputDouble(input, true);
		
		System.out.print("Prosze wprowadzic liczbe pociskow w magazynku: ");
		int magazineSize = GunService.inputInt(input, true);
		
		System.out.print("Prosze wprowadzic wage calkowita broni: ");
		double weight = GunService.inputDouble(input, true);
		
		System.out.print("Prosze wprowadzic typ broni (Shogun, Pistol, Rifle): ");
		Gun.Type gunType = GunService.inputGunType(input);
		
		if(guns == null)
			guns = new ArrayList<>();
		
		guns.add(new Gun(name, version, caliber, magazineSize, weight, gunType));
	}
	
	private void editGun() {
		
		System.out.println("Nie zaimplementowano");
	}
	
	private void removeGun() {
		
		System.out.println("Nie zaimplementowano");
	}
	
	private void saveGun() {
		
		System.out.print("Podaj nazwe pliku do zapisu: ");
		String filePath = input.next();
		
		FileExceptionsHandling.saveObjectExceptionHandling(guns, filePath);
	}
	
	private void readGun() {
		
		System.out.print("Podaj nazwe pliku do odczytu: ");
		String filePath = input.next();
		
		guns = FileExceptionsHandling.readObjectExceptionHandling(filePath);
	}

	public void run() {
		
		input = new Scanner(System.in);
		
		String menu = "\nMenu:\n"
				+ 	  "show - Wyswietlenie kolekcji\n"
				+ 	  "add - Dodanie broni\n"
				+ 	  "edit - Edytowanie broni\n"
				+  	  "remove - Usuniecie broni\n"
				+ 	  "save - Zapisz kolekcje do pliku\n"
				+ 	  "read - Wczytaj kolekcje z pliku\n"
				+     "exit - Wylaczenie programu\n";
		
		boolean doEnd = false;
		
		while(!doEnd) {
		
			System.out.println(menu);
			
			System.out.print("Wprowadz odpowiednia komende: ");
			
			switch(input.next()) {
			
				case "show":
					
					if(!GunService.showGuns(guns))
						System.out.println("Nie ma w bazie zadnych broni");
					
					break;
					
				case "add":
					
					addGun();
					break;
					
				case "edit":
					
					editGun();
					break;
					
				case "remove":
					
					removeGun();
					break;
					
				case "save":
					
					saveGun();
					break;
					
				case "read":
					
					readGun();
					break;
					
				case "exit":
					
					doEnd = true;
					break;
				
				default:
					
					System.out.println("Wprowadzono zla komende");
			}
		}
		
		System.out.println("Program zostal wylaczony");
	}
}

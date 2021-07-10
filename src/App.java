import java.util.ArrayList;
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
		
		System.out.print("Prosze wprowadzic liczbe broni: ");
		int numberOf = GunService.inputInt(input, true); 
		
		
		if(guns == null)
			guns = new ArrayList<>();
		
		guns.add(new Gun(name, version, caliber, magazineSize, weight, gunType, numberOf));
	}
	
	private void editGun() {
		
		Gun gun = find();
		
		if(gun == null) {
			
			System.out.println("Nie istnieje taki zasob");
			return;
		}
		
		String options = "\nOpcje:\n"
				+ 		 "name - Nazwa\n"
				+ 		 "version - Wersja\n"
				+ 		 "caliber - Kaliber\n"
				+ 		 "magazine - Rozmiar magazynka\n"
				+ 		 "type - Typ broni\n"
				+ 		 "number of - Liczba broni\n";
		
		System.out.println(options);
		System.out.println("Wprowadz odpowiednia kategorie ktora ma byc zmieniona: ");
		
		String category = input.next();
		
		System.out.println("Wprowadz wartosc: ");
		
		switch(category) {
		
			case "name":
				
				gun.setName(input.next());
				break;
			
			case "version":
				
				gun.setVersion(GunService.inputInt(input, true));
				break;
				
			case "caliber":
	
				gun.setCaliber(GunService.inputDouble(input, true));
				break;
				
			case "magazine":
	
				gun.setMagazineSize(GunService.inputInt(input, true));
				break;
				
			case "type":
				
				gun.setType(GunService.inputGunType(input));
				break;
			
			case "number of":
	
				gun.setNumberOf(GunService.inputInt(input, true));
				break;
			
			default:
				System.out.println("Wprowadzono niepoprawna kategorie");
		}
	}
	
	private Gun find() {
		
		if(guns == null) {
			
			System.out.println("Kolekcja broni jest pusta");
			return null;
		}
		
		System.out.print("Podaj nazwe zasobu: ");
		String name = input.next();
		
		System.out.print("Podaj wersje zasobu: ");
		int version = GunService.inputInt(input, true);
		
		System.out.print("Podaj kaliber broni: ");
		double caliber = GunService.inputDouble(input, true);
		
		String id = Gun.getString(name, version, caliber);
		
		for(Gun g : guns) {
			
			if(g.toString().equals(id))
				return g;
		}
		
		return null;
	}
	
	private void removeGun() {
		
		Gun gun = find();
		
		if(gun != null) {
		
			guns.remove(gun);
			
			System.out.println("Udalo sie usunac zasob");
		}
		else
			System.out.println("Taki zasob nie istnieje");
		
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
	
	private void showGuns() {
		
		for(Gun g : guns)
			System.out.println(g);
	}
	
	private void specificShowGuns() {
		
		System.out.println("Nazwa\t Wersja \t Kaliber(mm) \t Rozmiar magazynka \t"
				+ 		   "Waga(g) \t Typ \t Liczba sztuk");
		
		for(Gun g : guns) {
			
			System.out.println(g.getName() + "\t   " + g.getVersion() + "\t\t    " + g.getCaliber() + 
							   "\t\t\t" + g.getMagazineSize() + "\t\t" + g.getWeight() + "\t\t" +
								g.getType() + "\t\t" + g.getNumberOf());
		}
	}
	
	private void showGunsMenu() {
		
		if(guns == null) {
			
			System.out.println("Kolekcja jest pusta");
			return;
		}
		
		String menu = "\nOpcje:\n"
				+ 	  "generally - ogolne informacje\n"
				+ 	  "specifically - szczegolowe informacje\n";
		
		System.out.println(menu);
		
		System.out.print("Wprowadz odpowiednia komende: ");
		String command = input.next();
		
		System.out.print(System.lineSeparator());
		
		switch(command) {
		
			case "generally":
				
				showGuns();
				break;
			
			case "specifically":
				
				specificShowGuns();
				break;
			
			default:
				
				System.out.println("Wprowadzono niepoprawna komende");
		}
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
					
					showGunsMenu();
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

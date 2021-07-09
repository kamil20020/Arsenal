import java.util.InputMismatchException;
import java.util.Scanner;

public class GunService {
	
	public static int inputInt(Scanner input, boolean greaterThanZero) {
		
		while(true) {
			
			try {
				
				int inputValue = input.nextInt();
				
				if(inputValue < 0)
					throw new IllegalArgumentException("Nalezy wprowadzic liczbe dodatnia: ");
				
				return inputValue;
			}
			catch(IllegalArgumentException e) {
				
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e1) {
				
				System.out.println("Podano nieprawidlowa liczbe calkowita: ");
				
				input.nextLine();
			}
		}
	}
	
	public static double inputDouble(Scanner input, boolean greaterThanZero) {
		
		while(true) {
			
			try {
				
				double inputValue = input.nextDouble();
				
				if(inputValue < 0)
					throw new IllegalArgumentException("Nalezy wprowadzic liczbe dodatnia: ");
				
				return inputValue;
			}
			catch(IllegalArgumentException e) {
				
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e1) {
				
				System.out.println("Podano nieprawidlowa liczbe zmiennoprzecinkowa podwojnej prezycji: ");
				
				input.nextLine();
			}
		}
	}
	
	public static Gun.Type inputGunType(Scanner input){
		
		Gun.Type gunType;
		
		while(true) {
			
			gunType = GunService.validateGunType(input.next());
			
			if(gunType != null)
				return gunType;
			
			System.out.print("Wprowadzono nieprawidlowy typ broni: ");
		}
	}
	
	public static Gun.Type validateGunType(String gunType) {
		
		try {
			
			return Gun.Type.valueOf(gunType);
		}
		catch(IllegalArgumentException e) {}
		
		return null;
	}
}

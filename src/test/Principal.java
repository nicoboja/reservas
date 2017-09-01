package test;

import java.util.Scanner;


public class Principal {
	
	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		String rta="";
		boolean continua=true;
		do {
			
			System.out.println("\n\n...............###############···········\n");
			System.out.println("MENU PRINCIPAÑ:");
			System.out.println("1 - ABMC PERSONAS");
			System.out.println("2 - ABMC Vehiculos");
			System.out.println("3 - ABMC Tipos Vehiculos");
			System.out.println("0 - Salir");
			rta=s.nextLine();
			
			switch (rta.toLowerCase()) {
			case "1":
				
				System.out.println("(1)");
				
				break;
		
			case "0":
				continua=false;
				System.out.println("Chau Hasta Luego!");
			}
		} while (continua);
		
		s.close();
	}
}
		
	

	
	
	
	
	



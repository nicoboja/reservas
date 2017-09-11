package test;

import java.util.Scanner;


public class Principal {
	
	private static Scanner s;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		s=new Scanner(System.in);
		String rta="";
		boolean continua=true;
		do {
			
			System.out.println("\n\n...............###############···········\n");
			System.out.println("MENU PRINCIPAL:");
			System.out.println("1 - ABMC PERSONAS");
			System.out.println("2 - ABMC Vehiculos");
			System.out.println("3 - ABMC Tipos Vehiculos");
			System.out.println("0 - Salir\n");
			rta=s.nextLine();
			
			switch (rta) {
			case "1":
				
				System.out.println("(1)");
				ABMCPersonaConsole test = new ABMCPersonaConsole();
				test.start();
				break;
		
			case "0":
				continua=false;
				System.out.println("Chau Hasta Luego!");
			}
		} while (continua);
		
		s.close();
	}
}
		
	

	
	
	
	
	



package test;

import java.util.Scanner;
import controlers.*;
import test.*;

public class Principal {
	
	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		String rta="";
		boolean continua=true;
		do {
			
			System.out.println("\n\n##############################\n");
			System.out.println("MENU PRINCIPAL:");
			System.out.println("1 - ABMC Personas");
			System.out.println("2 - ABMC Elementos");
			System.out.println("3 - ABMC Tipos Elementos");
			System.out.println("0 - Salir\n");
			rta=s.nextLine();
			
			switch (rta) {
			
			case "1":
				
				System.out.println("(1)");
				
				break;
		
			case "2":
				
				ABMCElementoTest test=new ABMCElementoTest();
				System.out.println("(2)");
				test.start();
						
				break;
				
			case "3":
				
				ABMCTipoElementoTest testTe=new ABMCTipoElementoTest();
				System.out.println("(3)");
				testTe.start();
		
			case "0":
				continua=false;
				System.out.println("Chau Hasta Luego!");
			}
		} while (continua);
		
		s.close();
	}
}
		
	

	
	
	
	
	



package test;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import controlers.CtrlABMPersona;
import entity.Persona;

public class ABMCPersonaConsole {
	private Scanner s;
	private CtrlABMPersona ctrl;
	
	public ABMCPersonaConsole(){
		s=new Scanner(System.in);
		ctrl= new CtrlABMPersona();
		
	}
	public void start() throws Exception{
	
		String rta="";
		boolean continua=true;
		do {
			System.out.println("\n\n ###############\n");
			System.out.println("¿Qué acción desea realizar? (Ingrese la letra indicada)");
			System.out.println("1 - Consulta");
			System.out.println("2 - Alata");
			System.out.println("3 - Baja");
			System.out.println("4 - ");
			System.out.println("0 - Salir");
			
			rta=s.nextLine();
			
			switch (rta) {
			case "1":
				this.consulta();
				break;
			case "2":
			this.alta();
				break;
			case "3":
//				this.modificacion();
				break;
			case "4":
//				this.consulta();
				break;
			case "0":
				continua=false;
			}
		} while (continua);
		
		s.close();
	}
	
	public void consulta() throws Exception{
		
		Persona p=new Persona();
		
		System.out.println("\n\nConsultar personas");
		System.out.println("#############");
		System.out.println("Ingrese Opción:");
		System.out.println("1 - Listado");
		System.out.println("2 - Buscar por DNI");
		System.out.println("3 - Buscar por Nombre y Apellido");
		String rta=s.nextLine();
		switch (rta) {
		
		case "1":
		this.mostrar(ctrl.getAll());
			break;
		case "2":
			System.out.println("Ingrese DNI:");
			p.setDni(s.nextLine());
			this.mostrar(ctrl.getByDni(p));
			break;
		case "3":
			System.out.println("Ingrese Nombre:");
			p.setNombre(s.nextLine());
			System.out.println("Ingrese Apellido:");
			p.setApellido(s.nextLine());
	//		this.mostrar(ctrl.getByNombreApellido(p));
			break;

		default:
			break;
		}

	}
	
	public void mostrar(ArrayList<Persona> personas){
		for(Persona p: personas){
			mostrar(p);
		}
	}
	
	public void mostrar(Persona p){
		System.out.println(p.getApellido());
	}
	
	private void alta() throws Exception{
		System.out.println("\n\nNueva persona");
		System.out.println("#############");
		Persona p=new Persona();
		System.out.println("Ingrese DNI:");
		p.setDni(s.nextLine());
		System.out.println("Ingrese Nombre");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese Apellido");
		p.setApellido(s.nextLine());
		System.out.println("¿Está habilitado? (S/N)");
		String h=s.nextLine();
		if(h.equalsIgnoreCase("S")){
			p.setHabilitado(true);
		}else if (h.equalsIgnoreCase("N")) {
			p.setHabilitado(false);
		}
		ctrl.add(p);
	}
	
	
	}




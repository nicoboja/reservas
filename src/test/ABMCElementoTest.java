package test;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlABMElemento;
import entity.Elemento;


public class ABMCElementoTest {
	
	private Scanner s=new Scanner(System.in);
	private CtrlABMElemento ctrl=new CtrlABMElemento();
	
	public void start(){
		String rta="";
		boolean cont=true;
		
		do {
			System.out.println("\n\n ###############\n");
			System.out.println("-----GESTION DE ELEMENTOS-----");
			System.out.println("Seleccione una opcion:");
			System.out.println("A - Alta Elemento");
			System.out.println("B - Baja Elemento");
			System.out.println("M - Modificar Elemento");
			System.out.println("C - Buscar Elemento");
			System.out.println("S - Salir");
			rta=s.nextLine();
		
			switch (rta) {
				case "a":
				try {
					this.alta();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case "b":
					//this.baja();
					break;
				case "m":
					//this.modificacion();
					break;
				case "c":
				try {
					this.mostrar(ctrl.getAll());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case "s":
					cont=false;
			}			
			
		} while(cont);		
		s.close();		
		
	}
		
	private void alta() throws Exception{
		System.out.println("\n\n Nuevo Elemento ");
		System.out.println("--------------");
		Elemento e=new Elemento();
		System.out.println("Ingrese Nombre");
		e.setNombre(s.nextLine());
		System.out.println("Ingrese Descripcion");
		e.setDescrip(s.nextLine());
		ctrl.add(e);
	}
	
	public void mostrar(ArrayList<Elemento>elementos){
		for(Elemento e: elementos){
			mostrar(e);
		}
	}
	
	public void mostrar(Elemento e){
		String h="";
		System.out.println(e.getIdE()+" - "+e.getNombre()+", "+
						 e.getDescrip()+": "+h);
	}
	

}

package test;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlABMTipoElemento;
import entity.Elemento;
import entity.TipoElemento;

public class ABMCTipoElementoTest {
	
	private Scanner s=new Scanner(System.in);
	private CtrlABMTipoElemento ctrl=new CtrlABMTipoElemento();
	
	public void start(){
		String rta="";
		boolean cont=true;
		
		do {
			System.out.println("\n\n ###############\n");
			System.out.println("-----GESTION TIPO de ELEMENTOS-----");
			System.out.println("Seleccione una opcion:");
			//System.out.println("A - Alta Elemento");
			//System.out.println("B - Baja Elemento");
			//System.out.println("M - Modificar Elemento");
			System.out.println("C - Buscar Elemento");
			System.out.println("L - Listar Elementos");
			System.out.println("S - Salir");
			rta=s.nextLine();
		
			switch (rta) {
										
				case "c":	
					try{
					TipoElemento te=new TipoElemento();
					System.out.println("Ingrese Nombre:");
					te.setNombre(s.nextLine());
					this.mostrar(ctrl.getByNombre(te));
					} catch (Exception e) {
						e.printStackTrace();
					}
						break;
					
				case "l":
					try {
						this.mostrar(ctrl.getAll());
					} catch (Exception e) {
						e.printStackTrace();
					}
						break;
						
				case "s":
					cont=false;
			}						
		} while(cont);		
		s.close();			
	}

	public void mostrar(ArrayList<TipoElemento>tipoelementos){
		for(TipoElemento te: tipoelementos){
			mostrar(te);
		}
	}
	
	public void mostrar(TipoElemento te){
		String h="";
		
		if(te.getNombre()==null){
			System.out.println("El elemento no exite");
			
		} else{
		System.out.println(te.getIdT()+" - "+te.getNombre());
		
		}
	}
	
		

}

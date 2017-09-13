package test;

import java.util.ArrayList;
import java.util.Scanner;

import controlers.CtrlABMElemento;
import controlers.CtrlABMTipoElemento;
import entity.Elemento;
import entity.TipoElemento;


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
			System.out.println("L - Listar Elementos");
			System.out.println("S - Salir");
			rta=s.nextLine();
		
			switch (rta) {
			
				case "a":
				try {
					this.alta();
				} catch (Exception e) {
					e.printStackTrace();
				}
					break;
					
				case "b":
				try {
					this.baja();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					break;
					
				case "m":
					//this.modificacion();
					break;
					
				case "c":	
					try{
					Elemento el=new Elemento();
					System.out.println("Ingrese Nombre:");
					el.setNombre(s.nextLine());
					this.mostrar(ctrl.getByNombre(el));
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
		
	private void alta() throws Exception{
		CtrlABMTipoElemento ctrlTE=new CtrlABMTipoElemento();
		System.out.println("\n\n Agregar un Elemento ");
		System.out.println("--------------");
		Elemento e=new Elemento();
		TipoElemento te=new TipoElemento();
		System.out.println("Ingrese Nombre");
		e.setNombre(s.nextLine());
		System.out.println("Ingrese Descripcion");
		e.setDescrip(s.nextLine());
		System.out.println("Ingrese Tipo Elemento");
		te.setNombre(s.nextLine());
		e.setTipoElem(ctrlTE.getByNombre(te));
		ctrl.add(e);
	}
	
	
	private void baja() throws Exception{
		
		System.out.println("\n\n Borrar un Elemento ");
		System.out.println("--------------");
		Elemento el=new Elemento();
		try{
			System.out.println("Ingrese Nombre");
			el.setNombre(s.nextLine());
			if(ctrl.getByNombre(el)==null){
				System.out.println("El elemento no exite");
			} else{
				System.out.println("Borrando elemento!");
				ctrl.delete(el);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
	public void mostrar(ArrayList<Elemento>elementos){
		for(Elemento e: elementos){
			mostrar(e);
		}
	}
	
	public void mostrar(Elemento e){
		String h="";
		
		if(e.getNombre()==null){
			System.out.println("El elemento no exite");
		} else{

		System.out.println(e.getIdE()+" - "+e.getNombre()+", "+
						 e.getDescrip()+": "+h);
		}
	}
	

}

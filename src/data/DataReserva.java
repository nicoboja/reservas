package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import entity.Reserva;
import util.AppDataException;


public class DataReserva {
	

	public ArrayList<Reserva> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		
		ArrayList<Reserva> reserv= new ArrayList<Reserva>();
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from reservado");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setId(rs.getInt("idR"));

					reserv.add(r);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reserv;
		

	}
	public ArrayList<Reserva> getAllPendientes() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reserv= new ArrayList<Reserva>();
		
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from reservado");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setId(rs.getInt("idR"));
			
					reserv.add(r);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return reserv;
		
	}



	public void add(Reserva r) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try{
			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva (fecha, detalle, idElemento, hora, cantHoras, idPersona) values (?,?,?,?,?,?)");
			stmt.setDate(1, r.getFecha());
			stmt.setString(2, r.getDetalle());
			stmt.setInt(3, r.getElem().getId());
			stmt.setTime(4, r.getHora());
			stmt.setInt(5, r.getCantHoras());
			stmt.setInt(6, r.getPer().getId());
			stmt.executeUpdate();
						
		}catch (Exception ex){
			System.out.println("No se ha cargado un elemento");
			throw ex;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}			
	}


	public Reserva getById(Reserva r) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Reserva r) {
		// TODO Auto-generated method stub
		
	}

	public void update(Reserva r) {
		// TODO Auto-generated method stub
		
	}


}

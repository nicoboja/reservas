package data;

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
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from reservado");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setId(rs.getInt("idR"));
					r.setElemento(rs.getString("tipoelemento"));
					r.setTipo(rs.getString("elemento"));
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
					r.setElemento(rs.getString("tipoelemento"));
					r.setTipo(rs.getString("elemento"));
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


}

package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import entity.Reserva;

public class DataReserva {
	

	public void add(Reserva r) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try{
			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva (fecha, detalle, idTipo, hora, cantHoras, idPersona) values (?,?,?,?,?,?)");
			stmt.setDate(1, r.getFecha());
			stmt.setString(2, r.getDetalle());
			stmt.setInt(3, r.getTipo().getIdT());
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

	public ArrayList<Reserva> getAll() {
		// TODO Auto-generated method stub
		return null;
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

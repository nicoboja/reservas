package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Categoria;
import entity.Reserva;
import entity.Reserva;
import util.AppDataException;


public class DataReserva {
	
	public void add(Reserva r) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try{
			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva (fecha, detalle, idElemento, hora, cantHoras, idPersona, estado) values (?,?,?,?,?,?,?)");
			stmt.setDate(1, r.getFecha());
			stmt.setString(2, r.getDetalle());
			stmt.setInt(3, r.getElem().getId());
			stmt.setTime(4, r.getHora());
			stmt.setInt(5, r.getCantHoras());
			stmt.setInt(6, r.getPer().getId());
			stmt.setString(7, r.getEstado());
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
	
	public ArrayList<Reserva> getByIdPer(int idPers) throws Exception {
		System.out.println("dataReserva!");
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Reserva r=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from reserva r inner join elemento e on r.idElemento=e.idE "
					+ "where e.idE=? and r.estado='Habilitado' and r.fecha>CURDATE() order by r.fecha");			
			stmt.setInt(1, idPers);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){					
					r=new Reserva();
					r.setId(rs.getInt("idR"));
					r.setFecha(rs.getDate("fecha"));
					r.setDetalle(rs.getString("detalle"));
					r.setCantHoras(rs.getInt("cantHoras"));
					r.setEstado(rs.getString("estado"));
					r.setHora(rs.getTime("hora"));
					r.getElem().setId(rs.getInt("idElemento"));
					res.add(r);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		System.out.println("enviando array por persona");
		return res;
	}

	public ArrayList<Reserva> getByFecha(java.sql.Date fec) throws Exception {
		System.out.println("dataReserva!");
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Reserva r=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from reserva where fecha=? and estado='Habilitado'");			
			stmt.setDate(1, fec);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){					
					r=new Reserva();
					r.setId(rs.getInt("idR"));
					r.setFecha(rs.getDate("fecha"));
					r.setDetalle(rs.getString("detalle"));
					r.setCantHoras(rs.getInt("cantHoras"));
					r.setEstado(rs.getString("estado"));
					r.setHora(rs.getTime("hora"));
					//r.getPer().setId(rs.getInt("idPersona"));
					//r.getElem().setId(rs.getInt("idElemento"));
					res.add(r);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		System.out.println("enviando array getByFecha");
		return res;
	}
	
	public void delete(Reserva r) {
		// TODO Auto-generated method stub
		
	}

	public void update(Reserva r) {
		// TODO Auto-generated method stub
		
	}


}

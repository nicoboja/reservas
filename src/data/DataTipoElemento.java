package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.TipoElemento;

public class DataTipoElemento {
	
	public TipoElemento getByNombre(TipoElemento te) throws Exception{
		
		TipoElemento tipoElem=new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from tipoelemento where descripcion=?");
			stmt.setString(1, te.getDescripcion());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					tipoElem.setIdT(rs.getInt("idT"));
					tipoElem.setDescripcion(rs.getString("descripcion"));
					tipoElem.setCantMax(rs.getInt("maxPend"));
					tipoElem.setDiasMaxAnt(rs.getInt("diasant"));
					tipoElem.setTiempoMax(rs.getInt("tiempoMax"));
			}			
		} catch (SQLException e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return tipoElem;
	}	
	
	public void add(TipoElemento te) throws Exception {
		PreparedStatement stmt=null;
		try{			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tipoelemento (descripcion, maxPend, diasant, tiempoMax) values (?,?,?,?)");
			stmt.setString(1, te.getDescripcion());
			stmt.setInt(2, te.getCantMax());
			stmt.setInt(3, te.getDiasMaxAnt());
			stmt.setInt(4, te.getTiempoMax());
			stmt.executeUpdate();
		}catch (Exception e){
			System.out.println("No se ha cargado el tipo elemento");
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}			
	}
	
	public void update(TipoElemento te) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update tipoelemento set descripcion=?,  diasant=?, maxPend=?, tiempoMax=? where idT=?");
			stmt.setString(1, te.getDescripcion());
			stmt.setInt(2, te.getDiasMaxAnt());
			stmt.setInt(3, te.getCantMax());
			stmt.setInt(4, te.getTiempoMax());
			stmt.setInt(5, te.getIdT());
			stmt.executeUpdate();					
		}catch (Exception e) {
			System.out.println("Ha fallado la modificacion de datos");
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public void delete(TipoElemento te) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from tipoelemento where idT=?");
			stmt.setInt(1, te.getIdT());
			stmt.executeUpdate();			
		}catch (Exception e) {
			System.out.println("Ha fallado el borrado de datos");
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public ArrayList<TipoElemento> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipoelementos= new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tipoElem=new TipoElemento();
					tipoElem.setIdT(rs.getInt("idT"));
					tipoElem.setDescripcion(rs.getString("descripcion"));
					tipoElem.setCantMax(rs.getInt("maxPend"));
					tipoElem.setDiasMaxAnt(rs.getInt("diasant"));
					tipoElem.setTiempoMax(rs.getInt("tiempoMax"));
					tipoelementos.add(tipoElem);
				}
			}
		} catch (SQLException e) {			
			throw e;
		} 
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {			
			throw e;
		}		
		return tipoelementos;		
	}	

}
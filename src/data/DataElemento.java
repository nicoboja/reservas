package data;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;
import entity.*;

public class DataElemento {

	public void add(Elemento el) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try{			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into elemento (idT, nombre) values (?,?)");
			stmt.setInt(1, el.getTipoElem().getIdT());
			stmt.setString(2, el.getNombre());
			stmt.executeUpdate();			
			
		}catch (SQLException e){
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}			
	}
	
	public void delete(Elemento el) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from elemento where idE=?");
			stmt.setInt(1, el.getId());
			stmt.executeUpdate();			
		}catch (Exception e) {
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	
	public Elemento getByNombre(Elemento el) throws Exception{
		Elemento elem= null;		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.idE, e.`nombre`, t.idT, t.descripcion from elemento e inner join tipoelemento t  on e.`idT` = t.idT where nombre=?");
			stmt.setString(1, el.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					elem =new Elemento();
					elem.setTipoElem(new TipoElemento());					
					elem.setId(rs.getInt("idE"));
					elem.setNombre(rs.getString("nombre"));
					elem.getTipoElem().setDescripcion(rs.getString("descripcion"));
					elem.getTipoElem().setIdT(rs.getInt("idT"));					
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
		return elem;
	}
	
	public ArrayList<Elemento> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento elem=new Elemento();
					elem.setId(rs.getInt("idE"));
					elem.setNombre(rs.getString("nombre"));
					elementos.add(elem);
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
			
			e.printStackTrace();
		}		
		return elementos;		
	}	

	public void update(Elemento el) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update elemento set nombre=?, idT=? where idE=?;");
			stmt.setString(1, el.getNombre());
			stmt.setInt(3, el.getTipoElem().getIdT());
			stmt.setInt(4, el.getId());
			stmt.executeUpdate();		
		}catch (Exception e) {
			System.out.println("Ha fallado el borrado de datos");
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public ArrayList<Elemento> getByTipo(int t) throws Exception{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from elemento where idT=?");
			stmt.setInt(1, t);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Elemento elem=new Elemento();
					elem.setId(rs.getInt("idE"));
					elem.setNombre(rs.getString("nombre"));
					elementos.add(elem);
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
		return elementos;		
	}	

}

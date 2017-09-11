package data;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;
import entity.*;

public class DataElemento {
	
	public void add(Elemento e) throws SQLException {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into elemento (nombre, descripcion) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
		stmt.setString(1, e.getNombre());
		stmt.setString(2, e.getDescrip());
		stmt.executeUpdate();
		keyResultSet=stmt.getGeneratedKeys();
		if(keyResultSet!=null && keyResultSet.next()){
			e.setIdE(keyResultSet.getInt(1));
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		}
	}
	
	public void delete(Elemento e) throws SQLException {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from elemento where nombre like '?' ");
			stmt.executeUpdate();
			
		}catch (Exception e1) {
			System.out.println("Ha fallado el borrado de datos");
			throw e1;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}
		
		
		
		
	}
	
	
	public Elemento getByNombre(Elemento elem) throws Exception{
	
		Elemento el=new Elemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from elemento where nombre=?");
			stmt.setString(1, elem.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					//Elemento el=new Elemento();
					el.setIdE(rs.getInt("idE"));
					el.setNombre(rs.getString("nombre"));
					el.setDescrip(rs.getString("descripcion"));
			}
			
		} catch (Exception e) {
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
		return el;
	}
	
	public ArrayList<Elemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elem= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento e=new Elemento();
					e.setIdE(rs.getInt("idE"));
					e.setNombre(rs.getString("nombre"));
					e.setDescrip(rs.getString("descripcion"));
					elem.add(e);
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
		
		return elem;
		
	}
	
}

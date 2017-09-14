package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Elemento;
import entity.TipoElemento;

public class DataTipoElemento {
	
	public TipoElemento getByNombre(TipoElemento te) throws Exception{
		
		TipoElemento tipoElem=new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from tipoelemento where nombre=?");
			stmt.setString(1, te.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					tipoElem.setIdT(rs.getInt("idT"));
					tipoElem.setNombre(rs.getString("nombre"));
			}
			
		} catch (Exception e1) {
			throw e1;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e1) {
				throw e1;
			}
		}
		return tipoElem;
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
					tipoElem.setNombre(rs.getString("descripcion"));
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
			
			e.printStackTrace();
		}
		
		return tipoelementos;
		
	}
	
	

}
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
		ArrayList<TipoElemento> tiposelemento= new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento t=new TipoElemento();
					t.setIdT(rs.getInt("idT"));
					t.setDescripcion(rs.getString("descripcion"));
					//
					System.out.println(t.getDescripcion()+t.getIdT());
					//
					tiposelemento.add(t);
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
		
		return tiposelemento;
		
	}
	
	

}
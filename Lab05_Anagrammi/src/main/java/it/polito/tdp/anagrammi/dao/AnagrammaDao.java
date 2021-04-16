package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDao {
	
	public boolean isCorrect(String anagramma){
		
		String sql= "SELECT nome FROM parola WHERE nome= ?";
		
		try {
			Connection conn = ConnectionDB.getConnection();
		
		    PreparedStatement st= conn.prepareStatement(sql);
		    
		    st.setString(1, anagramma);
		
		    ResultSet res= st.executeQuery();
		    
		    if(res.next())
		    	return true;
		    
		    res.close();
		    st.close();
		    conn.close();
		    
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	

}

package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.dao.AnagrammaDao;

public class Model {
	
	AnagrammaDao dao= new AnagrammaDao();
	
    public List<String> anagrammi(String parola) {
		
		List<String> risultato = new ArrayList<>() ;
		
		permuta("", parola, 0, risultato) ; 
		
		return risultato ;
		
	}
	
    
    public List<String> risolvi(String parola) {
    	
		List<String> risultato = new ArrayList<>();
		
		permuta("",parola,0,risultato);
		
		return risultato;
	}
    
    
	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
		
		if( lettere.length()==0 ) { 
			
			risultato.add(parziale) ;
			
		} else {
			
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos) ; 
				
				String nuovaParziale = parziale + tentativo ;
				String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
				
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;
				
			}
		}
	}
	
	public String getCorretti(String parola) {

		String risultato = "";
		
		for(String s : risolvi(parola))
			
			if(dao.isCorrect(s)==true)
				risultato = risultato +s +"\n";

		return risultato;
	}
	
	
	public String getErrati(String parola) {

		String risultato = "";
		
		for(String s : risolvi(parola))
			
			if(dao.isCorrect(s)==false)
				risultato = risultato +s +"\n";

		return risultato;
	}

}

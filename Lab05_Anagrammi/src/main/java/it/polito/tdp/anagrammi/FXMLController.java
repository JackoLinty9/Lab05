package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.dao.AnagrammaDao;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserito;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextArea txtErrate;

    @FXML
    private Button btnReset;

    @FXML
    void calcolaAnagrammi(ActionEvent event) {
    	
    	String inserito=txtInserito.getText().toLowerCase();
    	
    	this.txtCorrette.setText(model.getCorretti(inserito));
    	
    	this.txtErrate.setText(model.getErrati(inserito));

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtInserito.clear();
    	
    	this.txtCorrette.clear();
    	txtCorrette.setEditable(false);
    	
    	this.txtErrate.clear();
    	txtErrate.setEditable(false);
    	
    }
    
    public void setModel(Model model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtInserito != null : "fx:id=\"txtInserito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrate != null : "fx:id=\"txtErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

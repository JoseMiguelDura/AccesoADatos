/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiusosv0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jose Miguel Durá Sirvent y Agustín Erkiletlian Battista
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MenuItem nuevoArchivoID;
    @FXML
    private MenuItem abrirArchivoID;
    @FXML
    private MenuItem guardarArchivoID;
    @FXML
    private MenuItem cerrarArchivoID;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelDescripcion;
    @FXML
    private Label labelLicencia;
    @FXML
    private Label labelPrecio;
    @FXML
    private Label labelRequisitos;
    @FXML
    private Label labelAlternativas;
    @FXML
    private Button bEditar;
    @FXML
    private Button bAnterior;
    @FXML
    private Button bSiguiente;
    @FXML
    private Pane paneGlobal;
    @FXML
    private TextField tNombre;
    @FXML
    private TextField tDescripcion;
    @FXML
    private TextField tLicencia;
    @FXML
    private TextField tPrecio;
    @FXML
    private TextField tRequisitos;
    @FXML
    private TextField tAlternativa;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @FXML
    private void clickEditar()
    {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tDescripcion.setText("Necesario crear archivo primero");
        tNombre.setText("Necesario crear archivo primero");
        
    }    
    
}

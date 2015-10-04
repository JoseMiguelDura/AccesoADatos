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
    private Button bGuardar;
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
    @FXML
    private MenuItem mNuevoArchivo;
    @FXML
    private Button bNuevo;
    @FXML
    private Label lSoftware;
    private int numeroSoftware;
    private ModeloMultiusos miModelo;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @FXML
    private void clickEditar()
    {
    }
    
    @FXML
    private void clickNuevo()
    {
        tDescripcion.setText("");
        tNombre.setText("");
        tLicencia.setText("");
        tPrecio.setText("");
        tRequisitos.setText("");
        tAlternativa.setText("");
        setEditar(true);
        bGuardar.setDisable(false);
    }
    
    private void setEditar(boolean estado)
    {
        tDescripcion.setEditable(estado);
        tNombre.setEditable(estado);
        tLicencia.setEditable(estado);
        tPrecio.setEditable(estado);
        tRequisitos.setEditable(estado);
        tAlternativa.setEditable(estado);
    }
    
    public void guardar()
    {
        if(numeroSoftware>miModelo.getSize())
        {
            miModelo.Anyadir(
                    new Software(tNombre.getText(),tDescripcion.getText(),tLicencia.getText(),
                            Double.parseDouble(tPrecio.getText()),
                            tRequisitos.getText(),tAlternativa.getText()));
        }
        else
        {
            Software aux=miModelo.getSoftware(numeroSoftware);
            aux.setNombre(tNombre.getText());
            aux.setDescripcion(tDescripcion.getText());
            aux.setLicencia(tLicencia.getText());
            aux.setPrecio(Double.parseDouble(tPrecio.getText()));
            aux.setRequisitos(tRequisitos.getText());
            aux.setAlternativas(tAlternativa.getText());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tDescripcion.setText("Necesario crear archivo primero");
        tNombre.setText("Necesario crear archivo primero");
        tLicencia.setText("Necesario crear archivo primero");
        tPrecio.setText("Necesario crear archivo primero");
        tRequisitos.setText("Necesario crear archivo primero");
        tAlternativa.setText("Necesario crear archivo primero");
        setEditar(false);
        numeroSoftware=0;
        lSoftware.setText("Software: "+numeroSoftware);
        bGuardar.setDisable(true);
    }    

    
}

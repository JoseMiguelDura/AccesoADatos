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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    @FXML
    private Pane paneNew;
    private ToggleGroup miTG;
    @FXML
    private RadioButton tipoBinario;
    @FXML
    private RadioButton tipoPlano;
    private String nombreFichero;
    @FXML
    private Button botonNuevo;
    @FXML
    private TextField tfNombreFichero;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @FXML
    private void clickNuevo()
    {
        paneNew.setVisible(true);
    }
    
    @FXML
    private void nuevoSoftware()
    {
        tNombre.setText("");
        tDescripcion.setText("");
        tLicencia.setText("");
        tPrecio.setText("");
        tRequisitos.setText("");
        tAlternativa.setText("");
        lSoftware.setText(nombreFichero + "     " + numeroSoftware + "/" + (int)(miModelo.getSize()+1));
    }
    
    @FXML
    private void nuevoFichero()
    {
        nombreFichero = tfNombreFichero.getText();
        paneNew.setVisible(false);
        paneGlobal.setVisible(true);
        lSoftware.setText(nombreFichero + "     " + numeroSoftware + "/" + (int)(miModelo.getSize()+1));
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
    
    @FXML
    public void guardar()
    {
        if(numeroSoftware>=miModelo.getSize())
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
        numeroSoftware = 1;
        miTG=new ToggleGroup();
        tipoPlano.setToggleGroup(miTG);
        tipoBinario.setToggleGroup(miTG);
        miTG.selectToggle(tipoBinario);
        paneGlobal.setVisible(false);
        paneNew.setVisible(false);
        miModelo=new ModeloMultiusos();
        
    }    

    
}

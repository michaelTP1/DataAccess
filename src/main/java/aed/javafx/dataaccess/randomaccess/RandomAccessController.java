package aed.javafx.dataaccess.randomaccess;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class RandomAccessController implements Initializable {

    @FXML
    private BorderPane view;

    @FXML
    private Button vizualizarButton;

    @FXML
    private TextField idText;

    @FXML
    private Button buscarIdButton;

    @FXML
    private Button modificarButton;

    @FXML
    private Button insertarDatosButton;

    @FXML
    private TableView<?> TablaDatos;

    @FXML
    private TableColumn<?, ?> codColumn;

    @FXML
    private TableColumn<?, ?> nomColumn;

    @FXML
    private TableColumn<?, ?> codLigaColumn;

    @FXML
    private TableColumn<?, ?> localidadColumn;

    @FXML
    private TableColumn<?, ?> copasColumn;

    @FXML
    private TableColumn<?, ?> internacionalColumn;
    
    
    
    public RandomAccessController() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RandomAccessView.fxml"));
		loader.setController(this);
		loader.load();
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    

    @FXML
    void onBuscarPorIdAction(ActionEvent event) {

    }

    @FXML
    void onInsertarDatosAction(ActionEvent event) {

    }

    @FXML
    void onModificarCopasAction(ActionEvent event) {

    }

    @FXML
    void onVisualizarAction(ActionEvent event) {

    }
    
    public BorderPane getView() {
    	return view;
    }




	
}

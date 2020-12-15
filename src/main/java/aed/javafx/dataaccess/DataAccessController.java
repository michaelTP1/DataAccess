package aed.javafx.dataaccess;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import aed.javafx.dataaccess.fileaccess.FileAccessController;
import aed.javafx.dataaccess.randomaccess.RandomAccessController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class DataAccessController implements Initializable{
//vista	
    @FXML
    private BorderPane view;

   
	@FXML
    private Tab fileAccessTab;
	@FXML
	private Tab randomAccessTab;
	
	//controllers
	private FileAccessController fileAccessController=new FileAccessController();
	private RandomAccessController randomAccessController=new RandomAccessController();

	public DataAccessController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DataAccessView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		fileAccessTab.setContent(fileAccessController.getView());
		randomAccessTab.setText("Acceso aleatorio");
		randomAccessTab.setContent(randomAccessController.getView());
		
	}
	
	public BorderPane getView() {
		return view;
	}
	
}




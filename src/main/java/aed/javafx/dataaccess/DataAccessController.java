package aed.javafx.dataaccess;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import aed.javafx.dataaccess.fileaccess.FileAccessController;
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
	
	
	//controllers
	private FileAccessController fileAccessController=new FileAccessController();

	public DataAccessController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DataAccessView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		fileAccessTab.setContent(fileAccessController.getView());
	}
	
	public BorderPane getView() {
		return view;
	}
	
}




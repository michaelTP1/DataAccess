package aed.javafx.dataaccess;

import aed.javafx.dataaccess.fileaccess.FileAccessController;
import aed.javafx.dataaccess.fileaccess.FileAccessView;
import javafx.scene.control.TabPane;

public class DataAccessView extends TabPane{

	FileAccessView fileAccessTab= new FileAccessController().getView();
	
	
	
	public DataAccessView() {
		super();
		
		
		
		this.getTabs().addAll(fileAccessTab);
		
	}
}

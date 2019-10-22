package aed.javafx.dataaccess;

import aed.javafx.dataaccess.fileaccess.view.FileAccessView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class DataAccessView extends TabPane{

	FileAccessView fileAccess;
	
	
	
	public DataAccessView() {
		super();
		
		fileAccess=new FileAccessView();
		
		this.getTabs().addAll(fileAccess);
		
	}
}

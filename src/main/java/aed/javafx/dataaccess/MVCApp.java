package aed.javafx.dataaccess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCApp extends Application {
	
	//controllers
	
	private DataAccessController root;



	
	@Override
	public void start(Stage primaryStage) throws Exception {

		root=new DataAccessController();

		Scene scene = new Scene(root.getView(),680, 480);
		primaryStage.setTitle("ver");
		primaryStage.setScene(scene);
		primaryStage.show();

		

	}

	public static void main(String[] args) {
		launch(args);
	}

}

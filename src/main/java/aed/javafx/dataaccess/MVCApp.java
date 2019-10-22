package aed.javafx.dataaccess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCApp extends Application {

	// controllers



	// model




	
	@Override
	public void start(Stage primaryStage) throws Exception {

	

		// bindeos

		

		Scene scene = new Scene(new DataAccessView(),680, 480);
		
		
		primaryStage.setMinWidth(680);
		primaryStage.setMinHeight(480);
		primaryStage.setTitle("ver");
		primaryStage.setScene(scene);
		primaryStage.show();

		

	}

	public static void main(String[] args) {
		launch(args);
	}

}

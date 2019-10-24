package aed.javafx.dataaccess.fileaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.javafx.iio.ImageStorage.ImageType;

import aed.javafx.dataaccess.FileOrDirectoryNotFoundException;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileAccessController {

	private FileAccessView root = new FileAccessView();
	private FileAccessModel model = new FileAccessModel();

	private File file;

	private Alert errorAlert = new Alert(AlertType.ERROR);

	public FileAccessController() {

		errorAlert.setTitle("Error");
		errorAlert.setContentText("El fichero o directorio no existe");

		// bindeos

		model.currentPathProperty().bindBidirectional(root.getCurrentPathText().textProperty());
		model.destinyPathProperty().bind(root.getDestinyPathText().textProperty());

		model.isFileProperty().bindBidirectional(root.getFileCheckBox().selectedProperty());
		model.isDirectoryProperty().bindBidirectional(root.getFolderCheckBox().selectedProperty());

		root.getFileCheckBox().selectedProperty().addListener(e -> onFileCheckBoxSelectedAction(e));
		root.getFolderCheckBox().selectedProperty().addListener(e -> onFolderCheckBoxSelectedAction(e));

		model.fileContentProperty().bindBidirectional(root.getFileContentArea().textProperty());
		
		
		
		model.setCurrentPath(System.getProperty("user.home") + "\\FileAccess\\");

		root.getCreateButton().setOnAction(e -> onCreateButtonAction(e));
		root.getDelButton().setOnAction(e -> onDelButtonAction(e));
		root.getMoveButton().setOnAction(e -> onMoveButtonAction(e));
		root.getShowButton().setOnAction(e -> onShowButtonAction(e));
		root.getViewFileButton().setOnAction(e -> onViewFileButtonAction(e));
		root.getModFileButton().setOnAction(e -> onModFileButtonAction(e));

	}

	private void onFolderCheckBoxSelectedAction(Observable e) {
		
			model.setIsFile(false);

	}

	private void onFileCheckBoxSelectedAction(Observable e) {

			model.setIsDirectory(false);
	}

	private void onModFileButtonAction(ActionEvent e) {
		try {
			initFile();

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onViewFileButtonAction(ActionEvent e) {
		try {
			initFile();

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onShowButtonAction(ActionEvent e) {
		try {
			initFile();

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onMoveButtonAction(ActionEvent e) {
		try {
			initFile();

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onDelButtonAction(ActionEvent e) {
		try {
			initFile();

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onCreateButtonAction(ActionEvent e) {
		try {
			initFile();

			if (!model.getDestinyPath().isBlank()) {

				file = new File(model.getCurrentPath().concat(model.getDestinyPath()));

				if(model.isIsFile()) {
					FileWriter fw=new FileWriter(file);
					PrintWriter writer=new PrintWriter(fw);
					
					writer.print(model.getFileContent());
					writer.flush();
					
					writer.close();
				}
				
				else
					
					file.mkdir();
				
			}
			else {
				Alert noNameAlert=new Alert(AlertType.ERROR);
				noNameAlert.setTitle("Error");
				noNameAlert.setHeaderText("Introduzca nombre de fichero o directorio");
				noNameAlert.setContentText("Necesita introducir el nombre del fichero o directorio para crearlo");
				noNameAlert.showAndWait();
			}
			
			

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		
		}catch (FileNotFoundException e2) {
			Alert fileOrDirectoryNameAlert=new Alert(AlertType.ERROR);
			fileOrDirectoryNameAlert.setTitle("Error");
			fileOrDirectoryNameAlert.setHeaderText("Nombre incorrecto");
			fileOrDirectoryNameAlert.setContentText("Es posible que ya exista un fichero o directorio con ese nombre.\nPor favor, escoja otro nombre");
			fileOrDirectoryNameAlert.showAndWait();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

	private boolean initFile() throws FileOrDirectoryNotFoundException {
		file = new File(model.getCurrentPath());

		if (!file.exists())
			throw new FileOrDirectoryNotFoundException();

		return file.isFile();
	}

	public FileAccessView getView() {
		return root;
	}

}

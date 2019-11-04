package aed.javafx.dataaccess.fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class FileAccessController {

	private FileAccessView root = new FileAccessView();
	private FileAccessModel model = new FileAccessModel();

	private Alert errorAlert = new Alert(AlertType.ERROR);
	Alert notFileAlert = new Alert(AlertType.ERROR);

	public FileAccessController() {
		
		notFileAlert.setTitle("Error");
		notFileAlert.setHeaderText("La ruta especificada no corresponde a un fichero");
		notFileAlert.setContentText("Por favor, compruebe la ruta a la que desea acceder e inténtelo de nuevo");
		
		errorAlert.setTitle("Error");
		errorAlert.setContentText("El fichero o directorio no existe");

		// bindeos

		model.currentPathProperty().bindBidirectional(root.getCurrentPathText().textProperty());
		model.destinyPathProperty().bind(root.getDestinyPathText().textProperty());

		model.isFileProperty().bindBidirectional(root.getFileRadioButton().selectedProperty());
		model.isDirectoryProperty().bindBidirectional(root.getDirectoryRadioButton().selectedProperty());

		root.getFileRadioButton().setOnAction(e -> onFileRadioButtonAction(e));
		root.getDirectoryRadioButton().setOnAction(e -> onDirectoryRadioButtonAction(e));
		
		model.fileListProperty().bindBidirectional(root.getFileListView().itemsProperty());
		model.selectedProperty().bind(root.getFileListView().getSelectionModel().selectedIndexProperty());

		model.fileContentProperty().bindBidirectional(root.getFileContentArea().textProperty());

		model.setCurrentPath(System.getProperty("user.home") + File.separator + "FileAccess" + File.separator);

		root.getFileListView().setOnMouseClicked(e -> onFileListMouseClicked(e));
		model.selectedProperty().bind(root.getFileListView().getSelectionModel().selectedIndexProperty());

		model.setFile(new File(model.getCurrentPath()));
		if (!model.getFile().exists())
			model.getFile().mkdir();

		root.getCreateButton().setOnAction(e -> onCreateButtonAction(e));
		root.getDelButton().setOnAction(e -> onDelButtonAction(e));
		root.getMoveButton().setOnAction(e -> onMoveButtonAction(e));
		root.getShowButton().setOnAction(e -> onShowButtonAction(e));
		root.getViewFileButton().setOnAction(e -> onViewFileButtonAction(e));
		root.getModFileButton().setOnAction(e -> onModFileButtonAction(e));

	}

	private void onCreateButtonAction(ActionEvent e) {

		try {
			initFile();

			if (!model.getDestinyPath().isBlank()) {
				model.setFile(new File(model.getCurrentPath().concat(model.getDestinyPath())));

				if (model.getFile().exists()) {
					Alert alreadyExistsAlert = new Alert(AlertType.ERROR);
					alreadyExistsAlert.setTitle("Error");
					alreadyExistsAlert.setHeaderText("El fichero ya existe");
					alreadyExistsAlert.setContentText(
							"Introduzca otro nombre o acceda a el mediante los botones correspondientes");
					alreadyExistsAlert.showAndWait();
				} else {

					if (model.isIsFile()) {
						FileWriter fw = new FileWriter(model.getFile());
						PrintWriter writer = new PrintWriter(fw);

						writer.print(model.getFileContent());
						writer.flush();

						writer.close();

					} else

						model.getFile().mkdir();

				}
			} else {
				Alert noNameAlert = new Alert(AlertType.ERROR);
				noNameAlert.setTitle("Error");
				noNameAlert.setHeaderText("Introduzca nombre de fichero o directorio");
				noNameAlert.setContentText("Necesita introducir el nombre del fichero o directorio para crearlo");
				noNameAlert.showAndWait();
			}

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();

		} catch (FileNotFoundException e2) {
			Alert fileOrDirectoryNameAlert = new Alert(AlertType.ERROR);
			fileOrDirectoryNameAlert.setTitle("Error");
			fileOrDirectoryNameAlert.setHeaderText("Nombre incorrecto");
			fileOrDirectoryNameAlert.setContentText(
					"Es posible que ya exista un fichero o directorio con ese nombre.\nPor favor, escoja otro nombre");
			fileOrDirectoryNameAlert.showAndWait();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void onDelButtonAction(ActionEvent e) {

		try {
			initFile();
			if (!model.getDestinyPath().isBlank()) {
				model.setFile(new File(model.getCurrentPath().concat(model.getDestinyPath())));
				if (model.getFile().exists()) {
					if (!model.getFile().isFile())
						directoryDeleter(model.getFile());
					model.getFile().delete();
				}

			}
		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onMoveButtonAction(ActionEvent e) {
		try {
			initFile();
			if (model.getFile().isFile())
				Files.move(Paths.get(model.getCurrentPath()),
						Paths.get(model.getDestinyPath() + model.getFile().getName()));
			else {

				File destiny = new File(model.getDestinyPath() + model.getFile().getName());
				destiny.mkdir();

				directoryMover(model.getFile());
				model.getFile().delete();

			}

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		} catch (IOException e1) {
			Alert moveErrorAlert = new Alert(AlertType.ERROR);
			moveErrorAlert.setTitle("Error");
			moveErrorAlert.setHeaderText("Error al mover el fichero");
			moveErrorAlert.setContentText("Compruebe que la ruta de destino es correcta");
			moveErrorAlert.showAndWait();
			e1.printStackTrace();
		}

	}

	private void onShowButtonAction(ActionEvent e) {
		try {

			changeFileListSelection();

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void onViewFileButtonAction(ActionEvent e) {
		try {
			initFile();
			if (model.getFile().isDirectory()) {
				notFileAlert.showAndWait();
			} else {
				readFile(model.getFile());
			}

		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		}

	}

	private void readFile(File file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String auxString = new String("");
			String line = new String();

			line = br.readLine();

			while (line != null) {
				auxString += line + "\n";
				line = br.readLine();

			}

			br.close();
			model.setFileContent(auxString);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void onModFileButtonAction(ActionEvent e) {
		try {
			initFile();
			if(model.getFile().isFile()) {
			FileWriter fw = new FileWriter(model.getFile());
			PrintWriter writer = new PrintWriter(fw);

			writer.print(model.getFileContent());
			writer.flush();

			writer.close();

			}else {
				notFileAlert.showAndWait();
			}
		} catch (FileOrDirectoryNotFoundException e2) {
			errorAlert.showAndWait();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private boolean initFile() throws FileOrDirectoryNotFoundException {
		model.setFile(new File(model.getCurrentPath()));

		if (!model.getFile().exists())
			throw new FileOrDirectoryNotFoundException();

		if (!model.getDestinyPath().isBlank())
			if (model.getDestinyPath().charAt(model.getDestinyPath().length() - 1) != '\\')
				model.setDestinyPath(model.getDestinyPath() + '\\');

		return model.getFile().isFile();
	}

	private void onDirectoryRadioButtonAction(ActionEvent e) {
		model.setIsFile(false);

	}

	private void onFileRadioButtonAction(ActionEvent e) {
		model.setIsDirectory(false);
	}

	private void onFileListMouseClicked(MouseEvent e) {
		try {
			if (e.getClickCount() == 2) {
				model.setFileContent("");;
				File selectedFile = model.getFileList().get(model.getSelected());
				if (selectedFile.isDirectory()) {
					model.setCurrentPath(
							selectedFile.getAbsolutePath());
					changeFileListSelection();
				} else {
					readFile(selectedFile);

				}

			}
		} catch (FileOrDirectoryNotFoundException ex) {
			errorAlert.showAndWait();
		}

	}

	private void changeFileListSelection() throws FileOrDirectoryNotFoundException {
		initFile();
		
		model.getFileList().clear();
		model.getFileList().addAll(Arrays.asList(model.getFile().listFiles()));

	}

	private void directoryDeleter(File delFile) {

		File[] files = delFile.listFiles();

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory())
				directoryDeleter(files[i]);
			files[i].delete();
		}

	}

	private void directoryMover(File movFile) {

		File[] files = movFile.listFiles();
		File[] destiny = new File[files.length];

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				destiny[i] = new File(model.getDestinyPath() + model.getFile().getName()
						+ files[i].getPath().toString().substring(model.getCurrentPath().length() - 1));
				destiny[i].mkdir();
				directoryMover(files[i]);
			} else {
				try {

					Files.move(Paths.get(files[i].getPath()),
							Paths.get(model.getDestinyPath() + model.getFile().getName()
									+ files[i].getPath().toString().substring(model.getCurrentPath().length() - 1)));

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			files[i].delete();
		}

	}

	public FileAccessView getView() {
		return root;
	}

}

package aed.javafx.dataaccess.fileaccess;

import java.io.File;


import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class FileAccessView extends GridPane {


	
	private TextField currentPathText, destinyPathText;
	private ListView<File> fileListView;
	private RadioButton fileRadioButton, directoryRadioButton;
	private Button createButton, delButton, moveButton, showButton, modFileButton,backButton;
	private TextArea fileContentArea;
	private HBox buttonRowBox;

	public FileAccessView() {
		super();

	

		

		currentPathText = new TextField();

		destinyPathText = new TextField();
		destinyPathText.setPromptText("Carpeta o fichero a crear, modificar, eliminar o destino a mover");

		fileListView = new ListView<File>();
		fileListView.setMaxHeight(150);
		fileListView.setPrefHeight(50);

		fileRadioButton = new RadioButton("Es fichero");
		fileRadioButton.setSelected(true);
		

		directoryRadioButton = new RadioButton("Es carpeta");

		createButton = new Button("Crear");

		delButton = new Button("Eliminar");

		moveButton = new Button("Mover");
		
		backButton=new Button("volver");

		buttonRowBox = new HBox(createButton, delButton, moveButton,new Separator(), fileRadioButton, directoryRadioButton);
		buttonRowBox.setSpacing(5);
		buttonRowBox.setAlignment(Pos.BASELINE_LEFT);

		showButton = new Button("Ver contenido");

		

		modFileButton = new Button("Modificar fichero");

		VBox fileButtonBox = new VBox( modFileButton);
		fileButtonBox.setSpacing(5);

		fileContentArea = new TextArea();

		this.setPadding(new Insets(5));
		this.setHgap(5);
		this.setVgap(5);

		this.addRow(0, new Label("Ruta Actual: "), currentPathText);
		this.addRow(1, buttonRowBox);
		this.addRow(2, destinyPathText);
		this.addRow(3, showButton, backButton);
		this.addRow(4, fileListView);
		this.addRow(5, fileButtonBox, fileContentArea);

		GridPane.setColumnSpan(buttonRowBox, 2);
		GridPane.setColumnSpan(destinyPathText, 2);
		GridPane.setColumnSpan(showButton, 3);
		GridPane.setColumnSpan(fileListView, 2);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(),

		};
		this.getColumnConstraints().setAll(cols);

		cols[0].setHalignment(HPos.LEFT);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		RowConstraints[] row = { new RowConstraints(), new RowConstraints(), new RowConstraints(), new RowConstraints(),
				new RowConstraints(), new RowConstraints() };

		this.getRowConstraints().setAll(row);

		row[4].setVgrow(Priority.SOMETIMES);
		row[4].setPercentHeight(15);
		row[4].setFillHeight(true);
		row[5].setVgrow(Priority.SOMETIMES);
//		row[5].setFillHeight(true);
		row[5].setValignment(VPos.CENTER);

		this.setPadding(new Insets(5, 5, 5, 5));

		

		

	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	public RadioButton getFileRadioButton() {
		return fileRadioButton;
	}

	public RadioButton getDirectoryRadioButton() {
		return directoryRadioButton;
	}

	public TextField getCurrentPathText() {
		return currentPathText;
	}

	public TextField getDestinyPathText() {
		return destinyPathText;
	}

	public ListView<File> getFileListView() {
		return fileListView;
	}

	

	public Button getCreateButton() {
		return createButton;
	}

	public Button getDelButton() {
		return delButton;
	}

	public Button getMoveButton() {
		return moveButton;
	}

	public Button getShowButton() {
		return showButton;
	}



	public Button getModFileButton() {
		return modFileButton;
	}

	public TextArea getFileContentArea() {
		return fileContentArea;
	}

	public HBox getButtonRowBox() {
		return buttonRowBox;
	}
}

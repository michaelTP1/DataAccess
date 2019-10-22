package aed.javafx.dataaccess.fileaccess.view;

import java.io.File;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

public class FileAccessView extends Tab {

	private BorderPane root;
	private Label nameLabel;
	private GridPane contentPane;
	private TextField pathText, newPathText;
	private ListView<File> fileListView;
	private CheckBox folderCheckBox, fileCheckBox;
	private Button createButton, delButton, moveButton, showButton, viewFileButton, modFileButton;
	private TextArea fileContentArea;
	private HBox buttonRowBox;

	public FileAccessView() {
		super();

		nameLabel = new Label("Michael Jonay Trujillo Padilla");

		root = new BorderPane();

		contentPane = new GridPane();

		pathText = new TextField();

		newPathText = new TextField();
		newPathText.setPromptText("Carpeta o fichero a crear, modificar, eliminar o destino a mover");

		fileListView = new ListView<File>();
		fileListView.setMaxHeight(150);
		fileListView.setPrefHeight(50);

		folderCheckBox = new CheckBox("Es carpeta");

		fileCheckBox = new CheckBox("Es fichero");

		createButton = new Button("Crear");

		delButton = new Button("Eliminar");

		moveButton = new Button("Mover");

		buttonRowBox = new HBox(createButton, delButton, moveButton, folderCheckBox, fileCheckBox);
		buttonRowBox.setSpacing(5);
		buttonRowBox.setAlignment(Pos.BASELINE_LEFT);

		showButton = new Button("Ver ficheros y carpetas");

		viewFileButton = new Button("Ver contenido del fichero");
		viewFileButton.setPrefWidth(viewFileButton.getMaxWidth());

		modFileButton = new Button("Modificar fichero");

		VBox fileButtonBox = new VBox(viewFileButton, new Label(), new Label(), modFileButton);
		fileButtonBox.setSpacing(5);

		fileContentArea = new TextArea();

		contentPane.setPadding(new Insets(5));
		contentPane.setHgap(5);
		contentPane.setVgap(5);

		contentPane.addRow(0, new Label("Ruta Actual: "), pathText);
		contentPane.addRow(1, buttonRowBox);
		contentPane.addRow(2, newPathText);
		contentPane.addRow(3, showButton);
		contentPane.addRow(4, fileListView);
		contentPane.addRow(5, fileButtonBox, fileContentArea);

		
		GridPane.setColumnSpan(buttonRowBox, 2);
		GridPane.setColumnSpan(newPathText, 2);
		GridPane.setColumnSpan(showButton, 2);
		GridPane.setColumnSpan(fileListView, 2);
		GridPane.setColumnSpan(viewFileButton, 2);
	
		

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(),

		};
		contentPane.getColumnConstraints().setAll(cols);

		cols[0].setHalignment(HPos.LEFT);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		RowConstraints[] row = { new RowConstraints(), new RowConstraints(), new RowConstraints(), new RowConstraints(),
				new RowConstraints(), new RowConstraints() };

		contentPane.getRowConstraints().setAll(row);

		row[5].setVgrow(Priority.ALWAYS);
		row[5].setFillHeight(true);

		contentPane.setPadding(new Insets(5, 5, 5, 5));

		root.setTop(nameLabel);
		root.setCenter(contentPane);
		BorderPane.setAlignment(nameLabel, Pos.CENTER);
		BorderPane.setAlignment(root, Pos.CENTER);

		setContent(root);
		setText("Acceso a ficheros");

	}

	public BorderPane getRoot() {
		return root;
	}

	public GridPane getContentPane() {
		return contentPane;
	}

	public TextField getPathText() {
		return pathText;
	}

	public TextField getNewPathText() {
		return newPathText;
	}

	public ListView<File> getFileListView() {
		return fileListView;
	}

	public CheckBox getFolderCheckBox() {
		return folderCheckBox;
	}

	public CheckBox getFileCheckBox() {
		return fileCheckBox;
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

	public Button getViewFileButton() {
		return viewFileButton;
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

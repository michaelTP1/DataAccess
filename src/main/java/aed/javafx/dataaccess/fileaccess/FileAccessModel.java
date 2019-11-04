package aed.javafx.dataaccess.fileaccess;

import java.io.File;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class FileAccessModel {
	
	private StringProperty currentPath=new SimpleStringProperty();
	private StringProperty destinyPath=new SimpleStringProperty();
	private BooleanProperty isFile=new SimpleBooleanProperty();
	private BooleanProperty isDirectory=new SimpleBooleanProperty();
	private StringProperty fileContent=new SimpleStringProperty();
	private IntegerProperty selected=new SimpleIntegerProperty();
	private ListProperty<File> fileList=new SimpleListProperty<File>();
	
	


	private File file;
	
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public final StringProperty currentPathProperty() {
		return this.currentPath;
	}
	
	public final String getCurrentPath() {
		return this.currentPathProperty().get();
	}
	
	public final void setCurrentPath(final String currentPath) {
		this.currentPathProperty().set(currentPath);
	}
	
	public final StringProperty destinyPathProperty() {
		return this.destinyPath;
	}
	
	public final String getDestinyPath() {
		return this.destinyPathProperty().get();
	}
	
	public final void setDestinyPath(final String destinyPath) {
		this.destinyPathProperty().set(destinyPath);
	}

	public final BooleanProperty isFileProperty() {
		return this.isFile;
	}
	

	public final boolean isIsFile() {
		return this.isFileProperty().get();
	}
	

	public final void setIsFile(final boolean isFile) {
		this.isFileProperty().set(isFile);
	}
	

	public final BooleanProperty isDirectoryProperty() {
		return this.isDirectory;
	}
	

	public final boolean isIsDirectory() {
		return this.isDirectoryProperty().get();
	}
	

	public final void setIsDirectory(final boolean isDirectory) {
		this.isDirectoryProperty().set(isDirectory);
	}

	public final StringProperty fileContentProperty() {
		return this.fileContent;
	}
	

	public final String getFileContent() {
		return this.fileContentProperty().get();
	}
	

	public final void setFileContent(final String fileContent) {
		this.fileContentProperty().set(fileContent);
	}

	public final IntegerProperty selectedProperty() {
		return this.selected;
	}
	

	public final int getSelected() {
		return this.selectedProperty().get();
	}
	

	public final void setSelected(final int selected) {
		this.selectedProperty().set(selected);
	}

	public final ListProperty<File> fileListProperty() {
		return this.fileList;
	}
	

	public final ObservableList<File> getFileList() {
		return this.fileListProperty().get();
	}
	

	public final void setFileList(final ObservableList<File> fileList) {
		this.fileListProperty().set(fileList);
	}
	
	
	
	
	
	
	

}

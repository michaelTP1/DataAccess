package aed.javafx.dataaccess.fileaccess;

import java.io.File;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileAccessModel {
	
	private StringProperty currentPath=new SimpleStringProperty();
	private StringProperty destinyPath=new SimpleStringProperty();
	private BooleanProperty isFile=new SimpleBooleanProperty();
	private BooleanProperty isDirectory=new SimpleBooleanProperty();
	private StringProperty fileContent=new SimpleStringProperty();
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
	
	
	
	
	

}

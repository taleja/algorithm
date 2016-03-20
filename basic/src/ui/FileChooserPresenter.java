package ui;

import javax.swing.JFileChooser;

public class FileChooserPresenter {

	public String invokeFileAndDirectoryChooser() {
		JFileChooser chooser  = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));  
		chooser.setDialogTitle("Path chooser");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		
		chooser.setAcceptAllFileFilterUsed(false); 
		
		if(chooser.showOpenDialog(chooser.getParent()) == JFileChooser.APPROVE_OPTION){
		    System.out.println("getSelectedFile:  " +  chooser.getSelectedFile());
		} else {
			System.out.println("No Selection"); 
		}
		 
		return chooser.getSelectedFile().getAbsolutePath();
	}
}

package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class FileScannerView{
	

	private static final long serialVersionUID = 1L; 

	private ChildSearch chilSearcher;
	private FileScannerPresenter presenter;

	public FileScannerView (FileScannerPresenter presenter){
		this.presenter = presenter;
		initLogic();  		
	}

	private void initLogic() {

		presenter.getButtonBrowse().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filePath = invokeFileAndDirectoryChooser();	
				presenter.getSearchTextField().setText(filePath); 
			}
		});
			
		presenter.getButtonStart().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.showCancelButton();
				chilSearcher = new ChildSearch(presenter.getSearchTextField().getText());
				chilSearcher.addObserver(new Observer() {
					
					@Override
					public void update(Observable o, Object arg) {
						Object[] array = chilSearcher.getChildren().toArray();
						presenter.showSearchResult(array);
					}
				});
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
				///parallel thread
				Thread myThread = new Thread(chilSearcher);
				myThread.setName("myThreadName");
				myThread.start();
			}
		});

		presenter.getButtonCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.showStartButton();
				chilSearcher.stopSearch();
			}
		});
	}

	
	private String invokeFileAndDirectoryChooser() {
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

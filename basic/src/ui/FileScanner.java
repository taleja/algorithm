package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class FileScanner extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private JSplitPane contentSplitPane;
	private JSplitPane mainSplitPane;

	public FileScanner (){
		initUI();  		
	}

	private void initUI() {
		setTitle("File Scanner");
		setSize(600, 500);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		mainSplitPane = new JSplitPane(); 
		mainSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(mainSplitPane, BorderLayout.CENTER);
		
		////////////// SearchPanel
		JPanel searchButtonPanel = new JPanel();
		searchButtonPanel.setName("searchButtonPanel");
		searchButtonPanel.setLayout(new BorderLayout());
		mainSplitPane.setTopComponent(searchButtonPanel);
		
		JTextField searchTextField = new JTextField();
		searchTextField.setName("searchTextField");
		searchTextField.setPreferredSize(new Dimension(400, mainSplitPane.getTopComponent().getHeight())); 
		searchButtonPanel.add(searchTextField, BorderLayout.LINE_START);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.setName("buttonSearch");
		buttonSearch.setPreferredSize(new Dimension(100, searchTextField.getHeight()));  
		searchButtonPanel.add(buttonSearch, BorderLayout.CENTER);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setName("buttonSearch");
		buttonCancel.setPreferredSize(new Dimension(100, searchTextField.getHeight())); 
		searchButtonPanel.add(buttonCancel, BorderLayout.LINE_END);
		//////////////////////////////////////////////////////////////
		
		
		contentSplitPane = new JSplitPane(); 
		contentSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		getContentPane().add(mainSplitPane, BorderLayout.CENTER);
		mainSplitPane.setBottomComponent(contentSplitPane);
		
		JScrollPane scrollPane_right = new JScrollPane();
		scrollPane_right.setName("scrollPane_right");
		scrollPane_right.setSize(contentSplitPane.getWidth(), contentSplitPane.getHeight());
		
		JScrollPane scrollPane_left = new  JScrollPane();
		scrollPane_left.setName("scrollPane_left");
		scrollPane_left.setSize(contentSplitPane.getWidth(), contentSplitPane.getHeight());
		
		contentSplitPane.setRightComponent(scrollPane_right);
		contentSplitPane.setLeftComponent(scrollPane_left);
	}

}

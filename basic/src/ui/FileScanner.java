package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class FileScanner extends JFrame{
	

	private static final long serialVersionUID = 1L; 
	private JSplitPane contentSplitPane;
	private JSplitPane mainSplitPane;
	private JPanel cardPanel;
	private final static String start = "START";
	private final static String cancel = "CANCEL";
	private CardLayout cardLayot = new CardLayout();

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
		
		
		
		JButton buttonBrowse = new JButton("Browse");
		buttonBrowse.setName("buttonSearch");
		buttonBrowse.setPreferredSize(new Dimension(100, searchTextField.getHeight()));  
		searchButtonPanel.add(buttonBrowse, BorderLayout.CENTER);
		buttonBrowse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filePath = invokeFileAndDirectoryChooser();	
				searchTextField.setText(filePath); 
			}
		});
			
		cardPanel = new JPanel(cardLayot);
		cardPanel.setPreferredSize(new Dimension(100, searchTextField.getHeight())); 
		cardPanel.setName("cardPanel");
		searchButtonPanel.add(cardPanel, BorderLayout.LINE_END);  
		
		JButton buttonStart = new JButton("Start");
		buttonStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayot.show(cardPanel, cancel);
			}
		});
		
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setName("buttonSearch");
		buttonCancel.setPreferredSize(new Dimension(100, searchTextField.getHeight())); 
		buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayot.show(cardPanel, start); 
				
			}
		});

		
		cardPanel.add(buttonStart, start); 
		cardPanel.add(buttonCancel, cancel); 
		
		searchButtonPanel.add(cardPanel, BorderLayout.LINE_END);
		cardLayot.show(cardPanel, start);
		
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
	
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cardPanel.getLayout());
        cl.show(cardPanel, (String)evt.getItem());
    }
	
	private String invokeFileAndDirectoryChooser() {
		JFileChooser chooser  = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));  
		chooser.setDialogTitle("Path chooser");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		
		chooser.setAcceptAllFileFilterUsed(false); 
		
		if(chooser.showOpenDialog(chooser.getParent()) == JFileChooser.APPROVE_OPTION){
		    System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
		} else {
			System.out.println("No Selection"); 
		}
		 
		return chooser.getCurrentDirectory().toString();
	}

}

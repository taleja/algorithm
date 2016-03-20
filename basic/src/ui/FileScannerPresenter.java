package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class FileScannerPresenter extends JFrame{

	private JSplitPane contentSplitPane;
	private JSplitPane mainSplitPane;
	private JPanel cardPanel;
	private JTextField searchTextField;
	private JList listOfChildren;
	private JScrollPane scrollPane_right;
	private JScrollPane scrollPane_left;
	private final static String start = "START";
	private final static String cancel = "CANCEL";
	private CardLayout cardLayot = new CardLayout();
	private JButton buttonStart;
	private JButton buttonCancel;
	private JButton buttonBrowse;
	
	public FileScannerPresenter() {
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
		
		searchTextField = new JTextField(".");
		searchTextField.setName("searchTextField");
		searchTextField.setPreferredSize(new Dimension(400, mainSplitPane.getTopComponent().getHeight())); 
		searchButtonPanel.add(searchTextField, BorderLayout.LINE_START);
		
		
		
		buttonBrowse = new JButton("Browse");
		buttonBrowse.setName("buttonSearch");
		buttonBrowse.setPreferredSize(new Dimension(100, searchTextField.getHeight()));  
		searchButtonPanel.add(buttonBrowse, BorderLayout.CENTER);

		cardPanel = new JPanel(cardLayot);
		cardPanel.setPreferredSize(new Dimension(100, searchTextField.getHeight())); 
		cardPanel.setName("cardPanel");
		searchButtonPanel.add(cardPanel, BorderLayout.LINE_END);  
		
		buttonStart = new JButton("Start");

		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setName("buttonSearch");
		buttonCancel.setPreferredSize(new Dimension(100, searchTextField.getHeight())); 
		
		cardPanel.add(buttonStart, start); 
		cardPanel.add(buttonCancel, cancel); 
		
		searchButtonPanel.add(cardPanel, BorderLayout.LINE_END);
		cardLayot.show(cardPanel, start);
		
		//////////////////////////////////////////////////////////////
		
		
		contentSplitPane = new JSplitPane(); 
		contentSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		getContentPane().add(mainSplitPane, BorderLayout.CENTER);
		mainSplitPane.setBottomComponent(contentSplitPane);
		
		scrollPane_right = new JScrollPane(new JList());
		scrollPane_right.setName("scrollPane_right");
		scrollPane_right.setSize(contentSplitPane.getWidth(), contentSplitPane.getHeight());
		
		scrollPane_left = new  JScrollPane();
		scrollPane_left.setName("scrollPane_left");
		scrollPane_left.setPreferredSize(new Dimension(100,200)); 
		
		contentSplitPane.setRightComponent(scrollPane_right);
		contentSplitPane.setLeftComponent(scrollPane_left);
	
	}

	public JSplitPane getContentSplitPane() {
		return contentSplitPane;
	}

	public JSplitPane getMainSplitPane() {
		return mainSplitPane;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

	public JTextField getSearchTextField() {
		return searchTextField;
	}

	public JList getListOfChildren() {
		return listOfChildren;
	}

	public JScrollPane getScrollPane_right() {
		return scrollPane_right;
	}

	public JScrollPane getScrollPane_left() {
		return scrollPane_left;
	}

	public static String getStart() {
		return start;
	}

	public static String getCancel() {
		return cancel;
	}

	public CardLayout getCardLayot() {
		return cardLayot;
	}

	public JButton getButtonStart() {
		return buttonStart;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	public JButton getButtonBrowse() {
		return buttonBrowse;
	}
	
	public void showCancelButton(){
		cardLayot.show(cardPanel, cancel);
	}
	
	public void showStartButton(){
		cardLayot.show(cardPanel, start); 
	}
	
	public void showSearchResult(Object[] array){
		listOfChildren = new JList<>(array);
		scrollPane_left.setViewportView(listOfChildren); 
		cardLayot.show(cardPanel, start);
		repaint();
	};
}

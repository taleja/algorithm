package ui;

public class AppStarter {

	public static void main(String[] args){
		FileScannerPresenter presenter = new FileScannerPresenter();
		FileChooserPresenter filePresenter = new FileChooserPresenter();
		presenter.setVisible(true);
		FileScannerView fileScanner = new FileScannerView(presenter, filePresenter);
	}
}

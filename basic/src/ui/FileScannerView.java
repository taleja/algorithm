package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class FileScannerView{
	
	private ChildSearch childSearcher;
	private FileScannerPresenter presenter;
	private FileChooserPresenter filePresenter;

	public FileScannerView (FileScannerPresenter presenter, FileChooserPresenter filePresenter){
		this.presenter = presenter;
		this.filePresenter = filePresenter;
		initLogic();  		
	}

	private void initLogic() {

		presenter.onBrowseClick(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filePath = filePresenter.invokeFileAndDirectoryChooser();	
				presenter.showFilePath(filePath);
			}
		});
			
		presenter.onStartClick(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.showCancelButton();
				childSearcher = new ChildSearch(presenter.getFilePath());
				childSearcher.addObserver(new Observer() {
					
					@Override
					public void update(Observable o, Object arg) {
						Object[] array = childSearcher.getChildren().toArray();
						presenter.showSearchResult(array);
					}
				});
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
				///parallel thread
				Thread myThread = new Thread(childSearcher);
				myThread.setName("myThreadName");
				myThread.start();
			}
		});

		presenter.onCancelClick(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.showStartButton();
				childSearcher.stopSearch();
			}
		});
	}
}

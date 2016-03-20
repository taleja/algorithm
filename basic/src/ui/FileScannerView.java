package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FileScannerView{
	
	private FileScannerPresenter presenter;
	private FileChooserPresenter filePresenter;
	private FileSearchService fileSearchService;

	public FileScannerView (FileScannerPresenter presenter, FileChooserPresenter filePresenter, FileSearchService 
			fileSearchService){
		this.presenter = presenter;
		this.filePresenter = filePresenter;
		this.fileSearchService = fileSearchService;
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
				fileSearchService.searchFiles(presenter.getFilePath(), new Observer() {
					
					@Override
					public void update(Observable o, Object arg) {
						Object[] array = (( List<String>) arg).toArray();
						presenter.showSearchResult(array);
					}
				});
			}
		});

		presenter.onCancelClick(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.showStartButton();
				fileSearchService.stopSearch();
			}
		});
	}
}

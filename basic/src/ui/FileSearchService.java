package ui;

import java.util.Observable;
import java.util.Observer;

public class FileSearchService {
	
	private ChildSearch childSearcher;

	public void searchFiles(String filePath, Observer observer){
		
		childSearcher = new ChildSearch(filePath);
		childSearcher.addObserver(observer);
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		///parallel thread
		Thread myThread = new Thread(childSearcher);
		myThread.setName("myThreadName");
		myThread.start();
	}

	public void stopSearch() {
		childSearcher.stopSearch();
	}
	
}

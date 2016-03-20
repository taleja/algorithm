package ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ChildSearch extends Observable implements Runnable {

	private String startSearch;
	private List<String> listOfFiles = new ArrayList<String>();
	private volatile boolean isStoped;
	Thread thread;

	ChildSearch(String startSearch) {
		this.startSearch = startSearch;
	}

	@Override
	public void run() {
		thread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		File actual = new File(startSearch);
		for (File f : actual.listFiles()) {
			if(isStoped){
				break;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
			}
			
			listOfFiles.add(f.getName());
		}
		setChanged();
		notifyObservers();
		
	}

	public List<String> getChildren() {
		return listOfFiles;
	}
	
	public void stopSearch(){
		this.isStoped = true;
		thread.interrupt();
	}
}

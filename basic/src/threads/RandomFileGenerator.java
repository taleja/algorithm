package threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomFileGenerator implements Runnable{

	private volatile boolean isStoped;
	
	@Override
	public void run() {
		File file = new File("Random Value");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			while(!isStoped){
				
				Random random = new Random();
				Integer in = random.nextInt();
				fileWriter.write(in.toString() + "\n");		
				fileWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} 
	
	public void terminate(){
		isStoped = true;
	}

}

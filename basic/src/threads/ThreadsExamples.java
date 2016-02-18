package threads;

import java.io.IOException;

public class ThreadsExamples {

	public static void main(String[] args) throws IOException{ 
		RandomFileGenerator rfg = new RandomFileGenerator();		
		Thread myThread = new Thread(rfg);
		//myThread.setDaemon(true);
		myThread.start();
		
		System.out.println("Press any key to exit...");
		System.in.read();
		
		rfg.terminate();
		System.out.println("Terminated");
		
	}
}

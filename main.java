/*Thomas Harrison
cs 370
PA4- Producer Consumer problem
4/11/2012

Class main

Driver program. Makes threads and exits
*/
public class main {

	
	
	 
	public static void main(String[] args) throws InterruptedException {
		//creates buffer and threads	
		buffer b= new buffer();
		Producer p=new Producer(b);
		Consumer c=new Consumer(b);
		Thread p_thread = new Thread(p);
		Thread c_thread= new Thread(c);
        	p_thread.start();
        	c_thread.start();
		// joins c_thread because that will be the last one to close due to the nature of a producer and consumer
        	c_thread.join();
		// final message before closing	
       		System.out.println("\nProducer: Finished generating 1,000,000 items");
        	System.out.println("\nConsumer: Finished consuming 1,000,000 items");
        	System.out.println("\nexiting ...");
	
		
	}
}

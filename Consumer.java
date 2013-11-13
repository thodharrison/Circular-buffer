/*
Thomas Harrison
cs 370
PA4- Producer Consumer problem
4/11/2012

Class Consumer

Thread In charge of consuming from the buffer to the buffer
it calls the buffer's remove method to do so. It consumes 1000000 times.*/
public class Consumer implements Runnable{

	
	int count;
	buffer buff;
	public Consumer(buffer b)
	{
		count=0;
		buff=b;
		
	}
	
	public void run() {
		while(count<1000000)
		{
			
				try {
					consume();
					count++;
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
		
	}
	
	public void consume() throws InterruptedException
	{
		
		buff.remove();
		
	}

}

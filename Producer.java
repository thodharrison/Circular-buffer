import java.util.Random;
/*
Thomas Harrison
cs 370
PA4- Producer Consumer problem
4/11/2012

Class Producer

Thread In charge of producing randomn doubles and appending them to the buffer
it calls the buffer's add method to do so It produces 1000000 times.
*/

public class Producer implements Runnable {
	int count;
	buffer buff;
	
	public Producer(buffer b)
	{
		count=0;
		buff=b;
		
	}

	@Override
	public void run() {
		while(count<1000000)
		{
			
				try {
					produce();
					count++;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			
		}
		
		
		
	}
	public void produce() throws InterruptedException
	{Random random = new Random();
	double d=random.nextDouble() * 100.0;
	buff.add(d);		
	}


}

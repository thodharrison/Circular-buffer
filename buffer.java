/*
Thomas Harrison
cs 370
PA4- Producer Consumer problem
4/11/2012

Class buffer

This is the circular buffer with a capacity of 1000. It adds to itself as well as removes from itself.

This class contains all of the critical sections for producer and consumer and operates so consumer will never consume from an empty space
and that producer will never produce into a full space.

*/
public class buffer {
	// buffer	
	double[] buff=new double[1000];
	// keeps track of the cumilative total of consumed and produced items
	 int total_produced;
	 int total_consumed;
	//input pointer	
	 int input=0;
	// output pointer
	 int output=0;
	//keeps track of how many items where produced verses the amount consumed	
	 double c_tracker=0;
	 double p_tracker=0;
	
	//constructs the buffer *note* -1 is the empty value 
	public buffer()
	{
		for (int i=0;i<1000;i++)
			buff[i]=-1;
		
	}
	
	//adds to buffer
	public synchronized void add(double d) throws InterruptedException
	{
		//condition if buffer is full
		if(buff[input]!=-1)
		{
			wait();
		}
		// apends amount produced and fills buffer	
		p_tracker+=d;
		buff[input]=d;
		this.total_produced++;
		//iterate
		input=next(input);
		if(total_produced%100000==0)
			System.out.println("Producer: Generated "+this.total_produced+" items, Cumulative value of generated items="+this.p_tracker);
	
		// waits to fill buffer before notifying the consumer		
		if (input!=-1)
			notify();
	}
	
	public synchronized void remove() throws InterruptedException
	{
		// checks to see if there is nothing to consume
		if(buff[output]==-1)	
			wait();
		// consumption
		//{
		double temp=buff[output];
		// if empty value is consumed i want it to blow up	
		if(temp==-1)
		{
			while (true)
				temp=temp/0;
		}
		buff[output]=-1;
		//}
		//iterates
		output=next(output);
		c_tracker+=temp;
		this.total_consumed++;
		if(total_consumed%100000==0)
			System.out.println("Consumer: Consumed "+this.total_consumed+" items, Cumulative value of consumed items="+this.c_tracker);
		//consumes fully before notifying the producer
		if(buff[output]==-1);
		notify();
		
	}

	// iteration moves to next value	
	public int next(int c)
	{
		    c++;
			if(c==1000)
				return 0;
			else return c;
		
	}
	
	
	

	
}

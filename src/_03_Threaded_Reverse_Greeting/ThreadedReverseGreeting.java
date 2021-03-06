package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
    
    public static void main(String[] args) {
        new ThreadedReverseGreeting().reverseGreet( 1 );
    }
    
    public void reverseGreet( int threadNum ) {
        
        if( threadNum <= 50 ) {
            reverseGreet( threadNum + 1 );
            Thread r = createThread( threadNum );
	    r.start();
            try {
		// Wait for thread to finish
	        r.join();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
        }
    }
    
    Thread createThread( int threadNum ) {
        return new Thread( ()->System.out.println( "Hello from Thread " + threadNum + "!" ) );
    }
}

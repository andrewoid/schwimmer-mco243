package schwimmer.mco243;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class IgnoreOperations {

	public static void main(String[] args) throws InterruptedException {

//		
//		for ( int i=0; i<10000; i++ ) {
//			

//			
//		}
//		
//		service.shutdown();
//		service.awaitTermination(10, TimeUnit.DAYS);
//		System.out.println(total);

		final ExecutorService service = Executors.newFixedThreadPool(6);
		final AtomicBoolean allowed = new AtomicBoolean(true);
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ( allowed.get() ) {
					allowed.set(false);
					Runnable runnable = new Runnable() {
						public void run() {
							try {
								// LONG RUNNING OPERATION
							}
							catch ( IOException e ) {
								e.printStackTrace();
							}
							finally {
								allowed.set(true);
							}
						}
					};
				
					service.execute(runnable);
				}
			}
			
		};
		
		
	}
}

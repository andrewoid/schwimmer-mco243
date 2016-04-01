package schwimmer.mco243;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DownloadLotsOfImages {
	
	int totalDownloaded = 0;
	int totalProcessed = 0;
	
	public void downloadFile() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized(this) {
			totalDownloaded++;
		}
	}
	
	public void processFile() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized(this) {
			totalProcessed++;
		}
	}
	
	public void downloadAll() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(6);
		
		for ( int i=0; i<10000; i++ ) {
			
			Runnable runnable = new Runnable() {
				public void run() {
					downloadFile();
					processFile();
				}
			};
			
			service.execute(runnable);
			
		}
		
		service.shutdown();
		service.awaitTermination(10, TimeUnit.DAYS);
		System.out.println(totalDownloaded);
	}

	public static void main(String[] args) throws InterruptedException {
		
		new DownloadLotsOfImages().downloadAll();
		
	}

}

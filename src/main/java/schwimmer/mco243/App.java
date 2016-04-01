package schwimmer.mco243;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		
		Process process = Runtime.getRuntime().exec("java.exe -version");
		InputStream in = process.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		
		String line;
		while ( (line = reader.readLine()) != null ) {
			System.out.println(line);
		}
		
	}
}

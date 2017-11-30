package sample_progs;
//import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class ReadFileFromUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL("http://www.puzzlers.org/pub/wordlists/pocket.txt");
			Scanner s = new Scanner(url.openStream());
			while(s.hasNext()){
				System.out.println("next >> "+s.next());	
			}
			
			String str = "/opt/application/coherence/coh_domain/ProductUtility/lib/db.properties";
			String substr = "lib";
			String before = str.substring(0, str.indexOf(substr));
			
			System.out.println(before);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

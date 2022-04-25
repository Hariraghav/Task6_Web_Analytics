

import java.util.*;

import java.io.*;
import java.net.*;


public class Location {
	public String getLoc(String ip) {
		String country = "";
		ip=ip.trim();
		URL url;
		try {
				url = new URL("https://iplocation.zoho.com/getipinfo?ip="+ip+"&type=text");
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String str = "";
				String temp="";
				String loc_details[];	
				while (null != (str = br.readLine())) {
					temp=str;
					
				}	
			 	loc_details=temp.split(";");
				int length=loc_details.length;
		
				if(length==11){
					

					
					if(loc_details[4]!=null){
						country =loc_details[4];
					}
					

								
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}

	public static void main(String[] args) {
		

}
}

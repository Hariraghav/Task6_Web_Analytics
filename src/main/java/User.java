
import java.sql.Connection;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;


public class User {
	public void save(UserDetails ub) {
		
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		 
	      String query = "INSERT INTO analyticsbyip (url,ip,browser,country,date,time) VALUES('"+ub.getUrl()+"','"+ub.getIp()+"','"+ub.getBrowser()+"','"+ub.getCountry()+"',toDate(now()),toTimestamp(now()));";
	      String query1 = "INSERT INTO analyticsbywebsites (url,ip,browser,country,date,time) VALUES('"+ub.getUrl()+"','"+ub.getIp()+"','"+ub.getBrowser()+"','"+ub.getCountry()+"',toDate(now()),toTimestamp(now()));";
	      String query2 = "INSERT INTO analyticsbybrowser (url,ip,browser,country,date,time) VALUES('"+ub.getUrl()+"','"+ub.getIp()+"','"+ub.getBrowser()+"','"+ub.getCountry()+"',toDate(now()),toTimestamp(now()));";
	      String query3 = "INSERT INTO analyticsbycountry (url,ip,browser,country,date,time) VALUES('"+ub.getUrl()+"','"+ub.getIp()+"','"+ub.getBrowser()+"','"+ub.getCountry()+"',toDate(now()),toTimestamp(now()));";
	      String query4 = "INSERT INTO analyticsbydate (url,ip,browser,country,date,time) VALUES('"+ub.getUrl()+"','"+ub.getIp()+"','"+ub.getBrowser()+"','"+ub.getCountry()+"',toDate(now()),toTimestamp(now()));";
	      Session session = cluster.connect("webanalytics");
	      session.execute(query); 
	      session.execute(query1);
	      session.execute(query2);
	      session.execute(query3);
	      session.execute(query4);
	      System.out.println("Data created");

			}  
	
	public static List getDetails(String url) {
		String query = "select  ip,browser,count(ip) from analyticsbyip where url='"+url+"' group by ip ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
          Iterator<Row> it = result.iterator();
          while(it.hasNext()) {
       	   UserDetails ub =new UserDetails();
       	  
        	Row r = it.next();
       	  ub.setIp(r.getString(0));
       	  ub.setBrowser(r.getString(1));
       	  ub.setSvisits(String.valueOf(r.getLong(2)));
 
       	  list.add(ub);
       	 }
		return list;
 
			}  
	public static List getCountryData(String url) {
		String query = "select country,count(country) from analyticsbycountry where url='"+url+"' group by country ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<CountryDetails> list = new ArrayList<>();
          Iterator<Row> it = result.iterator();
          while(it.hasNext()) {
        	  CountryDetails cd = new CountryDetails();  
        	Row r = it.next();
       	  cd.setCountry(r.getString(0));
       	  System.out.println(r.getLong(1));
       	  cd.setCount(String.valueOf(r.getLong(1)));

       	  list.add(cd);
       	 }
		return list;
 
			} 
	
	public static List getDateData(String url) {
		String query = "select date,count(date) from analyticsbydate where url='"+url+"' group by date ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<DateDetails> list = new ArrayList<>();
          Iterator<Row> it = result.iterator();
          while(it.hasNext()) {
        	  DateDetails dd = new DateDetails();  
        	Row r = it.next();
       	  dd.setDate(String.valueOf(r.getDate(0)));
       	 
       	  dd.setCount(String.valueOf(r.getLong(1)));
       	  System.out.println("count"+r.getLong(1));

       	  list.add(dd);
       	 }
		return list;
 
			} 
	
	public static List getBrowserData(String url) {
		String query = "select browser,count(browser) from analyticsbybrowser where url='"+url+"' group by browser ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<BrowserDetails> list = new ArrayList<>();
          Iterator<Row> it = result.iterator();
          while(it.hasNext()) {
        	  BrowserDetails dd = new BrowserDetails();  
        	Row r = it.next();
       	  dd.setBrowser(String.valueOf(r.getString(0)));
       	 
       	  dd.setCount(String.valueOf(r.getLong(1)));

       	  list.add(dd);
       	 }
		return list;
 
			} 
	public static List getUrl() {
		 String query = "SELECT  url  from websites group by url";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
           List<UserDetails> list1 = new ArrayList<>();
           Iterator<Row> it = result.iterator();
           while(it.hasNext()) {
        	   UserDetails ub =new UserDetails();
        	   ub.setUrl(it.next().getObject(0).toString()); 
        	   //System.out.println(it.next().getString(0));
        	   list1.add(ub);
        	 }
		return list1;
	    
		}  
	public static List filterByDate(String from, String to) {
		String query = "select  ip,browser,country, date from analyticsbyip where date >='"+from+"' and date <='"+to+"' and url='"+UserDetails.getCurrentUrl()+"'  ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
        Iterator<Row> it = result.iterator();
        while(it.hasNext()) {
     	   UserDetails ub =new UserDetails();  
      	Row r = it.next();
     	 ub.setIp(r.getString(0));
     	 ub.setBrowser(r.getString(1));
     	ub.setCountry(r.getString(2));
     	 ub.setDate(String.valueOf(r.getDate(3)));

     	  list.add(ub);
     	 }
		return list;
		
	}
	public static List<UserDetails> filterByBrowser(String browser) {
		String query = "select  ip,browser,country,date from analyticsbyip where browser ='"+browser+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
      Iterator<Row> it = result.iterator();
      while(it.hasNext()) {
   	   UserDetails ub =new UserDetails();  
    	Row r = it.next();
   	 ub.setIp(r.getString(0));
   	 ub.setBrowser(r.getString(1));
   	ub.setCountry(r.getString(2));
    ub.setDate(String.valueOf(r.getDate(3)));

   	  list.add(ub);
   	 }
		return list;
	}
	
	public static List<UserDetails> filterByDate_Browser(String from,String to,String browser) {
		String query = "select  ip,browser,country,date from analyticsbyip where date >='"+from+"' and date <='"+to+"' and browser ='"+browser+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
      Iterator<Row> it = result.iterator();
      while(it.hasNext()) {
   	   UserDetails ub =new UserDetails();  
    	Row r = it.next();
   	 ub.setIp(r.getString(0));
   	 ub.setBrowser(r.getString(1));
   	ub.setCountry(r.getString(2));
    ub.setDate(String.valueOf(r.getDate(3)));

   	  list.add(ub);
   	 }
		return list;
	}
	
	public static List<UserDetails> filterByBrowser_Country(String browser,String country) {
		String query = "select  ip,browser,country,date from analyticsbyip where browser ='"+browser+"' and country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
      Iterator<Row> it = result.iterator();
      while(it.hasNext()) {
   	   UserDetails ub =new UserDetails();  
    	Row r = it.next();
   	 ub.setIp(r.getString(0));
   	 ub.setBrowser(r.getString(1));
   	ub.setCountry(r.getString(2));
    ub.setDate(String.valueOf(r.getDate(3)));

   	  list.add(ub);
   	 }
		return list;
	}
	public static List<UserDetails> filterByDate_Country(String from,String to,String country) {
		String query = "select  ip,browser,country,date from analyticsbyip where date >='"+from+"' and date <='"+to+"' and country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
      Iterator<Row> it = result.iterator();
      while(it.hasNext()) {
   	   UserDetails ub =new UserDetails();  
    	Row r = it.next();
   	 ub.setIp(r.getString(0));
   	 ub.setBrowser(r.getString(1));
   	ub.setCountry(r.getString(2));
    ub.setDate(String.valueOf(r.getDate(3)));

   	  list.add(ub);
   	 }
		return list;
	}
	public static List<UserDetails> filterByDate_Browser_Country(String from,String to,String browser,String country) {
		String query = "select  ip,browser,country,date from analyticsbyip where date >='"+from+"' and date <='"+to+"' and browser ='"+browser+"' and country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
      Iterator<Row> it = result.iterator();
      while(it.hasNext()) {
   	   UserDetails ub =new UserDetails();  
    	Row r = it.next();
   	 ub.setIp(r.getString(0));
   	 ub.setBrowser(r.getString(1));
   	ub.setCountry(r.getString(2));
    ub.setDate(String.valueOf(r.getDate(3)));

   	  list.add(ub);
   	 }
		return list;
	}
	public static List<UserDetails> filterByCountry(String country) {
		String query = "select  ip,browser,country,date from analyticsbyip where  country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

	      Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	      Session session = cluster.connect("webanalytics");
	    

	      ResultSet result = session.execute(query);
	    //System.out.println(result.all());
	      List<UserDetails> list = new ArrayList<>();
      Iterator<Row> it = result.iterator();
      while(it.hasNext()) {
   	   UserDetails ub =new UserDetails();  
    	Row r = it.next();
   	 ub.setIp(r.getString(0));
   	 ub.setBrowser(r.getString(1));
   	ub.setCountry(r.getString(2));
    ub.setDate(String.valueOf(r.getDate(3)));

   	  list.add(ub);
   	 }
		return list;
	}
	
	public static void main(String args[]){  
	
		
		
}


}
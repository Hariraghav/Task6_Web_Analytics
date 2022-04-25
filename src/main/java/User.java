
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
		 
	      String query = "INSERT INTO analytics (url,ip,browser,date,time) VALUES('"+ub.getUrl()+"','"+ub.getIp()+"','"+ub.getBrowser()+"',toDate(now()),toTimestamp(now()));";
	      String query1 = "INSERT INTO websites (url,time) VALUES('"+ub.getUrl()+"',toTimestamp(now()));";
	      Session session = cluster.connect("webanalytics");
	      session.execute(query); 
	      session.execute(query1); 
	      System.out.println("Data created");

			}  
	
	public static List getDetails(String url) {
		String query = "select  ip,browser,count(ip) from analytics where url='"+url+"' group by ip ALLOW FILTERING";

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
		String query = "select  ip,browser,country, date from analytics where date >='"+from+"' and date <='"+to+"' and url='"+UserDetails.getCurrentUrl()+"'  ALLOW FILTERING";

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
		String query = "select  ip,browser,country,date from analytics where browser ='"+browser+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

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
		String query = "select  ip,browser,country,date from analytics where date >='"+from+"' and date <='"+to+"' and browser ='"+browser+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

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
		String query = "select  ip,browser,country,date from analytics where browser ='"+browser+"' and country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

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
		String query = "select  ip,browser,country,date from analytics where date >='"+from+"' and date <='"+to+"' and country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

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
		String query = "select  ip,browser,country,date from analytics where date >='"+from+"' and date <='"+to+"' and browser ='"+browser+"' and country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

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
		String query = "select  ip,browser,country,date from analytics where  country ='"+country+"'and url='"+UserDetails.getCurrentUrl()+"' ALLOW FILTERING";

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.github.javafaker.Faker;

public class FakeData {
	 public static String dateFormater(String dateFromJSON, String expectedFormat, String oldFormat) {
		    SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
		    Date date = null;
		    String convertedDate = null;
		    try {
		        date = dateFormat.parse(dateFromJSON);
		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(expectedFormat);
		        convertedDate = simpleDateFormat.format(date);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return convertedDate;
		}
public static void main(String args[]) {
	Faker faker = new Faker();
	String ip = faker.internet().ipV4Address();
	String browser = "chrome";
	String country = faker.country().name();
	Date From =null;
	Date to =null ;
	try {
		From = new SimpleDateFormat("yyyy-mm-dd").parse("2020-01-01");
		to = new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	String dateStr = faker.date().between(From, to).toString();
	DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
	Date date = null;
	try {
		date = (Date)formatter.parse(dateStr);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}       

	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	String formatedDate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +         cal.get(Calendar.DATE);   
	UserDetails ub = new  UserDetails();
	ub.setIp(ip);
	ub.setUrl("www.zoho.com");
	ub.setBrowser(browser);
	ub.setCountry(country);
	ub.setDate(formatedDate);
	User u  = new User();
	u.save(ub);
	
	
}
}

import java.util.*;
public class UserDetails{
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public static String getCurrentUrl() {
		return currentUrl;
	}
	public static void setCurrentUrl(String currentUrl) {
		UserDetails.currentUrl = currentUrl;
	}
	public String getSvisits() {
		return svisits;
	}
	public void setSvisits(String svisits) {
		this.svisits = svisits;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	private String url;
	private String ip;
	private String browser;
	private String svisits;
	private String timestamp;
	private String date;
	private String country;
	private static String currentUrl;
	

}

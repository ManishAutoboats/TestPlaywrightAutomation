package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Base {
 
public static Properties prop;
public static RequestSpecification re;
static PrintStream log;
	public void readCofig() {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resource/env.properties");
			 prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static RequestSpecification setup() {
		
	
		try {
		 log = new PrintStream(new FileOutputStream("log.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	re= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclcick123")
		 .setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log)).build();
	 return re;
	}

}

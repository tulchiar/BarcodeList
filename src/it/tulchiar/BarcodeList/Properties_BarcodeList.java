package it.tulchiar.BarcodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Properties_BarcodeList{
		
	public static String serverIp;
	public static String user;
	public static String password;
		
		public static void inizialize() {
			
			//////verifico se il file esiste//////
			if(new File("properties").exists()) {
				
				System.out.println("Il file properties esiste già, ne recupero il contenuto");
				
				////////////Reading properties////////////////////////////////
				try (InputStream in = new FileInputStream("properties")) {
					Properties prop = new Properties();
					prop.load(in);
							
					Properties_BarcodeList.serverIp = prop.getProperty("serverIp");
					Properties_BarcodeList.user = prop.getProperty("user");
					Properties_BarcodeList.password = prop.getProperty("password");
					System.out.println("serverIp :" + serverIp);
					System.out.println("user :" + user);
					System.out.println("password :" + password);
	
					
					System.out.println("####Properties.stringPropertyNames usage####");
					for (String property : prop.stringPropertyNames()) {
						String value = prop.getProperty(property);
						System.out.println(property + " ==> " + value);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				////////////////////////////////////////////////////
				
			} else {
				
				System.out.println("Il file properties non esiste, lo creo con valori di default");
					
				//////saving properties into example.properties file/////////
				try (OutputStream out = new FileOutputStream("properties")) {
					Properties properties = new Properties();
					properties.setProperty("serverIp", "localhost:3306"); //:3311
					properties.setProperty("user", "root");
					properties.setProperty("password", "Chrmrc84a15");
					properties.store(out, "Impostazioni per BarcodeList");
	
				} catch (IOException e) {
					e.printStackTrace();
				}
				///////////////////////////////////////////////////////////////
			}
						System.out.println();

//			/////////writing and reading fromxml////////////////
//			try (OutputStream out = new FileOutputStream("example.xml")) {
//				Properties properties = new Properties();
//				properties.setProperty("article", "JavaProperties");
//				properties.setProperty("version", "1.0");
//				properties.setProperty("ide", "eclipse");
//				properties.storeToXML(out,
//						"This is how we can have properties as xml");
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			///////////////////////////////////////////////////////

//			///////////Reading properties from xml/////////////////
//			try (InputStream in = new FileInputStream("example.xml")) {
//				Properties prop = new Properties();
//				prop.loadFromXML(in);
//
//				System.out.println("####Properties.load from xml usage####");
//				for (String property : prop.stringPropertyNames()) {
//					String value = prop.getProperty(property);
//					System.out.println(property + "=" + value);
//				}
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println();
//
//			///////////////////////////////////////////////////////

		}
	}


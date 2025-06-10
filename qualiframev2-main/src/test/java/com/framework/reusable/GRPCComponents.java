package com.framework.reusable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;
import com.framework.components.Settings;
import com.framework.report.Status;

public class GRPCComponents extends WebReusableComponents {

	protected Properties properties = Settings.getInstance();
	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Function to return headers for request
	 * 
	 * @param protoFile name of the protofile
	 * 
	 * @param payload payloaf for rhe request
	 * 
	 * @param service	name of teh service
	 * 
	 * @return JSONObject
	 */
	public JSONObject gRPCrequest(String protoFile, String payload, String service) {
		
		Process process = null;

		JSONObject jsonObject = null;

		addTestLog("Service name : ", service, Status.PASS);
		System.out.println("Service name : \n" + service);

		addTestLog("Payload : ", payload , Status.PASS);
		System.out.println("Payload : \n" + payload);
		
		payload = payload.replace(" ", "").replace("\n", "").replace("\"", "\\\"");

		String command = "grpcurl -cacert=./ca-certificates.crt"
				+ " -proto "+protoFile+".proto "
				+ "-d \""+payload+"\" "
				+ "spoke-a-grpc.test4.areax.app:443"
				+ " " + service;
		
		boolean flag = false;
		for(int i=0;i<3;i++) {
			try {
				if (isWindows()) {
		            System.out.println("This is Windows");
		            process = Runtime.getRuntime().exec("cmd.exe /c " +command,
							null,
							new File("." + File.separator + "src" + File.separator + "test" + File.separator
									+ "resources" + File.separator + "api" + File.separator + "payload"));
					
					process.waitFor(20, TimeUnit.SECONDS);
		        } else if (isMac()) {
		            System.out.println("This is Mac");
		            Runtime. getRuntime(). 
		            exec(command,
							null,
							new File("." + File.separator + "src" + File.separator + "test" + File.separator
									+ "resources" + File.separator + "api" + File.separator + "payload"));
		        } else if (isUnix()) {
		            System.out.println("This is Unix or Linux");
		            Runtime. getRuntime(). 
		            exec(command,
							null,
							new File("." + File.separator + "src" + File.separator + "test" + File.separator
									+ "resources" + File.separator + "api" + File.separator + "payload"));
		        } else if (isSolaris()) {
		            System.out.println("This is Solaris");
		        } else {
		            System.out.println("Your OS is not support!!");
		        }
				
				if(!process.isAlive()) {
					flag = true;
					break;
				} else {
					process.destroy();
				}
					
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(!flag)
			addTestLog("Response : ", "Unable to run service - " + service, Status.FAIL);
		InputStream inputStream = process.getInputStream();
		BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
		String value = reader.lines().collect(Collectors.joining());
		System.out.println(value);
		try {
			jsonObject = new JSONObject(value);
		}  catch (JSONException err) { 
			addTestLog("Response : ",  err.toString() + " **** The String has " + value, Status.FAIL);
		}
		process.destroy();
		addTestLog("Response : ",  value, Status.PASS);

		return jsonObject;
	}
	
	public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0
                || OS.indexOf("nux") >= 0
                || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
	
}

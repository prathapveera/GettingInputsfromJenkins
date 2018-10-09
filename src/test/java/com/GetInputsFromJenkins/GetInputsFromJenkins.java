package com.GetInputsFromJenkins;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.apache.tools.ant.util.ClasspathUtils;
import org.testng.annotations.Test;

public class GetInputsFromJenkins {
	
	@Test
	
	public static void getInputsFromJenkins() 
	{
		System.out.println(System.getenv("Modules"));
		System.out.println(System.getenv("TestdataRequired"));
		System.out.println(System.getenv("Environment"));
	
		
		String path="";
		
		
		switch (System.getenv("Modules").toLowerCase()) {
		case "questionarie":
			
			
			if(System.getenv("TestdataRequired").equals("false"))
			{
				path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\Questionaries_WithoutTestdataPreparation";
			}else
			{
				path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\Questionaries_WithoutTestdataPreparation";
			}
				
			break;

		default:
			break;
		}
		
		
	if(! path.isEmpty())	
	{

		File src= new File(path);
		
		File[] allpackages=src.listFiles();
		
		
		for (File file : allpackages) {
			
			System.out.println(file);
			
		}
		
		
	}
		
		
		
		
	
	
	
	}

}

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
	
	/*
	File src= new File(System.getProperty("user.dir")+"\\src\\test\\java\\\\com");
	
	File[] allpackages=src.listFiles();
	
	
	for (File file : allpackages) {
		
		System.out.println(file);
		
	}
	
	*/
	
	
	}

}

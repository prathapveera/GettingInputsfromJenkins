package com.GetInputsFromJenkins;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.tools.ant.util.ClasspathUtils;
import org.testng.annotations.Test;

public class GetInputsFromJenkins {
	
	static List alltestcases=new ArrayList();
	
	@Test
	
	public static void getInputsFromJenkins() 
	{
		System.out.println(System.getenv("Modules"));
		System.out.println(System.getenv("TestdataRequired"));
		System.out.println(System.getenv("Environment"));
	
		String path="";
		System.out.println("========================================");
		
		System.out.println(System.getProperty("user.dir"));
		
		System.out.println("========================================");
		
		switch (System.getenv("Modules").toLowerCase()) {
		case "questionarie":
			
			
			if(System.getenv("TestdataRequired").equals("false"))
			{
				path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\Questionaries_WithoutTestdataPreparation";
			}else
			{
				path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\Questionaries_WithTestdataPreparation";
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
			
			System.out.println(file.getName().substring(0, file.getName().indexOf(".")));
			alltestcases.add(file.getName().substring(0, file.getName().indexOf(".")));
			
			
		}
		
		
		if(!(alltestcases.size()==0))
		{
			buildXML();
		}
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
		
		
		
		
	
	
	
	}
	
	
	
	public static void buildXML()
	{try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("suite");
				doc.appendChild(rootElement);
		
		// set attribute to root element
				Attr attr = doc.createAttribute("name");
				attr.setValue("Suite of Suits");
				rootElement .setAttributeNode(attr);
				
				
	   // Test
				Element test = doc.createElement("test");
				rootElement.appendChild(test);		
				
		// set attribute to Test element
				Attr testattr = doc.createAttribute("name");
				testattr.setValue("Test");
				test .setAttributeNode(testattr);
				
				
		// Classes
				Element classes= doc.createElement("classes");
				test.appendChild(classes);	
				
				//Class
				
				for(int i=0;i<=alltestcases.size()-1;i++)
				{
					
					//Class
					Element classinsideclasses= doc.createElement("class");
					classes.appendChild(classinsideclasses);
					
					// set attribute to Class element
					Attr classattr = doc.createAttribute("name");	
					
				classattr.setValue("com.TestCases."+alltestcases.get(i).toString());
				classinsideclasses .setAttributeNode(classattr);	
				}
				
				
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer;
				
					transformer = transformerFactory.newTransformer();
					
					
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+"\\TestCases.xml"));

					// Output to console for testing
				 //result = new StreamResult(System.out);

					transformer.transform(source, result);

					System.out.println("File saved!");	
					Thread.sleep(4000);
					System.out.println("XML Generation is completed");	
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
	}
	
	@AfterClass
	public static void runXML() throws InterruptedException
	{
		
		Thread.sleep(2000);
		
		
		// Create object of TestNG Class
		TestNG runner=new TestNG();

		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add("TestCases.xml");

		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		runner.run();
		
		
		System.out.println("hello");
		
	}
	

}

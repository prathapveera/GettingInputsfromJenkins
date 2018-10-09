package com.howtodoinjava.demo.jsonsimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJSONExample 
{
	
	public static  JSONParser parser;
	public static  JSONObject jsonObject;

	
	public static void main(String[] args) 
	{
		
		
		 parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(new FileReader("Testdata.json"));
             
            //convert Object to JSONObject
             jsonObject = (JSONObject)object;
             
             geturl();
             getdata("Tc_FIC1747_TemplateLinkPopUpConsumption","Cloud_Details","Partner",1);
             
         
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		
		
		
		
	}
	
	
	
	public static String geturl()
	{
		
		String url="";
		
		
		try
		{
		  //Reading the array
        JSONArray environments = (JSONArray)jsonObject.get("Generic_Testdata");
       
             
        for(int i=0;i<=environments.size()-1;i++)
        
        {
        	 JSONObject item = (JSONObject)environments.get(i);
             
             String env_Status = (String)item.get("Execute_Test");             
           
             
             if(env_Status.equalsIgnoreCase("yes"))
             {
            	 
             url = (String)item.get("url");
                 
             System.out.println(url);
                 
            	 
                 
                 break;
            	 
             }
          
        } 

        	
        }
        
        catch(Exception e)
		{
        	
		}
		return url;
        
        
    
		
	}
	
	public static String getdata(String tcname,String crntmethod,String fieldname,int itr)

	{
		
		String searchresult="";

		
		
		try {
		

			  //Reading the array for the testcase
	        JSONArray environments = (JSONArray)jsonObject.get(crntmethod);
	       
	             
	        for(int i=0;i<=environments.size()-1;i++)
	        
	        {
	        	 JSONObject item = (JSONObject)environments.get(i);
	             
	             String TestCase = (String)item.get("Tc_Name");  
	             
	             String crntitr=(String)item.get("Iteration");
	           
	             
	             if(TestCase.equalsIgnoreCase(tcname) && crntitr.equals(Integer.toString(itr)))
	             {
	            	 
	            	 searchresult = (String)item.get(fieldname);
	                 
	                 System.out.println(searchresult);
	                 
	                
	                 
	                 break;
	            	 
	             }
	          
	        } 

	        	
	        
			

			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			searchresult="";
		}

		
		return searchresult;
		
		
	}
	
	
	
	
}

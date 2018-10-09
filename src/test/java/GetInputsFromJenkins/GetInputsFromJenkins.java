package GetInputsFromJenkins;

import org.testng.annotations.Test;

public class GetInputsFromJenkins {
	
	@Test
	
	public static void getInputsFromJenkins()
	{
		System.out.println(System.getenv("Modulename"));
	}

}

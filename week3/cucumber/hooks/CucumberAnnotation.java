package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberAnnotation {

	@Before
	public void preScript() {
		//Set endpoint and basic auth
		System.out.println("This is the preScript from hooks");
	}

	@After
	public void PostScript() {
		System.out.println("This is the postScript from hooks");
	}

}

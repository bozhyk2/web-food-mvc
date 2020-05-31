package fr.iv.calories.config;




import javax.servlet.Filter;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);


		return new Filter[] {encodingFilter};
	}


	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {FoodContextAppConfig.class};
	}

	


	

	

	@Override
	protected String[] getServletMappings() {
		return new String [] {"/"};
	}

	
	

	/**
	 * dispatcherTypes =null if the default DispatcherType.REQUEST is to be used
	 * isMatchAfter= true if the given filter mapping should be matched after any declared filter mappings,
	 * 		 and false if it is supposed to be matched before any declared filter mappings
	 * 					of the ServletContext from which this FilterRegistration was obtained
	 * url Patterns- the url patterns of the filter mapping
	 */
	
	
	

	
	


}

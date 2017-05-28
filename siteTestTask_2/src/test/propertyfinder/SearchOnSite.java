package test.propertyfinder;

import org.testng.annotations.*;

	

	public class SearchOnSite extends TestBase  {
		
	  
	  @Test
	  public void FindApartmentTest() throws Exception  {
			  
	    openSite();
	    searchFirstAreaFromFile();    
	    selectSearchParameters();	 
	    submitSearch();
	    sortSearchResultLowPrice();
	    scrollDown();   
	    openLastSearchResult();
	    verifyApartmentIsTwoBerdroom();
	    
	    
	     }
	 }



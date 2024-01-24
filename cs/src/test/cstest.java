package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Incidents;
import dao.ICrimeAnalysisServiceImpl;

public class cstest {
	
	private ICrimeAnalysisServiceImpl cstest;
    
   
    
    @Before
    public void setUp() {
        cstest = new ICrimeAnalysisServiceImpl();
       
        
    }
    
    
    @After
    public void tearDown() {
        // Clean up resources if needed
        cstest = null;
       
       
    }
    
    @Test
    public void testCreateIncident() {
    	
    	Incidents testnewincident = new Incidents(
    			31,
    			"theft",
    			java.sql.Date.valueOf("2023-10-15"),
    			"Latitude: 40, Longitude: 50",
    			"Theft at Temple",
    			"Open",
    			2,
    			2
    			);
    	boolean result = cstest.createIncident(testnewincident);
    	
    	assertTrue("Incident creation success", result);
    	
    }
    
    @Test
    public void updateIncidentStatus() {
    	int incidentId = 1;
        String statuss = "CLOSED";
    	
    	boolean result = cstest.updateIncidentStatus(incidentId, statuss);
    	
    	assertTrue("Incident status updated successfully", result);
        
        
    	
    }

}
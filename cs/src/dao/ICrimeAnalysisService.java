package dao;

import java.util.List;

import entity.Incidents;

public interface ICrimeAnalysisService {

	boolean createIncident(Incidents incident);
	
	List<Incidents> searchIncidentsByType(String incidentType);

	List<Incidents> getIncidentsInDateRange(String startDateStr, String endDateStr);

	boolean updateIncidentStatus(int incidentId, String status);

	Object generateIncidentReport(Incidents incident, int reportingOfficer);

	Incidents getIncidentById(int incidentId);

	

	

	

}

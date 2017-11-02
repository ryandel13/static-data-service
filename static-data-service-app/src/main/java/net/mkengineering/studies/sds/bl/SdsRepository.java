package net.mkengineering.studies.sds.bl;

import java.util.List;

import net.mkengineering.studies.sds.DataResponse;

public interface SdsRepository {

	public List<String> getAllVehicles();

	public DataResponse getAllDataForVin(String vin);

	public DataResponse getAttributeForVin(String vin, String attribute);
	
}

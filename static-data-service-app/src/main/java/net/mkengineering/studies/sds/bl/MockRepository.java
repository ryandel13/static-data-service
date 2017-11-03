package net.mkengineering.studies.sds.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import net.mkengineering.studies.sds.DataResponse;

@Component
@ConditionalOnProperty(name="repository.location", havingValue="database")
public class MockRepository implements SdsRepository{

	private final Map<String, Map<String, String>> vehicleMap = new HashMap<>();
	
	public MockRepository() {
		vehicleMap.put("WP0ZZZ94427", new HashMap<String, String>());
		vehicleMap.put("MBD000TEST1", new HashMap<String, String>());
	}
	
	@Override
	public List<String> getAllVehicles() {
		List<String> list = new ArrayList<>();
		list.addAll(vehicleMap.keySet());
		return list;
	}

	@Override
	public DataResponse getAllDataForVin(String vin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResponse getAttributeForVin(String vin, String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean evictCache() {
		// TODO Auto-generated method stub
		return null;
	}

}

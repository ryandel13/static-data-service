package net.mkengineering.studies.sds.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import net.mkengineering.studies.sds.DataResponse;
import net.mkengineering.studies.sds.ResponseEntity;

@Component
@ConditionalOnProperty(name="repository.location", havingValue="database")
public class MockRepository implements SdsRepository{

	private final Map<String, Map<String, String>> vehicleMap = new HashMap<>();
	
	public MockRepository() {
		vehicleMap.put("WP0ZZZ94427", new HashMap<String, String>());
		vehicleMap.put("MBD000TEST1", new HashMap<String, String>());
		
		initVehicles();
	}
	
	private void initVehicles() {
		Map<String, String> map = vehicleMap.get("WP0ZZZ94427");
		map.put("motorCode", "M44.11");
		map.put("licensePlate", "B-GQ-944");
		map.put("color", "zermatt silver");
		vehicleMap.put("WP0ZZZ94427", map);
		
		map = vehicleMap.get("MBD000TEST1");
		map.put("motorCode", "23676");
		map.put("licensePlate", "LIP-JK-123");
		map.put("color", "silber");
		vehicleMap.put("MBD000TEST1", map);
	}
	
	@Override
	public List<String> getAllVehicles() {
		List<String> list = new ArrayList<>();
		list.addAll(vehicleMap.keySet());
		return list;
	}

	@Override
	public DataResponse getAllDataForVin(String vin) {
		Map<String, String> map = vehicleMap.get(vin);
		DataResponse dR = new DataResponse();
		for(String s : map.keySet()) {
			ResponseEntity rE = new ResponseEntity(s, map.get(s), String.class.getName());
			dR.addEntry(rE);
		}
		return dR;
	}

	@Override
	public DataResponse getAttributeForVin(String vin, String attribute) {
		Map<String, String> map = vehicleMap.get(vin);
		DataResponse dR = new DataResponse();
		for(String s : map.keySet()) {
			if(s.equalsIgnoreCase(attribute)) {
				ResponseEntity rE = new ResponseEntity(s, map.get(s), String.class.getName());
				dR.addEntry(rE);
			}
		}
		return dR;
	}

	@Override
	public Boolean evictCache() {
		// TODO Auto-generated method stub
		return null;
	}

}

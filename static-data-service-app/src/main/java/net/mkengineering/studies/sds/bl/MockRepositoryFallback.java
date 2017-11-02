package net.mkengineering.studies.sds.bl;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import net.mkengineering.studies.sds.DataResponse;

public class MockRepositoryFallback implements SdsRepository {

	@Override
	public List<String> getAllVehicles() {
		// TODO Auto-generated method stub
		return null;
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

}

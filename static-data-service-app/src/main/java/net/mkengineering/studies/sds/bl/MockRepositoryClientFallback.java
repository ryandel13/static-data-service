package net.mkengineering.studies.sds.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import net.mkengineering.studies.sds.DataResponse;
import net.mkengineering.studies.sds.remote.SdsRemoteFeign;

@Component
@ConditionalOnProperty(name="repository.location", havingValue="memory")
public class MockRepositoryClientFallback implements SdsRepository {

	@Autowired
	private SdsRemoteFeign feign;
	
	@Override
	@Cacheable("vehicles")
	public List<String> getAllVehicles() {
		return feign.getAllVehicles().getBody();
	}

	@Override
	@Cacheable("dataForVin")
	public DataResponse getAllDataForVin(String vin) {
		return feign.getAllDataForVin(vin).getBody();
	}

	@Override
	@Cacheable("attributeForVin")
	public DataResponse getAttributeForVin(String vin, String attribute) {
		return feign.getAttributeForVin(vin, attribute).getBody();
	}

	@Override
	@CacheEvict
	public Boolean evictCache() {
		return true;
	}
	
}

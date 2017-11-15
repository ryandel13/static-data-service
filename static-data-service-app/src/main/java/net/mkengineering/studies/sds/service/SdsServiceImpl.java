package net.mkengineering.studies.sds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.mkengineering.studies.sds.DataResponse;
import net.mkengineering.studies.sds.bl.MockRepositoryClientFallback;
import net.mkengineering.studies.sds.bl.SdsRepository;

@RestController
public class SdsServiceImpl implements SdsServiceInterface {

	@Autowired
	private SdsRepository sdsRepo;
	
	 @Value("${message}")
	  String name = "World";
	
	@Override
	public ResponseEntity<List<String>> getAllVehicles() {
		return new ResponseEntity(sdsRepo.getAllVehicles(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DataResponse> getAllDataForVin(@PathVariable String vin) {
		return new ResponseEntity<DataResponse>(sdsRepo.getAllDataForVin(vin), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DataResponse> getAttributeForVin(@PathVariable String vin, @PathVariable String attribute) {
		return new ResponseEntity<DataResponse>(sdsRepo.getAttributeForVin(vin, attribute), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> echo() {
		return new ResponseEntity<>(name, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Boolean> evictCache() {
		return new ResponseEntity<>(sdsRepo.evictCache(), HttpStatus.OK);
	}
	



}

package net.mkengineering.studies.sds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class DataResponse {

	List<ResponseEntity> values = new ArrayList<>();
	
}

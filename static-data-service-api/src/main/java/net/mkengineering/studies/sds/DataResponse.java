package net.mkengineering.studies.sds;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {

	private List<ResponseEntity> values = new ArrayList<>();
	
	public void addEntry(ResponseEntity rE) {
		values.add(rE);
	}
	
}

package hr.abc.service;

import java.util.List;

import hr.abc.dto.CERARequestDTO;

public interface CERARequestService {
	
	public List<CERARequestDTO> ceraRequestSelectAll();
	
	public CERARequestDTO ceraRequestSelect(String id);
	
	public boolean ceraRequestInsert(CERARequestDTO ceraRequestDTO);
	
	public boolean ceraRequestUpdate(CERARequestDTO ceraRequestDTO);
	
	public boolean ceraRequestDelete(String id);
	
	public int ceraRequestCount();
	
	public void ceraRequestHitNumber(int num);
	
	public boolean ceraRequestId(int num, String id);
	
	public List<?> ceraRequestSearch(String keyword, String keyfield, int page, int limit);
	
	public int ceraRequestSearchCount(String keyword, String keyfield);

}

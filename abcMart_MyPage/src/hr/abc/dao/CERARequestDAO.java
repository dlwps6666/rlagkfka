package hr.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hr.abc.dto.CERARequestDTO;
import hr.abc.service.CERARequestService;

public class CERARequestDAO implements CERARequestService{
	
	private static Log log = LogFactory.getLog(CERARequestDAO.class);

	@Override
	public ArrayList<CERARequestDTO> ceraRequestSelectAll() {
		ArrayList<CERARequestDTO> arrayList = new ArrayList<CERARequestDTO>();
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			
			String sql = "select * from CERARequest";
			log.info("SQL 확인 - " + sql);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CERARequestDTO ceraRequestDTO = new CERARequestDTO();
				ceraRequestDTO.setId(resultSet.getString("id"));
				ceraRequestDTO.setProductName(resultSet.getString("productName"));
				ceraRequestDTO.setContents(resultSet.getString("contests"));
				ceraRequestDTO.setReasons(resultSet.getString("reasons"));
				arrayList.add(ceraRequestDTO);
			}
		} catch (Exception e) {
			log.info("목록보기 실패 - " + e);
		}
		
		return arrayList;
	}

	@Override
	public CERARequestDTO ceraRequestSelect(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ceraRequestInsert(CERARequestDTO ceraRequestDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ceraRequestUpdate(CERARequestDTO ceraRequestDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ceraRequestDelete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int ceraRequestCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ceraRequestHitNumber(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ceraRequestId(int num, String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> ceraRequestSearch(String keyword, String keyfield, int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ceraRequestSearchCount(String keyword, String keyfield) {
		// TODO Auto-generated method stub
		return 0;
	}

}

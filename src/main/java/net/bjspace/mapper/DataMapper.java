package net.bjspace.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface DataMapper {
	
	int insertInfo(Map<String, Object> map);

	int deleteInfo(Map<String, Object> map);

	int updateInfo(Map<String, Object> map);

	List<Map<String, Object>> queryInfo(Map<String, Object> map);
	
	
}

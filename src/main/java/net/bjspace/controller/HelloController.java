package net.bjspace.controller;

import lombok.extern.slf4j.Slf4j;
import net.bjspace.mapper.DataMapper;
import net.bjspace.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author : BJ
 * @brief :
 * @Date : 2019/6/4
 * @Package : net.bjspace.controller
 * @file : HelloController
 * @note :
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataMapper dataMapper;
    @Autowired
    private LogService logService;

    @RequestMapping("hello")
    public List<Map<String, Object>> hello() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select id,user_id,action,create_time from lu_log ", new Object[]{});

        /*Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName", " user ");
        paramMap.put("condition1", " ID,USERNAME,PASSWORD ");
        paramMap.put("condition2", " ");
        List<Map<String, Object>> list = dataMapper.queryInfo(paramMap);*/
        log.info(list.toString());
        logService.logInsert("程序测试", "");

        return list;
    }

}

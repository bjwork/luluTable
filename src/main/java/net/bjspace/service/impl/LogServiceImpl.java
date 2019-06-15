package net.bjspace.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.bjspace.mapper.DataMapper;
import net.bjspace.service.LogService;
import net.bjspace.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : BJ
 * @brief : 日志记录
 * @Date : 2019/6/15
 * @Package : net.bjspace.service.impl
 * @file : LogServiceImpl
 * @note : 操作日志记录类
 */
@Slf4j
@Service("LogService")
public class LogServiceImpl implements LogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataMapper dataMapper;

    @Override
    public void logInsert(String logMsg, String remarks) {
        /*Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName", " user ");
        paramMap.put("condition1", " ID,USERNAME,PASSWORD ");
        paramMap.put("condition2", " ");
        List<Map<String, Object>> list = dataMapper.queryInfo(paramMap);*/
        Date dateTime = new Date();
        String time = DateUtil.getCurrentTime();
        String sql = "insert into lu_log(user_id, action, create_time) values (1, '" + logMsg + "', '" + time + "')";
        jdbcTemplate.execute(sql);

    }

    @Override
    public List<Map<String, Object>> queryLogs(String search, String startTime, String endTime, String page, String limit){
        StringBuffer whereSBF = new StringBuffer();
        if (StringUtils.isNotBlank(search)) {
            whereSBF.append(" and (action like '%" + search + "%' or remarks like '%" + search + "%')");
        }
        if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
            whereSBF.append(" and create_time > '" + startTime + "' and create_time < '" + endTime + "'");
        }
        int s = 0;///开始位置
        int n = 10;///查询条数
        if (StringUtils.isNotBlank(page) && StringUtils.isNotBlank(limit)) {
            s = (Integer.valueOf(page) - 1) * Integer.valueOf(limit);
            n = Integer.valueOf(limit);
        }
        List<Map<String, Object>> list = jdbcTemplate
                .queryForList("select user_id,action,date_format(create_time, '%Y-%m-%d %H:%i:%s') as createTime,ip,os,browser,equipment,remarks from lu_log where 1=1 "
                        + whereSBF.toString() + " order by create_time desc limit " + s + "," + n, new Object[]{});
        return list;
    }

}

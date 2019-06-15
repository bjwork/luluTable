package net.bjspace.service;

import java.util.List;
import java.util.Map;

/**
 * @author : BJ
 * @brief : 日志记录
 * @Date : 2019/6/15
 * @Package : net.bjspace.service
 * @file : LogService
 * @note : 操作日志记录类
 */
public interface LogService {

    /**
     * 写入日志信息
     * @param logMsg 日志内容
     * @param remarks 备注信息（可以为空）
     */
    void logInsert(String logMsg, String remarks);

    /**
     * 查询日志信息
     * @param page 当前页
     * @param limit 每页条数
     * @return 日志集合
     */
    List<Map<String, Object>> queryLogs(String search, String startTime, String endTime, String page, String limit);

}

package net.bjspace.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.bjspace.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author : BJ
 * @brief :日志
 * @Date : 2019/6/15
 * @Package : net.bjspace.controller
 * @file : LogController
 * @note :日志
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value="查询所有日志", notes="根据输入条件模糊匹配，根据日期查询；以下所有值都可以为空，分页没有传值的话默认查前10条")
    @ApiImplicitParams({
            @ApiImplicitParam(name="search", value="模糊搜索匹配值", required=true, dataType="String", paramType="query"),
            @ApiImplicitParam(name="startTime", value="日期（yyyy-MM-dd）", required=false, dataType="String", paramType="path"),
            @ApiImplicitParam(name="endTime", value="日期（yyyy-MM-dd）", required=false, dataType="String", paramType="path"),
            @ApiImplicitParam(name="page", value="当前页", required=false, dataType="String", paramType="path"),
            @ApiImplicitParam(name="limit", value="每页显示条数", required=false, dataType="String", paramType="path")})
    @ResponseBody
    @RequestMapping(value = "queryLogs", method = RequestMethod.POST)
    public JSONObject queryLogs(String search, String startTime,
                                               String endTime, String page,
                                               String limit) {
        JSONObject jsonObject = new JSONObject();
        List<Map<String, Object>> maps = logService.queryLogs(search, startTime, endTime, page, limit);
        jsonObject.put("code", 200);
        jsonObject.put("message", "获取成功");
        jsonObject.put("data", maps);
        return jsonObject;
    }

}

package com.edu.common.controller.manager;

import com.edu.commonConfig.service.ISubjectService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lc on 2015/5/30.
 */
public class BaseAction {

	protected final Logger logger = Logger.getLogger(getClass());


    /**
     * 学科service
     */
    @Autowired
    public ISubjectService subjectService;
    

    /**
     * 获取页面参数，增加分页条件
     * @param request
     * @return Map<String, Object> 页面参数
     */
    public Map<String, Object> publicActionParm(HttpServletRequest request) {
        Map<String, Object> parameterMap = this.getParameters(request);
        if (parameterMap != null && parameterMap.get("currentPage") != null) {
            int currentPage = Integer.parseInt(parameterMap.get("currentPage")
                    .toString());
            int pageSize = Integer.parseInt(parameterMap.get("pageSize")
                    .toString());

            parameterMap.put("startIndex", (currentPage - 1) * pageSize);
            parameterMap.put("pageSize", pageSize);
        }else{
        	int currentPage = 1;
            int pageSize = 10;

            parameterMap.put("startIndex", (currentPage - 1) * pageSize);
            parameterMap.put("pageSize", pageSize);
        }
        return parameterMap;
    }

    /**
     * 获取页面上参数包装成map
     * @param request
     * @return Map<String, Object> 页面参数
     */
    public Map<String, Object> getParameters(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            try {
                if (value != null && "".equals(value)) {
                    value = null;
                } else {
                    value = URLDecoder.decode(value, "utf-8");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

}

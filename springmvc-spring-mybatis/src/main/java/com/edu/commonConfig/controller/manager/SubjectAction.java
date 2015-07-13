package com.edu.commonConfig.controller.manager;

import com.edu.common.bean.ComboboxBean;
import com.edu.common.controller.manager.BaseAction;
import com.edu.common.utils.DateUtils;
import com.edu.commonConfig.bean.Gradestage;
import com.edu.commonConfig.bean.Subject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lc on 2015/6/5.
 */
@Controller
@RequestMapping("/mcsubject")
public class SubjectAction extends BaseAction {

    /**
     * 学段年级Service
     *//*
    @Autowired
    private IGradestageService gradestageService;

    *//**
     * 学科service
     *//*
    @Autowired
    private ISubjectService subjectService;*/

    Logger logger = Logger.getLogger(SubjectAction.class);


    /**
     * 列表页面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/listPages")
    public String getPage(HttpServletRequest request, Map<String, Object> map) {
        
        return "manager/pages/commonConfig/subjectLists";
    }

    @RequestMapping("/lists")
    public String getListPage(HttpServletRequest request, Map<String, Object> map) {
        /*Map<String, Object> parameterMap = publicActionParm(request);
        try {
            Pages<Subject> pages = subjectService.selectFkPagination(parameterMap);
            if (pages != null && pages.getResult().size() > 0) {
                map.put("subjects", pages.getResult());
                //map.put("pages",pages);
            } else {
                map.put("subjects", null);
            }
            map.put("total", pages.getTotalsCount());
            map.put("pageSize", pages.getPageSize());
            map.put("pageNumber", pages.getCurrentPage());
            map.putAll(parameterMap);
        } catch (Exception e) {
            logger.error("----------获取科目失败----------------" + e);
            e.printStackTrace();
        }*/
        return "manager/pages/commonConfig/subjectList";
    }


    /**
     * 添加预处理
     */
    @RequestMapping("/preadd")
    public String input(Map<String, Object> map) {
        try {
            Map<String, String> isEnable = new HashMap();
            isEnable.put("1", "启用");
            isEnable.put("0", "不启用");
            map.put("isEnable", isEnable);
            map.put("subject", new Subject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "manager/pages/commonConfig/subjectAdd";
    }

    /**
     * 添加持久化
     */
    @ResponseBody
    @RequestMapping("/add")
    public int save(Subject subject) {
        System.out.println("save =" + subject);
        try {
            //设置增加时的父级ID
            subject.setCreated(DateUtils.getCurrentTime());
            subject.setModified(DateUtils.getCurrentTime());
            subject.setVersion(1);
            return subjectService.insert(subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 删除持久化
     */
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        try {
            return subjectService.delete(id);
        } catch (Exception e) {
            logger.error("----------删除学科失败----------------" + e);
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 编辑预处理
     */
    @RequestMapping("/preedit/{ID}")
    public String input(@PathVariable("ID") Integer ID, Map<String, Object> map) {
        try {
            Map<String, String> isEnable = new HashMap();
            isEnable.put("1", "启用");
            isEnable.put("0", "不启用");
            map.put("isEnable", isEnable);
            map.put("subject", subjectService.selectByPrimaryKey(ID));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "manager/pages/commonConfig/subjectEdit";
    }

    /**
     * 编辑持久化
     */
    @ResponseBody
    @RequestMapping("/edit")
    public Integer edit(Subject subject) {
        System.out.println("update =" + subject);
        try {
            subject.setModified(DateUtils.getCurrentTime());
            subject.setVersion(subject.getVersion() + 1);
            return subjectService.update(subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
     *
     * @param ID
     * @param map
     */
    @ModelAttribute
    public void getSubject(@RequestParam(value = "ID", required = false) Integer ID,
                              Map<String, Object> map) {
        if (ID != null) {
            try {
                map.put("subject", subjectService.selectByPrimaryKey(ID));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * list<学段年级>集合转换成json字符串，用于easyui combobox学段年级下拉列表显示
     * @param gradestages list<学段年级>
     * @param id          默认显示的选择项，如果为0，默认为第一个,-1没有默认选中值，
     *                    由页面控制,其它值则是指定具体的ID值
     * @return
     */
    public List<ComboboxBean> listToJson(List<Gradestage> gradestages, int id) {
        List<ComboboxBean> comboboxBeans = new ArrayList<ComboboxBean>();
        if (gradestages != null && gradestages.size() > 0) {
            ComboboxBean comboboxBean = null;
            for (int i = 0; i < gradestages.size(); i++) {
                Gradestage gradestage = gradestages.get(i);
                if (id == -1) {
                    comboboxBean = new ComboboxBean(gradestage.getID(), gradestage.getgName());
                } else if (id != 0 && id != -1) {
                    if (id == gradestage.getID()) {
                        comboboxBean = new ComboboxBean(gradestage.getID(), gradestage.getgName(), true);
                    } else {
                        comboboxBean = new ComboboxBean(gradestage.getID(), gradestage.getgName());
                    }
                } else if (id == 0) {
                    if (i == 0) {
                        comboboxBean = new ComboboxBean(gradestage.getID(), gradestage.getgName(), true);
                    } else {
                        comboboxBean = new ComboboxBean(gradestage.getID(), gradestage.getgName());
                    }
                }
                comboboxBeans.add(comboboxBean);
            }
        }
        return comboboxBeans;
    }
}

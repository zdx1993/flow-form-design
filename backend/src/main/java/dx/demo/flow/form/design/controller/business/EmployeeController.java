package dx.demo.flow.form.design.controller.business;

import dx.demo.flow.form.design.common.BackEntity;
import dx.demo.flow.form.design.controller.BaseController;
import dx.demo.flow.form.design.entity.DefinitionFormDesign;
import dx.demo.flow.form.design.service.DefinitionFormDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

/**
 * @description: 用于雇员相关操作的controller
 * @author: zhang.da.xin
 * @create: 2019-07-11 13:35
 **/

@Controller
@ResponseBody
public class EmployeeController extends BaseController {

    private final String FLOWABLE_SERVICE_URL="http://127.0.0.1:8080/flowable-modeler/";


    @Autowired
    private DefinitionFormDesignService definitionFormDesignService;

    @Autowired
    private RestTemplate restTemplate;

    //获取启动流程的表单
    @GetMapping("/form/init")
    public BackEntity getFormInit(String processKey){
        String formId = restTemplate.getForObject(FLOWABLE_SERVICE_URL + "/formId_by_processkey?processKey="+processKey, String.class);
        DefinitionFormDesign definitionFormDesign = definitionFormDesignService.selectByPrimaryKey(formId);
        return getOkBack(definitionFormDesign);
    }

    //获取任务的表单
    @GetMapping("/form/task")
    public BackEntity getTaskForm(String taskId){
        //获取任务表单的formId
        String formId = restTemplate.getForObject(FLOWABLE_SERVICE_URL + "formId_by_taskId?taskId="+taskId, String.class);
        DefinitionFormDesign definitionFormDesign = definitionFormDesignService.selectByPrimaryKey(formId);
        String content = definitionFormDesign.getContent();
        //获取当前任务对应的流程变量
        Map<String,String> forObject = restTemplate.getForObject(FLOWABLE_SERVICE_URL + "task_variables?taskId=" + taskId, Map.class);
        //根据当前的流程变量(由于表单提交自动生成的),渲染自定义的表单
        Set<String> variableKeys = forObject.keySet();
        for (String variableKey : variableKeys) {
            content = content.replace(String.format("${%s}",variableKey),forObject.get(variableKey));
        }
        definitionFormDesign.setContent(content);
        return getOkBack(definitionFormDesign);
    }

}

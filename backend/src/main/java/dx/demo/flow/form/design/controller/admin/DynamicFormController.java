package dx.demo.flow.form.design.controller.admin;

import dx.demo.flow.form.design.common.BackEntity;
import dx.demo.flow.form.design.controller.BaseController;
import dx.demo.flow.form.design.entity.DefinitionFormDesign;
import dx.demo.flow.form.design.service.DefinitionFormDesignService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 管理员用户关于动态表单相关功能的操作
 * @author: zhang.da.xin
 * @create: 2019-07-10 14:07
 **/

@Controller
@ResponseBody
@MapperScan(basePackages = "dx.demo.flow.form.design.dao")
@RequestMapping("/admin_form")
public class DynamicFormController extends BaseController {
    @Autowired
    private DefinitionFormDesignService definitionFormDesignService;

    @GetMapping("/form_list")
    public BackEntity getformList(){
        return new BackEntity("200","请求成功",definitionFormDesignService.selectAll());
    }
    @PostMapping("/add_form_item")
    public BackEntity addFormItem(DefinitionFormDesign definitionFormDesign){
        return new BackEntity("200","请求成功",definitionFormDesignService.insert(definitionFormDesign));
    }
    @GetMapping("/details")
    public BackEntity getDetails(String id){
        return new BackEntity("200","请求成功",definitionFormDesignService.selectByPrimaryKey(id));
    }
}

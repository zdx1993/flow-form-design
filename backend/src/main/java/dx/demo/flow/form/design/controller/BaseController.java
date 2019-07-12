package dx.demo.flow.form.design.controller;

import dx.demo.flow.form.design.common.BackEntity;

/**
 * @description: 基础控制器
 * @author: zhang.da.xin
 * @create: 2019-07-10 14:11
 **/


public class BaseController {
    public <T> BackEntity<T> getOkBack(T back){
        return new BackEntity("200","请求成功",back);
    }
}

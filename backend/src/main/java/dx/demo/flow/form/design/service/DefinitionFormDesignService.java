package dx.demo.flow.form.design.service;

import dx.demo.flow.form.design.entity.DefinitionFormDesign;import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 动态表单定义service
 * @author: zhang.da.xin
 * @create: 2019-07-10 14:18
 **/

@Service
public interface DefinitionFormDesignService {

    int deleteByPrimaryKey(String id);

    int insert(DefinitionFormDesign record);

    int insertSelective(DefinitionFormDesign record);

    DefinitionFormDesign selectByPrimaryKey(String id);

    List<DefinitionFormDesign> selectAll();

    int updateByPrimaryKeySelective(DefinitionFormDesign record);

    int updateByPrimaryKey(DefinitionFormDesign record);
}


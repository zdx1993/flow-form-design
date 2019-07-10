package dx.demo.flow.form.design.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import dx.demo.flow.form.design.entity.DefinitionFormDesign;
import dx.demo.flow.form.design.dao.DefinitionFormDesignMapper;
import dx.demo.flow.form.design.service.DefinitionFormDesignService;

import java.util.List;

@Service
public class DefinitionFormDesignServiceImpl implements DefinitionFormDesignService{

    @Resource
    private DefinitionFormDesignMapper definitionFormDesignMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return definitionFormDesignMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DefinitionFormDesign record) {
        return definitionFormDesignMapper.insert(record);
    }

    @Override
    public int insertSelective(DefinitionFormDesign record) {
        return definitionFormDesignMapper.insertSelective(record);
    }

    @Override
    public DefinitionFormDesign selectByPrimaryKey(String id) {
        return definitionFormDesignMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DefinitionFormDesign> selectAll() {
        return definitionFormDesignMapper.selectAll();
    }


    @Override
    public int updateByPrimaryKeySelective(DefinitionFormDesign record) {
        return definitionFormDesignMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DefinitionFormDesign record) {
        return definitionFormDesignMapper.updateByPrimaryKey(record);
    }

}

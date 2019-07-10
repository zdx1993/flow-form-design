package dx.demo.flow.form.design.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import dx.demo.flow.form.design.entity.DefinitionFormDesign;

public interface DefinitionFormDesignMapper {
    int deleteByPrimaryKey(String id);

    int insert(DefinitionFormDesign record);

    int insertSelective(DefinitionFormDesign record);

    DefinitionFormDesign selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DefinitionFormDesign record);

    int updateByPrimaryKey(DefinitionFormDesign record);

    List<DefinitionFormDesign> selectAll();

}
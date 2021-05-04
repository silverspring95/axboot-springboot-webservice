package edu.axboot.domain.bom;

import com.chequer.axboot.core.mybatis.MyBatisMapper;

import java.util.HashMap;
import java.util.List;

public interface EducationBomMapper /*extends MyBatisMapper*/ {
    List<EducationBom> select(HashMap<String, String> params);
    EducationBom selectOne(Long id);

    int insert(EducationBom educationBom);
    int update(EducationBom educationBom);
    int delete(Long id);
}

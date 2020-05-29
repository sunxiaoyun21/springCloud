package com.demo.mapper;

import com.demo.entity.akt.TAktorgInstitutionAnnexEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;


/**
 * @author 孙小云
 * @date 2020/5/28 11:47
 **/
@Mapper
@Repository
public interface ImgMapper extends BaseMapper<TAktorgInstitutionAnnexEntity> {

}

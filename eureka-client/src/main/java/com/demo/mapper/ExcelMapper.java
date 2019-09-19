package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/18 17:12
 **/
@Mapper
public interface ExcelMapper{


    @Select(" SELECT\n" +
        "      (cv_job_hunting.comprehensive :: jsonb -> 'workCategory')::varchar AS TYPE\n" +
        "    FROM\n" +
        "      cv_job_hunting\n" +
        "        INNER JOIN cv_info ON cv_info.user_id = cv_job_hunting.user_id\n" +
        "        INNER JOIN user_info ON user_info.user_id = cv_job_hunting.user_id\n" +
        "    WHERE\n" +
        "      cv_info.archive_complete > 0.6\n" +
        "      and cv_info.job_status=1\n" +
        "      and cv_job_hunting.comprehensive ::jsonb@> '{\"workNature\":[\"${type}\"]}'\n" +
        "   ;")
    List<String> findJobHuntingByType(@Param("type") String type);

    int findPostNum(@Param("category") String category,@Param("type") int type,@Param("all") Boolean all);
}

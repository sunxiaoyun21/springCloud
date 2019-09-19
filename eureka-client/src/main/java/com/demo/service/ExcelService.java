package com.demo.service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/9/18 17:10
 **/
public interface ExcelService {

    List findJobHuntingByType(String type);
}

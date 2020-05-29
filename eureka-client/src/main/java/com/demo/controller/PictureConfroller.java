package com.demo.controller;

import com.demo.entity.akt.OrgVo;
import com.demo.entity.akt.TAktorgOrgEntity;
import com.demo.service.akt.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 孙小云
 * @date 2020/5/28 11:15
 **/
@RestController
@RequestMapping("/img/")
public class PictureConfroller {

    @Autowired
    PictureService pictureService;


    @GetMapping("findAll")
    public List<OrgVo>  findAll(){
        return pictureService.findList();
    }


    @PostMapping("insertImg")
    public Boolean insertImg(String path,String parent){
       return  pictureService.insertImg(path,parent);
    }

}

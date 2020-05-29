package com.demo.service.akt;

import com.demo.GetPictureName;
import com.demo.entity.akt.OrgVo;
import com.demo.entity.akt.TAktorgInstitutionAnnexEntity;
import com.demo.entity.akt.TAktorgOrgEntity;
import com.demo.mapper.ImgMapper;
import com.demo.mapper.PictureMapper;
import com.demo.utils.BeanUtils;
import com.demo.utils.OtherUtil;
import com.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 孙小云
 * @date 2020/5/28 11:10
 **/
@Component
public class PictureService {

    @Autowired
    PictureMapper pictureMapper;

    @Autowired
    ImgMapper imgMapper;

    public List<OrgVo> findList(){
        return BeanUtils.copy(pictureMapper.select(new TAktorgOrgEntity().setDelFlag("0")),OrgVo.class);
    }


    public Boolean insertImg(String path,String parentName) {
        List<OrgVo> list = findList();
        Collection<OrgVo> collection = findList();
        Stream<OrgVo> orgVoStream = collection.stream().filter(new Predicate<OrgVo>() {
            @Override
            public boolean test(OrgVo orgVo) {
                return parentName.equals(orgVo.getOrgName());//
            }
        });
        collection = orgVoStream.collect(Collectors.toList());
        collection.forEach(obj->{
            String id = obj.getId();
            String orgName = obj.getOrgName();
            String tenantId = obj.getTenantId();
            String userId = obj.getUserId();
            String systemId = obj.getSystemId();
            String organizeId = obj.getOrganizeId();
            List<String> names= GetPictureName.getFileName(path);
            names.forEach(name->{
                TAktorgInstitutionAnnexEntity img = new  TAktorgInstitutionAnnexEntity();
                img.setId(UUIDUtil.generateUuid())
                        .setDelFlag("0")
                        .setOrgId(id)
                        .setOrgName(orgName)
                        .setTenantId(tenantId)
                        .setUserId(userId)
                        .setSystemId(systemId)
                        .setOrganizeId(organizeId)
                        .setCreateBy("b1598571dc2e4613abaaeb197387d124")
                        .setCreateDate(new Date())
                        .setOriginalFileName(name)
                        .setFileName(name)
                        .setFilePath("/usr/local/tomcat/tomcat-nanning/apache-tomcat-8.0.41/webapps/pensionSector/WEB-INF/static/img/");
                imgMapper.insertSelective(img);

            });

        });
        return true;
    }


    public static void main(String[] args) {


       String ss= "C:/Users/sunxi/Pictures/timg.jpg";
        String str = ss.substring(ss.indexOf("/Pictures"), ss.indexOf(".jpg"));
        System.out.println(str);
        System.out.println(ss.indexOf("/Pictures"));
    }
}

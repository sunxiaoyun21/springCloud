package com.demo.entity.akt;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author sunxiaoyun
 * @date 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "t_aktorg_institution_annex")
public class TAktorgInstitutionAnnexEntity implements Serializable {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 机构id
     */
    private String orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 原文件名称
     */
    private String originalFileName;

    /**
     * 现文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件大小
     */
    private String fileSize;

    private String remarks;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String status;

    private String version;

    private String affixFlag;

    private String tenantId;

    private String delFlag;

    private String organizeId;

    private String userId;

    private String systemId;
}

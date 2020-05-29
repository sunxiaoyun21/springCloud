package com.demo.entity.akt;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 机构表
 *
 * @author sunxiaoyun
 * @date 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "t_aktorg_org")
public class TAktorgOrgEntity implements Serializable {

    @Id
    private String id;

    /**
     * 父机构ID
     */
    private String orgParentId;

    private String priceLevel;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 法人电话
     */
    private String legalPersonPhone;

    /**
     * 身份证号
     */
    private String legalPersonIdentity;

    /**
     * 法人邮箱
     */
    private String legalPersonEmail;

    /**
     * 住址
     */
    private String legalPersonAddr;

    /**
     * 邮编
     */
    private String legalPersonZipcode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 编码
     */
    private String orgCode;

    /**
     * 机构LOGO
     */
    private String orgLogo;

    /**
     * 占地面积
     */
    private String orgAcreage;

    /**
     * 所属区域
     */
    private String orgOwnerArea;

    /**
     * 床位数
     */
    private Integer orgBedCount;

    /**
     * 机构地址
     */
    private String orgAddr;

    /**
     * 联系电话
     */
    private String orgPhone;

    /**
     * 机构性质 - 公办事业/工商企业/民办非
     */
    private String orgNatuare;

    /**
     * 投资总额
     */
    private String orgGrossAssets;

    /**
     * 成立日期
     */
    private String orgSetupDate;

    /**
     * 机构邮编
     */
    private String orgZipcode;

    /**
     * 机构邮箱
     */
    private String orgEmail;

    /**
     * 业务范围
     */
    private String orgBusinessScope;

    /**
     * 组织 结构代码证号
     */
    private String orgdocCode;

    /**
     * 开户行
     */
    private String bankOpening;

    /**
     * 户名
     */
    private String bankUsername;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 机构备注
     */
    private String orgDesc;

    private String createBy;

    private String updateBy;

    private Date createDate;

    private Date updateDate;

    private String delFlag;

    private String status;

    private String version;

    /**
     * 是否有附件
     */
    private String affixFlag;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 组织ID
     */
    private String organizeId;

    private String userId;

    private String systemId;

    private String remarks;

    /**
     * 当前住人数
     */
    private String dangqiansum;

    /**
     * 经度
     */
    private String locationX;

    /**
     * 纬度
     */
    private String locationY;

    /**
     * 市id
     */
    private String areaId;

    /**
     * 市名称
     */
    private String areaName;

    /**
     * 区id
     */
    private String districtId;

    /**
     * 区名称
     */
    private String districtName;

    /**
     * 服务人数
     */
    private Integer serviceNumber;

    /**
     * 服务总量
     */
    private Integer serviceQuantity;

    /**
     * 查房次数
     */
    private Integer makeNumber;

    /**
     * 消防检查次数
     */
    private Integer fireNumber;

    /**
     * 护理消毒次数
     */
    private Integer disinfectionNumber;

    /**
     * 上传人姓名
     */
    private String uploadingName;

    /**
     * 上传人电话
     */
    private String uploadingPhone;

    /**
     * 满意度
     */
    private Integer satisfaction;

    /**
     * 总金额
     */
    private Integer sumMoney;

    /**
     * 机构备注
     */
    private String orgIntroduce;

    /**
     * 机构星级
     */
    private String starClass;

    private String topOrder;

    private Integer stor;
}

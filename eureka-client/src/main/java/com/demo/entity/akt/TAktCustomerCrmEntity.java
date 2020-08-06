package com.demo.entity.akt;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author sunxiaoyun
 * @date 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "t_akt_customer_crm")
public class TAktCustomerCrmEntity implements Serializable {

    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 邮箱
     */
    private String customerEmail;

    /**
     * 同步状态
     */
    private String isSynchronize;

    /**
     * 同步状态
     */
    private String martialStatus;

    /**
     * 同步状态
     */
    private String elevator;

    /**
     * 是否有货梯
     */
    private String serviceElevator;

    /**
     * 付费类型
     */
    private String healthyPayType;

    /**
     * 医疗卡号
     */
    private String medicalCard;

    /**
     * 身高
     */
    private String customerHeight;

    /**
     * 体重
     */
    private String customerWeight;

    /**
     * 血型
     */
    private String customerBlood;

    /**
     * 是否吸烟
     */
    private String smokingFlag;

    /**
     * 户口所在地
     */
    private String accountAddress;

    /**
     * 户口所在地邮编
     */
    private String accountPostCode;

    /**
     * 原职业
     */
    private String customerJob;

    /**
     * 本人月收入
     */
    private BigDecimal customerMoney;

    /**
     * 养老意向
     */
    private String customerMind;

    /**
     * 服务保障
     */
    private String serviceKind;

    /**
     * 经济来源
     */
    private String moneySource;

    /**
     * 失能情况
     */
    private String lostStatus;

    /**
     * 健康状况
     */
    private String healthyStatus;

    /**
     * 用户二维码路径
     */
    private String customerCodeUrl;

    /**
     * 客户所属业务
     */
    private String customerBussiness;

    /**
     * 用户头像
     */
    private String icon;

    /**
     * 经度
     */
    private String locationX;

    /**
     * 维度
     */
    private String locationY;

    /**
     * 电子围栏半径
     */
    private String circleRadius;

    /**
     * 电子围栏多边形
     */
    private String squareRadius;

    /**
     * 农历生日
     */
    private String chineseBirthday;

    /**
     * 用户编号
     */
    private String customerNo;

    /**
     * 用户姓名
     */
    private String customerName;

    /**
     * 性别
     */
    private String customerSex;

    /**
     * 政府补贴类型配置
     */
    private String govSubsidy;

    /**
     * 补贴叠加配置
     */
    private String subsidyComposition;

    /**
     * 居家评估等级配置
     */
    private String homeAssessLevel;

    /**
     * 长护险等级配置
     */
    private String longInsuranceLevel;

    /**
     * 服务方式配置
     */
    private String serviceMode;

    /**
     * 自费比例配置
     */
    private String privateCostPercent;

    /**
     * 服务属性配置
     */
    private String serviceProperties;

    private String customerType;

    private String customerKind;

    /**
     * 生日
     */
    private String customerBirthday;

    /**
     * 身份证号
     */
    private String identifyNo;

    private String customerCategory;

    /**
     * 手机
     */
    private String customerMobile;

    /**
     * 地址
     */
    private String customerAddress;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 年龄
     */
    private String customerAge;

    /**
     * 住宅电话
     */
    private String customerPhone;

    /**
     * 用户唯一码
     */
    private String customerUkey;

    /**
     * 所属客户
     */
    private String customerSource;

    /**
     * 家庭唯一码
     */
    private String familyUkey;

    /**
     * 家庭二维码
     */
    private String familyCodeUrl;

    /**
     * 靠近路名
     */
    private String nearbyRoad;

    /**
     * 救护车入口
     */
    private String ambulanceEnter;

    /**
     * 钥匙存放地
     */
    private String keyPlace;

    /**
     * 子女情况
     */
    private String childrenCondition;

    /**
     * 居住情况
     */
    private String liveCondition;

    /**
     * 附近街道
     */
    private String nearbyStreet;

    /**
     * 机器编号
     */
    private String machineNo;

    /**
     * 机器使用状态
     */
    private String useStatus;

    /**
     * 所属物业
     */
    private String ownedProperty;

    /**
     * 安装日期
     */
    private String installDate;

    /**
     * APP绑定状态
     */
    private String appStatus;

    /**
     * 特长爱好
     */
    private String customerHobby;

    /**
     * 所属区/街道、居委全路径
     */
    private String customerBelongsFullPath;

    private String customerBelongsName;

    /**
     * 所属区/街道/居委
     */
    private String customerBelongs;

    /**
     * 居委电话
     */
    private String neighborhoodPhone;

    /**
     * 所属物业
     */
    private String propertyBelongs;

    /**
     * 所属物业电话
     */
    private String propertyPhone;

    /**
     * 所属警署/派出所
     */
    private String policeBelongs;

    /**
     * 所属警署/派出所电话
     */
    private String policePhone;

    /**
     * 机器所有权
     */
    private String machineOwnership;

    /**
     * 退机日期
     */
    private String rejectDate;

    /**
     * 销售员
     */
    private String sales;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 责任人
     */
    private String responsible;

    /**
     * 收费说明
     */
    private String chargeDescription;

    /**
     * 收费类别
     */
    private String chargeKind;

    /**
     * 收费银行
     */
    private String chargeBank;

    /**
     * 联系状态(预留)
     */
    private String connectState;

    /**
     * 是否潜在客户 0否  1是
     */
    private String customerFlag;

    /**
     * 录入人ID
     */
    private String optUserId;

    /**
     * 录入人姓名
     */
    private String optUserName;

    /**
     * 录入人类型
     */
    private String optUserType;

    /**
     * is_subscription（预留）
     */
    private String isSubscription;

    /**
     * 名单状态(预留)
     */
    private String listStatus;

    /**
     * 名单内类型(预留)
     */
    private String listInType;

    /**
     * 导入批次
     */
    private String importBatch;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * 组织ID
     */
    private String organizeId;

    /**
     * 租户ID
     */
    private String tenantsId;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String field6;

    private String field7;

    private String field9;

    private String field10;

    private String field11;

    private String field12;

    private String field13;

    private String field14;

    private String field15;

    private String field16;

    private String field17;

    private String field18;

    /**
     * 健康档案封面数据
     */
    private String field19;

    private String field20;

    /**
     * 是否享受区级补贴
     */
    private String isDistrictSubsidy;

    /**
     * 是否VIP用户
     */
    private String isVip;

    /**
     * VIP用户等级
     */
    private String vipLevel;

    /**
     * 积分
     */
    private String score;

    /**
     * 是否绑定标签
     */
    private String isTags;

    /**
     * 区域
     */
    private String area;

    /**
     * 版本
     */
    private String version;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否有附件
     */
    private String affixFlag;

    /**
     * 客户号码
     */
    private String customerNumber;

    /**
     * 退机原因
     */
    private String rejectReason;

    /**
     * 配偶姓名
     */
    private String spouseName;

    /**
     * 配偶身份证号
     */
    private String spouseIdentifyno;

    /**
     * 配偶性别
     */
    private String spouseSex;

    /**
     * 配偶生日
     */
    private String spouseBirthday;

    /**
     * 电子钱包余额
     */
    private String ewalletBalance;

    /**
     * 到费日期
     */
    private String expEndDate;

    /**
     * 百度地图经度
     */
    private String longitudeBd;

    /**
     * 百度地图纬度
     */
    private String latitudeBd;

    /**
     * 民族
     */
    private String customerNation;

    /**
     * 常住类型
     */
    private String residentType;

    /**
     * 婚姻状况
     */
    private String customerMarriage;

    /**
     * 宗教信仰
     */
    private String customerReligion;

    /**
     * 文化程度
     */
    private String customerDegree;
}

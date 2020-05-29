package com.demo.entity.akt;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 孙小云
 * @date 2020/5/28 11:25
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrgVo {

    private String id;
    private String orgName;
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

}

package com.example.achieve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisTest.generator.processor.param.get.GenGetParam;
import com.example.mybatisTest.generator.processor.param.get.IgnoreGenGetParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户关系表
 * </p>
 *
 * @author 屈燃希
 * @since 2022-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="user_relation对象",description="用户关系表")
@TableName("user_relation")
@GenGetParam(pkgName = "com.example.achieve.param.userRelation",isPage = false)
public class UserRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户关系表id
     */
    @IgnoreGenGetParam
    @TableId(value = "user_relation_id", type = IdType.AUTO)
    @ApiModelProperty("用户关系表id")
    private Integer userRelationId;

    /**
     * 用户id
     */
    @TableField("user_id")
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 所属代理用户pid
     */
    @TableField("user_agent_pid")
    @ApiModelProperty("所属代理用户pid")
    private Integer userAgentPid;

    /**
     * 所属主播代理pid
     */
    @TableField("user_anchor_pid")
    @ApiModelProperty("所属主播代理pid")
    @IgnoreGenGetParam
    private Integer userAnchorPid;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @ApiModelProperty("创建时间")
    @IgnoreGenGetParam
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty("更新时间")
    @IgnoreGenGetParam
    private LocalDateTime updateTime;


}

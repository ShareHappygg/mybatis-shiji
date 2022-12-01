package com.example.achieve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisTest.generator.processor.param.add.GenAddParam;
import com.example.mybatisTest.generator.processor.param.get.GenGetParam;
import com.example.mybatisTest.generator.processor.param.update.GenUpdateParam;
import com.example.mybatisTest.generator.processor.vo.GenVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户代理
 * </p>
 *
 * @author 屈燃希
 * @since 2022-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="user_agent对象",description="用户代理")
@TableName("user_agent")
@GenUpdateParam(pkgName = "com.example.achieve.param.userAgent")
@GenGetParam(pkgName = "com.example.achieve.param.userAgent")
@GenAddParam(pkgName = "com.example.achieve.param.userAgent")
@GenVo(pkgName = "com.example.achieve.vo.userAgent")
//@(pkgName = "com.example.achieve.param.userAgent")
public class UserAgent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户代理表id
     */
    @TableId(value = "user_agent_id", type = IdType.AUTO)
    @ApiModelProperty("用户代理表id")
    private Integer userAgentId;

    /**
     * 用户id
     */
    @TableField("user_id")
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 用户代理列表	
     */
    @TableField("user_agent_list")
    @ApiModelProperty("用户代理列表	")
    private String userAgentList;


}

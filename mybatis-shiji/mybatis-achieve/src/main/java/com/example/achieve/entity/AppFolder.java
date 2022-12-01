package com.example.achieve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisTest.generator.processor.param.add.GenAddParam;
import com.example.mybatisTest.generator.processor.param.get.GenGetParam;
import com.example.mybatisTest.generator.processor.vo.GenVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件夹表
 * </p>
 *
 * @author 屈燃希
 * @since 2022-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="app_folder对象",description="文件夹表")
@TableName("app_folder")
@GenAddParam(pkgName = "com.example.achieve.param.folder")
@GenGetParam(pkgName ="com.example.achieve.param.folder",isPage = false )
@GenVo(pkgName ="com.example.achieve.vo.folder")
public class AppFolder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件夹id
     */
    @TableId(value = "app_folder_id", type = IdType.AUTO)
    @ApiModelProperty("文件夹id")
    private Integer appFolderId;

    /**
     * 文件夹名称
     */
    @TableField("app_folder_name")
    @ApiModelProperty("文件夹名称")
    private String appFolderName;

    /**
     * 父文件夹id
     */
    @TableField("app_folder_pid")
    @ApiModelProperty("父文件夹id")
    private Integer appFolderPid;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}

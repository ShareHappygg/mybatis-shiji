package com.example.achieve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisTest.generator.processor.param.update.GenUpdateParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author 屈燃希
 * @since 2022-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="app_file对象",description="文件表")
@TableName("app_file")
@GenUpdateParam(pkgName = "com.example.achieve.param.file")
public class AppFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件id
     */
    @TableId(value = "app_file_id", type = IdType.AUTO)
    @ApiModelProperty("文件id")
    private Long appFileId;

    /**
     * 文件名称
     */
    @TableField("name")
    @ApiModelProperty("文件名称")
    private String name;

    /**
     * 文件md5
     */
    @TableField("md5")
    @ApiModelProperty("文件md5")
    private String md5;

    /**
     * 上传路径
     */
    @TableField("path")
    @ApiModelProperty("上传路径")
    private String path;

    /**
     * 上传时间
     */
    @TableField("upload_time")
    @ApiModelProperty("上传时间")
    private LocalDateTime uploadTime;

    /**
     * 是否已经删除 1为删除 0为正常
     */
    @TableField("is_delete")
    @ApiModelProperty("是否已经删除 1为删除 0为正常")
    private Integer isDelete;

    /**
     * 文件大小
     */
    @TableField("size")
    @ApiModelProperty("文件大小")
    private Integer size;

    /**
     * 文件后缀名
     */
    @TableField("suffix")
    @ApiModelProperty("文件后缀名")
    private String suffix;


}

// ---Auto Generated by Only4Play ---
package com.example.achieve.param.file;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(
    chain = true
)
@JsonIgnoreProperties({ "handler" })
@ApiModel(
    value = "app_file对象",
    description = "更新文件表Param"
)
public class UpdateAppFileParam {
  private long serialVersionUID;

  @ApiModelProperty("文件id")
  @JsonProperty("app_file_id")
  private Long appFileId;

  @ApiModelProperty("文件名称")
  @JsonProperty("name")
  private String name;

  @ApiModelProperty("文件md5")
  @JsonProperty("md5")
  private String md5;

  @ApiModelProperty("上传路径")
  @JsonProperty("path")
  private String path;

  @ApiModelProperty("上传时间")
  @JsonProperty("upload_time")
  private LocalDateTime uploadTime;

  @ApiModelProperty("是否已经删除 1为删除 0为正常")
  @JsonProperty("is_delete")
  private Integer isDelete;

  @ApiModelProperty("文件大小")
  @JsonProperty("size")
  private Integer size;

  @ApiModelProperty("文件后缀名")
  @JsonProperty("suffix")
  private String suffix;
}
// ---Auto Generated by Only4Play ---
package com.example.achieve.vo.coupon;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(
    chain = true
)
@JsonIgnoreProperties({ "handler" })
@ApiModel(
    value = "Coupon对象",
    description = "优惠券表Vo"
)
public class CouponVo {
  private long serialVersionUID;

  @ApiModelProperty("id")
  @JsonProperty("id")
  private Long id;

  @ApiModelProperty("优惠券名称")
  @JsonProperty("name")
  private String name;

  @ApiModelProperty("抵消金币")
  @JsonProperty("offset_gold")
  private Integer offsetGold;

  @ApiModelProperty("优惠券描述信息")
  @JsonProperty("tips")
  private String tips;

  @ApiModelProperty("使用类型 0座驾 1头饰 2vip 3背景 4欢迎礼物")
  @JsonProperty("type")
  private Integer type;

  @ApiModelProperty("有效期限（天）")
  @JsonProperty("time_limit")
  private Long timeLimit;

  @ApiModelProperty("创建时间")
  @JsonProperty("create_time")
  @JsonFormat(
      pattern = "yyyy-MM-dd HH:mm:ss",
      timezone = "GMT+8"
  )
  private Date createTime;

  @ApiModelProperty("修改时间")
  @JsonProperty("update_time")
  @JsonFormat(
      pattern = "yyyy-MM-dd HH:mm:ss",
      timezone = "GMT+8"
  )
  private Date updateTime;
}
package com.example.achieve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * 用户资产表
 * </p>
 *
 * @author 屈燃希
 * @since 2022-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="user_asset对象",description="用户资产表")
@TableName("user_asset")
@GenVo(pkgName = "com.example.achieve.vo.userAsset")
public class UserAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 金币数量（余量）
     */
    @TableField("gold_coin")
    @ApiModelProperty("金币数量（余量）")
    private Long goldCoin;

    /**
     * 银币数量（余量）
     */
    @TableField("silver_coin")
    @ApiModelProperty("银币数量（余量）")
    private Long silverCoin;

    /**
     * 钻石数量（余量）
     */
    @TableField("diamond")
    @ApiModelProperty("钻石数量（余量）")
    private Long diamond;

    /**
     * 财富等级;默认为1级（15级才能申请靓号、25以上房间靓号和个人靓号一致）
     */
    @TableField("wealth_level")
    @ApiModelProperty("财富等级;默认为1级（15级才能申请靓号、25以上房间靓号和个人靓号一致）")
    private Integer wealthLevel;

    /**
     * 魅力等级;默认为1级
     */
    @TableField("charisma_level")
    @ApiModelProperty("魅力等级;默认为1级")
    private Integer charismaLevel;

    /**
     * 财富值（金币）
     */
    @TableField("wealth_val")
    @ApiModelProperty("财富值（金币）")
    private Long wealthVal;

    /**
     * 魅力值（金币）
     */
    @TableField("charisma_val")
    @ApiModelProperty("魅力值（金币）")
    private Long charismaVal;

    /**
     * 个人经验值
     */
    @TableField("exp")
    @ApiModelProperty("个人经验值")
    private Integer exp;

    /**
     * vip等级（默认为0 1-5vip可申请靓号ID）
     */
    @TableField("vip_level")
    @ApiModelProperty("vip等级（默认为0 1-5vip可申请靓号ID）")
    private Integer vipLevel;

    /**
     * 总充值人民币数额
     */
    @TableField("RMB")
    @ApiModelProperty("总充值人民币数额")
    private Long rmb;

    /**
     * 总充值美元数额
     */
    @TableField("dollar")
    @ApiModelProperty("总充值美元数额")
    private Long dollar;

    /**
     * 代理充值
     */
    @TableField("agent_recharge")
    @ApiModelProperty("代理充值")
    private Long agentRecharge;

    /**
     * 贡献值（金币）
     */
    @TableField("contribute")
    @ApiModelProperty("贡献值（金币）")
    private Long contribute;

    /**
     * 钻石转金币的花费的总钻石数
     */
    @TableField("diamond_gold")
    @ApiModelProperty("钻石转金币的花费的总钻石数")
    private Long diamondGold;

    /**
     * 本月收益（金币）
     */
    @TableField("thismonth_earnings")
    @ApiModelProperty("本月收益（金币）")
    private Long thismonthEarnings;

    /**
     * 上月收益（金币）
     */
    @TableField("lastmonth_earnings")
    @ApiModelProperty("上月收益（金币）")
    private Long lastmonthEarnings;

    /**
     * 用户等级（默认1级）
     */
    @TableField("user_level")
    @ApiModelProperty("用户等级（默认1级）")
    private Integer userLevel;

    /**
     * 1封禁消费 0正常
     */
    @TableField("is_freeze")
    @ApiModelProperty("1封禁消费 0正常")
    private Integer isFreeze;

    /**
     * 账户余额（美金）
     */
    @TableField("balance")
    @ApiModelProperty("账户余额（美金）")
    private Long balance;

    /**
     * vip过期时间
     */
    @TableField("vip_expire_time")
    @ApiModelProperty("vip过期时间")
    private LocalDateTime vipExpireTime;

    /**
     * 装备的座驾ID
     */
    @TableField("equip_ride")
    @ApiModelProperty("装备的座驾ID")
    private Integer equipRide;

    /**
     * 装备的头像框ID
     */
    @TableField("equip_avatar_box")
    @ApiModelProperty("装备的头像框ID")
    private Integer equipAvatarBox;

    /**
     * 充值次数
     */
    @TableField("recharge_count")
    @ApiModelProperty("充值次数")
    private Integer rechargeCount;

    /**
     * 充值金币（充值数额转换成金币数）1美元:1000金币
     */
    @TableField("recharge_gold")
    @ApiModelProperty("充值金币（充值数额转换成金币数）1美元:1000金币")
    private String rechargeGold;


}

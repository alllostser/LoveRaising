package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("raisinginfo")
public class RaisingInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String raisingId;

    private Integer statusId;

    private String raisingTitle;

    private String raisingName;

    private Double targetAmount;

    private Double currentAmount;

    private String creatTime;

    private String raisingDescription;

    private String bankNum;

    private String userName;

    private String firstUrl;

    @TableField(exist = false)
    private List<RaisingImageInfo> urls;

}

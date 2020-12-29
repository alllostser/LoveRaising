package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("raisinginfo")
public class RaisingInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer statusId;

    private String raisingTitle;

    private String raisingName;

    private double targetAmount;

    private double currentAmount;

    private String creatTime;

    private String raisingDescription;

    private String bankNum;

    private String userName;


}

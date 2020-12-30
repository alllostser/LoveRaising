package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("activitiesinfo")
public class ActivitiesInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String activityId;

    private Integer statusId;

    private String activityTitle;

    private String activityLocation;

    private String activityDescription;

    private Integer activityNum;

    private Integer currentNum;

    private String startTime;

    private String creatTime;

    private String userName;

    private String firstUrl;
}

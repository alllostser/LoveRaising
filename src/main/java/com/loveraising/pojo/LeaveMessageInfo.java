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
@TableName("enrollinfo")
public class LeaveMessageInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String name;

    private String telephone;

    private String message;

    private String creatTime;
}

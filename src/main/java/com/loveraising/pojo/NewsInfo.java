package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@TableName("newsinfo")
@Data
public class NewsInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String newsTitle;

    private String newsDescription;

    private Date creatTime;

}

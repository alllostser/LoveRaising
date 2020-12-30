package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
public class UserInfo implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    private String realName;

    private String sex;

    private String email;

    private String telephone;

    private String birthday;

    private Integer roleId;

    private String idNumber;

    private Integer status;

    private LocalDateTime creatTime;

    private double remainingSum;


}

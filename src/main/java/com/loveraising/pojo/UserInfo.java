package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("userinfo")
public class UserInfo {
    private int id;

    private String userName;

    private String password;

    private String realName;

    private String sex;

    private String email;

    private String telephone;

    private String birthday;

    private String idNumber;

    private int status;

    public UserInfo() {
    }

    public UserInfo(int id, String userName, String password, String realName, String sex, String email, String telephone, String birthday, String idNumber, int status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.email = email;
        this.telephone = telephone;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", status=" + status +
                '}';
    }
}

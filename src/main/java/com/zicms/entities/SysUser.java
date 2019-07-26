package com.zicms.entities;

import com.zicms.common.base.BaseEntity;
import com.zicms.common.constant.Constant;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 
 * @author
 */

@SuppressWarnings({ "unused" })
@Table(name = "sys_user")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long companyId; // company_id <归属公司>

    private String email; // email <邮箱>

    private String mobile; // mobile <手机>

    private String name; // name <姓名>

    private String no; // no <工号>

    private Long officeId; // office_id <归属部门>

    private String password; // password <密码>

    private String phone; // phone <电话>

    private String remarks; // remarks <备注信息>

    private String username; // username <登录名>

    private String userType; // user_type <用户类型>

    private String updateBy; // update_by <更新者>

    private Date updateDate; // update_date <更新时间>

    private String createBy; // create_by <创建者>

    private Date createDate; // create_date <创建时间>

    private String delFlag; // del_flag <删除标记(0.正常 1.删除)>

    private Integer status;

    private Date loginDate; // login_date <最后登陆时间,针对管理员来说>

    private String loginIp; // login_ip <最后登陆IP,针对管理员来说>

    private Date lastLoginDate;// <最后登陆时间,针对用户来说>

    private String lastLoginIp;// <最后登陆IP,针对用户来说>

    private String lastLoginErrorMsg;// 最后一次登录错误原因

    private Integer errorCount;// 错误次数，登录成功后，清为0

    private Date nextLoginDate;// 下一次可以登录时间，锁定时清空

    private Date nextModPwdDate;// 下一次修改密码时间，强制修改密码

    private String userSource; // user_source <用户来源(1教师，2学生)>

    private String province;// 省份

    public String getProvince() {
        return this.getString("province");
    }

    public void setProvince(String province) {
        this.set("province", province);
    }

    @Transient
    private Long[] roleIds; // 角色

    public SysUser() {
    }

    public SysUser(Long companyId, String email, String mobile, String name, String no, Long officeId, String password, String phone, String remarks, String username, String userType, Long[] roleIds,
                   String province) {
        super();
        this.companyId = companyId;
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.no = no;
        this.officeId = officeId;
        this.password = password;
        this.phone = phone;
        this.remarks = remarks;
        this.username = username;
        this.userType = userType;
        this.roleIds = roleIds;
        this.province = province;
    }

    public void setRoleIds(Long[] roleIds) {
        this.set("roleIds", roleIds);
    }

    public Long[] getRoleIds() {
        return (Long[]) this.get("roleIds");
    }

    public Long getCompanyId() {
        return this.getLong("companyId");
    }

    public void setCompanyId(Long companyId) {
        this.set("companyId", companyId);
    }

    public String getEmail() {
        return this.getString("email");
    }

    public void setEmail(String email) {
        this.set("email", email);
    }

    public Date getLoginDate() {
        return this.getDate("loginDate");
    }

    public void setLoginDate(Date loginDate) {
        this.set("loginDate", loginDate);
    }

    public String getLoginIp() {
        return this.getString("loginIp");
    }

    public void setLoginIp(String loginIp) {
        this.set("loginIp", loginIp);
    }

    public String getMobile() {
        return this.getString("mobile");
    }

    public void setMobile(String mobile) {
        this.set("mobile", mobile);
    }

    public String getName() {
        return this.getString("name");
    }

    public void setName(String name) {
        this.set("name", name);
    }

    public String getNo() {
        return this.getString("no");
    }

    public void setNo(String no) {
        this.set("no", no);
    }

    public Long getOfficeId() {
        return this.getLong("officeId");
    }

    public void setOfficeId(Long officeId) {
        this.set("officeId", officeId);
    }

    public String getPassword() {
        return this.getString("password");
    }

    public void setPassword(String password) {
        this.set("password", password);
    }

    public String getPhone() {
        return this.getString("phone");
    }

    public void setPhone(String phone) {
        this.set("phone", phone);
    }

    public String getRemarks() {
        return this.getString("remarks");
    }

    public void setRemarks(String remarks) {
        this.set("remarks", remarks);
    }

    public String getUsername() {
        return this.getString("username");
    }

    public void setUsername(String username) {
        this.set("username", username);
    }

    public String getUserType() {
        return this.getString("userType");
    }

    public void setUserType(String userType) {
        this.set("userType", userType);
    }

    public String getCreateBy() {
        return this.getString("createBy");
    }

    public void setCreateBy(String createBy) {
        this.set("createBy", createBy);
    }

    public Date getCreateDate() {
        return this.getDate("createDate");
    }

    public void setCreateDate(Date createDate) {
        this.set("createDate", createDate);
    }

    public String getUpdateBy() {
        return this.getString("updateBy");
    }

    public void setUpdateBy(String updateBy) {
        this.set("updateBy", updateBy);
    }

    public Date getUpdateDate() {
        return this.getDate("updateDate");
    }

    public void setUpdateDate(Date updateDate) {
        this.set("updateDate", updateDate);
    }

    public String getDelFlag() {
        return this.getString("delFlag");
    }

    public void setDelFlag(String delFlag) {
        this.set("delFlag", delFlag);
    }

    // 是否是超级管理员
    public boolean isAdmin() {
        return Constant.SUPER_ADMIN.equals(this.getUserType()) ? true : false;
    }

    public Date getLastLoginDate() {
        return getDate("lastLoginDate");
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.set("lastLoginDate", lastLoginDate);
    }

    public String getLastLoginIp() {
        return getString("lastLoginIp");
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.set("lastLoginIp", lastLoginIp);
    }

    public String getLastLoginErrorMsg() {
        return getString("lastLoginErrorMsg");
    }

    public void setLastLoginErrorMsg(String lastLoginErrorMsg) {
        this.set("lastLoginErrorMsg", lastLoginErrorMsg);
    }

    public Integer getErrorCount() {
        return this.getInteger("errorCount");
    }

    public void setErrorCount(Integer errorCount) {
        this.set("errorCount", errorCount);
    }

    public Date getNextLoginDate() {
        return this.getDate("nextLoginDate");
    }

    public void setNextLoginDate(Date nextLoginDate) {
        this.set("nextLoginDate", nextLoginDate);
    }

    public Date getNextModPwdDate() {
        return this.getDate("nextModPwdDate");
    }

    public void setNextModPwdDate(Date nextModPwdDate) {
        this.set("nextModPwdDate", nextModPwdDate);
    }

    public Integer getStatus() {
        return this.getInteger("status");
    }

    public void setStatus(Integer status) {
        this.set("status", status);
    }

    public String getUserSource() {
        return this.getString("userSource");
    }

    public void setUserSource(String userSource) {
        this.set("userSource", userSource);
    }

}

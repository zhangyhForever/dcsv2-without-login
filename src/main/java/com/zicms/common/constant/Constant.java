package com.zicms.common.constant;

import com.google.common.collect.Lists;

import java.util.List;

public class Constant {

	// 域名拨测是否跳转（3：有跳转  4：无跳转    9:未知）是否违规（0:默认值    7：正常    8：违规）
	public static final String REDIRECTED_YES = "3";
	public static final String REDIRECTED_NO = "4";
	public static final String REDIRECTED_UNKNOWN = "9";
	public static final String REDIRECTED_YES_DISABLE = "39";
	public static final String REDIRECTED_NO_DISABLE = "49";
	public static final String DANGEROUS_YES = "8";
	public static final String DANGEROUS_NO = "7";
	public static final String DANGEROUS_DEFAULT = "0";
	public static final String DANGEROUS_UNCONFIRM = "78";
	public static final String DANGEROUS_DISABLE = "99";


	//审核结果  （0：待审     1：不良      2：正常       3：不确定    101:正在复审    10000：未导出       10001：已导出）
	public static final String STATUS_WAIT = "0";
	public static final String STATUS_BAD = "1";
	public static final String STATUS_NORMAL = "2";
	public static final String STATUS_UNCONFIRM = "3";
	public static final String STATUS_CHECKING = "101";
	public static final String EXPORT_YES = "10000";
	public static final String EXPORT_NO = "10001";

	//任务id  目前只有一个任务，所以写死
	public static final Long TASK_ID = 3L;

	// 删除标记（0：正常；1：删除；2：审核；）
	public static final String FIELD_DEL_FLAG = "delFlag";
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";
		
	public static final Integer USER_STATUS_NORMAL = 1; //正常
	public static final Integer USER_STATUS_STOP = 2;//禁用
	public static final Integer USER_STATUS_LOCK = 3;//锁定
	
	//域名，ip来源type（1 图 文    2 钓鱼）
	public static final Integer TYPE_BULIANG = 1;
	public static final Integer TYPE_DIAOYU = 2;
	
	//图片实体文件相对路径起始文件夹
	public static final String IMAGE_PATH="imageFile";
	
	//截图脚本是否运行 0：未运行     1：正在运行   2：完成
	public static final String SCREEN_NOTRUN = "0";
	public static final String SCREEN_RUNING = "1";
	public static final String SCREEN_RUNED = "2";
	
	// 资源
	public static final String RESOURCE_STATUS_NORMAL = "0"; // 正常
	public static final String RESOURCE_STATUS_DISABLE = "1"; // 禁用
	public static final String RESOURCE_TYPE_MENU = "0"; // 菜单类型
	public static final String RESOURCE_TYPE_BUTTON = "1"; // 按钮类型
	public static final String RESOURCE_COMMON = "1"; // 公共资源

	// 用户
	public static final String SESSION_LOGIN_USER = "loginUser"; // session中的用户key
	public static final String SUPER_ADMIN = "1"; // 超级管理员

	// 缓存key
	public static final String CACHE_SYS_RESOURCE = "sysResource_cache"; // 资源的缓存名称
	public static final String CACHE_SYS_OFFICE = "sysOffice_cache"; //机构的缓存名称
	public static final String CACHE_SYS_ROLE = "sysRole_cache"; //角色的缓存名称
	public static final String CACHE_SYS_USER = "sysUser_cache"; //用户缓存名称
	
	public static final String CACHE_ALL_RESOURCE = "allSysResource"; // 全部资源key
	public static final String CACHE_USER_RESOURCE = "userSysResource"; // 用户权限
	public static final String CACHE_USER_MENU = "userMenuTree"; // 用户菜单树
	public static final String CACHE_USER_ROLE = "userRole"; // 用户角色
	public static final String CACHE_USER_DATASCOPE = "userDataScope"; //用户数据范围
	public static final String CACHE_USER_OFFICE = "userOffice"; //用户机构

	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
	public static final String DATA_SCOPE_OFFICE = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";
	public static final List<String> DATA_SCOPE_ADMIN = Lists.newArrayList("1","2","3","4","5","8","9");
	

	// 显示/隐藏
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	// 是/否
	public static final String YES = "1";
	public static final String NO = "0";
	
	//update or add or delete
	public static final Integer SUCCESS = 1;
	
	public static final String MSG = "msg";
	
	// 启用/禁用
	public static final Integer SYSTEM_COMMON_ENABLE = 1;
	public static final Integer SYSTEM_COMMON_DISABLE = 0;
	
	
	//课程类型
	public static final Integer COURSE_PUBLIC = 0;//公共课
	public static final Integer COURSE_MAJOR = 1;//专业课
	
	
	// 用户来源
	public static final String SYSTEM_USER_SOURCE_BY_TEACHER = "1"; //教师
	public static final String SYSTEM_USER_SOURCE_BY_STUDENT = "2"; //学生
	public static final String SYSTEM_USER_SOURCE_BY_UNTEACHER_OR_UNSTUDENT = "3"; //非教师和学生


	// 入学年
	public static int BEFORE_YEAR = 5; //提前年数
	public static int AFTER_YEAR = 0;  //推后年数
	
	// 学生
	public static final Integer STUDENT_NOMARL = 1; //正常
	public static final Integer STUDENT_EXIT = 2; //退学
	public static final Integer STUDENT_TRANSFER = 3; //转学
	public static final Integer STUDENT_SUSEND = 4; //休学
	public static final Integer STUDENT_DISCHARGE = 5; //开除
	public static final Integer STUDENT_GRADUATED = 0; //已毕业
	
	//教师
	public static final Integer TEACHER_EXISTS = 1; //在职
	public static final Integer TEACHER_NOT_EXISTS = 0; //不在职
	
	/**
	 * 数据库表默认的5个字段
	 */
	public static final List<String> DEFAULT_PROP = Lists.newArrayList("createDate","createBy",
			"updateDate","updateBy","delFlag");
	
	public static final Integer COMMON_FILE = 1;
	public static final Integer ATTACH_FILE = 2;
}

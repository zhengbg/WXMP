/**
 * 文 件 名:  UserDO
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2018/2/6
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.wx.jzh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author huangsongbo
 * @version 2018/2/6
 * @se [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@ToString
public class UserDO implements Serializable
{
	private Integer userID;
	/**
	 * 11位手机号码
	 */
	private String account;

	/**
	 * 32位MD5加密串
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private String createTime;
}

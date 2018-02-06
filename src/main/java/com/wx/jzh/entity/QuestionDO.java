/**
 * 文 件 名:  QuestionDO
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
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@ToString
public class QuestionDO implements Serializable
{
	/**
	 * 问题主键ID，mysql主键自增长
	 */
	private Integer questionID;
	/**
	 * 问题内容，长度不超过256个字符
	 */
	private String content;
	/**
	 * 问题类型，1：单选 2：多选
	 */
	private Integer type;
	/**
	 * 选项。总共有四个选项，以 key=value，切分号隔开存进数据库。
	 * 如A=选项一；B=选项二；C=选项三；D=选项四
	 */
	private String item;
	/**
	 * 问题答案
	 */
	private String answer;

	/**
	 * 保留字段，后台配置问题显示的排序
	 */
	private Integer sort;

	/**
	 * 创建时间
	 */
	private String createTime;
}

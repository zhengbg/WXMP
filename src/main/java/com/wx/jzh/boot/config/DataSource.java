/**
 * 文 件 名:  DataSource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/27
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.wx.jzh.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zhengbinggui
 * @version 2017/10/27
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSource
{
	private String url;

	private String username;

	private String password;

	private String driverClassName;

	@Bean
	public DruidDataSource getDruidDataSource ()
	{
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl (url);
		druidDataSource.setUsername (username);
		druidDataSource.setPassword (password);
		druidDataSource.setDriverClassName (driverClassName);
		return druidDataSource;
	}

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("DataSource{");
		sb.append ("url='").append (url).append ('\'');
		sb.append (", username='").append (username).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", driverClassName='").append (driverClassName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
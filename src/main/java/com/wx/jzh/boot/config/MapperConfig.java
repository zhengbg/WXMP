/**
 * 文 件 名:  MapperConfig
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/27
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.wx.jzh.boot.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
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
@Configuration
public class MapperConfig
{
	private static final String BASE_PACK = "com.wx.jzh.dao";

	//它 将 会 查 找 类 路 径 下 的 映 射 器 并 自 动 将 它 们 创 建 成 MapperFactoryBean。
	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer ()
	{
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName ("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage (BASE_PACK);
		return mapperScannerConfigurer;
	}
}
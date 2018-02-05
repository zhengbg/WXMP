/**
 * 文 件 名:  InitConfig
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
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zhengbinggui
 * @version 2017/10/27
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class InitConfig
{
	private static final Logger LOGGER = LoggerFactory.getLogger (InitConfig.class);

	//实体类路径
	private static final String ENTITY_PACKAGE_PATH = "com.wx.jzh.entity";

	//mybatis配置文件路径
	private static final String MYBATIS_PATH = "classpath:/mybatis-config.xml";

	//mybatis映射文件路径
	private static final String MAPPER_PATH = "classpath:/mapper/*.xml";

	@Autowired
	private DruidDataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactory ()
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource (dataSource);
		//使用别名
		sqlSessionFactoryBean.setTypeAliasesPackage (ENTITY_PACKAGE_PATH);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		try
		{
			//加载mybatis配置文件
			sqlSessionFactoryBean.setConfigLocation (resolver.getResource (MYBATIS_PATH));
			sqlSessionFactoryBean.setMapperLocations (resolver.getResources (MAPPER_PATH));
			return sqlSessionFactoryBean.getObject ();
		}
		catch (Exception e)
		{
			LOGGER.error ("init database error.", e);
			return null;
			//throw new DeviceException ("999999", "init database failed.");
		}
	}

	/**
	 * SqlSessionTemplate 是 MyBatis-Spring 的核心。 这个类负责管理 MyBatis 的 SqlSession, 调用 MyBatis 的 SQL 方法, 翻译异常。 SqlSessionTemplate 是线程安全的, 可以被多个 DAO 所共享使用。
	 * 当调用 SQL 方法时, 包含从映射器 getMapper()方法返回的方法, SqlSessionTemplate 将会保证使用的 SqlSession 是和当前 Spring 的事务相关的。此外,它管理 session 的生命 周期,包含必要的关闭,提交或回滚操作。
	 * SqlSessionTemplate 实现了 SqlSession 接口,这就是说,在代码中无需对 MyBatis 的 SqlSession 进行替换。 SqlSessionTemplate 通常是被用来替代默认的 MyBatis 实现的 DefaultSqlSession , 因为模板可以参与到 Spring 的事务中并且被多个注入的映射器类所使 用时也是线程安全的。相同应用程序中两个类之间的转换可能会引起数据一致性的问题。
	 */
	@Bean
	public SqlSessionTemplate getSqlSessionTemplate (SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
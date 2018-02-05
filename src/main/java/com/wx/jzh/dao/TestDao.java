package com.wx.jzh.dao;

import com.wx.jzh.entity.TestDO;

import java.util.List;

/**
 * 测试Dao层
 *
 * @author zhengbinggui
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface TestDao {
    /**
     * 查询
     *
     * @return
     */
    List<TestDO> query ();
}

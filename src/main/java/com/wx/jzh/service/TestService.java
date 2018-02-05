package com.wx.jzh.service;

import com.wx.jzh.entity.TestDO;

import java.util.List;

/**
 * 测试Service层
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface TestService {
    List<TestDO> query();
}

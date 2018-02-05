package com.wx.jzh.service.impl;

import com.wx.jzh.dao.TestDao;
import com.wx.jzh.entity.TestDO;
import com.wx.jzh.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试service实现层
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service("testService")
public class TestServiceImpl implements TestService{

    private static final Logger LOGGER = LoggerFactory.getLogger (TestServiceImpl.class);
    @Autowired
    private TestDao testDao;

    @Override
    public List<TestDO> query() {
        try {
            List<TestDO> testDOS = testDao.query();
            return testDOS;
        }
        catch (Exception e){

        }
        return null;
    }
}

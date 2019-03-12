package org.wsk.autoTestMock.testcase;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.wsk.autoTestMock.common.MybatisUtil;
import org.wsk.autoTestMock.dao.UTestMapper;
import org.wsk.autoTestMock.entity.UTest;

public class MybatisTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SqlSession session = MybatisUtil.getSession();
		UTestMapper mapper = session.getMapper(UTestMapper.class);
		UTest uTest = mapper.selectOneUser(1);
		System.out.println(uTest);
	}

}

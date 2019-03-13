package org.wsk.autoTestMock.testcase;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import org.wsk.autoTestMock.common.MybatisUtil;
import org.wsk.autoTestMock.dao.UTestMapper;
import org.wsk.autoTestMock.entity.UTest;

public class MybatisTest {


	@Test
	public void test() {
		SqlSession session = MybatisUtil.getSession();
		UTestMapper mapper = session.getMapper(UTestMapper.class);
		UTest uTest = mapper.selectOneUser(1);
		System.out.println(uTest);
	}

}

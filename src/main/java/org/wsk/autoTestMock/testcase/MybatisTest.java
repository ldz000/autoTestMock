package org.wsk.autoTestMock.testcase;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.wsk.autoTestMock.common.MybatisUtil;
import org.wsk.autoTestMock.dao.UserMapper;
import org.wsk.autoTestMock.entity.Users;

public class MybatisTest {
	@Test
	public void test1(){
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		Users user = mapper.selectUser(1);
		System.out.println(user);
	}
}

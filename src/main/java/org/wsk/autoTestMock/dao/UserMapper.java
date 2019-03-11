package org.wsk.autoTestMock.dao;

import org.wsk.autoTestMock.entity.Users;

public interface UserMapper {
	Users selectUser(int id);
}

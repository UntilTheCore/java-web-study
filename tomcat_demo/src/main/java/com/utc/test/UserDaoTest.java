package com.utc.test;

import com.utc.dao.UserDao;
import com.utc.domain.User;
import org.junit.Test;

public class UserDaoTest {

  @Test
  public void testLogin() {
    User loginUser = new User();
    loginUser.setUsername("zhangsan");
    loginUser.setPassword("456");
    UserDao dao = new UserDao();
    User login = dao.login(loginUser);
    System.out.println(login);
  }
}

package com.utc.service.impl;

import com.utc.dao.UserDao;
import com.utc.dao.impl.UserDaoImpl;
import com.utc.domain.User;
import com.utc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
  private UserDao dao = new UserDaoImpl();

  @Override
  public User login(User user) {
    // 操作 dao 完成登录用户的查询操作
    return dao.findUserByUsernameAndPassword(user);
  }

  @Override
  public List<User> findAll() {
    // 操作 dao 完成用户查询操作
    return dao.findAll();
  }

  @Override
  public int addUser(User user) {
    // 操作 dao 完成添加用户
    return dao.addUser(user);
  }

  @Override
  public int deleteUser(String id) {
    return dao.deleteUser(id);
  }
}

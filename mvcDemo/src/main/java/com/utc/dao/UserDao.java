package com.utc.dao;

import com.utc.domain.User;

import java.util.List;

public interface UserDao {
  public User findUserByUsernameAndPassword(User user);

  /**
   * 从数据库中查询所有用户信息
   *
   * @return 返回查询到的用户数据，没有数据则返回 null
   */
  public List<User> findAll();

  public int addUser(User user);
}

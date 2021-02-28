package com.utc.service;

import com.utc.domain.User;

import java.util.List;

public interface UserService {
  public User login(User user);

  /**
   * 查询所有用户信息
   *
   * @return 返回用户的信息的列表
   */
  public List<User> findAll();

  /**
   * 添加一个用户
   *
   * @return
   */
  public int addUser(User user);

  public int deleteUser(String id);

  public User findUser(String id);

  public int updateUser(User user);
}

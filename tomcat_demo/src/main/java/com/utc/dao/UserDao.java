package com.utc.dao;

import com.utc.domain.User;
import com.utc.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 所有用户相关数据库操作的类
 */
public class UserDao {
  // 声明 JDBCTemplate 对象共用
  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  /**
   * 用户登录
   *
   * @param loginUser 只有用户名和密码信息
   * @return 登录用户的所有信息
   */
  public User login(User loginUser) {
    try {
      String sql = "SELECT * FROM users WHERE username = ? and password = ?;";
      return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
    } catch (DataAccessException e) {
      return null;
    }
  }
}

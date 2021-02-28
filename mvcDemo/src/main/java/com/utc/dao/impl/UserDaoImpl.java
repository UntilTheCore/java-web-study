package com.utc.dao.impl;

import com.utc.dao.UserDao;
import com.utc.domain.User;
import com.utc.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
  private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

  @Override
  public User findUserByUsernameAndPassword(User user) {
    try {
      String sql = "SELECT * FROM users WHERE username = ? and password = ?;";
      return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
    } catch (DataAccessException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public List<User> findAll() {
    // 通过 jdbc 查询内容
    String sql = "SELECT * FROM users;";
    List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    return users;
  }

  @Override
  public int addUser(User user) {
    String sql = "INSERT INTO users VALUES (null,?,?,?,?,?,?,null,null);";
    return jdbcTemplate.update(sql,
      user.getName(),
      user.getGender(),
      user.getAge(),
      user.getQq(),
      user.getAddress(),
      user.getEmail()
    );
  }

  @Override
  public int deleteUser(String id) {
    String sql = "DELETE FROM users WHERE id = ?;";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public User findUser(String id) {
    try {
      String sql = "SELECT * FROM users WHERE id = ?;";
      return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    } catch (DataAccessException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public int updateUser(User user) {
    String sql = "UPDATE users set gender=?,age=?,address=?,email=? WHERE id=?;";
    return jdbcTemplate.update(sql, user.getGender(), user.getAge(), user.getAddress(), user.getEmail(), user.getId());
  }
}

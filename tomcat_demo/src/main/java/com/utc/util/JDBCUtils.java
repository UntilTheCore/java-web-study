package com.utc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类 使用 druid 连接池
 */
public class JDBCUtils {
  private static DataSource ds;

  static {
    try {
      // 加载配置文件
      Properties ps = new Properties();
      InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
      ps.load(is);

      ds = DruidDataSourceFactory.createDataSource(ps);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 获取连接池对象
  public static DataSource getDataSource() {
    return ds;
  }

  // 获取连接（connection) 对象
  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }
}

package com.utc.web;

import com.utc.dao.UserDao;
import com.utc.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
/*
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    User loginUser = new User();
    loginUser.setUsername(username);
    loginUser.setPassword(password);
*/
    // 使用 beanUtils 简化用户数据的设置
    Map<String, String[]> parameterMap = req.getParameterMap();
    User loginUser = new User();
    try {
      BeanUtils.populate(loginUser, parameterMap);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }

    UserDao dao = new UserDao();
    User user = dao.login(loginUser);
    if (user == null) {
      // 登录失败
      req.getRequestDispatcher("/failServlet").forward(req, resp);
    } else {
      // 登录成功
      req.setAttribute("user", user);
      req.getRequestDispatcher("/successServlet").forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}

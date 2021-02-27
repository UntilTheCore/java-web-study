package com.utc.web.servlet;

import com.utc.domain.User;
import com.utc.service.UserService;
import com.utc.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

@WebServlet("/userAddServlet")
public class UserAddServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    // 获取表单数据
    Map<String, String[]> parameterMap = request.getParameterMap();
    User user = new User();
    try {
      BeanUtils.populate(user, parameterMap);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }

    UserService us = new UserServiceImpl();
    if (us.addUser(user) > 0) {
      // 添加成功
      System.out.println("add seccess!");
    } else {
      // 添加失败
      System.out.println("add faild!");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}

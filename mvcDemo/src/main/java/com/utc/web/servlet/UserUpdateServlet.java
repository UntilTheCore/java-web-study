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
import java.util.Map;

@WebServlet(name = "UserUpdateServlet", value = "/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置编码格式
    request.setCharacterEncoding("utf-8");
    // 获取用户数据
    Map<String, String[]> map = request.getParameterMap();
    User user = new User();
    try {
      BeanUtils.populate(user, map);
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }

    // 更新用户信息
    UserService userService = new UserServiceImpl();
    if (userService.updateUser(user) > 0) {
      // 更新成功
      request.getRequestDispatcher(this.getServletContext().getContextPath() + "/userListServlet").forward(request, response);
    } else {
      // 更新失败
      request.getSession().setAttribute("msg_error", "更新失败!");
      request.getRequestDispatcher(this.getServletContext().getContextPath() + "/userListServlet").forward(request, response);
    }

  }
}

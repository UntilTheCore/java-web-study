package com.utc.web.servlet;

import com.utc.domain.User;
import com.utc.service.UserService;
import com.utc.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1. 调用 DaoServiceImpl 完成查询
    UserServiceImpl userService = new UserServiceImpl();
    List<User> userList = userService.findAll();
    System.out.println(userList);
    // 2. 将查询到的数据存到作用域内
    request.setAttribute("users", userList);
    // 3. 将请求转发
    request.getRequestDispatcher("/list.jsp").forward(request, response);
  }
}

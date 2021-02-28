package com.utc.web.servlet;

import com.utc.domain.User;
import com.utc.service.UserService;
import com.utc.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserFindServlet", value = "/userFindServlet")
public class UserFindServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置页面编码
    request.setCharacterEncoding("utf-8");
    // 获取用户 id
    String id = request.getParameter("id");
    // 查询用户信息
    UserService userService = new UserServiceImpl();
    User user = userService.findUser(id);
    if (user != null) {
      request.setAttribute("user", user);
      request.getRequestDispatcher(this.getServletContext().getContextPath() + "/update.jsp").forward(request, response);
    } else {
      request.getSession().setAttribute("msg_error", "用户查询失败!用户可能已被删除!");
      response.sendRedirect(this.getServletContext().getContextPath() + "/list.jsp");
    }
  }
}

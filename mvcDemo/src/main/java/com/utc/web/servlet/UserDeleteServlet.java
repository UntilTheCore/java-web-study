package com.utc.web.servlet;

import com.utc.service.UserService;
import com.utc.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", value = "/userDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    UserService us = new UserServiceImpl();
    if (us.deleteUser(id) > 1) {
      // 删除成功!
      response.sendRedirect(this.getServletContext().getContextPath() + "/userListServlet");
    } else {
      // 删除失败!
      request.getSession().setAttribute("msg_error", "删除失败!");
      response.sendRedirect(this.getServletContext().getContextPath() + "/userListServlet");
    }
  }
}

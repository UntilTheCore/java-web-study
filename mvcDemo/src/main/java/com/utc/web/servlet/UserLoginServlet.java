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

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 设置编码
    request.setCharacterEncoding("utf-8");
    // 判断用户验证码是否正确
    String verifycode = request.getParameter("verifycode");
    HttpSession session = request.getSession();
    String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

    if (!checkcode_server.equalsIgnoreCase(verifycode)) {
      // 验证码错误
      this.responseInfo("验证码错误!", "/login.jsp", request, response);
    } else {
      // 验证码正确，判断用户是否存在且正确
      Map<String, String[]> parameterMap = request.getParameterMap();
      User user = new User();
      try {
        BeanUtils.populate(user, parameterMap);
      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
      session.removeAttribute("CHECKCODE_SERVER");
      // 调用 Service 进行用户校验
      UserService us = new UserServiceImpl();
      User loginUser = us.login(user);
      if (loginUser != null) {
        // 登录成功
        session.setAttribute("user", loginUser);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
      } else {
        // 登录失败
        this.responseInfo("登录失败,用户名或密码错误!", "/login.jsp", request, response);
      }
    }
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

  private void responseInfo(String msg, String dispatcher, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("login_msg", msg);
    request.getRequestDispatcher(dispatcher).forward(request, response);
  }
}

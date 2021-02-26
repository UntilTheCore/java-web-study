package com.utc.download;

import com.utc.utils.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 获取请求参数
    String filename = request.getParameter("filename");
    // 使用字节流将文件加载进入内存
    ServletContext servletContext = this.getServletContext();

    // 获取文件路径
    String realPath = servletContext.getRealPath("/img/" + filename);
    System.out.println(realPath);

    // 解决中文文件名的问题
    // 1. 获取 user-agent 请求头
    String header = request.getHeader("user-agent");
    filename = DownLoadUtils.getFileName(header, filename);

    // 获取文件 Mime 信息
    String mimeType = servletContext.getMimeType(filename);
    // 设置响应头信息
    response.setHeader("content-type", mimeType);
    // 设置文件打开方式
    response.setHeader("content-disposition", "attachment;filename=" + filename);

    // 获取文件输入流
    FileInputStream fileInputStream = new FileInputStream(new File(realPath));
    ServletOutputStream outputStream = response.getOutputStream();
    // 获取文件输出流
    byte[] bytes = new byte[1024 * 8];
    int len = 0;
    while ((len = fileInputStream.read(bytes)) != -1) {
      outputStream.write(bytes, 0, len);
    }

  }
}

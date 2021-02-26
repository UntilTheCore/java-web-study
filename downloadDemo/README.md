# 文件下载

步骤：
  1. 获取请求参数信息;
  2. 通过请求的参数信息从服务器获取文件字节流数据并加载入内存中;
  3. 设置响应头;
  4. 返回数据;

主要知识点:
  1. 如何获取 servlet 上下文信息;
  2. servletContext 获取的路径情况;(在idea下，会自动将src/webapp内的内容拷贝到服务器运行的根目录下。webapp内是什么样的路径，那么服务器的访问路径一样)
  3. 设置响应头信息：
      - 设置文件Mime信息（content-type）；
      - 设置文件打开方式（"content-disposition=attachment;filename=xxx"
       
  4. 本地文件读取;
  5. 响应流的输出;(response.getOutputStream())
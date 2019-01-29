<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>${title}</title>
  </head>
  <body>

  <form action="/check" method="post">
      <input type="text" name="login" placeholder="login" style="display: block">
      <input type="password" name="pass" placeholder="password" style="display:block;">
      <input type="submit" name="submit">
  </form>

  </body>
</html>
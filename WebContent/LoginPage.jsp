 	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
h1{
	font-family: "微軟正黑體","blod";
	color:#3C3C3C;
}

.login-page {
  width: 450px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
#ip1 {
  text-align: center;
  font-family: "微軟正黑體";
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
body {
  background: #A3D1D1;
  font-family: "微軟正黑體";   
}

#bot{
	background: #3C3C3C;
	color:white;
	text-align: center;
  	font-family: "微軟正黑體";
  	outline: 0;
    width: 45%;
  	border: 0;
  	margin: 0 0 15px;
  	padding: 15px;
  	box-sizing: border-box;
  	font-size: 14px;
}

span{
	color:red;
	height:30px;
	margin:15px;
}

</style>
</head>
<body>
<div class="login-page">
  <div class="form">
  <h1 >會員登入</h1>
    <form action="memberLogin.do"  method="post">
      <input id="ip1" type="text" name="userAcc" placeholder="ACCOUNT"/>
      <input id="ip1" type="password" name="userPwd" placeholder="PASSWORD"/>
	  <div class="info">
		<p><span>${p}</span></p>
	  </div>
      <input id="bot" type="submit" value="Submit"/>
      <input id="bot" type="reset" value="Reset"/>
      <p>Not registered? <a href="RegisterPage.jsp">Create an account!</a></p>
    </form>
  </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#title {
	font-family: "微軟正黑體", "blod";
	color: #3C3C3C;
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
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.ip1 {
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

.bot {
	background: #3C3C3C;
	color: white;
	text-align: center;
	font-family: "微軟正黑體";
	width: 45%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

span {
	color: red;
	height: 30px;
	margin: 15px;
}

.sel_wrap {
	background: #f2f2f2;
}

.sel_wrap label {
	padding-left: 10px;
	font-size: 14px;
	z-index: 2;
	color: #6C6C6C;
	line-height: 40px;
	height: 40px;
	display: block;
}

.sel_wrap .select {
	width: 100%;
	height: 40px;
	color: #6C6C6C;
	line-height: 40px;
	background: #f2f2f2;
	filter: alpha(opacity = 0);
	cursor: pointer;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<h1>會員註冊</h1>
			<br />
			<form action="MemberRegister.do" method="post">
				<input class="ip1" type="text" name="userAcc" placeholder="ACCOUNT" />
				<input class="ip1" type="password" name="userpwd" placeholder="PASSWORD" /> 
				<input class="ip1" type="text" name="userName" placeholder="NAME" /> 
				<input class="ip1" type="text" name="userphone" placeholder="PHONE" /> 
				<input class="ip1" type="text" name="usermail" placeholder="MAIL" />
				<div class="ip1">
					<input type="radio" name="usergender" value="Male">Male 
					<input type="radio" name="usergender" value="Female">Female
				</div>
				<input class="ip1" type="date" name="userbirth" placeholder="BIRTHDAY" />
				<div class="sel_wrap">
					<label>GAME PREFERENCE</label> <select class="select"
						name="gametype">
						<option value="PartyGames">PartyGames</option>
						<option value="StrategyGames">StrategyGames</option>
						<option value="ThemeticGames">ThemeticGames</option>
						<option value="WarGames">WarGames</option>
						<option value="AbstractGames">AbstractGames</option>
						<option value="CustomizableGames">CustomizableGames</option>
					</select>
				</div>
				<p>
					<span>${p}</span>
				</p>
				<input class="bot" type="submit" value="Submit" /> <input
					class="bot" type="reset" value="Reset" />
				<p>
					Already registered? <a href="LoginPage.jsp">Sign In!</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
    <title>Register Form</title>
    <link rel="stylesheet" type="text/css" href="RegisterPage.css" />
    <script>
      function queryAcc(){
          let Obj =document.getElementsByName("userAcc")[0];
          let VerifyObj = document.getElementById("checkAccount");

          var xhr = new XMLHttpRequest();
	      xhr.open("POST", "<c:url value='/CheckDuplicateAccountServlet' />", true);
		  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	      xhr.send("account=" + Obj.value);
		  var message = "";
		  xhr.onreadystatechange = function() {
				    // 伺服器請求完成
              if (xhr.readyState == 4 && xhr.status == 200) {
                  var result = JSON.parse(xhr.responseText);

		          if (result.memberAccountisDuplicate == "false") {
		              message = "帳號可用";
		          } else {
		              message = "帳號重複，請重新輸入帳號";
		          }
	              
	              VerifyObj.innerHTML = "<font color='red' size='-2'>" + message + "</font>";
	          }
		  }
      }

      function queryMail(){
    	  let Obj =document.getElementsByName("userMail")[0];
          let VerifyObj = document.getElementById("checkMail");

          var xhr = new XMLHttpRequest();
		  xhr.open("POST", "<c:url value='/CheckDuplicateMailServlet' />", true);
		  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		  xhr.send("mail=" + Obj.value);
	      var message = "";
		  xhr.onreadystatechange = function() {
				    // 伺服器請求完成
              if (xhr.readyState == 4 && xhr.status == 200) {
                  var result = JSON.parse(xhr.responseText);

		          if (result.memberAccountisDuplicate == "false") {
		              message = "信箱可用";
		          } else {
		              message = "信箱重複，請重新輸入信箱";
		          }
	              
	              VerifyObj.innerHTML = "<font color='red' size='-2'>" + message + "</font>";
	          }
		  }
      }




      function checkAcc(){
		        let Obj =document.getElementsByName("userAcc")[0];
		        let ObjVal = Obj.value.replace(/\s*/g, "");
		        let ObjValLen = ObjVal.length;
		        let VerifyObj = document.getElementById("checkAccount");
	
		        if (ObjVal == "") {
		          VerifyObj.innerHTML = "不能空白";
		        } else if (ObjValLen < 2 || ObjValLen>15) {
		          VerifyObj.innerHTML = "限制長度為6-15字";
		        } else {
		          if (/^[a-zA-z0-9]{2,15}$/.test(ObjVal)) {
		            VerifyObj.innerHTML = "格式正確";
		          } else {
		            VerifyObj.innerHTML = "必須全為字母數字";
		          }
		        }
            
		        if(VerifyObj.innerHTML=="格式正確"){
			        queryAcc();
			      }
		  }

      function checkPwd(){
		        let Obj =document.getElementsByName("userPwd")[0];
		        let ObjVal = Obj.value.replace(/\s*/g, "");
		        let ObjValLen = ObjVal.length;
		        let VerifyObj = document.getElementById("checkPassword");
	
		        if (ObjVal == "") {
		          VerifyObj.innerHTML = "不能空白";
		        } else if (ObjValLen < 6 || ObjValLen>15) {
		          VerifyObj.innerHTML = "限制長度為6-15字";
		        } else {
		          if (/^[a-zA-z0-9]{6,15}$/.test(ObjVal)) {
		            VerifyObj.innerHTML = "格式正確";
		          } else {
		            VerifyObj.innerHTML = "必須全為字母數字";
		          }
		        }
            checkPwd2();
            
		  }

      function checkPwd2(){
		        let Obj =document.getElementsByName("userPwd")[0];
		        let ObjVal = Obj.value.replace(/\s*/g, "");
            let Obj2 =document.getElementsByName("userPwd2")[0];
            let ObjVal2= Obj2.value.replace(/\s*/g, "");
            let VerifyObj = document.getElementById("checkPassword");
		        let VerifyObj2 = document.getElementById("checkPassword2");
            if(VerifyObj.innerHTML=="格式正確" && ObjVal==ObjVal2){
              VerifyObj2.innerHTML="v";
            }else{
              VerifyObj2.innerHTML="密碼不符";
            }

		  }

      function checkNickName(){
            let Obj =document.getElementsByName("userName")[0];
		        let ObjVal = Obj.value.replace(/\s*/g, "");
		        let ObjValLen = ObjVal.length;
		        let VerifyObj = document.getElementById("checkNickName");
	
		        if (ObjVal == "") {
		          VerifyObj.innerHTML = "不能空白";
		        } else if (ObjValLen < 2 || ObjValLen>15) {
		          VerifyObj.innerHTML = "限制長度為6-15字";
		        } else {
		          if (/^[a-zA-z0-9\u4E00-\u9FFF_!.]{2,15}$/.test(ObjVal)) {
		            VerifyObj.innerHTML = "格式正確";
		          } else {
		            VerifyObj.innerHTML = "必須全為字母數字中文_!.";
		          }
		        }
      }


    	
    </script>
  </head>

  <body>
    <form action="MemberRegister.do" method="POST">
      <table>
        <caption>
          	註冊頁面 *為必填項目 寬度叫邱奕豪調 格式像這樣 style="width:100px"
        </caption>
        <tr>
          <td>*</td>
          <td>Email :</td>
          <td><input type="email" name="userMail" required /></td>
          <td id="checkMail"></td>
        </tr>
        <tr>
          <td>*</td>
          <td></td>
          <td>
            <input type="submit" value="send" />
            <input type="text" name="verified" style="width: 95px" />
          </td>
          <td id="checkMailCode"></td>
        </tr>
        <tr>
          <td>*</td>
          <td>Account :</td>
          <td><input type="text" name="userAcc" onblur="checkAcc()" required /></td>
          <td id="checkAccount"></td>
        </tr>
        <tr>
          <td>*</td>
          <td>Password :</td>
          <td><input type="password" name="userPwd" style="width: 148px;" onblur="checkPwd()" required /></td>
          <td id="checkPassword"></td>
        </tr>
        <tr>
          <td>*</td>
          <td>ConfirmPwd :</td>
          <td><input type="password" name="userPwd2" style="width: 148px;" onblur="checkPwd2()" required /></td>
          <td id="checkPassword2"></td>
        </tr>
        <tr>
          <td>*</td>
          <td>NickName :</td>
          <td><input type="text" name="userName" onblur="checkNickName()"/></td>
          <td id="checkNickName"></td>
        </tr>

		<tr>
          <td></td>
          <td>Birthday :</td>
          <td><input type="text" name="userBirth" /></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td>Cellphone :</td>
          <td><input type="text" name="userPhone" /></td>
          <td></td>
        </tr>

        <tr>
          <td></td>
          <td>Gender :</td>
          <td style="text-align: left">
            <input type="radio" name="userGender" value="m" />Male
            <input type="radio" name="userGender" value="f" />Female
          </td>
          <td></td>
        </tr>

        <tr>
          <td></td>
          <td>Prefer :</td>
          <td>
            <select class="select" name="gameType" style="width: 175px">
              <option value="PartyGames">PartyGames</option>
              <option value="StrategyGames">StrategyGames</option>
              <option value="ThemeticGames">ThemeticGames</option>
              <option value="WarGames">WarGames</option>
              <option value="AbstractGames">AbstractGames</option>
              <option value="CustomizableGames">CustomizableGames</option>
            </select>
          </td>
          <td></td>
        </tr>
      </table>
      <input type="submit" value="Submit" />
      <p>
		Already registered? <a href="LoginPage.jsp">Sign In!</a>
	  </p>
    </form>
  </body>
</html>

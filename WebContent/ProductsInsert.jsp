<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${AppName}</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function setFocus(fld) {
     document.getElementById(fld).focus();
}
</script>

</head>
<div id='main'>
<form  id="form1" name="form1" method="post" 
       action="ProductsInsert.do"  enctype="multipart/form-data" >
  
<table  class="table_color" width="680" border="2" align="center" cellpadding="2" cellspacing="2" bordercolorlight="#FFFFFF" bordercolordark="#330033">
   <tr height='40'>
       <td colspan="4" align="center" valign="bottom"> 
           <TABLE width="680" BORDER='0'>
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
            <TR height='20' >
                <TD  align='center' >
                   <FONT color='black' size='+2' style="font-weight:900;" >
                      新增商品資料
                   </FONT>
                </TD>
            </TR>
            <TR height='5' >
                <TD align='center' >&nbsp;</TD>
            </TR>
         </TABLE>
           
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">名稱</td>
       <td colspan="3"> 
           <input name="name" class='InputClass' type="text" id="title" 
              value="${requestScope.title}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errTitle}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">庫存</td>
       <td colspan="3"> 
           <input name="stock" class='InputClass' type="text" id="title" 
              value="${requestScope.title}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errTitle}
           </font>
       </td>
    </tr>
   <tr height='36'>
       <td width="45" align="right" class="title_font">訂價</td>
       <td colspan="3"> 
           <input name="price" class='InputClass' type="text" id="title" 
              value="${requestScope.title}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errTitle}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">年齡</td>
       <td colspan="3"> 
           <input name="age" class='InputClass' type="text" id="title" 
              value="${requestScope.title}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errTitle}
           </font>
       </td>
    </tr>
        <tr height='36'>
       <td width="45" align="right" class="title_font">語言</td>
       <td colspan="3"> 
           <input name="lang" class='InputClass' type="text" id="title" 
              value="${requestScope.title}" size="50" />
           <font color='red' size='-1'>
              ${ErrMsg.errTitle}
           </font>
       </td>
    </tr>
    <tr height='36'>
       <td width="45" align="right" class="title_font">類型</td>
       <td colspan="3"> 
      <select class="select" name="gametype">
		<option value="5001">PartyGames</option>
		<option value="5002">StrategyGames</option>
		<option value="5003">ThemeticGames</option>
		<option value="5004">WarGames</option>
		<option value="5005">AbstractGames</option>
		<option value="5006">CustomizableGames</option>
		<option value="5007">ChildrenGames </option>
		<option value="5008">FamilyGames</option>
	</select>
           <font color='red' size='-1'>
              ${ErrMsg.errTitle}
           </font>
       </td>
    </tr>
    <tr height='36'>
        <td width="45" align="right" class="title_font">圖片</td>
        <td colspan="1">
            <input style="background:#FFFFFF" class='InputClass'  type="file" 
            name="uploadFile" size="40" /><br>
            <font color='red' size='-1'>${ErrMsg.errPicture}</font></td>
    </tr>
    
    <tr height="36" >
      <td height="61" colspan="6" align="center">
          
         <input type="submit" name="Submit" value="新增" />
         <p><span>${InsertMsg}</span></p>
      </td>
    </tr>
    
  </table>
</form>
</center>
</div>
<p>&nbsp;</p>
<c:remove var="ErrMsg" scope='session'/>
</body>
</html>
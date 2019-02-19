<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardEdit.jsp</title>
	<style type="text/css">
	   *{font-size: 20pt; font-weight: bold; }
	   a{text-decoration:none;font-size: 20pt; font-weight: bold; }
	   a:hover{text-decoration:underline;font-size: 26pt; font-weight: bold; color:blue; }
	</style>
	<script type="text/javascript">
	function chk(){
		var chkBoxVal ="<c:out value="${dto.hobby}"/>";			
		var chkBox= document.getElementsByName("hobby");
		var chkBoxLen = chkBox.length;
		if(chkBoxLen == null || isNaN(chkBoxLen)) return;
		var chkvals = chkBoxVal.split(',');		
		for(var i in chkvals){
			for(j=0;j<chkvals.length;j++)
			if(chkBox[i].val == chkvals[j]){
				console.log(chkBox[i]);
				console.log(chkvals[j]);
				chkBox[i].checked = true;
			}
		}
	}
	window.onload = chk;
	</script>
</head>
<body>
   <font color=blue>[boardEdit.jsp]</font> <p>
	
	<form action="edit.do" enctype="multipart/form-data" method="post">
	 <!-- hobby_idx는 꼭꼭꼭 hidden  -->
	 <input type="hidden" name="hobby_idx" value="${dto.hobby_idx}">
	 	<b>이름:</b> 
	 	  <input type=text name="name" value="${dto.name}"> <br>
	 	<b>제목:</b> 
	 	  <input type=text name="title" value="${dto.title}"> <br>
	 	<b>내용:</b><br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	 	 <textarea name="content" rows="4" cols="20">${dto.content}</textarea> <br>
	 	<b>성별:</b> 
	 	  <input type="radio" name="gender" value="man" >남자
	 	  <input type="radio" name="gender" value="woman" >여자
	 	  <b><font color=red>[수정전:${dto.gender}]</font></b>
	 	  <br>
	 	<b>취미:</b>
	 	  <input type="checkbox" name="hobby" value="game" >게임
	 	  <input type="checkbox" name="hobby" value="study" >공부
	 	  <input type="checkbox" name="hobby" value="ski" >스키
	 	  <input type="checkbox" name="hobby" value="movie" >영화
	 	  <b><font color=red>[수정전:${dto.hobby}]</font></b>
	 	  <br>
	 	<b>파일:</b>
	 	  <input type="file" name="upload_f">
	 	  <b><font color=red>[${dto.img_file_name}]파일</font></b>
	 	  <p>
	 	  
	 	  <input type="submit" value="spring데이타수정">&nbsp;&nbsp;
	 	  <input type="reset" value="입력취소">          
	 </form>
 </body>


<p>
<a href="index.jsp">[index.jsp]</a>
<a href="write.do">[신규등록]</a>
<a href="list.do">[전체출력]</a>

</body>
</html>














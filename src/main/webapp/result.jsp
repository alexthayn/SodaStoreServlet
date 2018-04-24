
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>Available Sodas</h1>
<%
List result= (List) request.getAttribute("brands");
if(result.isEmpty()){
	out.println("<br> No Results Were Found <br><br>");
}else{
	Iterator it = result.iterator();
	out.println("<br>We have <br><br>");
	while(it.hasNext()){
	out.println(it.next()+"<br>");
	}
}
%>
</body>
</html>


<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>Available Sodas</h1>
<%
List result= (List) request.getAttribute("searchresult");
	if(results != null){
		Iterator it = result.iterator();
		out.println("<br>We have <br><br>");
		while(it.hasNext()){
		out.println(it.next()+"<br>");
	}else
		out.println("There were no matching results!");
}
%>
</body>
</html>

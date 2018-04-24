
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>Select the brand of Soda</h1>
<form method="post" action="SelectSoda">
		<br>
		<select name="Type" size="1">
			<%
				List result= (List) request.getAttribute("index");
				Iterator it = result.iterator();
				while(it.hasNext()){
				out.println("<option>" +it.next()+"</option>");
			%>
		</select>
		<br><br>
		<input type="submit">
	</form>	
	
	<h1> Search for a drink </h1>
	<form method="post" action="SearchSoda">
		<div>
	    	<input type="search" name="Search" placeholder="Search the site...">
	    	<button type="submit">Search</button>
	  	</div>
	</form>
	</center>

</body>
</html>

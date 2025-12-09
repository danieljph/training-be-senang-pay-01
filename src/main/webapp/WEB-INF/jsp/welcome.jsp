<%
    var userName = request.getParameter("name");
    boolean isUserLoggedIn = (userName != null && !userName.trim().isEmpty());
%>
<h1>Welcome, <%= isUserLoggedIn ? userName : "Guest" %>!</h1>
<p>
    ${message}
</p>

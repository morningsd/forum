<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
<%@ page import="java.net.*" %>
<%
    String hostname, serverAddress;
    try {
        InetAddress inetAddress;
        inetAddress = InetAddress.getLocalHost();
        hostname = inetAddress.getHostName();
        serverAddress = inetAddress.toString();
    } catch (UnknownHostException e) {
        throw new RuntimeException(e);
    }
%>
<li>InetAddress: <%=serverAddress %>
<li>InetAddress.hostname: <%=hostname %>
</body>
</html>

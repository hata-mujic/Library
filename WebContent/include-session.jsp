
<%
	if (session.getAttribute("uname") == null) {
		response.sendRedirect("index.jsp");

	} else {
		String uname = String.valueOf(session.getAttribute("uname"));
		String admin = String.valueOf(session.getAttribute("admin"));

		session.setAttribute("uname", uname);
		session.setAttribute("admin", admin);
	}

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ConsultantForm</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
<form:form action="save" modelAttribute="consultant" method="post">

		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />

		<table>
			<tbody>
				<tr>
					<td><label>First name(*):</label></td>
					<td>
						<form:input path="firstName" />
						<form:errors path="firstName" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><label>Last name(*):</label></td>
					<td>
						<form:input path="lastName" />
						<form:errors path="lastName" cssClass="error"></form:errors>
					</td>
					
				</tr>
				
				<tr>
					<td><label>Email(*):</label></td>
					<td>
						<form:input path="email" />
						<form:errors path="email" cssClass="error"></form:errors>
					</td>
				</tr>
				
				<tr>
					<td><label>Address:</label></td>
					<td>
						<form:input path="address" />
						<form:errors path="address" cssClass="error"></form:errors>
					</td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>

</body>
</html>
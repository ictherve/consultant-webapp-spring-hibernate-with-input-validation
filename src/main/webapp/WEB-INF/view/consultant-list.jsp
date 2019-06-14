<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<h1>Welcome, this is your homepage</h1>
	<div>

		<input type="button" value="Add Customer"
			onclick="window.location.href='registerForm'; return false;"
			class="add-button" />

		<!--  add our html table here -->
		<c:if test="${consultants != null && consultants.size() != 0}">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>BirthDate</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="consultant" items="${consultants}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/consultant/updateForm">
						<c:param name="consultantId" value="${consultant.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/consultant/delete">
						<c:param name="consultantId" value="${consultant.id}" />
					</c:url>

					<tr>
						<td>${consultant.firstName}</td>
						<td>${consultant.lastName}</td>
						<td>${consultant.email}</td>
						<td>${consultant.address}</td>
						<td>${consultant.birthDate}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>
		</c:if>
	</div>

</body>
</html>
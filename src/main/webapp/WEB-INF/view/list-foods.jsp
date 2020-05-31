<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
<head><title>Calorie food</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Cooking Food</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
            <input type="button" value="Add Item"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button">
			<table>
				<tr>
					<th>Group</th>
					<th>Food</th>
					<th>kCal/100g</th>
                    <th>Action</th>
				</tr>
				<c:forEach var="tmpFood" items="${foods}">
                    <c:url var="updateLink" value="/food/showFormForUpdate">
                        <c:param name="foodId" value="${tmpFood.id}"/>
                    </c:url>
					<c:url var="deleteLink" value="/food/deleteFood">
						<c:param name="foodId" value="${tmpFood.id}"/>
					</c:url>
					<tr>
						<td>${tmpFood.type}</td>
						<td>${tmpFood.name}</td>
						<td>${tmpFood.kcalPerHundredGm}</td>
                        <td>
							<a href="${updateLink}">Update</a>|
							<a href="${deleteLink}"
							   onclick="if(!(confirm('Do you sure you want to delete this food?')))
							   return false;">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>
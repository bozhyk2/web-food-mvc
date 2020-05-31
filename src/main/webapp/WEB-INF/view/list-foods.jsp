<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
<head><title>Calorie food</title>
</head>
<body>
    <h2>Cooking Food</h2>
        <hr>
			<table border="1">
				<tr>
					<th >Group</th>
					<th >Food</th>
					<th>kCal/100g</th>
				</tr>
					<c:forEach var="tmpFood" items="${foods}">

						<tr>
							<td >${tmpFood.type}</td>
							<td >${tmpFood.name}</td>
							<td>${tmpFood.kcalPerHundredGm}</td>
						</tr>
					</c:forEach>
			</table>

</body>

</html>
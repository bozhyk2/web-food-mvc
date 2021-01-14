<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Save food</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-food-style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Cooking Food</h2>
    </div>
</div>
<div id="container">
    <h3>Save Food</h3>

    <form:form action="saveFood" modelAttribute="food" method="POST">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Type:</label></td>
                <td><select id="selectType">
                    <option id="selectTypeOption" value="">--- Select ---</option>

                    <c:if test="${food.id>0}">
                        <c:forEach var="tmpType" items="${foodTypes}">
                            <c:choose>
                                <c:when test="${tmpType == food.type}">
                                    <option value="${tmpType}" selected>${tmpType}</option>
                                </c:when>
                                <c:when test="${tmpType != food.type}">
                                    <option value="${tmpType}">${tmpType}</option>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </c:if>

                    <c:if test="${food.id==0}">
                        <c:forEach var="tmpType" items="${foodTypes}">
                            <option value="${tmpType}">${tmpType}</option>
                        </c:forEach>
                    </c:if>

                    <option id="addTypeOption" value="">New</option>
                </select>
                    <div id="showChoisedType">
                        <form:input id="enterType" path="type" placeholder="Enter new type"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td><label>Name:</label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><label>Kcal/100gm:</label></td>
                <td><form:input path="kcalPerHundredGm"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
<div style="clear:both;">
    <p>
        <a href="${pageContext.request.contextPath}/food/list">Back to List</a>
    </p>
</div>
<script src="${pageContext.request.contextPath}/resources/js/add-food-script.js"></script>
</body>
</html>

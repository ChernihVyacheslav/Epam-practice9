<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<body>

<table border ="1">
<c:forEach var="entry" items="${applicationScope.voteMap}">
    <tr>
        <td>${entry.key}</td>
        <td>${entry.value}</td>
        <td>
            <c:set var="isEmpty" value="true" scope="page"/>
            <c:forEach var="names" items="${applicationScope.nameVotes}" varStatus="status">
                <c:if test="${names.value == entry.key}">
                    <c:choose>
                    <c:when test="${isEmpty}">
                        <c:set var="isEmpty" value="false" scope="page"/>
                    </c:when>
                    <c:otherwise>${", "}</c:otherwise>
                    </c:choose>
                    ${names.key}
                </c:if>
            </c:forEach>
        </td>
    </tr>
</c:forEach>
</table>

<a href="/sportVote.html">Back</a>

</body>
</html>
<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="pager" type="org.springframework.data.domain.Page" required="true"%>
<%@ attribute name="paginationSize" type="java.lang.Integer" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
int current =  pager.getNumber() + 1;
int begin = Math.max(1, current - paginationSize/2);
int end = Math.min(begin + (paginationSize - 1), pager.getTotalPages());
request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
%>
<div class="pagination">
	<ul>
		 <% if (pager.hasPreviousPage()){%>
               	<li><a href="${ctx}/1">&lt;&lt;</a></li>
                <li><a href="${ctx}/${current-1}">&lt;</a></li>
         <%}else{%>
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
         <%} %>
 
		<c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i == current}">
                    <li class="active"><a href="${ctx}/${i}">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${ctx}/${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
	  
	  	 <% if (pager.hasNextPage()){%>
               	<li><a href="${ctx}/${current+1}">&gt;</a></li>
                <li><a href="${ctx}/${pager.totalPages}">&gt;&gt;</a></li>
         <%}else{%>
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
         <%} %>

	</ul>
</div>


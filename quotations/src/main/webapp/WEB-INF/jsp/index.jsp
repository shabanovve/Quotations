<%@ include file="common/header.jsp" %>

	<div class="link">
		<h2>Create Quote</h2>
		<c:if test="${saved == 'success'}">
			<p class="success">Quote Created Successfully</p>
		</c:if>
		<c:if test="${deleted == 'success'}">
			<p class="success">Quote Deleted Successfully</p>
		</c:if>
		<c:if test="${status == 'exist'}">
			<p class="error">Quote Already Exist</p>
		</c:if>
		<form:form modelAttribute="quote" action="/quotations/create" method="post">
			<form:label path="quoteStr">Quote str</form:label><form:input path="quoteStr" />
			<button type="submit" id="save">Save Quote</button><button type="submit" id="search">Search Quote</button>
		</form:form>
	</div>

	<c:if test="${search == 'true'}">
	<table>
	<tr>
	<th>Quote Str</th>
	<th colspan="2">Actions</th>
	</tr>
	<c:if test="${empty quotes}">
	<tr>
		<td colspan="4">No results found!</td>
	</tr>
	</c:if>
	<c:forEach var="current" items="${quotes}">
		<tr>
		<td>${current.quoteStr}</td>
		<td><a href="/quotations/edit/${current.quoteStr}">Edit</a></td>
		<td><a href="/quotations/delete/${current.quoteStr}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>

<script type="text/javascript">

	$(function() {
		$("#save").click(function(event) {
        	$("#quote").attr("action", "/quotations/create")
			$("#quota").submit();
		});

		$("#search").click(function(event) {
        	$("#quote").attr("action", "/quotations/search")
			$("#quote").submit();

		});
	});
</script>

<%@ include file="common/footer.jsp" %>

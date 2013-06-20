<%@ include file="common/header.jsp" %>

	<div class="link">
		<h2>Update Quote</h2>
		<c:if test="${saved == 'success'}">
			<p class="success">Quote Updated Successfully</p>
		</c:if>
		<form:form modelAttribute="quote" action="/quotations/update" method="post">
			<form:label path="quotaStr">Quota Str</form:label><form:input path="quotaStr" />
			<button type="submit" id="save">Update Quota</button> <a href="/quotations/">Go Home</a>
		</form:form>
	</div>


<%@ include file="common/footer.jsp" %>

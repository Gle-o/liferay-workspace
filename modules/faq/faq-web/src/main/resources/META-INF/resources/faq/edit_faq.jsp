<%-- 
	Assigment editing view.
--%>

<%@ include file="/init.jsp"%>

<%-- Generate add / edit action URL and set title. --%>

<c:choose>
	<c:when test="${not empty faq}">
		<portlet:actionURL var="faqActionURL" name="<%=MVCCommandNames.EDIT_FAQ %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-faq"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="faqActionURL" name="<%=MVCCommandNames.ADD_FAQ %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-faq"/>
	</c:otherwise>
</c:choose>

<%-- Error messages. --%>

<liferay-ui:error key="error.faq-service-error" message="error.faq-service-error" />
<liferay-ui:error key="error.faq-title-empty" message="error.faq-title-empty" />
<liferay-ui:error key="error.faq-description-empty" message="error.faq-description-empty" />
<liferay-ui:error key="error.faq-date-empty" message="error.faq-date-empty" />

<div class="container-fluid-1280 edit-faq">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${faq}" model="${faqClass}" />

	<aui:form action="${faqActionURL}" name="fm" onSubmit="event.preventDefault();">

		<aui:input name="faqId" field="faqId" type="hidden" />
		
		<aui:fieldset-group markupView="lexicon">
		
			<aui:fieldset>
			
				<%-- Title field. --%>
				
				<aui:input name="title">
				
					<aui:validator name="required" />
					
					<%-- Custom AUI validator. --%>
					
					<aui:validator errorMessage="error.faq-title-format" name="custom">
						function(val, fieldNode, ruleValue) {
							var wordExpression = 
								new RegExp("^[^\\[\\]\\^$<>]*$");
							
							return wordExpression.test(val);
						}
					</aui:validator>
				</aui:input>

				<%-- Description field. --%>
				
				<aui:field-wrapper 
					cssClass="entry-content form-group faq-description" 
					label="description" 
					required="true">

					<liferay-ui:input-editor 
						contents="${faq.description}"
						editorName='alloyeditor' 
						name="descriptionEditor"
						placeholder="description">
						
						<aui:validator name="required" />
						
					</liferay-ui:input-editor>
					<aui:input name="description" type="hidden" />
				</aui:field-wrapper>

				<%-- Due date field. --%>

				<aui:input name="dueDate">
					<aui:validator name="required" />
				</aui:input>
			</aui:fieldset>
		</aui:fieldset-group>
		
		<%--Buttons. --%>
		
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

</div>


<aui:script>

	AUI().ready(function() {
		
		$('#<portlet:namespace />fm').on('submit', function() {

			var editorValue = window['<portlet:namespace />descriptionEditor'].getHTML();
			
			if (editorValue.length == 0) {
				return false;
			}
			
			window['<portlet:namespace />description'].value = editorValue;

			submitForm(document.<portlet:namespace />fm);
		});
	});

</aui:script>

<%-- 
	Actions menu for a single faq.
--%>

<%@ include file="/init.jsp"%>

<c:set var="faq" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>

	<c:if
		test="${faqPermissionChecker.contains(permissionChecker, scopeGroupId, faq.faqId, 'VIEW' )}">
		<portlet:renderURL var="viewFaqsURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.VIEW_FAQS %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="faqId" value="${faq.faqId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="view" url="${viewFaqsURL}" />
	</c:if>

	<%-- Edit action. --%>

	<c:if
		test="${faqPermissionChecker.contains(permissionChecker, scopeGroupId, faq.faqId, 'UPDATE' )}">
		<portlet:renderURL var="editFaqURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.EDIT_FAQ %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="faqId" value="${faq.faqId}" />
		</portlet:renderURL>

		<liferay-ui:icon message="edit" url="${editFaqURL}" />
	</c:if>
	
	<%-- Permissions action. --%>
	
	<c:if
		test="${faqPermissionChecker.contains(permissionChecker, scopeGroupId, faq.faqId, 'PERMISSIONS')}">

		<liferay-security:permissionsURL
			modelResource="fr.smile.training.faq.model.Faq"
			modelResourceDescription="${faq.getTitle(locale)}"
			resourcePrimKey="${faq.faqId}" 
			var="permissionsURL" 
		/>

		<liferay-ui:icon message="permissions" url="${permissionsURL}" />
	</c:if>
		
	<%-- Delete action. --%>
	
	<c:if
		test="${faqPermissionChecker.contains(permissionChecker, scopeGroupId, faq.faqId, 'DELETE')}">

		<portlet:actionURL name="<%=MVCCommandNames.DELETE_FAQ %>" var="deleteFaqURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="faqId" value="${faq.faqId}" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="${deleteFaqURL}" />
	</c:if>
</liferay-ui:icon-menu>

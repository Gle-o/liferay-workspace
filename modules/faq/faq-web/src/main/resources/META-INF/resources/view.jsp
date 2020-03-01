<%--


https://dev.liferay.com/de/develop/reference/-/knowledge_base/7-1/breaking-changes#upgrade-considerations
	The main view.
	
	actionParams
clientDataRequest
cookies
contextPath
locale
locales
mutableRenderParams
namespace
portletContext
portletMode
portletRequest
portletResponse
resourceParams
windowId
windowState
stateAwareResponse

--%>
 
<%@ include file="/init.jsp"%>

<%-- Success messages. --%>

<liferay-ui:success key="faq-added" message="faq-added-successfully" />
<liferay-ui:success key="faq-updated" message="faq-updated-successfully" />
<liferay-ui:success key="faq-deleted" message="faq-deleted-successfully" />

<%-- Application display template renderer. 
     Contents of this tag can be overridden by your custom application display template. --%>

<liferay-ddm:template-renderer
	className="${faqClassName}"
	displayStyle="${ADTdisplayStyle}"
	displayStyleGroupId="${ADTdisplayStyleGroupId}" 
	entries="${faqs}">

	<div class="container-fluid-1280">
	
		<h1><liferay-ui:message key="faqs" /></h1>
		
		<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		clearResultsURL="${faqsManagementToolbarDisplayContext.getSearchActionURL()}"
		componentId="faqToolbar"
		creationMenu="${faqsManagementToolbarDisplayContext.getCreationMenu()}"
		disabled="${faqCount eq 0}"
		filterDropdownItems="${faqsManagementToolbarDisplayContext.getFilterDropdownItems()}"
		itemsTotal="${faqCount}"
		searchActionURL="${faqsManagementToolbarDisplayContext.getSearchActionURL()}"
		searchContainerId="faqEntries" searchFormName="searchFm"
		selectable="false" showInfoButton="false"
		sortingOrder="${faqsManagementToolbarDisplayContext.getOrderByType()}"
		sortingURL="${faqsManagementToolbarDisplayContext.getSortingURL()}"
		viewTypeItems="${faqsManagementToolbarDisplayContext.getViewTypes()}" />

	<%-- Search container. --%>
	
		<liferay-ui:search-container 
			emptyResultsMessage="no-faq"
			id="faqEntries"
			iteratorURL="${portletURL}" 
			total="${faqCount}">

			<liferay-ui:search-container-results results="${faqs}" />

			<liferay-ui:search-container-row
				className="fr.smile.training.faq.model.Faq"
				modelVar="entry">

				<%@ include file="/faq/entry_search_columns.jspf" %>

			</liferay-ui:search-container-row>
			
			<%-- Iterator / Paging --%>

			<liferay-ui:search-iterator 
				displayStyle="${faqsManagementToolbarDisplayContext.getDisplayStyle()}"
				markupView="lexicon" 
			/>
		</liferay-ui:search-container>
	</div> 
</liferay-ddm:template-renderer>
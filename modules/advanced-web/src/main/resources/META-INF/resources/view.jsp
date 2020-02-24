<%@ include file="init.jsp"%>
<p>
<portlet:renderURL var="nextViewURL">
<portlet:param name="mvcRenderCommandName" value="Next" />
</portlet:renderURL>
<a href="${nextViewURL}">Click here for next page</a>
</p>
<h1>
city : ${advancedPortletInstanceConfiguration.city()}
</h1>

<%-- show success message --%>
<%-- https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/adding-messages-to-jsps --%>
<liferay-ui:success key="greetingMessage" message="${GREETER_MESSAGE}" />

<%-- declare  liferay portlet arction url, will call EditEntryMVCActionCommand --%>
<liferay-portlet:actionURL name="greet" var="greetURL" />

<aui:form action="${greetURL}" method="post" name="fm">
	<aui:input name="name" type="text" />

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>
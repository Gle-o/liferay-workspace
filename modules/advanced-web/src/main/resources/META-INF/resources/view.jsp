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

<%-- declare  liferay portlet action url, will call EditEntryMVCActionCommand --%>
<liferay-portlet:actionURL name="greet" var="greetURL" />

<aui:form action="${greetURL}" method="post" name="fm">
	<aui:input name="name" type="text" />

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>


<%-- https://portal.liferay.dev/docs/7-2/appdev/-/knowledge_base/a/mvc-resource-command --%>
<%-- declare  liferay portlet render url, will call EducationMVCResourceCommand --%>
<liferay-portlet:resourceURL  id="/blade/education" var="addEducation" />

<div style="display: none;" id="addEducationURL">${addEducation}</div>

<aui:input name="education" id="education" onChange="addEducation()" label="education" inlineField="true" value="" />
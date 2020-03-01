<%-- 
	This is for showing assignment full content in Asset Publisher portlet.  
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-ddm" uri="http://liferay.com/tld/ddm" %>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ page import="java.util.Date"%>

<%@ page import="javax.portlet.WindowState"%>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@ page import="fr.smile.training.faq.model.Faq"%>
<%@ page import="fr.smile.training.faq.web.constants.MVCCommandNames"%>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);
					
	String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);
					
	Faq faq = (Faq)request.getAttribute("faq");					
%>

<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
	<h3 class="title"><%= HtmlUtil.escape(faq.getTitle(locale)) %></h3>
</aui:a>

<liferay-asset:asset-categories-available
    className="<%= Faq.class.getName() %>"
    classPK="<%= faq.getFaqId() %>"
>
    <div class="entry-categories">
        <liferay-asset:asset-categories-summary
            className="<%= Faq.class.getName() %>"
            classPK="<%= faq.getFaqId() %>"
            portletURL="<%= renderResponse.createRenderURL() %>"
        />
    </div>
</liferay-asset:asset-categories-available>


<liferay-asset:asset-tags-available
    className="<%= Faq.class.getName() %>"
    classPK="<%= faq.getFaqId() %>"
>
    <div class="entry-tags">
        <liferay-asset:asset-tags-summary
            className="<%= Faq.class.getName() %>"
            classPK="<%= faq.getFaqId() %>"
            portletURL="<%= renderResponse.createRenderURL() %>"
        />
    </div>
</liferay-asset:asset-tags-available>

<div class="autofit-col autofit-col-expand">
	${faq.getDescription()}
</div>


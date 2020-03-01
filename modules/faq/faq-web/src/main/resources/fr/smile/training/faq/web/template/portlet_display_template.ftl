<#--

	This is an example Application Display Template for the Faq Application.

	Application display templates can be used to modify the look of a
	specific application.

	Please use the left panel to quickly add commonly used variables.
	Autocomplete is also available and can be invoked by typing "${".


-->

<div class="container-fluid-1280">

	<h1>This is Using a Custom Application Display Template</h1>

	<div class="flex-container">

		<@liferay_ui["search-container"] emptyResultsMessage="there-are-no-faqs-for-this-class">
			<@liferay_ui["search-container-results"] results=entries />
			<@liferay_ui["search-container-row"]
				className="fr.smile.training.faq.model.Faq"
				modelVar="faq">

				<@liferay_portlet["renderURL"] var="viewSubmissionsURL">
					<@liferay_portlet["param"] name="mvcRenderCommandName"
						value="/faq/view" />
					<@liferay_portlet["param"] name="redirect" value="${currentURL}" />
					<@liferay_portlet["param"] name="faqId"
						value="${faq.getFaqId()}" />
				</@>
				
				<@liferay_frontend["icon-vertical-card"] icon="folder"
					title="${faq.getTitle(locale)}"
					actionJsp="/faq/entry_actions.jsp"
					cssClass="col-md-3 flex-item-break-xs card-row-padded"
					actionJspServletContext=application resultRow=row
					url="${}">

					<@liferay_frontend["vertical-card-footer"]>
						<p class="truncate-text flex-item-center">${faq.getDescription()}</p>
					</@>
				</@>
			</@>

			<liferay_ui["search-iterator"] markupView="lexicon" />
		</@>
	</div>
</div>
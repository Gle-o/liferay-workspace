/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package fr.smile.training.faq.search.spi.model.index.contributor;


import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.FaqLocalService;

/**
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "indexer.class.name=fr.smile.training.faq.model.Faq",
	service = ModelIndexerWriterContributor.class
)
public class FaqModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<Faq> {

	@Override
	public void customize(
		BatchIndexingActionable batchIndexingActionable,
		ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setAddCriteriaMethod(
			dynamicQuery -> {
				// you can filter
				
//				Property displayDateProperty = PropertyFactoryUtil.forName(
//					"displayDate");
//
//				dynamicQuery.add(displayDateProperty.lt(new Date()));
			});
		batchIndexingActionable.setPerformActionMethod(
			(Faq faq) -> batchIndexingActionable.addDocuments(
				modelIndexerWriterDocumentHelper.getDocument(faq)));
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				_faqLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Faq faq) {
		return faq.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(Faq faq) {
		if (faq.isApproved() || faq.isDraft() 
			// || faq.isInTrash() 
			|| faq.isPending()) {

			return IndexerWriterMode.UPDATE;
		}

		if (!faq.isApproved()
				//&& !faq.isInTrash()
			) {
			return IndexerWriterMode.SKIP;
		}

		return IndexerWriterMode.DELETE;
	}

	@Reference
	private FaqLocalService _faqLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory
		_dynamicQueryBatchIndexingActionableFactory;

}
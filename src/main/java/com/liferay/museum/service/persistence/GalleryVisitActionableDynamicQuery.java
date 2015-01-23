package com.liferay.museum.service.persistence;

import com.liferay.museum.model.GalleryVisit;
import com.liferay.museum.service.GalleryVisitLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class GalleryVisitActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GalleryVisitActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GalleryVisitLocalServiceUtil.getService());
        setClass(GalleryVisit.class);

        setClassLoader(com.liferay.museum.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("galleryVisitId");
    }
}

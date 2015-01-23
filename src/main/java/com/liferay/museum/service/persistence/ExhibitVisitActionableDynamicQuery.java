package com.liferay.museum.service.persistence;

import com.liferay.museum.model.ExhibitVisit;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class ExhibitVisitActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ExhibitVisitActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ExhibitVisitLocalServiceUtil.getService());
        setClass(ExhibitVisit.class);

        setClassLoader(com.liferay.museum.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("exhibitVisitId");
    }
}

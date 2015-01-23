package com.liferay.museum.model.impl;

import com.liferay.museum.model.ExhibitVisit;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ExhibitVisit service. Represents a row in the &quot;Museum_ExhibitVisit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExhibitVisitImpl}.
 * </p>
 *
 * @author James Falkner
 * @see ExhibitVisitImpl
 * @see com.liferay.museum.model.ExhibitVisit
 * @generated
 */
public abstract class ExhibitVisitBaseImpl extends ExhibitVisitModelImpl
    implements ExhibitVisit {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a exhibit visit model instance should use the {@link ExhibitVisit} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ExhibitVisitLocalServiceUtil.addExhibitVisit(this);
        } else {
            ExhibitVisitLocalServiceUtil.updateExhibitVisit(this);
        }
    }
}

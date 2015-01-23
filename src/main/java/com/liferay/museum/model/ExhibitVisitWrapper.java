package com.liferay.museum.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ExhibitVisit}.
 * </p>
 *
 * @author James Falkner
 * @see ExhibitVisit
 * @generated
 */
public class ExhibitVisitWrapper implements ExhibitVisit,
    ModelWrapper<ExhibitVisit> {
    private ExhibitVisit _exhibitVisit;

    public ExhibitVisitWrapper(ExhibitVisit exhibitVisit) {
        _exhibitVisit = exhibitVisit;
    }

    @Override
    public Class<?> getModelClass() {
        return ExhibitVisit.class;
    }

    @Override
    public String getModelClassName() {
        return ExhibitVisit.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("exhibitVisitId", getExhibitVisitId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("exhibitName", getExhibitName());
        attributes.put("visitorId", getVisitorId());
        attributes.put("proximity", getProximity());
        attributes.put("galleryName", getGalleryName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long exhibitVisitId = (Long) attributes.get("exhibitVisitId");

        if (exhibitVisitId != null) {
            setExhibitVisitId(exhibitVisitId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String exhibitName = (String) attributes.get("exhibitName");

        if (exhibitName != null) {
            setExhibitName(exhibitName);
        }

        String visitorId = (String) attributes.get("visitorId");

        if (visitorId != null) {
            setVisitorId(visitorId);
        }

        String proximity = (String) attributes.get("proximity");

        if (proximity != null) {
            setProximity(proximity);
        }

        String galleryName = (String) attributes.get("galleryName");

        if (galleryName != null) {
            setGalleryName(galleryName);
        }
    }

    /**
    * Returns the primary key of this exhibit visit.
    *
    * @return the primary key of this exhibit visit
    */
    @Override
    public long getPrimaryKey() {
        return _exhibitVisit.getPrimaryKey();
    }

    /**
    * Sets the primary key of this exhibit visit.
    *
    * @param primaryKey the primary key of this exhibit visit
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _exhibitVisit.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the exhibit visit ID of this exhibit visit.
    *
    * @return the exhibit visit ID of this exhibit visit
    */
    @Override
    public long getExhibitVisitId() {
        return _exhibitVisit.getExhibitVisitId();
    }

    /**
    * Sets the exhibit visit ID of this exhibit visit.
    *
    * @param exhibitVisitId the exhibit visit ID of this exhibit visit
    */
    @Override
    public void setExhibitVisitId(long exhibitVisitId) {
        _exhibitVisit.setExhibitVisitId(exhibitVisitId);
    }

    /**
    * Returns the group ID of this exhibit visit.
    *
    * @return the group ID of this exhibit visit
    */
    @Override
    public long getGroupId() {
        return _exhibitVisit.getGroupId();
    }

    /**
    * Sets the group ID of this exhibit visit.
    *
    * @param groupId the group ID of this exhibit visit
    */
    @Override
    public void setGroupId(long groupId) {
        _exhibitVisit.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this exhibit visit.
    *
    * @return the company ID of this exhibit visit
    */
    @Override
    public long getCompanyId() {
        return _exhibitVisit.getCompanyId();
    }

    /**
    * Sets the company ID of this exhibit visit.
    *
    * @param companyId the company ID of this exhibit visit
    */
    @Override
    public void setCompanyId(long companyId) {
        _exhibitVisit.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this exhibit visit.
    *
    * @return the user ID of this exhibit visit
    */
    @Override
    public long getUserId() {
        return _exhibitVisit.getUserId();
    }

    /**
    * Sets the user ID of this exhibit visit.
    *
    * @param userId the user ID of this exhibit visit
    */
    @Override
    public void setUserId(long userId) {
        _exhibitVisit.setUserId(userId);
    }

    /**
    * Returns the user uuid of this exhibit visit.
    *
    * @return the user uuid of this exhibit visit
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _exhibitVisit.getUserUuid();
    }

    /**
    * Sets the user uuid of this exhibit visit.
    *
    * @param userUuid the user uuid of this exhibit visit
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _exhibitVisit.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this exhibit visit.
    *
    * @return the user name of this exhibit visit
    */
    @Override
    public java.lang.String getUserName() {
        return _exhibitVisit.getUserName();
    }

    /**
    * Sets the user name of this exhibit visit.
    *
    * @param userName the user name of this exhibit visit
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _exhibitVisit.setUserName(userName);
    }

    /**
    * Returns the create date of this exhibit visit.
    *
    * @return the create date of this exhibit visit
    */
    @Override
    public java.util.Date getCreateDate() {
        return _exhibitVisit.getCreateDate();
    }

    /**
    * Sets the create date of this exhibit visit.
    *
    * @param createDate the create date of this exhibit visit
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _exhibitVisit.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this exhibit visit.
    *
    * @return the modified date of this exhibit visit
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _exhibitVisit.getModifiedDate();
    }

    /**
    * Sets the modified date of this exhibit visit.
    *
    * @param modifiedDate the modified date of this exhibit visit
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _exhibitVisit.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the exhibit name of this exhibit visit.
    *
    * @return the exhibit name of this exhibit visit
    */
    @Override
    public java.lang.String getExhibitName() {
        return _exhibitVisit.getExhibitName();
    }

    /**
    * Sets the exhibit name of this exhibit visit.
    *
    * @param exhibitName the exhibit name of this exhibit visit
    */
    @Override
    public void setExhibitName(java.lang.String exhibitName) {
        _exhibitVisit.setExhibitName(exhibitName);
    }

    /**
    * Returns the visitor ID of this exhibit visit.
    *
    * @return the visitor ID of this exhibit visit
    */
    @Override
    public java.lang.String getVisitorId() {
        return _exhibitVisit.getVisitorId();
    }

    /**
    * Sets the visitor ID of this exhibit visit.
    *
    * @param visitorId the visitor ID of this exhibit visit
    */
    @Override
    public void setVisitorId(java.lang.String visitorId) {
        _exhibitVisit.setVisitorId(visitorId);
    }

    /**
    * Returns the proximity of this exhibit visit.
    *
    * @return the proximity of this exhibit visit
    */
    @Override
    public java.lang.String getProximity() {
        return _exhibitVisit.getProximity();
    }

    /**
    * Sets the proximity of this exhibit visit.
    *
    * @param proximity the proximity of this exhibit visit
    */
    @Override
    public void setProximity(java.lang.String proximity) {
        _exhibitVisit.setProximity(proximity);
    }

    /**
    * Returns the gallery name of this exhibit visit.
    *
    * @return the gallery name of this exhibit visit
    */
    @Override
    public java.lang.String getGalleryName() {
        return _exhibitVisit.getGalleryName();
    }

    /**
    * Sets the gallery name of this exhibit visit.
    *
    * @param galleryName the gallery name of this exhibit visit
    */
    @Override
    public void setGalleryName(java.lang.String galleryName) {
        _exhibitVisit.setGalleryName(galleryName);
    }

    @Override
    public boolean isNew() {
        return _exhibitVisit.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _exhibitVisit.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _exhibitVisit.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _exhibitVisit.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _exhibitVisit.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _exhibitVisit.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _exhibitVisit.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _exhibitVisit.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _exhibitVisit.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _exhibitVisit.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _exhibitVisit.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ExhibitVisitWrapper((ExhibitVisit) _exhibitVisit.clone());
    }

    @Override
    public int compareTo(com.liferay.museum.model.ExhibitVisit exhibitVisit) {
        return _exhibitVisit.compareTo(exhibitVisit);
    }

    @Override
    public int hashCode() {
        return _exhibitVisit.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.museum.model.ExhibitVisit> toCacheModel() {
        return _exhibitVisit.toCacheModel();
    }

    @Override
    public com.liferay.museum.model.ExhibitVisit toEscapedModel() {
        return new ExhibitVisitWrapper(_exhibitVisit.toEscapedModel());
    }

    @Override
    public com.liferay.museum.model.ExhibitVisit toUnescapedModel() {
        return new ExhibitVisitWrapper(_exhibitVisit.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _exhibitVisit.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _exhibitVisit.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _exhibitVisit.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ExhibitVisitWrapper)) {
            return false;
        }

        ExhibitVisitWrapper exhibitVisitWrapper = (ExhibitVisitWrapper) obj;

        if (Validator.equals(_exhibitVisit, exhibitVisitWrapper._exhibitVisit)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ExhibitVisit getWrappedExhibitVisit() {
        return _exhibitVisit;
    }

    @Override
    public ExhibitVisit getWrappedModel() {
        return _exhibitVisit;
    }

    @Override
    public void resetOriginalValues() {
        _exhibitVisit.resetOriginalValues();
    }
}

package com.liferay.museum.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GalleryVisit}.
 * </p>
 *
 * @author James Falkner
 * @see GalleryVisit
 * @generated
 */
public class GalleryVisitWrapper implements GalleryVisit,
    ModelWrapper<GalleryVisit> {
    private GalleryVisit _galleryVisit;

    public GalleryVisitWrapper(GalleryVisit galleryVisit) {
        _galleryVisit = galleryVisit;
    }

    @Override
    public Class<?> getModelClass() {
        return GalleryVisit.class;
    }

    @Override
    public String getModelClassName() {
        return GalleryVisit.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("galleryVisitId", getGalleryVisitId());
        attributes.put("galleryName", getGalleryName());
        attributes.put("visitorId", getVisitorId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long galleryVisitId = (Long) attributes.get("galleryVisitId");

        if (galleryVisitId != null) {
            setGalleryVisitId(galleryVisitId);
        }

        String galleryName = (String) attributes.get("galleryName");

        if (galleryName != null) {
            setGalleryName(galleryName);
        }

        String visitorId = (String) attributes.get("visitorId");

        if (visitorId != null) {
            setVisitorId(visitorId);
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
    }

    /**
    * Returns the primary key of this gallery visit.
    *
    * @return the primary key of this gallery visit
    */
    @Override
    public long getPrimaryKey() {
        return _galleryVisit.getPrimaryKey();
    }

    /**
    * Sets the primary key of this gallery visit.
    *
    * @param primaryKey the primary key of this gallery visit
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _galleryVisit.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the gallery visit ID of this gallery visit.
    *
    * @return the gallery visit ID of this gallery visit
    */
    @Override
    public long getGalleryVisitId() {
        return _galleryVisit.getGalleryVisitId();
    }

    /**
    * Sets the gallery visit ID of this gallery visit.
    *
    * @param galleryVisitId the gallery visit ID of this gallery visit
    */
    @Override
    public void setGalleryVisitId(long galleryVisitId) {
        _galleryVisit.setGalleryVisitId(galleryVisitId);
    }

    /**
    * Returns the gallery name of this gallery visit.
    *
    * @return the gallery name of this gallery visit
    */
    @Override
    public java.lang.String getGalleryName() {
        return _galleryVisit.getGalleryName();
    }

    /**
    * Sets the gallery name of this gallery visit.
    *
    * @param galleryName the gallery name of this gallery visit
    */
    @Override
    public void setGalleryName(java.lang.String galleryName) {
        _galleryVisit.setGalleryName(galleryName);
    }

    /**
    * Returns the visitor ID of this gallery visit.
    *
    * @return the visitor ID of this gallery visit
    */
    @Override
    public java.lang.String getVisitorId() {
        return _galleryVisit.getVisitorId();
    }

    /**
    * Sets the visitor ID of this gallery visit.
    *
    * @param visitorId the visitor ID of this gallery visit
    */
    @Override
    public void setVisitorId(java.lang.String visitorId) {
        _galleryVisit.setVisitorId(visitorId);
    }

    /**
    * Returns the group ID of this gallery visit.
    *
    * @return the group ID of this gallery visit
    */
    @Override
    public long getGroupId() {
        return _galleryVisit.getGroupId();
    }

    /**
    * Sets the group ID of this gallery visit.
    *
    * @param groupId the group ID of this gallery visit
    */
    @Override
    public void setGroupId(long groupId) {
        _galleryVisit.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this gallery visit.
    *
    * @return the company ID of this gallery visit
    */
    @Override
    public long getCompanyId() {
        return _galleryVisit.getCompanyId();
    }

    /**
    * Sets the company ID of this gallery visit.
    *
    * @param companyId the company ID of this gallery visit
    */
    @Override
    public void setCompanyId(long companyId) {
        _galleryVisit.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this gallery visit.
    *
    * @return the user ID of this gallery visit
    */
    @Override
    public long getUserId() {
        return _galleryVisit.getUserId();
    }

    /**
    * Sets the user ID of this gallery visit.
    *
    * @param userId the user ID of this gallery visit
    */
    @Override
    public void setUserId(long userId) {
        _galleryVisit.setUserId(userId);
    }

    /**
    * Returns the user uuid of this gallery visit.
    *
    * @return the user uuid of this gallery visit
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisit.getUserUuid();
    }

    /**
    * Sets the user uuid of this gallery visit.
    *
    * @param userUuid the user uuid of this gallery visit
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _galleryVisit.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this gallery visit.
    *
    * @return the user name of this gallery visit
    */
    @Override
    public java.lang.String getUserName() {
        return _galleryVisit.getUserName();
    }

    /**
    * Sets the user name of this gallery visit.
    *
    * @param userName the user name of this gallery visit
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _galleryVisit.setUserName(userName);
    }

    /**
    * Returns the create date of this gallery visit.
    *
    * @return the create date of this gallery visit
    */
    @Override
    public java.util.Date getCreateDate() {
        return _galleryVisit.getCreateDate();
    }

    /**
    * Sets the create date of this gallery visit.
    *
    * @param createDate the create date of this gallery visit
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _galleryVisit.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this gallery visit.
    *
    * @return the modified date of this gallery visit
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _galleryVisit.getModifiedDate();
    }

    /**
    * Sets the modified date of this gallery visit.
    *
    * @param modifiedDate the modified date of this gallery visit
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _galleryVisit.setModifiedDate(modifiedDate);
    }

    @Override
    public boolean isNew() {
        return _galleryVisit.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _galleryVisit.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _galleryVisit.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _galleryVisit.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _galleryVisit.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _galleryVisit.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _galleryVisit.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _galleryVisit.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _galleryVisit.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _galleryVisit.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _galleryVisit.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new GalleryVisitWrapper((GalleryVisit) _galleryVisit.clone());
    }

    @Override
    public int compareTo(com.liferay.museum.model.GalleryVisit galleryVisit) {
        return _galleryVisit.compareTo(galleryVisit);
    }

    @Override
    public int hashCode() {
        return _galleryVisit.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.museum.model.GalleryVisit> toCacheModel() {
        return _galleryVisit.toCacheModel();
    }

    @Override
    public com.liferay.museum.model.GalleryVisit toEscapedModel() {
        return new GalleryVisitWrapper(_galleryVisit.toEscapedModel());
    }

    @Override
    public com.liferay.museum.model.GalleryVisit toUnescapedModel() {
        return new GalleryVisitWrapper(_galleryVisit.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _galleryVisit.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _galleryVisit.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _galleryVisit.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GalleryVisitWrapper)) {
            return false;
        }

        GalleryVisitWrapper galleryVisitWrapper = (GalleryVisitWrapper) obj;

        if (Validator.equals(_galleryVisit, galleryVisitWrapper._galleryVisit)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public GalleryVisit getWrappedGalleryVisit() {
        return _galleryVisit;
    }

    @Override
    public GalleryVisit getWrappedModel() {
        return _galleryVisit;
    }

    @Override
    public void resetOriginalValues() {
        _galleryVisit.resetOriginalValues();
    }
}

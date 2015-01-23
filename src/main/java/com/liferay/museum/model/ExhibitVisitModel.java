package com.liferay.museum.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ExhibitVisit service. Represents a row in the &quot;Museum_ExhibitVisit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.museum.model.impl.ExhibitVisitImpl}.
 * </p>
 *
 * @author James Falkner
 * @see ExhibitVisit
 * @see com.liferay.museum.model.impl.ExhibitVisitImpl
 * @see com.liferay.museum.model.impl.ExhibitVisitModelImpl
 * @generated
 */
public interface ExhibitVisitModel extends BaseModel<ExhibitVisit>, GroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a exhibit visit model instance should use the {@link ExhibitVisit} interface instead.
     */

    /**
     * Returns the primary key of this exhibit visit.
     *
     * @return the primary key of this exhibit visit
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this exhibit visit.
     *
     * @param primaryKey the primary key of this exhibit visit
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the exhibit visit ID of this exhibit visit.
     *
     * @return the exhibit visit ID of this exhibit visit
     */
    public long getExhibitVisitId();

    /**
     * Sets the exhibit visit ID of this exhibit visit.
     *
     * @param exhibitVisitId the exhibit visit ID of this exhibit visit
     */
    public void setExhibitVisitId(long exhibitVisitId);

    /**
     * Returns the group ID of this exhibit visit.
     *
     * @return the group ID of this exhibit visit
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this exhibit visit.
     *
     * @param groupId the group ID of this exhibit visit
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this exhibit visit.
     *
     * @return the company ID of this exhibit visit
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this exhibit visit.
     *
     * @param companyId the company ID of this exhibit visit
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this exhibit visit.
     *
     * @return the user ID of this exhibit visit
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this exhibit visit.
     *
     * @param userId the user ID of this exhibit visit
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this exhibit visit.
     *
     * @return the user uuid of this exhibit visit
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this exhibit visit.
     *
     * @param userUuid the user uuid of this exhibit visit
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this exhibit visit.
     *
     * @return the user name of this exhibit visit
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this exhibit visit.
     *
     * @param userName the user name of this exhibit visit
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this exhibit visit.
     *
     * @return the create date of this exhibit visit
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this exhibit visit.
     *
     * @param createDate the create date of this exhibit visit
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this exhibit visit.
     *
     * @return the modified date of this exhibit visit
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this exhibit visit.
     *
     * @param modifiedDate the modified date of this exhibit visit
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the exhibit name of this exhibit visit.
     *
     * @return the exhibit name of this exhibit visit
     */
    @AutoEscape
    public String getExhibitName();

    /**
     * Sets the exhibit name of this exhibit visit.
     *
     * @param exhibitName the exhibit name of this exhibit visit
     */
    public void setExhibitName(String exhibitName);

    /**
     * Returns the visitor ID of this exhibit visit.
     *
     * @return the visitor ID of this exhibit visit
     */
    @AutoEscape
    public String getVisitorId();

    /**
     * Sets the visitor ID of this exhibit visit.
     *
     * @param visitorId the visitor ID of this exhibit visit
     */
    public void setVisitorId(String visitorId);

    /**
     * Returns the proximity of this exhibit visit.
     *
     * @return the proximity of this exhibit visit
     */
    @AutoEscape
    public String getProximity();

    /**
     * Sets the proximity of this exhibit visit.
     *
     * @param proximity the proximity of this exhibit visit
     */
    public void setProximity(String proximity);

    /**
     * Returns the gallery name of this exhibit visit.
     *
     * @return the gallery name of this exhibit visit
     */
    @AutoEscape
    public String getGalleryName();

    /**
     * Sets the gallery name of this exhibit visit.
     *
     * @param galleryName the gallery name of this exhibit visit
     */
    public void setGalleryName(String galleryName);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(ExhibitVisit exhibitVisit);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ExhibitVisit> toCacheModel();

    @Override
    public ExhibitVisit toEscapedModel();

    @Override
    public ExhibitVisit toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

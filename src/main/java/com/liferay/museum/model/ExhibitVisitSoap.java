package com.liferay.museum.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.museum.service.http.ExhibitVisitServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.museum.service.http.ExhibitVisitServiceSoap
 * @generated
 */
public class ExhibitVisitSoap implements Serializable {
    private long _exhibitVisitId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _exhibitName;
    private String _visitorId;
    private String _proximity;
    private String _galleryName;

    public ExhibitVisitSoap() {
    }

    public static ExhibitVisitSoap toSoapModel(ExhibitVisit model) {
        ExhibitVisitSoap soapModel = new ExhibitVisitSoap();

        soapModel.setExhibitVisitId(model.getExhibitVisitId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setExhibitName(model.getExhibitName());
        soapModel.setVisitorId(model.getVisitorId());
        soapModel.setProximity(model.getProximity());
        soapModel.setGalleryName(model.getGalleryName());

        return soapModel;
    }

    public static ExhibitVisitSoap[] toSoapModels(ExhibitVisit[] models) {
        ExhibitVisitSoap[] soapModels = new ExhibitVisitSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ExhibitVisitSoap[][] toSoapModels(ExhibitVisit[][] models) {
        ExhibitVisitSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ExhibitVisitSoap[models.length][models[0].length];
        } else {
            soapModels = new ExhibitVisitSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ExhibitVisitSoap[] toSoapModels(List<ExhibitVisit> models) {
        List<ExhibitVisitSoap> soapModels = new ArrayList<ExhibitVisitSoap>(models.size());

        for (ExhibitVisit model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ExhibitVisitSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _exhibitVisitId;
    }

    public void setPrimaryKey(long pk) {
        setExhibitVisitId(pk);
    }

    public long getExhibitVisitId() {
        return _exhibitVisitId;
    }

    public void setExhibitVisitId(long exhibitVisitId) {
        _exhibitVisitId = exhibitVisitId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getExhibitName() {
        return _exhibitName;
    }

    public void setExhibitName(String exhibitName) {
        _exhibitName = exhibitName;
    }

    public String getVisitorId() {
        return _visitorId;
    }

    public void setVisitorId(String visitorId) {
        _visitorId = visitorId;
    }

    public String getProximity() {
        return _proximity;
    }

    public void setProximity(String proximity) {
        _proximity = proximity;
    }

    public String getGalleryName() {
        return _galleryName;
    }

    public void setGalleryName(String galleryName) {
        _galleryName = galleryName;
    }
}

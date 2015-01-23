package com.liferay.museum.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.museum.service.http.GalleryVisitServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.museum.service.http.GalleryVisitServiceSoap
 * @generated
 */
public class GalleryVisitSoap implements Serializable {
    private long _galleryVisitId;
    private String _galleryName;
    private String _visitorId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;

    public GalleryVisitSoap() {
    }

    public static GalleryVisitSoap toSoapModel(GalleryVisit model) {
        GalleryVisitSoap soapModel = new GalleryVisitSoap();

        soapModel.setGalleryVisitId(model.getGalleryVisitId());
        soapModel.setGalleryName(model.getGalleryName());
        soapModel.setVisitorId(model.getVisitorId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());

        return soapModel;
    }

    public static GalleryVisitSoap[] toSoapModels(GalleryVisit[] models) {
        GalleryVisitSoap[] soapModels = new GalleryVisitSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static GalleryVisitSoap[][] toSoapModels(GalleryVisit[][] models) {
        GalleryVisitSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new GalleryVisitSoap[models.length][models[0].length];
        } else {
            soapModels = new GalleryVisitSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static GalleryVisitSoap[] toSoapModels(List<GalleryVisit> models) {
        List<GalleryVisitSoap> soapModels = new ArrayList<GalleryVisitSoap>(models.size());

        for (GalleryVisit model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new GalleryVisitSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _galleryVisitId;
    }

    public void setPrimaryKey(long pk) {
        setGalleryVisitId(pk);
    }

    public long getGalleryVisitId() {
        return _galleryVisitId;
    }

    public void setGalleryVisitId(long galleryVisitId) {
        _galleryVisitId = galleryVisitId;
    }

    public String getGalleryName() {
        return _galleryName;
    }

    public void setGalleryName(String galleryName) {
        _galleryName = galleryName;
    }

    public String getVisitorId() {
        return _visitorId;
    }

    public void setVisitorId(String visitorId) {
        _visitorId = visitorId;
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
}

package com.liferay.museum.model;

import com.liferay.museum.service.ClpSerializer;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ExhibitVisitClp extends BaseModelImpl<ExhibitVisit>
    implements ExhibitVisit {
    private long _exhibitVisitId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _exhibitName;
    private String _visitorId;
    private String _proximity;
    private String _galleryName;
    private BaseModel<?> _exhibitVisitRemoteModel;

    public ExhibitVisitClp() {
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
    public long getPrimaryKey() {
        return _exhibitVisitId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setExhibitVisitId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _exhibitVisitId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getExhibitVisitId() {
        return _exhibitVisitId;
    }

    @Override
    public void setExhibitVisitId(long exhibitVisitId) {
        _exhibitVisitId = exhibitVisitId;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setExhibitVisitId", long.class);

                method.invoke(_exhibitVisitRemoteModel, exhibitVisitId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_exhibitVisitRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_exhibitVisitRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_exhibitVisitRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_exhibitVisitRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_exhibitVisitRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_exhibitVisitRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getExhibitName() {
        return _exhibitName;
    }

    @Override
    public void setExhibitName(String exhibitName) {
        _exhibitName = exhibitName;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setExhibitName", String.class);

                method.invoke(_exhibitVisitRemoteModel, exhibitName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVisitorId() {
        return _visitorId;
    }

    @Override
    public void setVisitorId(String visitorId) {
        _visitorId = visitorId;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setVisitorId", String.class);

                method.invoke(_exhibitVisitRemoteModel, visitorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProximity() {
        return _proximity;
    }

    @Override
    public void setProximity(String proximity) {
        _proximity = proximity;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setProximity", String.class);

                method.invoke(_exhibitVisitRemoteModel, proximity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getGalleryName() {
        return _galleryName;
    }

    @Override
    public void setGalleryName(String galleryName) {
        _galleryName = galleryName;

        if (_exhibitVisitRemoteModel != null) {
            try {
                Class<?> clazz = _exhibitVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setGalleryName", String.class);

                method.invoke(_exhibitVisitRemoteModel, galleryName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getExhibitVisitRemoteModel() {
        return _exhibitVisitRemoteModel;
    }

    public void setExhibitVisitRemoteModel(BaseModel<?> exhibitVisitRemoteModel) {
        _exhibitVisitRemoteModel = exhibitVisitRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _exhibitVisitRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_exhibitVisitRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ExhibitVisitLocalServiceUtil.addExhibitVisit(this);
        } else {
            ExhibitVisitLocalServiceUtil.updateExhibitVisit(this);
        }
    }

    @Override
    public ExhibitVisit toEscapedModel() {
        return (ExhibitVisit) ProxyUtil.newProxyInstance(ExhibitVisit.class.getClassLoader(),
            new Class[] { ExhibitVisit.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ExhibitVisitClp clone = new ExhibitVisitClp();

        clone.setExhibitVisitId(getExhibitVisitId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setExhibitName(getExhibitName());
        clone.setVisitorId(getVisitorId());
        clone.setProximity(getProximity());
        clone.setGalleryName(getGalleryName());

        return clone;
    }

    @Override
    public int compareTo(ExhibitVisit exhibitVisit) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), exhibitVisit.getCreateDate());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ExhibitVisitClp)) {
            return false;
        }

        ExhibitVisitClp exhibitVisit = (ExhibitVisitClp) obj;

        long primaryKey = exhibitVisit.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{exhibitVisitId=");
        sb.append(getExhibitVisitId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", exhibitName=");
        sb.append(getExhibitName());
        sb.append(", visitorId=");
        sb.append(getVisitorId());
        sb.append(", proximity=");
        sb.append(getProximity());
        sb.append(", galleryName=");
        sb.append(getGalleryName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.liferay.museum.model.ExhibitVisit");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>exhibitVisitId</column-name><column-value><![CDATA[");
        sb.append(getExhibitVisitId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>exhibitName</column-name><column-value><![CDATA[");
        sb.append(getExhibitName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>visitorId</column-name><column-value><![CDATA[");
        sb.append(getVisitorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>proximity</column-name><column-value><![CDATA[");
        sb.append(getProximity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>galleryName</column-name><column-value><![CDATA[");
        sb.append(getGalleryName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

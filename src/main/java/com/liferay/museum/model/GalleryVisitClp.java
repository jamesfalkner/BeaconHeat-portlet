package com.liferay.museum.model;

import com.liferay.museum.service.ClpSerializer;
import com.liferay.museum.service.GalleryVisitLocalServiceUtil;

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


public class GalleryVisitClp extends BaseModelImpl<GalleryVisit>
    implements GalleryVisit {
    private long _galleryVisitId;
    private String _galleryName;
    private String _visitorId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private BaseModel<?> _galleryVisitRemoteModel;

    public GalleryVisitClp() {
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
    public long getPrimaryKey() {
        return _galleryVisitId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGalleryVisitId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _galleryVisitId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getGalleryVisitId() {
        return _galleryVisitId;
    }

    @Override
    public void setGalleryVisitId(long galleryVisitId) {
        _galleryVisitId = galleryVisitId;

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setGalleryVisitId", long.class);

                method.invoke(_galleryVisitRemoteModel, galleryVisitId);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setGalleryName", String.class);

                method.invoke(_galleryVisitRemoteModel, galleryName);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setVisitorId", String.class);

                method.invoke(_galleryVisitRemoteModel, visitorId);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_galleryVisitRemoteModel, groupId);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_galleryVisitRemoteModel, companyId);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_galleryVisitRemoteModel, userId);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_galleryVisitRemoteModel, userName);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_galleryVisitRemoteModel, createDate);
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

        if (_galleryVisitRemoteModel != null) {
            try {
                Class<?> clazz = _galleryVisitRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_galleryVisitRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getGalleryVisitRemoteModel() {
        return _galleryVisitRemoteModel;
    }

    public void setGalleryVisitRemoteModel(BaseModel<?> galleryVisitRemoteModel) {
        _galleryVisitRemoteModel = galleryVisitRemoteModel;
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

        Class<?> remoteModelClass = _galleryVisitRemoteModel.getClass();

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

        Object returnValue = method.invoke(_galleryVisitRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GalleryVisitLocalServiceUtil.addGalleryVisit(this);
        } else {
            GalleryVisitLocalServiceUtil.updateGalleryVisit(this);
        }
    }

    @Override
    public GalleryVisit toEscapedModel() {
        return (GalleryVisit) ProxyUtil.newProxyInstance(GalleryVisit.class.getClassLoader(),
            new Class[] { GalleryVisit.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        GalleryVisitClp clone = new GalleryVisitClp();

        clone.setGalleryVisitId(getGalleryVisitId());
        clone.setGalleryName(getGalleryName());
        clone.setVisitorId(getVisitorId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());

        return clone;
    }

    @Override
    public int compareTo(GalleryVisit galleryVisit) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), galleryVisit.getCreateDate());

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

        if (!(obj instanceof GalleryVisitClp)) {
            return false;
        }

        GalleryVisitClp galleryVisit = (GalleryVisitClp) obj;

        long primaryKey = galleryVisit.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{galleryVisitId=");
        sb.append(getGalleryVisitId());
        sb.append(", galleryName=");
        sb.append(getGalleryName());
        sb.append(", visitorId=");
        sb.append(getVisitorId());
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
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.liferay.museum.model.GalleryVisit");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>galleryVisitId</column-name><column-value><![CDATA[");
        sb.append(getGalleryVisitId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>galleryName</column-name><column-value><![CDATA[");
        sb.append(getGalleryName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>visitorId</column-name><column-value><![CDATA[");
        sb.append(getVisitorId());
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

        sb.append("</model>");

        return sb.toString();
    }
}

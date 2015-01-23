package com.liferay.museum.model.impl;

import com.liferay.museum.model.GalleryVisit;
import com.liferay.museum.model.GalleryVisitModel;
import com.liferay.museum.model.GalleryVisitSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the GalleryVisit service. Represents a row in the &quot;Museum_GalleryVisit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.museum.model.GalleryVisitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GalleryVisitImpl}.
 * </p>
 *
 * @author James Falkner
 * @see GalleryVisitImpl
 * @see com.liferay.museum.model.GalleryVisit
 * @see com.liferay.museum.model.GalleryVisitModel
 * @generated
 */
@JSON(strict = true)
public class GalleryVisitModelImpl extends BaseModelImpl<GalleryVisit>
    implements GalleryVisitModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a gallery visit model instance should use the {@link com.liferay.museum.model.GalleryVisit} interface instead.
     */
    public static final String TABLE_NAME = "Museum_GalleryVisit";
    public static final Object[][] TABLE_COLUMNS = {
            { "galleryVisitId", Types.BIGINT },
            { "galleryName", Types.VARCHAR },
            { "visitorId", Types.VARCHAR },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table Museum_GalleryVisit (galleryVisitId LONG not null primary key,galleryName VARCHAR(75) null,visitorId VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table Museum_GalleryVisit";
    public static final String ORDER_BY_JPQL = " ORDER BY galleryVisit.createDate ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Museum_GalleryVisit.createDate ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.liferay.museum.model.GalleryVisit"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.liferay.museum.model.GalleryVisit"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.liferay.museum.model.GalleryVisit"));
    private static ClassLoader _classLoader = GalleryVisit.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            GalleryVisit.class
        };
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
    private GalleryVisit _escapedModel;

    public GalleryVisitModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static GalleryVisit toModel(GalleryVisitSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        GalleryVisit model = new GalleryVisitImpl();

        model.setGalleryVisitId(soapModel.getGalleryVisitId());
        model.setGalleryName(soapModel.getGalleryName());
        model.setVisitorId(soapModel.getVisitorId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<GalleryVisit> toModels(GalleryVisitSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<GalleryVisit> models = new ArrayList<GalleryVisit>(soapModels.length);

        for (GalleryVisitSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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

    @JSON
    @Override
    public long getGalleryVisitId() {
        return _galleryVisitId;
    }

    @Override
    public void setGalleryVisitId(long galleryVisitId) {
        _galleryVisitId = galleryVisitId;
    }

    @JSON
    @Override
    public String getGalleryName() {
        if (_galleryName == null) {
            return StringPool.BLANK;
        } else {
            return _galleryName;
        }
    }

    @Override
    public void setGalleryName(String galleryName) {
        _galleryName = galleryName;
    }

    @JSON
    @Override
    public String getVisitorId() {
        if (_visitorId == null) {
            return StringPool.BLANK;
        } else {
            return _visitorId;
        }
    }

    @Override
    public void setVisitorId(String visitorId) {
        _visitorId = visitorId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            GalleryVisit.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public GalleryVisit toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (GalleryVisit) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        GalleryVisitImpl galleryVisitImpl = new GalleryVisitImpl();

        galleryVisitImpl.setGalleryVisitId(getGalleryVisitId());
        galleryVisitImpl.setGalleryName(getGalleryName());
        galleryVisitImpl.setVisitorId(getVisitorId());
        galleryVisitImpl.setGroupId(getGroupId());
        galleryVisitImpl.setCompanyId(getCompanyId());
        galleryVisitImpl.setUserId(getUserId());
        galleryVisitImpl.setUserName(getUserName());
        galleryVisitImpl.setCreateDate(getCreateDate());
        galleryVisitImpl.setModifiedDate(getModifiedDate());

        galleryVisitImpl.resetOriginalValues();

        return galleryVisitImpl;
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

        if (!(obj instanceof GalleryVisit)) {
            return false;
        }

        GalleryVisit galleryVisit = (GalleryVisit) obj;

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
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<GalleryVisit> toCacheModel() {
        GalleryVisitCacheModel galleryVisitCacheModel = new GalleryVisitCacheModel();

        galleryVisitCacheModel.galleryVisitId = getGalleryVisitId();

        galleryVisitCacheModel.galleryName = getGalleryName();

        String galleryName = galleryVisitCacheModel.galleryName;

        if ((galleryName != null) && (galleryName.length() == 0)) {
            galleryVisitCacheModel.galleryName = null;
        }

        galleryVisitCacheModel.visitorId = getVisitorId();

        String visitorId = galleryVisitCacheModel.visitorId;

        if ((visitorId != null) && (visitorId.length() == 0)) {
            galleryVisitCacheModel.visitorId = null;
        }

        galleryVisitCacheModel.groupId = getGroupId();

        galleryVisitCacheModel.companyId = getCompanyId();

        galleryVisitCacheModel.userId = getUserId();

        galleryVisitCacheModel.userName = getUserName();

        String userName = galleryVisitCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            galleryVisitCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            galleryVisitCacheModel.createDate = createDate.getTime();
        } else {
            galleryVisitCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            galleryVisitCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            galleryVisitCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        return galleryVisitCacheModel;
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

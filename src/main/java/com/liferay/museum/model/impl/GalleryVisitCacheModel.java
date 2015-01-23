package com.liferay.museum.model.impl;

import com.liferay.museum.model.GalleryVisit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GalleryVisit in entity cache.
 *
 * @author James Falkner
 * @see GalleryVisit
 * @generated
 */
public class GalleryVisitCacheModel implements CacheModel<GalleryVisit>,
    Externalizable {
    public long galleryVisitId;
    public String galleryName;
    public String visitorId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{galleryVisitId=");
        sb.append(galleryVisitId);
        sb.append(", galleryName=");
        sb.append(galleryName);
        sb.append(", visitorId=");
        sb.append(visitorId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public GalleryVisit toEntityModel() {
        GalleryVisitImpl galleryVisitImpl = new GalleryVisitImpl();

        galleryVisitImpl.setGalleryVisitId(galleryVisitId);

        if (galleryName == null) {
            galleryVisitImpl.setGalleryName(StringPool.BLANK);
        } else {
            galleryVisitImpl.setGalleryName(galleryName);
        }

        if (visitorId == null) {
            galleryVisitImpl.setVisitorId(StringPool.BLANK);
        } else {
            galleryVisitImpl.setVisitorId(visitorId);
        }

        galleryVisitImpl.setGroupId(groupId);
        galleryVisitImpl.setCompanyId(companyId);
        galleryVisitImpl.setUserId(userId);

        if (userName == null) {
            galleryVisitImpl.setUserName(StringPool.BLANK);
        } else {
            galleryVisitImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            galleryVisitImpl.setCreateDate(null);
        } else {
            galleryVisitImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            galleryVisitImpl.setModifiedDate(null);
        } else {
            galleryVisitImpl.setModifiedDate(new Date(modifiedDate));
        }

        galleryVisitImpl.resetOriginalValues();

        return galleryVisitImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        galleryVisitId = objectInput.readLong();
        galleryName = objectInput.readUTF();
        visitorId = objectInput.readUTF();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(galleryVisitId);

        if (galleryName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(galleryName);
        }

        if (visitorId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(visitorId);
        }

        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
    }
}

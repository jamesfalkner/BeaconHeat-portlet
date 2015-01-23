package com.liferay.museum.model.impl;

import com.liferay.museum.model.ExhibitVisit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExhibitVisit in entity cache.
 *
 * @author James Falkner
 * @see ExhibitVisit
 * @generated
 */
public class ExhibitVisitCacheModel implements CacheModel<ExhibitVisit>,
    Externalizable {
    public long exhibitVisitId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String exhibitName;
    public String visitorId;
    public String proximity;
    public String galleryName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{exhibitVisitId=");
        sb.append(exhibitVisitId);
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
        sb.append(", exhibitName=");
        sb.append(exhibitName);
        sb.append(", visitorId=");
        sb.append(visitorId);
        sb.append(", proximity=");
        sb.append(proximity);
        sb.append(", galleryName=");
        sb.append(galleryName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ExhibitVisit toEntityModel() {
        ExhibitVisitImpl exhibitVisitImpl = new ExhibitVisitImpl();

        exhibitVisitImpl.setExhibitVisitId(exhibitVisitId);
        exhibitVisitImpl.setGroupId(groupId);
        exhibitVisitImpl.setCompanyId(companyId);
        exhibitVisitImpl.setUserId(userId);

        if (userName == null) {
            exhibitVisitImpl.setUserName(StringPool.BLANK);
        } else {
            exhibitVisitImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            exhibitVisitImpl.setCreateDate(null);
        } else {
            exhibitVisitImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            exhibitVisitImpl.setModifiedDate(null);
        } else {
            exhibitVisitImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (exhibitName == null) {
            exhibitVisitImpl.setExhibitName(StringPool.BLANK);
        } else {
            exhibitVisitImpl.setExhibitName(exhibitName);
        }

        if (visitorId == null) {
            exhibitVisitImpl.setVisitorId(StringPool.BLANK);
        } else {
            exhibitVisitImpl.setVisitorId(visitorId);
        }

        if (proximity == null) {
            exhibitVisitImpl.setProximity(StringPool.BLANK);
        } else {
            exhibitVisitImpl.setProximity(proximity);
        }

        if (galleryName == null) {
            exhibitVisitImpl.setGalleryName(StringPool.BLANK);
        } else {
            exhibitVisitImpl.setGalleryName(galleryName);
        }

        exhibitVisitImpl.resetOriginalValues();

        return exhibitVisitImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        exhibitVisitId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        exhibitName = objectInput.readUTF();
        visitorId = objectInput.readUTF();
        proximity = objectInput.readUTF();
        galleryName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(exhibitVisitId);
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

        if (exhibitName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(exhibitName);
        }

        if (visitorId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(visitorId);
        }

        if (proximity == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(proximity);
        }

        if (galleryName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(galleryName);
        }
    }
}

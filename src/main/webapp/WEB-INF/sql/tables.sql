create table Museum_ExhibitVisit (
	exhibitVisitId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	exhibitName VARCHAR(75) null,
	visitorId VARCHAR(75) null,
	proximity VARCHAR(75) null,
	galleryName VARCHAR(75) null
);

create table Museum_GalleryVisit (
	galleryVisitId LONG not null primary key,
	galleryName VARCHAR(75) null,
	visitorId VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);
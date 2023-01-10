create table AB_Absli (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	uId VARCHAR(75) null,
	product VARCHAR(75) null,
	agentCode VARCHAR(75) null,
	sourceName VARCHAR(75) null,
	discount BOOLEAN,
	createdBy VARCHAR(75) null
);
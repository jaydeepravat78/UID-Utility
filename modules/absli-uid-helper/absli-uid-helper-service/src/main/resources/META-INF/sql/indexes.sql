create index IX_2E5BF753 on AB_Absli (groupId);
create index IX_4813FF08 on AB_Absli (product[$COLUMN_LENGTH:75$]);
create index IX_DB255AF1 on AB_Absli (sourceName[$COLUMN_LENGTH:75$]);
create index IX_4EFF81C9 on AB_Absli (uId[$COLUMN_LENGTH:75$]);
create index IX_F551ED6B on AB_Absli (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EABCD2AD on AB_Absli (uuid_[$COLUMN_LENGTH:75$], groupId);
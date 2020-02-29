create index IX_901A23A7 on FOO_Faq (groupId);
create index IX_E810FA81 on FOO_Faq (status, groupId);
create index IX_70DE5F97 on FOO_Faq (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_80D7DFD9 on FOO_Faq (uuid_[$COLUMN_LENGTH:75$], groupId);
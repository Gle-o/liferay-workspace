create table FOO_Faq (
	uuid_ VARCHAR(75) null,
	faqId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	title STRING null,
	question STRING null,
	answer STRING null,
	description VARCHAR(75) null
);
create index IX_316B3757 on Faq_Faq (groupId);
create index IX_ABAB5E31 on Faq_Faq (status, groupId);
create index IX_209071E7 on Faq_Faq (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_138A4629 on Faq_Faq (uuid_[$COLUMN_LENGTH:75$], groupId);
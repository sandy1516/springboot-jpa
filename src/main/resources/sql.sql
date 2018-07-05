CREATE DATABASE [Test]


CREATE TABLE [dbo].[user](
	[id] [int] NOT NULL,
	[value] [varchar](255) NULL,
	[name] [varchar](255) NULL)
	
INSERT INTO [Test].[dbo].[user] (id, value,name) VALUES ('1','200','sandy')

INSERT INTO [Test].[dbo].[user] (id, value,name) VALUES ('2','400','muthu')
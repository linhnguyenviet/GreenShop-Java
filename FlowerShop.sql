CREATE DATABASE GreenShop;
GO
USE GreenShop

CREATE TABLE Customer (
	cID int NOT NULL PRIMARY KEY,
	cName nvarchar(50),
	Email nvarchar(50),
	Password nvarchar(50),
	Phone nvarchar(50),
	Address nvarchar(100)

);

CREATE TABLE Category (
	cateID int NOT NULL PRIMARY KEY,
	Name nvarchar(50),
);

CREATE TABLE Flower (
	fID int NOT NULL PRIMARY KEY,
	fName nvarchar(50),
	Quantity nvarchar(50),
	Price float,
	cateID int,
	Img nvarchar(50),
	CONSTRAINT FK_FlowerCategory FOREIGN KEY (cateID) REFERENCES Category (cateID)
);



CREATE TABLE Bill (
	bID int NOT NULL PRIMARY KEY,
	cID int,
	Total float,
	Payment nvarchar(50),
	Bank nvarchar(50),
	Address nvarchar(100),
	Date nvarchar(50),
	CONSTRAINT FK_BillCustomer FOREIGN KEY (cID) REFERENCES Customer (cID)
);

CREATE TABLE BillDetail (
	bDetailID int NOT NULL PRIMARY KEY,
	bID int,
	fID int,
	Price float,
	Quantity int,
	Status nvarchar(50),
	CONSTRAINT FK_BillDetail_Flower FOREIGN KEY (fID) REFERENCES Flower (fID),
	CONSTRAINT FK_BillDetail_Bill FOREIGN KEY (bID) REFERENCES Bill (bID),
);


INSERT INTO Customer(cID,cName,Email,Password,Phone,Address) VALUES ('1','admin','admin','admin',null,null)

INSERT INTO Category(cateID,Name) VALUES ('1',N'Sinh Nhật')
INSERT INTO Category(cateID,Name) VALUES ('2',N'Trang Trí')
INSERT INTO Category(cateID,Name) VALUES ('3',N'Tiệc Cưới')

INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('1',N'Khổng Tước','5','200000','1','./Images/spx2-1.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('2',N'Sơn Liễu','5','200000','2','./Images/spx2-2.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('3',N'Ngâu','5','340000','3','./Images/spx2-3.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('4',N'Bàng Singapore','5','500000','2','./Images/spx2-4.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('5',N'Lan Ý Mỹ','5','430000','1','./Images/spx2-5.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('6',N'Dây Nhện','5','500000','3','./Images/spx2-6.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('7',N'Cỏ Lan Chi','5','500000','1','./Images/spx2-7.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('8',N'Hoa Bỏng','5','250000','3','./Images/spx2-8.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('9',N'Kim Ngân','5','400000','2','./Images/spx2-9.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('10',N'Huy Hoàng','5','420000','2','./Images/spx2-10.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('11',N'Kim Tiền','5','450000','3','./Images/spx2-11.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('12',N'Hồng Môn','5','150000','1','./Images/spx2-12.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('13',N'Lan Chi','5','450000','1','./Images/spx2-13.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('14',N'Lan Ý','5','350000','2','./Images/spx2-14.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('15',N'Lưỡi Hổ','5','480000','1','./Images/spx2-15.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('16',N'Môn Quan Âm','5','140000','2','./Images/spx2-1.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('17',N'Ngọc Ngân','5','300000','3','./Images/spx2-2.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('18',N'Nha Đam','5','500000','1','./Images/spx2-3.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('19',N'Phát Lộc','5','450000','2','./Images/spx2-4.png')
INSERT INTO Flower(fID,fName,Quantity,Price,cateID,Img) VALUES ('20',N'Phú Quý','5','170000','3','./Images/spx2-5.png')
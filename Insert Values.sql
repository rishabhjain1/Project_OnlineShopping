INSERT INTO PRODUCTS (PID,CID,PRODUCT_NAME,PRICE,QUANTITY) VALUES 
(1,3, 'SAMSUNG S7 GOLD', 43000,20),
(2,3, 'SAMSUNG S7 BLACK', 43000,20), 
(3,3, 'IPHONE 6S GOLD 16 GB', 48000,20),
(4,3, 'IPHONE 6S GOLD 32 GB', 55000,20),
(5,3, 'IPHONE 6S GOLD 64 GB', 61000,20),
(6,3, 'IPHONE 6S PLUS GOLD 16 GB', 54000,20),
(7,3, 'IPHONE 6S PLUS GOLD 32 GB', 61000,20),
(8,3, 'IPHONE 6S PLUS GOLD 64 GB', 67000,20),
(9,4, 'INTEX ECO BLACK', 2950,20),
(10,4, 'NOKIA 215 BLACK', 3300,20),
(11,4, 'SAMSUNG METRO XL WHITE', 2700,20),
(12,7, 'VORSON IPHONE 6S BLACK CASE', 480,20),
(13,7, 'CUBIX IPHONE 6S WHITE CASE',220,20),
(14,7, 'SAMSUNG S7 OFFICIAL COVER', 610,20);


INSERT INTO CATEGORY (CID,CATEGORY) VALUES (1, 'ELECTRONICS');
INSERT INTO CATEGORY (CID,CATEGORY,PARENT_CATEGORY) VALUES (2, 'MOBILE', 'ELECTRONICS'),
 (3,'SMARTPHONES','MOBILE'),
 (4,'FEATURE PHONES', 'MOBILE'),
 (5,'MOBILE ACCESORIES','MOBILE'),
 (6,'HEADPHONES','MOBILE ACCESORIES'),
 (7,'CASES','MOBILE ACCESORIES'), 
 (8, 'LAPTOP', 'ELECTRONICS');
 
 INSERT INTO CATEGORY_ATTRIBUTE(CID, ATTRIBUTE) VALUES (3,'COLOUR'),(3, 'SIZE'),(3, 'PROCESSOR'),(3, 'OS'),(3, 'RAM'), (3,'STORAGE_CAPACITY'),
 (4,'COLOUR'),(4, 'SIZE'), (4,'BATTERY_CAPACITY'),
 (7,'COLOUR'),(7,'TYPE');

 INSERT INTO ATTRIBUTE_VALUES (PID,ATTRIBUTE,ATT_VALUE) VALUES
(1,'COLOUR','Gold'), (1,'SIZE','5.1 Inches'),(1,'PROCESSOR', 'Exynos 8890'), (1,'OS','Android M'),(1,'RAM', '4 GB'),(1,'STORAGE_CAPACITY' ,'32 GB'),
(2,'COLOUR','BLACK'), (2,'SIZE','5.1 Inches'),(2,'PROCESSOR', 'Exynos 8890'), (2,'OS','Android M'),(2,'RAM', '4 GB'),(2,'STORAGE_CAPACITY', '32 GB'),
(3,'COLOUR','GOLD'), (3,'SIZE','4.7 Inches'),(3,'PROCESSOR', 'Twister'), (3,'OS','IOS 7'),(3,'RAM', '2 GB'),(3,'STORAGE_CAPACITY', '16 GB'),
(4,'COLOUR','GOLD'), (4,'SIZE','4.7 Inches'),(4,'PROCESSOR', 'Twister'), (4,'OS','IOS 7'),(4,'RAM', '2 GB'),(4,'STORAGE_CAPACITY', '32 GB'),
(5,'COLOUR','GOLD'), (5,'SIZE','4.7 Inches'),(5,'PROCESSOR', 'Twister'), (5,'OS','IOS 7'),(5,'RAM', '2 GB'),(5,'STORAGE_CAPACITY', '64 GB'),
(6,'COLOUR','GOLD'), (6,'SIZE','5.1 Inches'),(6,'PROCESSOR', 'Twister'), (6,'OS','IOS 7'),(6,'RAM', '2 GB'),(6,'STORAGE_CAPACITY', '16 GB'),
(7,'COLOUR','GOLD'), (7,'SIZE','5.1 Inches'),(7,'PROCESSOR', 'Twister'), (7,'OS','IOS 7'),(7,'RAM', '2 GB'),(7,'STORAGE_CAPACITY', '32 GB'),
(8,'COLOUR','GOLD'), (8,'SIZE','5.1 Inches'),(8,'PROCESSOR', 'Twister'), (8,'OS','IOS 7'),(8,'RAM', '2 GB'),(8,'STORAGE_CAPACITY', '64 GB'),
(9,'COLOUR','BLACK'), (9,'SIZE','1.8 Inches'),(9,'BATTERY_CAPACITY','800 mAH'),
(10,'COLOUR','BLACK'), (10,'SIZE','2.4 Inches'),(10,'BATTERY_CAPACITY','1100 mAH'),
(11,'COLOUR','WHITE'), (11,'SIZE','3.3 Inches'),(11,'BATTERY_CAPACITY','1200 mAH'),
(12,'COLOUR','WHITE'), (12,'TYPE', 'BACK COVER'),
(13,'COLOUR','SILVER'), (13,'TYPE', 'FLIP COVER')
;

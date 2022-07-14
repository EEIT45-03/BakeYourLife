--新增小農廠商資料
SET
IDENTITY_INSERT [dbo].[farmers] ON

INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username]) VALUES (1, N'320桃園市中壢區新生路二段421號', N'ROLE_FARMER', N'ddfoew133@gmail.com', N'123', N'聖德小農', N'https://i.imgur.com/xZPc9iL.jpg', N'$2a$10$/8NjHp7kfnUPJhqjh3isaOXMrYTGIq89dmDoF4XvO5hY2gifSSxZu', N'0998765432', CAST(N'2022-07-14T10:16:40.5780000' AS DateTime2), N'a123456')
SET IDENTITY_INSERT [dbo].[farmers] OFF

--新增小農商品資料
SET IDENTITY_INSERT [dbo].[farmer_product] ON

INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time]) VALUES (1, N'中、大果規格：8~9入裝', N'★我們推薦大熊農場愛文芒果的理由
■草生栽培安全用藥
■甜度高 香氣足 果肉細緻
■通過屏科大 381項農藥殘留檢驗
■經產銷履歷驗證', CAST(N'2022-07-11T09:27:33.5870000' AS DateTime2), N'愛文芒果5斤(8~9入)禮盒裝', 799, 200, 0, N'冰箱冷藏', NULL, N'水果類', NULL)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time]) VALUES (2, N'水蜜桃12入裝 (約3台斤)', N'★我們推薦養老部落水蜜桃的理由
■來自氣候宜人日照充足的尖石鄉
■友善種植不施除草劑
■皮薄肉嫩 香甜多汁
■通過環虹錕騰科技驗證H200617-003-01-A1', CAST(N'2022-07-11T09:28:57.2940000' AS DateTime2), N'養老部落高山蜜桃12粒裝', 450, 50, 0, N'冰箱冷藏', NULL, N'水果類', NULL)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time]) VALUES (3, N'936ml牛乳x3瓶', N'★新生活鮮乳，符合CNS中華民國國家標準，生產過程從生乳殺菌至完成產品，絕無添加任何添加物及成分調整，如防腐劑、乳化劑、消泡劑、奶粉等，是全國唯一用法律責任向消費者保證，若宣告不實每瓶賠償新台幣一百萬元，讓您喝的健康又安心!', CAST(N'2022-07-11T09:30:35.6370000' AS DateTime2), N'新生活純牛乳 936ml 3瓶裝', 199, 30, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time]) VALUES (4, N'烘焙咖啡豆5包，每包200g', N'由無名黑鐵老闆依產季及每批咖啡豆品質挑選混合成完美的口味，並依季節調整烘焙度。是最能品嚐出咖啡師傅功力與品味的招牌!
★咖啡豆皆採新鮮烘焙，出貨時間會受天候因素影響，還請您見諒!
★考量保鮮不易，恕無法提供磨粉服務。
★每月月底現烘出貨，如欲購買請先向客服人員詢問出貨時間', CAST(N'2022-07-11T09:31:25.1630000' AS DateTime2), N'招牌綜合咖啡豆 200g x 5包', 300, 300, 0, N'放置陰涼處', NULL, N'咖啡豆類', NULL)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time]) VALUES (5, N'原片茶葉，單罐50g', N'清晨採摘掛著露水的新鮮桂花，製茶師以古老精湛的工藝渥堆花與茶，層層交錯堆疊，使茶葉充分吸收花香，烘焙乾燥製成清新脫俗的桂花鐵觀音。

以新鮮的桂花烘焙鐵觀音，風味色澤不像混以乾燥花入茶般的濃烈鮮豔。反之，伴隨一股清新雅致，餘韻不絕的淡淡花香，為醇厚的鐵觀音，注入一抹淡雅悠長的曼妙風味。', CAST(N'2022-07-11T09:32:19.6490000' AS DateTime2), N'手採桂花鐵觀音', 89, 100, 0, N'放置陰涼處', NULL, N'茶葉類', NULL)
SET IDENTITY_INSERT [dbo].[farmer_product] OFF

SET IDENTITY_INSERT [dbo].[farmer_product_pic] ON

INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (1, N'https://i.imgur.com/0FbGVHs.jpg', 1)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (2, N'https://i.imgur.com/uSqP8yF.jpg', 1)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (3, N'https://i.imgur.com/q7LLcNd.jpg', 1)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (4, N'https://i.imgur.com/gYcdU2s.jpg', 2)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (5, N'https://i.imgur.com/dmvlkem.jpg', 2)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (6, N'https://i.imgur.com/i11nx6a.jpg', 2)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (7, N'https://i.imgur.com/L6QD7Pg.jpg', 3)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (8, N'https://i.imgur.com/TpzUEAu.jpg', 3)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (9, N'https://i.imgur.com/EcyAcbT.jpg', 3)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (10, N'https://i.imgur.com/ilEoDGC.jpg', 4)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (11, N'https://i.imgur.com/Sgzn03L.jpg', 5)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (12, N'https://i.imgur.com/VZ9pxvl.jpg', 5)
SET IDENTITY_INSERT [dbo].[farmer_product_pic] OFF



--新增會員資料
INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url) VALUES (N'桃園市楊梅區中山路121巷4弄9號', N'1994-09-19', N'vison919@gmail.com', N'管理者', N'男', N'$2a$10$gZpVFhR6Qxp.EC4AP1s9HO0ZcLBgJlVZ8p4mQ4RyWTkGLXxybkaO2', N'0918583187', GETDATE(), N'user',N'ROLE_ADMIN',N'https://i.imgur.com/BhAxrqk.jpg')

--新增場地
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes) VALUES (15,'A201',30,'https://i.imgur.com/ZjKfu38.jpg',NULL);
INSERT INTO venue(person_max, venue_name, hr_price, picture, notes)
VALUES (15, 'A202', 30, 'https://i.imgur.com/4KAEu5T.jpg', NULL);
INSERT INTO venue(person_max, venue_name, hr_price, picture, notes)
VALUES (15, 'A203', 30, 'https://i.imgur.com/WTCSrKe.jpg', NULL);
INSERT INTO venue(person_max, venue_name, hr_price, picture, notes)
VALUES (10, 'B201', 30, 'https://i.imgur.com/ecdjZkm.jpg', NULL);
INSERT INTO venue(person_max, venue_name, hr_price, picture, notes)
VALUES (12, 'B202', 30, 'https://i.imgur.com/i0z2ejz.jpg', NULL);
INSERT INTO venue(person_max, venue_name, hr_price, picture, notes)
VALUES (15, 'B203', 30, 'https://i.imgur.com/RjYjbA5.jpg', NULL);


--新增器具類別
INSERT INTO tackle_sort(sort)
VALUES ('烤箱');
INSERT INTO tackle_sort(sort)
VALUES ('攪拌器');
INSERT INTO tackle_sort(sort)
VALUES ('刮刀');

--新增器具
INSERT INTO tackle(damages, day_price, max, notes, picture, specification, tackle_name, fk_sort_id)
VALUES (1200, 50, 50, NULL, 'https://i.imgur.com/S3DqPbq.png', 'PANASONIC NBH3200', '32L電烤箱', 1);
INSERT INTO tackle(damages, day_price, max, notes, picture, specification, tackle_name, fk_sort_id)
VALUES (1500, 50, 50, NULL, 'https://i.imgur.com/3KpunET.png', 'PANASONIC NB-H3801', '38L電烤箱', 1);
INSERT INTO tackle(damages, day_price, max, notes, picture, specification, tackle_name, fk_sort_id)
VALUES (500, 50, 50, NULL, 'https://i.imgur.com/J2wbBdf.png', 'PANASONIC MX-SS2', '手持式攪拌棒', 2);
INSERT INTO tackle(damages, day_price, max, notes, picture, specification, tackle_name, fk_sort_id)
VALUES (200, 30, 80, NULL, 'https://i.imgur.com/4P4hQAU.png', 'SN4889', '打蛋器', 2);
INSERT INTO tackle(damages, day_price, max, notes, picture, specification, tackle_name, fk_sort_id)
VALUES (100, 25, 100, NULL, 'https://i.imgur.com/9Mi01IL.png', 'CakeLand', '矽膠刮刀', 3);

--新增訂單資料
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date,
                    shipping_fee, total_price, tracking_number, code, user_id)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-07-06T22:35:24.6900000' AS DateTime2), N'202207062235245', N'完成',
        CAST(N'2022-07-06T22:35:57.5750000' AS DateTime2), 0, CAST(N'2022-07-06T22:42:52.8590000' AS DateTime2), 100,
        899, N'111111111111', NULL, 1)
    INSERT
INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee,
             total_price, tracking_number, code, user_id, refund_reason)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST (N'2022-06-06T22:36:13.6490000' AS DateTime2), N'202207062236137', N'退款審核中', CAST (N'2022-07-06T22:36:33.0420000' AS DateTime2), 1, CAST (N'2022-07-06T22:42:56.1490000' AS DateTime2), 100, 899, N'', NULL, 1, '等太久')
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date,
                    shipping_fee, total_price, tracking_number, code, user_id, refund_reason)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST (N'2022-05-06T22:37:36.7950000' AS DateTime2), N'202207062237369', N'退款審核中', CAST (N'2022-07-06T22:38:01.3090000' AS DateTime2), 0, NULL, 100, 1698, NULL, NULL, 1, '我不想買了')
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date,
                    shipping_fee, total_price, tracking_number, code, user_id)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST (N'2022-04-06T22:38:22.6500000' AS DateTime2), N'202207062238220', N'待出貨', CAST (N'2022-07-06T22:38:34.1380000' AS DateTime2), 1, CAST (N'2022-07-06T22:43:00.0770000' AS DateTime2), 100, 2497, N'', NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date,
                    shipping_fee, total_price, tracking_number, code, user_id)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST (N'2022-03-06T22:38:54.8850000' AS DateTime2), N'202207062238548', N'待付款', NULL, 0, NULL, 100, 899, NULL, NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date,
                    shipping_fee, total_price, tracking_number, code, user_id)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST (N'2022-02-06T22:39:13.2840000' AS DateTime2), N'202207062239134', N'待出貨', CAST (N'2022-07-06T22:39:22.9590000' AS DateTime2), 1, CAST (N'2022-07-06T22:43:03.0060000' AS DateTime2), 100, 899, N'', NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date,
                    shipping_fee, total_price, tracking_number, code, user_id)
VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST (N'2022-01-06T22:40:25.7620000' AS DateTime2), N'202207062240251', N'待出貨', CAST (N'2022-07-06T22:40:46.1170000' AS DateTime2), 0, CAST (N'2022-07-06T22:43:08.5550000' AS DateTime2), 100, 899, N'', NULL, 1)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 1)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 2)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 2, 1598, 3)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 3, 2397, 4)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 5)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 6)
INSERT INTO order_item (product_name, product_no, product_type, qty, sub_total, order_id)
VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 7)

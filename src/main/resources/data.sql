--新增小農廠商資料
SET IDENTITY_INSERT [dbo].[farmers] ON
INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username],[enabled]) VALUES (1, N'320桃園市中壢區新生路二段421號', N'ROLE_FARMER', N'vison919@gmail.com', N'農場位於桃園聖德山後山山腳下，長年使用天然的山泉水灌概，以友善的方式涵養土壤，使果園孕育出優質的有機水果。', N'聖德小農', N'https://i.imgur.com/H6pJVIo.png', N'$2a$10$/8NjHp7kfnUPJhqjh3isaOXMrYTGIq89dmDoF4XvO5hY2gifSSxZu', N'0998765432', CAST(N'2022-07-14T10:16:40.5780000' AS DateTime2), N'a123456',N'1')
INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username],[enabled]) VALUES (2, N'320桃園市中壢區新生路一段777號', N'ROLE_FARMER', N'garyfarm@gmail.com', N'李老夫婦倆經營二十餘年的農場，共有六甲地，從慣形農法轉作為有機農法，最重要的動力，就是希望回歸自然。', N'Gary''s Farm', N'https://i.imgur.com/diiOEEN.jpg', N'$2a$10$CN/uDEjDWYUXZ1c7cqRxcuSNc47tp51ncpAQyn3R7TRl1qZQWy8jq', N'0963524152', CAST(N'2022-07-18T17:28:30.2970000' AS DateTime2), N'b123456',N'1')
INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username],[enabled]) VALUES (3, N'320桃園市中壢區新生路八段763號', N'ROLE_FARMER', N'c8763@gmail.com', N'快還要更快，磨豆還要哭!!', N'星爆咖啡', N'https://i.imgur.com/a4a2ayg.jpg', N'$2a$10$.QjkVdYrsOw5aBAQeZi0H.smojiuZ8t1r/.A/1CwgtDqOBP8TFK1G', N'0987878763', CAST(N'2022-07-18T17:32:23.6960000' AS DateTime2), N'c123456',N'1')
INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username],[enabled]) VALUES (4, N'320桃園市中壢區新生路二段45號', N'ROLE_FARMER', N'eeit45tea@gmail.com', N'茶~', N'EEIT45 TEA', N'https://i.imgur.com/Tvs3Rrb.jpg', N'$2a$10$7XGw4/D8OkLHFsn086NbOuJ.Tj02hXHsrlU3X/3ojrzH3yktJbW2G', N'0965454587', CAST(N'2022-07-18T17:34:00.5990000' AS DateTime2), N'd123456',N'1')
INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username],[enabled]) VALUES (5, N'320桃園市中壢區新生路六段666號', N'ROLE_FARMER', N'ispanvegetable@gmail.com', N'只提供無毒蔬菜，用心堅持四十五代的農場', N'資展蔬果', N'https://i.imgur.com/b2Zen1G.jpg', N'$2a$10$g2L1wVp5ZZxXyMYSIQ3gq.GGoqqFTxCZgNbyucPEijxiwk6MIhIPq', N'0965658789', CAST(N'2022-07-18T17:36:48.3310000' AS DateTime2), N'e123456',N'1')
INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username],[enabled]) VALUES (6, N'320桃園市中壢區新生路二段204號', N'ROLE_FARMER', N'204milk@gmail.com', N'以給自家人喝的心情，將台灣最高品質的鮮奶，以最嚴格自然的生產流程，新鮮供應給每一個期待天然無添加食品的家庭。', N'204牧場', N'https://i.imgur.com/QvKy87p.jpg', N'$2a$10$DTq0rKfoi6z9.YcCFz7SYeQJpG9LnpnYV8lqWdadSUkdRWwHdzmuO', N'0920204204', CAST(N'2022-07-18T17:38:23.9170000' AS DateTime2), N'f123456',N'1')
SET IDENTITY_INSERT [dbo].[farmers] OFF

--一般商品

SET IDENTITY_INSERT [dbo].[member_goods_table3] ON

INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (1, CAST(N'2022-07-17T15:59:46.5650000' AS DateTime2), N'6', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/z2JaiX7.jpg,https://i.imgur.com/Ez9ThcI.jpg,https://i.imgur.com/MT924wB.jpg', N'北海道優質麵粉', N'日本', N'麵粉', N'59', N'否', N'2023-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (2, CAST(N'2022-07-18T11:12:45.7810000' AS DateTime2), N'33', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/xddgnal.jpg,https://i.imgur.com/XTb16wM.jpg,https://i.imgur.com/XPVD7xN.jpg', N'巧克力', N'台灣', N'巧克力', N'92', N'是', N'2023-07-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (3, CAST(N'2022-07-17T15:59:58.6740000' AS DateTime2), N'81', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/dYjHIAM.jpg,https://i.imgur.com/4QkXZGZ.jpg,https://i.imgur.com/obvVijn.jpg', N'乳酪蛋糕', N'紐西蘭', N'乳製品', N'159', N'否', N'2023-08-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (4, CAST(N'2022-07-21T21:41:36.5150000' AS DateTime2), N'49', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/4Ccy2GF.jpg,https://i.imgur.com/2LTuRm0.jpg,https://i.imgur.com/VaM8Xom.jpg', N'玫瑰鹽', N'日本', N'頂級鹽品', N'180', N'否', N'2023-09-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (5, CAST(N'2022-07-18T11:23:11.2240000' AS DateTime2), N'46', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/E0m0Leh.jpg,https://i.imgur.com/VWtSK8Z.jpg,https://i.imgur.com/tj8EvAT.jpg', N'堅果', N'日本', N'堅果乾', N'96', N'否', N'2023-10-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (18, CAST(N'2022-07-17T16:00:19.6520000' AS DateTime2), N'7', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/C1a4sa7.jpg,https://i.imgur.com/mMyE7ml.jpg,https://i.imgur.com/yvqQIlh.jpg', N'高筋麵粉', N'日本', N'麵粉', N'100', N'否', N'2023-11-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (19, CAST(N'2022-07-17T16:00:25.6360000' AS DateTime2), N'9', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉、茶葉', NULL, N'https://i.imgur.com/f6kfTrz.jpg,https://i.imgur.com/cpJfwpx.jpg,https://i.imgur.com/lgHfZu4.jpg', N'山茶花麵粉', N'台灣', N'麵粉', N'66', N'否', N'2023-12-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (20, CAST(N'2022-07-17T16:00:32.3320000' AS DateTime2), N'4', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/ET2w8Yp.jpg,https://i.imgur.com/qA9JoWz.jpg,https://i.imgur.com/ESgHOAH.jpg', N'沖繩高筋麵粉', N'日本', N'麵粉', N'165', N'否', N'2023-01-04', N'冷藏', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (21, CAST(N'2022-07-17T16:00:39.1940000' AS DateTime2), N'4', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/XcmhNzV.jpg,https://i.imgur.com/ZyAxPQq.jpg,https://i.imgur.com/V2bfFY3.jpg', N'江西製麵粉', N'浙江', N'麵粉', N'57', N'否', N'2023-02-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (22, CAST(N'2022-07-17T16:00:45.2050000' AS DateTime2), N'1', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/XZTsagO.jpg,https://i.imgur.com/EVd5h11.jpg,https://i.imgur.com/wJiMsN4.jpg', N'黑龍麵粉', N'日本', N'麵粉', N'119', N'否', N'2023-03-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (23, CAST(N'2022-07-17T16:00:56.0950000' AS DateTime2), N'7', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/2rWuweQ.jpg,https://i.imgur.com/693zedW.jpg,https://i.imgur.com/UFuhUe2.jpg', N'義大利麵粉', N'義大利', N'麵粉', N'167', N'否', N'2023-04-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (24, CAST(N'2022-07-17T16:01:48.7440000' AS DateTime2), N'6', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/a3R21ka.jpg,https://i.imgur.com/7gcH9Vr.jpg,https://i.imgur.com/kKT0bol.jpg', N'中筋麵粉', N'日本', N'麵粉', N'37', N'否', N'2023-05-07', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (25, CAST(N'2022-07-17T16:01:15.8370000' AS DateTime2), N'7', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/rKDiJHE.jpg,https://i.imgur.com/tQ4fPDw.jpg,https://i.imgur.com/zPfJnWl.jpg', N'低筋麵粉', N'日本', N'麵粉', N'69', N'否', N'2023-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (26, CAST(N'2022-07-18T11:13:18.2320000' AS DateTime2), N'33', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/o5drCcA.jpg,https://i.imgur.com/g5D6GFN.jpg,https://i.imgur.com/dbxAkns.jpg', N'法式巧克力', N'法國', N'巧克力', N'144', N'否', N'2023-07-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (27, CAST(N'2022-07-18T11:19:45.7580000' AS DateTime2), N'12', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'可可粉', NULL, N'https://i.imgur.com/3ON9ZKa.jpg,https://i.imgur.com/wDHsKSa.jpg,https://i.imgur.com/1MEH0pk.jpg', N'義大利經典巧克力', N'義大利', N'巧克力', N'67', N'否', N'2023-08-07', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (28, CAST(N'2022-07-18T11:20:09.0310000' AS DateTime2), N'80', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/6mCfJl1.jpg,https://i.imgur.com/gp3igHw.jpg,https://i.imgur.com/JfNofAT.jpg', N'南非經典巧克力', N'南非', N'巧克力', N'159', N'否', N'2023-09-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (29, CAST(N'2022-07-18T11:20:33.4200000' AS DateTime2), N'33', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/xuPuF1R.jpg,https://i.imgur.com/zFSAdVV.jpg,https://i.imgur.com/k25MNWf.jpg', N'巴西黑巧克力', N'巴西', N'巧克力', N'201', N'否', N'2030-10-04', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (30, CAST(N'2022-07-18T11:21:48.0520000' AS DateTime2), N'87', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/P1vsqXB.jpg,https://i.imgur.com/zTq4Rn4.jpg,https://i.imgur.com/Ye6rBk6.jpg', N'西班牙純巧克力', N'西班牙', N'巧克力', N'259', N'否', N'2023-12-15', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (31, CAST(N'2022-07-18T11:27:19.4570000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'草莓', NULL, N'https://i.imgur.com/oIXrQlA.jpg,https://i.imgur.com/0qS9n97.jpg,https://i.imgur.com/HGsoPVl.jpg', N'草莓醬', N'日本', N'抹醬', N'59', N'是', N'2023-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (32, CAST(N'2022-07-21T21:41:19.6310000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/RSywQX9.jpg,https://i.imgur.com/kpx2jrF.jpg,https://i.imgur.com/ScvSQS4.jpg', N'經典香料', N'日本', N'嚴選香料', N'59', N'否', N'2023-04-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (33, CAST(N'2022-07-21T21:41:06.1670000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/k4yPbyu.jpg,https://i.imgur.com/MlSZcmC.jpg,https://i.imgur.com/AmZeWSR.jpg', N'經典彩糖', N'日本', N'彩糖', N'59', N'否', N'2023-07-15', N'常溫', NULL, N'上架中')
SET IDENTITY_INSERT [dbo].[member_goods_table3] OFF


--新增小農商品資料
SET IDENTITY_INSERT [dbo].[farmer_product] ON

INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (1, N'中、大果規格：8~9入裝', N'★我們推薦大熊農場愛文芒果的理由
■草生栽培安全用藥
■甜度高 香氣足 果肉細緻
■通過屏科大 381項農藥殘留檢驗
■經產銷履歷驗證', CAST(N'2022-07-11T09:27:33.5870000' AS DateTime2), N'愛文芒果5斤(8~9入)禮盒裝', 799, 200, 0, N'冰箱冷藏', NULL, N'水果類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (2, N'水蜜桃12入裝 (約3台斤)', N'★我們推薦養老部落水蜜桃的理由
■來自氣候宜人日照充足的尖石鄉
■友善種植不施除草劑
■皮薄肉嫩 香甜多汁
■通過環虹錕騰科技驗證H200617-003-01-A1', CAST(N'2022-07-11T09:28:57.2940000' AS DateTime2), N'養老部落高山蜜桃12粒裝', 450, 50, 0, N'冰箱冷藏', NULL, N'水果類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (3, N'936ml牛乳x3瓶', N'★新生活鮮乳，符合CNS中華民國國家標準，生產過程從生乳殺菌至完成產品，絕無添加任何添加物及成分調整，如防腐劑、乳化劑、消泡劑、奶粉等，是全國唯一用法律責任向消費者保證，若宣告不實每瓶賠償新台幣一百萬元，讓您喝的健康又安心!', CAST(N'2022-07-11T09:30:35.6370000' AS DateTime2), N'新生活純牛乳 936ml 3瓶裝', 199, 30, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (4, N'烘焙咖啡豆5包，每包200g', N'由無名黑鐵老闆依產季及每批咖啡豆品質挑選混合成完美的口味，並依季節調整烘焙度。是最能品嚐出咖啡師傅功力與品味的招牌!
★咖啡豆皆採新鮮烘焙，出貨時間會受天候因素影響，還請您見諒!
★考量保鮮不易，恕無法提供磨粉服務。
★每月月底現烘出貨，如欲購買請先向客服人員詢問出貨時間', CAST(N'2022-07-11T09:31:25.1630000' AS DateTime2), N'招牌綜合咖啡豆 200g x 5包', 300, 300, 0, N'放置陰涼處', NULL, N'咖啡豆類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (5, N'原片茶葉，單罐50g', N'清晨採摘掛著露水的新鮮桂花，製茶師以古老精湛的工藝渥堆花與茶，層層交錯堆疊，使茶葉充分吸收花香，烘焙乾燥製成清新脫俗的桂花鐵觀音。

以新鮮的桂花烘焙鐵觀音，風味色澤不像混以乾燥花入茶般的濃烈鮮豔。反之，伴隨一股清新雅致，餘韻不絕的淡淡花香，為醇厚的鐵觀音，注入一抹淡雅悠長的曼妙風味。', CAST(N'2022-07-11T09:32:19.6490000' AS DateTime2), N'手採桂花鐵觀音', 89, 100, 0, N'放置陰涼處', NULL, N'茶葉類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (6, N'紅鬚玉米筍(帶殼)6斤裝', N'最熱銷品項-紅鬚玉米筍強勢來襲，擁有玉米的香甜卻搭配爽脆口感。玉米筍通常是玉米成熟前的果穗，富含維生素、及胺基酸，營養多熱量也不高。但紅鬚玉米筍為專門的玉米筍品種，又脆又甜，在市場相當受消費者歡迎。', CAST(N'2022-07-18T18:27:19.4530000' AS DateTime2), N'【無毒紅鬚帶殼玉米筍6斤裝】', 550, 600, 0, N'冰箱冷藏', NULL, N'蔬菜類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (7, N'紅肉紅龍果5斤±5%', N'★我們推薦妞妞果紅龍果的理由
■友善環境 草生栽培
■彰化縣107~110年度紅龍果評鑑比賽年年得獎
■有產銷履歷可追溯(EG-180408T1Z)

紅肉紅龍果，果實甜度佳且均勻，帶紅龍果特殊香氣。香甜可口多汁鮮美，每一口都是好滋味！

妞妞果園位於彰化福興鄉，自製益生菌噴灌，採用有機質活化土壤，友善環境，草生栽培，
在食安風暴下，陳大哥希望提供給每位消費者，安心、自然、健康的紅龍果。', CAST(N'2022-07-18T18:27:59.9280000' AS DateTime2), N'【產銷履歷紅龍果(紅肉5斤裝)】', 520, 400, 0, N'冰箱冷藏', NULL, N'水果類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (8, N'貓貓1隻', N'有點傷心的貓咪', CAST(N'2022-07-11 09:27:35.1780000' AS DateTime2), N'小貓咪', 500, 1, 0, N'放置陰涼處', NULL, N'牛奶類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (9, N'紅鑽芭樂5斤裝(約5-8顆)', N'★為什麼我們強力推薦綠創頂級芭樂呢？
■ 拒用除草劑，愛地球愛健康
■ 口感清脆香甜，讓人一再回味
■ 使用高成本有機肥，確保植株養分健康成長

紅鑽石芭樂市面上相當稀少，不好種植！果肉呈現紅色，細緻甘甜，籽非常少，有一種淡淡的花果香，口感清脆、有十分香濃的芭樂味，與白心芭樂截然不同～超涮嘴的酸甜比，絕對讓您一口接一口停不下來，沒吃過的您一定要試試！更是中醫藥材指定藥用水果，富含維生素C及多重的抗氧化成分，是水果當中的抗氧化之王哦。', CAST(N'2022-07-18T18:28:42.0000000' AS DateTime2), N'【紅鑽石芭樂5斤裝(約5-8顆)】', 765, 650, 0, N'冰箱冷藏', NULL, N'水果類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (10, N'930cc鮮乳x3瓶', N'★為什麼我們推薦五梅牧場?

全台灣眾多牧場，僅有不到5%能榮獲農委會評鑑為特優的五梅獎牧場，能三度獲頒的牧場更是鳳毛麟角!

牧場要在生乳品質、經營效益、飼養管理、疾病防治、環境衛生等各方面都能維持特優水準，除了飼養環境要青山綠水無汙染，更仰賴來自以色列，高科技的牛隻健康管理系統，透過牛隻身上的無線傳輸監控環，掌握每頭牛的活動量、飲食及健康狀況，比對生乳品質後，才能針對個別狀況給予最適當的照顧，確保每滴鮮乳都維持最佳品質。

五梅牧場鮮乳品質保證:
1.100%來自五梅獎牧場的生乳，不加一滴水。
2.決不經人工修飾，不添加人工乳化劑及消泡劑，成分無調整。
3.經檢驗無抗生素及磺胺劑殘留', CAST(N'2022-07-18T18:29:42.8810000' AS DateTime2), N'【五梅鮮奶 930cc 3瓶組】', 425, 425, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (11, N'100g/包', N'★有機農產品驗證字號：1-009-110213

綠茶帶著鮮甜的青草香、淡淡的海苔鮮、微微的甘蔗味，聞得到茶園新鮮氣息，不發酵的製作過程保留更多營養價值，低溫浸泡，不苦不澀，適合全家大小一起飲用，其中茶葉中的營養成分價值高。

◎品種：金萱
◎發酵程度：無發酵
◎烘焙程度：輕烘焙', CAST(N'2022-07-18T20:34:10.0990000' AS DateTime2), N'【醜醜茶 有機綠茶100g】', 900, 300, 0, N'放置陰涼處', NULL, N'茶葉類', NULL, 1)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (12, N'咖啡豆220g(半磅)', N'【非洲之王 艾達多(Adado) 水洗】
花香氣、柑橘、伯爵茶、蘋果酸、蜂蜜甜、及回甘的水果香甜
■ 處理方式：水洗(純淨超清爽山泉水)
■ 品種：衣索比亞原生種 Heirloom

包裝材料：牛皮紙包裝
烘焙方式：一爆密爆後40秒下豆
養豆方式：烘焙完成日期五天後才可以打開飲用', CAST(N'2022-07-18T21:09:29.9310000' AS DateTime2), N'【非洲之王 艾達多(Adado) 水洗豆 220g裝】', 300, 800, 0, N'放置陰涼處', NULL, N'咖啡豆類', NULL, 2)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (13, N'水蜜桃6入裝 (約187.5g±20g/顆)', N'★我們推薦黃家水蜜桃的理由
■為保鮮度 每日清晨採收出貨
■使用植物性基肥 甜度自然不膩口
■嬌嫩欲滴 果香迷人

梨山擁有得天獨厚的生長條件，因海拔高日夜溫差大加上豐富的天然資源，所孕育出的水蜜桃口感鮮嫩多汁、果肉綿密細緻，濃郁的水蜜桃香氣讓人驚嘆。

黃爸爸每日清晨五點，必須趕在太陽還沒起床就上工採收水蜜桃，因為此時摘採的水蜜桃最新鮮，並趕在中午前分級、包裝、宅配，每到七、八月份黃爸爸都要跟時間賽跑，為的就是希望把最新鮮的水蜜桃送到消費者手上。', CAST(N'2022-07-18T21:10:22.7260000' AS DateTime2), N'【超人氣！梨山特有 上海水蜜桃6入裝】', 820, 620, 0, N'放置陰涼處', NULL, N'水果類', NULL, 2)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (14, N'鮮乳大罐(936ml) x 8', N'★因夏季炎熱，特別提醒您要注意鮮乳的保存:
1.收到鮮乳後，請立刻放入冰箱冷藏。
2.最佳冷藏溫度是4度C，鮮乳盡量放置在冷藏的上層(避免放冰箱門)。
3.離開冷藏請不要超過15分鐘。', CAST(N'2022-07-18T21:10:54.9200000' AS DateTime2), N'【鮮奶訂閱組合C- 8大罐】', 860, 500, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 2)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (15, N'1kg盒裝9~9.5row', N'■ 來自美國西北部 著名產區
■ 世界上口感與色澤最好的櫻桃之一
■ 夏季盛產 現在吃 正當季

美國西北櫻桃，不是指品種，是指美國華盛頓州、俄勒崗州、愛達荷州及猶他州所產的櫻桃。這四州位於美國西北部，因此稱為西北櫻桃。因美國西北部絕佳的氣候、地理環境，世界上首屈一指的栽種技術，再經過美國農業單位嚴格檢驗、農場專業篩選，讓西北櫻桃聞名世界，更被稱為世界上口感與色澤最好的櫻桃之一。

西北櫻桃表皮光澤透亮，果肉結實又具彈性，夏季是西北櫻桃的產季，一年只有一次，請把握品嚐這富含鐵質的水果。進口水果皆通過政府進口檢驗規範，請安心購買，開心品嚐。', CAST(N'2022-07-18T21:11:28.0000000' AS DateTime2), N'【水果中的鑽石 美國西北櫻桃1kg裝】', 1200, 1000, 0, N'冰箱冷藏', NULL, N'水果類', NULL, 2)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (16, N'烘焙咖啡豆454g×5包，單向排氣閥包裝。', N'由封閉者依產季及每批咖啡豆品質挑選混合成完美的口味，並依季節調整烘焙度。是最能品嚐出咖啡師傅功力與品味的招牌!', CAST(N'2022-07-18T21:26:11.7250000' AS DateTime2), N'【商用綜合咖啡豆 454g×5包】', 2300, 200, 0, N'放置陰涼處', NULL, N'咖啡豆類', NULL, 3)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (17, N'300公克(20公克x15入/包)', N'銷售第一名，最好喝，超便宜，不怕您比較。
★獨一無二的異國風味咖啡，媲美經典拿鐵、卡布基諾。
★無加糖、沒有焦苦與酸澀味、最佳黃金比例口感。
★味道濃純，口感香滑，濃郁的香氣更是令人回味無窮。
★最好喝，超便宜，以台灣人口感喜好調配的咖啡。', CAST(N'2022-07-18T21:32:40.1900000' AS DateTime2), N'【二合一無加糖白咖啡(20gx15入/包)】', 160, 1200, 0, N'放置陰涼處', NULL, N'咖啡豆類', NULL, 3)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (18, N'咖啡豆763g', N'濃郁複雜的花香、莓果、葡萄、黑嘉麗軟糖、多層次水果風味、層次飽滿豐富。', CAST(N'2022-07-18T21:33:39.9770000' AS DateTime2), N'【星爆精選 星爆豆 763g裝】', 8763, 8763, 0, N'放置陰涼處', NULL, N'咖啡豆類', NULL, 3)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (19, N'3.5g/包；共30包/盒', N'選用陳期已逾16年的熟茶為原料製作，歷經時間淬鍊茶湯口感醇和飽滿，茶香帶棗乾、糯米及熟茶茶香，水甜滑順，口尾回甘度佳，熟茶的溫暖與醇和，飯後來上一杯，是生活美麗的點綴。

特別推薦：普洱奶茶
兩茶包搭配300cc水小火滾煮3分鐘，再加入200cc牛奶小火煮至溫熱後熄火，可依個人喜好加入蜂蜜或糖調味。', CAST(N'2022-07-18T21:41:09.0930000' AS DateTime2), N'【普洱熟茶立體茶包30入】', 480, 600, 0, N'放置陰涼處', NULL, N'茶葉類', NULL, 4)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (20, N'60g±3%/罐', N'★有機驗證機構：慈心有機驗證(股)公司 證書字號：1-009-110128
此茶樹是用種子來繁殖，經過野放栽培而成，製茶時先以基本烏龍茶的製作過程製作後，再轉為紅茶的做法來完成，以重發酵、輕烘焙來製成，不炒菁保留了茶葉的活性，經過存放，茶質已經轉為甘甜順口！結合烏龍茶與紅茶的製作過程，讓其茶味也融合了這兩種茶的醇和、甘潤的特色，帶有熟果香，與中重焙火製成的烏龍茶更多了一分溫潤與滑順，好入口不刺激。

茶園完全不使用除草劑、化學肥料及農藥，透過友善土地的栽種方式，喝綠光農園的有機茶，不但有益身心，亦能透過喝有機茶來支持、維護我們的水源與自然生態，歡迎大家來品嚐。', CAST(N'2022-07-18T21:41:38.9530000' AS DateTime2), N'【有機紅水烏龍單罐60g】', 1050, 1666, 0, N'放置陰涼處', NULL, N'茶葉類', NULL, 4)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (21, N'無毒檸檬切片(低溫烘乾)25g', N'將無毒新鮮檸檬切片後以低溫烘乾，製作出天然無添加的無毒檸檬果乾，保留最天然的檸檬香氣與營養。

不含防腐劑及任何添加物。', CAST(N'2022-07-18T21:42:16.4230000' AS DateTime2), N'【檸檬茶片】', 160, 2000, 0, N'放置陰涼處', NULL, N'茶葉類', NULL, 4)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (22, N'6份時令有機葉菜類(約250g/包)
2份有機瓜果根莖類(約500g/包)', N'精選花蓮縣壽豐鄉農友供應之當季農產品，每份組合含6份有機葉菜類、2份有機瓜果根莖類。

參考菜單:
【葉菜類】小松菜、小芥菜、紅鳳菜、塔菇菜、山甜菜、芊寶菜、龍鬚菜、過貓、空心菜、地瓜葉、青江菜、小白菜、京水菜、雪菜、快綠菜、甜菜心、日本茼蒿等當季葉菜。

【瓜果根莖類】白蘿蔔、白花椰、南瓜、芭蕉、結頭菜、甜玉米、馬鈴薯、茄子、黑木耳、小黃瓜、花生、甜椒、芋頭、地瓜等當季根莖瓜果類或時令水果。

◎為正常作業及均衡營養考量，配送內容依實際出貨為主', CAST(N'2022-07-18T21:49:30.3000000' AS DateTime2), N'【輕量套餐 2莖6葉有機蔬果箱】', 600, 3000, 0, N'冰箱冷藏', NULL, N'蔬菜類', NULL, 5)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (23, N'5斤/箱', N'■「綠竹筍原料」均通過有機(或轉型期)農產品驗證
■無添加保鮮劑、人工添加物
■專業預冷保鮮處理

綠竹筍在八里區生產已逾百年，其出土綠化前色澤金黃亮麗，品質特優，因此農會將此命名為「黃金筍」，八里區黃金筍多種在砂壤土中，加上東北季風帶來的鹽份，所以品質特別細嫩甜美，吃來口感如細嫩水梨一般。

帶殼黃金筍於現採後兩小時內進行預冷處理，能延長保鮮期限，長途運輸也方便。烹調食用前需剝殼去皮，經預冷的黃金筍鮮炒時，特別鮮、甜、脆。', CAST(N'2022-07-18T21:50:17.2960000' AS DateTime2), N'【帶殼預冷黃金筍5斤/箱】', 990, 2220, 0, N'冰箱冷藏', NULL, N'蔬菜類', NULL, 5)

INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (24, N'彩色地瓜10斤：菱角地瓜/紫地瓜/栗子地瓜/台農66號/台農57號～約各2斤', N'本組合有五種地瓜：菱角地瓜、紫地瓜、栗子地瓜、台農66號地瓜、台農57號地瓜，台灣是地瓜王國，不管是在地品種或外來改良，在甜度細緻度上都享譽國際，慧軒農場用傳承三代的種植技術，讓您一次品嚐多種台灣之光！

■菱角地瓜：產量超稀少！外皮為紫色，果肉如同牛奶白又帶著淡淡的紫，吃起來有菱角香氣及牛奶味，質地相當細緻綿密，史場少見。

■紫地瓜：外皮及內肉都呈現絢麗的紫色而得其名，富含膳食纖維及花青素，低卡又高纖，甜度屬於地瓜中較低的品種，口感紮實。

■栗子地瓜：粉紫色外皮配上金黃色果肉，日本超人氣品種，甜度相當高，口感細緻卻紮實，猶如炒栗子的風味，產量不多。

■台農66號地瓜：紅皮橘肉，口感甘甜軟嫩水分相當多，為台灣相當常見的『紅薯』，胡蘿蔔素含量高，不管是蒸煮、配稀飯，都好吃！

■台農57號地瓜：黃皮黃肉，台灣最普遍蕃薯品種，品質相當穩定，甜度高口感鬆Q，烤地瓜首選品種，蒸後冰鎮也超好吃。', CAST(N'2022-07-18T21:51:03.8890000' AS DateTime2), N'【無毒彩色地瓜10斤裝】', 700, 1600, 0, N'放置陰涼處', NULL, N'蔬菜類', NULL, 5)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (25, N'940cc鮮乳x20瓶', N'■使用自家種植牧草餵養
■使用100%無人工調整鮮乳(符合國家CNS3056規定)
■絕無添加防腐劑及人工香料', CAST(N'2022-07-18T22:11:12.2650000' AS DateTime2), N'【主恩鮮乳 940cc 20瓶 團購優惠組】', 1880, 1000, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 6)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (26, N'200cc寡多醣可可亞x15瓶', N'牧場要在生乳品質、經營效益、飼養管理、疾病防治、環境衛生等各方面都能維持特優水準，除了飼養環境要青山綠水無汙染，更仰賴來自以色列，高科技的牛隻健康管理系統，透過牛隻身上的無線傳輸監控環，掌握每頭牛的活動量、飲食及健康狀況，比對生乳品質後，才能針對個別狀況給予最適當的照顧，確保每滴鮮乳都維持最佳品質。

五梅牧場寡多醣可可亞的特色:
1.完全以生乳調配不使用奶粉、奶精及人工乳化劑。
2.使用天然可可粉及天然麥芽精粉調味完全不使用人工添加劑
(1)不使用人工香料
(2)不使用人工色素
(3)不使用消泡劑
3.添加二種水溶性膳食纖維(Fibersol-2、Inulin)', CAST(N'2022-07-18T22:11:47.6120000' AS DateTime2), N'【200cc 寡多醣可可亞牛羊乳 15瓶組】', 560, 1300, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 6)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (27, N'920cc鮮乳x6瓶', N'根據各界醫學研究，乳鐵蛋白對提升腸道免疫力極具幫助，抵抗如腸病毒等病菌，吸收能力不好或常感冒的幼童尤其需要。

一般採高溫殺菌的鮮乳，卻也同時破壞了重要的營養成分，老爹鮮乳經檢驗證實其營養價值非常接近生乳成份，此研究結果更曾發表於畜產業知名的國際期刊"乳品新知 Journal of Dairy Science"上，廣受迴響!', CAST(N'2022-07-18T22:12:14.6300000' AS DateTime2), N'【老爹鮮乳 920cc 6瓶組】', 700, 1700, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 6)
INSERT [dbo].[farmer_product] ([farmer_product_id], [contents], [description], [launched_time], [name], [price], [quantity], [state], [storage], [suspend_time], [type], [violation_time], [farmer_id]) VALUES (28, N'936ml鮮羊乳x2瓶', N'■備受大廠壓迫 酪農辛苦慘賠
祥豪牧場的羊乳從以前就被大廠收購，價錢受到打壓，因此一直處於賠錢的狀態，第二代楊仁豪先生偶然發現父母所經營的牧場已經連年虧損近百萬元，從小認識的當地酪農也皆是如此。

■自創羊舍品牌 生產高品質羊乳
為了改善這樣的情況，他決定自創「羊舍」品牌，從飼養、擠奶、加工殺菌到運送羊乳，每個步驟都深具學問，絲毫毫馬虎不得。他更傳承了父母35年來的堅持-「100%純羊乳」，保證成分無調整、無添加，因此才能生產出最高品質的美味羊乳！

■精選飼育羊種 調配營養飼料
牧場所飼養的羊隻品種是阿爾拜因羊，母羊的泌乳期長、體質強健，對不同氣候環境的適應性良好。而牧場選用的飼料更混合台灣產的新鮮玉米粒、豆殼、豆粕，以及進口苜蓿草等，幫助羊隻補充每日所需營養。因此牧場的羊兒各個乳汁豐沛，不但營養價值高，且口感香醇濃郁。', CAST(N'2022-07-18T22:12:45.7930000' AS DateTime2), N'【936ml 鮮羊乳 2瓶組】', 420, 1600, 0, N'冰箱冷藏', NULL, N'牛奶類', NULL, 6)

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
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (13, N'https://i.imgur.com/989qBoW.jpg', 6)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (14, N'https://i.imgur.com/NBKSiaA.jpg', 6)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (15, N'https://i.imgur.com/Ik8kind.jpg', 7)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (16, N'https://i.imgur.com/aHCgsc4.jpg', 7)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (17, N'https://i.imgur.com/8t017n8.jpg', 8)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (18, N'https://i.imgur.com/NeebdTU.jpg', 9)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (19, N'https://i.imgur.com/6aTbzwg.jpg', 9)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (20, N'https://i.imgur.com/NEdjy3F.jpg', 10)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (21, N'https://i.imgur.com/UgMc3ZP.jpg', 10)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (22, N'https://i.imgur.com/UEGt0vZ.jpg', 11)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (23, N'https://i.imgur.com/ZGDwn56.jpg', 11)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (24, N'https://i.imgur.com/smcEuvC.jpg', 12)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (25, N'https://i.imgur.com/plq4s2V.jpg', 13)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (26, N'https://i.imgur.com/7noz2mC.jpg', 13)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (27, N'https://i.imgur.com/WSS1Miz.jpg', 14)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (29, N'https://i.imgur.com/qNJrhSR.jpg', 15)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (30, N'https://i.imgur.com/tVTiyRa.jpg', 16)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (31, N'https://i.imgur.com/VukYCXp.jpg', 17)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (32, N'https://i.imgur.com/yzDu1Wn.jpg', 18)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (33, N'https://i.imgur.com/r8cw4IF.jpg', 19)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (34, N'https://i.imgur.com/SWUSMXA.jpg', 20)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (35, N'https://i.imgur.com/FVxyJv3.jpg', 21)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (36, N'https://i.imgur.com/VbPaXg6.jpg', 22)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (37, N'https://i.imgur.com/DJL5cLw.jpg', 23)

INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (39, N'https://i.imgur.com/QpEua6w.jpg', 24)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (40, N'https://i.imgur.com/NgSGZ1d.jpg', 25)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (41, N'https://i.imgur.com/eApRBpR.jpg', 26)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (42, N'https://i.imgur.com/ysQBZ0W.jpg', 27)
INSERT [dbo].[farmer_product_pic] ([pic_id], [picture_link], [farmer_product_id]) VALUES (43, N'https://i.imgur.com/bZ8LR2u.jpg', 28)
SET IDENTITY_INSERT [dbo].[farmer_product_pic] OFF




--新增會員資料
INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url,enabled) VALUES (N'桃園市楊梅區中山路121巷4弄9號', N'1994-09-19', N'vison918889@gmail.com', N'管理者', N'男', N'$2a$10$YGN1RifEWFMQqWgVNFPl6uK68J8bjMpsOjQIw18ZEchdoQXZq1vP.', N'0918583187', GETDATE(), N'byl0729',N'ROLE_ADMIN',N'https://i.imgur.com/BhAxrqk.jpg',1)
INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url,enabled) VALUES (N'桃園市中壢區新生路二段421號', N'1993-08-19', N'eeit45@bycc.dev', N'跳跳虎', N'男', N'$2a$10$L6rXqpJopBrColGAahlYrOy6MWDIxAVQFJI3Ttrd31ZCoqK0x6gmS', N'0956326532', GETDATE(), N'usertest1',N'ROLE_USER',N'https://i.imgur.com/oGvQlYA.jpg',1)
--課程測試帳號
INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url,enabled) VALUES (N'桃園市中壢區新生路二段421號', N'1993-08-19', N'yi999897@gmail.com', N'麵包超人', N'男', N'$2a$10$irmlCNkjjQ8utDi06aHVte./TMmh15Ky3yQitT3.CjMMNXaVDMtsi', N'0956326532', GETDATE(), N'usertest123',N'ROLE_USER',N'https://i.imgur.com/8OWhg3I.png',1)
-- INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url) VALUES (N'桃園市中壢區新生路二段421號', N'1993-08-19', N'yi999897@gmail.com', N'測試會員', N'男', N'$2a$10$T3NCCFHTBIuMYsREiyFGDOi08B1KGO4jQ1/mA/S/vbOa4aL3t0G1u', N'0956326532', GETDATE(), N'usertest123',N'ROLE_USER',N'https://i.imgur.com/q5nYQAo.png',1)
--文章測試
INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url,enabled) VALUES (N'桃園市中壢區新生路二段421號', N'1993-08-19', N'hallie0705@gmail.com', N'依米奇', N'男', N'$2a$10$FnzDcG7WUQXUeUA1K6CwOe7BVoMZGHyydt9PtPfYNAIyJKDVzH6j2', N'0956326532', GETDATE(), N'article123',N'ROLE_USER',N'https://i.imgur.com/ezcCdg3.png',1)


-- 新增器具類別
INSERT INTO tackle_sort(sort) VALUES(N'烤箱');
INSERT INTO tackle_sort(sort) VALUES(N'模具');
INSERT INTO tackle_sort(sort) VALUES(N'容器');
INSERT INTO tackle_sort(sort) VALUES(N'濾網/篩具');
INSERT INTO tackle_sort(sort) VALUES(N'桿麵棍');
INSERT INTO tackle_sort(sort) VALUES(N'攪拌用具');
INSERT INTO tackle_sort(sort) VALUES(N'刷具');
INSERT INTO tackle_sort(sort) VALUES(N'刀具/切割工具');
INSERT INTO tackle_sort(sort) VALUES(N'測量工具');
INSERT INTO tackle_sort(sort) VALUES(N'擠花/翻糖工具');

-- 新增器具
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (4740,30,50,N'
                                                                                                         NB-H3801 大容量、發酵烘烤一機完成。
                                                                                                         ●3D熱風對流 - 大火力立體熱風對流烘烤,全面包圍時才,不易烤焦,油切更健康。
                                                                                                         ●上下獨立控溫滿足各種火力需求 - 上火+下火雙重控溫:上火、下火可同時設定不同溫度,滿足多種食材不同厚度的火裡需求。
                                                                                                         ●發酵行程 發酵烘培一機完成 - 結合發酵箱功能,一次滿足發酵與烘培需求,選擇發酵行程,無須再另外設定溫度就能維持30度~50度C最佳發酵環境。

                                                                                                         ●附加設備 - 琺瑯烤盤、琺瑯深烤盤、烤網、抽取式集屑盤、取物夾、取物支架。',N'PANASONIC NB-H3801',N'38L電烤箱', 1);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2950,50,50,N'
                                                                                                         NB-H3203 大容量、發酵烘烤一機完成。
                                                                                                         ●雙層防燙隔熱門 - 防止烘烤過程中誤觸玻璃門而燙傷,同時擁有更良好的聚熱功能,效率更提升。
                                                                                                         ●360度自動旋轉燒烤 - 自動旋轉烘烤,不會過焦或不熟,全面均勻受熱,不遺漏任何一處的美味。
                                                                                                         ●3D熱風對流 - 大火力立體熱風對流烘烤,全面包圍時才,不易烤焦,油切更健康。
                                                                                                         ●上下獨立控溫滿足各種火力需求 - 上火+下火雙重控溫:上火、下火可同時設定不同溫度,滿足多種食材不同厚度的火裡需求。
                                                                                                         ●發酵行程 發酵烘培一機完成 - 結合發酵箱功能,一次滿足發酵與烘培需求,選擇發酵行程,無須再另外設定溫度就能維持30度~50度C最佳發酵環境。

                                                                                                         ●附加設備 - 琺瑯烤盤、琺瑯深烤盤、烤網、抽取式集屑盤、取物夾、取物支架',N'PANASONIC  NB-H3203',N'32L電烤箱', 1);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (500,10,100,N'
                                                                                                         產地：台灣。

                                                                                                        成份：鋁合金(耐溫230度)。
                                                                                                        規格：最長約5公分、寬約4公分、高約2.2公分，每組五入。',N'鳳梨酥模具組_鋁合金小兔頭_5入_T213016',N'鳳梨酥模具+壓棒(兔子)', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (500,10,100,N'
                                                                                                         產地：台灣。

                                                                                                         成份：鋁合金(耐溫230度)。
                                                                                                         規格：最長約4.6公分、寬約4.5公分、高約2.2公分，每組五入。',N'鳳梨酥模具組_鋁合金小熊頭_5入_T213015',N'鳳梨酥模具+壓棒(小熊)', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2000,10,80,N'
                                                                                                         產地：日本。

                                                                                                         成份：鍍錫鋼片。
                                                                                                         規格：整體長約30公分、寬約22公分、高約2公分，置物最長約5.5公分、寬約5公分、高約2公分/共12連。',N'多連烤盤_MATSUNAGA雙心12連_126-19B',N'雙心12連模具', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2200,10,80,N'
                                                                                                         產地：日本。

                                                                                                         成份：鍍錫鋼片。
                                                                                                         規格：整體長約30公分、寬約22公分、高約2公分，置物最長約5公分、寬約5公分、高約2公分/共12連。',N'多連烤盤_MATSUNAGA栗子12連_126-18',N'栗子12連模具', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2350,10,80,N'
                                                                                                         產地：日本。

                                                                                                         成份：鍍錫鋼片。
                                                                                                         規格：整體長約30公分、寬約22公分、高約1.7公分，置物最長約5公分、寬約3.5公分、高約1.7公分/共15連。',N'多連烤盤_MATSUNAGA瑪德蓮15連_126-13',N'瑪德蓮15連模具', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (300,15,50,N'
                                                                                                        產地：日本。

                                                                                                        材質：耐熱玻璃(耐熱溫差120度)。
                                                                                                        尺寸規格 : 直徑長約15.6公分、高約10.2公分。直徑長約21公分、高約12公分。
                                                                                                        容量：(S)900ml/(M)1500ml/(L)2200ml。
                                                                                                        商品重量：約2.45公斤。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔',N'玻璃盆_MXPN-3704',N'玻璃盆', 3);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (390,15,50,N'
                                                                                                        產地：中國。

                                                                                                        材質：不鏽鋼。
                                                                                                        尺寸規格 : 直徑長約20公分、高約12公分。
                                                                                                        商品重量：約470公克。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔、放入微波爐',N'深型打蛋盆20cm_WK9364',N'20cm不鏽鋼盆', 3);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (350,15,40,N'
                                                                                                        產地：中國。

                                                                                                        材質：不鏽鋼。
                                                                                                        尺寸規格 : 內徑約22.8公分、外徑約23.2公分(不含嘴口)、高約13.4公分。
                                                                                                        商品重量：約460公克。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔、放入微波爐',N'深型打蛋盆24cmBetty_CT4967',N'24cm不鏽鋼盆', 3);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (350,15,40,N'
                                                                                                        產地：中國。

                                                                                                        材質：不鏽鋼。
                                                                                                        尺寸規格 : 內徑約24公分、外徑約27.5公分、高約14.5公分。
                                                                                                        商品重量：約500公克。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔、放入微波爐',N'握把底止滑打蛋盆23cm_CT4966',N'握把底止滑打蛋盆', 3);

--新增器具圖片
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/tb8W5J4.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/32RgBtM.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/xBpTAEm.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/nIQ7cWy.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/hxevsGw.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/uwkvD6G.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/Qk8Pz8S.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/7LYKHqh.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/hKTKUIm.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/HRaZVRP.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/S2KDkan.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/6WpFPTN.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/Hveg2Gl.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/1mGDySq.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/suof28U.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/hSnuiOC.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/eVTMLU3.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/CBzzRt4.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/6oxKYZl.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/bMe6oVu.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/Taf9bPN.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/rROpkOM.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/F2WY0eR.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/abXs2p1.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/UneqTz4.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/IaCJqaU.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/umbhqpf.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/ojBEUSN.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/9mO9pbP.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/h0dBp7v.png',8);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/jqoZB4F.png',8);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/nd7Jw0W.png',9);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/xAadPqt.png',9);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/yq493eP.png',10);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/U21OVeB.png',10);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/77tCgYR.png',11);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/EJTHlhj.png',11);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES(N'https://i.imgur.com/qi2ZZCt.png',11);

--新增場地類別
INSERT INTO venue_sort(sort) VALUES(N'課用烘培室');
INSERT INTO venue_sort(sort) VALUES(N'親子烘培室');
INSERT INTO venue_sort(sort) VALUES(N'小型烘培室');
INSERT INTO venue_sort(sort) VALUES(N'大型烘培室');



--新增場地
SET IDENTITY_INSERT [dbo].[venue] ON
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (1, 0, NULL, 30, N'A101', 1)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (2, 0, NULL, 30, N'A102', 1)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (3, 0, NULL, 30, N'A201', 1)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (4, 0, NULL, 30, N'A202', 1)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (5, 125, N'適合與小孩一起學習烘培，空間空曠，讓小孩擁有安全的空間體驗烘培，每組可4~5人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 15, N'B201', 2)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (6, 125, N'適合與小孩一起學習烘培，空間空曠，讓小孩擁有安全的空間體驗烘培，每組可4~5人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 15, N'B202', 2)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (7, 100, N'每組擁有獨至的小型烘培區，適合單人或雙人共同體驗烘培，每組可1~2人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 30, N'B301', 3)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (8, 100, N'每組擁有獨至的小型烘培區，適合單人或雙人共同體驗烘培，每組可1~2人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 30, N'B302', 3)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (9, 100, N'每組擁有獨至的小型烘培區，適合單人或雙人共同體驗烘培，每組可1~2人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 30, N'B303', 3)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (10, 300, N'適合一家人或與朋友一起來體驗團體烘培，每組可5~8人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 10, N'B401', 4)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (11, 300, N'適合一家人或與朋友一起來體驗團體烘培，每組可5~8人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 10, N'B501', 4)
INSERT [dbo].[venue] ([venue_id], [hr_price], [notes], [person_max], [venue_name], [fk_sort_id]) VALUES (12, 300, N'適合一家人或與朋友一起來體驗團體烘培，每組可5~8人。

場地使用規則:
1. 本教室之場地皆有樓層管理人員，請遵從樓層管理人員指示。 借用期間，借 用者應負責維持場地內外秩序、公共安全及環境衛生，並應接受本教室之監 督指導。
2. 本教室出借場地之時間，包含使用後將教室器具清洗乾淨及擦拭乾淨。
3. 本教室出借場地之費用 ： 不包含調味料、餐巾紙、擦手紙、免洗碗筷、吸管 ... 等耗材 。
4. 本教室出借場地之費用： 不包含垃圾清運處理、廚餘分類處理；若需本教室 協助處理，需另行付費。費用參照收費標準 。
5. 使用各項設備、器材，務必遵守使用規則，注意安全。
6. 垃圾請依照各項分類做資源回收。
7. 現場 陳設室內之 器皿、餐具 及硬體設備皆可使用。 各種用具使用 ~ 完畢須用 清潔劑 洗滌擦拭乾淨並放回原處。
8. 結束 後應分別將地面及工作台清掃或擦拭乾淨 → 所使用之器皿洗滌後逐一清點歸還回原位。', 10, N'B601', 4)
SET IDENTITY_INSERT [dbo].[venue] OFF

--新增場地圖片
SET IDENTITY_INSERT [dbo].[venue_pic_list] ON
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (1, N'https://i.imgur.com/jvJMtLN.jpg', 5)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (2, N'https://i.imgur.com/2Xe02ZD.jpg', 5)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (3, N'https://i.imgur.com/U2i2lNL.jpg', 5)
-- INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (4, N'https://i.imgur.com/jp44JJP.jpg', 5)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (5, N'https://i.imgur.com/U1nSSRP.jpg', 5)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (6, N'https://i.imgur.com/bOUD65S.jpg', 10)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (7, N'https://i.imgur.com/3gSo8JX.jpg', 10)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (8, N'https://i.imgur.com/KurZRTY.jpg', 10)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (9, N'https://i.imgur.com/veTtvo7.jpg', 7)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (10, N'https://i.imgur.com/YHfqcrh.jpg', 7)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (11, N'https://i.imgur.com/fTnPDzK.jpg', 7)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (12, N'https://i.imgur.com/jvJMtLN.jpg', 6)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (13, N'https://i.imgur.com/2Xe02ZD.jpg', 6)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (14, N'https://i.imgur.com/U2i2lNL.jpg', 6)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (15, N'https://i.imgur.com/jp44JJP.jpg', 6)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (16, N'https://i.imgur.com/veTtvo7.jpg', 8)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (17, N'https://i.imgur.com/YHfqcrh.jpg', 8)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (18, N'https://i.imgur.com/fTnPDzK.jpg', 8)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (19, N'https://i.imgur.com/veTtvo7.jpg', 9)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (20, N'https://i.imgur.com/YHfqcrh.jpg', 9)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (21, N'https://i.imgur.com/fTnPDzK.jpg', 9)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (22, N'https://i.imgur.com/bOUD65S.jpg', 11)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (23, N'https://i.imgur.com/3gSo8JX.jpg', 11)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (24, N'https://i.imgur.com/KurZRTY.jpg', 11)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (25, N'https://i.imgur.com/bOUD65S.jpg', 12)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (26, N'https://i.imgur.com/3gSo8JX.jpg', 12)
INSERT [dbo].[venue_pic_list] ([pic_list_id], [picture], [fk_venue_id]) VALUES (27, N'https://i.imgur.com/KurZRTY.jpg', 12)
SET IDENTITY_INSERT [dbo].[venue_pic_list] OFF


   --自動生產編號
Insert INTO produce_no VALUES ('20220726', 'rental','3')
Insert INTO produce_no VALUES ('20220726', 'venueList','9')

    --新增租借單
SET IDENTITY_INSERT [dbo].[rental] ON
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (1, CAST(N'2022-07-25T13:24:17.0000000' AS DateTime2), N'202207250000001', NULL, N'已付款', 2000, N'場地', 2)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (2, CAST(N'2022-07-25T13:25:46.0000000' AS DateTime2), N'202207250000002', NULL, N'已付款', 3100, N'場地', 2)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (3, CAST(N'2022-07-25T13:27:18.0000000' AS DateTime2), N'202207250000003', NULL, N'已付款', 4000, N'場地', 3)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (4, NULL, N'202207250000004', NULL, N'已退單', 1500, N'場地', 3)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (5, CAST(N'2022-07-25T13:29:44.0000000' AS DateTime2), N'202207250000005', NULL, N'已付款', 4800, N'場地', 4)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (6, CAST(N'2022-07-25T13:30:15.0000000' AS DateTime2), N'202207250000006', NULL, N'已付款', 1800, N'場地', 3)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (7, CAST(N'2022-07-26T08:33:07.7800000' AS DateTime2), N'202207260000001', NULL, N'待付款', 3200, N'場地', 2)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (8, CAST(N'2022-07-26T08:34:46.9280000' AS DateTime2), N'202207260000002', NULL, N'待付款', 28800, N'場地', 2)
INSERT [dbo].[rental] ([rental_id], [rental_date], [rental_no], [replenishment], [state], [total], [list_type], [user_id]) VALUES (9, NULL, N'202207260000003', NULL, N'未下單', 3600, N'場地', 2)

    SET IDENTITY_INSERT [dbo].[rental] OFF

    --場地清單
SET IDENTITY_INSERT [dbo].[venue_list] ON
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (1, N'N', N'08:00-12:00', 1, 500, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725001', 1, 5)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (2, N'N', N'08:00-12:00', 1, 500, CAST(N'2022-07-28T00:00:00.0000000' AS DateTime2), N'V20220725002', 1, 5)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (3, N'N', N'08:00-16:00', 1, 1000, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220725003', 1, 5)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (4, N'N', N'12:00-16:00', 2, 1000, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725004', 2, 5)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (5, N'N', N'08:00-12:00', 1, 500, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725005', 2, 6)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (6, N'N', N'08:00-16:00', 2, 1600, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725006', 2, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (7, N'N', N'16:00-20:00', 1, 400, CAST(N'2022-07-28T00:00:00.0000000' AS DateTime2), N'V20220725007', 3, 8)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (8, N'N', N'08:00-20:00', 2, 2400, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220725008', 3, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (9, N'N', N'08:00-20:00', 1, 1200, CAST(N'2022-07-31T00:00:00.0000000' AS DateTime2), N'V20220725009', 3, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (10, N'N', N'16:00-20:00', 1, 500, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725010', 4, 5)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (11, N'N', N'16:00-20:00', 1, 500, CAST(N'2022-07-29T00:00:00.0000000' AS DateTime2), N'V20220725011', 4, 5)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (12, N'N', N'12:00-16:00', 1, 500, CAST(N'2022-07-29T00:00:00.0000000' AS DateTime2), N'V20220725012', 4, 6)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (13, N'N', N'08:00-20:00', 1, 1200, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725013', 5, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (14, N'N', N'08:00-20:00', 2, 2400, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220725014', 5, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (15, N'N', N'08:00-20:00', 1, 1200, CAST(N'2022-08-06T00:00:00.0000000' AS DateTime2), N'V20220725015', 5, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (16, N'N', N'12:00-16:00', 2, 800, CAST(N'2022-07-26T00:00:00.0000000' AS DateTime2), N'V20220725016', 6, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (17, N'N', N'08:00-16:00', 1, 1000, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220725017', 6, 6)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (18, N'N', N'12:00-16:00', 1, 400, CAST(N'2022-07-27T00:00:00.0000000' AS DateTime2), N'V20220726001', 7, 8)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (19, N'N', N'08:00-16:00', 1, 800, CAST(N'2022-07-27T00:00:00.0000000' AS DateTime2), N'V20220726002', 7, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (20, N'N', N'08:00-16:00', 1, 800, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220726003', 7, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (21, N'N', N'08:00-20:00', 1, 1200, CAST(N'2022-08-06T00:00:00.0000000' AS DateTime2), N'V20220726004', 7, 7)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (22, N'N', N'16:00-20:00', 1, 1200, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220726005', 8, 10)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (23, N'N', N'08:00-20:00', 1, 3600, CAST(N'2022-07-31T00:00:00.0000000' AS DateTime2), N'V20220726006', 8, 10)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (24, N'N', N'12:00-20:00', 10, 24000, CAST(N'2022-07-30T00:00:00.0000000' AS DateTime2), N'V20220726007', 8, 11)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (25, N'N', N'08:00-16:00', 1, 2400, CAST(N'2022-08-03T00:00:00.0000000' AS DateTime2), N'V20220726008', 9, 12)
INSERT [dbo].[venue_list] ([venue_list_id], [ingredients], [period], [person], [price], [rental_date], [venue_list_no], [fk_rental_id], [fk_venue_id]) VALUES (26, N'N', N'16:00-20:00', 1, 1200, CAST(N'2022-07-27T00:00:00.0000000' AS DateTime2), N'V20220726009', 9, 11)

    SET IDENTITY_INSERT [dbo].[venue_list] OFF


--新增訂單資料
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-25T22:35:24.6900000' AS DateTime2), N'202207252235245', N'完成', CAST(N'2022-07-25T22:35:57.5750000' AS DateTime2), 0, CAST(N'2022-07-25T22:42:52.8590000' AS DateTime2), 100, 958, N'111111111111', NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-24T22:36:13.6490000' AS DateTime2), N'202207242236137', N'退款審核中', CAST(N'2022-07-24T22:36:33.0420000' AS DateTime2), 1, CAST(N'2022-07-25T22:42:56.1490000' AS DateTime2), 100, 899, N'', NULL, 2,'等太久')
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-23T22:37:36.7950000' AS DateTime2), N'202207232237369', N'退款審核中', CAST(N'2022-07-23T22:38:01.3090000' AS DateTime2), 0, NULL, 100, 1698, NULL, NULL, 2,'我不想買了')
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-22T22:38:22.6500000' AS DateTime2), N'202207222238220', N'待出貨', CAST(N'2022-07-22T22:38:34.1380000' AS DateTime2), 1, CAST(N'2022-07-25T22:43:00.0770000' AS DateTime2), 100, 2497, N'', NULL, 2,'等太久')
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-21T22:38:54.8850000' AS DateTime2), N'202207212238548', N'待付款', NULL, 0, NULL, 100, 899, NULL, NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-20T22:39:13.2840000' AS DateTime2), N'202207202239134', N'待收貨', CAST(N'2022-07-21T22:39:22.9590000' AS DateTime2), 1, CAST(N'2022-07-24T22:43:03.0060000' AS DateTime2), 100, 899,  N'111111111111', NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-19T22:40:25.7620000' AS DateTime2), N'202207192240251', N'待出貨', CAST(N'2022-07-20T22:40:46.1170000' AS DateTime2), 0, CAST(N'2022-07-23T22:43:08.5550000' AS DateTime2), 100, 899, N'', NULL, 2)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 1)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 2)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 2, 1598, 3)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 3, 2397, 4)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 5)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 6)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 7)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'北海道優質麵粉', N'G1', N'烘培材料', 1, 59, 1)


--新增優惠券
INSERT [dbo].[coupon] ([discriminator], [code], [end_date], [max_quantity], [minimum], [name], [start_date], [used_quantity], [deduct_amount], [discount]) VALUES (N'deduct', N'NEWUSER', CAST(N'2222-12-31T00:00:00.0000000' AS DateTime2), 999999, 500, N'新用戶優惠券', CAST(N'2022-01-01T00:00:00.0000000' AS DateTime2), 0, 100, NULL)


--新增課程資料
INSERT [dbo].[course_prodcut] ([description], [image], [name], [price], [summary]) VALUES (N'<p>第一天：長條狀奶油鬆餅＋果醬夾心蛋糕餅＋裝飾奶油小西餅</p>

<p>第二天：雙色冰箱小西餅-方形＋全麥蘇打夾心餅乾</p>

<p>＋巧克力披覆甜餅乾</p>

<p>第三天：&nbsp;裝飾薑餅屋＋雙色冰箱小西餅-圓形</p>
', N'https://i.imgur.com/oIM5zPW.jpg', N'乙級烘焙下午特訓班', 30000, N'目前國內烘焙證照最高等級「乙級證照」，取得將讓您終身受用無窮。依勞委會職訓局頒佈「烘焙」乙級技術士技能檢定規範術科篇，共分為麵包、西點、餅乾、伴手禮四大類。')
INSERT [dbo].[course_prodcut] ([description], [image], [name], [price], [summary]) VALUES (N'<p>圓頂奶油土司麵包、圓頂葡萄乾土司麵包、<br />
山形白土司麵包、橄欖形餐包、奶酥甜麵包、布丁餡甜麵包、紅豆餡甜麵包</p>
', N'https://i.imgur.com/WNhX4sH.jpg', N'丙級麵包烘焙晚間班', 18000, N'專業證照課程-烘焙麵包丙級不僅考證照、更讓您學得專業技術，取得專業認證、學習第二專長，將對你位來就業、創業受用無窮；年滿15歲，無任何烹飪經驗皆可參加。本教室訓練場地新、設備齊全，提供您親手實作、親身體驗作麵包的樂趣。')
INSERT [dbo].[course_prodcut] ([description], [image], [name], [price], [summary]) VALUES ( N'<p>A. 奶油貓舌小西餅 B. 葡萄乾燕麥紅糖小西餅 C. 調味小餅乾 D. 奶油小西餅 E. 瑪琍牛奶餅乾 F. 奶油蘇打餅乾&nbsp;G. 奶油椰子餅乾</p>

<p>另加學科：烘焙概論、烘焙計算、考場規定、及考試應注意事項、透過即測即評，一日內考完學科、術科，當天通過領證！</p>
', N'https://i.imgur.com/6Cumml6.jpg', N'丙級餅乾烘焙下午班', 15000, N'專業證照課程-烘焙丙級不僅考證照、更讓您學得專業技術，取得專業認證、學習第二專長，將對你位來就業、創業受用無窮；年滿15歲，無任何烹飪經驗皆可參加。本教室訓練場地新、設備齊全，提供您親手實作、親身體驗作麵包的樂趣。')
INSERT [dbo].[course_prodcut] ([description], [image], [name], [price], [summary]) VALUES (N'<p>第一堂：烘焙概論及計算、奶油大理石蛋糕(4個) 第二堂：戚風蛋糕捲(2條)、奶油空心餅(16個)&nbsp;</p>
', N'https://i.imgur.com/6GegbSQ.jpg', N'丙級蛋糕烘焙假日班', 20000, N'專業證照課程-烘焙丙級西點蛋糕不僅考證照、更讓您學得專業技術，取得專業認證、學習第二專長，將對你位來就業、創業受用無窮；年滿15歲，無任何烹飪經驗皆可參加。本教室訓練場地新、設備齊全，提供您親手實作、親身體驗作西點蛋糕的樂趣。')
INSERT [dbo].[course_prodcut] ([description], [image], [name], [price], [summary]) VALUES (N'<p>巧克力戚風蛋糕捲、奶油大理石蛋糕、海綿蛋糕、奶油空心餅、 香草天使蛋糕、蒸烤雞蛋牛奶布丁、檸檬布丁派等七種</p>
', N'https://i.imgur.com/EnRCJba.jpg', N'丙級西點烘焙上午班', 14000, N'巧克力戚風蛋糕捲、奶油大理石蛋糕、海綿蛋糕、奶油空心餅、 香草天使蛋糕、蒸烤雞蛋牛奶布丁、檸檬布丁派等七種')
INSERT [dbo].[course_prodcut] ([description], [image], [name], [price], [summary]) VALUES (N'<p>邀請具有十年以上經驗的專業西點烘焙師傅親自教學，在專業烘焙教學廚房上課，課程豐富多元，中秋節應景的月餅蛋黃酥，經典甜點提拉米蘇、法芙娜蛋糕吐司、舒芙蕾乳酪，到時下最夯的生吐司、虎皮蛋糕等。</p>
', N'https://i.imgur.com/6qGXxpu.jpg', N'西點烘焙假日體驗班', 2000, N'邀請具有十年以上經驗的專業西點烘焙師傅親自教學，在專業烘焙教學廚房上課，課程豐富多元，中秋節應景的月餅蛋黃酥，經典甜點提拉米蘇、法芙娜蛋糕吐司、舒芙蕾乳酪，到時下最夯的生吐司、虎皮蛋糕等')
--新增開課
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1000, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 60, N'', CAST(N'2022-08-22T01:00:00.0000000' AS DateTime2), N'謝佳陵', 1, 1)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1001, 0, CAST(N'2022-08-26T01:00:00.0000000' AS DateTime2), 12, N'', CAST(N'2022-08-23T01:00:00.0000000' AS DateTime2), N'謝佳陵', 1, 1)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1002, 0, CAST(N'2022-08-27T01:00:00.0000000' AS DateTime2), 15, N'', CAST(N'2022-08-24T01:00:00.0000000' AS DateTime2), N'謝佳陵', 1, 1)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1003, 0, CAST(N'2022-08-26T01:00:00.0000000' AS DateTime2), 12, N'', CAST(N'2022-08-23T01:00:00.0000000' AS DateTime2), N'謝佳陵', 2, 2)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1004, 0, CAST(N'2022-09-02T01:00:00.0000000' AS DateTime2), 12, N'', CAST(N'2022-08-29T01:00:00.0000000' AS DateTime2), N'謝佳陵', 2, 2)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1005, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 60, N'', CAST(N'2022-08-22T01:00:00.0000000' AS DateTime2), N'謝佳陵', 3, 3)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1006, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 60, N'', CAST(N'2022-08-22T01:00:00.0000000' AS DateTime2), N'謝佳陵', 4, 3)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1007, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 60, N'', CAST(N'2022-08-22T01:00:00.0000000' AS DateTime2), N'謝佳陵', 5, 2)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1008, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 8, N'', CAST(N'2022-08-15T01:00:00.0000000' AS DateTime2), N'謝佳陵', 6, 4)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1009, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 8, N'', CAST(N'2022-08-22T01:00:00.0000000' AS DateTime2), N'謝佳陵', 6, 2)

--課程時段
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-29T10:00:00.0000000' AS DateTime2), N'10001', N'', CAST(N'2022-08-29T12:00:00.0000000' AS DateTime2), 1000)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-30T10:00:00.0000000' AS DateTime2), N'10002', N'', CAST(N'2022-08-30T12:00:00.0000000' AS DateTime2), 1000)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-31T10:00:00.0000000' AS DateTime2), N'10003', N'', CAST(N'2022-08-31T12:00:00.0000000' AS DateTime2), 1000)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-25T10:00:00.0000000' AS DateTime2), N'10011', N'', CAST(N'2022-08-25T12:00:00.0000000' AS DateTime2), 1001)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-26T10:00:00.0000000' AS DateTime2), N'10012', N'', CAST(N'2022-08-26T12:00:00.0000000' AS DateTime2), 1001)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-27T10:00:00.0000000' AS DateTime2), N'10013', N'', CAST(N'2022-08-27T12:00:00.0000000' AS DateTime2), 1001)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-09-01T10:00:00.0000000' AS DateTime2), N'10021', N'', CAST(N'2022-09-01T12:00:00.0000000' AS DateTime2), 1002)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-09-02T10:00:00.0000000' AS DateTime2), N'10022', N'', CAST(N'2022-09-02T12:00:00.0000000' AS DateTime2), 1002)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-09-03T10:00:00.0000000' AS DateTime2), N'10023', N'', CAST(N'2022-09-03T12:00:00.0000000' AS DateTime2), 1002)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-31T10:00:00.0000000' AS DateTime2), N'10031', N'', CAST(N'2022-08-31T12:00:00.0000000' AS DateTime2), 1003)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-31T10:00:00.0000000' AS DateTime2), N'10041', N'', CAST(N'2022-08-31T12:00:00.0000000' AS DateTime2), 1004)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-08-31T10:00:00.0000000' AS DateTime2), N'10051', N'', CAST(N'2022-08-31T12:00:00.0000000' AS DateTime2), 1005)
INSERT [dbo].[course_time] ([ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (CAST(N'2022-09-30T10:00:00.0000000' AS DateTime2), N'10061', N'', CAST(N'2022-09-30T12:00:00.0000000' AS DateTime2), 1006)
--新增報名資料
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022001, 1, CAST(N'2022-07-26T09:48:14.7850000' AS DateTime2), 1, 30000, 1002, 3)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022002, 1, CAST(N'2022-07-26T10:00:13.3310000' AS DateTime2), 0, 30000, 1000, 2)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022003, 1, CAST(N'2022-07-26T10:00:37.7600000' AS DateTime2), 3, 15000, 1005, 2)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022004, 1, CAST(N'2022-07-26T10:01:01.2740000' AS DateTime2), 0, 18000, 1004, 3)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022005, 1, CAST(N'2022-07-26T09:48:14.7850000' AS DateTime2), 1, 30000, 1002, 1)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022006, 1, CAST(N'2022-07-26T10:00:13.3310000' AS DateTime2), 0, 30000, 1000, 1)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022007, 1, CAST(N'2022-07-26T10:00:37.7600000' AS DateTime2), 0, 15000, 1005, 1)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022008, 1, CAST(N'2022-07-26T10:01:01.2740000' AS DateTime2), 4, 18000, 1004, 2)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022009, 2, CAST(N'2022-07-26T10:07:29.5380000' AS DateTime2), 4, 60000, 1000, 2)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022010, 1, CAST(N'2022-07-26T10:07:55.9420000' AS DateTime2), 4, 20000, 1006, 3)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [total_price], [fk_op_course], [fk_user_id]) VALUES (2022011, 2, CAST(N'2022-07-26T10:08:47.7430000' AS DateTime2), 5, 40000, 1000, 2)
--新增留言
SET IDENTITY_INSERT [dbo].[course_student_result] ON
INSERT [dbo].[course_student_result] ([str_id], [result_image_url], [str_content], [str_title], [time], [fk_product_id], [fk_user_id]) VALUES (1, N'https://i.imgur.com/a9J2Spk.jpg', N'週末，在家裡跟家人一起體驗超初級烘焙，
動手做的時間很好玩，過程簡單，成品又好吃，
口味很像喜餅裡面會有的奶油/伯爵茶小餅乾，
香醇的奶油味，配上簡單的原物料，
可愛又迷人的小餅乾就出爐囉', N'奶油小餅乾', CAST(N'2022-07-26T10:51:02.7160000' AS DateTime2), 1, 2)
SET IDENTITY_INSERT [dbo].[course_student_result] OFF

--新增文章資料
SET IDENTITY_INSERT [dbo].[article] ON

INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (1, N'<p>磅蛋糕&nbsp;<br>&nbsp;</p><p>&nbsp;無鹽奶油 100克&nbsp;<br>&nbsp;細砂糖 100克&nbsp;<br>&nbsp;低筋麵粉 100克&nbsp;<br>&nbsp;室溫雞蛋 2顆(約100克左右)<br>&nbsp;鹽 一小撮 香草精 2克&nbsp;<br>&nbsp;</p><p>檸檬糖漿(Lemon Syrup)&nbsp;</p><p>水 40克&nbsp;</p><p>細砂糖 30克&nbsp;</p><p>檸檬汁 10克&nbsp;</p><p>檸檬糖霜(Lemon Glaze)&nbsp;</p><p>糖粉 80克, 過篩&nbsp;</p><p>檸檬汁 15克&nbsp;</p><p>檸檬糖霜磅蛋糕做法</p><p>步驟&nbsp;1.烤模內抹油、灑粉，備用&nbsp;</p><p>2.打盆裡加入室溫軟化的奶油跟鹽，用中速打約四分鐘，打發的奶油顏色會變白&nbsp;</p><p>3.質地更膨鬆，再用刮勺把盆邊的奶油都集中在一起&nbsp;</p><p>4.加入細砂糖，但要少量、分次地加入，避免一次加入太多，一樣用中速攪打至混合均勻&nbsp;</p><p>5.兩顆雞蛋也是分次加，每加一顆打約30秒，或直到看不見蛋液為止才能再加另一顆</p><p>6.打完蛋後，加入香草精再打三十秒到一分鐘&nbsp;</p><p>7.將麵粉分三次篩入，用刮勺用翻拌的方式直到看不見乾粉；將拌好的麵糊倒入烤模內，敲幾下以排出空氣</p><p>8.在麵糊表面的中間，擠一條、或切一條細長的奶油，可幫助烘烤時裂紋比較漂亮 用170°C預熱烤箱，烘烤 50-55 分鐘&nbsp;</p><p>9.起一小鍋來做檸檬糖漿，加入糖跟水，用中小火煮至糖溶解，沸騰後再多煮2分鐘便可移鍋關火，最後加上10克的檸檬汁拌勻，放涼備用&nbsp;</p><p>10.出爐後的磅蛋糕先靜置10-15分鐘，時間到脫模，用竹叉在上面戳幾個洞，趁蛋糕還熱塗上檸檬糖漿，放至完全涼透&nbsp;</p><p>11.最後，取一個小碗加入篩過的糖粉，再倒入15克的檸檬汁充份攪拌，然後淋在已經塗了糖漿的磅蛋糕上，待糖霜乾透即可享用，建議冰過後再吃，風味絕佳~<br>&nbsp;</p>', 13, CAST(N'2022-07-12' AS Date), N'https://i.imgur.com/N42uCxU.jpg', N'檸檬磅蛋糕', N'食譜討論', 1)
INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (2, N'<p>雞蛋布丁&nbsp;</p><p>材料&nbsp;</p><p>鮮奶 500g&nbsp;</p><p>雞蛋 4顆&nbsp;</p><p>砂糖 50g&nbsp;</p><p>雞蛋布丁&nbsp;</p><p>作法 1.鮮奶微火加熱.倒入砂糖攪拌至溶化(不能太熱~溫溫的就好)&nbsp;</p><p>2.加入打散的雞蛋攪拌均勻&nbsp;</p><p>3.用篩子過濾鮮奶蛋液(最好過濾2次.口感更細滑)</p><p>&nbsp;4.鮮奶蛋液倒入瓶器約8分滿&nbsp;</p><p>5.電鍋外鍋加1.5杯水、擺上蒸架、放上瓶器&nbsp;</p><p>6.上蓋夾筷子留一小隙縫、按下開關加熱(留一小隙縫是怕溫度太高變蒸蛋)</p><p>7.跳起之後會轉保溫～如果因為蛋液比較多還沒全熟可以蓋緊上蓋再悶一下</p><p>8.起鍋後先放涼再吃～會是超濃郁的奶蛋香哦！<br>&nbsp;</p>', 14, CAST(N'2022-07-01' AS Date), N'https://i.imgur.com/S8TpcPH.jpg', N'一起來做雞蛋布丁吧', N'食譜討論', 2)
INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (3, N'<p>在家做蛋糕時，常常遇到以下困擾嗎~</p><p>#蛋白老是打不好？</p><p>#蛋糕捲怎麼捲就是都捲不起來嗎~</p><p>#怎麼捲都會裂 ~</p><p>&nbsp;看過來看過來~~ 這堂講堂黃建勳老師的教大家獨家的「黃式蛋白打法」&nbsp;</p><p>將您的蛋糕製作技巧實實在在的?根打底， 做出碰塞塞、細緻又濕潤的蛋糕 有年紀的金皮巧克力蛋糕捲，</p><p>用更精緻的手法來操作，讓您的古早味更加昇華 全乳脂完全無水配方搭配青蔥肉鬆，</p><p>鹹香好滋味 超精彩講堂，還不馬上報名去！<br>&nbsp;</p>', 12, CAST(N'2022-06-30' AS Date), N'https://i.imgur.com/E5JFGAh.jpg', N'●【甜點講堂｜ 黃建勳 （Jerry Huang） ：金皮蛋糕捲、全乳脂青蔥肉鬆捲】●', N'課程資訊', 1)
INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (4, N'<p>一年一度的母親節又來了，BakeYourLife會員有回饋，提供了100元購物金，歡迎大家到我們的商城採買~</p>', 25, CAST(N'2022-05-10' AS Date), N'https://i.imgur.com/zbzEEl0.jpg', N'BakeYourLife會員優惠券', N'活動資訊', 1)
INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (5, N'<p>◆瑪德蓮材料</p><p>無鹽奶油 60g</p><p>低筋麵粉 60g</p><p>細砂糖 50g</p><p>雞蛋一顆</p><p>泡打粉 2g</p><p>◆瑪德蓮作法</p><p>1. 雞蛋與砂糖一起打散，攪拌至砂糖融入蛋液中即可&nbsp;</p><p><br>2. 低筋麵粉、泡打粉過篩後加入蛋液中拌勻</p><p><br>3.最後倒入放涼的融化奶油，拌勻即可，做好的麵糊裝進擠花袋中，在冰箱內冰一晚，或至少一小時唷&nbsp;。完成的麵糊以刮刀提起流下時，會呈現緞帶般的折疊痕跡<br>&nbsp;</p><p>4. 模型中塗上奶油、撒上低筋麵粉做防沾<br>&nbsp;</p><p>&nbsp;5. 因為麵糊中奶油比例很高，剛從冰箱取出時麵糊偏硬，<br>記得先放在室溫下20～30分鐘退冰 將麵糊以Z字型方式擠入烤盤約八分滿，擠好後稍微敲打或摔一下烤模，<br>讓麵糊中的空氣排出放入已預熱的烤箱中，<br>以200度烘烤10～15分鐘即可，烤完後要立即取出脫膜，<br>以免冷掉反而無法脫模。<br>每個人家中的烤箱/氣炸鍋火力不同，烘烤時間請依照自家狀況調整。</p>', 20, CAST(N'2022-07-09' AS Date), N'https://i.imgur.com/YOsSagn.jpg', N'瑪德蓮食譜', N'食譜討論', 2)
INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (6, N'<p>全新課程</p><p>燕麥奶與豆漿讓吐司更美味的秘密</p><p>期待許久的張錫源老師來了~~</p><p>擁有20多年烘焙經歷的張錫源老師，對烘焙有強大的熱忱，</p><p>老師持續不斷地自我充實，不藏私將許多烘焙技術傳授給學員們<img src="https://static.xx.fbcdn.net/images/emoji.php/v9/tf6/3/16/2728.png" alt="?"></p><p>這次老師幫我們帶來了兩款吐司</p><p><img src="https://static.xx.fbcdn.net/images/emoji.php/v9/t19/3/16/1f35e.png" alt="??">燕麥奶麥粒吐司</p><p><img src="https://static.xx.fbcdn.net/images/emoji.php/v9/t19/3/16/1f35e.png" alt="??">紫米豆漿吐司</p><p>這堂課您將會學到</p><p>麵團攪打判斷、麵團溫度掌握</p><p>麵團食材講解說明</p><p>如何運用燕麥奶與牛奶結合，達到風味及價值的平衡點(非使用百分百燕麥奶喔)</p><p>如何運用熟紫米與豆漿，讓吐司風味更增加風味及口感</p><p>成品的保存注意事項</p><p>超精彩講堂絕對不要錯過~~</p><p>7/21(日)報名<a href="https://forms.gle/WHF6UXBn5KohViai7?fbclid=IwAR0ILS8hAhLzed8m2qlLOOPS4XAv84HBsQ_hJF6zWcZQAC8mGmQ6cCmOoJA">https://forms.gle/WHF6UXBn5KohViai7</a></p><p>&nbsp;</p><p>講堂教師：張錫源</p><p>講堂日期：7月21日(四)13:00~16:30</p><p>講堂費用：2,200元 (含稅)</p><p>講堂內容：</p><p><img src="https://static.xx.fbcdn.net/images/emoji.php/v9/t19/3/16/1f35e.png" alt="??">燕麥奶麥粒吐司</p><p><img src="https://static.xx.fbcdn.net/images/emoji.php/v9/t19/3/16/1f35e.png" alt="??">紫米豆漿吐司</p><p>課後可帶回吐司各一條</p><p>＿＿＿＿＿＿＿＿＿＿＿＿＿</p><p><img src="https://static.xx.fbcdn.net/images/emoji.php/v9/tf6/3/16/2728.png" alt="?"> 更多張錫源老師的精彩講堂<img src="https://static.xx.fbcdn.net/images/emoji.php/v9/tf6/3/16/2728.png" alt="?"></p>', 9, CAST(N'2022-07-15' AS Date), N'https://i.imgur.com/B1xCxVB.jpg', N'★【麵包講堂｜ 張錫源 （Aaron Chang） ：燕麥奶與豆漿的吐司運用】★', N'課程資訊', 1)
INSERT [dbo].[article] ([postid], [content], [counter], [date], [image_url], [title], [type], [user_id]) VALUES (7, N'<p>從今天起台灣在地小農可自行上架農產品，讓你在家就可輕鬆買到新鮮、優質的商品</p>', 16, CAST(N'2022-07-14' AS Date), N'https://i.imgur.com/RrV9MDW.png', N'歡迎小農廠商加入BakeYourLife', N'活動資訊', 1)
SET IDENTITY_INSERT [dbo].[article] OFF

--新增留言資料
SET IDENTITY_INSERT [dbo].[message] ON

INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (1, CAST(N'2022-07-20T10:47:34.8140000' AS DateTime2), N'https://i.imgur.com/lNPl7Qy.jpg', N'想請問上課時間~',  3, 2)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (2, CAST(N'2022-07-20T10:51:49.6880000' AS DateTime2), N'https://i.imgur.com/w4r4lCj.jpg', N'adgfhkokd', 3, 3)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (3, CAST(N'2022-07-20T10:54:14.5620000' AS DateTime2), N'https://i.imgur.com/v3UKiPB.png', N'好讚!加入會員有優惠!', 4, 4)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (4, CAST(N'2022-07-20T10:58:06.7900000' AS DateTime2), N'https://i.imgur.com/KaKjwkC.jpg', N'很喜歡張錫源老師的課~
希望下次他還會來Bake Your Life 開課!謝謝~
附上自己在家做的成品~~~', 6, 2)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (5, CAST(N'2022-07-20T11:00:47.6660000' AS DateTime2), N'https://i.imgur.com/C48h41n.png', N'哇!竟然也結合了在地小農!
可以輕鬆買到農產品很棒耶~', 7, 3)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (6, CAST(N'2022-07-20T11:03:32.8690000' AS DateTime2), N'https://i.imgur.com/m3KXoIT.jpg', N'謝謝你的分享!
之前做瑪德蓮一直失敗，
自從使用你的做法就成功了。
收穫良多，謝謝!', 5, 4)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (8, CAST(N'2022-07-21T12:37:34.5490000' AS DateTime2), N'https://i.imgur.com/DL0IXBG.png', N'超喜歡檸檬磅蛋糕的，
謝謝分享~', 1, 2)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (9, CAST(N'2022-07-21T12:39:20.2320000' AS DateTime2), N'https://i.imgur.com/DwdWRwJ.jpg', N'小朋友吃了布丁很喜歡!', 2, 4)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (10, CAST(N'2022-07-21T12:40:09.9350000' AS DateTime2), N'https://i.imgur.com/LZrKOSV.jpg', N'好喜歡瑪德蓮~!', 5, 3)
INSERT [dbo].[message] ([message_id], [date_time], [image_url], [message], [postid], [user_id]) VALUES (11, CAST(N'2022-07-21T12:42:30.4100000' AS DateTime2), N'https://i.imgur.com/2ouaQzc.png', N'有小農直送的農產品!', 7, 2)
SET IDENTITY_INSERT [dbo].[message] OFF

--新增評論假資料

INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2), NULL, 1, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'普普通通 = =', 3, CAST(N'2022-03-21T14:48:11.2150000' AS DateTime2), NULL, 1, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), NULL, 1, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), NULL, 3, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 4, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2), NULL, 5, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'普普通通 = =', 3, CAST(N'2022-03-21T14:48:11.2150000' AS DateTime2), 5, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), NULL, 6, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), NULL, 7, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 6, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 15, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 1, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 3, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2),1, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 18, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 19, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 16, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'普普通通 = =', 3, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2),17, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2), 21, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 20, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 20, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 21, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'普普通通 = =', 3, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2),21, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2), 21, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 22, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 23, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2), 21, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 20, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 20, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 21, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'普普通通 = =', 3, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2),21, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2), 21, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'普普通通 = =', 3, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2),23, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'難吃', 1, CAST(N'2022-05-21T14:48:11.2150000' AS DateTime2), 22, NULL, 2)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 23, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 24, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2),25, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 3, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 4, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 5, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好讚 太讚了ㄅ', 5, CAST(N'2022-01-21T14:48:11.2380000' AS DateTime2), 6, NULL, 3)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 7, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 13, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 9, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 10, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'好好吃 還會再買', 4, CAST(N'2022-02-21T14:48:11.2380000' AS DateTime2), 11, NULL, 4)
INSERT [dbo].[product_comment] ( [comment_content], [star], [time], [farmer_product_id], [goods_id], [user_id]) VALUES ( N'太貴了啦', 2, CAST(N'2022-04-21T14:48:11.2380000' AS DateTime2),12, NULL, 3)
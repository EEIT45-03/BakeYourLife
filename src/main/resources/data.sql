--新增小農廠商資料
SET
IDENTITY_INSERT [dbo].[farmers] ON

INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username]) VALUES (1, N'320桃園市中壢區新生路二段421號', N'ROLE_FARMER', N'ddfoew133@gmail.com', N'123', N'聖德小農', N'https://i.imgur.com/xZPc9iL.jpg', N'$2a$10$/8NjHp7kfnUPJhqjh3isaOXMrYTGIq89dmDoF4XvO5hY2gifSSxZu', N'0998765432', CAST(N'2022-07-14T10:16:40.5780000' AS DateTime2), N'a123456')
SET IDENTITY_INSERT [dbo].[farmers] OFF

--一般商品

SET IDENTITY_INSERT [dbo].[member_goods_table3] ON

INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (1, CAST(N'2022-07-17T15:59:46.5650000' AS DateTime2), N'6', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/z2JaiX7.jpg,https://i.imgur.com/Ez9ThcI.jpg,https://i.imgur.com/MT924wB.jpg', N'北海道優質麵粉', N'日本', N'麵粉', N'59', N'否', N'2023-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (2, CAST(N'2022-07-17T15:59:52.5310000' AS DateTime2), N'73', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/xddgnal.jpg,https://i.imgur.com/XTb16wM.jpg,https://i.imgur.com/XPVD7xN.jpg', N'巧克力', N'台灣', N'巧克力', N'92', N'否', N'2023-07-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (3, CAST(N'2022-07-17T15:59:58.6740000' AS DateTime2), N'81', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/dYjHIAM.jpg,https://i.imgur.com/4QkXZGZ.jpg,https://i.imgur.com/obvVijn.jpg', N'乳酪蛋糕', N'紐西蘭', N'乳製品', N'159', N'否', N'2023-08-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (4, CAST(N'2022-07-17T16:00:06.6020000' AS DateTime2), N'49', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/4Ccy2GF.jpg,https://i.imgur.com/2LTuRm0.jpg,https://i.imgur.com/VaM8Xom.jpg', N'玫瑰鹽', N'日本', N'頂級鹽品', N'180', N'否', N'2023-09-05', N'常溫', NULL, N'已下架')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (5, CAST(N'2022-07-17T16:00:13.1610000' AS DateTime2), N'46', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/E0m0Leh.jpg,https://i.imgur.com/VWtSK8Z.jpg,https://i.imgur.com/tj8EvAT.jpg', N'堅果', N'日本', N'堅果乾', N'96', N'否', N'2023-10-05', N'常溫', NULL, N'已下架')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (18, CAST(N'2022-07-17T16:00:19.6520000' AS DateTime2), N'7', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/C1a4sa7.jpg,https://i.imgur.com/mMyE7ml.jpg,https://i.imgur.com/yvqQIlh.jpg', N'高筋麵粉', N'日本', N'麵粉', N'100', N'否', N'2023-11-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (19, CAST(N'2022-07-17T16:00:25.6360000' AS DateTime2), N'9', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉、茶葉', NULL, N'https://i.imgur.com/f6kfTrz.jpg,https://i.imgur.com/cpJfwpx.jpg,https://i.imgur.com/lgHfZu4.jpg', N'山茶花麵粉', N'台灣', N'麵粉', N'66', N'否', N'2023-12-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (20, CAST(N'2022-07-17T16:00:32.3320000' AS DateTime2), N'4', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/ET2w8Yp.jpg,https://i.imgur.com/qA9JoWz.jpg,https://i.imgur.com/ESgHOAH.jpg', N'沖繩高筋麵粉', N'日本', N'麵粉', N'165', N'否', N'2023-01-04', N'冷藏', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (21, CAST(N'2022-07-17T16:00:39.1940000' AS DateTime2), N'4', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/XcmhNzV.jpg,https://i.imgur.com/ZyAxPQq.jpg,https://i.imgur.com/V2bfFY3.jpg', N'江西製麵粉', N'浙江', N'麵粉', N'57', N'否', N'2023-02-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (22, CAST(N'2022-07-17T16:00:45.2050000' AS DateTime2), N'1', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/XZTsagO.jpg,https://i.imgur.com/EVd5h11.jpg,https://i.imgur.com/wJiMsN4.jpg', N'黑龍麵粉', N'日本', N'麵粉', N'119', N'否', N'2023-03-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (23, CAST(N'2022-07-17T16:00:56.0950000' AS DateTime2), N'7', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/2rWuweQ.jpg,https://i.imgur.com/693zedW.jpg,https://i.imgur.com/UFuhUe2.jpg', N'義大利麵粉', N'義大利', N'麵粉', N'167', N'否', N'2023-04-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (24, CAST(N'2022-07-17T16:01:48.7440000' AS DateTime2), N'6', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/a3R21ka.jpg,https://i.imgur.com/7gcH9Vr.jpg,https://i.imgur.com/kKT0bol.jpg', N'中筋麵粉', N'日本', N'麵粉', N'37', N'否', N'2023-05-07', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (25, CAST(N'2022-07-17T16:01:15.8370000' AS DateTime2), N'7', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/rKDiJHE.jpg,https://i.imgur.com/tQ4fPDw.jpg,https://i.imgur.com/zPfJnWl.jpg', N'低筋麵粉', N'日本', N'麵粉', N'69', N'否', N'2023-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (26, CAST(N'2022-07-17T16:01:23.7520000' AS DateTime2), N'63', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/o5drCcA.jpg,https://i.imgur.com/g5D6GFN.jpg,https://i.imgur.com/dbxAkns.jpg', N'法式巧克力', N'法國', N'巧克力', N'144', N'否', N'2023-07-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (27, CAST(N'2022-07-17T16:01:56.7360000' AS DateTime2), N'12', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'可可粉', NULL, N'https://i.imgur.com/VXJGh3T.jpg', N'義大利經典巧克力', N'義大利', N'巧克力', N'67', N'否', N'2023-08-07', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (28, CAST(N'2022-07-17T16:01:41.1590000' AS DateTime2), N'80', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/4EkTZLk.jpg', N'南非經典巧克力', N'南非', N'巧克力', N'159', N'否', N'2023-09-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (29, CAST(N'2022-07-17T16:01:32.2660000' AS DateTime2), N'33', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/IbR43Xy.jpg', N'巴西黑巧克力', N'巴西', N'巧克力', N'201', N'否', N'2030-10-04', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [sales], [savetime], [saveway], [stars], [system]) VALUES (30, CAST(N'2022-07-17T16:01:06.6550000' AS DateTime2), N'87', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/Yd1tZYc.jpg', N'西班牙純巧克力', N'西班牙', N'巧克力', N'259', N'否', N'2023-12-15', N'常溫', NULL, N'上架中')
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
INSERT INTO users(address,birth,email,full_name,gender,password,phone,register_time,username,authority,image_url) VALUES (N'桃園市中壢區新生路二段421號', N'1993-08-19', N'ddfoew133@gmail.com', N'測試會員', N'男', N'$2a$10$L6rXqpJopBrColGAahlYrOy6MWDIxAVQFJI3Ttrd31ZCoqK0x6gmS', N'0956326532', GETDATE(), N'usertest1',N'ROLE_USER',N'https://i.imgur.com/gEHJxsi.jpg')


--新增器具類別
INSERT INTO tackle_sort(sort) VALUES('烤箱');
INSERT INTO tackle_sort(sort) VALUES('攪拌器');
INSERT INTO tackle_sort(sort) VALUES('刮刀');

--新增器具
INSERT INTO tackle(damages,day_price,max,notes,picture,specification,tackle_name, fk_sort_id) VALUES (1200,50,50,NULL,'https://i.imgur.com/S3DqPbq.png','PANASONIC NBH3200','32L電烤箱', 1);
INSERT INTO tackle(damages,day_price,max,notes,picture,specification,tackle_name, fk_sort_id) VALUES (1500,50,50,NULL,'https://i.imgur.com/3KpunET.png','PANASONIC NB-H3801','38L電烤箱', 1);
INSERT INTO tackle(damages,day_price,max,notes,picture,specification,tackle_name, fk_sort_id) VALUES (500,50,50,NULL,'https://i.imgur.com/J2wbBdf.png','PANASONIC MX-SS2','手持式攪拌棒', 2);
INSERT INTO tackle(damages,day_price,max,notes,picture,specification,tackle_name, fk_sort_id) VALUES (200,30,80,NULL,'https://i.imgur.com/4P4hQAU.png','SN4889','打蛋器', 2);
INSERT INTO tackle(damages,day_price,max,notes,picture,specification,tackle_name, fk_sort_id) VALUES (100,25,100,NULL,'https://i.imgur.com/9Mi01IL.png','CakeLand','矽膠刮刀', 3);


--新增場地類別
INSERT INTO venue_sort(sort) VALUES('課用烘培室');
INSERT INTO venue_sort(sort) VALUES('獨立烘培室');
INSERT INTO venue_sort(sort) VALUES('小型烘培室');
INSERT INTO venue_sort(sort) VALUES('大型烘培室');


--新增場地
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (2,'A201',30,'https://i.imgur.com/ZjKfu38.jpg',NULL,2);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (2,'A202',30,'https://i.imgur.com/4KAEu5T.jpg',NULL,2);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (2,'A203',30,'https://i.imgur.com/WTCSrKe.jpg',NULL,2);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (2,'A204',30,'https://i.imgur.com/WTCSrKe.jpg',NULL,2);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (2,'A205',30,'https://i.imgur.com/WTCSrKe.jpg',NULL,2);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (5,'B201',30,'https://i.imgur.com/ecdjZkm.jpg',NULL,3);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (5,'B202',30,'https://i.imgur.com/i0z2ejz.jpg',NULL,3);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (5,'B203',30,'https://i.imgur.com/RjYjbA5.jpg',NULL,3);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (15,'B301',30,'https://i.imgur.com/RjYjbA5.jpg',NULL,4);
INSERT INTO venue(person_max,venue_name,hr_price,picture,notes,fk_sort_id) VALUES (15,'B401',30,'https://i.imgur.com/RjYjbA5.jpg',NULL,4);



--新增訂單資料
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-07-06T22:35:24.6900000' AS DateTime2), N'202207062235245', N'完成', CAST(N'2022-07-06T22:35:57.5750000' AS DateTime2), 0, CAST(N'2022-07-06T22:42:52.8590000' AS DateTime2), 100, 958, N'111111111111', NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-06-06T22:36:13.6490000' AS DateTime2), N'202207062236137', N'退款審核中', CAST(N'2022-07-06T22:36:33.0420000' AS DateTime2), 1, CAST(N'2022-07-06T22:42:56.1490000' AS DateTime2), 100, 899, N'', NULL, 2,'等太久')
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-05-06T22:37:36.7950000' AS DateTime2), N'202207062237369', N'退款審核中', CAST(N'2022-07-06T22:38:01.3090000' AS DateTime2), 0, NULL, 100, 1698, NULL, NULL, 2,'我不想買了')
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-04-06T22:38:22.6500000' AS DateTime2), N'202207062238220', N'待出貨', CAST(N'2022-07-06T22:38:34.1380000' AS DateTime2), 1, CAST(N'2022-07-06T22:43:00.0770000' AS DateTime2), 100, 2497, N'', NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-03-06T22:38:54.8850000' AS DateTime2), N'202207062238548', N'待付款', NULL, 0, NULL, 100, 899, NULL, NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-02-06T22:39:13.2840000' AS DateTime2), N'202207062239134', N'待出貨', CAST(N'2022-07-06T22:39:22.9590000' AS DateTime2), 1, CAST(N'2022-07-06T22:43:03.0060000' AS DateTime2), 100, 899, N'', NULL, 2)
INSERT INTO orders (address, is_review, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, 0, CAST(N'2022-01-06T22:40:25.7620000' AS DateTime2), N'202207062240251', N'待出貨', CAST(N'2022-07-06T22:40:46.1170000' AS DateTime2), 0, CAST(N'2022-07-06T22:43:08.5550000' AS DateTime2), 100, 899, N'', NULL, 2)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 1)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 2)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 2, 1598, 3)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 3, 2397, 4)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 5)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 6)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 7)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'北海道優質麵粉', N'G1', N'烘培材料', 1, 59, 1)


--新增課程資料
SET IDENTITY_INSERT [dbo].[course_prodcut] ON
INSERT [dbo].[course_prodcut] ([id], [description], [image], [name], [price], [summary]) VALUES (1, N'單元一：烘培食品概論(麵包、蛋糕、西點)、產品分類、原料特性、製程解說及分析、烘培計算及配方範圍演算。單元二：圓頂奶油土司、奶油空心餅(泡芺)', N'https://i.imgur.com/hunDTmc.jpg', N'丙級西點烘焙下午班', 14000, N'烘培食品概論(麵包、蛋糕、西點)圓頂奶油土司、奶油空心餅(泡芺)')
INSERT [dbo].[course_prodcut] ([id], [description], [image], [name], [price], [summary]) VALUES (2, N'單元一：烘培食品概論(麵包、蛋糕、西點)、產品分類、原料特性、製程解說及分析、烘培計算及配方範圍演算。單元二：圓頂奶油土司、奶油空心餅(泡芺)', N'https://i.imgur.com/2UnR7Lm.jpg', N'乙級麵包烘焙假日班', 14000, N'烘培食品概論(麵包、蛋糕、西點)圓頂奶油土司、奶油空心餅(泡芺)')
INSERT [dbo].[course_prodcut] ([id], [description], [image], [name], [price], [summary]) VALUES (3, N'單元一：烘培食品概論(麵包、蛋糕、西點)、產品分類、原料特性、製程解說及分析、烘培計算及配方範圍演算。單元二：圓頂奶油土司、奶油空心餅(泡芺)', N'https://i.imgur.com/Fd0KQoL.jpg', N'乙級蛋糕烘焙晚上班', 14000, N'烘培食品概論(麵包、蛋糕、西點)圓頂奶油土司、奶油空心餅(泡芺)')
SET IDENTITY_INSERT [dbo].[course_prodcut] OFF
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1000, 0, CAST(N'2022-08-25T01:00:00.0000000' AS DateTime2), 60, N'', CAST(N'2022-08-22T01:00:00.0000000' AS DateTime2), N'TeacherChen', 1, 1)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1001, 0, CAST(N'2022-08-26T01:00:00.0000000' AS DateTime2), 12, N'', CAST(N'2022-08-23T01:00:00.0000000' AS DateTime2), N'TeacherLin', 1, 1)
INSERT [dbo].[course] ([open_course], [applicants], [end_date], [hours], [note], [start_date], [teacher], [fk_c_product_id], [fk_venue_id]) VALUES (1002, 0, CAST(N'2022-08-27T01:00:00.0000000' AS DateTime2), 15, N'', CAST(N'2022-08-24T01:00:00.0000000' AS DateTime2), N'TeacherWang', 2, 1)
SET IDENTITY_INSERT [dbo].[course_time] ON
INSERT [dbo].[course_time] ([ctime_id], [ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (1, CAST(N'2022-08-29T10:00:00.0000000' AS DateTime2), N'10001', N'', CAST(N'2022-08-29T12:00:00.0000000' AS DateTime2), 1000)
INSERT [dbo].[course_time] ([ctime_id], [ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (2, CAST(N'2022-08-30T10:00:00.0000000' AS DateTime2), N'10002', N'', CAST(N'2022-08-30T12:00:00.0000000' AS DateTime2), 1000)
INSERT [dbo].[course_time] ([ctime_id], [ctime_end_date], [ctime_no], [ctime_note], [ctime_start_date], [fk_op_course_id]) VALUES (3, CAST(N'2022-08-31T10:00:00.0000000' AS DateTime2), N'10002', N'', CAST(N'2022-08-31T12:00:00.0000000' AS DateTime2), 1000)
SET IDENTITY_INSERT [dbo].[course_time] OFF
--新增報名資料
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [fk_op_course], [fk_user_id]) VALUES (8801, 1, CAST(N'2022-01-01T11:00:00.0000000' AS DateTime2), 1, 1000, 1)
INSERT [dbo].[course_register] ([register_id], [attendance], [register_date], [state], [fk_op_course], [fk_user_id]) VALUES (8802, 3, CAST(N'2022-01-02T11:00:00.0000000' AS DateTime2), 1, 1001, 1)

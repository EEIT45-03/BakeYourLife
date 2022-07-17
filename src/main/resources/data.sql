--新增小農廠商資料
SET
IDENTITY_INSERT [dbo].[farmers] ON

INSERT [dbo].[farmers] ([farmer_id], [address], [authority], [email], [farmer_info], [farmer_name], [image_url], [password], [phone], [register_time], [username]) VALUES (1, N'320桃園市中壢區新生路二段421號', N'ROLE_FARMER', N'ddfoew133@gmail.com', N'123', N'聖德小農', N'https://i.imgur.com/xZPc9iL.jpg', N'$2a$10$/8NjHp7kfnUPJhqjh3isaOXMrYTGIq89dmDoF4XvO5hY2gifSSxZu', N'0998765432', CAST(N'2022-07-14T10:16:40.5780000' AS DateTime2), N'a123456')
SET IDENTITY_INSERT [dbo].[farmers] OFF

--一般商品

SET IDENTITY_INSERT [dbo].[member_goods_table3] ON

INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (1, CAST(N'2022-07-14T10:34:27.9120000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/z2JaiX7.jpg,https://i.imgur.com/Ez9ThcI.jpg,https://i.imgur.com/MT924wB.jpg', N'北海道優質麵粉', N'日本', N'原裝利樂包', N'59', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (2, CAST(N'2022-07-14T10:35:59.2000000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/xddgnal.jpg,https://i.imgur.com/XTb16wM.jpg,https://i.imgur.com/XPVD7xN.jpg', N'巧克力', N'日本', N'原裝利樂包', N'59', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (3, CAST(N'2022-07-14T10:38:42.4570000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/dYjHIAM.jpg,https://i.imgur.com/4QkXZGZ.jpg,https://i.imgur.com/obvVijn.jpg', N'乳酪蛋糕', N'日本', N'原裝利樂包', N'59', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (4, CAST(N'2022-07-14T10:41:26.8620000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/4Ccy2GF.jpg,https://i.imgur.com/2LTuRm0.jpg,https://i.imgur.com/VaM8Xom.jpg', N'玫瑰鹽', N'日本', N'原裝利樂包', N'180', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (5, CAST(N'2022-07-14T10:43:13.8320000' AS DateTime2), N'60', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/E0m0Leh.jpg,https://i.imgur.com/VWtSK8Z.jpg,https://i.imgur.com/tj8EvAT.jpg', N'堅果', N'日本', N'原裝利樂包', N'79', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (18, CAST(N'2022-07-14T11:13:27.1740000' AS DateTime2), N'91', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/C1a4sa7.jpg,https://i.imgur.com/mMyE7ml.jpg,https://i.imgur.com/yvqQIlh.jpg', N'高筋麵粉', N'日本', N'透明夾鏈立袋', N'69', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (19, CAST(N'2022-07-14T11:18:13.7960000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉、茶葉', NULL, N'https://i.imgur.com/f6kfTrz.jpg,https://i.imgur.com/cpJfwpx.jpg,https://i.imgur.com/lgHfZu4.jpg', N'山茶花麵粉', N'日本', N'原裝利樂包', N'59', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (20, CAST(N'2022-07-14T11:27:26.3600000' AS DateTime2), N'40', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/ET2w8Yp.jpg,https://i.imgur.com/qA9JoWz.jpg,https://i.imgur.com/ESgHOAH.jpg', N'沖繩高筋麵粉', N'日本', N'保溫錫箔紙', N'165', N'2022-06-05', N'冷藏', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (21, CAST(N'2022-07-14T11:29:16.4020000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/XcmhNzV.jpg,https://i.imgur.com/ZyAxPQq.jpg,https://i.imgur.com/V2bfFY3.jpg', N'江西製麵粉', N'日本', N'原裝利樂包', N'64', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (22, CAST(N'2022-07-14T11:30:29.3120000' AS DateTime2), N'70', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/XZTsagO.jpg,https://i.imgur.com/EVd5h11.jpg,https://i.imgur.com/wJiMsN4.jpg', N'黑龍麵粉', N'日本', N'透明夾鏈立袋', N'119', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (23, CAST(N'2022-07-14T11:32:47.7800000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/2rWuweQ.jpg,https://i.imgur.com/693zedW.jpg,https://i.imgur.com/UFuhUe2.jpg', N'義大利麵粉', N'義大利', N'原裝利樂包', N'67', N'2022-09-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (24, CAST(N'2022-07-14T11:36:19.4980000' AS DateTime2), N'66', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/a3R21ka.jpg,https://i.imgur.com/7gcH9Vr.jpg,https://i.imgur.com/kKT0bol.jpg', N'中筋麵粉', N'日本', N'原裝利樂包', N'78', N'2022-11-07', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (25, CAST(N'2022-07-14T11:40:01.9880000' AS DateTime2), N'74', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/rKDiJHE.jpg,https://i.imgur.com/tQ4fPDw.jpg,https://i.imgur.com/zPfJnWl.jpg', N'低筋麵粉', N'日本', N'原裝利樂包', N'69', N'2022-06-05', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (26, CAST(N'2022-07-14T11:48:06.7270000' AS DateTime2), N'50', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/o5drCcA.jpg,https://i.imgur.com/g5D6GFN.jpg,https://i.imgur.com/dbxAkns.jpg', N'法式巧克力', N'日本', N'原裝利樂包', N'59', N'2022-09-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (27, CAST(N'2022-07-14T11:50:38.2770000' AS DateTime2), N'503', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'可可粉', NULL, N'https://i.imgur.com/VXJGh3T.jpg', N'義大利經典巧克力', N'日本', N'原裝利樂包', N'159', N'2022-06-07', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (28, CAST(N'2022-07-14T11:54:44.5630000' AS DateTime2), N'80', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/4EkTZLk.jpg', N'南非經典巧克力', N'南非', N'原裝利樂包', N'159', N'2022-09-09', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (29, CAST(N'2022-07-14T11:55:40.4540000' AS DateTime2), N'40', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/IbR43Xy.jpg', N'巴西黑巧克力', N'巴西', N'原裝利樂包', N'200', N'2030-08-04', N'常溫', NULL, N'上架中')
INSERT [dbo].[member_goods_table3] ([id], [admission_time], [count], [describe], [element], [evaluation], [image_url], [name], [origin], [packagematerial], [packages], [savetime], [saveway], [stars], [system]) VALUES (30, CAST(N'2022-07-14T11:56:21.9760000' AS DateTime2), N'150', N'以黑麥、小麥等糧食作物為基本原料，先磨成粉，再加水、鹽、酵母等和面並製成麵團坯料，然後再以烘、烤、蒸或煎等方式加熱製成的食品。麵包有時候也含有其他成分，例如牛奶、雞蛋、糖、香料、水果、果仁等等。麵包是最古老的加工食品之一，在新石器時代已經出現。  通常提到麵包，大都會想到歐美麵包的夾餡麵包、甜麵包等。其實，按照上述的定義劃分，麵包這一食品範圍更加廣泛，世界上還有許多特殊種類的麵包。  世界上廣泛使用的製作麵包的原料除了黑麥粉、小麥粉以外，還有蕎麥粉、糙米粉、玉米粉等。有些麵包經酵母發酵，在烘烤過程中變得更加彭鬆柔軟；亦有剛好相反的麵包，不需要經過發酵。儘管原料和製作工藝不盡相同，它們都被稱為麵包。', N'小麥粉', NULL, N'https://i.imgur.com/Yd1tZYc.jpg', N'西班牙純巧克力', N'西班牙', N'原裝利樂包', N'259', N'2020-12-15', N'常溫', NULL, N'上架中')
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


--新增器具類別
INSERT INTO tackle_sort(sort) VALUES('烤箱');
INSERT INTO tackle_sort(sort) VALUES('模具');
INSERT INTO tackle_sort(sort) VALUES('容器');
INSERT INTO tackle_sort(sort) VALUES('濾網/篩具');
INSERT INTO tackle_sort(sort) VALUES('桿麵棍');
INSERT INTO tackle_sort(sort) VALUES('攪拌用具');
INSERT INTO tackle_sort(sort) VALUES('刷具');
INSERT INTO tackle_sort(sort) VALUES('刀具/切割工具');
INSERT INTO tackle_sort(sort) VALUES('測量工具');
INSERT INTO tackle_sort(sort) VALUES('擠花/翻糖工具');

--新增器具
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (4740,30,50,'NB-H3801 大容量、發酵烘烤一機完成。
                                                                                                         ●3D熱風對流 - 大火力立體熱風對流烘烤,全面包圍時才,不易烤焦,油切更健康。
                                                                                                         ●上下獨立控溫滿足各種火力需求 - 上火+下火雙重控溫:上火、下火可同時設定不同溫度,滿足多種食材不同厚度的火裡需求。
                                                                                                         ●發酵行程 發酵烘培一機完成 - 結合發酵箱功能,一次滿足發酵與烘培需求,選擇發酵行程,無須再另外設定溫度就能維持30度~50度C最佳發酵環境。

                                                                                                         ●附加設備 - 琺瑯烤盤、琺瑯深烤盤、烤網、抽取式集屑盤、取物夾、取物支架。','PANASONIC NB-H3801','38L電烤箱', 1);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2950,50,50,'NB-H3203 大容量、發酵烘烤一機完成。
                                                                                                         ●雙層防燙隔熱門 - 防止烘烤過程中誤觸玻璃門而燙傷,同時擁有更良好的聚熱功能,效率更提升。
                                                                                                         ●360度自動旋轉燒烤 - 自動旋轉烘烤,不會過焦或不熟,全面均勻受熱,不遺漏任何一處的美味。
                                                                                                         ●3D熱風對流 - 大火力立體熱風對流烘烤,全面包圍時才,不易烤焦,油切更健康。
                                                                                                         ●上下獨立控溫滿足各種火力需求 - 上火+下火雙重控溫:上火、下火可同時設定不同溫度,滿足多種食材不同厚度的火裡需求。
                                                                                                         ●發酵行程 發酵烘培一機完成 - 結合發酵箱功能,一次滿足發酵與烘培需求,選擇發酵行程,無須再另外設定溫度就能維持30度~50度C最佳發酵環境。

                                                                                                         ●附加設備 - 琺瑯烤盤、琺瑯深烤盤、烤網、抽取式集屑盤、取物夾、取物支架','PANASONIC  NB-H3203','32L電烤箱', 1);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (500,10,100,'產地：台灣。

                                                                                                        成份：鋁合金(耐溫230度)。
                                                                                                        規格：最長約5公分、寬約4公分、高約2.2公分，每組五入。','鳳梨酥模具組_鋁合金小兔頭_5入_T213016','鳳梨酥模具+壓棒(兔子)', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (500,10,100,'產地：台灣。

                                                                                                         成份：鋁合金(耐溫230度)。
                                                                                                         規格：最長約4.6公分、寬約4.5公分、高約2.2公分，每組五入。','鳳梨酥模具組_鋁合金小熊頭_5入_T213015','鳳梨酥模具+壓棒(小熊)', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2000,10,80,'產地：日本。

                                                                                                         成份：鍍錫鋼片。
                                                                                                         規格：整體長約30公分、寬約22公分、高約2公分，置物最長約5.5公分、寬約5公分、高約2公分/共12連。','多連烤盤_MATSUNAGA雙心12連_126-19B','雙心12連模具', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2200,10,80,'產地：日本。

                                                                                                         成份：鍍錫鋼片。
                                                                                                         規格：整體長約30公分、寬約22公分、高約2公分，置物最長約5公分、寬約5公分、高約2公分/共12連。','多連烤盤_MATSUNAGA栗子12連_126-18','栗子12連模具', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (2350,10,80,'產地：日本。

                                                                                                         成份：鍍錫鋼片。
                                                                                                         規格：整體長約30公分、寬約22公分、高約1.7公分，置物最長約5公分、寬約3.5公分、高約1.7公分/共15連。','多連烤盤_MATSUNAGA瑪德蓮15連_126-13','瑪德蓮15連模具', 2);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (300,15,50,'產地：日本。

                                                                                                        材質：耐熱玻璃(耐熱溫差120度)。
                                                                                                        尺寸規格 : 直徑長約15.6公分、高約10.2公分。直徑長約21公分、高約12公分。
                                                                                                        容量：(S)900ml/(M)1500ml/(L)2200ml。
                                                                                                        商品重量：約2.45公斤。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔','玻璃盆_MXPN-3704','玻璃盆', 3);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (390,15,50,'產地：中國。

                                                                                                        材質：不鏽鋼。
                                                                                                        尺寸規格 : 直徑長約20公分、高約12公分。
                                                                                                        商品重量：約470公克。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔、放入微波爐','深型打蛋盆20cm_WK9364','20cm不鏽鋼盆', 3);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (350,15,40,'產地：中國。

                                                                                                        材質：不鏽鋼。
                                                                                                        尺寸規格 : 內徑約22.8公分、外徑約23.2公分(不含嘴口)、高約13.4公分。
                                                                                                        商品重量：約460公克。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔、放入微波爐','深型打蛋盆24cmBetty_CT4967','24cm不鏽鋼盆', 3);
INSERT INTO Tackle(damages,day_price,max,notes,specification,tackle_name, fk_sort_id) VALUES (350,15,40,'產地：中國。

                                                                                                        材質：不鏽鋼。
                                                                                                        尺寸規格 : 內徑約24公分、外徑約27.5公分、高約14.5公分。
                                                                                                        商品重量：約500公克。
                                                                                                        用途：盛裝食材用。
                                                                                                        注意事項：不可重摔、放入微波爐','握把底止滑打蛋盆23cm_CT4966','握把底止滑打蛋盆', 3);

--新增器具圖片
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/tb8W5J4.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/32RgBtM.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/xBpTAEm.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/nIQ7cWy.png',1);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/hxevsGw.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/uwkvD6G.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/Qk8Pz8S.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/7LYKHqh.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/hKTKUIm.png',2);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/HRaZVRP.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/S2KDkan.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/6WpFPTN.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/Hveg2Gl.png',3);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/1mGDySq.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/suof28U.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/hSnuiOC.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/eVTMLU3.png',4);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/CBzzRt4.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/6oxKYZl.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/bMe6oVu.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/Taf9bPN.png',5);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/rROpkOM.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/F2WY0eR.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/abXs2p1.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/UneqTz4.png',6);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/IaCJqaU.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/umbhqpf.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/ojBEUSN.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/9mO9pbP.png',7);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/h0dBp7v.png',8);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/jqoZB4F.png',8);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/nd7Jw0W.png',9);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/xAadPqt.png',9);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/yq493eP.png',10);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/U21OVeB.png',10);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/77tCgYR.png',11);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/EJTHlhj.png',11);
INSERT INTO tackle_pic_list(picture,fk_tackle_id) VALUES('https://i.imgur.com/qi2ZZCt.png',11);

--新增場地類別
INSERT INTO venue_sort(sort) VALUES('課用烘培室');
INSERT INTO venue_sort(sort) VALUES('親子烘培室');
INSERT INTO venue_sort(sort) VALUES('小型烘培室');
INSERT INTO venue_sort(sort) VALUES('大型烘培室');


--新增場地
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'A101',0,NULL,1);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'A102',0,NULL,1);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'A201',0,NULL,1);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'A202',0,NULL,1);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (20,'B201',125,NULL,2);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (20,'B202',125,NULL,2);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (10,'B301',80,NULL,3);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (12,'B302',80,NULL,3);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (12,'B303',80,NULL,3);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'B401',50,NULL,4);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'B501',50,NULL,4);
INSERT INTO Venue(person_max,venue_name,hr_price,notes,fk_sort_id) VALUES (30,'B601',50,NULL,4);



--新增訂單資料
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-07-06T22:35:24.6900000' AS DateTime2), N'202207062235245', N'完成', CAST(N'2022-07-06T22:35:57.5750000' AS DateTime2), 0, CAST(N'2022-07-06T22:42:52.8590000' AS DateTime2), 100, 899, N'111111111111', NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-06-06T22:36:13.6490000' AS DateTime2), N'202207062236137', N'退款審核中', CAST(N'2022-07-06T22:36:33.0420000' AS DateTime2), 1, CAST(N'2022-07-06T22:42:56.1490000' AS DateTime2), 100, 899, N'', NULL, 1,'等太久')
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id,refund_reason) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-05-06T22:37:36.7950000' AS DateTime2), N'202207062237369', N'退款審核中', CAST(N'2022-07-06T22:38:01.3090000' AS DateTime2), 0, NULL, 100, 1698, NULL, NULL, 1,'我不想買了')
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-04-06T22:38:22.6500000' AS DateTime2), N'202207062238220', N'待出貨', CAST(N'2022-07-06T22:38:34.1380000' AS DateTime2), 1, CAST(N'2022-07-06T22:43:00.0770000' AS DateTime2), 100, 2497, N'', NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-03-06T22:38:54.8850000' AS DateTime2), N'202207062238548', N'待付款', NULL, 0, NULL, 100, 899, NULL, NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-02-06T22:39:13.2840000' AS DateTime2), N'202207062239134', N'待出貨', CAST(N'2022-07-06T22:39:22.9590000' AS DateTime2), 1, CAST(N'2022-07-06T22:43:03.0060000' AS DateTime2), 100, 899, N'', NULL, 1)
INSERT INTO orders (address, discount_amount, order_date, order_no, order_status, pay_date, pay_type, ship_date, shipping_fee, total_price, tracking_number, code, user_id) VALUES (N'桃園市楊梅區中山路121巷4弄9號', 0, CAST(N'2022-01-06T22:40:25.7620000' AS DateTime2), N'202207062240251', N'待出貨', CAST(N'2022-07-06T22:40:46.1170000' AS DateTime2), 0, CAST(N'2022-07-06T22:43:08.5550000' AS DateTime2), 100, 899, N'', NULL, 1)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 1)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 2)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 2, 1598, 3)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 3, 2397, 4)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 5)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 6)
INSERT INTO order_item ( product_name, product_no, product_type, qty, sub_total, order_id) VALUES (N'愛文芒果5斤(8~9入)禮盒裝', N'F1', N'小農', 1, 799, 7)
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

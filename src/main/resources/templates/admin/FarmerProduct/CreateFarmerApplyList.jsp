<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>建立申請單</title>

<%@include file="/JSP/css.html"%>
<style>
.form-control {
	width: 50%
}

textarea.form-control {
	resize: none;
	height: 100px;
}

.imgParent {
	width: 120px;
	height: 90px;
	overflow: hidden;
}

.img {
	border-radius: 5px;
	object-fit: cover;
	width: 120px;
	height: 90px;
	/* max-width: 100%; */
	/* max-height: 100%; */
}

#farmerProductPicDataUrl {
	width: 25%;
}
</style>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@include file="/JSP/sidebar.html"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<%@include file="/JSP/header.html"%>


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800"></h1>
					<p class="mb-4">
						<a href="./" class="btn btn-primary btn-icon-split btn-sm"> <span
							class="icon text-white-50"> <i class="fas fa-undo"></i>
						</span> <span class="text">返回申請單管理</span>
						</a>



					</p>
					<c:if test="${error!=null }">
						<div class="alert alert-danger" role="alert"></div>
					</c:if>
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">建立申請單</h6>
						</div>
						<div class="card-body">

								<!-- 商品名稱: -->
							<form action="CreateFarmerApplyList" method="post"   >
								<div class="row mb-3">
									<label for="farmerProductName" class="col-sm-2 col-form-labels">商品名稱:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control"
											name="farmerProductName" id="farmerProductName"
											maxlength="30" value="" placeholder="請輸入商品名稱" required>
										<span id="nameSize"> 0/30 </span> <span id="nameError"
											style="color: red"> </span>
									</div>
								</div>

								<!-- 價格: -->
								<div class="row mb-3 ">
									<label for="farmerProductPrice"
										class="col-sm-2 col-form-labels">價格:</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"
											oninput="value=value.replace(/[^\d]/g,'');if(value>99999)value=99999;if(value.length>5)value=value.slice(0,5);if(value<1)value=1;"
											min="1" max="99999" name="farmerProductPrice"
											id="farmerProductPrice" placeholder="請輸入價格" required>
										<span id="priceSize"> 0/5 </span> <span id="priceError"
											style="color: red"> </span>
									</div>
								</div>
								<!--數量:-->
								<div class="row mb-3">
									<label for="farmerProductQuantity"
										class="col-sm-2 col-form-labels">數量:</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"
											oninput="value=value.replace(/[^\d]/g,'');if(value>99999)value=99999;if(value.length>5)value=value.slice(0,5);if(value<1)value=1;"
											min="1" max="99999" name="farmerProductQuantity"
											id="farmerProductQuantity" placeholder="請輸入數量" required>
										<span id="quaSize"> 0/5 </span> 
										<span id="quaError" style="color: red"> </span>
									</div>
								</div>
								<!--保存方式: -->
								<div class="row mb-3">
									<label for="farmerProductStorage"
										class="col-sm-2 col-form-labels">保存方式:</label>
									<div class="col-sm-10">
										<select name="farmerProductStorage" class="form-control"
											id="farmerProductStorage"  required>
											<option value="" selected hidden disabled>請選擇保存方式</option>
											<option value="冰箱冷藏">冰箱冷藏</option>
											<option value="冰箱冷凍">冰箱冷凍</option>
											<option value="放置陰涼處">放於陰涼處</option>
										</select> <span id="stoError" style="color: red"> </span>
									</div>
								</div>
								<!--內容物:-->
								<div class="row mb-3">
									<label for="farmerProductContent"
										class="col-sm-2 col-form-labels">內容物:</label>
									<div class="col-sm-10">
										<textarea class="form-control" name="farmerProductContent"
											id="farmerProductContent" value="" placeholder="請輸入內容物"
											maxlength="100" required></textarea>

										<span id="conSize"> 0/100 </span> 
										<span id="conError" style="color: red"> </span>
									</div>
								</div>


								<!--商品介紹:-->
								<div class="row mb-3">
									<label for="farmerProductDescription"
										class="col-sm-2 col-form-labels">商品介紹:</label>
									<div class="col-sm-10">
										<textarea class="form-control" name="farmerProductDescription"
											id="farmerProductDescription" value="" placeholder="請輸入商品介紹"
											maxlength="500" required></textarea>
										<span id="desSize"> 0/500 </span>
										<span id="desError" style="color: red"> </span>
									</div>
								</div>
								<div class="row mb-3">
									<label for="farmerProductPic" class="col-sm-2 col-form-labels">商品圖片:</label>
									<div class="col-sm-10 imgParent">
										<img id="img" class="img" style="display: none;" src="#" /> 
										<input type="file" accept="image/png,image/gif,image/jpg,image/jpeg"
											name="farmerProductPic" id="farmerProductPic" value=""> 
										<input type="hidden" 
											name="farmerProductPicDataUrl" id="farmerProductPicDataUrl" value=""> 
											<span id="picSize"> 0M/1M </span>
											<span id="picError" style="color: red"> </span>
									</div>
								</div>
								<input type="hidden" name="farmerProductState" id="farmerProductState" value="0"> 
								<input type="hidden" name="farmerProductApplyTime" id="farmerProductApplyTime" value=""> 

								<button type="submit" class="btn btn-primary" id="sendData">建立申請單</button>
							</form>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->


			<%@include file="/JSP/footer.html"%>


		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->



	<%@include file="/JSP/javascript.html"%>
	<script src="${pageContext.request.contextPath}/js/createFarmerApplyList.js"></script>






</body>

</html>
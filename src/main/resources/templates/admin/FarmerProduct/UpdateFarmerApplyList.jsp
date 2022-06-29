<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>修改申請單</title>

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

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">修改申請單</h6>
						</div>


						<div class="card-body">
							<form action="" method="post">
								<!-- 申請單編號: -->

								<div class="row mb-3">
									<label for="farmerProductId" class="col-sm-2 col-form-labels">申請單編號:</label>
									<div class="col-sm-10">
										${bean.farmerProductId} <input type="hidden"
											name="farmerProductId" value="${bean.farmerProductId}">

									</div>
								</div>
								<!-- 商品名稱: -->
								<div class="row mb-3">
									<label for="farmerProductName" class="col-sm-2 col-form-labels">商品名稱:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control"
											name="farmerProductName" id="farmerProductName"
											maxlength="30" value="${bean.farmerProductName}"
											placeholder="請輸入商品名稱" required> <span id="nameSize">
										</span> <span id="nameError" style="color: red"> </span>
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
											id="farmerProductPrice" placeholder="請輸入價格"
											value="${bean.farmerProductPrice}" required> <span
											id="priceSize"> </span> <span id="priceError"
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
											id="farmerProductQuantity" placeholder="請輸入數量"
											value="${bean.farmerProductQuantity}" required> <span
											id="quaSize"></span> <span id="quaError" style="color: red">
										</span>
									</div>
								</div>
								<!--保存方式: -->
								<div class="row mb-3">
									<label for="farmerProductStorage"
										class="col-sm-2 col-form-labels">保存方式:</label>
									<div class="col-sm-10">
										<select name="farmerProductStorage" class="form-control"
											id="farmerProductStorage" required>
											<option value="${bean.farmerProductStorage}" selected hidden>${bean.farmerProductStorage}</option>
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
											maxlength="100" required>${bean.farmerProductContent}</textarea>

										<span id="conSize"> </span> <span id="conError"
											style="color: red"> </span>
									</div>
								</div>


								<!--商品介紹:-->
								<div class="row mb-3">
									<label for="farmerProductDescription"
										class="col-sm-2 col-form-labels">商品介紹:</label>
									<div class="col-sm-10">
										<textarea class="form-control" name="farmerProductDescription"
											id="farmerProductDescription" value="" placeholder="請輸入商品介紹"
											maxlength="500" required>${bean.farmerProductDescription}</textarea>
										<span id="desSize"> </span> <span id="desError"
											style="color: red"> </span>
									</div>
								</div>
								<div class="row mb-3">
									<label for="farmerProductPic" class="col-sm-2 col-form-labels">商品圖片:</label>
									<div class="col-sm-10 imgParent">
										<img id="img" class="img"
											src="${bean.farmerProductPicDataUrl}" /> <input type="file"
											accept="image/png,image/gif,image/jpg,image/jpeg"
											name="farmerProductPic" id="farmerProductPic" value="">
										<input type="hidden" name="farmerProductPicDataUrl"
											id="farmerProductPicDataUrl"
											value="${bean.farmerProductPicDataUrl}"> <span
											id="picSize"> </span> <span id="picError" style="color: red">
										</span>
									</div>
								</div>
								<input type="hidden" name="farmerProductState"
									id="farmerProductState" value="${bean.farmerProductState}">
								<input type="hidden" name="" id="farmerProductLaunchedTime"
									value=""> <input type="hidden" name=""
									id="farmerProductSoldTime" value=""> <input
									type="hidden" name="" id="farmerProductApplyTime" value="">
								<input type="hidden" name="" id="farmerProductCheckTime"
									value="">


								<button type="submit" class="btn btn-primary" id="sendData">修改申請單</button>
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

	<script>
     $(document).ready(function() {
    	
    	 if(`${bean.farmerProductLaunchedTime}`){
    		 $("#farmerProductLaunchedTime").attr("name","farmerProductLaunchedTime");
    		 $("#farmerProductLaunchedTime").val(new Date(`${bean.farmerProductLaunchedTime}`));
    	 }
    	 if(`${bean.farmerProductSoldTime}`){
    		 $("#farmerProductSoldTime").attr("name","farmerProductSoldTime");
    	 	 $("#farmerProductSoldTime").val(new Date(`${bean.farmerProductSoldTime}`));
    	 }
    	 if(`${bean.farmerProductApplyTime}`){
    		 $("#farmerProductApplyTime").attr("name","farmerProductApplyTime");
    		 $("#farmerProductApplyTime").val(new Date(`${bean.farmerProductApplyTime}`));
    	 }
    	 if(`${bean.farmerProductCheckTime}`){
    		 $("#farmerProductCheckTime").attr("name","farmerProductCheckTime");
    		 $("#farmerProductCheckTime").val(new Date(`${bean.farmerProductCheckTime}`));
    	 }
    	 
    	 
    	 
    		function getLength(input) {
    			//獲取輸入內容
    			let userDesc = input.val();

    			//判斷字數
    			let len;
    			if (userDesc) {
    				len = userDesc.length;
    			} else {
    				len = 0
    			}

    			return len
    		}

    		$("#farmerProductName").on('input propertychange', function() {
    			let len = getLength($(this));
    			$("#nameSize").text(len + '/30');
    		});
    		$("#farmerProductPrice").on('input propertychange', function() {
    			let len = getLength($(this));
    			$("#priceSize").text(len + '/5');
    		});
    		$("#farmerProductQuantity").on('input propertychange', function() {
    			let len = getLength($(this));
    			$("#quaSize").text(len + '/5');
    		});
    		$("#farmerProductContent").on('input propertychange', function() {
    			let len = getLength($(this));
    			$("#conSize").text(len + '/100');
    		});


    		$("#farmerProductDescription").on('input propertychange', function() {
    			let len = getLength($(this));
    			$("#desSize").text(len + '/500');
    		});


    		//圖片大小驗證
    		$("#farmerProductPic").on("change",function(){
    			var file =document.getElementById("farmerProductPic");
    			var inputDataUrl =document.getElementById("farmerProductPicDataUrl");
    			
    				var fileSize = 0;
    			var fileMaxSize = 1024;//1M
    			var filePath = file.value;
    			
    			if (filePath) {
    				fileSize = file.files[0].size;
    				var size = fileSize / 1024;
    				$('#picSize').text((size/1000).toFixed(2) + 'M/1M');
    				if (size > fileMaxSize) {
    					$("#img").attr('src', `${bean.farmerProductPicDataUrl}`);
    					$("#farmerProductPicDataUrl").val(`${bean.farmerProductPicDataUrl}`);
    					alert("檔案大小不能大於1M！");
    					file.value = "";
    					return false;
    				} else if (size <= 0) {
    					$("#img").attr('src',`${bean.farmerProductPicDataUrl}`);
    					$("#farmerProductPicDataUrl").val(`${bean.farmerProductPicDataUrl}`);
    					alert("檔案大小不能為0M！");
    					file.value = "";
    					return false;
    				}else{
    					
    					readURL(this)
    				}
    			} else {
    				$("#img").attr('src',`${bean.farmerProductPicDataUrl}`);
    				$("#farmerProductPicDataUrl").val(`${bean.farmerProductPicDataUrl}`);
    				
    				return false;
    			}
    		});
    		
    		
    		


//     		$("#farmerProductPic").change(function() {
    			

//     			readURL(this)

//     		});


    		var dataUrl =null; 
    		function readURL(input) {

    			if (input.files && input.files[0]) {

    				var reader = new FileReader();

    				reader.onload = function(e) {
    					 dataUrl =  e.target.result;
    					$("#img").attr('src', dataUrl);
    					
    					$("#farmerProductPicDataUrl").val(dataUrl);
    					

    				}

    				reader.readAsDataURL(input.files[0]);

    			}

    		}


    		
    	});
     
     
     $("#sendData").on("click", function() {

 		$("#farmerProductName").val($.trim($("#farmerProductName").val()));
 		$("#farmerProductPrice").val($.trim($("#farmerProductPrice").val()));
 		$("#farmerProductQuantity").val($.trim($("#farmerProductQuantity").val()));
 		$("#farmerProductContent").val($.trim($("#farmerProductContent").val()));
 		$("#farmerProductDescription").val($.trim($("#farmerProductDescription").val()));

 	});



</script>

</body>

</html>
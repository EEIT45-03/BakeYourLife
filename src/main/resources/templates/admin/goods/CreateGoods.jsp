<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>建立商品</title>

<%@include file="/JSP/css.html" %>
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
						<a href="../Goods/" class="btn btn-primary btn-icon-split btn-sm">
							<span class="icon text-white-50"> <i class="fas fa-undo"></i>
						</span> <span class="text">返回商品管理</span>
						</a>



					</p>
				
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">新增商品</h6>
						</div>
						<div class="card-body">
							<form:form  action="add" id="form" modelAttribute="Goods" method="post" enctype="multipart/form-data">
								<!-- 會員編號: -->
								<div class="row mb-3">
									<form:label  path="name" for="name" class="col-sm-2 col-form-labels">商品名稱:</form:label>
									<div class="col-sm-10">
										<form:input path="name" type="text" class="form-control" name="name" onblur="checkName(this)"
											id="name" placeholder="請輸入商品名稱" required="required" />
									</div>
								</div>
								<!-- 地址: -->
								<div class="row mb-3">
									<form:label path="element" for="element" class="col-sm-2 col-form-labels">成分:</form:label>
									<div class="col-sm-10">
										<form:input  path="element" type="text" class="form-control" name="element"
											id="element" placeholder="請輸入商品成分" required="required"/>
									</div>
								</div>
								<!-- 訂單類型: -->
								<div class="row mb-3">
									<form:label path="origin" for="origin" class="col-sm-2 col-form-labels">產地:</form:label>
									<div class="col-sm-10">
										<form:input path="origin" type="text" class="form-control" name="origin"
											id="origin" placeholder="請輸入商品產地" required="required"/>
									</div>
								</div>
								
								<!-- 運費: -->
								<div class="row mb-3">
									<form:label path="savetime" for="savetime" class="col-sm-2 col-form-labels">保存期限:</form:label>
									<div class="col-sm-10">
										<form:input path="savetime" type="text" class="form-control" name="savetime" onblur="checkdate(this)"
											id="savetime" placeholder="請輸入保存期限" required="required"/>
									</div>
								</div>
								<!-- 總金額: -->
								<div class="row mb-3">
									<form:label path="packages" for="packages" class="col-sm-2 col-form-labels">價格(元):</form:label>
									<div class="col-sm-10">
										<form:input path="packages" type="text" class="form-control" name="packages" onblur="checkprice(this)"
											id="packages"  placeholder="請輸入商品價格" required="required"/>
									</div>
								</div>
								<div class="row mb-3">
									<form:label path="productImage" for="picture" class="col-sm-2 col-form-labels">圖片:</form:label>
									<div class="col-sm-10">
										<form:input path="productImage" type="file" class="form-control" name="goodImage" onblur=""
											id="picture"/>
									</div>
								</div>
							
								<div class="row mb-3">
                                            <form:label path="packagematerial" for="orderStatus" class="col-sm-2 col-form-labels">商品包裝材質:</form:label>
                                            <div class="col-sm-10">
                                                <form:select path="packagematerial" class="form-control form-select mb-3" name="packagematerial" id="packagematerial"
                                                    aria-label="Default select example">
                                    <%-- 問一下 --%> <form:option value="原裝利樂包" >原裝利樂包</form:option>
                                                    <form:option value="透明夾鏈立袋" >透明夾鏈立袋</form:option>
                                                    <form:option value="保溫錫箔紙" >保溫錫箔紙</form:option>
                                                </form:select>
                                            </div>
                                        </div>
								<div class="row mb-3">
                                            <form:label path="saveway" for="orderStatus" class="col-sm-2 col-form-labels">商品保存方式:</form:label>
                                            <div class="col-sm-10">
                                                <form:select path="saveway" class="form-control form-select mb-3" name="saveway" id="saveway"
                                                    aria-label="Default select example">
                                    <%-- 問一下 --%> <form:option value="常溫" >常溫</form:option>
                                                    <form:option value="冷藏" >冷藏</form:option>
                                                    <form:option value="冷凍" >冷凍</form:option>
                                                </form:select>
                                            </div>
                                        </div>

								<form:button type="submit" class="btn btn-primary">建立商品</form:button>
							</form:form>
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



	<!-- Bootstrap core JavaScript-->
<%@include file="/JSP/javascript.html" %>
	<script>
	function checkdate(e) {
    	var date = e.value
    	var reg = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/
    	if(reg.test(date))return
    	else{alert("日期格式錯誤。須為YYYY-MM-DD")}
    	e.value=""
	}
    
    function checkprice(e){
    	var price = e.value;
    	if(price>=0)return;
    	else{alert("價格不得為負數。")};
    	e.value=""
    }
   		
		function checkName(e){
   			var name = e.value
   		$.ajax({  
   	   	type: "POST",    
		url: "./CheckGoods",      
   		data: "name="+name,   
   		success: function(data){
   			console.log(data);
   		if(data==true){     
   		alert("商品名稱已存在");    
   		e.value = '';}else{     
   	              }   
		   return;    
	}            
   			 });
   		}
   		
    </script>
</body>
</html>
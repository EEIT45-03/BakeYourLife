<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>商品管理</title>


<%@include file="/JSP/css.html"%>
<!--  modal  -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style>
.modal-confirm {
	color: #636363;
	width: 400px;
}
.modal-confirm .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
	text-align: center;
	font-size: 14px;
}
.modal-confirm .modal-header {
	border-bottom: none;
	position: relative;
}
.modal-confirm h4 {
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -10px;
}
.modal-confirm .close {
	position: absolute;
	top: -5px;
	right: -2px;
}
.modal-confirm .modal-body {
	color: #999;
}
.modal-confirm .modal-footer {
	border: none;
	text-align: center;
	border-radius: 5px;
	font-size: 13px;
	padding: 10px 15px 25px;
}
.modal-confirm .modal-footer a {
	color: #999;
}
.modal-confirm .icon-box {
	width: 80px;
	height: 80px;
	margin: 0 auto;
	border-radius: 50%;
	z-index: 9;
	text-align: center;
	border: 3px solid #f15e5e;
}
.modal-confirm .icon-box i {
	color: #f15e5e;
	font-size: 46px;
	display: inline-block;
	margin-top: 13px;
}
.modal-confirm .btn, .modal-confirm .btn:active {
	color: #fff;
	border-radius: 4px;
	background: #60c7c1;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	min-width: 120px;
	border: none;
	min-height: 40px;
	border-radius: 3px;
	margin: 0 5px;
}
.modal-confirm .btn-secondary {
	background: #c1c1c1;
}
.modal-confirm .btn-secondary:hover, .modal-confirm .btn-secondary:focus
	{
	background: #a8a8a8;
}
.modal-confirm .btn-danger {
	background: #f15e5e;
}
.modal-confirm .btn-danger:hover, .modal-confirm .btn-danger:focus {
	background: #ee3535;
}
.trigger-btn {
	display: inline-block;
	margin: 100px auto;
}
.picture {
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

<div id="myModle" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<div class="modal-header flex-column">
								<div class="icon-box">
								
									<i class="material-icons">&#xE5CD;</i>

								</div>
								<h4 class="modal-title w-100">請確認是否要刪除此商品?</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>如果刪除，商品資料將會永久消失!</p>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
								<form action="DeleteGoods">
									<input type="hidden" name="id" id="dateId" value="" /> <input
										type="submit" class="btn btn-danger" value="刪除">
								</form>
							</div>
						</div>
					</div>
				</div>

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">商品管理</h1>
					<p class="mb-4">
						<a href="CreateGoods"
							class="btn btn-primary btn-icon-split btn-sm"> 
							<span
							class="icon text-white-50"> <i class="fas fa-plus"></i>
							</span>
							
						 <span class="text">新增商品</span>
						</a>



					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">商品資訊</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-striped" id="oredrTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th></th>
											<th>商品編號</th>
											<th>商品名稱</th>
											<th>成分</th>
											<th>產地</th>
											<th>保存期限</th>
											<th>價格(元)</th>
											<th>包裝材質</th>
											<th>保存方式</th>
											<th>圖片</th>
											<th>修改</th>
											<th>刪除</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${goods}" var="goods">

											<tr>
												<td></td>
												<td>${goods.id}</td>
												<td>${goods.name}</td>
												<td>${goods.element}</td>
												<td>${goods.origin}</td>
												<td>${goods.savetime}</td>
												<td>${goods.packages}</td>
												<td>${goods.packagematerial}</td>
												<td>${goods.saveway}</td>
												<td><img width='60' height='72' src="<c:url value='/Admin/Goods/crm/picture/${goods.id}' />" /></td>
		

												<td><a href="UpdateGoods?id=${goods.id}"
													class="btn btn-warning btn-icon-split btn-sm"> 
													<img src="${pageContext.request.contextPath}/img/777.jpeg" width="50" height="50" class="img1"
													>
													<!-- <span class="text">修改訂單</span> -->
												</a></td>
												<td>
													<button type="button"
													
														class="btn btn-danger btn-icon-split btn-sm"
														data-toggle="modal" data-target="#myModle"
														onclick="values(${goods.id})">
														<img src="${pageContext.request.contextPath}/img/777.jpeg" width="50" height="50" class="img">
														
														<!-- <span class="text">刪除訂單</span> -->
													</button>
												</td>




											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
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
	<!-- Page level custom scripts -->
	<script>
	function values(ID){    
		$('#dateId').val(ID)
	}
	var h3APP=document.querySelectorAll(".img")
	console.log(h3All)
	$('.img').on('mouseenter',function(){
		$(this).attr('src','${pageContext.request.contextPath}/img/888.jpg')
		}).on('mouseleave',function(){
		$(this).attr('src','${pageContext.request.contextPath}/img/777.jpeg')
		})  
	var h3All=document.querySelectorAll(".img1")
	$('.img1').on('mouseenter',function(){
		$(this).attr('src','${pageContext.request.contextPath}/img/555.jpg')
		}).on('mouseleave',function(){
		$(this).attr('src','${pageContext.request.contextPath}/img/777.jpeg')
		})  
		/*for(let i=0; i<h3All.lenght; i++){
		h3All[i].addEventListener("mouseover",function(){
		h3All[i].img.src="${pageContext.request.contextPath}/img/888.jpg"
		})
		}   失敗*/
	/*var img= document.getElementById("img2");
	img.addEventListener("mouseover",function(){
	    img.src="${pageContext.request.contextPath}/img/888.jpg"
	})
	var img = document.getElementById("img2");
	img.addEventListener("mouseout",function(){
	    img.src="${pageContext.request.contextPath}/img/777.jpeg"
	})*/

	</script>


</body>
</html>
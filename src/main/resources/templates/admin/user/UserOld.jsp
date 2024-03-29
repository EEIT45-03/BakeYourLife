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

<title>會員管理</title>

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


				<div id="myModal" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<div class="modal-header flex-column">
								<div class="icon-box">
									<i class="material-icons">&#xE5CD;</i>

								</div>
								<h4 class="modal-title w-100">請確認是否要刪除此會員?</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>如果刪除，會員資料將會永久消失!</p>
							</div>
							<div class="modal-footer justify-content-center">
								<form action="DeleteUser" >
									<input type="hidden" name="userId" id="dateId" value="" /> <input
										type="submit" class="btn btn-danger" value="刪除">
								</form>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
							</div>
						</div>
					</div>
				</div>


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">會員管理</h1>
					<p class="mb-4">
						<a href="CreateUser" class="btn btn-primary btn-icon-split btn-sm">
							<span class="icon text-white-50"> <i class="fas fa-plus"></i>
						</span> <span class="text">新增會員</span>
						</a>



					</p>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">會員資訊</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="userTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>帳號</th>
											<th>編號</th>
											<th>姓名</th>
											<th>E-mail</th>
											<th>電話</th>
											<th>生日</th>
											<th>性別</th>
											<th>地址</th>

											<th class="none">帳號:</th>
											<th class="none">密碼:</th>
											<th class="none">動作:</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${users}" var="user">

											<tr>
												<td></td>
												<td>${user.userId}</td>
												<td>${user.fullName}</td>
												<td>${user.email}</td>
												<td>${user.phone}</td>
												<td>${user.birth}</td>
												<td>${user.gender}</td>
												<td>${user.address}</td>
												<td>${user.username}</td>
												<td>${user.password}</td>
												<td><a href="${pageContext.request.contextPath}/User/update/${user.userId}"
													class="btn btn-warning btn-icon-split btn-sm"> <span
														class="icon text-white-50"> <i
															class="fas fa-exclamation-triangle"></i>
													</span><span class="text">修改</span>
												</a>&nbsp;&nbsp;&nbsp;

													<button type="button"
														class="btn btn-danger btn-icon-split btn-sm"
														data-toggle="modal" data-target="#myModal"
														onclick="values(${user.userId})">
														<span class="icon text-white-50"> <i
															class="fas fa-trash"></i>
														</span> <span class="text">刪除</span>
													</button></td>

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
	<script>
        //刪除訂單傳值
        function values(ID) {
            $('#dateId').val(ID);
        }
        $(document).ready(function() {
      	  $('#userTable').DataTable( {
      		language: {
      	            url: '//cdn.datatables.net/plug-ins/1.11.5/i18n/zh-HANT.json'
      	        },
      	    responsive: {
      	        details: {
      	            type: 'column'
      	        }
      	    },
              columnDefs: [{
                  className: 'dtr-control',
                  orderable: false,
                  targets: 0
              }],
      	    order: [ 1, 'asc' ]
      	} );
      	});
    </script>

</body>

</html>
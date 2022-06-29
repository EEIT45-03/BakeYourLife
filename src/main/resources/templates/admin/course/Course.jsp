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

<title>課程管理</title>

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
								<h4 class="modal-title w-100">請確認是否要刪除此課程?</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>刪除嗎?</p>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
								<form action="CourseDelete">
									<input type="hidden" name="openCourse" id="openCourse" value="" />
									<input type="submit" class="btn btn-danger" value="刪除">
								</form>
							</div>
						</div>
					</div>
				</div>
				
				
				<div id="myModal2" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<div class="modal-header flex-column">
								<div class="icon-box">
									 <i class="material-icons">&#xE5CD;</i> 
								</div>
								<h4 class="modal-title w-100">A</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>B</p>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">OK</button>
								
							</div>
						</div>
					</div>
				</div>


				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">課程管理</h1>
					<p class="mb-4">
						<a href="./CreateCourse"
							class="btn btn-primary btn-icon-split btn-sm"> <span
							class="icon text-white-50"> <i class="fas fa-plus"></i>
						</span> <span class="text">建立課程</span>
						</a>



					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">課程資訊</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-striped" id="courseTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th></th>
											<th>開課編號</th>
											<th>課程編號</th>
											<th>開課日期</th>
											<th>結束日期</th>
											<th>教室</th>
											<th>人數上限</th>
											<th class="none">老師</th>
											<th class="none">備註</th>
											<th>修改</th>
											<th>刪除</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${courses}" var="course">

											<%-- c:set var="courseItemList" value="${course.courseItemList}" />  --%>
											<tr>
												<td></td>
												<td>${course.openCourse}</td>
												
												
<%-- 												<td>${course.courseID}</td> --%>
												<td>
													<button type="button"
														 STYLE="background-color: transparent; border:none"
														onclick="courseIdAlert('${course.courseID}')">
														 <span class="text">${course.courseID}</span>
													</button>
												</td>
												<!-- <td>
												<button type="button"
														class="btn btn-danger btn-icon-split btn-sm"
														data-toggle="modal" data-target="#myModal"
														onclick="values('${course.openCourse}')">
														<span class="icon text-white-50"> <i
															class="fas fa-trash"></i>
														</span> <span class="text">刪除課程</span>
													</button>
												<a href="QueryArticle?postid=${ article.postid}">
											${ article.title} -->
											
												<td><fmt:formatDate pattern="yyyy/MM/dd"
														value="${course.startDate}" /></td>
												<td><fmt:formatDate pattern="yyyy/MM/dd"
														value="${course.endDate}" /></td>
												 <%--
                                                            <td>
                                                                <c:if test="${empty order.shipDate}">
                                                                    未發貨
                                                                </c:if>
                                                                <c:if test="${not empty order.shipDate}">
                                                                    <fmt:formatDate pattern="yyyy/MM/dd HH:mm"
                                                                        value="${order.shipDate}" />
                                                                </c:if>
                                                            </td>
                                                             
                                                            <td>${course.Room}</td>
                                                            <td>${course.RegisterMax}</td>
                                                             --%>
												<td>${course.room }</td>
												<td>${course.registerMax }</td>
												<td>${course.teacher }</td>
												<td>${course.note }</td>
												<td><a
													href="UpdateCourse?openCourse=${course.openCourse}"
													class="btn btn-warning btn-icon-split btn-sm"> <span
														class="icon text-white-50"> <i
															class="fas fa-exclamation-triangle"></i>
													</span> <span class="text">修改課程</span>
												</a></td>
												<td>
													<button type="button"
														class="btn btn-danger btn-icon-split btn-sm"
														data-toggle="modal" data-target="#myModal"
														onclick="values('${course.openCourse}')">
														<span class="icon text-white-50"> <i
															class="fas fa-trash"></i>
														</span> <span class="text">刪除課程</span>
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


			<%@include file="/JSP/footer.html" %>


		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->



	<%@include file="/JSP/javascript.html"%>
	<script src="${pageContext.request.contextPath}/js/course.js"></script>
	<script>
        //刪除訂單傳值
        function values(openCourse) {
            $('#openCourse').val(openCourse);
        }
        $(document).ready(function() {
        	  $('#courseTable').DataTable( {
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
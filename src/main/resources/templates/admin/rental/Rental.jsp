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

<title>租借管理</title>

<%@include file="/JSP/css.html"%>
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
					<h1 class="h3 mb-2 text-gray-800">租借管理</h1>
					<p class="mb-4">
						<a href="CreateRental"
							class="btn btn-primary btn-icon-split btn-sm"> <span
							class="icon text-white-50"> <i class="fas fa-plus"></i>
						</span> <span class="text">建立租借單</span>
						</a>
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">租借單資訊</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-striped" id="rentalTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th></th>
											<th>租借單ID</th>
											<th>租借單編號</th>
											<th>租借類型</th>
											<th>會員</th>
											<th>總金額</th>
											<th>新增清單</th>
											<th>修改</th>
											<th>刪除</th>
											<th class="none">租借清單</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${rentals}" var="rental">

											<c:set var="venueList" value="${rental.venueList}" />
											<c:set var="tackleList" value="${rental.tackleList}" />

											<tr>
												<td></td>
												<td>${rental.rentalId}</td>
												<td>${rental.rentalNO}</td>
												<td>${rental.type}</td>
												<td>${rental.user.userName}</td>
												<td>${rental.total}</td>
												<td>
												<c:if test="${rental.type =='tackle'}">
													<button type="button"
														class="btn btn-danger btn-icon-split btn-sm"
														onclick="createTackleList(${rental.rentalId})">
														<span class="icon text-white-50"> <i
															class="fas fa-plus"></i>
														</span>
													</button>
												</c:if>
												<c:if test="${rental.type =='venue'}">
													<button type="button"
														class="btn btn-danger btn-icon-split btn-sm"
														onclick="createVenueList(${rental.rentalId})">
														<span class="icon text-white-50"> <i
															class="fas fa-plus"></i>
														</span>
													</button>
												</c:if>
												</td>
												<td>
													<button type="button"
														class="btn btn-warning btn-icon-split btn-sm"
														onclick="updateRental(${rental.rentalId})">
														<span class="icon text-white-50"> <i
															class="fas fa-exclamation-triangle"></i>
														</span>
													</button>
												</td>
												<td>
													<button type="button"
														class="btn btn-danger btn-icon-split btn-sm"
														onclick="deleteRental(${rental.rentalId})">
														<span class="icon text-white-50"> <i
															class="fas fa-trash"></i>
														</span>
													</button>
												</td>
												
												<td>
													<table>
														<c:if test="${rental.type =='tackle'}">
															<tr>

																<th>清單編號</th>
																<th>租借器具</th>
																<th>出租時間</th>
																<th>歸還時間</th>
																<th>數量</th>
																<th>小計</th>
																<th>修改</th>
																<th>刪除</th>

															</tr>
															<c:forEach items="${tackleList}" var="tlist">
																<tr>

																	<td>${tlist.tackleListNo }</td>
																	<td>${tlist.tackle.tackleName }</td>
																	<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm"
																			value="${tlist.lendTime }" /></td>
																	<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm"
																			value="${tlist.returnTime }" /></td>
																	<td>${tlist.quantity }</td>
																	<td>${tlist.price }</td>
																	<td>
																		<button type="button"
																			class="btn btn-warning btn-icon-split btn-sm"
																			onclick="updateTackleList(${tlist.tackleListId})">
																			<span class="icon text-white-50"> <i
																				class="fas fa-exclamation-triangle"></i>
																			</span>
																		</button>
																	</td>
																	<td>
																		<button type="button"
																			class="btn btn-danger btn-icon-split btn-sm"
																			onclick="deleteTackleList(${tlist.tackleListId})">
																			<span class="icon text-white-50"> <i
																				class="fas fa-trash"></i>
																			</span>
																		</button>
																	</td>

																</tr>
															</c:forEach>
														</c:if>
													
														<c:if test="${rental.type =='venue'}">
															<tr>
																<th>清單編號</th>
																<th>租借場地</th>
																<th>出租時間</th>
																<th>歸還時間</th>
																<th>人數</th>
																<th>小計</th>
																<th>修改</th>
																<th>刪除</th>
															</tr>
															<c:forEach items="${venueList}" var="vlist">
																<tr>
																	<td>${vlist.venueListNo }</td>
																	<td>${vlist.classroom.className }</td>
																	<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm"
																			value="${vlist.lendTime }" /></td>
																	<td><fmt:formatDate pattern="yyyy/MM/dd HH:mm"
																			value="${vlist.returnTime }" /></td>
																	<td>${vlist.person }</td>
																	<td>${vlist.price }</td>
																	<td>
																		<button type="button"
																			class="btn btn-warning btn-icon-split btn-sm"
																			onclick="updateVenueList(${vlist.venueListId})">
																			<span class="icon text-white-50"> <i
																				class="fas fa-exclamation-triangle"></i>
																			</span>
																		</button>
																	</td>
																	<td>
																		<button type="button"
																			class="btn btn-danger btn-icon-split btn-sm"
																			onclick="deleteVenueList(${vlist.venueListId})">
																			<span class="icon text-white-50"> <i
																				class="fas fa-trash"></i>
																			</span>
																		</button>
																	</td>
																</tr>
															</c:forEach>
														</c:if>
													</table>
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


	<!-- 訂單頁面 -->
	<script src="${pageContext.request.contextPath}/js/rental.js"></script>


</body>

</html>
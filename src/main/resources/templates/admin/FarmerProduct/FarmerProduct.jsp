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

<title>小農商品管理</title>

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
.table th{
  vertical-align: middle;
  text-align: center;
}

.table td{
  vertical-align: middle;
  text-align: center;
}
td.child{
text-align: left;
}
ul{
text-align:left;
}

.fa-solid {
 font-size: 1.3rem;
}

.text{
white-space:pre;
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
									<i class="fa-solid fa-face-sad-tear"></i>
								</div>
								<h4 class="modal-title w-100">請確認是否要下架此商品?</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>下架確認後將無法更改!</p>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
								<form action="UpdateFarmerProductState">
									<input type="hidden" name="farmerProductId" id="farmerProductId" value="" />
									<input type="hidden" name="farmerProductState" id="farmerProductState" value="3" />
									<input type="submit" class="btn btn-danger" value="確認下架">
								</form>
							</div>
						</div>
					</div>
				</div>
				
				<div id="myModal1" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<div class="modal-header flex-column">
								<div class="icon-box">
									<i class="fa-solid fa-face-kiss-wink-heart"></i>
								</div>
								<h4 class="modal-title w-100">請確認是否要通過此申請單?</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>確認通過後將無法更改!</p>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
								<form action="UpdateFarmerProductState">
									<input type="hidden" name="farmerProductId" id="farmerProductId1" value="" />
									<input type="hidden" name="farmerProductState" id="farmerProductState" value="1" />
									<input type="submit" class="btn btn-success" value="確認通過">
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
									 <i class="fa-solid fa-face-dizzy"></i>
								</div>
								<h4 class="modal-title w-100">請確認是否未通過此申請單?</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
							</div>
							<div class="modal-body">
								<p>確認未通過後將無法更改!</p>
							</div>
							<div class="modal-footer justify-content-center">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
								<form action="UpdateFarmerProductState">
									<input type="hidden" name="farmerProductId" id="farmerProductId2" value="" />
									<input type="hidden" name="farmerProductState" id="farmerProductState" value="2" />
									<input type="submit" class="btn btn-danger" value="確認未通過">
								</form>
							</div>
						</div>
					</div>
				</div>
				


				<!-- Begin Page Content -->
				<div class="container-fluid ">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">小農商品管理</h1>
<!--         <p class="mb-4"> -->
<!--             <a href="./CheckFarmerApplyList/" class="btn btn-info btn-icon-split "> <span class="icon text-white-50"> <i class="fa-solid fa-file-pen"></i> -->
<!--                 </span> <span class="text">審核申請單</span> -->
<!--             </a> -->



<!--         </p> -->

        <!-- DataTales Example -->
        <div class="card shadow mb-4 ">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">小農商品資訊</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped" id="ApplyListTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th></th>
                                <th>#</th>
<!--                                 <th>上架時間</th> -->
                                <th>商品編號</th>
                                <th>商品圖片</th>
                                <th>商品名稱</th>
                                <th>價格</th>
                                <th>數量</th>
                                <th>狀態</th>
                                <th class="none">內容物</th>
                                <th class="none">保存方式</th>
                                <th class="none">商品介紹</th>
                                <th>動作</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% int count = 1; %>
						<c:forEach items="${farmerProductBeans}" var="bean">
                            <tr>
                                <td></td>
                                <td><%= count++ %></td>
<%--                                 <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" --%>
<%-- 														value="${bean.farmerProductLaunchedTime}" /></td> --%>
                                <td>${bean.farmerProductId}</td>
                                <td class="imgParent" ><img src="${bean.farmerProductPicDataUrl}" class="img"></td>
                                <td>${bean.farmerProductName}</td>
                                <td>NT$${bean.farmerProductPrice}</td>
                                <td>${bean.farmerProductQuantity}</td>
                                <td>
                             <c:if test="${bean.farmerProductState==0}">
								<i class="fa-solid fa-file-pen" style="color:#46A3FF;"></i>
								待審核
								 <br>
								 申請時間:
                                <fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${bean.farmerProductApplyTime}" />
								</c:if>
                                <c:if test="${bean.farmerProductState==1}">
								<i class="fa-solid fa-file-circle-check" style="color:#75d571;"></i>
								上架中
								 <br>
								 上架時間:
                                <fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${bean.farmerProductLaunchedTime}" />
								</c:if>
                                <c:if test="${bean.farmerProductState==2}">
								<i class="fa-solid fa-file-circle-xmark" style="color:#f15e5e;"></i>
								審核未通過
								 <br>
								 審核時間:
                                <fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${bean.farmerProductCheckTime}" />
								</c:if>
								
								 <c:if test="${bean.farmerProductState==3}">
								<i class="fa-solid fa-file-circle-minus" style="color:#8080C0;"></i>
								已下架
								 <br>
								 下架時間:
                                <fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${bean.farmerProductSoldTime}" />
								</c:if>
                               </td>
                                <td>${bean.farmerProductContent}</td>
                                <td>${bean.farmerProductStorage}</td>
                                <td>${bean.farmerProductDescription}</td>
                                <td>
                                <c:if test="${bean.farmerProductState==1}">
                                
                                   <a href="UpdateFarmerApplyList?farmerProductId=${bean.farmerProductId}"
                                        class="btn btn-warning btn-icon-split btn-sm" > <span class="icon text-white-50">
                                            <i class="fas fa-exclamation-triangle"></i>
                                        </span> <span class="text">修改</span> </a>
                                
                                <button type="button" class="btn btn-danger btn-icon-split btn-sm"
                                        data-toggle="modal" data-target="#myModal"
                                        onclick="values('${bean.farmerProductId}')">
                                        <span class="icon text-white-50"> <i class="fa-solid fa-arrow-down"></i>
                                        </span> <span class="text">下架此商品</span>
                                    </button>
                                        </c:if>
                                      
                                <c:if test="${bean.farmerProductState==0}">
                                    <button type="button" class="btn btn-success btn-icon-split btn-sm"
                                        data-toggle="modal" data-target="#myModal1"
                                        onclick="values1('${bean.farmerProductId}')">
                                        <span class="icon text-white-50"> <i class="fa-solid fa-thumbs-up"></i>
                                        </span> <span class="text">通過</span>
                                    </button>
                                    <button type="button" class="btn btn-danger btn-icon-split btn-sm"
                                        data-toggle="modal" data-target="#myModal2"
                                        onclick="values2('${bean.farmerProductId}')">
                                        <span class="icon text-white-50"> <i class="fa-solid fa-thumbs-down"></i>
                                        </span> <span class="text">未通過</span>
                                    </button>
                                      </c:if>
                                       <c:if test="${bean.farmerProductState==2}">
                                       已審核(未通過)
                                        </c:if>
                                       <c:if test="${bean.farmerProductState==3}">
                                       已下架
                                        </c:if>
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
	<script>
        //下架商品傳值
        function values(farmerProductId) {
            $('#farmerProductId').val(farmerProductId);
        }
        function values1(farmerProductId) {
            $('#farmerProductId1').val(farmerProductId);
        }
        function values2(farmerProductId) {
            $('#farmerProductId2').val(farmerProductId);
        }
        $(document).ready(function() {
        	  $('#ApplyListTable').DataTable( {
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
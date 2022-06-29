<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>修改訂單</title>

    <%@include file="/JSP/css.html"%>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <%@include file="/JSP/sidebar.html" %>

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <%@include file="/JSP/header.html" %>


                        <!-- Begin Page Content -->
                        <div class="container-fluid">

                            <!-- Page Heading -->
                            <h1 class="h3 mb-4 text-gray-800"></h1>
                            <p class="mb-4">
                                <a href="../Course/" class="btn btn-primary btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-undo"></i>
                                    </span>
                                    <span class="text">返回課程管理</span>
                                </a>

                            </p>
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">修改課程</h6>
                                </div>
                                <div class="card-body">
                                <form action="UpdateCourse" method="post">
                                    <!-- orderId(in server) -->
                                    <!-- orderNo(in server) -->
                                   <!--  <p>開課編號:${course.openCourse}</p>-->
                                   	<div class="row mb-3">
                                            <label for="OpenCourse" class="col-sm-2 col-form-labels">開課編號:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="OpenCourse" id="OpenCourse"
                                                    value="${course.openCourse}" required readonly>
                                            </div>
                                        </div>
                                   <!-- <p>課程編號:${course.courseID}</p>-->
                                    <div class="row mb-3">
                                            <label for="OpenCourse" class="col-sm-2 col-form-labels">課程編號:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="CourseID" id="CourseID"
                                                    value="${course.courseID}" required>
                                            </div>
                                        </div>
                                    <!-- shipDate(action) -->
                                    <!--<p>開始日期:${course.startDate}</p>-->
                                    <div class="row mb-3">
                                            <label for="StartDate" class="col-sm-2 col-form-labels">開始日期:</label>
                                            <div class="col-sm-10">
                                                <input type="Date" class="form-control" name="StartDate" id="StartDate"
                                                    value="${course.startDate}" required>
                                            </div>
                                        </div>
                                        
                                    <div class="row mb-3">
                                            <label for="StartDate" class="col-sm-2 col-form-labels">結束日期:</label>
                                            <div class="col-sm-10">
                                                <input type="Date" class="form-control" name="EndDate" id="EndDate"
                                                    value="${course.endDate}" required>
                                            </div>
                                        </div>
                                        
                                    
                                    <!-- orderDate(in server) -->
                                    <!-- <p>訂單日期:${order.orderDate}</p> -->
                                    <!-- orderStatus(in server) -->
                                    <!--<p>教室:${course.room}</p> -->
                                    <div class="row mb-3">
                                            <label for="memNo" class="col-sm-2 col-form-labels">教室:</label>
                                            <div class="col-sm-10">
                                            	<select name="Room" class="form-control" id="Room" value="${course.room}"  required>
                                                    
                                                    
							                        <option value="R201" id="R201">R201</option>
							                        <option value="R202" id="R202">R202</option>
							                        <option value="R203" id="R203">R203</option>
							                        <option value="R301" id="R301">R301</option>
							                        <option value="R302" id="R302">R302</option>
							                	</select>    
                                            
                                                <!--
                                                <div class="col-sm-9">
				<select class="form-control form-select mb-3" name="orderStatus"
					id="orderStatus" aria-label="Default select example">
					<option value="未付款"
 						${order.orderStatus.equals('未付款')?"selected":""}>未付款</option>
					<option value="未發貨"
						${order.orderStatus.equals('未發貨')?"selected":""}>未發貨</option>
					<option value="待收貨"
						${order.orderStatus.equals('待收貨')?"selected":""}>待收貨</option>
					<option value="已完成"
						${order.orderStatus.equals('已完成')?"selected":""}>已完成</option>
				</select>
			</div>
                                                
                                                <input type="text" class="form-control" name="Room" id="Room"
                                                    value="${course.room}" required>  -->
                                            </div>
                                    </div>
                                    
                                    <!--<p>最大報名人數:${course.registerMax}</p>-->
                            		<div class="row mb-3">
                                            <label for="memNo" class="col-sm-2 col-form-labels">最大報名人數:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="RegisterMax" id="RegisterMax"
                                                    value="${course.registerMax}" required>
                                            </div>
                                    </div>
                                    
                                    <!-- 老師: -->
                                    <div class="row mb-3">
                                            <label for="memNo" class="col-sm-2 col-form-labels">老師:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="Teacher" id="Teacher"
                                                    value="${course.teacher}" required>
                                            </div>
                                    </div>
                                        <!-- 備註: -->
                                        <div class="row mb-3">
                                            <label for="Note" class="col-sm-2 col-form-labels">備註:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="Note" id="Note"
                                                    value="${course.note}" >
                                            </div>
                                        </div>
                                        <!-- 訂單類型: -->
                                        <!-- <div class="row mb-3">
                                    <label for="orderType" class="col-sm-2 col-form-labels">訂單類型:</label>
                                    <div class="col-sm-10">
                                        <select class="form-control form-select mb-3" name="orderType"
                                            aria-label="Default select example">
                                            <option value="一般商品" selected>一般商品</option>
                                        </select>
                                    </div>
                                </div>-->
                                        <!-- 運費: -->
                                        <!--<div class="row mb-3">
                                            <label for="shippingFee" class="col-sm-2 col-form-labels">運費:</label>
                                            <div class="col-sm-10">
                                                <input type="number" class="form-control" name="shippingFee"
                                                    id="shippingFee" value="${order.shippingFee}" required>
                                            </div>
                                        </div>
                                        <!-- 總金額: -->
                                        <!--<div class="row mb-3">
                                            <label for="address" class="col-sm-2 col-form-labels">總金額:</label>
                                            <div class="col-sm-10">
                                                <input type="number" class="form-control" name="totalPrice"
                                                    id="totalPrice" value="${order.totalPrice}" required>
                                            </div>
                                        </div>-->
                                        <button type="submit" class="btn btn-primary">修改課程</button>
                                    </form>
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
    window.onload=function(){
    	 var selecten = document.getElementById("${course.room}");
    	 selecten.selected=true
    	}
    </script>
</body>

</html>
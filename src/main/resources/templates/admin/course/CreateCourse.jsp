<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>建立課程</title>
    
	
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
                                <a href="./" class="btn btn-primary btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-undo"></i>
                                    </span>
                                    <span class="text">返回課程管理</span>
                                </a>



                            </p>
                            <c:if test="${error!=null }">
                                <div class="alert alert-danger" role="alert">

                                </div>
                            </c:if>
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">建立課程</h6>
                                </div>
                                <div class="card-body">
                                    <form:form action="" method="post" modelAttribute="course">
                                        <!-- 開課編號: 
                                        
                                        <div class="row mb-3">
                                            <label for="OpenCourse" class="col-sm-2 col-form-labels">開課編號:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="OpenCourse" id="OpenCourse"
                                                    value="${course.openCourse}" placeholder="請輸入開課編號" required>
                                            </div>
                                        </div>-->
                                        
                                        <!-- 課程編號: -->
                                         <div class="row mb-3">
                                            <form:label path="courseID" for="courseID" class="col-sm-2 col-form-labels">課程編號:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="courseID" type="text" class="form-control" name="courseID" id="courseID"
                                                    placeholder="請輸入課程編號" required="required" />
                                            </div>
                                        </div>
                                        <!--<p>開始日期:${course.startDate}</p>-->
                                    <div class="row mb-3" >
                                            <form:label path="startDate" for="startDate" class="col-sm-2 col-form-labels">開始日期:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="startDate" type="Date" class="form-control" name="startDate" id="startDate"
                                                     required="required" />
                                            </div>
                                        </div>
                                        <%-- <p>結束日期:${course.endtDate}</p> --%>
                                        <div class="row mb-3">
                                            <form:label path="endDate" for="endDate" class="col-sm-2 col-form-labels">結束日期:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="endDate" type="Date" class="form-control" name="endDate" id="endDate"
                                                    required="required" />
                                            </div>
                                        </div>
                                        
<%--                                     <p>教室:${course.room}</p> --%>
                                    <div class="row mb-3">
                                            <label for="room" class="col-sm-2 col-form-labels">教室:</label>
                                            <div class="col-sm-10">
                                            	
                                            	<form:select path="room" name="room" class="form-control form-select mb-3" >
							                        <form:option value="R201">R201</form:option>
							                        <form:option value="R202">R202</form:option>
							                        <form:option value="R203">R203</form:option>
							                        <form:option value="R301">R301</form:option>
							                        <form:option value="R302">R302</form:option>
							                	</form:select>                                            
                                               <!--  <input type="text" class="form-control" name="Room" id="Room"
                                                    value="${course.room}" required> -->
                                            </div>
                                    </div>
                                    
                                    <%-- <p>最大報名人數:${course.registerMax}</p> --%>
                            		<div class="row mb-3">
                                            <form:label path="registerMax" for="registerMax" class="col-sm-2 col-form-labels">最大報名人數:</form:label>
                                            <div class="col-sm-10">
                                                <form:input type="text" class="form-control" name="registerMax" id="registerMax"
                                                   path="registerMax"  placeholder="請輸入人數" onkeyup = "value=value.replace(/[^\d]/g,'')" required="required" />
                                            </div>
                                    </div>
<!--                                     <form action="" method="post"> -->
                                    
                                    <!-- 老師: -->
                                    <div class="row mb-3">
                                            <form:label path="teacher" for="memNo" class="col-sm-2 col-form-labels">老師:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="teacher" type="text" class="form-control" name="teacher" id="teacher"
                                                    placeholder="請輸入教師" required="required" />
                                            </div>
                                    </div>
                                    
                                    <!-- 備註: -->
                                        <div class="row mb-3">
                                            <form:label path="note" for="note" class="col-sm-2 col-form-labels">備註:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="note" type="text" class="form-control" name="note" id="note"
                                                     placeholder="備註" />
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-primary">建立課程</button>
                                        
                                        <button type="button" class="btn btn-secondary" id="correctInput">一鍵輸入</button>
                                        <button type="button" class="btn btn-secondary" id="wrongInput">錯誤輸入</button>
                                        
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        
                        

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
    
    
//     function checkForm(){ 
//     	if (StartDate > EndDate) {
// 	    	let StartDate = new Date($("#StartDate").val());
// 	        let EndDate = new Date($("#EndDate").val());
// 	        alert("刊登開始日期不可於刊登結束日期之後");
// 	        checkResult = false;
// 	        return checkResult;
//     	}
//     	return checkResult;
// 	}
    </script>
    </body>

</html>
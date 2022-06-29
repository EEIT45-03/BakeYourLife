<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.io.*"  %>
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

    <title>編輯貼文</title>

    <%@include file="/JSP/css.html"%>
<style> 
 .t2{ margin: auto;
 }
</style>
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
                                    <span class="text">返回選單</span>
                                </a>



                            </p>
                            <c:if test="${error!=null }">
                                <div class="alert alert-danger" role="alert">

                                </div>
                            </c:if>
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">查看貼文</h6>
                                </div>
                                <div class="card-body">
                                     <form enctype="multipart/form-data" action="QueryArticle" method="Get">
                                     <c:forEach items="${articles}" var="article"> 
                                        <!-- 發文ID: -->
                                        <div class="row mb-3">
                                            <label for="postid" class="col-sm-2 col-form-labels">發文ID:</label>
                                            <div class="col-sm-10">
                                                ${ article.postid}
                                            </div>
                                        </div>
                                        <!-- 標題: -->
                                        <div class="row mb-3">
                                            <label for="title" class="col-sm-2 col-form-labels">標題:</label>
                                            <div class="col-sm-10">
                                               <span>${ article.title}</span><br>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <label for="type" class="col-sm-2 col-form-labels">文章分類:</label>
                                            <div class="col-sm-10">
                                               <span>${ article.type}</span><br>
                                            </div>
                                        </div>
                                        <!-- 訂單類型: -->
                                        <div class="row mb-3">
                                        <label for="" class="col-sm-2 col-form-labels">發文日期</label>
                                        ${ article.date}                                        
                                        </div>
                                        <hr>
                                        <div class="row mb-3">
                                        <p>${ article.content}</p>
                                         </div>
                                         <div align="center" class="row mb-3">
                                         <img width="300" height="300" style="display:block; margin:auto;" <img src="data:image/jpg;base64,${article.base64}"/> />	
                                         
                                         </div> 
                                                                              
                                        <div class="t2"><a class="btn btn-warning" 
												href="UpdateArticle?postid=${article.postid}">編輯貼文</a></div>
                                         <div style="float: right;"> 
                                        觀看次數:${ article.counter}
                                        </div>
                                      </c:forEach>  
                                    </form>
                                    <div style="float: right;">
                                   
<!--                                        觀看次數: -->
<%--                                      <% --%>
<!-- //                                        SessionCounter counter = (SessionCounter) session -->
<!-- //                                                .getAttribute("counter"); -->
<%--                                                                       %> --%>
<%--                       Number of online user(s): <%= counter.getActiveSessionNumber() %> --%>
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

</body>

</html>

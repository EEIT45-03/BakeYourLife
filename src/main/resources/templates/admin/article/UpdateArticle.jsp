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

    <title>編輯貼文</title>

<%@include file="/JSP/css.html"%>
<style>
.a1{ margin:20px;
    
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
                                    <h6 class="m-0 font-weight-bold text-primary">編輯貼文</h6>
                                </div>
                                <div class="card-body">
                                     <form enctype="multipart/form-data" action="UpdateArticle?postid=${article.postid}" method="post">
                                        <c:forEach items="${articles}" var="article">
                                        <!-- 發文ID: -->
                                        <div class="row mb-3">
                                            <label for="postid" class="col-sm-2 col-form-labels">發文ID:${article.postid}</label>
                                            <div class="col-sm-10">
                                                <!--<input type="text" class="form-control" name="postid" id="article"-->
                                                <!--value="${article.postid}" required>-->
                                            </div>
                                        </div>
                                        <!-- 標題: -->
                                        <div class="row mb-3">
                                            <label for="title" class="col-sm-2 col-form-labels">標題:</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="title" id="title" value="${article.title}" required>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                             <label for="type" class="col-sm-2 col-form-labels">文章分類</label>
                                            <select name="type" aria-label="Default select example" id="type"  required>
<%--                                            <option>${article.type}</option> --%>
                                           <option value="活動資訊">活動資訊</option>
                                           <option value="課程資訊">課程資訊</option>
                                           <option value="食譜討論">食譜討論</option>
                                           </select>
                                           </div>
                                        <!-- 訂單類型: -->
                                        <div class="row mb-3">
                                        <label for="" class="col-sm-2 col-form-labels">發文日期</label>
                                        <input type="date" name="date" id="date" value="${article.date}" required>
                                        </div>
                                        <div class="row mb-3">
                                        <lable for="" class="col-sm-2 col-form-labels">內文:</lable><textarea name="content" id="article" cols="70"
                                         rows="10" required>${article.content}</textarea> <br>
                                         </div>
                                         <div>                                    
                                           <img src="data:image/jpg;base64,${article.base64}"  width="200" height="200" style="display:block; margin:auto;" id="previewImage"/>	
                                          </div>                                                                                                                                                                 
                                         <div class="row mb-3">照片上傳 
                                         <input type="file" name="articleImage" value="" required id="image">
                                         <br>
                                         <br>                                      
                                          <!-- <img id="previewImage" width="200" height="200" style="float:right;" /> -->                         
                                         </div> 
                                         <INPUT  class="btn btn-warning" NAME="INSERT" TYPE="SUBMIT" VALUE="送出編輯">                                       
                                       
                                           

                                        </c:forEach>
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
<!--CKEditor編輯器-->
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>    
<script>
                        ClassicEditor
                                .create( document.querySelector( '#article' ) )
                                .then( editor => {
                                        console.log( editor );
                                } )
                                .catch( error => {
                                        console.error( error );
                                } );
                        
                        
                        $(document).ready(function(){
                            $("body").on("change", "#image", function(e){
                                var file = e.target.files[0];
                                var mediabase64data;
                                getBase64(file).then(
                                    mediabase64data => $('#previewImage').attr('src', mediabase64data)
                                );
                            });
                        })

                        function getBase64(file) {
                            return new Promise((resolve, reject) => {
                                const reader = new FileReader();
                                reader.readAsDataURL(file);
                                reader.onload = () => resolve(reader.result);
                                reader.onerror = error => reject(error);
                            });
                        }
                           
                </script>
</body>


</html>
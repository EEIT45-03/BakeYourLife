<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>修改商品</title>

<%@include file="/JSP/css.html" %>
<style>
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
                                <a href="../Goods/" class="btn btn-primary btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-undo"></i>
                                    </span>
                                    <span class="text">返回商品管理</span>
                                </a>



                            </p>
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">修改商品</h6>
                                </div>
                                <div class="card-body">
                                   
                                   <p>商品編號:${goods.id}</p>
                                   <form:form action="" method="post" modelAttribute="Goods" enctype="multipart/form-data">
                                        <!-- 會員編號: -->
                                        <div class="row mb-3">
                                            <form:label path="name" for="name" class="col-sm-2 col-form-labels">商品名稱:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="name" type="text" class="form-control" name="name" id="name"
                                                    value="${name}" readonly="readonly" required="required"/>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <form:label path="element" for="element" class="col-sm-2 col-form-labels">成分:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="element" type="text" class="form-control" name="element" id="element"
                                                    value="${element}" required="required"/>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <form:label path="origin" for="origin" class="col-sm-2 col-form-labels">商品產地:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="origin" type="text" class="form-control" name="origin" id="origin"
                                                    value="${origin}" required="required"/>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <form:label path="savetime" for="savetime" class="col-sm-2 col-form-labels">商品保存期限:</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="savetime" type="text" class="form-control" name="savetime" id="savetime" onblur="checkdate(this)"
                                                    value="${savetime}" required="required"/>
                                            </div>
                                        </div>
                                        <div class="row mb-3">
                                            <form:label path="packages" for="packages" class="col-sm-2 col-form-labels">商品價格(元):</form:label>
                                            <div class="col-sm-10">
                                                <form:input path="packages" type="text" class="form-control" name="packages" id="packages" onblur="checkprice(this)"
                                                    value="${packages}" required="required"/>
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
                                        
                                        <div class="row mb-3">
                                            <form:label path="productImage" for="origin" class="col-sm-2 col-form-labels">商品圖片:</form:label>
                                            <div class="col-sm-10">
                                            <img id="cs" width='60' height='72' src="<c:url value='/Admin/Goods/crm/picture/${Goods.id}' />" class="">
                                                <form:input path="productImage" type="file" class="form-control" name="picture" 
											id="picture"/>
                                            </div>
                                        </div>
                                     
                                       
                                        <form:button type="submit" class="btn btn-primary">修改商品</form:button>
                                    </form:form>
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



<%@include file="/JSP/javascript.html" %>
    <script>
    $("#picture").change(function(){

    	  readURL(this);

    	});

    	 

    	function readURL(input){

    	  if(input.files && input.files[0]){

    	    var reader = new FileReader();

    	    reader.onload = function (e) {

    	       $(".picture").attr('src', e.target.result);

    	    }

    	    reader.readAsDataURL(input.files[0]);

    	  }

    	}

    
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
        $(document).ready(function(){
            $("body").on("change", "#picture", function(e){
                var file = e.target.files[0];
                var mediabase64data;
                getBase64(file).then(
                    mediabase64data => $('#cs').attr('src', mediabase64data)
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
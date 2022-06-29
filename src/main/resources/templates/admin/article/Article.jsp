<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BakeYourLife</title>

<%@include file="/JSP/css.html"%>
<script type="text/javascript"> 
function del(){ 
if(!confirm("確認要刪除？")){ 
window.event.returnValue = false; 
} 
} 
</script> 
</head>
<style>
.st1 {
            width: 500px;
/*              border-bottom: 1px dashed #0072E3;  */
            padding-bottom: 20px; 
            margin: 20px;
        }
        
  fieldset {
            width: 600px;
            border-radius: 10px;
            border: solid #0072E3;
            margin: 0px auto;

        }
        
      legend {
/*              text-align: center;  */
            color: #0072E3;
            MARGIN-LEFT: 100PX;  
            MARGIN-RIGHT: 100PX;  
        }
        #dataTable_filter{
        display:none;
        }
</style>

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
					<h1 class="h3 mb-4 text-gray-800">貼文管理</h1>
					<p class="mb-4">
						 最新貼文資訊
						<br>
						<br>
						<a href="CreateArticle"
							class="btn btn-primary btn-icon-split btn-sm"> <span
							class="icon text-white-50"> <i class="fas fa-plus"></i>
						</span> <span class="text">新增貼文</span>
						</a>
						</p>
<!-- 						<form action="Art" method="post" class="row float-right"> 						 -->
<!--                         <span>查詢標題:</span><br><input type="text" class="form-control" name="title" id="title" style="width:100px; height:30px;"> -->
<!--                        <input type="submit" name="confirm" value="搜尋" class="btn btn-primary btn-icon-split btn-sm" style="width:80px; height:30px;"> -->
<!--                        </form> -->
                       <br><br>
                      <table style="float: center;"> 
                      <c:forEach items="${article}" var="articles">
										<fieldset>
                                        <legend>貼文資訊</legend>
										<div style="text-align:center;"class="st1"> 
											發文ID:${articles.postid}<br>
											<a href="QueryArticle?postid=${ articles.postid}">
											標題:${ articles.title}
											</a><br>
											文章分類:${ articles.type}<br>
											發文日期:${ articles.date}<br>
											內文:${ articles.content}<br>
											
											</div> 
											<img src="${pageContext.request.contextPath}/Picture?postid=${articles.postid}" width="100" height="100" style="display:block; margin:20px;"/>
											</fieldset>
											
											
                                             
									</c:forEach>
									</table> 
					                
								
					<div class="card shadow mb-4">
					</div>
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary"></h6>
						
						<div class="card-body">
						
							<div class="table-responsive">
                            
							<form action="Article" method="get">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											
											<th>發文ID</th>
											<th>標題</th>
											<th>文章分類</th>
											<th>發文日期</th>
											<th>觀看次數</th>
											<th>刪除</th>
										</tr>
									</thead>
									
									<c:forEach items="${articles}" var="article">
											
										<tr>
											<td>${article.postid}</td>
											<td><a href="QueryArticle?postid=${ article.postid}">
											${ article.title}
											</a></td>
											<td>${ article.type}</td>
											<td>${ article.date}</td>
											<td>${ article.counter}</td>
											<td><button type="button"
														class="btn btn-danger"
														onclick="archiveFunction(${article.postid})" id="btn">刪除貼文</button></td>
								     <!--<td><a class="btn btn-danger"
												href="DeleteArticle?postid=${article.postid}" onclick="del()">刪除貼文</a></td>--> 
										</tr>
											
											
                                             
									</c:forEach>
								</table>
                                    </form>
                              
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
function archiveFunction(postid) {   
    Swal.fire({
        title: '確定要刪除嗎?',
        text: "刪除後無法復原!",
        icon: 'warning',
        showCancelButton: true,
        cancelButtonText: '取消',
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '刪除'
    }).then((result) => {
        if (result.isConfirmed) {
       	 $.post( "./DeleteArticle?postid=" +postid, function( data ) {
       		location.reload();
       	});
        }
    })
}

</script>
</body>

</html>
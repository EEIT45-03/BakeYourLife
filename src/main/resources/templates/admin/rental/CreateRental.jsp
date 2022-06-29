<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>建立租借單</title>

<%@include file="/JSP/css.html" %>
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
					<h1 class="h3 mb-4 text-gray-800"></h1>
					<p class="mb-4">
						<a href="../Rental/" class="btn btn-primary btn-icon-split btn-sm">
							<span class="icon text-white-50"> <i class="fas fa-undo"></i>
						</span> <span class="text">返回租借管理</span></a>
					</p>
					
<%-- 					<c:if test="${error!=null }"> --%>
<!-- 						<div class="alert alert-danger" role="alert"></div> -->
<%-- 					</c:if> --%>

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">建立租借單</h6>
						</div>
						<div class="card-body">
							<form:form action="" method="post" modelAttribute="rental">
								<!-- 會員編號: -->
								<div class="row mb-3">
									<form:label path="userId" for="userId" class="col-sm-2 col-form-labels">會員編號:</form:label>
									<div class="col-sm-10">
										<form:input path="userId" type="number" class="form-control" name="userId"
											id="userId" placeholder="請輸入會員編號" min="1" required="required" />
									</div>
								</div>
								<!-- 租借單編號: -->
								<div class="row mb-3">
									<form:label path="rentalNO" for="rentalNO" class="col-sm-2 col-form-labels">租借單編號:</form:label>
									<div class="col-sm-10">
										<form:input path="rentalNO" type="text" class="form-control" name="rentalNO"
											id="rentalNO" placeholder="請輸入租借單編號" required="required" />
									</div>
								</div>
								<!-- 租借類型: -->
								<div>
									<form:label path="listType" for="listType" class="col-sm-2 col-form-labels">租借類型:</form:label>
									<div class="col-sm-10">
										<form:select path="listType" class="form-control form-select mb-3"
											name="listType" id="listType" aria-label="Default select example" multiple="false">
												<form:option value="venue" selected="selected">場地</form:option>
												<form:option value="tackle">器具</form:option>
										</form:select>								
									</div>
								</div>
								
							<!-- 	<div class="card">
									<div class="card-body">
										<table class="table">
											<thead>
												<tr>
													<th></th>
													<th>清單編號</th>
													<th>租借場地</th>
													<th>出租時間</th>
													<th>歸還時間</th>													
													<th>人數</th>
													<th>小計</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td></td>
														
													<td><form:input path="venueListNo" type="text" class="form-control"
														name="venueListNo" id="venueListNo" placeholder="清單編號"
														required="required"/></td>
													
													<td><form:input path="FK_classId" type="number" class="form-control"
														name="FK_classId" id="FK_classId" min="0" placeholder="租借場地"
														required="required"/></td>
													
													<td><form:input path="lendTime" type="datetime-local" class="form-control"
														name="lendTime" id="lendTime" required="required"/></td>	
															
													<td><form:input path="returnTime" type="datetime-local" class="form-control"
														name="returnTime" id="returnTime" required="required"/></td>	
														
													<td><form:select path="person" class="form-control form-select mb-3"
														name="person" id="person" aria-label="Default select example" multiple="false">
															<form:option value="1" selected="selected">1</form:option>
															<form:option value="2">2</form:option>
															<form:option value="3">3</form:option>
															<form:option value="4">4</form:option>
															<form:option value="5">5</form:option>
															<form:option value="6">6</form:option>
															<form:option value="7">7</form:option>
															<form:option value="8">8</form:option>
															<form:option value="9">9</form:option>
															<form:option value="10">10</form:option>
													</form:select></td>
													
													<td><form:input path="price" type="number" class="form-control subTotal"
														name="price" id="price" placeholder="小計" required="required"/>
													</td>
													
													<td><button id="btn" class="btn btn-primary">
															<i class="fas fa-plus"></i>
														</button></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>	-->			
								<button type="submit" class="btn btn-primary">建立租借單</button>
							</form:form>
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



	<!-- Bootstrap core JavaScript-->
<%@include file="/JSP/javascript.html" %>
	<script>
    $(function () {
        
        $('tbody').on('blur','.subTotal',function(){
        	let subTotal=parseInt($(this).closest('.subTotal').val())
        	console.log(subTotal)
            if(subTotal<0){
            	$(this).closest('.subTotal').val(0)
            	Swal.fire('小計不能為負數')
            }
        })
        
        $('#shippingFee').change(function(){
            let shippingFee=parseInt($('#shippingFee').val());
            if(shippingFee<0){
            	$('#shippingFee').val(0)
            	Swal.fire('運費不能為負數')
            }
        })
        $('#btn').click(function(){
        	let content=`<tr>
                <td>
                <input type="number" class="form-control" name="productNo"
                    id="productNo" placeholder="商品ID" required="required">
            </td>
            <td>
                <input type="text" class="form-control" name="productName"
                    id="productName" placeholder="商品名稱" required="required">
            </td>
            <td>
                <select class="form-control form-select mb-3" name="qty"
                    aria-label="Default select example">
                    <option value="1" selected>1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                </select>
            </td>
            <td>
                <input type="number" class="form-control subTotal" name="subTotal"
                     placeholder="小計" required="required">
            </td>
            <td><button class="del btn btn-danger"><i class="fas fa-minus"></i>	</button></td>

        </tr>`
		if($('tr').length<=10){
			$('tbody').append(content)
		}
        })
        $('tbody').on('click','.del',function(){
        	$(this).closest('tr').remove()
        })
        $('#memNo').blur(function(){
        	let memNo=$('#memNo');
        	let address=$('#address')
            let memNoValue=parseInt(memNo.val());
            $.ajax({
                type: "GET",
                url: "./Check?memNo="+memNoValue,
                dataType: "json",
                success: function (response) {
                	memNo.val(response.user_id)
                	address.val(response.address)
                },
                error: function (thrownError) {
                  memNo.val('')
                  address.val('')
                  Swal.fire({
                        icon: 'error',
                        title: '發生錯誤',
                        text: '不存在這個會員編號'
                    })
                }
              });
        })
    });
    </script>
</body>

</html>
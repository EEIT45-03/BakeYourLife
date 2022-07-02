<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>購物車</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">烘焙工作坊</a>
	</nav>

	<div class="container-fluid">
		<div class="card-body">
			<div class="card-body"></div>
			<div class="card card-body" id="cartBody">
				<table class="table text-center">
					<thead>
						<tr>
							<!-- <th scope="col" class="col-sm-1"></th> -->
							<!-- <th scope="col" width="50"></th> -->
							<th scope="col" class="col-sm-5">商品名稱</th>
							<th scope="col" class="col-sm-1">單價</th>
							<th scope="col" class="col-sm-3">數量</th>
							<th scope="col" class="col-sm-1">小計</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartItems}" var="cartItem">
							<tr>
								<td class="product-name">${cartItem.productName }</td>
								<td class="product-price">$${cartItem.price }</td>
								<td class="product-qty">${cartItem.qty}</td>
								<td class="text-right product-subTotal">$${cartItem.subTotal}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="3" class="text-right">運費</td>
							<td class="text-right" id="shippingFee">$${shippingFee }</td>
						</tr>
						<tr>
							<td colspan="3 " class="text-right">合計</td>
							<td class="text-right" id="total">$${total }</td>
						</tr>
					</tfoot>
				</table>

			</div>
		</div>

		<div class="card-body">
<!-- 			<div class="card-body"></div> -->
			<div class="card card-body">
			<form action="" method="post">
				<div class="row mb-3">
					<label for="address"
						class="col-sm-2 col-form-labels">地址:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							name="address" id="address" placeholder="請輸入地址"
							required="required" value="${address}" />
					</div>
				</div>
<input type="submit" value="提交訂單"  class="btn btn-warning col-12" />


				</form>
			</div>
		</div>
	</div>





	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>

</html>
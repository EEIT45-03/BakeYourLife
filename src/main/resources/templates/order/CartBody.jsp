<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table text-center">
					<thead>
						<tr>
							<th scope="col" class="col-sm-1"></th>
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
								<input class="product-id" type="hidden" value="${cartItem.productNo}" >
								<td class="product-remove" scope="row">
									<button class="btn btn-link"
										onclick="remove(${cartItem.productNo})">
										<i class="fas fa-trash-alt"></i>
									</button>
								</td>
								<!-- <td>
                              <div class="card border-secondary">
                                <img src="https://shoplineimg.com/5a3c2dc46ef2d4b77b0017de/5e52e185fbd3450010f91378/200x200f.webp?source_format=png"
                            class="card-img-top" alt="...">
                              </div>
                            </td> -->
								<td class="product-name">${cartItem.productName }</td>
								<td class="product-price">$${cartItem.price }</td>
								<td class="product-qty"><button
										class="btn btn-light btn-sm minus">
										<i class="fa-solid fa-minus fa-2xs"></i>
									</button> <input type="text" class="text-center" name="qty" class="qty"
									value="${cartItem.qty}" max="20" style="width: 25px">
									<button class="btn btn-light btn-sm plus">
										<i class="fa-solid fa-plus fa-2xs"></i>
									</button></td>
								<td class="text-right product-subTotal">$${cartItem.subTotal}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4" class="text-right">運費</td>
							<td class="text-right" id="shippingFee">$${shippingFee }</td>
						</tr>
						<tr>
							<td colspan="4 " class="text-right">合計</td>
							<td class="text-right" id="total">$${total }</td>
						</tr>
					</tfoot>
				</table>

				<button id="checkout" class="btn btn-warning" onclick="checkout()">結帳</button>
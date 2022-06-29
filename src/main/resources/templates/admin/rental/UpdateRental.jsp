<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="card-body">
	<p class="row mb-3">
		<span class="col-sm-3">租借編號:</span> <span class="col-sm-9">${rental.rentalNO}</span>
	</p>
	
	<p class="row mb-3">
		<span class="col-sm-3">租借類型:</span><span class="col-sm-9">${rental.type}</span>
	</p>
	<form:form action="UpdateRental?rentalId=${rental.rentalId}" method="post"
		modelAttribute="rentalRequest">
		<!-- 會員編號: -->
		<div class="row mb-3">
			<form:label path="userId" for="userId" class="col-sm-3 col-form-labels">會員編號:</form:label>
			<div class="col-sm-9">
				<form:input path="userId" type="text" class="form-control"
					name="userId" id="userId" required="required" />
			</div>
		</div>
		<!-- 總金額: -->
		<div class="row mb-3">
			<form:label path="total" for="total"
				class="col-sm-3 col-form-labels">總金額:</form:label>
			<div class="col-sm-9">
				<form:input path="total" type="number" class="form-control"
					name="total" id="total" min="0" required="required" />
			</div>
		</div>
		<button type="submit" class="btn btn-primary">修改租借單</button>
	</form:form>
</div>

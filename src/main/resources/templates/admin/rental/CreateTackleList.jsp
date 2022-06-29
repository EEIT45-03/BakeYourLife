<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="" method="post" modelAttribute="tackleList">
	<!-- 清單編號: -->
	<div class="row mb-3">
		<form:label path="tackleListNo" for="tackleListNo"
			class="col-sm-2 col-form-labels">清單編號:</form:label>
		<div class="col-sm-10">
			<form:input path="tackleListNo" type="text" class="form-control"
				name="tackleListNo" id="tackleListNo" placeholder="請輸入清單編號"
				required="required" />
		</div>
	</div>
	<!-- 租借器具: -->
	<div class="row mb-3">
		<form:label path="tackleName" for="tackleName"
			class="col-sm-2 col-form-labels">租借器具:</form:label>
		<div class="col-sm-10">
			<form:input path="tackleName" type="text" class="form-control"
				name="tackleName" id="tackleName" placeholder="請輸入器具名稱" 
				required="required"/>
		</div>
	</div>
	<!-- 出租時間: -->
	<div class="row mb-3">
		<form:label path="lendTime" for="lendTime"
			class="col-sm-2 col-form-labels">出租時間:</form:label>
		<div class="col-sm-10">
			<form:input path="lendTime" type="datetime-local" class="form-control"
				name="lendTime" id="lendTime" required="required"/>
		</div>
	</div>
	<!-- 歸還時間: -->
	<div class="row mb-3">
		<form:label path="returnTime" for="returnTime"
			class="col-sm-2 col-form-labels">歸還時間:</form:label>
		<div class="col-sm-10">
			<form:input path="returnTime" type="datetime-local" class="form-control"
				name="returnTime" id="returnTime" required="required"/>
		</div>
	</div>
	<!-- 數量: -->
	<div class="row mb-3">
		<form:label path="quantity" for="quantity"
			class="col-sm-2 col-form-labels">數量:</form:label>
		<div class="col-sm-10">
			<form:input path="quantity" type="number" class="form-control"
				name="quantity" id="quantity" min="1" required="required"/>
		</div>
	</div>
	<!-- 小計: -->
	<div class="row mb-3">
		<form:label path="price" for="price"
			class="col-sm-2 col-form-labels">小計:</form:label>
		<div class="col-sm-10">
			<form:input path="price" type="number" class="form-control"
				name="price" id="price" min="0" required="required"/>
		</div>
	</div>
	<button type="submit" class="btn btn-primary">建立清單</button>
</form:form>
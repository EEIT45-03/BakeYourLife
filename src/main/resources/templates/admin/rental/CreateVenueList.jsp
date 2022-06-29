<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form action="" method="post" modelAttribute="venueList">
	<!-- 清單編號: -->
	<div class="row mb-3">
		<form:label path="venueListNo" for="venueListNo"
			class="col-sm-2 col-form-labels">清單編號:</form:label>
		<div class="col-sm-10">
			<form:input path="venueListNo" type="text" class="form-control"
				name="venueListNo" id="venueListNo" placeholder="請輸入清單編號"
				required="required" />
		</div>
	</div>
	<!-- 租借場地: -->
	<div class="row mb-3">
		<form:label path="className" for="className"
			class="col-sm-2 col-form-labels">租借場地:</form:label>
		<div class="col-sm-10">
			<form:input path="className" type="text" class="form-control"
				name="className" id="className" placeholder="請輸入場地名稱" 
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
	<!-- 人數: -->
	<div class="row mb-3">
		<form:label path="person" for="person"
			class="col-sm-2 col-form-labels">人數:</form:label>
		<div class="col-sm-10">
			<form:input path="person" type="number" class="form-control"
				name="person" id="person" min="1" required="required"/>
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
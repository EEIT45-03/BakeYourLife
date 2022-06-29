<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="card-body">
	<p class="row mb-3">
		<span class="col-sm-3">租借編號:</span> <span class="col-sm-9">${venueList.rental.rentalNO}</span>
	</p>
	
	<p class="row mb-3">
		<span class="col-sm-3">租借類型:</span><span class="col-sm-9">${venueList.rental.type}</span>
	</p>
	<p class="row mb-3">
		<span class="col-sm-3">清單編號:</span><span class="col-sm-9">${venueList.venueListNo}</span>
	</p>
		<form:form action="UpdateVenueList?venueListId=${venueList.venueListId}" method="post"
		modelAttribute="venueListRequest">
		<!-- 租借場地: -->
		<div class="row mb-3">
			<form:label path="className" for="className" class="col-sm-3 col-form-labels">租借場地:</form:label>
			<div class="col-sm-9">
				<form:input path="className" type="text" class="form-control"
 					name="className" id="className" required="required" /> 
			</div>
		</div>
		<!-- 租借時間: -->
		<div class="row mb-3">
			<form:label path="lendTime" for="lendTime"
 				class="col-sm-3 col-form-labels">租借時間:</form:label> 
			<div class="col-sm-9">
 				<form:input path="lendTime" type="datetime-local" class="form-control"
					name="lendTime" id="lendTime" required="required" />
			</div>
 		</div>
 		<!-- 歸還時間: -->
 		<div class="row mb-3">
 			<form:label path="returnTime" for="returnTime" 
				class="col-sm-3 col-form-labels">歸還時間:</form:label> 
 			<div class="col-sm-9">
 				<form:input path="returnTime" type="datetime-local" class="form-control" 
 					name="returnTime" id="returnTime" required="required" /> 
 			</div>
 		</div> 
		<!-- 人數: --> 
 		<div class="row mb-3"> 
 			<form:label path="person" for="person" 
 				class="col-sm-3 col-form-labels">人數:</form:label> 
 			<div class="col-sm-9"> 
 				<form:input path="person" type="number" class="form-control" 
 					name="person" id="person" min="0" required="required" />
 			</div> 
 		</div> 
		<!-- 小計: --> 
 		<div class="row mb-3"> 
 			<form:label path="price" for="price" 
				class="col-sm-3 col-form-labels">小計:</form:label>
			<div class="col-sm-9">
				<form:input path="price" type="number" class="form-control"
 					name="price" id="price" min="0" required="required" /> 
			</div>
		</div>
		<button type="submit" class="btn btn-primary">修改場地清單</button>
	</form:form>
</div>

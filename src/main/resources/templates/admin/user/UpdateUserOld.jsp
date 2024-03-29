<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>修改會員資料</title>

<%@include file="/JSP/css.html"%>
<style>
.fa-check{
	color:GREEN;
}
.wrong{
	color:RED;
}
</style>
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
						<a href="../" class="btn btn-primary btn-icon-split btn-sm">
							<span class="icon text-white-50"> <i class="fas fa-undo"></i>
						</span> <span class="text">返回會員管理</span>
						</a>
					</p>

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">修改會員資料</h6>
						</div>
						<div class="card-body">







							<form id="form" action="" method="post">

								<!-- 會員帳號: -->
								<div class="row mb-3">
									<label for="userName" class="col-sm-2 col-form-labels">帳號:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="userName"
											id="userName" value="${user.username}"  readonly required>
											<span
											class="show" id="s_userName"></span>
									</div>
								</div>
								<!-- 會員密碼: -->
								<div class="row mb-3">
									<label for="password" class="col-sm-2 col-form-labels">密碼:</label>
									<div class="col-sm-10">
										<input type="password" class="form-control" minlength="6" name="password"
											id="password" value="${user.password}" required>
											<input name="changepassword" id="viewpassword" type="radio"
											value="viewpassword" onclick="typeChanger()" />顯示密碼 <input
											name="changepassword" id="hidepassword" type="radio"
											value="hidepassword" onclick="changeBack()" />隱藏密碼 <span class="show"
											id="s_password"></span>
									</div>
								</div>
								<!-- 會員姓名: -->
								<div class="row mb-3">
									<label for="fullName" class="col-sm-2 col-form-labels">會員姓名:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="fullName"
											id="fullName" value="${user.fullName}" required>
											<span class="show" id="s_fullName"></span>
									</div>
								</div>

								<!-- 會員Email: -->
								<div class="row mb-3">
									<label for="email" class="col-sm-2 col-form-labels">E-mail:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="email"
											id="email" value="${user.email}" required>
											<span class="show"
											id="s_email"></span>
									</div>
								</div>


								<!-- 會員電話: -->
								<div class="row mb-3">
									<label for="phone" class="col-sm-2 col-form-labels">手機號碼:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="phone"
											id="phone" value="${user.phone}" required>
											<span class="show" id="s_phone"></span>
									</div>
								</div>
								<!-- 會員生日: -->
								<div class="row mb-3">
									<label for="birth" class="col-sm-2 col-form-labels">生日:</label>
									<div class="col-sm-10">
										<input type="date" class="form-control" name="birth"
											id="birth" value="${user.birth}" required>
									</div>
								</div>
								<!-- 會員性別: -->
								<div class="row mb-3">
									<label for="gender" class="col-sm-2 col-form-labels">性別:</label>
									<div class="col-sm-10">
										<select class="form-control form-select mb-3"
											name="gender" aria-label="Default select example">
											<option value="男" selected>男</option>
											<option value="女" selected>女</option>
										</select>
									</div>
								</div>
								<!-- 會員地址: -->
								<div class="row mb-3">
									<label for="address" class="col-sm-2 col-form-labels">地址:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="address"
											id="address" value="${user.address}" required>
									</div>
								</div>




								<button type="submit" class="btn btn-primary" id="submit">修改會員資料</button>
							</form>
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
<script>
		function typeChanger() {

			document.getElementById("password").type = "text";

		}
		function changeBack() {

			document.getElementById("password").type = "password";

		}
	window.onload = function() {

		document.getElementById("form").onsubmit = function() {
			return checkUserName(),checkPassword(),checkFullName(),checkEmail(),checkPhone();
		}
		document.getElementById("userName").onblur = checkUserName;
		document.getElementById("password").onblur = checkPassword;
		document.getElementById("fullName").onblur = checkFullName;
		document.getElementById("email").onblur = checkEmail;
		document.getElementById("phone").onblur = checkPhone;
	}
		
	function checkUserName() {

		var userName = document.getElementById("userName").value;
		var res = /^[a-zA-Z0-9]{6,}$/;
		var flag1 = res.test(userName);
		if (flag1) {
			document.getElementById("s_userName").innerHTML = "<i class='fa-solid fa-check'>帳號格式正確</i>";
			document.getElementById('submit').disabled=false;
			return true;
		} else {
			document.getElementById("s_userName").innerHTML = "<p class='wrong'>帳號格式錯誤</p>";
			document.getElementById('submit').disabled=true;
			return false;
		}
	}
		
		function checkPassword() {
			var password = document.getElementById("password").value;
			var res = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
			var flag2 = res.test(password);
			if (flag2) {
				document.getElementById("s_password").innerHTML ="<i class='fa-solid fa-check'></i>";
				document.getElementById('submit').disabled=false;
				return true;
			} else {
				document.getElementById("s_password").innerHTML = "<p class='wrong'>密碼格式錯誤: 必須至少 8 個字元含有大小寫英文字母且至少一個數字</p>";
				document.getElementById('submit').disabled=true;
				return false;
			}
		}
		//js驗證真實姓名，是用的unicode字元的來進行匹配
		function checkFullName() {
			var fullName = document.getElementById("fullName").value;
			var res = /^[\u4e00-\u9fa5]{2,4}$/;
			var flag3 = res.test(fullName);
			if (flag3) {
				document.getElementById("s_fullName").innerHTML = "<i class='fa-solid fa-check'></i>";
				document.getElementById('submit').disabled=false;
				return true;
			} else {
				document.getElementById("s_fullName").innerHTML = "<p class='wrong'>姓名格式錯誤:請輸入真實中文名字</p>";
				document.getElementById('submit').disabled=true;
				return false;
			}
		}
		function checkEmail() {
			var email = document.getElementById("email").value;
			var res = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			var flag4 = res.test(email);
			if (flag4) {
				document.getElementById("s_email").innerHTML = "<i class='fa-solid fa-check'></i>";
				document.getElementById('submit').disabled=false;
				return true;
			} else {
				document.getElementById("s_email").innerHTML = "<p class='wrong'>E-mail格式錯誤 Ex: vison919@gmail.com</p>";
				document.getElementById('submit').disabled=true;
				return false;
			}
		}
		function checkPhone() {
			var phone = document.getElementById("phone").value;
			var res = /^09[0-9]{8}$/;
			var flag5 = res.test(phone);
			if (flag5) {
				document.getElementById("s_phone").innerHTML = "<i class='fa-solid fa-check'></i>";
				document.getElementById('submit').disabled=false;
				return true;
			} else {
				document.getElementById("s_phone").innerHTML = "<p class='wrong'>電話格式錯誤 Ex: 0918xxxxxx共10位</p>";
				document.getElementById('submit').disabled=true;
				return false;
			}
		}
		
	</script>


	<%@include file="/JSP/javascript.html"%>

</body>
</html>
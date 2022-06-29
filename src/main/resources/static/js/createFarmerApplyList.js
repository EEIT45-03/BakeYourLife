$(document).ready(function() {
	function getLength(input) {
		//獲取輸入內容
		let userDesc = input.val();

		//判斷字數
		let len;
		if (userDesc) {
			len = userDesc.length;
		} else {
			len = 0
		}

		return len
	}

	$("#farmerProductName").on('input propertychange', function() {
		let len = getLength($(this));
		$("#nameSize").text(len + '/30');
	});
	$("#farmerProductPrice").on('input propertychange', function() {
		let len = getLength($(this));
		$("#priceSize").text(len + '/5');
	});
	$("#farmerProductQuantity").on('input propertychange', function() {
		let len = getLength($(this));
		$("#quaSize").text(len + '/5');
	});
	$("#farmerProductContent").on('input propertychange', function() {
		let len = getLength($(this));
		$("#conSize").text(len + '/100');
	});


	$("#farmerProductDescription").on('input propertychange', function() {
		let len = getLength($(this));
		$("#desSize").text(len + '/500');
	});


	//圖片大小驗證
	$("#farmerProductPic").on("change", function() {

		var file = document.getElementById("farmerProductPic");

		var fileSize = 0;
		var fileMaxSize = 1024;//1M
		var filePath = file.value;

		if (filePath) {
			fileSize = file.files[0].size;
			var size = fileSize / 1024;
			$('#picSize').text((size / 1000).toFixed(2) + 'M/1M');
			if (size > fileMaxSize) {
				$("#img").css('display', 'none')
				alert("檔案大小不能大於1M！");
				file.value = "";
				return false;
			} else if (size <= 0) {
				$("#img").css('display', 'none')
				alert("檔案大小不能為0M！");
				file.value = "";
				return false;
			} else {
				$("#img").css('display', 'inline')
				readURL(this)
			}
		} else {
			$("#farmerProductPicDataUrl").val(null);
			$("#img").css('display', 'none')
			$('#picSize').text('0M/1M');
			return false;
		}
	});




	//	$("#farmerProductPic").change(function() {
	//		$("#img").css('display', 'inline')
	//
	//		readURL(this)
	//
	//	});


	var dataUrl = null;
	function readURL(input) {

		if (input.files && input.files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				dataUrl = e.target.result;
				$("#img").attr('src', dataUrl);

				$("#farmerProductPicDataUrl").val(dataUrl);


			}

			reader.readAsDataURL(input.files[0]);

		}

	}

	$("#sendData").on("click", function() {

		$("#farmerProductName").val($.trim($("#farmerProductName").val()));
		$("#farmerProductPrice").val($.trim($("#farmerProductPrice").val()));
		$("#farmerProductQuantity").val($.trim($("#farmerProductQuantity").val()));
		$("#farmerProductContent").val($.trim($("#farmerProductContent").val()));
		$("#farmerProductDescription").val($.trim($("#farmerProductDescription").val()));

		let date = new Date();
		$("#farmerProductApplyTime").val(date);
	});




});


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

	$("#name").on('input propertychange', function() {
		let len = getLength($(this));
		$("#nameSize").text(len + '/30');
	});
	$("#price").on('input propertychange', function() {
		let len = getLength($(this));
		$("#priceSize").text(len + '/5');
	});
	$("#quantity").on('input propertychange', function() {
		let len = getLength($(this));
		$("#quaSize").text(len + '/5');
	});
	$("#contents").on('input propertychange', function() {
		let len = getLength($(this));
		$("#conSize").text(len + '/100');
	});


	$("#description").on('input propertychange', function() {
		let len = getLength($(this));
		$("#desSize").text(len + '/500');
	});



	$("#sendData").on("click", function() {

		$("#name").val($.trim($("#name").val()));
		$("#price").val($.trim($("#price").val()));
		$("#quantity").val($.trim($("#quantity").val()));
		$("#content").val($.trim($("#content").val()));
		$("#description").val($.trim($("#description").val()));

	});




});

function img(id){
		var file =$(`#${id}`);
		var img =file.closest(".imgUp").find("img");
		var inputDataUrl=file.next();
	
		var fileSize = 0;
		var fileMaxSize = 1024;//1M
		var filePath = file.val();
		if (filePath) {
			fileSize = file[0].files[0].size;
			
			var size = fileSize / 1024;
			if (size > fileMaxSize) {
				img.css('display', 'none')
				Swal.fire({
				  icon: 'error',
				  title: '檔案大小不能大於1MB！',
				  text: '',
				})
				file.val("");
				return false;
			} else if (size <= 0) {
				img.css('display', 'none')
				Swal.fire({
				  icon: 'error',
				  title: '檔案大小不能為0MB！',
				  text: '',
				})
				file.val("");
				return false;
			} else {
				img.css('display', 'inline')
				$('#picError').text("");
				readURL(file)
			}
		} else {
			inputDataUrl.val("");
			img.css('display', 'none')
			$('#picSize').text('0MB/1MB');
			return false;
		}
}

	function readURL(input) {
		let dataUrl = null;
		if (!window.FileReader) {
			Swal.fire({
				  icon: 'error',
				  title: '此瀏覽器不支援！',
				  text: '',
				})
			
		return;//瀏覽器沒支援就跳出
			
		}

		if (input.prop("files") && input[0].files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				dataUrl = e.target.result;
				
				input.closest(".imgUp").find("img").attr('src', dataUrl);
				
				input.next().val(dataUrl)


			}

			reader.readAsDataURL(input[0].files[0]);

		}

	}

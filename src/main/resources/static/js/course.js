//圖片顯示的js
$(document).ready(function(){
	$("body").on("change", "#customFile", function(e){
		var file = e.target.files[0];
		var mediabase64data;
		getBase64(file).then(
			mediabase64data => $('#previewImage').attr('src', mediabase64data)
		);
	});
})

function getBase64(file) {
	return new Promise((resolve, reject) => {
		const reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = () => resolve(reader.result);
		reader.onerror = error => reject(error);
	});
}
//-------圖片顯示的js End-------
//顯示文字的js----
$(document).ready(function () {
	bsCustomFileInput.init()
})
//顯示文字的js End----

function checkForm() {
  //  let checkResult = true;



    let StartDate = new Date($("#StartDate").val());
        let EndDate = new Date($("#EndDate").val());
        if (StartDate > EndDate) {
			Swal.fire({
				  icon: 'error',
				  title: '發生錯誤',
				  text: '開始日期請在結束日期之前',				  
				}).then((result) =>{
					if (result.isConfirmed) {
					$("#StartDate").val('')
					$("#EndDate").val('')
					}
				})

//            alert("開始日期請在結束日期之前");
            checkResult = false;
            return checkResult;
        }

}

$('#InputCourseProduct').click(function () {

	$('#name').val('丙級西點烘焙下午班')
	$('#price').val('14000')
	$('#summary').val('烘培食品概論(麵包、蛋糕、西點)圓頂奶油土司、奶油空心餅(泡芺)')
	$('#desc').val('單元一：烘培食品概論(麵包、蛋糕、西點)、產品分類、原料特性、製程解說及分析、烘培計算及配方範圍演算。單元二：圓頂奶油土司、奶油空心餅(泡芺)' )
})

$('#wrongInput').click(function () {
    
    $('#cProduct').val('1')
	$('#hours').val('60')
    $('#startDate').val('2022-08-22 01:00')
    $('#endDate').val('2022-08-20 01:00')
    $('#venue').val('1')
	$('#applicants').val('0')
    $('#teacher').val('Teacher1')
    $('#note').val('')
})

$('#correctInput').click(function () {

	$('#cProduct').val('1')
	$('#hours').val('60')
	$('#startDate').val('2022-08-22 01:00')
	$('#endDate').val('2022-08-25 01:00')
	$('#venue').val('1')
	$('#applicants').val('0')
	$('#teacher').val('Teacher1')
	$('#note').val('')
})

//課程
function courseIdAlert(id){
//	fetch('./UpdateOrder?orderId='+orderId)
//.then(response => response.text())
//.then(function(data){
	
	if(id==47){
	Swal.fire({
	  title: 'C0001 西點蛋糕麵包',
	  text: '蛋糕、西點、麵包產品教學：戚風蛋糕、杯子蛋糕、蛋糕捲、切片蛋糕、磅蛋糕、古早味鹹蛋糕',
	  imageUrl: 'https://i.imgur.com/lOLPgyY.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我開課吧</a>',
	})}
	
	if(courseId=="C0002"){
	Swal.fire({
	  title: 'C0002 中式麵食',
	  text: '中式麵食',
	  imageUrl: 'https://i.imgur.com/WZdAdGv.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我開課吧</a>',
	})}
	
	if(courseID=="C0003"){
	Swal.fire({
	  title: 'C0003 西點蛋糕麵包',
	  text: '西點蛋糕麵包 平日',
	  imageUrl: 'https://i.imgur.com/CQ4BLqB.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我開課吧</a>',
	})}
	
	if(courseID=="C0004"){
	Swal.fire({
	  title: 'C0004 丙級麵包',
	  text: '丙級麵包 平日下午班',
	  imageUrl: 'https://i.imgur.com/KWg5bSq.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我開課吧</a>',
	})}
	
	if(courseID=="T0001"){
	Swal.fire({
	  title: 'T0001 蛋糕體驗',
	  text: '手作蛋糕體驗',
	  imageUrl: 'https://i.imgur.com/fE6bPtF.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我開課吧</a>',
	})}
	
//});
}

function values(openCourse) {
	$('#openCourse').val(openCourse);
}
$(document).ready(function() {
	$('#courseTable').DataTable( {
		language: {
			url: '//cdn.datatables.net/plug-ins/1.11.5/i18n/zh-HANT.json'
		},
		responsive: {
			details: {
				type: 'column'
			}
		},
		columnDefs: [{
			className: 'dtr-control',
			orderable: false,
			targets: 0,
		}],
		order: [ 1, 'asc' ],
	} );
});
$(document).ready(function() {
	$('#registerTable').DataTable( {
		language: {
			url: '//cdn.datatables.net/plug-ins/1.11.5/i18n/zh-HANT.json'
		},
		responsive: {
			details: {
				type: 'column'
			}
		},
		columnDefs: [{
			className: 'dtr-control',
			orderable: false,
			targets: 0,
		}],
		order: [ 1, 'asc' ],
	} );
});

//刪除開課資料
function deleteCourseAlert(openCourse) {
	Swal.fire({
		title: '請問是否要刪除此筆開課資料?',
		text: "如果刪除開課資料，相關項目也會一併刪除!",
		icon: 'warning',
		showCancelButton: true,
		cancelButtonText: '取消',
		confirmButtonColor: '#ff0000',
		cancelButtonColor: '#3085d6',
		confirmButtonText: '刪除'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "POST",
				url: './DeleteCourse?openCourse=' + openCourse,
				success: function (msg) {
					Swal.fire(
						'已刪除!',
						'開課資料已成功刪除!',
						'success'
					).then((result) => {
						if (result.isConfirmed) {
							location.reload();
						}
					})
				},
				error: function (msg) {
					// console.log(msg.status)
					Swal.fire({
						icon: 'error',
						title: '發生錯誤',
						text: 'HTTP 狀態碼為 ' + msg.status,
						footer: '<a href="https://developer.mozilla.org/zh-TW/docs/Web/HTTP/Status"  target="_blank">為什麼會有這個問題?</a>'
					})
				}
			});


		}
	})
}

//刪除報名資料
function deleteRegisterAlert(registerId) {
	Swal.fire({
		title: '請問是否要刪除此筆報名資料?',
		text: "",
		icon: 'warning',
		showCancelButton: true,
		cancelButtonText: '取消',
		confirmButtonColor: '#ff0000',
		cancelButtonColor: '#3085d6',
		confirmButtonText: '刪除'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "POST",
				url: './DeleteRegister?registerId=' + registerId,
				success: function (msg) {
					Swal.fire(
						'已刪除!',
						'報名資料已成功刪除!',
						'success'
					).then((result) => {
						if (result.isConfirmed) {
							location.reload();
						}
					})
				},
				error: function (msg) {
					// console.log(msg.status)
					Swal.fire({
						icon: 'error',
						title: '發生錯誤',
						text: 'HTTP 狀態碼為 ' + msg.status,
						footer: '<a href="https://developer.mozilla.org/zh-TW/docs/Web/HTTP/Status"  target="_blank">為什麼會有這個問題?</a>'
					})
				}
			});


		}
	})
}
//跳出新增報名
function CreateRegister(){
	Swal.showLoading()
	fetch('./CreateRegister')
		.then(response => response.text())
		.then(function(data){

			Swal.fire({
				title: '新增報名',
				html:data,
				width: '40%',
				showCloseButton: true,
				showCancelButton: false,
				showConfirmButton: false,
				focusConfirm: false
			})
		});
}
//跳出修改報名表
function updateRegister(registerId){
	Swal.showLoading()
	fetch('./UpdateRegister?registerId='+registerId)
		.then(response => response.text())
		.then(function(data){

			Swal.fire({
				title: '修改報名表',
				html:data,
				showCloseButton: true,
				showCancelButton: false,
				showConfirmButton: false,
				focusConfirm: false
			})

		});
}

//跳出新增課程時間清單
function CreateCourseTime(ctimeId){
	Swal.showLoading()
	fetch('./CreateCourseTime?FK_opCourseId=' + ctimeId)
		.then(response => response.text())
		.then(function(data){

			Swal.fire({
				title: '新增場地清單',
				icon: 'info',
				html:data,
				width: '40%',
				showCloseButton: true,
				showCancelButton: false,
				showConfirmButton: false,
				focusConfirm: false
			})
		});
}

//刪除場地清單
function deleteCourseTime(ctimeId) {
	Swal.fire({
		title: '請問是否要刪除此清單?',
		icon: 'warning',
		showCancelButton: true,
		cancelButtonText: '取消',
		confirmButtonColor: '#d33',
		cancelButtonColor: '#3085d6',
		confirmButtonText: '刪除'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "POST",
				url: './DeleteCourseTime?ctimeId=' + ctimeId,
				success: function (msg) {
					Swal.fire(
						'已刪除!',
						'清單已成功刪除!',
						'success'
					).then((result) => {
						if (result.isConfirmed) {
							location.reload();
						}
					})
				},
				error: function (msg) {
					// console.log(msg.status)
					Swal.fire({
						icon: 'error',
						title: '發生錯誤',
						text: 'HTTP 狀態碼為 ' + msg.status,
						footer: '<a href="https://developer.mozilla.org/zh-TW/docs/Web/HTTP/Status"  target="_blank">為什麼會有這個問題?</a>'
					})
				}
			});
		}
	})
}
//跳出修改場地清單
function updateCourseTime(ctimeId){
	Swal.showLoading()
	fetch('./UpdateCourseTime?ctimeId=' + ctimeId)
		.then(response => response.text())
		.then(function(data){

			Swal.fire({
				title: '修改場地清單',
				icon: 'info',
				html:data,
				width: '40%',
				showCloseButton: true,
				showCancelButton: false,
				showConfirmButton: false,
				focusConfirm: false
			})
		});
}



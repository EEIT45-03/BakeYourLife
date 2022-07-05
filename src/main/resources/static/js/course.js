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


   // return checkResult;
}


$('#wrongInput').click(function () {
    
    $('#courseId').val('C0001')
    $('#startDate').val('2022-05-22  01:00')
    $('#endDate').val('2022-05-20 01:00')
    $('#venue').val('1')
	$('#applicants').val('0')
    $('#teacher').val('Teacher1')
    $('#note').val('')
})

$('#correctInput').click(function () {
    
    $('#courseId').val('1')
    $('#startDate').val('2022-05-10 01:00')
    $('#endDate').val('2022-05-20 01:00')
    $('#venue').val('1')
	$('#applicants').val('0')
    $('#teacher').val('Teacher2')
    $('#note').val('本期新增馬卡龍製作')
})


//課程
function courseIdAlert(courseId){
//	fetch('./UpdateOrder?orderId='+orderId)
//.then(response => response.text())
//.then(function(data){
	
	if(courseId=='1'){
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




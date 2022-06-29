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
    
    $('#courseID').val('C0001')
    $('#startDate').val('2022-05-22')
    $('#endDate').val('2022-05-20')
    $('#room').val('R302')
    $('#registerMax').val('')
    $('#teacher').val('Teacher1')
    $('#note').val('')
})

$('#correctInput').click(function () {
    
    $('#courseID').val('C0001')
    $('#startDate').val('2022-05-10')
    $('#endDate').val('2022-05-20')
    $('#room').val('R301')
    $('#registerMax').val('20')
    $('#teacher').val('Teacher2')
    $('#note').val('本期新增馬卡龍製作')
})


//課程
function courseIdAlert(courseID){
//	fetch('./UpdateOrder?orderId='+orderId)
//.then(response => response.text())
//.then(function(data){
	
	if(courseID=="C0001"){
	Swal.fire({
	  title: 'C0001 西點蛋糕麵包',
	  text: '蛋糕、西點、麵包產品教學：戚風蛋糕、杯子蛋糕、蛋糕捲、切片蛋糕、磅蛋糕、古早味鹹蛋糕',
	  imageUrl: 'https://i.imgur.com/lOLPgyY.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我新增課程吧</a>',
	})}
	
	if(courseID=="C0002"){
	Swal.fire({
	  title: 'C0002 中式麵食',
	  text: '中式麵食',
	  imageUrl: 'https://i.imgur.com/WZdAdGv.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我新增課程吧</a>',
	})}
	
	if(courseID=="C0003"){
	Swal.fire({
	  title: 'C0003 西點蛋糕麵包',
	  text: '西點蛋糕麵包 平日',
	  imageUrl: 'https://i.imgur.com/CQ4BLqB.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我新增課程吧</a>',
	})}
	
	if(courseID=="C0004"){
	Swal.fire({
	  title: 'C0004 丙級麵包',
	  text: '丙級麵包 平日下午班',
	  imageUrl: 'https://i.imgur.com/KWg5bSq.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我新增課程吧</a>',
	})}
	
	if(courseID=="T0001"){
	Swal.fire({
	  title: 'T0001 蛋糕體驗',
	  text: '手作蛋糕體驗',
	  imageUrl: 'https://i.imgur.com/fE6bPtF.jpg',
	  imageWidth: 400,
	  
	  imageAlt: 'Custom image',
	  footer: '<a href="./CreateCourse">點我新增課程吧</a>',
	})}
	
//});
}



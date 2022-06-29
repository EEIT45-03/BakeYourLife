$(document).ready(function () {
//    function formatDate(date) {
//        var d = new Date(date),
//            month = '' + (d.getMonth() + 1),
//            day = '' + d.getDate(),
//            year = d.getFullYear();
//    
//        if (month.length < 2) 
//            month = '0' + month;
//        if (day.length < 2) 
//            day = '0' + day;
//    
//        return [year, month, day].join('-');
//    }
    
//    let today = new Date();
//	let endDate = new Date();
//	endDate.setMonth(endDate.getMonth()-6)
//    if($('#edate').val()==''){
//	$('#edate').val(formatDate(today))
//	}
//	if($('#sdate').val()==''){
//	$('#sdate').val(formatDate(endDate))
//	}
    $('#rentalTable').DataTable({
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
            targets: 0
        }, {
            className: 'dt-center',
            targets: [1, 2, 3, 4, 5, 6, 7]
        }],
        order: [1, 'asc']/*,
          dom: 'Bfrtip',
          buttons: [
              'copyHtml5',
              'excelHtml5',
              'csvHtml5'
          ]*/
    });
//    		//在sweetalert2中檢查運費
//            $('body').on('blur','#shippingFee',function(){
//            let shippingFee=parseInt($('#shippingFee').val());
//            if(shippingFee<0){
//            	$('#shippingFee').val(0)
//            	alert('運費不能為負數')
//            }	
//        })
//        $('body').on('blur','#memNo',function(){
//        	let memNo=$('#memNo');
//        	let address=$('#address')
//            let memNoValue=parseInt(memNo.val());
//            $.ajax({
//                type: "GET",
//                url: "./Check?memNo="+memNoValue,
//                dataType: "json",
//                success: function (response) {
//                	memNo.val(response.user_id)
//                	address.val(response.address)
//                },
//                error: function (thrownError) {
//                  memNo.val('')
//                  address.val('')
//				  alert('不存在這個會員編號')
//                }
//              });
//        })
});
/*==========================================================================================================================*/
//刪除租借單
function deleteRental(rentalId) {
    Swal.fire({
        title: '請問是否要刪除此租借單?',
        text: "如果刪除租借單，相關的租借項目也會一併刪除!",
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
                url: './DeleteRental?rentalId=' + rentalId,
                success: function (msg) {
                    Swal.fire(
                        '已刪除!',
                        '訂單已成功刪除!',
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
//跳出修改租借單
function updateRental(rentalId){
Swal.showLoading()
	fetch('./UpdateRental?rentalId='+rentalId)
.then(response => response.text())
.then(function(data){

Swal.fire({
  title: '修改租借單',
  icon: 'info',
  html:data,
  showCloseButton: true,
  showCancelButton: false,
  showConfirmButton: false,
  focusConfirm: false
})

});
}

/*===============================================================================================================*/

//刪除器具清單
function deleteTackleList(tackleListId) {
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
                url: './DeleteTackleList?tackleListId=' + tackleListId,
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
//跳出修改器具清單
function updateTackleList(tackleListId){
Swal.showLoading()
	fetch('./UpdateTackleList?tackleListId=' + tackleListId)
.then(response => response.text())
.then(function(data){

Swal.fire({
  title: '修改器具清單',
  icon: 'info',
  html:data,
  showCloseButton: true,
  showCancelButton: false,
  showConfirmButton: false,
  focusConfirm: false
})
});
}

/*==========================================================================================*/


//刪除場地清單
function deleteVenueList(venueListId) {
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
                url: './DeleteVenueList?venueListId=' + venueListId,
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
function updateVenueList(venueListId){
Swal.showLoading()
	fetch('./UpdateVenueList?venueListId=' + venueListId)
.then(response => response.text())
.then(function(data){

Swal.fire({
  title: '修改場地清單',
  icon: 'info',
  html:data,
  showCloseButton: true,
  showCancelButton: false,
  showConfirmButton: false,
  focusConfirm: false
})
});
}
//跳出新增器具清單
function createTackleList(rentalId){
Swal.showLoading()
	fetch('./CreateTackleList?FK_rentalId=' + rentalId)
.then(response => response.text())
.then(function(data){

Swal.fire({
  title: '新增器具清單',
  icon: 'info',
  html:data,
  showCloseButton: true,
  showCancelButton: false,
  showConfirmButton: false,
  focusConfirm: false
})
});
}
//跳出新增場地清單
function createVenueList(rentalId){
Swal.showLoading()
	fetch('./CreateVenueList?FK_rentalId=' + rentalId)
.then(response => response.text())
.then(function(data){

Swal.fire({
  title: '新增場地清單',
  icon: 'info',
  html:data,
  showCloseButton: true,
  showCancelButton: false,
  showConfirmButton: false,
  focusConfirm: false
})
});
}

/*==========================================================================================*/
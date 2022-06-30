$(document).ready(function () {
    function formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
    
        if (month.length < 2) 
            month = '0' + month;
        if (day.length < 2) 
            day = '0' + day;
    
        return [year, month, day].join('-');
    }
    
    let today = new Date();
	let endDate = new Date();
	endDate.setMonth(endDate.getMonth()-6)
    if($('#edate').val()==''){
	$('#edate').val(formatDate(today))
	}
	if($('#sdate').val()==''){
	$('#sdate').val(formatDate(endDate))
	}
    $('#oredrTable').DataTable({
        language: {
            url: '//cdn.datatables.net/plug-ins/1.11.5/i18n/zh-HANT.json'
        },
        responsive: {
            details: {
                type: 'column'
            }
        },
        columnDefs: [{
            className: 'dt-center',
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
    		//在sweetalert2中檢查運費
            $('body').on('blur','#shippingFee',function(){
            let shippingFee=parseInt($('#shippingFee').val());
            if(shippingFee<0){
            	$('#shippingFee').val(0)
            	alert('運費不能為負數')
            }	
        })
        $('body').on('blur','#userId',function(){
        	let userId=$('#userId');
        	let address=$('#address')
            let userIdValue=parseInt(userId.val());
            $.ajax({
                type: "GET",
                url: "./Check?userId="+userIdValue,
                dataType: "json",
                success: function (response) {
                	userId.val(response.user_id)
                	address.val(response.address)
                },
                error: function (thrownError) {
                  memNo.val('')
                  address.val('')
				  alert('不存在這個會員編號')
                }
              });
        })
});

//跳出修改訂單Alert
function updateAlert(orderId){
Swal.showLoading()
	fetch('./UpdateOrder?orderId='+orderId)
.then(response => response.text())
.then(function(data){

Swal.fire({
  title: '修改訂單',
  icon: 'info',
  html:data,
  showCloseButton: true,
  showCancelButton: false,
  showConfirmButton: false,
  focusConfirm: false
})

});
}
function deleteAlert(orderId) {
    Swal.fire({
        title: '請問是否要刪除此訂單?',
        text: "如果刪除訂單，相關的訂單商品也會一併刪除!",
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
                url: './DeleteOrder?orderId=' + orderId,
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

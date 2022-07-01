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
    	// 	//在sweetalert2中檢查運費
        //     $('body').on('blur','#shippingFee',function(){
        //     let shippingFee=parseInt($('#shippingFee').val());
        //     if(shippingFee<0){
        //     	$('#shippingFee').val(0)
        //     	alert('運費不能為負數')
        //     }
        // })
        // $('body').on('blur','#userId',function(){
        // 	let userId=$('#userId');
        // 	let address=$('#address')
        //     let userIdValue=parseInt(userId.val());
        //     $.ajax({
        //         type: "GET",
        //         url: "./Check?userId="+userIdValue,
        //         dataType: "json",
        //         success: function (response) {
        //         	userId.val(response.user_id)
        //         	address.val(response.address)
        //         },
        //         error: function (thrownError) {
        //           memNo.val('')
        //           address.val('')
		// 		  alert('不存在這個會員編號')
        //         }
        //       });
        // })
});



function showAlert(orderId){
    Swal.showLoading()
    fetch('//localhost:8080/Orders/'+orderId)
        .then(response => {
            if (!response.ok) {
                throw new Error(response.statusText)
            }
            return response.json()
        })
        .catch(error => {
        Swal.showValidationMessage(
            `Request failed: ${error}`
        )
    })
        .then(function(result){

            console.log(result)
            let data = getData(result);
            let trackingNumber = getTrackingNumber(result);
            Swal.fire({
                title: "訂單明細",
                html: `<table class="table text-center">
					<thead>
						<tr>
							<th scope="col" class="col-sm-6">商品名稱</th>
							<th scope="col" class="col-sm-2">商品類型</th>
							<th scope="col" class="col-sm-2">數量</th>
							<th scope="col" class="col-sm-2">小計</th>
						</tr>
					</thead>
					<tbody>
                        ${data}
					</tbody>
					<tfoot>
						<tr>
							<td class="text-lift">運費</td>
							<td colspan="3" class="text-center" id="shippingFee">NT$${result.shippingFee}</td>
						</tr>
						<tr>
							<td class="text-lift">優惠卷折扣</td>
							<td colspan="3" class="text-center" id="coupon">-NT$100</td>
						</tr>
                        <tr>
							<td class="text-lift">合計</td>
							<td colspan="3" class="text-center" id="total">NT$${result.totalPrice}</td>
						</tr>
                        <tr>
                            <td class="text-lift col-sm-2">運送地址</td>
                            <td colspan="3" class="text-center col-sm-10">${result.address}</td>
                        </tr>                        
                        ${trackingNumber}
					</tfoot>
				</table>`,
                width:1000
            })

        });

}


function getData(result){
    let data = "";
    result.orderItemList.forEach(element => {
        data = data +
            `<tr>
			<td class="product-name">${element.productName}</td>
			<td class="product-type">${element.productType}</td>
			<td class="product-qty">${element.qty}</td>
			<td class="text-center product-subTotal">NT$${element.subTotal}</td>
		</tr>`
    });
    return data;
}
function getTrackingNumber(result) {
    if(result.trackingNumber == null){
        return "";
    }else {
        return `<tr>
                   <td class="text-lift col-sm-2">物流單號</td>
                   <td colspan="3" class="text-center col-sm-10">${result.trackingNumber}</td>
             </tr>
             <tr>
                   <td class="text-lift col-sm-2">發貨日期</td>
                   <td colspan="3" class="text-center col-sm-10">${result.shipDate}</td>
             </tr>`
    }
}
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


function refundAlert(orderNo){
    Swal.fire({
        title: '請問是否要通過此訂單的退款請求',
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: '通過',
        denyButtonText: `拒絕`,
        cancelButtonText: '取消',
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            fetch('http://localhost:8080/Order/' + orderNo + '/Refund?choose=accept',
                {
                    method:"POST"
                }).then(
            Swal.fire('退款請求已同意', '', 'success')
            )
        } else if (result.isDenied) {
            fetch('http://localhost:8080/Order/' + orderNo + '/Refund?choose=reject',
                {
                    method:"POST"
                }).then(
            Swal.fire('退款請求已拒絕', '', 'success')
            )
        }
    })
}

function shipAlert(orderNo){
    Swal.fire({
        title: '請輸入物流單號',
        input: 'text',
        inputAttributes: {
            autocapitalize: 'off'
        },
        showCancelButton: true,
        cancelButtonText: '取消',
        confirmButtonText: '發貨',
        showLoaderOnConfirm: true,
        preConfirm: (trackingNumber) => {

            return     fetch('http://localhost:8080/Order/' + orderNo + '/Ship?trackingNumber='+trackingNumber,
                {
                    method:"POST"
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(response.statusText)
                    }
                    return response.json()
                })
                .catch(error => {
                    Swal.showValidationMessage(
                        `發貨失敗: ${error}`
                    )
                })
        }
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire({
                title: `發貨成功`
            }).then((result) => {
                if (result.isConfirmed) {
                    location.reload();
                }
            })
        }
    })
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

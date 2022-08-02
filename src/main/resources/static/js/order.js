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

    let urlParams = new URLSearchParams(window.location.search);

    var edate = $('#edate');

    var sdate = $('#sdate');

    if (urlParams.get('sdate') && urlParams.get('edate')) {
        edate.val(urlParams.get('edate'));
        sdate.val(urlParams.get('sdate'));
    } else {
        let today = new Date();
        let endDate = new Date();
        endDate.setMonth(endDate.getMonth() - 6)
        if (edate.val() === '') {
            edate.val(formatDate(today))
        }
        if (sdate.val() === '') {
            sdate.val(formatDate(endDate))
        }
    }
});


function showAlert(orderId) {
    Swal.showLoading()
    fetch('//localhost:8080/Orders/' + orderId)
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
        .then(function (result) {

            console.log(result)
            let data = getData(result);
            let trackingNumber = getTrackingNumber(result);
            let coupon = getCoupon(result);
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
                           ${coupon}
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
                width: 1000
            })

        });

}


function getData(result) {
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
    if (result.trackingNumber === '' || result.trackingNumber == null) {
        return "";
    } else {
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

function getCoupon(result) {
    if (result.code === "") {
        return "";
    } else {
        return `						<tr>
							<td class="text-lift">優惠券代碼${result.code}</td>
							<td colspan="3" class="text-center" id="coupon">-NT$${result.discountAmount}</td>
						</tr>`
    }
}



function refundingAlert(orderNo,refundReason) {
    Swal.fire({
        title: '請問是否要通過此訂單的退款請求',
        text: "退款原因: "+refundReason,
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: '通過',
        denyButtonText: `拒絕`,
        cancelButtonText: '取消',
    }).then((result) => {
        let baseUrl = 'http://localhost:8080/Order/' + orderNo + '/Refunding?choose=';
        if (result.isConfirmed) {
            fetch(baseUrl + 'accept',
                {
                    method: "POST"
                }).then(
                Swal.fire('退款請求已同意', '', 'success')
                    .then((result) => {
                        if (result.isConfirmed) {
                            location.reload();
                        }
                    })
            )
        } else if (result.isDenied) {
            fetch(baseUrl + 'reject',
                {
                    method: "POST"
                }).then(
                Swal.fire('退款請求已拒絕', '', 'success')
                    .then((result) => {
                        if (result.isConfirmed) {
                            location.reload();
                        }
                    })
            )
        }
    })
}

function refundAlert(orderNo) {
    Swal.fire({
        title: '請選擇退款原因，並提出退款請求',
        input: 'select',
        inputOptions: {
            '0': '等太久',
            '1': '我不想買了',
            '2': '買錯東西',
        },
        showCancelButton: true,
        confirmButtonText: '提出',
        cancelButtonText: '放棄',
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            fetch('http://localhost:8080/Order/' + orderNo + '/Refund/'+result.value,
                {
                    method: "POST",
                }).then(
                Swal.fire('退款請求已提出', '', 'success')
                    .then((result) => {
                        if (result.isConfirmed) {
                            location.reload();
                        }
                    })
            )
        }
    })
}

function cancelAlert(orderNo) {
    Swal.fire({
        title: '請問是否要取消此訂單嗎?',
        showCancelButton: true,
        confirmButtonText: '確定取消訂單',
        cancelButtonText: '放棄',
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            fetch('http://localhost:8080/Order/' + orderNo + '/Cancel',
                {
                    method: "POST"
                }).then(
                Swal.fire('訂單已取消', '', 'success')
                    .then((result) => {
                    if (result.isConfirmed) {
                        location.reload();
                    }
                })
            )
        }
    })
}

function receiveAlert(orderNo) {
    Swal.fire({
        title: '請問是否已收到商品?',
        showCancelButton: true,
        confirmButtonText: '確認收貨',
        cancelButtonText: '放棄',
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            fetch('http://localhost:8080/Order/' + orderNo + '/Receive',
                {
                    method: "POST"
                }).then(
                Swal.fire('訂單已完成', '', 'success')
                    .then((result) => {
                        if (result.isConfirmed) {
                            location.reload();
                        }
                    })
            )
        }
    })
}

function shipAlert(orderNo) {
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

            return fetch('http://localhost:8080/Order/' + orderNo + '/Ship?trackingNumber=' + trackingNumber,
                {
                    method: "POST"
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
                type: "DELETE",
                url: '/Orders/' +orderId,
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

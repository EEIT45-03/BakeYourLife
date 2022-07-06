$(document).ready(function () {

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
            targets: [1, 2, 3, 4, 5]
        }],
        order: [1, 'asc']
    });

    $('#venueTable').DataTable({
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
            targets: [1, 2, 3, 4, 5]
        }],
        order: [1, 'asc']
    });

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


//刪除場地
function deleteVenue(venueId) {
    Swal.fire({
        title: '請問是否要刪除此場地?',
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
                url: './DeleteVenue?venueId=' + venueId,
                success: function (msg) {
                    Swal.fire(
                        '已刪除!',
                        '已成功刪除!',
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
//跳出修改場地
function updateVenue(venueId){
    Swal.showLoading()
    fetch('./UpdateVenue?venueId=' + venueId)
        .then(response => response.text())
        .then(function(data){
            Swal.fire({
                title: '修改場地',
                icon: 'info',
                html:data,
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false
            })
        });
}
//跳出新增場地
function createVenue(){
    Swal.showLoading()
    fetch('./CreateVenue')
        .then(response => response.text())
        .then(function(data){
            Swal.fire({
                title: '新增場地',
                icon: 'info',
                html:  data,
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false,
            })
        });
}

/*==========================================================================================*/


//刪除器具
function deleteTackle(tackleId) {
    Swal.fire({
        title: '請問是否要刪除此器具?',
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
                url: './DeleteTackle?tackleId=' + tackleId,
                success: function (msg) {
                    Swal.fire(
                        '已刪除!',
                        '已成功刪除!',
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
//跳出修改器具
function updateTackle(tackleId){
    Swal.showLoading()
    fetch('./UpdateTackle?tackleId=' + tackleId)
        .then(response => response.text())
        .then(function(data){

            Swal.fire({
                title: '修改器具',
                icon: 'info',
                html:data,
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false
            })
        });
}
//跳出新增器具
function createTackle(){
    Swal.showLoading()
    fetch('./CreateTackle')
        .then(response => response.text())
        .then(function(data){

            Swal.fire({
                title: '新增器具',
                icon: 'info',
                html:data,
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false
            })
        });
}


//器材名稱輸入檢查
function checkTN() {
    var tName = document.getElementById("tackleName").value;
    var res = /^[\u4e00-\u9fa5]{2,10}$/;
    var flag = res.test(tName);
    if (flag) {
        // document.getElementById("s_tName").innerHTML = "<i class='fa-solid fa-check' style='color: #1cc88a'></i>";
        document.getElementById('submit').disabled = false;
        return true;
    } else {
        document.getElementById("s_tName").innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>格式錯誤:請輸入器具的中文名稱</p>";
        document.getElementById('submit').disabled = true;
        return false;
    }
}

//場地名稱輸入檢查
function checkVN() {
    var vName = document.getElementById("venueName").value;
    var res = /^[A-Z]\d{2,5}$/;
    var flag = res.test(vName);
    if (flag && vName.length >3 ) {
        // document.getElementById("s_tName").innerHTML = "<i></i>";
        document.getElementById('submit').disabled = false;
        return true;
    } else {
        document.getElementById('s_vName').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>格式錯誤:場地名稱第一個字為大寫英文,加上3~4個數字</p>";
        document.getElementById('submit').disabled = true;
        return false;
    }

}

//場地清單的場地輸入檢查

function checkVL() {
    console.log('----------------------')
    var  now = Date.now();
    now.setDate(now.getDate()+1);


    var vId = document.getElementById("venueId").value;
    console.log(vId)
    var lTime = document.getElementById("lendTime").value;
    var eTime = document.getElementById("endTime").value;


    if (vId.length >0 ) {
        console.log(vId+"-0000")
        // document.getElementById("s_tName").innerHTML = "<i></i>";
        document.getElementById('submit').disabled = false;
        return true;
    } else {
        console.log(vId+"-11111")
        document.getElementById('s_vId').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>請選擇使用場地</p>";
        document.getElementById('submit').disabled = true;
        return false;
    }
    //
    // if (lTime.getTime() >= now.getTime() ) {
    //     // document.getElementById("s_tName").innerHTML = "<i></i>";
    //     document.getElementById('submit').disabled = false;
    // } else {
    //     document.getElementById('s_lTime').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>輸入錯誤</p>";
    //     document.getElementById('submit').disabled = true;
    //     return false;
    // }
    //
    // if (lTime != null && lTime.length > 0  ) {
    //     var limit = lTime.setHours(lTime.getHours() + 2);
    //     if()
    //     document.getElementById('submit').disabled = false;
    // } else {
    //     document.getElementById('eTime').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>請選擇出租時間</p>";
    //     document.getElementById('submit').disabled = true;
    //     return false;
    // }

}
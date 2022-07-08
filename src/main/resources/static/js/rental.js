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

    // $('#venueTable').DataTable({
    //     language: {
    //         url: '//cdn.datatables.net/plug-ins/1.11.5/i18n/zh-HANT.json'
    //     },
    //     responsive: {
    //         details: {
    //             type: 'column'
    //         }
    //     },
    //     columnDefs: [{
    //         className: 'dtr-control',
    //         orderable: false,
    //         targets: 0
    //     }, {
    //         className: 'dt-center',
    //         targets: [1, 2, 3, 4, 5]
    //     }],
    //     order: [1, 'asc']
    // });

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
    // width: '40%',
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
    // width: '40%',
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
                // width: '40%',
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
    // width: '40%',
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
    // width: '40%',
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
                // width: '40%',
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
                // width: '40%',
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
                // width: '40%',
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
                // width: '40%',
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false
            })
        });
}
/*

//器材名稱輸入檢查
function checkTN() {
    var tName = document.getElementById("tackleName").value;
    var res = /^[\u4e00-\u9fa5]{2,10}$/;
    var flag = res.test(tName);
    if (flag) {
        document.getElementById("s_tName").innerHTML = "<i class='fa-solid fa-check'></i>";
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
        document.getElementById("s_vName").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit').disabled = false;
        return true;
    } else {
        document.getElementById('s_vName').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>格式錯誤:場地名稱第一個字為大寫英文,加上3~4個數字</p>";
        document.getElementById('submit').disabled = true;
        return false;
    }

}

//場地清單的場地輸入檢查

function checkVId() {

    var vId = document.getElementById("venueId").value;

    if (vId.length >0 && vId!= null) {
        document.getElementById("s_vId").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else {
        document.getElementById('s_vId').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>請選擇使用場地</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }

}

//場地清單的出租時間輸入檢查
function checkVLT() {

    var lT = document.getElementById("lendTime").value;
    var lTime = new Date(lT).getTime();

    var now = Date.now();
    var date = new Date(now);
    date.setDate(date.getDate()+1);
    date.setTime(0);

    if (lTime > date) {
        document.getElementById("s_lTime").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else {
        document.getElementById('s_lTime').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>出租時間輸入錯誤,最快為明天</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }
}

//場地清單的結束時間輸入檢查
function checkVET() {

    var lT1 = document.getElementById("lendTime").value;
    var lTime1 = new Date(lT1);
    lTime1.setHours(lTime1.getHours()+2);
    lTime1 = new Date(lTime1).getTime();
    var eT = document.getElementById("endTime").value;
    var eTime = new Date(eT).getTime();

    if (eTime >= lTime1 && lTime1 != null) {
        document.getElementById("s_eTime").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else if(!lTime1){
        document.getElementById('s_eTime').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>請先輸入出租時間</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    } else {
        document.getElementById('s_eTime').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>結束時間輸入錯誤,至少要多於出租時間2小時</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }

}

//器具清單的器具輸入檢查

function checkTId() {

    var tId = document.getElementById("tackleId").value;

    if (tId.length >0 && tId != null) {
        document.getElementById("s_tId").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else {
        document.getElementById('s_tId').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>請選擇器具</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }

}

//器具清單的出租時間輸入檢查
function checkTLD() {

    var lD = document.getElementById("lendDate").value;
    var lDate = new Date(lD).getTime();

    var now = Date.now();

    if (lDate > now) {
        document.getElementById("s_lDate").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else {
        document.getElementById('s_lDate').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>出租日期輸入錯誤,不可輸入今天以前的日期</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }
}

//場地清單的結束時間輸入檢查
function checkTED() {

    var lD1 = document.getElementById("lendDate").value;
    var lDate1 = new Date(lD1).getTime();
    var eD = document.getElementById("endDate").value;
    var eDate = new Date(eD).getTime();

    if (eDate >= lDate1 && lDate1 != null) {
        document.getElementById("s_eDate").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else if(!lDate1){
        document.getElementById('s_eDate').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>請先輸入出租日期</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    } else {
        document.getElementById('s_eDate').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>結束日期輸入錯誤,不可早於出租日期</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }

}

//場地清單的歸還時間輸入檢查
function checkTRD() {

    var eD1 = document.getElementById("endDate").value;
    var eDate1 = new Date(eD1).getTime();
    var rD = document.getElementById("returnDate").value;
    var rDate = new Date(rD).getTime();


    if (rDate >= eDate1) {
        document.getElementById("s_rDate").innerHTML = "<i class='fa-solid fa-check'></i>";
        document.getElementById('submit_List').disabled = false;
        return true;
    } else {
        document.getElementById('s_rDate').innerHTML = "<p style='color: red ; font-size: small ; font-style: italic'>歸還日期輸入錯誤,不可早於結束日期</p>";
        document.getElementById('submit_List').disabled = true;
        return false;
    }
}

function getState() {

    var sta = document.getElementById("state").value;
    if(sta == 'return'){
        document.getElementById('rD').style.display="black";
    } else {
        document.getElementById('rD').style.display="none";
    }
}

 */
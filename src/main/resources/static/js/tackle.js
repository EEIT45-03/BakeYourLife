$(document).ready(function () {

    $('#tackleTable').DataTable({
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

    $("body").on("change", "#image", function(e){
        var file = e.target.files[0];
        var mediabase64data;
        getBase64(file).then(
            mediabase64data => $('#images').attr('src', mediabase64data)
        );
    });
});

function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });



}


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
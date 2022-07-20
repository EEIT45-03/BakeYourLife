$(document).ready(function () {

    $(".carousel-inner").each(function () {

        $(this).children().first().addClass("active");
    })

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

    $(document).on("change", ".uploadFile", function () {
        var file = $(this);
        var img = file.closest(".imgUp").find("img");

        var fileSize = 0;
        var fileMaxSize = 1024;//1M
        var filePath = file.val();
        if (filePath) {
            fileSize = file[0].files[0].size;

            var size = fileSize / 1024;
            if (size > fileMaxSize) {
                Swal.fire({
                    icon: 'error',
                    title: '檔案大小不能大於1MB！',
                    text: '',
                })
                file.val("");
                return false;
            } else if (size <= 0) {
                Swal.fire({
                    icon: 'error',
                    title: '檔案大小不能為0MB！',
                    text: '',
                })
                file.val("");
                return false;
            } else {
                readURL(file)
            }
        } else {
            return false;
        }
    });

    function readURL(input) {
        let dataUrl = null;
        let base64 = "";
        if (!window.FileReader) {
            Swal.fire({
                icon: 'error',
                title: '此瀏覽器不支援！',
                text: '',
            })
            return;//瀏覽器沒支援就跳出
        }

        if (input.prop("files") && input[0].files[0]) {

            var reader = new FileReader();

            reader.onload = function (e) {
                dataUrl = e.target.result;
                base64 = dataUrl.split(",")[1];
                input.closest(".imgUp").find("img").attr('src', dataUrl);
                input.next().val(base64)

            }
            reader.readAsDataURL(input[0].files[0]);
            // imgAdd();
        }
    }


    $(".imgAdd").click(function () {
        imgAdd();
    })

    function imgAdd() {

        if ($(".imgUp").length < 5) {
            $(".imgAdd")
                .before(`<div class=" imgUp" id="imgdiv" >
											<img id="img" class="imagePreview"  src="/img/logo6.png"><br>
											<label class="btn btn-primary imgbtn">
												選擇圖片
												<input type="file" class="uploadFile"
													accept="image/png,image/gif,image/jpg,image/jpeg"
													 id="farmerProductPic" value=""
													style="width: 0px;height: 0px;overflow: hidden;">
												<input type="hidden" name="base64" id="base64" value="">
											</label><i class="fa fa-times del"></i>
										</div>`);

        }
        if ($(".imgUp").length == 5) {
            $(".imgAdd").css("display", "none")
        }

    }


    $(document).on("click", "i.del", function () {
        $(this).prev().children().next().val("");
        $(this).parent().remove();
        $(".imgAdd").css("display", "block");
    });


    // $(document).on("click", "i.del", function () {
    //     $(this).prev().children().next().val("");
    //     $(this).parent().remove();
    //     $(".imgAdd").css("display", "block");
    // });

    $('#submit_c').on('click', function () {
        if (check) {
            var venue = getVenue();
            $.ajax({
                url: "/admin/Venue/CreateVenue",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(venue),
                success: function (res) {
                    Swal.fire(
                        '新增成功',
                        '場地已新增',
                        'success'
                    ).then((result) => {
                        if (result.isConfirmed) {
                            location.href="../Venue/";
                        }
                    })
                },
                error: function (xhr, status, err) {
                    console.log("error=" + err)
                    console.log("status=" + status)
                    console.log("xhr=" + xhr)
                }
            })

        }
    });

    $('#submit_u').on('click', function () {
        if (check) {
            var venue = getVenue();
            $.ajax({
                url: "/admin/Venue/UpdateVenue",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(venue),
                success: function (res) {
                    Swal.fire(
                        '更新成功',
                        '場地已更新',
                        'success'
                    ).then((result) => {
                        if (result.isConfirmed) {
                            location.href="../";
                        }
                    })
                },
                error: function (xhr, status, err) {
                    console.log("error=" + err)
                    console.log("status=" + status)
                    console.log("xhr=" + xhr)
                }
            })

        }
    })

});

function getVenue() {
    let venueId = $.trim($("#vId").val());
    let venueName = $.trim($("#vName").val());
    let personMax = $.trim($("#pMax").val());
    let hrPrice = $.trim($("#hPri").val());
    let sort = $.trim($("#vSort").val());
    let notes = $.trim($("#vNotes").val());
    let base64Array = new Array();
    $("input[name=base64]").each(function () {
        base64Array.push($(this).val());
    });
    let venue = {
        "venueId": venueId,
        "venueName": venueName,
        "personMax": personMax,
        "hrPrice": hrPrice,
        "sort": sort,
        "notes": notes,
        "base64": base64Array
    }
    return venue;
}

function check(){
    let venueName = $.trim($("#vName").val());
    let personMax = $.trim($("#pMax").val());
    let hrPrice = $.trim($("#hPri").val());
    let sort = $.trim($("#vSort").val());
    let notes = $.trim($("#tNotes").val());
    if(venueName === '' || venueName.length <=0){
        Swal.fire(
            '請輸入場地名稱',
            '',
            'warning'
        )
        return false;
    }
    if(personMax === '' || personMax <= 0 ){
        Swal.fire(
            '請輸入場地上限組數',
            '',
            'warning'
        )
        return false;
    }
    if(hrPrice === '' || hrPrice <= 0 ){
        Swal.fire(
            '請輸入價錢/時',
            '',
            'warning'
        )
        return false;
    }
    if(sort === '' || sort <= 0 ){
        Swal.fire(
            '請選擇場地種類',
            '',
            'warning'
        )
        return false;
    }
    if(notes === '' || notes <=0){
        Swal.fire(
        '請輸入場地介紹(備註)',
            '',
            'warning'
        )
        return false;
    }
    return true;
}



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
function updateVenue(venueId) {
    Swal.showLoading()
    fetch('./UpdateVenue?venueId=' + venueId)
        .then(response => response.text())
        .then(function (data) {
            Swal.fire({
                title: '修改場地',
                icon: 'info',
                html: data,
                // width: '40%',
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false
            })
        });
}

//跳出新增場地
function createVenue() {
    Swal.showLoading()
    fetch('./CreateVenue')
        .then(response => response.text())
        .then(function (data) {
            Swal.fire({
                title: '新增場地',
                icon: 'info',
                html: data,
                // width: '40%',
                showCloseButton: true,
                showCancelButton: false,
                showConfirmButton: false,
                focusConfirm: false,
            })
        });
}
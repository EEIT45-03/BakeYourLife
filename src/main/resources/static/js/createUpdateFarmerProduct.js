$(document).ready(function () {
    function getLength(input) {
        //獲取輸入內容
        let userDesc = input.val();

        //判斷字數
        let len;
        if (userDesc) {
            len = userDesc.length;
        } else {
            len = 0
        }

        return len
    }

    $("#name").on('input propertychange', function () {
        let len = getLength($(this));
        $("#nameSize").text(len + '/30');
    });
    $("#price").on('input propertychange', function () {
        let len = getLength($(this));
        $("#priceSize").text(len + '/5');
    });
    $("#quantity").on('input propertychange', function () {
        let len = getLength($(this));
        $("#quaSize").text(len + '/5');
    });
    $("#contents").on('input propertychange', function () {
        let len = getLength($(this));
        $("#conSize").text(len + '/100');
    });

    $("#description").on('input propertychange', function () {
        let len = getLength($(this));
        $("#desSize").text(len + '/500');
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
            imgAdd();


        }

    }


    $(".imgAdd").click(function () {
        imgAdd();
    })

    function imgAdd() {

        if ($(".imgUp").length < 3) {
            $(".imgAdd")
                .before(`<div class=" imgUp" id="imgdiv" >
											<img id="img" class="imagePreview"  src="/img/logo4.png"><br>
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
        if ($(".imgUp").length == 3) {
            $(".imgAdd").css("display", "none")
        }

    }


    $(document).on("click", "i.del", function () {
        $(this).prev().children().next().val("");
        $(this).parent().remove();
        $(".imgAdd").css("display", "block");
    });


    $("#inputData").on("click", function () {
        $("#type").val("水果類").change();
        $("#name").val("愛文芒果5斤(8~9入)禮盒裝");
        $("#price").val("799");
        $("#quantity").val("200");
        $("#storage").val("冰箱冷藏").change();
        $("#contents").val("中、大果規格：8~9入裝");
        $("#description").val("★我們推薦大熊農場愛文芒果的理由\n" +
            "■草生栽培安全用藥\n" +
            "■甜度高 香氣足 果肉細緻\n" +
            "■通過屏科大 381項農藥殘留檢驗\n" +
            "■經產銷履歷驗證");

    })


});

// ====================新增========================

function sendcreate() {
    var xhr = new XMLHttpRequest();
    var jsonString = JSON.stringify(getFarmerProduct());
    console.log(jsonString);
    if (check()) {
        Swal.fire({
            title: '資料上傳中!',
            html: '請稍後...',
            allowOutsideClick: false,
            onBeforeOpen: () => {
                Swal.showLoading()
            },
        });
        xhr.onreadystatechange = function () {
            //建立成功，狀態碼會是201
            if (xhr.readyState === 4 && xhr.status === 201) {
                Swal.fire(
                    '新增成功!',
                    ':D',
                    'success'
                ).then((result) => {
                    if (result.isConfirmed) {
                        location = "./";
                    }
                })
            } else if (xhr.status === 400) {
                Swal.fire(
                    '新增失敗!',
                    json.message,
                    'error'
                )
            }
        }
        xhr.open("POST", '/FarmerProducts', true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(jsonString);
    } else {
        Swal.fire(
            '有欄位未填寫',
            '請填寫完整，謝謝!!',
            'error'
        )
    }

}

// ===================修改========================
function sendupdate(farmerProductId) {
    var xhr = new XMLHttpRequest();
    var jsonString = JSON.stringify(getFarmerProduct());
    console.log(jsonString);
    if (check()) {
        Swal.fire({
            title: '資料上傳中!',
            html: '請稍後...',
            allowOutsideClick: false,
            onBeforeOpen: () => {
                Swal.showLoading()
            },
        });
        xhr.onreadystatechange = function () {
            //修改成功，狀態碼會是200
            if (xhr.readyState === 4 && xhr.status === 200) {
                Swal.fire(
                    '修改成功!',
                    ':D',
                    'success',
                ).then((result) => {
                    if (result.isConfirmed) {
                        location = "./";
                    }
                })
            } else if (xhr.status === 400) {
                Swal.fire(
                    '修改失敗!',
                    json.message,
                    'error'
                )
            }
        }
        xhr.open("PUT", '/FarmerProducts/' + farmerProductId, true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(jsonString);
    } else {
        Swal.fire(
            '有欄位未填寫',
            '請填寫完整，謝謝!!',
            'error'
        )
    }

}


function getFarmerProduct() {


    let type = $("#type").val();
    let name = $.trim($("#name").val());
    let price = $.trim($("#price").val());
    let quantity = $.trim($("#quantity").val());
    let storage = $.trim($("#storage").val());
    let contents = $.trim($("#contents").val());
    let description = $.trim($("#description").val());
    let state = $.trim($("#state").val());
    let launchedTime = $.trim($("#launchedTime").val());
    let suspendTime = $.trim($("#suspendTime").val());
    let violationTime = $.trim($("#violationTime").val());
    let base64Array = new Array();
    $("input[name=base64]").each(function () {
        base64Array.push($(this).val());
    });

    let FarmerProduct = {
        "type": type,
        "name": name,
        "price": price,
        "quantity": quantity,
        "storage": storage,
        "contents": contents,
        "description": description,
        "state": state,
        "launchedTime": launchedTime,
        "suspendTime": suspendTime,
        "violationTime": violationTime,
        "base64": base64Array
    }
    return FarmerProduct;
}

function check() {
    let type = $("#type").val();
    let name = $.trim($("#name").val());
    let price = $.trim($("#price").val());
    let quantity = $.trim($("#quantity").val());
    let storage = $.trim($("#storage").val());
    let contents = $.trim($("#contents").val());
    let description = $.trim($("#description").val());
    if (type === '') {
        return false;
    }
    if (name === '') {
        return false;
    }
    if (price === '') {
        return false;
    }
    if (quantity === '') {
        return false;
    }
    if (storage === '') {
        return false;
    }
    if (contents === '') {
        return false;
    }
    if (description === '') {
        return false;
    }
    return true;
}






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
                img.css('display', 'inline')
                readURL(file)
            }
        } else {
            return false;
        }
    });


    function readURL(input) {
        let dataUrl = null;
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

                input.closest(".imgUp").find("img").attr('src', dataUrl);

                input.next().val(dataUrl)


            }

            reader.readAsDataURL(input[0].files[0]);

        }

    }


    $(".imgAdd").click(function () {

        if ($(".imgUp").length < 5) {
            $(this)
                .closest(".row")
                .find(".imgAdd")
                .before(`<div class=" imgUp" id="imgdiv" >
											<img id="img" class="imagePreview" style="display: none;" src="#"><br>
											<label class="btn btn-primary imgbtn">
												選擇圖片
												<input type="file" class="uploadFile"
													accept="image/png,image/gif,image/jpg,image/jpeg"
													 id="farmerProductPic" value=""
													style="width: 0px;height: 0px;overflow: hidden;">
												<input type="hidden" name="pictureDataUrl" id="pictureDataUrl" value="">
											</label><i class="fa fa-times del"></i>
										</div>`);

        }
        if ($(".imgUp").length == 5) {
            $(".imgAdd").css("display", "none")
        }
    })


    $(document).on("click", "i.del", function () {
        $(this).prev().children().next().val("");
        $(this).parent().remove();
        $(".imgAdd").css("display", "block");
    });


    $("#sendData").on("click", function () {

        $("#name").val($.trim($("#name").val()));
        $("#price").val($.trim($("#price").val()));
        $("#quantity").val($.trim($("#quantity").val()));
        $("#content").val($.trim($("#content").val()));
        $("#description").val($.trim($("#description").val()));

    });

});




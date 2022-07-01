$(document).ready(function() {

	$('#FarmerProductTable').DataTable({
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
		}],
		order: [1, 'asc']
	});


});


//刪除商品
function deleteProduct(farmerProductId) {
	Swal.fire({
		title: '確認刪除此商品?',
		text: "如果刪除，將會永久消失!",
		icon: 'warning',
		showCancelButton: true,
		cancelButtonText: '取消',
		confirmButtonColor: '#f15e5e',
		cancelButtonColor: '#ADADAD',
		confirmButtonText: '刪除'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "POST",
				url: './DeleteFarmerProduct?farmerProductId=' + farmerProductId,
				success: function(msg) {
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
				error: function(msg) {
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
//修改商品狀態
function updateState(farmerProductId,state,title,text) {
	Swal.fire({
		title: `${title}`,
		text: `${text}`,
		icon: 'warning',
		showCancelButton: true,
		cancelButtonText: '取消',
		confirmButtonColor: '#f15e5e',
		cancelButtonColor: '#ADADAD',
		confirmButtonText: '確定'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				type: "POST",
				url: './UpdateFarmerProductState?farmerProductId=' + farmerProductId+'&state='+state,
				success: function(msg) {
					Swal.fire(
						'成功',
						'',
						'success'
					).then((result) => {
						if (result.isConfirmed) {
							location.reload();
						}
					})
				},
				error: function(msg) {
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


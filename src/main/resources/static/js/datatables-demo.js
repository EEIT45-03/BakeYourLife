// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable( {
	language: {
            url: '//cdn.datatables.net/plug-ins/1.11.5/i18n/zh-HANT.json'
        },
    responsive: {
        details: {
            type: 'column'
        }
    },
    order: [[ 0, 'asc' ],[ 1, 'asc' ]]
} );
});
    $(function () {
        let url = window.location.href;
        if(url.indexOf('?') != -1){
		url = window.location.href.split('?')[0]
		}
        if(url.indexOf('#') != -1){
		url = window.location.href.split('#')[0]
		}
        // for single sidebar menu
        $('ul.navbar-nav a').filter(function () {
        	//console.log("a" +  this.href);
            return this.href == url;
        }).parent('.nav-item').addClass('active');

        // for sidebar menu
        $('ul.navbar-nav a.collapse-item').filter(function () {
            return this.href == url;
        })
        .addClass('active')
        .parent()
        .parent(".collapse")
        .addClass('show')
        .parent(".nav-item")
        .addClass('active');
    });
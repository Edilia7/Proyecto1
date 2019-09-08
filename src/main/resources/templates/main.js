$(document).ready(function(){
    $('ul.tabs li a:first').addClass('active');
	$('.forms article').hide();
	$('.forms article:first').show();

	$('ul.tabs li a').click(function(){
		$('ul.tabs li a').removeClass('active');
		$(this).addClass('active');
		$('.forms article').hide();

		var activeTab = $(this).attr('href');
		$(activeTab).show();
		return false;
	});
});

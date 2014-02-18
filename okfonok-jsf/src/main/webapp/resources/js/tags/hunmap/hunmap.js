jQuery(document).ready(function($) {
	if ($('#image_map')) {
		$('#image_map area').each(function() {
			var id = $(this).attr('id');
			$(this).mouseover(function() {
				$('#overlay' + id).show();

			});

			$(this).mouseout(function() {
				$('#overlay' + id).hide();
			});
			
			$(this).click(function() {
				$('#county').val(id);
				remoteChangeCommand();
			});

		});
	}
});
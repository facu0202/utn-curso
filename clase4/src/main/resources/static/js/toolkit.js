$(function(){
						  $("#service").change(function(){
						    $.getJSON('/toolkit/ajax/capabilities',{service: $(this).val(), ajax: 'true'}, function(j){
						      var options = '';
						      
						      options += '<option value="" selected=""></option>';
						      for (var i = 0; i < j.length; i++) {
							        options += '<option value="' + j[i].id + '">' + j[i].name + '</option>';
							      }
						      $("#capability").html(options);
						    })
						  })
						})
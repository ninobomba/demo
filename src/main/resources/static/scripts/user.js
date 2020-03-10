var url = 'http://127.0.0.1:8080'

$(document).ready(function () {

    $('#ui_button_user_save').click(function () {
        save();
    });

    $('#ui_button_user_update').click(function () {
        update();
    });

    $('#ui_button_user_delete').click(function () {
        var id = $('#ui_input_delete_user_id').val();
        if( id ) {
            delete_user(id);
        }
    });

    
    list();
    
});


function save()
{
    var parameters = {
        'name'   : $('#ui_input_create_user_name').val(),
        'age'    : $('#ui_input_create_user_age').val(),
        'status' : $('#ui_input_create_user_status').val()
    };

    $.ajax({
        type: "POST",
        url: url + '/user',
        data: JSON.stringify( parameters ),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        crossDomain: true,
        crossOrigin: true,
        success: function(data, textStatus, xhr){
        },
        complete: function(xhr, textStatus) {
            console.log('request is complete', xhr.status);
            if( xhr.status == 201 ){
                alert( 'user has been saved' );
            }
            list();
        },
        error: function(err) {
        }
    });
}

function list()
{
    $.ajax({
        type: "GET",
        url: url + '/user',
        data:{},
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data, textStatus, xhr){
        	
        	var users = data._embedded.localUsers;
        	
            var table = 'No Data';
            var thead = '<thead><tr><th scope="col">#</th><th scope="col">Name<th>Age</th><th scope="col">Date</th></tr></thead>';
            var rows = '';

            if( xhr.status == 200 )
            {
                for( var index =0; index < users.length; index++ )
                {
                    var user = users[ index ];
                    rows += '<tr><td scope="row">'+ ( index + 1 ) + '</td><td>' + user.name + '</td><td>' + user.age + '</td><td>'+ user.creationDate +'</td></tr>'
                }

                if( users && users.length > 0 ){
                    table = '<table class="table table-striped table-hover">' + thead + '<tbody>' + rows + '</tbody></table>';
                }
            }

            $('#ui_table_user_list').empty().html( table );
        },
        complete: function(xhr, textStatus) {
            console.log('request is complete', xhr.status);
        },
        error: function(err) {
            alert('an error has ocurred');
        }
    });
}


function update()
{
    var id = $('#ui_input_update_user_id').val();

    var parameters = {
    		'id'     : $('#ui_input_update_user_id').val(),
            'name'   : $('#ui_input_update_user_name').val(),
            'age'    : $('#ui_input_update_user_age').val(),
            'status' : $('#ui_input_update_user_status').val()
        };

    $.ajax({
        type: "PUT",
        url: url + '/user/' + id,
        data: JSON.stringify( parameters ),
        headers: {"X-HTTP-Method-Override": "PUT"},
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data, textStatus, xhr){
        },
        complete: function(xhr, textStatus) {
            console.log('request is complete', xhr.status);
            if( xhr.status == 200 ){
                alert( 'user has been updated' );
                list();
            }
        },
        error: function(err) {
        }
    });
}

function delete_user(id)
{
	 $.ajax({
	        type: "DELETE",
	        url: url + '/user/' + id,
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        success: function(data, textStatus, xhr){
	        },
	        complete: function(xhr, textStatus) {
	            console.log('request is complete', xhr.status);
	            if( xhr.status == 200 || xhr.status == 204 ){
	                alert('user has been deleted');
	                list();
	            }
	        },
	        error: function(err) {
	            //alert('an error has ocurred');
	        }
	    });
}

window.onload = function () {

    load();
};


$('#submit').click(function () {

	var room = {
			number_room: document.getElementById('number_room').value,

			floor:  document.getElementById('floor').value,

			number_of_people: document.getElementById('number_of_people').value,
	        
			room_type:  document.getElementById('room_type').value,
	            
	         hotel: {
	            	id: document.getElementById('idHotels').value
	        }
	          
	    };
	document.getElementById('number_room').value = '';
    document.getElementById('floor').value = '';
    document.getElementById('number_of_people').value = '';	
    document.getElementById('room_type').value = 'room type';	

    $.ajax({
        url: 'saveRoom?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(room),
        success : function () {
            load();
        }

    });
});

function load() {

    

    $.ajax({
        url: 'loadRoom?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {

            var allRooms = document.createElement('div');
            allRooms.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
            	var index = res[i].id;
                all += "<div>"+' floor '+res[i].floor +',   room '+res[i].number_room +', for - '+res[i].number_of_people +' people,   room type - '+res[i].room_type + "<a href='deleteRoom/"+index+"'>delete</a></div><br>";
            }
           
            

            document.getElementById('all').innerHTML = all;

        }

    })

}
function deleteRoom(index) {

    $.ajax({

        url: 'deleteRoom?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+' floor '+res[i].floor +',   room '+res[i].number_room +', for - '+res[i].number_of_people +' people,   room type - '+res[i].room_type +'<a onclick="deleteRoom(' + index + ')"> delete </div><br>';
            }
            document.querySelector('all').innerHTML = all;
        }
    })


}

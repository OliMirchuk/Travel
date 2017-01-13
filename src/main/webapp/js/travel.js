window.onload = function () {

    load();
};


$('#submit').click(function () {

    var travel = {
    		country: {
    			id: document.getElementById('idCountry').value},
    		
    		city: {
    			id: document.getElementById('idCity').value},
    		
    		hotel: {
        		id: document.getElementById('idHotel').value},
        	
        	room: {
            	id: document.getElementById('idRoom').value},
            		
            	days_trip: document.getElementById('days_trip').value,

            	type_traffic:  document.getElementById('type_traffic').value,
        
            	cost_travel:  document.getElementById('cost_travel').value,
            	
            	day_start: document.getElementById('date').value
    		
    };
    document.getElementById('days_trip').value = '';
    document.getElementById('type_traffic').value = 'type_traffic';
    document.getElementById('cost_travel').value = '';		
    console.log(travel);
    $.ajax({
        url: 'saveTravel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(travel),
        success : function () {
            load();
        }

    });
});

function load() {

   

    $.ajax({
        url: 'loadTravel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {
        	console.log(res);
            var allTravels = document.createElement('div');
            allTravels.style.backgroundColor = 'aqua';
            allTravels.style.border = 1+'px solid black';
            allTravels.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
            	var index = res[i].id;
                all += "<div>"+res[i].days_trip +' '+res[i].type_traffic+' '+res[i].cost_travel + "<a href='deleteTravel/"+index+"'>delete</a></div><br>";
            }

           

            document.getElementById('all').innerHTML = all;

        }

    });

};
function deleteTravel(index) {

    $.ajax({

        url: 'deleteTravel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].days_trip +' '+res[i].type_traffic+' '+res[i].cost_travel  +'<a onclick="deleteTravel(' + index + ')"> delete </div><br>';
            }
            document.querySelector('all').innerHTML = all;
        }
    })


}

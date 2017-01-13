window.onload = function () {

    load();
};


$('#submit').click(function () {

    var hotel = {
    		hotelName: document.getElementById('hotelName').value,

        stars: document.getElementById('stars').value,

        type_of_food:  document.getElementById('food').value,
        
        city: {
            id: document.getElementById('idCity').value
        }
         
    };
    document.getElementById('hotelName').value = '';
    document.getElementById('stars').value = 'stars';
    document.getElementById('food').value = 'type of food';
    $.ajax({
        url: 'saveHotel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(hotel),
        success : function () {
            load();
        }

    });
});

function load() {

   

    $.ajax({
        url: 'loadHotel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {

            var allHotels = document.createElement('div');
            allHotels.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
            	 var index = res[i].id;
          
                all += "<div>"+res[i].hotelName +' '+res[i].stars  +'* '+' '+res[i].type_of_food  + "<a href='deleteHotel/"+index+"'>delete</a></div><br>";
            }

           

            document.getElementById('all').innerHTML = all;

        }

    })

}

function deleteHotel(index) {

    $.ajax({

        url: 'deleteHotel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+' floor '+res[i].hotelName +' '+res[i].stars  +'* '+' '+res[i].type_of_food   +'<a onclick="deleteHotel(' + index + ')"> delete </div><br>';
            }
            document.querySelector('all').innerHTML = all;
        }
    })


}

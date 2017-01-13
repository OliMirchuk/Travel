window.onload =window.onload = function () {

    load();
};


$('#submit').click(function () {

    var city = {
    		cityName: document.getElementById('cityName').value,

        country: {
            id: document.getElementById('idCountry').value
        }

    };
    document.getElementById('cityName').value = '';
    $.ajax({
        url: 'saveCity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(city),
        success : function () {
            load();
        }

    });
});

function load() {

   

    $.ajax({
        url: 'loadCity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {
console.log(res)
            var allCities = document.createElement('div');        
            allCities.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
            	 var index = res[i].id;
             all +="<div>"+res[i].cityName+"<a href='deleteCity/"+index+"'>delete</a></div><br>";
            }

           

            document.getElementById('all').innerHTML = all;

        }

    });

};

function deleteCity(index) {

    $.ajax({

        url: 'deleteCity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].cityName +'<a onclick="deleteCity(' + index + ')"> delete </div><br>';
            }
            document.querySelector('.all').innerHTML = all;
        }
    })


}

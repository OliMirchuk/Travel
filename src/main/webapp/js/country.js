window.onload = function () {

    load();
};


$('#submit').click(function () {

    var country = {
    		countryName: document.getElementById('countryName').value,
    };
    document.getElementById('countryName').value = '';
    $.ajax({
        url: 'saveCountry?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(country),
        success : function () {
            load();
        }

    });
});

function load() {

   

    $.ajax({
        url: 'loadCountries?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {
console.log(res)
            var allCountries = document.createElement('div');        
            allCountries.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
            	 var index = res[i].id;
             all +="<div>"+res[i].countryName+"<a href='deleteCountry/"+index+"'>delete</a></div><br>";
            }

           

            document.getElementById('all').innerHTML = all;

        }

    });

};

function deleteCountry(index) {

    $.ajax({

        url: 'deleteCountry?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].countryName +'<a onclick="deleteCountry(' + index + ')"> delete </div><br>';
            }
            document.querySelector('.all').innerHTML = all;
        }
    })


}
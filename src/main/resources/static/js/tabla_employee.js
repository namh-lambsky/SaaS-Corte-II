$(document).ready(function () {

    function loadEmployee(data){
        console.log('success', data);

    }

    $.ajax({
        type: 'GET',
        url: 'localhost:8080/employee',
        dataType: 'json',
        success:loadEmployee,

    });
});



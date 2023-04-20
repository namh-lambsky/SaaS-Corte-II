$(function () {
    var $employees=$('#employees')
    $.ajax({
        type: 'GET',
        url: '/employee',
        success: function (data){
            console.log('success', data);
            $.each(data, function (i, item) {
                $employees.append('<li>name:'+ employee.name+', email:'+employee.email+' , role:'+employee.role+' </li>')
                
            })
        }
    });
});
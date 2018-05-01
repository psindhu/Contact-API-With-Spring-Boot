$(document).ready(function() {
    $.ajax({
        url: "http://127.0.0.1:8080/api/list/"
    }).then(function(data) {
       $('.greeting-id').append(data[0].id);
       $('.greeting-content').append(data[0].email);
    });
});
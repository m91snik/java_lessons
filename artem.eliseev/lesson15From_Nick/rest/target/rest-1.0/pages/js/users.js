var users=[];
var dialog;
var selectedUser;
var userType
var userId;

$(document).ready(function() {

	userId = $.cookie("admin_id");
	var adminName = $.cookie("admin_name");
	userType = $.cookie("user_type");
	$("#admin_name").html(adminName);

	dialog = $("#dialog-form").dialog({
            autoOpen: false,
            height: 400,
            width: 400,
            modal: true,
            buttons: {
                "Save": saveUser
            },
            close: function() {
                $("#save-user-form").trigger("reset");
            }
        });

    downloadUsers();

    $("#my-ajax-table").on("dynatable:afterUpdate", function() {
        bindEditEvent();
        bindChangeExpEvent();

        $("#my-ajax-table tbody tr").hover(
            function() {
                 $(this).css('cursor','pointer');
            }, function() {
                 $(this).css('cursor','auto');
            });
    });

    $("#user-add").click(function(){
        $("#save-user-form").trigger("reset");
        dialog.dialog( "open" );
    });


    $("#user-remove").click(function(){
        var checkedValues = $('input:checkbox:checked').map(function() {
            return $(this)
        }).get();
        for(checked of checkedValues){
            $.ajax({
                    url : "controller/user/"+checked.attr('userId'),
                    type : "DELETE"
            });
            $("tr[recId='"+checked.attr('recId')+"']").remove()
        }

    });

});

function downloadUsers(){
    var url='controller/user?userId='+userId;

    $.ajax({
      url: url,
      dataType: 'json',
      success: function(data){
        users=data;
        result=[];
        for(var idx in users){
            user=users[idx];
            result.push(toSimpleUser(user));
            }
        $('#my-ajax-table').dynatable({
            features: {
              paginate: false,
              recordCount: false,
              sorting: false,
              search: false
            },
            dataset:{
                records:result
            },
             writers: {
               _rowWriter: ulWriter
             }
        });

      }
    });
}

function saveUser() {
    selectedUser = selectedUser ? selectedUser : {};
    selectedUser.name = $("#name").val();
    selectedUser.userType = $("#userType").val();
    selectedUser.password = $("#password").val();

    var userIdPath=(selectedUser.id) ? "/"+selectedUser.id : ""
    var url="controller/user" + userIdPath+"?adminId="+userId;
    var type= (selectedUser.id) ?  "PUT" : "POST";
    $.ajax({
        url : url,
        type : type,
        contentType : "application/json; charset=utf-8",
        data : JSON.stringify(selectedUser),
        dataType : "json",
        success : function(user) {
            if(selectedUser.id){
                var raw = $("#tr-"+selectedUser.id);
                raw.replaceWith(ulWriter(raw.attr("recId"), toSimpleUser(selectedUser), null, null));
            } else{
                users.push(user)
                var html=ulWriter(users.length-1, toSimpleUser(user), null, null)
                $('#my-ajax-table tr:last').after(html);
            }
            bindEditEvent();
            bindChangeExpEvent();
             dialog.dialog( "close" );
        },
        error : function(data) {
            alert(data.responseText);
        }
    });
}

function toSimpleUser(user){
        return {"id" : user.id,
                           "name" : user.name,
                           "userType" : user.userType,
                           "creationDate" : user.creationDate
               };

}

function ulWriter(rowIndex, record, columns, cellWriter) {
  line= "<tr id='tr-"+record.id+"' recId='"+rowIndex+"'><td><input class='sel-btn' type='checkbox' id='sel-"+record.id+
    "' recId='"+rowIndex+"' userId='"+record.id+"'/></td>"+"<td>"+record.creationDate+"</td>"+"<td>"+record.name+"</td>"
    +"<td>REGULAR</td>"+
    "<td><button class='edit-btn btn btn-default' id='edit-"+record.id+"' recId='"+rowIndex+"'>Edit</button></td>"
           if(userType!="ADMIN"){
             return line;
            }
    return line+ "<td><button class='change-exp-btn btn btn-default' id='change-exp-"+record.id+"' recId='"+rowIndex+"'>Change Expenses</button></td></tr>";
}

function bindEditEvent(){
    $(".edit-btn").bind( "click", function (e) {
            selectedUser=users[$(this).attr('recId')]

            $("#name").val(selectedUser.name);
            $("#userType").val(selectedUser.userType);
            $("#password").val("");

            dialog.dialog( "open" );
      });
}


function bindChangeExpEvent(){
    $(".change-exp-btn").bind( "click", function (e) {
            selectedUser=users[$(this).attr('recId')]
            $.cookie("user_id", selectedUser.id);
            $.cookie("user_name", null);
            window.location="expenses.html?userName="+selectedUser.name
      });
}



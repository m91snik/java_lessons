var expenses=[];
var dialog;
var selectedExpense;

var userId;

$.urlParam = function(name){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	return results[1] || 0;
}

$(document).ready(function() {

    $( "#dateFrom" ).datepicker({
                    dateFormat: "dd.mm.yy"
                    });
    $( "#dateTo" ).datepicker({
                  dateFormat: "dd.mm.yy"
                  });

	userId = $.cookie("user_id");
	var userName = $.cookie("user_name");
	if(userName && userName!='null'){
	    $("#user_greeting").html("Hello, <span>"+userName+"</span>! <a href=\"logout\">Logout</a>");
	}else{
	 userName=$.urlParam('userName')
	 $("#user_greeting").html(userName+" expenses page. <a href=\"users.html\">Back to Users</a>");
	}

    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 400,
        width: 400,
        modal: true,
        buttons: {
            "Save": saveExpense
        },
        close: function() {
            form[0].reset();
        }
    });

    downloadExpenses();

    $("#my-ajax-table").on("dynatable:afterUpdate", function() {
        bindEditEvent();
        $("#my-ajax-table tbody tr").hover(
            function() {
                 $(this).css('cursor','pointer');
            }, function() {
                 $(this).css('cursor','auto');
            });
    });

    form = dialog.find( "form" ).on( "submit", function( event ) {
        selectedExpense=null;
        event.preventDefault();
        saveExpense();
    });

    $("#exp-add").click(function(){
        form[0].reset();
        dialog.dialog( "open" );
    });

    $("#exp-print").click(function(){
           var url='controller/expenses/report?ownerId='+userId;
           var dateFrom = $( "#dateFrom" ).val();
           var dateTo = $( "#dateTo" ).val();
           if(dateFrom){
              url+="&from="+dateFrom;
           }
           if(dateTo){
                  url+="&to="+dateTo;
           }
            window.location=url
        });

    $("#exp-remove").click(function(){
        var checkedValues = $('input:checkbox:checked').map(function() {
            return $(this)
        }).get();
        for(checked of checkedValues){
            $.ajax({
                    url : "controller/expenses/"+checked.attr('expId'),
                    type : "DELETE"
            });
            $("tr[recId='"+checked.attr('recId')+"']").remove()
        }

    });

    $("#exp-filter").click(function(){
            var url='controller/expenses?ownerId='+userId;
            var dateFrom = $( "#dateFrom" ).val();
            var dateTo = $( "#dateTo" ).val();
            if(dateFrom){
                   url+="&from="+dateFrom;
               }
               if(dateTo){
                       url+="&to="+dateTo;
               }
               $.ajax({
                 url: url,
                 dataType: 'json',
                 success: function(data){
                   expenses=data;
                   result=[];
                   $('#my-ajax-table tbody tr').remove();
                   for(var idx in expenses){
                       expense=expenses[idx];

                       result.push(toSimpleExpense(expense));

                       $('#my-ajax-table tbody').append(ulWriter(expenses.length-1, toSimpleExpense(expense), null, null));
                       bindEditEvent();
                   }

                 }
               });
    });

});

function downloadExpenses(){
    var url='controller/expenses?ownerId='+userId;

    $.ajax({
      url: url,
      dataType: 'json',
      success: function(data){
        expenses=data;
        result=[];
        for(var idx in expenses){
            expense=expenses[idx];

            result.push(toSimpleExpense(expense));
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

function toSimpleExpense(expense){
        return {"id" : expense.id,
                           "amount" : expense.amount,
                           "currency" : expense.currency,
                           "description" : expense.description,
                           "comment" : expense.comment,
                           "creationTime" : expense.creationTime};

}

function ulWriter(rowIndex, record, columns, cellWriter) {
    return "<tr id='tr-"+record.id+"' recId='"+rowIndex+"'><td><input class='sel-btn' type='checkbox' id='sel-"+record.id+"' recId='"+rowIndex+"' expId='"+record.id+"'/></td><td>"+record.creationTime+"</td>"+
    "<td>"+record.amount+" "+record.currency+"</td><td>"+record.description+"</td><td>"+record.comment+"</td><td><button class='edit-btn btn btn-default' id='edit-"+record.id+"' recId='"+rowIndex+"'>Edit</button></td></tr>";
}

function saveExpense() {
    selectedExpense = selectedExpense ? selectedExpense : {};
    selectedExpense.amount = $("#amount").val();
    selectedExpense.currency = $("#currency").val();
    selectedExpense.description = $("#description").val();
    selectedExpense.comment = $("#comment").val();
    selectedExpense.creationTime = $("#creationTime").val();
     selectedExpense.ownerId = userId;

    var expIdPath=(selectedExpense.id) ? "/"+selectedExpense.id : ""
    var url="controller/expenses" + expIdPath;
    var type= (selectedExpense.id) ?  "PUT" : "POST";
    $.ajax({
        url : url,
        type : type,
        contentType : "application/json; charset=utf-8",
        data : JSON.stringify(selectedExpense),
        dataType : "json",
        success : function(expense) {
            if(selectedExpense.id){
                var raw = $("#tr-"+selectedExpense.id);
                raw.replaceWith(ulWriter(raw.attr("recId"), toSimpleExpense(selectedExpense), null, null));
            } else{
                expenses.push(expense)
                var html=ulWriter(expenses.length-1, toSimpleExpense(expense), null, null)
                $('#my-ajax-table tr:last').after(html);
            }
            bindEditEvent();
            dialog.dialog( "close" );
        },
        error : function(data) {
            alert(data.responseText);
        }
    });
}

function bindEditEvent(){
    $(".edit-btn").bind( "click", function (e) {
            selectedExpense=expenses[$(this).attr('recId')]

            $("#amount").val(selectedExpense.amount);
            $("#creationTime").val(selectedExpense.creationTime);
            $("#currency").val(selectedExpense.currency);
            $("#description").val(selectedExpense.description);
            $("#comment").val(selectedExpense.comment);

            dialog.dialog( "open" );
      });
}



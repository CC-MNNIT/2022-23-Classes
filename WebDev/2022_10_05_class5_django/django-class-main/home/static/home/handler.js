
$(".delete_btn").on('click',(e)=>{
    console.log("Delete clicked");
    let id = e.target.id;

    let conf = confirm("Are you sure you want to delete this user...??");

    if(!conf)
        return;

    let url='/orders/handle_cancel_order/';
    let data = {'id':id};

    $.ajax({
        url: url,
        data: data,
        success: function () {
            alert("User Deleted successfully");
        },
        error: function (res) {
            show_toast("An error occured.");
        },
    });

})

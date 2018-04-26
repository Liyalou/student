var Tables={
    loadPage:function(){
    	$("#update").on('click', function(event) {
            $("#updatePassword").load(ctx+'/admin/userContre/updatePasswordPage',function(){
                $("#updatePassword").modal('show');
            })
        }); 
    }
}
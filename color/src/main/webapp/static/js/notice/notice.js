var Tables={
	loadPage:function(){
        //查询申请记录
        $("#search_student").on('click', function() {
            var studentUserName=$("#studentUserName").val();
            $("body").load(ctx+'/admin/vacateNotice/index?userName='+studentUserName,function(){

            });
        });
	}
};
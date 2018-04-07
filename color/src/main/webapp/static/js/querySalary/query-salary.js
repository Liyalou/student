var Tables={
	loadPage:function(){
        //查询申请记录
        $("#search_salary").on('click', function() {
            var studentUserName=$("#studentUserName").val();
            var starCreateTime = $("#starCreateTime").val();
            var endCreateTime = $("#endCreateTime").val();
            $("body").load(ctx+'/amdin/queryVacate/queryIndex?studentUserName='+studentUserName+'&starCreateTime='+starCreateTime+'&endCreateTime='+endCreateTime,function(){

            });
        });
	}
};
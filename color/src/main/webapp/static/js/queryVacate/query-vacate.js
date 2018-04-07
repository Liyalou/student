var Tables={
	loadPage:function(){
        //查询申请记录
        $("#search_vacation").on('click', function() {
            var schoolClassName=$("#schoolClassName").val();
            var starCreateTime = $("#starCreateTime").val();
            var endCreateTime = $("#endCreateTime").val();
            $("body").load(ctx+'/amdin/queryVacate/queryIndex?schoolClassName='+schoolClassName+'&starCreateTime='+starCreateTime+'&endCreateTime='+endCreateTime,function(){

            });
        });
	}
};
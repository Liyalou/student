var Tables={
    loadPage:function(){
        //请假申请
        $(".infoVacation").click(function(){
        	var waitDealId = $(this).attr('id');
            $(".page-content").load(ctx+'/admin/waitDeal/selectWaitDeal?waitDealId='+waitDealId,function(){

            });
        })
        
        
    }
}
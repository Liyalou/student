var Tables={
	loadPage:function(){
       $("#starCreateTime").datetimepicker({
            language:  'zh-CN',
            format: 'yyyy-mm-dd:hh:mm:ss',
            autoclose: true,
            todayBtn: true,
        }).on('changeDate',function(ev){
            var starCreateTime=$("#starCreateTime").val();
            $("#endCreateTime").datetimepicker('setStartDate',starCreateTime);
            $("#starCreateTime").datetimepicker('hide');
        });

        // 结束时间的插件 
        $("#endCreateTime").datetimepicker({
            language:  'zh-CN',
            format: 'yyyy-mm-dd:hh:mm:ss',
            autoclose: true,
            todayBtn: true,
        }).on('changeDate',function(ev){
            var endCreateTime=$("#endCreateTime").val();
            $("#starCreateTime").datetimepicker('setStartDate',endCreateTime);
            $("#endCreateTime").datetimepicker('hide');
        });
        //查询申请记录
        $("#search_salary").on('click', function() {
            var userName=$("#studentUserName").val();
            var starCreateTime = $("#starCreateTime").val();
            var endCreateTime = $("#endCreateTime").val();
            $("body").load(ctx+'/admin/querySalary/querySalaryIndex?userName='+userName+'&starCreateTime='+starCreateTime+'&endCreateTime='+endCreateTime,function(){

            });
        });
	}
};
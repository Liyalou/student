var Tables={
    loadPage:function(){
        //请假申请
        $("#add_vacation").click(function(){
            $(".page-content").load(ctx+'/admin/studentVacate/addInput',function(){

            });
        })
        //修改请假申请
        $(".modifyVacation").on('click', function() {
            var studentVacateId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/studentVacate/addInput?studentVacateId='+studentVacateId,function(){

            });
        });
        //请假申请详情
        $(".infoVacation").on('click', function() {
            var studentVacateId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/studentVacate/getTeacherInfo?studentVacateId='+studentVacateId,function(){

            });
        });
        //查询申请记录
        $("#search_student").on('click', function() {
            var studentName=$("#studentName").val();
            $("body").load(ctx+'/admin/studentVacate/vacateIndex?userName='+studentName,function(){

            });

        });
    }
}
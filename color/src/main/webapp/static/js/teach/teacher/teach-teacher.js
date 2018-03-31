var Tables={
    loadPage:function(){
        //新增教务人员
        $("#add_teacher").click(function(){
            $(".page-content").load(ctx+'/admin/teachTeacher/teacherInput',function(){

            });
        })
        //修改教务人员
        $(".modifyTeacher").on('click', function() {
            var teachTeacherId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/teachTeacher/teacherInput?teachTeacherId='+teachTeacherId,function(){

            });
        });
        //教务人员详情
        $(".infoTeacher").on('click', function() {
            var teachTeacherId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/teachTeacher/getTeacherInfo?teachTeacherId='+teachTeacherId,function(){

            });
        });
        //查询教务人员
        $("#search_teacher").on('click', function() {
            var teacherName=$("#teacerName").val();
            $("body").load(ctx+'/admin/teachTeacher/index?userName='+teacherName,function(){

            });

        });
    }
}
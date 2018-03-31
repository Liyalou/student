var Tables={
    loadPage:function(){
        //新增学生
        $("#add_class").click(function(){
            $(".page-content").load(ctx+'/admin/studentRecord/addInput',function(){

            });
        })
        //修改学生
        $(".modifyStudent").on('click', function() {
            var studentRecordId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/studentRecord/addInput?studentRecordId='+studentRecordId,function(){

            });
        });
        //学生详情
        $(".infoStudent").on('click', function() {
            var studentRecordId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/studentRecord/getStudentInfo?studentRecordId='+studentRecordId,function(){

            });
        });
        //查询学生
        $("#search_student").on('click', function() {
            var studentUserName=$("#studentUserName").val();
            $("body").load(ctx+'/admin/studentRecord/index?userName='+studentUserName,function(){

            });

        });
        //班级选择
        $("#studentClassId").on('change',function() {
            var studentClassName=$(this).find("option:selected").attr('studentClassName')
            $("#studentClassName").val(studentClassName)
        });
    }
}
var Tables={
    loadPage:function(){
        //新增班级
        $("#add_class").click(function(){
            $(".page-content").load(ctx+'/admin/schoolClass/addInput',function(){

            });
        })
        //修改班级
        $(".modifyClass").on('click', function() {
            var schoolClassId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/schoolClass/addInput?schoolClassId='+schoolClassId,function(){

            });
        });
        //班级详情
        $(".infoClass").on('click', function() {
            var schoolClassId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/schoolClass/getSchoolClassInfo?schoolClassId='+schoolClassId,function(){

            });
        });
        //查询班级
        $("#search_teacher").on('click', function() {
            var teacherName=$("#teacerName").val();
            $("body").load(ctx+'/admin/schoolClass/index?userName='+teacherName,function(){

            });

        });
        
        //辅导员选择
        $("#classInstructorUid").on('change',function() {
            var userName=$(this).find("option:selected").attr('userName')
            $("#classInstructorUname").val(userName)
        });
    }
}
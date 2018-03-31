var Tables={
    loadPage:function(){
        //新增教务人员
        $("#add_teacher").click(function(){
            $(".page-content").load(ctx+'/admin/teachTeacher/teacherInput',function(){

            });
        })
        //修改教务人员
        $(".modifyTeacher").on('click', function() {
            console.log($(this))
            var teachTeacherId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/teachTeacher/teacherInput?teachTeacherId='+teachTeacherId,function(){

            });
        });
        //查询教务人员
        $("#search_teacher").on('click', function() {
            var teacherName=$("#teacerName").val();
            $("body").load(ctx+'/admin/teachTeacher/index?userName='+teacherName,function(){

            });

        });
    },
    teachTeacher:function(){
        //新增教务管理人员保存
        $("#teachTeacher_save").on('click', function(event) {
            $.ajax({
                url: ctx+'/admin/teachTeacher/submitTeacher',
                type: 'post',
                dataType: 'json',
                data: $("#teachTeacher_form").serialize(),
                success:function(data){
                    console.log(data)
                }
            })
            
        });
    }
}
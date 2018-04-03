var Tables={
    loadPage:function(){
        //请假申请
        $("#add_SalaryManage").click(function(){
            $(".page-content").load(ctx+'/admin/salaryManage/addInput',function(){

            });
        })
        //修改请假申请
        $(".modifySalaryManage").on('click', function() {
            var salaryManageId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/salaryManage/addInput?salaryManageId='+salaryManageId,function(){

            });
        });
        //请假申请详情
        $(".infoSalaryManage").on('click', function() {
            var salaryManageId=$(this).attr('_id');
            $(".page-content").load(ctx+'/admin/salaryManage/getSalaryInfo?salaryManageId='+salaryManageId,function(){

            });
        });
        //查询申请记录
        $("#search_SalaryManage").on('click', function() {
            var userName=$("#userName").val();
            $("body").load(ctx+'/admin/salaryManage/index?userName='+userName,function(){

            });
        });
        //班级选择
        $("#salaryClassId").on('change',function() {
            var schoolClassId=$(this).find("option:selected").val();
            $("#salaryClassName").val($(this).find("option:selected").text())
            $.ajax({
                url: ctx+'/admin/salaryManage/getStudentByClassId',
                type: 'post',
                dataType: 'json',
                data: {schoolClassId:schoolClassId},
                success:function(data){
                    var str='';
                    $.each(data, function(index, item) {
                        str+='<option value="'+item.studentRecordId+'" >'+item.studentRecordName+'</option>'
                    });
                    $("#studentUserId").html(str);
                    $("#studentUserName").val(data[0].studentRecordName);
                }
            })            
        });
        //学生选择
        $("#studentUserId").on('change',function() {
            $("#studentUserName").val($(this).find("option:selected").text())          
        });
    }
}
var Tables={
    loadPage:function(){
        //请假申请
        $(".infoVacation").click(function(){
        	var waitDealId = $(this).attr('id');
            $(".page-content").load(ctx+'/admin/waitDeal/selectWaitDeal?waitDealId='+waitDealId,function(){

            });
        })
        //同意弹框
        $("#agreeVacate").on('click', function(event) {
            $("#selectTeacher-input").load(ctx+'/admin/waitDeal/selectTeacher?waitDealId='+$("#waitDealId").val()+'&schoolClassId='+$("#studentClassId").val(),function(){
                $("#selectTeacher-input").modal('show');
            })
        });       
        $('#waitReplyResult').on('change',function(event) {
            var waitReplyResult=$(this).find('option:selected').val();
            if (waitReplyResult=='2') {
                $('#teacherTable').hide();
                $("#teacherTable").find('input[name="teacherUserId"]').removeAttr('required');
            }else{
                $('#teacherTable').show();
                $("#teacherTable").find('input[name="teacherUserId"]').attr('required','required');
            }
        });
    }
}
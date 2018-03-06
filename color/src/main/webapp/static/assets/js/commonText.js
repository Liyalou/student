/* 
* @Author: anchen
* @Date:   2017-04-07 14:39:10
* @Last Modified by:   anchen
* @Last Modified time: 2017-05-15 11:46:15
* @参数：一参：弹窗ID、二参：菜单编码、三参：标题、四参数：页面表格ID、五参数：后台要的这条数据ID、
非必填参数，如有请注意参数位置 六参：请假天数，有就传，么有就不传  七参 验收需要ID 八参：申请金额 九参：送审默认标题
*/


(function($){
    $.common = function(inputId,code,title,tableId,flowReferenceId,days,id,beCheckMoney,DefaultTitle){
        console.log(beCheckMoney)
        if(days == undefined){
            days = 0;
        }
        //转码，避免乱码
        var title1=encodeURI(encodeURI(title));
        $('#'+inputId+'').load(ctx+'/flowApproval/newFlowStartPage?menuCode='+code+'&menuTitle='+title1+'&vacationNum='+days+'&fixedAssetsCheckId='+id+'&beCheckMoney='+beCheckMoney,function(){
            $('#'+inputId+'').modal("show");

            $("#h2Title").html(title);
            
            $("#flowTitle").val(DefaultTitle);

            $("#flowApproval_save").unbind('click').click(function(){
                timer("#flowApproval_save")
               
                if($("#flowTitle").val() == ''){
                    $("#flow_end_Title").show();
                    return false
                }
                var id = CommUtils.getJqgridSelected('flowApproval-table');
                var all = $("#flowApproval-table").jqGrid('getRowData', id);
                if(id.length != 1 ){
                    swal("操作提示","请选择一名审核人","error");
                    return error;
                }
                var shoudApprovelJobId = all.jobId
                var shoudApprovelUserId = all.staffUserId

                var allUrl = window.location.pathname;
                var flowUrl = allUrl.substring(6);

                var  checkValue;

                if(days!=""){
                    checkValue = days;
                }else if(beCheckMoney!=""){
                    checkValue = beCheckMoney
                }

                var json = {
                        "flowUrl" : flowUrl, //菜单url
                        "flowReferenceId": flowReferenceId, //这一条数据的ID
                        "flowTitle" : $("#flowTitle").val(), //标题
                        "staApprovalFrom":1, //来源web端
                        "menuCode" : code, //菜单编码
                        "fixedAssetsCheckId" : id, //验收需要的id
                        //"vacationNum" : days,//请假时间
                        "menuTitle" : title, //菜单名称
                        "flowCutOffTime" : $("#flowCutOffTime").val(), //截至时间
                        "statementsNote" : $("#statNote").val(),//送审说明
                        "flowIsUrgent" : $("#flowIsUrgent").val(),//0为非急件 1为急件
                        "shoudApprovelJobId":shoudApprovelJobId,//JobId
                        "shoudApprovelUserId":shoudApprovelUserId,//userId
                        "flowSetId":$("#flowSetId").val(),//流程ID      
                        "checkValue":checkValue//审批金额  & 请假天数 

                }
                console.log(json)

                if($("#flowCutOffTime").val() == '' && $("#flowIsUrgent").val()==1){
                    swal("操作提示","急件请填写截至时间",'error')
                }else{
                 $.ajax({
                        url: ctx+'/flowApproval/newFlowStart',
                        type: 'POST',
                        dataType: 'JSON',
                        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                        data: json,
                        success:function(data){
                            console.log(data)
                            if(data != "该业务正在审核中 请勿重复提交"){
                                $('#'+inputId+'').modal("hide");
                                CommUtils.commConfirm("操作成功",function(){
                                    window.location.reload();
                                });
                            }else{
                                swal ("操作提示!", "该业务正在审核中 请勿重复提交!", "error")
                            }
                        }
                    }) 
                }
                
            });
        })
    }
})(jQuery);
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
            var studentClassName=$(this).find("option:selected").attr('studentClassName');
            $("#studentClassName").val(studentClassName)
        });
        
        $("#download").click(function(){
        	location.href=ctx+"/admin/studentRecord/downloadfile";
        })
        
        $("#upload").on('click', function(event) {
            $("#uploadStudent").load(ctx+'/admin/studentRecord/uploadStudentPage',function(){
                $("#uploadStudent").modal('show');  
//                studentClassId = function() {
//                    return $("#studentClassId").val();
//                };
//                studentClassName = function() {
//                    return $("#studentClassName").val();
//                };
//                //文件上传初始化id为input-id的输入框
//                $("#file-input").fileinput({
//                    //中文
//                    language:'zh',
//                    //后台接收的url
//                    uploadUrl:ctx+'/admin/studentRecord/readexcel',
//                    //异步
//                    uploadAsync:true,
//                    //预览
//                    showPreview:false,
//                    //最大上传
//                    maxFileCount:5,
//                    allowedFileExtensions:[ 'xlsx'],
//                    maxFileSize:10000,
//                    uploadExtraData: function(previewId, index) {   //额外参数的关键点         
//                    	var obj = {};
//                        obj.studentClassId = studentClassId();
//                        obj.studentClassName = studentClassName();
//                        return obj;
//                    }
//                }).on("fileuploaded", function(event, data){
//                	if(!data.response.status){
//                		alert('提示：'+data.response.errorMessage);
//                	}else{
//                		alert('失败个数：'+data.response.failureNumber+';'+data.response.stringBuffer);
//                        $('body').load(ctx+'/admin/studentRecord/index');
//                	}
//                });
            })
        }); 
    }
}
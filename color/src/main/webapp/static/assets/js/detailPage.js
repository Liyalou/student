/* 
* @Author: anchen
* @Date:   2017-04-11 10:25:09
* @Last Modified by:   anchen
* @Last Modified time: 2017-05-13 17:09:18
* @content:详情页面
* @参数：一参：包含这个页面的id、二参：请求这个页面的路径、三参：请求这个页面的参数、四参：ajax的URL、五参：ajax的参数、六参：流程轨迹的htmlId、七参：审核状态ID、八参、回复按钮隐藏，处理回复人信息显示
*/

(function($){



        function toggs(x){
            $("#liucheng").css("display",x)//流程
            $("#tabbable").css("display",x)//询问信息

        } 


    $.detailPage = function( htmlId, URL, dataId, ajaxUrl, ajaxData, orbit, flowState, state){
     

        $(htmlId).load(ctx+""+URL+""+dataId,function(){
            console.log(state)  
            toggs("none")
            $("#back").css("display","none");//退回按钮
            $("#dis_reply").css("display","none");//回复按钮
            $("#Replypage").css("display","none");//处理人信息
            $("#no-dis_reply").css("display","none");//
            $.ajax({
                url: ctx+""+ajaxUrl+"",
                type: 'POST',
                dataType: 'JSON',
                data: ajaxData,
                success:function(data){
                    if(data.flowSheet==null){
                         $(".page-content").load(ctx+''+URL+''+dataId,function(){
                               $("#dis_reply").css("display","block");//回复按钮
                               $("#no-dis_reply").css("display","block");//
                               if(state==3 || state==0){
                                   $("#dis_reply").css("display","none");//回复按钮
                                   $("#no-dis_reply").css("display","none");//
                                        if(state==0){
                                            toggs("none")
                                        }
                               }
                         })
                         return false;
                    }
                    
                    //console.log(data)

                    var stat=(data.flowSheet.flowState)
                    var djzt=(data.record.flowFreezeState)
                if(state == 1){ 
                     if (stat == 1 || stat == 2) { 
                        $("#dis_reply").css("display","none");//回复按钮
                        $("#Replypage").css("display","none");
                        $("#tabbable").show();
                        if(djzt!=2){
                            $("#dis_dotAgree").css("display","block");//不同意
                            $("#dis_agree").css("display","block");//同意
                        }
                    }else{
                        $("#tabbable").show();
                    };
                }else if(state == 2){
                    $("#dis_reply").css("display","block");
                    $("#no-dis_reply").css("display","block");
                    $("#waitDealId").val(data.record.waitDealId)
                    $("#back").css("display","block");
                }else if(state == 3){
                    $("#Replypage").css("display","block");
                }
                   
                    if(data){
                        $("#messSheetid").val(dataId);//传输主键id

                         var stt = data.flowSheet.flowState
                        if(data.flowSheet != null){
                            $("#"+orbit+"").val(data.flowSheet.flowJobNameTrail); //流程轨迹
                            //流程状态
                            var folwType = null;
                            if(stt == "1"){
                                folwType = '待审核'
                                toggs("block")

                            }else if(stt == "2"){
                                folwType = '审核中'
                                toggs("block")
                     
                            }else if(stt == "3"){
                                folwType = '已审批'
                                 toggs("block")
                                
                            }else if(stt == "4") {
                                folwType = '未通过'
                                toggs("block")
                                 
                            }else{
                                folwType = '退回'
                                 toggs("block")
                            }
                            $("#"+flowState+"").val(folwType);
                        }else{
                             toggs("none")
                        }
                         


                        //循环询问信息
                        if(data.messageList != null){
                            var div = '';
                            for(var i = 0 ; i < data.messageList.length ; i++){
                                div += '<div class="col-sm-12" ><div class="media search-media"><div class="media-body"><div><h4 class="media-heading"><p class="blue">'+data.messageList[i].messCreateUname+" @ "+data.messageList[i].messReplyUname+'<span style="margin-left:20px">'+data.messageList[i].messCreateTime+'</span></p></h4></div><p>'+data.messageList[i].messContent+'</p></div></div></div>'
                            }
                            $("#dis_append").append(div);
                            div = '';
                        }
                    }
                }
            });
        });

    }






})(jQuery)
// 按钮定时器，3秒触发一次
function timer(id) {
    $(id).attr('disabled', true);
    setTimeout(function () {
        $(id).attr('disabled', false);
    }, 3000);
}

(function () {
    // 银行卡号管理
    $('#bankBtn').on('click', function () {
        $('#bankcard_input').modal('show');
        jQuery("#bank_table").jqGrid({
            url: ctx + '/userBankCard/userBankCardList',
            datatype: 'json',
            mtype: "POST",
            height: "100%",
            autowidth: true,
            rownumbers: true,
            rownumWidth: 30,
            colNames: ['银行卡id', '', '开户行', '卡号', '创建时间'],
            colModel: [
                {name: 'userBankCardId', index: 'userBankCardId', width: 10, hidden: true},
                {name: 'action', sortable: false, width: 30, hidden: false, fixed: true},
                {name: 'bankCardName', index: 'bankCardName', hidden: false, width: 10},
                {name: 'bankCardNumber', index: 'bankCardNumber', sortable: true, hidden: false, width: 10},
                {name: 'cardCreateTime', index: 'cardCreateTime', editable: false, width: 15, hidden: false},
            ],
            viewrecords: true,
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: "#bank_pager",
            multiselect: false,
            multiboxonly: false,
            altRows: true,
            caption: "银行卡号管理：",
            jsonReader: {
                root: "result",
                total: 'totalPages',
                page: 'page',
                records: 'records'
            },
            loadComplete: function () {
                $('td').css({
                    'text-align': 'center'
                })
                $('th div').css({
                    'text-align': 'center'
                });
                var table = this;
                setTimeout(function () {
                    updatePagerIcons(table);
                }, 0);
                updatePagerIcons(table);
            },
            ondblClickRow: function (rowid) {
                var all = $("#bank_table").jqGrid('getRowData', rowid);
                $(".page-content").load(ctx + '/vehicleFiles/vehicleInfo?vehicleFilesId=' + all.vehicleFilesId, function () {

                });
            },
            gridComplete: function () {
                var ids = jQuery("#bank_table").jqGrid('getDataIDs');
                for (var i = 0; i < ids.length; i++) {
                    var cl = ids[i];
                    checkbox = "<label style=\"padding-left:2px;padding-top:3px\"><input name=\"grid-checkbox\" value=\""
                        + cl + "\"type=\"checkbox\" class=\"ace\"><span class=\"lbl\"></span></label>";
                    jQuery("#bank_table").jqGrid('setRowData', ids[i], {action: checkbox});
                }
                $(window).resize(function () {
                    var winwidth = $('#bank_table_warp').width();
                    $("#bank_table").setGridWidth(winwidth);
                    $('#gview_bank_table').find('.ui-jqgrid-bdiv').css('width', winwidth + 1);
                });
                $('#sidebar-collapse').click(function () {
                    var winwidth = $('#bank_table_warp').width();
                    $("#bank_table").setGridWidth(winwidth);
                    $('#gview_bank_table').find('.ui-jqgrid-bdiv').css('width', winwidth + 1);
                });
                setTimeout(function () {
                    var winwidth = $('#bank_table_warp').width();
                    $("#bank_table").setGridWidth(winwidth);
                    $('#gview_bank_table').find('.ui-jqgrid-bdiv').css('width', winwidth + 1);
                }, 0);

            }
        });

        $('#new_bank').on('click', function (event) {
            $('#bank_form').show();
        });

        $('#bank_close').on('click', function (event) {
            $('#bank_form').css('display', 'none')
            $('#bankCardNumber').val('');
            $('#bankCardName').val('');
        });

        $('#bank_save').on('click', function (event) {
            var bankCardNumber = $('#bankCardNumber').val();
            var bankCardName = $('#bankCardName').val();
            if (!bankCardNumber) {
                $('.bankCardNumber-info').css('display', 'block');
                return false;
            } else {
                $('.bankCardNumber-info').css('display', 'none');
            }
            if (!bankCardName) {
                $('.bankCardName-info').css('display', 'block');
                return false;
            } else {
                $('.bankCardName-info').css('display', 'none');
            }
            $.ajax({
                url: ctx + '/userBankCard/userBankCardSubmit',
                type: 'post',
                data: $("#bank_form").serialize(),
                success: function (result) {
                    if (result == 'true') {
                        $('#bankCardNumber').val('');
                        $('#bankCardName').val('');
                        // CommUtils.commConfirm("操作成功", function () {
                        //     window.location.reload();
                        // });
                        $("#bank_table").trigger('reloadGrid');
                    } else {
                        CommUtils.commAlert("role-input", "数据保存异常，请重试");
                    }
                    ;
                }
            })
        });

        // 修改验收申请弹窗
        $("#update_bank").on('click', function (event) {
            var ids = CommUtils.getJqgridSelected("bank_table");
            var all = $("#bank_table").jqGrid('getRowData', ids[0]);
            if (ids.length == 1) {
                console.log(all)
                $('#userBankCardId').val(all.userBankCardId)
                $('#bankCardName').val(all.bankCardName)
                $('#bankCardNumber').val(all.bankCardNumber)
                $('#bank_form').show();
            } else {
                CommUtils.commAlert("role-input", "选择一条数据");
            }
        });
        // 删除验收申请弹窗
        $("#del_bank").click(function () {
            var ids = CommUtils.getJqgridSelected('bank_table');
            var cardIds = [];
            $.each(ids, function (index, val) {
                var all = $("#bank_table").jqGrid('getRowData', val);
                cardIds.push(all.userBankCardId);
            })
            if (ids.length == 0) {
                CommUtils.commAlert("role-input", "请选择一条数据");
            } else {
                $("#delete_info").load(ctx + '/comContr/deleteComPage', function () {
                    $("#delete_info").modal('show')
                    $('#confirmDelete').click(function () {
                        $("#delete_info").modal('hide')
                        $("#back_del_info_input").load(ctx + '/userBankCard/userBankCardDelete?userBankCardIds=' + cardIds, function () {
                                $("#bank_table").trigger('reloadGrid');
                        })
                    })
                })
            }
        });
    })
})()

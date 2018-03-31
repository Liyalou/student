var Tables={
    loadPage:function(){
        $("#roleAdd").on('click', function (event) {
        	$(".page-content").load(ctx + '/admin/role/roleInput', function () {

        	});
        });        
    }
}

/*$("#submitRole").on('click', function(event){
	$("#wrapForm").submit();
});*/

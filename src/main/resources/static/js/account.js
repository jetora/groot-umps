//折叠
$('.collapse').collapse({
    toggle: true,parent:'#accordion'
})
$('.panel-heading').on('click', function () {
    var self = this;
    $(self).nextAll().eq(0).collapse("show");
})
$(document).on('keydown', function (event) {
    // 键盘翻页事件
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 38 || e && e.keyCode == 37) {//上,左
        // 上一页
        $('.page-pre').click()
    }
    if (e && e.keyCode == 40 || e && e.keyCode == 39) {//下,右
        // 下一页
        $('.page-next').click()
    }

})
// 初始化页面加载表格数据
$(function () {
    $('#enabled_type').val("")
    $('#search_username').val("")
    $('#search_username').bind('keyup', function (event) {
        if (event.keyCode == "13") {
            //回车执行查询
            searchData();
        }
    });
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

//获得全部角色数据
function getAllRoles() {
    $.ajax({
        type: 'get',
        url: '/api/role',
        dataType: "json",
        success: function (ret) {
            if (ret.code==200) {
                var opstr = "";
                $.each(ret.data, function (i, n) {
                    opstr += " <option value=\"" + n.id + "\">" + n.name + "</option>";
                })
                $("#sel_role").append(opstr);
                $("#sel_role").selectpicker('refresh');

            }
        }
    })

}
function resetData() {
    $('#enabled_type').val("")
    $('#search_username').val("")
    searchData()
}
// 点击查询按钮
function searchData() {
    $('#account_table').bootstrapTable('refreshOptions', {pageNumber: 1, offset: 0});
    //$('#account_table').bootstrapTable('refresh');
}
var responseHandler = function (e) {
    if (e.data && e.data.length > 0) {
        return { "rows": e.data, "total": e.total };
    }
    else {
        return { "rows": [], "total": 0 };
    }
}
// 表格数据查询参数
var queryParams = function (params) {
    var temp = {
        pageSize : params.limit,
        offset: params.offset,
        order: params.order,
        ordername: params.sort,
        username: $("#search_username").val(),
        enabled: $("#enabled_type").val()
    };
    //$.each(params, function (index, value) {
    //    console.log(index+"---"+value);
    //})
    return temp;
}
var TableInit = function () {
    var oTableInit = new Object();
    oTableInit.Init = function () {
        $('#account_table').bootstrapTable({
            url: '/api/account/pageInfo',                      //请求后台的URL（*）
            method: 'GET',                      //请求方式（*）
            dataType: "json",
            contentType: 'application/json,charset=utf-8',
            toolbar: "#toolbar",                //一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
            uniqueId: "id",                    //每一行的唯一标识，一般为主键列
            //height: document.body.clientHeight-165,   //动态获取高度值，可以使表格自适应页面
            cache: false,                       // 不缓存
            striped: true,                      // 隔行加亮
            queryParamsType: "limit",           //设置为"undefined",可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                                                //设置为"limit",符合 RESTFul 格式的参数,可以获取limit, offset, search, sort, order
            queryParams: queryParams,
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            // sortable: true,                     //是否启用排序;意味着整个表格都会排序
            sortName: 'id',                    // 设置默认排序为 name
            sortOrder: "asc",                   //排序方式
            pagination: true,                   //是否显示分页（*）
            //search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            showToggle:true,                    //是否显示详细视图和列表视图
            //clickToSelect: true,                //是否启用点击选中行
            minimumCountColumns: 2,          //最少允许的列数 clickToSelect: true, //是否启用点击选中行
            pageNumber: 1,                   //初始化加载第一页，默认第一页
            pageSize: 10,                    //每页的记录行数（*）
            pageList: [10, 25, 50, 100],     //可供选择的每页的行数（*）
            paginationPreText: "Previous",
            paginationNextText: "Next",
            paginationFirstText: "First",
            paginationLastText: "Last",
            responseHandler: responseHandler,
            onLoadSuccess: function (data) {
                //console.log(data);
            },
            onLoadError: function (data) {
                layer.msg("加载数据失败", {time : 1500, icon : 2});
                //console.log(data);
                //$('#account_table').boostrapTable('load', savedData);
            },
            formatLoadingMessage: function () {
                return "请稍等，正在加载中...";
            },
            columns: [
                {
                    checkbox: true,
                    visible: true                  //是否显示复选框
                },
                {
                    field: 'id',
                    title: 'ID',
                    sortable: true
                }, {
                    field: 'username',
                    title: '用户名',
                    sortable: true
                }, {
                    field: 'password',
                    title: '密码',
                    sortable: true
                }, {
                    field: 'enabled',
                    title: '是否可用',
                    sortable: true,
                    formatter:staFormatter
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    sortable: true
                },{
                    field: 'updateTime',
                    title: '修改时间',
                    sortable: true
                }, {
                    field:'operation',
                    title: '操作',
                    width: 120,
                    align: 'center',
                    valign: 'middle',
                    formatter: optFormatter,
                    events:optEvents
                },
            ]
        })
    }
    return oTableInit;
}
// 修改，删除按钮
function optFormatter(value, row) {
    var ret_butns = [];
    var edit_permit = row.editPermit;
    var remove_permit = row.removePermit;
    ret_butns.push('<a class="edit" href="javascript:void(0)" title="edit"><i class="fa fa-edit"></i></a> ');
    //ret_butns.push('<a class="roles" href="javascript:void(0)" title="roles"><i class="fa fa-book"></i></a> ');
    ret_butns.push('<a class="remove" href="javascript:void(0)" title="delete"><i class="fa fa-trash-o"></i></a> ');
    if (ret_butns.length > 0) {
        return ret_butns.join('');
    } else {
        return '<span class="label label-info">无权限</span>';
    }
}
// 状态
function staFormatter(value, row, index) {
    var status = "";
    if (2 == value) {
        status = '<span class="label label-danger">不可用</span>';
    } else if (1 == value) {
        status = '<span class="label label-info" >正常</span>';
    } else {
        status = "其他";
    }
    return status;
}
// 点击修改，删除按钮
window.optEvents = {
    'click .edit': function (e, value, row) {
        editData(row);
    },
    'click .roles': function (e, value, row) {
        //alert(row)
        relData(row);
    },
    'click .remove': function (e, value, row) {
        //var message = "确定要删除项目：" + row.asset_title + "?";
        //var r = confirm(message);
        //if (r == true) {
        //    delete_project(row.asset_id, row.asset_title);
        //}
        const swalWithBootstrapButtons = swal.mixin({
            confirmButtonClass: 'btn btn-success',
            cancelButtonClass: 'btn btn-danger',
            buttonsStyling: false,
        })

        swalWithBootstrapButtons({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
                delete_Data(row.id);
            } else if (
                // Read more about handling dismissals
                result.dismiss === swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons(
                    'Cancelled',
                    'Your imaginary file is safe :)',
                    'error'
                )
            }
        })
    }
};
// 添加项目
function addData() {
    // 设置标题
    $("#modalTitle").text("新增项目");
    var accountModal = $('#accountModal');
    // 初始化form表单内容
    accountModal.find('.modal-body #opt_type').val("add");
    accountModal.find('.modal-body #id').val("");
    accountModal.find('.modal-body #username').val("");
    accountModal.find('.modal-body #password').val("");
    getAllRoles();
    accountModal.find('.modal-body #enabled').selectpicker('val',1);
    accountModal.modal("show");
}
function editData(row) {
    $('#modalTitle').text('修改项目');
    var accountModal = $('#accountModal');
    accountModal.find('.modal-body #opt_type').val("edit");
    accountModal.find('.modal-body #id').val(row.id);
    accountModal.find('.modal-body #username').val(row.username);
    accountModal.find('.modal-body #password').val(row.password);
    accountModal.find('.modal-body #enabled').selectpicker('val',row.enabled);
    accountModal.find('.modal-body #enabled').val(row.enabled);
    accountModal.modal('show');
}
// 新增或编辑form表单内容
function get_form_data() {
    var data = {};
    var accountModal = $('#accountModal');
    // 获取表单内容
    data.opt_type = accountModal.find('.modal-body #opt_type').val();
    data.id = accountModal.find('.modal-body #id').val();
    data.username = accountModal.find('.modal-body #username').val();
    data.password = accountModal.find('.modal-body #password').val();
    if ("edit" == data.opt_type) {
        data.change_flag = true;
    } else {
        data.change_flag = false;
    }
    return data;
}
// 新增或编辑项目
function optData() {
    // 获取数据
    var data = get_form_data();
    //var change_flag = data.change_flag;
    opt_account(data);
}
function opt_account(data) {
    var change_flag = data.change_flag;
    var req_type;
    var id = $('#id').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var enabled = $('#enabled').val();
    var data;
    if (change_flag){
        req_type="put";
        data = {
            id:id,
            username:username,
            password:password,
            enabled:enabled
        };
    } else {
        req_type="post";
        data = {
            username:username,
            password:password,
            enabled:enabled
        };
    }
    // ajax新增项目数据
    $.ajax({
        url: encodeURI("/api/account"),
        type: req_type,
        contentType:"application/json; charset=utf-8",
        dataType: 'json',
        cache: false,
        async: true,
        //beforeSend: function(request) {
        //    request.setRequestHeader("Authorization", "Bearer xxxxxxxxxx");
        //},
        data: JSON.stringify(data),
        success: function (ret) {
            // 新增成功
            if (ret.code == 201 || ret.code == 200) {
                // 隐藏modal框
                $('#accountModal').modal('hide');
                $('#account_table').bootstrapTable('refresh');
                swal({
                    position: 'top-end',
                    type: 'success',
                    title: 'Your work has been saved',
                    showConfirmButton: false,
                    timer: 1500
                })
                //resetData();
            } else {
                swal({
                    position: 'top-end',
                    type: 'error',
                    title: 'Your work has not been saved',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            switch(XMLHttpRequest.status){
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        }
    })
}
// 根据id删除
function delete_Data(id) {
    // 获取数据
    //var data = {};
    //data.id = id;
    // ajax删除数据
    $.ajax({
        url: "/api/account/"+id,
        type: 'delete',
        dataType: 'json',
        success: function (ret) {
            if (ret.code != "200") {
                swal("Delete Failed!")
            } else {
                $('#account_table').bootstrapTable('refresh');
                swal("Deleted!", "Your imaginary file has been deleted.", "success");
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            switch(XMLHttpRequest.status){
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        }
    })
}
function delDatabatch() {
    var $table = $('#account_table')
    alert('getSelections: ' + JSON.stringify($table.bootstrapTable('getSelections')));
}
function updDatabatch() {
    var $table = $('#account_table')
    //alert('getSelections: ' + JSON.stringify($table.bootstrapTable('getSelections')));

    if ($table.bootstrapTable('getSelections').length == 0){
        alert("you must select one row...")
    } else {
        var data =  $table.bootstrapTable('getSelections');
        $.ajax({
            url: "/api/accountbatch",
            type: 'put',
            contentType:"application/json; charset=utf-8",
            dataType: 'json',
            cache: false,
            async: true,
            //beforeSend: function(request) {
            //    request.setRequestHeader("Authorization", "Bearer xxxxxxxxxx");
            //},
            data: JSON.stringify(data),
            success: function (ret) {
                if (ret.code != "200") {
                    swal("Update Failed!")
                } else {
                    $('#account_table').bootstrapTable('refresh');
                    swal("Updated!", "Your imaginary file has been updated.", "success");
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                switch(XMLHttpRequest.status){
                    case 401:
                        break;
                    case 404:
                        break;
                    case 500:
                        break;
                }
            }
        })
    }
}
//
function relData(row) {
    //$('#modalTitle').text('用户角色关系');
    //var accountroleModal = $('#accountroleModal');

    //accountroleModal.modal('show');
    console.log(111111111111111111)
    console.log(row.id);
    $.ajax({
        url: "/api/accountrole/"+row.id,
        type: 'get',
        contentType:"application/json; charset=utf-8",
        dataType: 'json',
        cache: false,
        async: true,
        //beforeSend: function(request) {
        //    request.setRequestHeader("Authorization", "Bearer xxxxxxxxxx");
        //},
        //data: JSON.stringify(data),
        success: function (ret) {
            console.log(ret.data)
            if (ret.code ==200){
                //$("#accountrel").append(ret.data[0]);
                alert(ret.data)
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            switch(XMLHttpRequest.status){
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        }
    })
    //iframe层-多媒体

    //iframe层-父子操作
    /*
    console.log(1111111111111111111)
    console.log(row.id)
    layer.open({
        type: 2,
        title:'用户角色信息',
        area: ['700px', '450px'],
        fixed: false, //不固定
        maxmin: true,
        content: 'accountrole'
    });
    */
}


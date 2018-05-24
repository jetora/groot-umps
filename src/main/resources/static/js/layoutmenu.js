$(document).ready(function() {
    $.ajax({
        url : '/api/menutree',
        method : 'get',
        cache: false,
        async: true,
        dataType : 'json',
        success : function(ret) {
            if (ret.code == 200) {
                var result = $('<ul class="nav side-menu"></ul>')
                showall(ret.data[0].children,result);

                $("#side-menu").append(result);
                $('#side-menu').metisMenu();
                f()
            }
        },
        error:function(ret){
            var item='';
            item="<span style='color:red;'>无数据，请联系管理员！！！</span>"
            var root = $('.sidebar-menu');
            root.append(item);
            $('#side-menu').metisMenu();
        }
    })
})

function f() {
    $("div#side-menu [data-url]").each(function () {
        $(this).on('click', function(event){
            event.preventDefault();
            var $this = $(this);
            var url = $this.attr('data-url');
            if (typeof url !== "undefined") {
                if (url != '#') {
                    console.log(url);
                }
            }
        });
    })
}
//menu_list为json数据
//parent为要组合成html的容器
function showall(menu_list, parent) {
    for (var menu in menu_list) {
        //如果有子节点，则遍历该子节点
        if (menu_list[menu].children.length > 0) {
            //创建一个子节点li
            var li = $("<li></li>");
            //将li的文本设置好，并马上添加一个空白的ul子节点，并且将这个li添加到父亲节点中
            $(li).append('<a href="javascript:void(0);" data-url="'+menu_list[menu].data_url+'" data-target="'+menu_list[menu].data_target+'"><i class="fa fa-home"></i>'+menu_list[menu].name+'<span class="fa arrow"></span></a>').append('<ul class="nav side-menu"></ul>').appendTo(parent);
            //将空白的ul作为下一个递归遍历的父亲节点传)
            showall(menu_list[menu].children, $(li).children().eq(1));
        }
        //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
        else {
            $("<li></li>").append('<a href="javascript:void(0);" data-url="'+menu_list[menu].data_url+'" data-target="'+menu_list[menu].data_target+'">'+menu_list[menu].name+'</a>').appendTo(parent);
        }
    }
}
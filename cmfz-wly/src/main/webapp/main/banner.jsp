<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body class="easyui-layout">
<script type="text/javascript">
    $(function () {
        $("#banner").edatagrid({
            fit: true,
            fitColumns: true,
            url: "${pageContext.request.contextPath}/banner/queryAll",
            updateUrl:"${pageContext.request.contextPath}/banner/updateById",
            pagination: true,
            pageSize: 10,
            pageList: [3, 10, 15, 20],
            columns: [[
                {field: 'id', title: '编号', width: 100},
                {field: 'name', title: '图片名称', width: 100},
                {field: 'picUrl', title: '图片路径', width: 100},
                {
                    field: 'description', title: '描述', width: 100,
                    editor: {type: 'textbox', options: {required: true}}
                },
                {
                    field: 'status', title: '状态', width: 100,
                    editor: {type: 'textbox', options: {required: true}}
                },
                {field: 'createTime', title: '创建时间', width: 100},
                {field: 'url', title: '点击图片访问路径', width: 100},

            ]],
            toolbar: [
                {
                    iconCls: "icon-add",
                    text: "添加",
                    handler: function () {
                        //初始化dialog
                        $("#dg").dialog({
                            title: "添加轮播图",
                            iconCls: "icon-add",
                            width: 500,
                            buttons: [
                                {
                                    iconCls: "icon-add",
                                    text: "提交",
                                    handler: function () {
                                        //提交表单
                                        $("#form").submit();
                                    }
                                },
                                {
                                    iconCls: "icon-add",
                                    text: "取消",
                                    handler: function () {
                                        //关闭当前dialog
                                        $("#dg").dialog("close");
                                    }
                                }
                            ]
                        });

                        //初始化form表单
                        $("#form").form({
                            url: "${pageContext.request.contextPath}/banner/addBanner",
                            onSubmit: function () {
                                var vi = $("#form").form("validate");
                                return vi;
                            },
                            success: function () {
                                //添加成功之后,关闭窗口,刷新表格
                                $("#dg").dialog("close");
                                $("#banner").edatagrid("reload");
                            }
                        });
                    }
                },
                {
                    text: "修改",
                    iconCls: "icon-add",
                    handler: function () {
                        //获得当前选中行
                        var a = $("#banner").edatagrid("getSelected");
                        //console.log(a)
                        if(a == null){
                            alert("请选择一行数据");
                        }else{
                            //根据行获取下标
                            var index = $("#banner").edatagrid("getRowIndex",a);
                            //根据下标使该行变成可编辑状态
                            $("#banner").edatagrid("editRow",index);
                        }
                    }
                },

                {
                    text:"保存",
                    iconCls:"icon-add",
                    handler:function () {
                        //保存修改的字段
                        $("#banner").edatagrid("saveRow");
                    }
                },
                {
                    text:"删除",
                    iconCls:"icon-add",
                    handler:function(){
                        //获得当前选中行
                        var a = $("#banner").edatagrid("getSelected");
                        if(a == null){
                            alert("请选择一行数据");
                        }else{
                            $.ajax({
                                url:"${pageContext.request.contextPath}/banner/deleteById?id="+a.id,
                                type:"post",
                                success:function () {
                                    //重新加载
                                    $("#banner").edatagrid("reload");
                                }
                            })
                        }
                    }
                }
            ],
            view: detailview,              //表格展示方式
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.picUrl + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.attr1 + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    });
</script>
<table id="banner"></table>
<div id="dg">
    <form id="form" enctype="multipart/form-data" method="post">
        <table style="width: 480px">
            <tr>
                <td class="td1">轮播图名称</td>
                <td><input type="text" id="name" name="name" class="easyui-textbox" data-options="required:true"></td>
            </tr>
            <tr>
                <td class="td1">图片路径</td>
                <td><input id="upload" name="upload" class="easyui-filebox" data-options="required:true"></td>
            </tr>
            <tr>
                <td class="td1">状态</td>
                <td><input type="text" id="status" name="status" class="easyui-textbox" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td class="td1">跳转路径</td>
                <td><input type="text" id="url" name="url" class="easyui-textbox" data-options="required:true"></td>
            </tr>
            <tr>
                <td class="td1">描述</td>
                <td><input type="text" id="description" name="description" class="easyui-textbox"
                           data-options="required:true"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
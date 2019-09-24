<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>教师Excel导入</title>

    <script type="text/javascript" src="../static/asserts/js/jquery-easyui-1.4.3/jquery.min.js"></script>
    <script type="text/javascript" src="../static/asserts/js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="../static/asserts/js/jquery-easyui-1.4.3/themes/icon.css" >
    <link rel="stylesheet" href="../static/asserts/js/jquery-easyui-1.4.3/themes/default/easyui.css" >
    <script type="text/javascript" src="../static/asserts/js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>


    <div id="tb">
        <form enctype="multipart/form-data" method="post" action="/excel/uploadTea">
            选择Excel表格：<input type="file" name="file" /><br /> <input type="submit"
                                                                     value="上传" />

        </form>

        <form enctype="multipart/form-data" method="post" action="/excel/teadownload">
            <input type="submit" value="导出" />
        </form>

    </div>

    <table id="dg" class="easyui-datagrid" style="width:400px;height:250px"
           data-options="url:'/techer/queryTeacherFy',fitColumns:true,fit:true,pagination:true,toolbar:'#tb'">
        <thead>
        <tr>
            <th field="ck" checkbox='true' ></th>
            <th data-options="field:'id',width:100">id</th>
            <th data-options="field:'cardNo',width:100">卡号</th>
            <th data-options="field:'name',width:100">用户名</th>
            <th data-options="field:'sex',width:100">性别</th>
            <th data-options="field:'sectionId',width:100">身份编号</th>
            <#--<th data-options="field:'status',width:100">状态</th>-->
            <#--<th data-options="field:'remark',width:100">备注</th>-->

        <#--<th data-options="field:'aa',width:400,formatter:caozuoo">操作</th>-->

        </tr>
        </thead>
    </table>



</body>

<script>

function sousuo() {

var stuname=$("#stuname").val();

$('#dg').datagrid('load', {
name :stuname,

});
}

</script>
</html>
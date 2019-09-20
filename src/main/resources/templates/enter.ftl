<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/metro-blue/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<head>
    <title>刷卡系统</title>
</head>
<body>
<center>
    <div class="easyui-panel" title="欢迎进入${computer.readroomid.name}"
         style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff">
            <div style="margin-bottom:20px">
                <select class="easyui-combobox" name="role" label="角色" style="width:100%">
                    <option value="">----------请选择----------</option>
                    <option value="Students">学生</option>
                    <option value="Teachers">老师</option>
                </select>
            </div>
            <div style="margin-bottom:30px">
                <input class="easyui-textbox" name="" id="cardNO" style="width:100%"
                       data-options="label:'输入卡号:',required:true">
            </div>
        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">确定</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">重置</a>
        </div>
    </div>
    <script>
        function submitForm() {
            var cardNO = $('#cardNO').val();
            var role = $("select").combobox('getValue');
            if (cardNO === '') {
                alert("请输入卡号！");
            }else if(role===''){
                alert("请选择角色！");
            }else {
                $.post('addEnterData', {
                    cardNO: cardNO,
                    readroomid:${computer.readroomid.id},
                    role:role
                }, function (data) {
                    alert(data.msg);
                })
            }
        }

        function clearForm() {
            $('#ff').form('clear');
        }
    </script>
</center>
</body>
</html>
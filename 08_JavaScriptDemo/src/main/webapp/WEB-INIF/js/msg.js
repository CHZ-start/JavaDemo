$(function () {
    //绑定发送按钮
    $(".sendbutton").click(function () {
        //获取文本内容
        var textarea = $("#textarea").val();
        //判断文本是否有内容
        if(textarea != null && textarea !== "" && textarea !== " ") {
            //创建p元素 文本内容
            var p_text = $("<p>");
            //创建p元素 当前时间
            var p_time = $("<p>");
            //获取当前时间
            var now_day = new Date().toLocaleDateString()
            var now_time = new Date().toLocaleTimeString();
            var day_time = now_day + " " + now_time;
            //将文本填入标签中
            p_text.html(textarea);
            p_time.html(day_time);
            //设置文本属性
            p_text.attr("id","sendmsg");
            p_time.attr("id","sendtime");
            //将元素添加到父节点中
            $("#content").append(p_time);
            $("#content").append(p_text);
            $("#textarea").val("");
        }else {
            alert("请输入内容");
        }
        //滚动条自动滑动到最底部
        var scrollHeight = $("#content").prop("scrollHeight");
        $("#content").scrollTop(scrollHeight,200);
    });

})
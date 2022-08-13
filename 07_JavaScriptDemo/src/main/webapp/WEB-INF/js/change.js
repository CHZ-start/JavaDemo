window.onload = function () {
    var l1 = document.getElementById("l1");
    var l2 = document.getElementById("l2");
    var l3 = document.getElementById("l3");
    l1.onclick = function () {
        var msg = document.getElementsByClassName("msg");
        msg[0].innerHTML = "个人推荐";
    }
    l2.onclick = function () {
        var msg = document.getElementsByClassName("msg");
        msg[0].innerHTML = "猜你喜欢";
    }
    l3.onclick = function () {
        var msg = document.getElementsByClassName("msg");
        msg[0].innerHTML = "我的收藏";
    }
}
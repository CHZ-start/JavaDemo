window.onload=function(){
    var btn = document.querySelector("button");
    var txt = document.querySelector("input");
    btn.onclick = function () {
        var val = txt.value;
        $.ajax({
            type: "POST",
            url: 'http://wthrcdn.etouch.cn/WeatherApi?city=' + val,
            dataType: 'xml',
            success: function (msg) {
                //console.log(msg);
                var resp = msg.querySelector('resp');
                var city = resp.querySelector('city').innerHTML;
                document.querySelector(".city").innerHTML = '查询的城市是：' + city;
                var updatetime = resp.querySelector('updatetime').innerHTML;
                document.querySelector(".updatetime").innerHTML = '更新的时间是：' + updatetime;
                var wendu = resp.querySelector('wendu').innerHTML;
                document.querySelector('.wendu').innerHTML = '现在的温度是：' + wendu + '度';
                var yesterday = resp.querySelector('yesterday');
                var high = yesterday.querySelector('high_1').innerHTML;
                document.querySelector('.high').innerHTML = '最' + high;
                var low = yesterday.querySelector('low_1').innerHTML;
                document.querySelector('.low').innerHTML = '最' + low;
            }
        });
    }
};
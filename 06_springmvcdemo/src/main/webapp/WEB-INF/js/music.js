window.onload=function(){//页面加载函数，html页面内容完了之后再执行js代码
    var lis=document.getElementsByTagName("li");//获得li元素数组lis
    /* console.log(lis); */
    var dao=document.getElementById("dao");//获取audio元素
    var con=document.getElementById("con");//获取页脚span元素

    /* 声明一个数组arr用于存放音乐的路径 */
    var arr=['../audio/不必在乎我是谁.mp3','../audio/凉凉.mp3','../audio/倾城.mp3','../audio/天意.mp3','../audio/为你我受冷风吹.mp3','../audio/一剪梅.mp3'];

    /* 使用循环实现相应的功能 */
    for(var i=0;i<lis.length;i++){
        lis[i].onclick=function(){//给每一li绑定一个点击事件
            for(var i=0;i<lis.length;i++){
                if(this==lis[i]){
                    lis[i].className="bg";//当点击到但当前音乐时,给当前音乐的背景色设置为bg（pink）
                    dao.src=arr[i];//当前的音乐路径赋值给audio的src。（实现动态赋值）
                    dao.play();//调用play（）方法播放音乐
                    con.innerHTML=lis[i].innerHTML;//把当前播放的音乐添加到页脚部分

                    /* 实现音乐播放完成后自动切换 */
                    var a=i;
                    dao.onended=function(){
                        a++;
                        if(a>lis.length-1){
                            a=0;
                        }
                        /* 当不播放该首音乐时，背景色还原 */
                        for(var j=0;j<lis.length;j++){
                            lis[j].className="";
                        }
                        dao.src=arr[a];
                        dao.play();
                        lis[a].className="bg";
                        con.innerHTML=lis[a].innerHTML;
                    }
                }else{
                    lis[i].className="";
                }
            }
        }
    }
}
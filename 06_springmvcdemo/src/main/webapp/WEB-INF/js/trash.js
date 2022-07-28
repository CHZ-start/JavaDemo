window.onload=function(){
    var lis=document.getElementsByTagName("li");//获取li元素存放在lis数组里面
    var oText=document.getElementById("text");
    var oDiv=document.getElementById("out");
    var targetLi=null;
    var img=document.createElement("img");
    img.src="../img/dele.png";
    /* 拖拽功能 */
    for(var i=0;i<lis.length;i++){
        lis[i].ondragstart=function(ev){
            this.style.background="blue";
            targetLi=this;
            ev.dataTransfer.setData("Text",this.innerHTML);
            ev.dataTransfer.setDragImage(img,20,20);
        }
        lis[i].ondragend=function(){//li失去背景色
            this.style.background="";
        }
    }
    oDiv.ondragover=function(ev){//阻止默认事件（必须要写）
        ev.preventDefault();
    }

    oDiv.ondrop=function(ev){//拖动到垃圾箱删除并显示删除的是什么垃圾
        var text=ev.dataTransfer.getData("Text");
        console.log(text);
        oText.innerHTML="删除的是："+text;
        targetLi.parentNode.removeChild(targetLi);
    }
}
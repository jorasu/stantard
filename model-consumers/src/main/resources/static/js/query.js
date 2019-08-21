/**
 * Created by jora on 2019/6/18.
 */
$(function () {
    loadAjax(1);
    var url=location.search;
    var reg=/\d+$/;
    var id=url.match(reg)[0];
    $.post("queryById.do", { "id": id },
        function(data){
          $("#id").val(data.id);
          $("#stdnum").val(data.stdNum);
          $("#zhname").val(data.zhName);
          $("#version").val(data.version);
          $("#keys").val(data.keys);
          $("#releasedate").val(data.releaseDate);
          $("#impldate").val(data.implDate);
        }, "json");
})

function loadAjax(pNo) {
    var title=$("#title").val();
    $.post("query.do", { "title": title,"pNo":pNo },
        function(data){
            var info="";
            $(".tr").remove();
            $(data.list).each(function () {
                info+=`
                   <tr class="tr">
                 <td>${this.stdNum}</td>
                 <td>${this.zhName}</td>
                 <td>${this.version}</td>
                 <td>${this.releaseDate}</td>
                 <td>${this.implDate}</td>
                 <td>
                 <a href="javascript:;" onclick="del(${this.id})">删除</a>
                 <a href="javascript:;" onclick="update(${this.id})">修改</a>          
                 </td>
             </tr>
                `;
            })

            $("table").append(info);
            var pageInfo=`   <a href="javascript:;" onclick="pageLoad(1)">首页</a>
           <a href="javascript:;" onclick="pageLoad(${data.prePage})">上一页</a>
           <a href="javascript:;" onclick="pageLoad(${data.nextPage})">下一页</a>
           <a href="javascript:;" onclick="pageLoad(${data.pages})">尾页</a>
           第<span>${data.pageNum}</span>页/共<span>${data.pages}</span>页`;
            $("#page").html(pageInfo);
        }, "json");
}

function searcthBtn() {
    loadAjax(1);
}
function pageLoad(pNo) {
    if(pNo=='0'){
        alert("不能翻页");
        return;
    }else {
        loadAjax(pNo);
    }
}

function del(id) {
    if(confirm("确定要删除么？")){
        $.post("del.do", { "id": id },
            function(data){
              window.location="query.html";
            });
    }}

function update(id) {
  window.location="update.html?id="+id;
}

function save() {
    $.post("update.do",$("#updateForm").serialize(),
        function(data){
         window.location="query.html";
        });
}

function addBtn() {
    window.location="add.html";
}

function addBtn1() {
    var stdnum=$("#stdnum").val();
    var releasedate=$("#releasedate").val();
    if(stdnum==""){
        alert("标准号不能为空");
    }else{
        $.post("add.do", $("#addForm").serialize(),
            function(data){
                alert(data);
                window.location="query.html";
            });
    }

}

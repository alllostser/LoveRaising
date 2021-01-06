layui.use(['context'],function(){
    const context = layui.context;
    context.put("hostUrl","http://localhost:8080")
    if (sessionStorage.getItem("token")==null){
        parent.window.location='../../login.html'
    }

})




<%@include file="header.jsp" %>
<h2>Welcome to my online shop home page</h2><br>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">BaiDu</option>
        <option value="jingdong">JingDong</option>
        <option value="taobao">TaoBao</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include file="footer.jsp" %>
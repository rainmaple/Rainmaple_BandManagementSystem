<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!--头部-->

<!--头部-->
	<header class="am-topbar am-topbar-inverse am-topbar-fixed-top">
  <div class="am-container">
    <h1 class="am-topbar-brand">
      <a href="#" class="am-text-ir">SuperSuperHandSome</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-xs  am-show-xs-only"
            data-am-collapse="{target: '#doc-topbar-collapse-4'}"><span class="am-sr-only">导航切换</span> <span
        class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse-4">
      <ul class="am-nav am-nav-pills am-topbar-nav ">
      
        <li  class="am-active"><a href="index.jsp">首页</a></li>
		<li><a href="about.jsp">整体简介</a></li>
		<li><a href="bandsFrontList.jsp">旗下乐队</a></li>
		<li><a href="content.jsp">粉丝团专区</a></li>
		<li class="last"><a href="contact.jsp">联系我们</a></li>
      </ul>
    </div>
  </div>
</header>
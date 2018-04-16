function tabs(tabTit,on,tabCon){
	$(tabCon).each(function(){
	  $(this).children().eq(0).show();
	  });
	$(tabTit).each(function(){
	  $(this).children().eq(0).addClass(on);
	  });
     $(tabTit).children().click(function(){
        $(this).addClass(on).siblings().removeClass(on);
         var index = $(tabTit).children().index(this);
         $(tabCon).children().eq(index).show().siblings().hide();
    });
}

function changeValue(ele){
	//alert(ele.innerHTML);
	document.getElementById("a").innerHTML = ele.innerHTML;
	document.getElementById("b").innerHTML = ele.innerHTML;
}

function initCheck(){
	document.getElementById("asd").click();
}

 $(document).ready(function(){
    /** 通过点击展开左边栏 **/
    $(".side-icon").click(function(){
      if($(".map-left").css("left") == "0px")
      {
        $(".map-left").animate({left:"-320px"});
		$(this).children().attr("class","fa fa-chevron-right")
      }
      else
      {
        $(".map-left").animate({left:"0px"});
		$(this).children().attr("class","fa fa-chevron-left")
      }
    });
  });

	
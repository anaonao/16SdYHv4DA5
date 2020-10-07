$(function() {
		//全选功能
		$(".ckAll").click(function() {
			//获取复选框状态
			var ckAll = $(this).prop("checked");
			// alert(ckAll)
			// 调整所有复选框状态
			$(".ck").prop("checked", ckAll)
			zj();
			zjj();
		})
		//商品是否全选调整
		$(".ck").click(function() {
			var flag = true;
			$(".ck").each(function() {
				if ($(this).prop("checked") == false) {
					flag = false;
				}
			})
			$(".ckAll").prop("checked", flag);
			zj();
			zjj();
		})
		
		//购物车加减
		$(".bt1").click(function() {
			var jian = $(this).next().val();
			// alert(jian)
			if (jian > 1) {
				jian--;
			}
			$(this).next().val(jian);
		
			//价格
			var price = $(this).parent().prev().text();
			//小计
			$(this).parent().next().text(price * jian);
			zj();
			zjj();
		})
		
		//购物车加减
		$(".bt2").click(function() {
			var jia = $(this).prev().val();
			// alert(jian)
			jia++;
			$(this).prev().val(jia);
		
			//价格
			var price = $(this).parent().prev().text();
			//小计
			$(this).parent().next().text(price * jia);
			zj();
			zjj();
		})

	function commisnull() {
		// alert($(".card-main").length)
		if ($(".card-main").length == 1) {
			$("#commisnull .card-main-1").removeClass("hidden");
		}
	}
		//页面加载就判断当前商品是否为空
		commisnull();
		xj();
		//单价
		function xj(){
			$(".price").each(function(){
				// $("xj").text()
				var price = ($(this).parents(".card-main-1").children(".price").text())
				var num =($(this).parents(".card-main-1").children(".aaa").children(".txt").val())
				$(this).parents(".card-main-1").children(".xj").text(price*num)
			})
		}
		
		
		//总计
		function zj(){
			var sum=0;
			$(".ck").each(function(){
				if($(this).prop("checked")){
					var p =$(this).parents(".card-main-1").children(".xj").text();
					sum+=parseInt(p);
				}
			})
			$(".zj").text(sum);
		}
		
		//件数
		  function zjj(){
			var sum=0;
			$(".ck").each(function(){
				if($(this).prop("checked")){
					var p =($(this).parents(".card-main-1").children(".aaa").children(".txt").val())
					sum+=parseInt(p);
				}
			})
			$(".sum").text(sum);
		}
})

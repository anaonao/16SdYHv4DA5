$(function() {
	//全选功能
	$(".ckAll").click(function() {
		$(".ck").prop("checked", $(".ckAll").prop("checked"));
		sum();
	})

	//单选状态影响全选状态
	$(".ck").click(function() {
		//遍历类中的每一项
		$(".ck").each(function() {
			//如果有一项为false
//			alert($(this).prop("checked"))
			if($(this).prop("checked") == false) {
				//全选也为false
				$(".ckAll").prop("checked", false);
			}
		})
		sum();
	})

	//加减的事件
	//加
	$(".add").click(function() {
		//取文本框的值
		var num = $(this).prev().val();
		//num自增
		num++;
		//把增加以后的数给了文本框
		$(this).prev().val(num);
		//取文本的值
		var pri = $(this).parent().prev().text();
		$(this).parent().next().text(pri * num);
		sum();
	})
	//减
	$(".sub").click(function() {
		var num = $(this).next().val();
		num--;
		if(num < 1) {
			num = 1;
		}
		$(this).next().val(num);
		var pri = $(this).parent().prev().text();
		$(this).parent().next().text(pri * num);
		sum();
	})

	//删除
	$("#cartBody a").click(function() {
		if(confirm("确定要删除吗？")) {
			$(this).parents(".row").remove();
			kong();
		}
		sum();
	})

	//批量删除
	$("#cartFoot a").click(function() {
		if(confirm("确定要删除吗？")) {
			$(".ck").each(function() {
				if($(this).prop("checked") == true) {
					$(this).parents(".row").remove();
					kong();
				}
			})
		}
		sum();
	})

	//判断空
	function kong() {
		//如果cartBody里边的所有商品都被删除完了，快去买东西的页面就出来了
		if($("#cartBody .row").length == 0) {
			$("#kong").removeClass("hidden");
			$(".ckAll").hide();
		}
	}

	//计算总价
	function sum() {
		var summary = 0;
		$(".ck").each(function() {
			if($(this).prop("checked") == true) {
				var p = $(this).parents(".row").children(".sSum").text();
				summary += parseInt(p);
			}
		})
		$("#cartFoot span").text(summary);
	}
})
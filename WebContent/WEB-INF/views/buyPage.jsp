<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>


<style>
div.buyPageDiv {
	margin: 20px auto;
	max-width: 1013px;
}

div.buyPageDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

div.buyDiv button {
	display: inline-block;
	margin: 0px 10px;
	width: 180px;
	height: 40px;
}

div.address {
	margin: 20px 5px;
	text-align: left;
}

div.addressTip, div.productListTip {
	color: #333333;
	font-size: 16px;
	font-weight: bold;
	text-align: left;
	margin-bottom: 30px;
}

table.addressTable {
	margin: 20px 20px;
	width: 600px;
}

table.addressTable td.firstColumn {
	width: 100px;
}

table.addressTable td {
	color: #333333;
	text-align: right;
	vertical-align: top;
	padding-right: 5px;
	text-align: left;
	height: 30px;
	font-size: 12px;
}

span.redStar {
	color: red;
	font-size: 8px;
}

table.addressTable td input {
	border: 1px solid #AFAFAF;
	width: 200px;
}

table.addressTable td textarea {
	border: 1px solid #AFAFAF;
	margin-bottom: 10px;
	width: 400px;
}

img.tmallbuy {
	width: 15px;
}

a.marketLink {
	color: black;
	font-size: 12px;
	font-weight: normal;
}

a.marketLink:hover {
	color: black;
	font-size: 12px;
	text-decoration: underline;
	font-weight: normal;
}

span.wangwangGif {
	display: inline-block;
	width: 25px;
	height: 25px;
	background-image: url(../../img/fore/wangwang.gif);
	background-repeat: no-repeat;
	background-color: transparent;
	background-attachment: scroll;
	background-position: -83px -0px;
	position: relative;
	top: 8px;
	left: 2px;
}

table.productListTable {
	width: 100%;
	border-collapse: separate;
}

table.productListTable th {
	color: #999999;
	font-weight: normal;
	font-size: 12px;
	text-align: center;
	padding-bottom: 5px;
}

th.productListTableFirstColumn {
	text-align: left !important;
}

table.productListTable tr.rowborder td {
	background-color: #b2d1ff;
	border-right: 2px solid #fff;
	height: 3px;
}

img.orderItemImg {
	width: 50px;
	height: 50px;
	border: 1px solid #E9E9E9;
}

tr.orderItemTR td {
	padding: 10px 0px;
}

a.orderItemProductLink {
	color: #666666;
	display: block;
}

a.orderItemProductLink:hover {
	color: #666666;
	text-decoration: underline;
}

td.orderItemProductInfo {
	text-align: left;
}

td.orderItemProductInfo img {
	height: 16px;
}

span.orderItemProductNumber {
	color: #000000;
}

tr.orderItemTR td {
	border-bottom: 1px solid #E5E5E5;
}

tbody.productListTableTbody td {
	text-align: center;
	font-size: 12px;
}

tbody.productListTableTbody td.orderItemFirstTD {
	text-align: left;
}

tbody.productListTableTbody td.orderItemProductInfo {
	text-align: left;
}

td.orderItemFirstTD, td.orderItemLastTD {
	border-bottom: 0px solid black !important;
}

label.orderItemDeliveryLabel {
	color: #666666;
	font-size: 12px;
	font-weight: normal;
}

div.orderItemSumDiv span {
	color: #999999;
}

div.orderItemSumDiv {
	padding: 20px;
	border-top: 2px solid #B4D0FF;
	background-color: #F2F6FF;
	height: 50px;
}

textarea.leaveMessageTextarea {
	border: 1px solid #FFAD35;
	width: 250px;
	height: 60px;
	resize: none;
}

span.leaveMessageText {
	display: inilne-block;
	margin-right: 10px;
	float: left;
}

span.leaveMessageTextareaSpan {
	display: inilne-block;
}

div.orderItemTotalSumDiv {
	margin: 40px;
	height: 40px;
}

div.orderItemTotalSumDiv span {
	color: #999999;
}

span.orderItemTotalSumSpan {
	color: #C40000 !important;
	font-size: 22px;
	font-weight: bold;
	border-bottom: 1px dotted #F2F6FF;
}

div.submitOrderDiv {
	height: 40px;
	margin: 20px 0px;
}

button.submitOrderButton {
	border: 1px solid #C40000;
	background-color: #C40000;
	text-align: center;
	line-height: 40px;
	font-size: 14px;
	font-weight: 700;
	color: white;
	float: right;
}
</style>

<script>
	$(function() {
		$("a.productDetailTopReviewLink").click(function() {
			$("div.productReviewDiv").show();
			$("div.productDetailDiv").hide();
		});
		$("a.productReviewTopPartSelectedLink").click(function() {
			$("div.productReviewDiv").hide();
			$("div.productDetailDiv").show();
		});

		$("span.leaveMessageTextareaSpan").hide();
		$("img.leaveMessageImg").click(function() {

			$(this).hide();
			$("span.leaveMessageTextareaSpan").show();
			$("div.orderItemSumDiv").css("height", "100px");
		});

		$("div#footer a[href$=#nowhere]").click(function() {
			alert("模仿天猫的连接，并没有跳转到实际的页面");
		});

		$("a.wangwanglink").click(function() {
			alert("模仿旺旺的图标，并不会打开旺旺");
		});
		$("a.notImplementLink").click(function() {
			alert("这个功能没做，蛤蛤~");
		});
	});
</script>
<div class="buyPageDiv">
	<form action="${ctx }/common/order/createOrder.action" method="post">

		<div class="buyFlow">
			<img class="pull-left" src="${ctx}/img/fore/simpleLogo.png"> <img
				class="pull-right" src="${ctx}/img/fore/buyflow.png">
			<div style="clear: both"></div>
		</div>
		<div class="address">
			<div class="addressTip">输入收货地址</div>
			<div>

				<table class="addressTable">
					<tr>
						<td class="firstColumn">详细地址<span class="redStar">*</span></td>

						<td><textarea name="address"
								style="margin: 0px 0px 10px; width: 378px; height: 99px;"
								placeholder="建议您如实填写详细收货地址，例如接到名称，门牌号码，楼层和房间号等信息"></textarea></td>
					</tr>
					<tr>
						<td>邮政编码</td>
						<td><input name="postalcode"
							placeholder="如果您不清楚邮递区号,请填写000000" type="text"></td>
					</tr>
					<tr>
						<td>收货人姓名<span class="redStar">*</span></td>
						<td><input name="userName" placeholder="长度不超过25个字符"
							type="text"></td>
					</tr>
					<tr>
						<td>手机号码 <span class="redStar">*</span></td>
						<td><input name="phone" placeholder="请输入11位手机号码" type="text"></td>
					</tr>
				</table>

			</div>

		</div>
		<div class="productList">
			<div class="productListTip">确认订单信息</div>
			<h3 style="color: red;">${msg }</h3>
			<table class="productListTable">
				<thead>
					<tr>
						<th colspan="2" class="productListTableFirstColumn"><img
							class="tmallbuy" src="${ctx}/img/fore/tmallbuy.png"> <a
							class="marketLink" href="#nowhere">店铺：天猫店铺</a> <a
							class="wangwanglink" href="#nowhere"> <span
								class="wangwangGif"></span></a></th>
						<th>单价</th>
						<th>数量</th>
						<th>小计</th>
						<th>配送方式</th>
					</tr>
					<tr class="rowborder">
						<td colspan="2"></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<tbody class="productListTableTbody">

					<c:if test="${!empty item }">
						<tr class="orderItemTR">
							<td class="orderItemFirstTD"><img class="orderItemImg"
								src="${ctx}${item.productTypeImagePath }"></td>
							<td class="orderItemProductInfo"><a
								href="${ctx }/product/${item.productTypeId}.action"
								class="orderItemProductLink"> ${item.productTypeName} </a> <img
								src="${ctx}/img/fore/creditcard.png" title="支持信用卡支付"> <img
								src="${ctx}/img/fore/7day.png" title="消费者保障服务,承诺7天退货"> <img
								src="${ctx}/img/fore/promise.png" title="消费者保障服务,承诺如实描述">

							</td>
							<td>
								<%--<span class="orderItemProductPrice">￥<fmt:formatNumber type="number"--%>
								<%--value="${oi.product.price}"--%> <%--minFractionDigits="2"/></span>--%>
								<span>￥${item.salePrice}</span>
							</td>
							<td><span class="orderItemProductNumber" name="number">${number}</span>
								<input type="hidden" value="${item.productTypeId}-${number }"
								name="productTypeIdAndNumber" /></td>
							<td>
								<%--<span class="orderItemUnitSum">--%> <%--￥<fmt:formatNumber type="number" value="${oi.product.price*oi.number}"--%>
								<%--minFractionDigits="2"/>--%> <%--</span>--%> <span>￥${item.salePrice * number}</span>
							</td>
							<td rowspan="5" class="orderItemLastTD"><label
								class="orderItemDeliveryLabel"> <input type="radio"
									value="" checked="checked"> 普通配送
							</label> <select class="orderItemDeliverySelect" class="form-control">
									<option>快递 免邮费</option>
							</select></td>

						</tr>
					</c:if>

					<c:if test="${!empty items}">
						<c:forEach items="${items}" var="item" varStatus="st">
							<tr class="orderItemTR">
								<td class="orderItemFirstTD"><img class="orderItemImg"
									src="${ctx}${item.productType.productTypeImagePath }"></td>
								<td class="orderItemProductInfo"><a
									href="${ctx }/product/${item.productType.productTypeId}.action"
									class="orderItemProductLink">
										${item.productType.productTypeName} </a> <img
									src="${ctx}/img/fore/creditcard.png" title="支持信用卡支付"> <img
									src="${ctx}/img/fore/7day.png" title="消费者保障服务,承诺7天退货"> <img
									src="${ctx}/img/fore/promise.png" title="消费者保障服务,承诺如实描述">

								</td>
								<td>
									<%--<span class="orderItemProductPrice">￥<fmt:formatNumber type="number"--%>
									<%--value="${oi.product.price}"--%> <%--minFractionDigits="2"/></span>--%>
									<span>${item.productType.price}</span>
								</td>
								<td><span class="orderItemProductNumber">${item.quantity}
									<input type="hidden" value="${item.productType.productTypeId }-${item.quantity }"
									name="productTypeIdAndNumber" />
								</span>
								</td>
								<td>
									<%--<span class="orderItemUnitSum">--%> <%--￥<fmt:formatNumber type="number" value="${oi.product.price*oi.number}"--%>
									<%--minFractionDigits="2"/>--%> <%--</span>--%> <span>${item.productType.price * item.quantity}</span>
								</td>
								<c:if test="${st.index == 0 }">
									<td rowspan="5" class="orderItemLastTD"><label
										class="orderItemDeliveryLabel"> <input type="radio"
											value="" checked="checked"> 普通配送
									</label> <select class="orderItemDeliverySelect" class="form-control">
											<option>快递 免邮费</option>
									</select></td>
								</c:if>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>

			</table>
			<div class="orderItemSumDiv">
				<div class="pull-left">
					<span class="leaveMessageText">给卖家留言:</span> <span> <img
						class="leaveMessageImg" src="${ctx}/img/fore/leaveMessage.png">
					</span> <span class="leaveMessageTextareaSpan"> <textarea
							name="user_message" class="leaveMessageTextarea"></textarea>
						<div>
							<span>最多可输入200个字符</span>
						</div>
					</span>
				</div>

				<span class="pull-right">店铺合计(含运费): ￥${total}</span>
			</div>


		</div>

		<div class="orderItemTotalSumDiv">
			<div class="pull-right">
				<span>实付款：</span> <span class="orderItemTotalSumSpan">￥${total}</span>
			</div>
		</div>

		<div class="submitOrderDiv">
			<button type="submit" class="submitOrderButton">提交订单</button>
		</div>
	</form>
</div>

<%@include file="include/footer.jsp"%>
<style>
    div.buyPageDiv {
        margin: 20px auto;
        max-width: 1013px;
    }

    div.buyPageDiv button {
        display: inline-block;
        margin: 0px 10px;
        width: 180px;
        height: 40px;
    }

    div.buyDiv button {
        display: inline-block;
        margin: 0px 10px;
        width: 180px;
        height: 40px;
    }

    div.address {
        margin: 20px 5px;
        text-align: left;
    }

    div.addressTip, div.productListTip {
        color: #333333;
        font-size: 16px;
        font-weight: bold;
        text-align: left;
        margin-bottom: 30px;
    }

    table.addressTable {
        margin: 20px 20px;
        width: 600px;
    }

    table.addressTable td.firstColumn {
        width: 100px;
    }

    table.addressTable td {
        color: #333333;
        text-align: right;
        vertical-align: top;
        padding-right: 5px;
        text-align: left;
        height: 30px;
        font-size: 12px;
    }

    span.redStar {
        color: red;
        font-size: 8px;
    }

    table.addressTable td input {
        border: 1px solid #AFAFAF;
        width: 200px;
    }

    table.addressTable td textarea {
        border: 1px solid #AFAFAF;
        margin-bottom: 10px;
        width: 400px;
    }

    img.tmallbuy {
        width: 15px;
    }

    a.marketLink {
        color: black;
        font-size: 12px;
        font-weight: normal;
    }

    a.marketLink:hover {
        color: black;
        font-size: 12px;
        text-decoration: underline;
        font-weight: normal;
    }

    span.wangwangGif {
        display: inline-block;
        width: 25px;
        height: 25px;
        background-image: url(../../img/fore/wangwang.gif);
        background-repeat: no-repeat;
        background-color: transparent;
        background-attachment: scroll;
        background-position: -83px -0px;
        position: relative;
        top: 8px;
        left: 2px;
    }

    table.productListTable {
        width: 100%;
        border-collapse: separate;
    }

    table.productListTable th {
        color: #999999;
        font-weight: normal;
        font-size: 12px;
        text-align: center;
        padding-bottom: 5px;
    }

    th.productListTableFirstColumn {
        text-align: left !important;
    }

    table.productListTable tr.rowborder td {
        background-color: #b2d1ff;
        border-right: 2px solid #fff;
        height: 3px;
    }

    img.orderItemImg {
        width: 50px;
        height: 50px;
        border: 1px solid #E9E9E9;
    }

    tr.orderItemTR td {
        padding: 10px 0px;
    }

    a.orderItemProductLink {
        color: #666666;
        display: block;
    }

    a.orderItemProductLink:hover {
        color: #666666;
        text-decoration: underline;
    }

    td.orderItemProductInfo {
        text-align: left;
    }

    td.orderItemProductInfo img {
        height: 16px;
    }

    span.orderItemProductNumber {
        color: #000000;
    }

    tr.orderItemTR td {
        border-bottom: 1px solid #E5E5E5;
    }

    tbody.productListTableTbody td {
        text-align: center;
        font-size: 12px;
    }

    tbody.productListTableTbody td.orderItemFirstTD {
        text-align: left;
    }

    tbody.productListTableTbody td.orderItemProductInfo {
        text-align: left;
    }

    td.orderItemFirstTD, td.orderItemLastTD {
        border-bottom: 0px solid black !important;
    }

    label.orderItemDeliveryLabel {
        color: #666666;
        font-size: 12px;
        font-weight: normal;
    }

    div.orderItemSumDiv span {
        color: #999999;
    }

    div.orderItemSumDiv {
        padding: 20px;
        border-top: 2px solid #B4D0FF;
        background-color: #F2F6FF;
        height: 50px;
    }

    textarea.leaveMessageTextarea {
        border: 1px solid #FFAD35;
        width: 250px;
        height: 60px;
        resize: none;
    }

    span.leaveMessageText {
        display: inilne-block;
        margin-right: 10px;
        float: left;
    }

    span.leaveMessageTextareaSpan {
        display: inilne-block;
    }

    div.orderItemTotalSumDiv {
        margin: 40px;
        height: 40px;
    }

    div.orderItemTotalSumDiv span {
        color: #999999;
    }

    span.orderItemTotalSumSpan {
        color: #C40000 !important;
        font-size: 22px;
        font-weight: bold;
        border-bottom: 1px dotted #F2F6FF;
    }

    div.submitOrderDiv {
        height: 40px;
        margin: 20px 0px;
    }

    button.submitOrderButton {
        border: 1px solid #C40000;
        background-color: #C40000;
        text-align: center;
        line-height: 40px;
        font-size: 14px;
        font-weight: 700;
        color: white;
        float: right;
    }
    .address_list{
        padding: 5px;
    }
    .address_list > .address_item{
        float:left;
        padding: 10px;
        margin-right: 5px;
	    max-width: 200px;
	    border: 2px dashed gray;
	    overflow: hidden;
	    box-sizing: border-box;
	    word-wrap: break-word; 
	       
	 }
	 .address_add{
	    height: 75px;
	    width: 100px;
	    color: black;
	    line-height: 100%;
	    text-align: center;
	    font-size: 52px;
	 }
	 .address_add:hover{
	    cursor: pointer;
	 }
	 .address_item > .addressName{
	    text-overflow: ellipsis;
	    overflow: hidden;
	    white-space: nowrap;
	 }
</style>	

<script>
    $(function () {
        $("a.productDetailTopReviewLink").click(function () {
            $("div.productReviewDiv").show();
            $("div.productDetailDiv").hide();
        });
        $("a.productReviewTopPartSelectedLink").click(function () {
            $("div.productReviewDiv").hide();
            $("div.productDetailDiv").show();
        });

        $("span.leaveMessageTextareaSpan").hide();
        $("img.leaveMessageImg").click(function () {

            $(this).hide();
            $("span.leaveMessageTextareaSpan").show();
            $("div.orderItemSumDiv").css("height", "100px");
        });

        $("div#footer a[href$=#nowhere]").click(function () {
            alert("模仿天猫的连接，并没有跳转到实际的页面");
        });


        $("a.wangwanglink").click(function () {
            alert("模仿旺旺的图标，并不会打开旺旺");
        });
        $("a.notImplementLink").click(function () {
            alert("这个功能没做，蛤蛤~");
        });
        $('body').on('click',"div.address_item[data-addressid]",function(){
        	$("input[name='addressId']").val($(this).attr('data-addressid'));
        	$(this).css("border","2px dashed red");
        	$(this).siblings().css("border","2px dashed gray");
        });
        get_address();
    });
let address_list = [];
const get_address = () => {
 	let address_item = '<div class="address_item" data-addressId=\'addr_addressId\'>\
					        <div class="addressName">\
					             地址:<span name="addressName">item_name</span>\
					        </div>\
					        <div class="consignee">\
					            收货人:<span name="consignee">item_consignee</span>\
					        </div>\
					        <div class="phone">\
					            手机号:<span name="phone">item_phone</span>\
					        </div>\
					    </div>';
	const url = '${ctx}/address/list.action';
	$.get(url,{},(data)=>{
	 data = eval(data);
	 $(data).each((index,item)=>{
		 let c_item = address_item.replace(/item_name/,item.addressName);
		 c_item = c_item.replace(/item_consignee/,item.consignee);
		 c_item = c_item.replace(/item_phone/,item.phone);
		 c_item = c_item.replace(/addr_addressId/,item.addressId);
		 let ele_item;
		 if(item.addressId == 1){
			 ele_item = $(c_item).css("border","2px dashed red");
			 $("input[name='addressId']").val(item.addressId);
		 }else{
			 ele_item = $(c_item);
		 }
		 $(".address_list").prepend(ele_item);
		 address_list.push(item);
	 });
	},'json');
}
</script>
<div class="buyPageDiv">
    <form action="${ctx }/common/order/createOrder.action" method="post">

        <div class="buyFlow">
            <img class="pull-left" src="${ctx}/img/fore/simpleLogo.png">
            <img class="pull-right" src="${ctx}/img/fore/buyflow.png">
            <div style="clear:both"></div>
        </div>
        <div class="address">
            <div class="addressTip">输入收货地址</div>
            <div>
            <div class="address_list">
                    <div class="address_item address_add">
                        <span class="icon">+</span>
                    </div>
            </div>
             <input hidden name="addressId" value="" />
             
            <div style="clear:both;"></div>
               <!-- 
                <table class="addressTable">
                    <tr>
                        <td class="firstColumn">详细地址<span class="redStar">*</span></td>

                        <td><textarea name="addressName" style="margin: 0px 0px 10px; width: 378px; height: 99px;" placeholder="建议您如实填写详细收货地址，例如接到名称，门牌号码，楼层和房间号等信息"></textarea></td>
                    </tr>
                    <tr>
                        <td>收货人姓名<span class="redStar">*</span></td>
                        <td><input name="consignee" placeholder="长度不超过25个字符" type="text"></td>
                    </tr>
                    <tr>
                        <td>手机号码 <span class="redStar">*</span></td>
                        <td><input name="phone" placeholder="请输入11位手机号码" type="text"></td>
                    </tr>
                </table>
                -->

            </div>

        </div>
        <div class="productList">
            <div class="productListTip">确认订单信息</div>
            <h3 style="color:red;">${msg }</h3>
            <table class="productListTable">
                <thead>
                <tr>
                    <th colspan="2" class="productListTableFirstColumn">
                        <img class="tmallbuy" src="${ctx}/img/fore/tmallbuy.png">
                        <a class="marketLink" href="#nowhere">店铺：天猫店铺</a>
                        <a class="wangwanglink" href="#nowhere"> <span class="wangwangGif"></span></a>
                    </th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th>配送方式</th>
                </tr>
                <tr class="rowborder">
                    <td colspan="2"></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody class="productListTableTbody">
                
                <c:if test="${!empty item }">
                     <tr class="orderItemTR">
                        <td class="orderItemFirstTD"><img class="orderItemImg" src="${ctx}${item.productTypeImagePath }">
                        </td>
                        <td class="orderItemProductInfo">
                            <a href="${ctx }/product/${item.productTypeId}.action" class="orderItemProductLink">
                                    ${item.productTypeName}
                            </a>

                            <img src="${ctx}/img/fore/creditcard.png" title="支持信用卡支付">
                            <img src="${ctx}/img/fore/7day.png" title="消费者保障服务,承诺7天退货">
                            <img src="${ctx}/img/fore/promise.png" title="消费者保障服务,承诺如实描述">

                        </td>
                        <td>

                                <%--<span class="orderItemProductPrice">￥<fmt:formatNumber type="number"--%>
                                <%--value="${oi.product.price}"--%>
                                <%--minFractionDigits="2"/></span>--%>
                            <span>￥${item.salePrice}</span>
                        </td>
                        <td>
                            <span class="orderItemProductNumber" name="number">${number}</span>
                            <input hidden value="${item.productTypeId }" name="productTypeId" />
                            <input hidden value="${number }" name="number" />
                        </td>
                        <td>
                                <%--<span class="orderItemUnitSum">--%>
                                <%--￥<fmt:formatNumber type="number" value="${oi.product.price*oi.number}"--%>
                                <%--minFractionDigits="2"/>--%>
                                <%--</span>--%>
                            <span>￥${item.salePrice * number}</span>
                        </td>
                            <td rowspan="5" class="orderItemLastTD">
                                <label class="orderItemDeliveryLabel">
                                    <input type="radio" value="" checked="checked">
                                    普通配送
                                </label>

                                <select class="orderItemDeliverySelect" class="form-control">
                                    <option>快递 免邮费</option>
                                </select>

                            </td>

                    </tr>
                </c:if>
                
                <c:if test="${!empty items}">
                <c:forEach items="${items}" var="item" varStatus="st">
                   <tr class="orderItemTR">
                        <td class="orderItemFirstTD"><img class="orderItemImg" src="${ctx}/${item.productType.productTypeImagePath }">
                        </td>
                        <td class="orderItemProductInfo">
                            <a href="${ctx }/product/${item.productType.productTypeId}.action" class="orderItemProductLink">
                                    ${item.productType.productTypeName}
                            </a>

                            <img src="${ctx}/img/fore/creditcard.png" title="支持信用卡支付">
                            <img src="${ctx}/img/fore/7day.png" title="消费者保障服务,承诺7天退货">
                            <img src="${ctx}/img/fore/promise.png" title="消费者保障服务,承诺如实描述">

                        </td>
                        <td>
                            <span>${item.productType.price}</span>
                        </td>
                        <td>
                            <span class="orderItemProductNumber">${item.quantity}</span>
                        </td>
                        <td>
                                <%--<span class="orderItemUnitSum">--%>
                                <%--￥<fmt:formatNumber type="number" value="${oi.product.price*oi.number}"--%>
                                <%--minFractionDigits="2"/>--%>
                                <%--</span>--%>
                            <span>${item.productType.price * item.quantity}</span>
                        </td>
                            <td rowspan="5" class="orderItemLastTD">
                                <label class="orderItemDeliveryLabel">
                                    <input type="radio" value="" checked="checked">
                                    普通配送
                                </label>

                                <select class="orderItemDeliverySelect" class="form-control">
                                    <option>快递 免邮费</option>
                                </select>

                            </td>

                    </tr>
                </c:forEach>
                </c:if>
                
                </tbody>

            </table>
            <div class="orderItemSumDiv">
                <div class="pull-left">
                    <span class="leaveMessageText">给卖家留言:</span>
                    <span>
                        <img class="leaveMessageImg" src="${ctx}/img/fore/leaveMessage.png">
                    </span>
                    <span class="leaveMessageTextareaSpan">
					<textarea name="user_message" class="leaveMessageTextarea"></textarea>
					<div>
						<span>最多可输入200个字符</span>
					</div>
				</span>
                </div>

                <span class="pull-right">店铺合计(含运费): ￥${total}</span>
            </div>


        </div>

        <div class="orderItemTotalSumDiv">
            <div class="pull-right">
                <span>实付款：</span>
                <span class="orderItemTotalSumSpan">￥${total}</span>
            </div>
        </div>

        <div class="submitOrderDiv">
            <button type="submit" class="submitOrderButton">提交订单</button>
        </div>
    </form>
</div>

<%@include file="include/footer.jsp" %>

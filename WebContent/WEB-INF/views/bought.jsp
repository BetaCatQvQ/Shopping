<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>
<%@include file="include/mini-search.jsp"%>

<style>
table {
	border-collapse: unset;
}

div.boughtDiv {
	max-width: 1013px;
	margin: 10px auto;
}

div.orderType div {
	border-bottom: 2px solid #E8E8E8;
	float: left;
}

div.orderType a {
	border-right: 1px solid #E8E8E8;
	display: inline-block;
	font-size: 16px;
	font-weight: bold;
	color: black;
	margin-bottom: 10px;
	padding: 0px 20px;
	text-decoration: none;
}

div.orderType a:hover {
	color: #FF0036;
	text-decoration: none;
}

div.orderType div.selectedOrderType {
	border-bottom: 2px solid #FF0036;
}

div.orderType div.selectedOrderType a {
	color: #FF0036;
}

div.orderTypeLastOne {
	overflow: hidden;
	float: none !important;
	border-bottom: 2px solid #E8E8E8;
	height: 35px;
}

a.noRightborder {
	border-right-width: 0px !important;
}

table.orderListTitleTable {
	border: 1px solid #E8E8E8;
	width: 100%;
	margin: 20px 0px;
	background-color: #F5F5F5;
	text-align: center;
	font-size: 12px;
}

table.orderListTitleTable td {
	padding: 12px 0px;
}

div.boughtDiv {
	max-width: 1013px;
	margin: 10px auto;
}

table.orderListItemTable {
	border: 2px solid #ECECEC;
	width: 100%;
	margin: 20px 0px;
	font-size: 12px;
}

table.orderListItemTable:hover {
	border: 2px solid #aaa;
}

table.orderListItemTable td {
	padding: 8px 10px;
}

tr.orderListItemFirstTR {
	background-color: #F1F1F1;
}

div.orderItemWangWangGif {
	display: inline-block;
	width: 67px;
	height: 22px;
	background-image: url(img/fore/wangwang.gif);
	background-repeat: no-repeat;
	background-color: transparent;
	background-attachment: scroll;
	background-position: -0px -0px;
	position: relative;
	top: 0px;
	left: 2px;
}

td.orderItemDeleteTD {
	text-align: right;
}

span.orderListItemDelete {
	display: inline-block;
	margin: 0px 10px;
	color: #999999;
	font-size: 16px;
}

tr.orderItemProductInfoPartTR {
	vertical-align: inherit;
}

div.orderListItemProductLinkOutDiv {
	position: relative;
	height: 80px;
}

div.orderListItemProductLinkInnerDiv {
	position: absolute;
	bottom: 0px;
}

div.orderListItemProductOriginalPrice {
	color: #999999;
	font-size: 14px;
}

div.orderListItemProductPrice {
	color: #3C3C3C;
	font-size: 14px;
}

td.orderListItemNumberTD {
	text-align: center;
}

td.orderItemOrderInfoPartTD {
	border: solid 1px #ECECEC;
}

span.orderListItemNumber {
	color: #3C3C3C;
}

td.orderListItemProductRealPriceTD {
	text-align: center;
}

div.orderListItemProductRealPrice {
	color: #3C3C3C;
	font-size: 14px;
	font-weight: bold;
}

div.orderListItemPriceWithTransport {
	color: #6C6C6C;
	font-size: 12px;
}

td.orderListItemButtonTD {
	text-align: center;
}

button.orderListItemReview {
	border: 1px solid #DCDCDC;
	background-color: #fff;
	border-radius: 2px;
	color: #3C3C3C;
	font-size: 12px;
	font-weight: bold;
	padding: 6px 12px;
}

button.orderListItemReview:hover {
	border-color: #C40000;
	color: #C40000;
}

button.orderListItemConfirm {
	background-color: #66B6FF;
	border-radius: 2px;
	color: white;
	font-size: 12px;
	font-weight: bold;
	border-width: 0px;
	padding: 6px 12px;
}

button.orderListItemConfirm:hover {
	background-color: #118ADB;
}

a {
	color: #999;
}

a:hover {
	text-decoration: none;
	color: #FF0036;
}

div.productNumber {
	color: #999999;
}

.productNumberSetting[disabled] {
	opacity: 1;
	background: #fff;
}

span.productNumberSettingSpan {
	border: 1px solid #999;
	display: inline-block;
	width: 43px;
	height: 32px;
	padding-top: 7px;
	margin-left: 5px;
}

input.productNumberSetting {
	outLine: none;
	text-align: center;
	border: 0px;
	height: 80%;
	width: 100%;
}

div.productNumber span.updown img {
	display: inline-block;
	vertical-align: top;
}

div.productNumber span.updown {
	border: 1px solid #999;
	display: block;
	width: 20px;
	height: 14px;
	text-align: center;
	padding-top: 4px;
}

div.productNumber span.updownMiddle {
	height: 4px;
	display: block;
}

div.productNumber span.arrow {
	display: inline-block;
	width: 22px;
	height: 32px;
	vertical-align: top;
}
</style>
<script>
	var deleteOrder = false;
	var deleteOrderid = 0;

	$(function() {

		function change(oiid, num, price) {
			num = parseFloat(num);
			price = parseFloat(price);
			$("div[data-oiid-total=" + oiid + "]").text("￥" + (num * price));
		}

		function change_quantity(oid, oiid, num) {
			$.post("${ctx}/orderItem/change.action", {
				orderId : oid,
				orderItemId : oiid,
				quantity : num
			}, function(data) {
				console.log(data);
			}, 'JSON')
		}

		$(".productNumberSetting").on(
				"change",
				function() {
					const oiid = $(this).attr("data-oiid");
					const oid = $(this).parents("table").attr("oid");
					const num = $(this).val();
					const price = eval($("div[data-oiid-price=" + oiid + "]")
							.text().replace("￥", ""));
					change(oiid, num, price);
					change_quantity(oid, oiid, num);
				});

		$(".productNumberSetting").keyup(
				function() {
					var stock = parseInt($(this).parents("tr").find(
							"span.restQuantity").text());
					var num = $(this).parents("tr").find(
							".productNumberSetting").val();
					num = parseInt(num);
					if (isNaN(num))
						num = 1;
					if (num <= 0)
						num = 1;
					if (num > stock)
						num = stock;
					$(this).parents("tr").find(".productNumberSetting")
							.val(num).change();
				});

		$(".increaseNumber").click(
				function() {
					var stock = parseInt($(this).parents("tr").find(
							"span.restQuantity").text());
					var num = $(this).parents("tr").find(
							".productNumberSetting").val();
					parseInt(num);
					num++;
					if (num > stock)
						num = stock;
					$(this).parents("tr").find(".productNumberSetting")
							.val(num).change();
				});

		$(".decreaseNumber").click(
				function() {
					var stock = parseInt($(this).parents("tr").find(
							"span.restQuantity").text());
					var num = $(this).parents("tr").find(
							".productNumberSetting").val();
					parseInt(num);
					--num;
					if (num <= 0)
						num = 1;
					$(this).parents("tr").find(".productNumberSetting")
							.val(num).change();

				});

		if ('' != '${param.orderStatus}') {
			changeStatus($("a[orderStatus=${param.orderStatus}]"));
		}
		/*$("a[orderStatus]").click(function() {
			changeStatus(this);
		});*/
		function changeStatus(self) {
			var orderStatus = $(self).attr("orderStatus");
			if ('all' == orderStatus) {
				$("table[orderStatus]").show();
			} else {
				$("table[orderStatus]").hide();
				$("table[orderStatus=" + orderStatus + "]").show();
			}

			$("div.orderType div").removeClass("selectedOrderType");
			$(self).parent("div").addClass("selectedOrderType");
		}

		$("a.deleteOrderLink").click(function() {
			deleteOrderid = $(this).attr("oid");
			deleteOrder = false;
			$("#deleteConfirmModal").modal("show");
		});

		$("button.deleteConfirmButton").click(function() {
			deleteOrder = true;
			$("#deleteConfirmModal").modal('hide');
		});

		$('#deleteConfirmModal').on(
				'hidden.bs.modal',
				function(e) {
					if (deleteOrder) {
						var page = "${ctx}/common/order/delOrder/"
								+ deleteOrderid + ".action";
						$.post(page, {}, function(result) {
							result = eval(result)
							if (1 == result) {
								window.location.reload();
							}
						}, "JSON");

					}
				})

		$(".ask2delivery").click(function() {
			var link = $(this).attr("link");
			$(this).hide();
			page = link;
			$.ajax({
				url : page,
				success : function(result) {
					alert("卖家已秒发，刷新当前页面，即可进行确认收货")
				}
			});

		});
	});
</script>
<style>
.pageBtn{
text-align: center;
}
.pageBtn>* {
	padding: 5px;
	border: 1px solid #e8e8e8;
	border-radius: 1px;
	background: #f5f5f5;
	margin: -10px 0 10px 0;
}
.pageBtn>*[disabled]{
    cursor:not-allowed;
}
div.page_num{
    text-align: center;
}
</style>
<div class="boughtDiv">
	<div class="orderType">
		<div class="selectedOrderType">
			<a orderStatus="all"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=all">所有订单</a>
		</div>
		<div>
			<a orderStatus="0"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=0">待付款</a>
		</div>
		<div>
			<a orderStatus="1"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=1">待发货</a>
		</div>
		<div>
			<a orderStatus="3"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=3">派送中</a>
		</div>
		<div>
			<a orderStatus="2"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=2">待收货</a>
		</div>
		<div>
			<a orderStatus="4"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=4">待评价</a>
		</div>
		<div>
			<a orderStatus="5"
				href="${ctx }/common/order.action?pageNo=${param.pageNo==null?1:param.pageNo}&orderStatus=5"
				class="noRightborder">已完成</a>
		</div>
		<div class="orderTypeLastOne">
			<a class="noRightborder"> </a>
		</div>
	</div>
	<div style="clear: both"></div>
	<div class="orderListTitle">
		<table class="orderListTitleTable">
			<tr>
				<td>宝贝</td>
				<td width="121px">单价</td>
				<td width="121px">数量</td>
				<td width="141px">实付款</td>
				<td width="121px">交易操作</td>
			</tr>
		</table>
	</div>
	<c:if test="${page_def.pageTotal != 0 && page_def.pageNo <= page_def.pageTotal }">
		<div class="pageBtn">
			<button  name="pre" class="col-md-1" <c:if test="${page_def.pageNo == 1 }">disabled</c:if>>上一页</button> 
			<div class="col-md-10">
			    ${page_def.pageNo }/${page_def.pageTotal }
			</div>
			<button  name="next" class="col-md-1" <c:if test="${page_def.pageNo == page_def.pageTotal }">disabled</c:if>>下一页</button>
		</div>
	</c:if>
	<div class="orderListItem">
		<c:forEach items="${orders}" var="o" varStatus="i">
			<table class="orderListItemTable" oid="${o.orderId}"
				orderStatus="${o.orderItems.get(0).status }">
				<tr class="orderListItemFirstTR">
					<td colspan="2"><b>${order.orderCreateDate}</b> <span>订单号:
							${o.orderId} </span></td>
					<td colspan="2"><img width="13px"
						src="${ctx}/img/fore/orderItemTmall.png">天猫商场</td>
					<td colspan="1"><a class="wangwanglink" href="#nowhere">
							<div class="orderItemWangWangGif"></div>
					</a></td>
					<td class="orderItemEditTD" style="float: right;"><c:if
							test="${o.orderItems.get(0).status == 0 }">
							<a class="deleteOrderLink" oid="${o.orderId}"> <span
								class="orderListItemDelete glyphicon glyphicon-trash"></span>
							</a>

						</c:if></td>
				</tr>
				<c:forEach items="${o.orderItems}" var="oi" varStatus="st">
					<tr class="orderItemProductInfoPartTR">
						<td class="orderItemProductInfoPartTD"><img width="80"
							height="80" src="${ctx}/${oi.productType.productTypeImagePath}">
						</td>
						<td class="orderItemProductInfoPartTD">
							<div class="orderListItemProductLinkOutDiv">
								<a
									href="/Shopping/product/${oi.productType.productTypeId}.action">${oi.productType.productTypeName}</a>
								<div class="orderListItemProductLinkInnerDiv">
									<img src="${ctx}/img/fore/creditcard.png" title="支持信用卡支付">
									<img src="${ctx}/img/fore/7day.png" title="消费者保障服务,承诺7天退货">
									<img src="${ctx}/img/fore/promise.png" title="消费者保障服务,承诺如实描述">
								</div>
							</div>
						</td>
						<td valign="middle" class="orderItemProductInfoPartTD"
							width="100px">

							<div class="orderListItemProductOriginalPrice">￥${oi.productType.price}</div>
							<div class="orderListItemProductPrice"
								data-oiid-price="${oi.orderItemId }">￥${oi.productType.salePrice}</div>

						</td>
						<td valign="middle"
							class="orderListItemNumberTD orderItemOrderInfoPartTD"
							width="100px">
							<!-- 显示数量 -->
							<div class="productNumber" style="margin-top: 20px;">
								<span data-p="p"> <span class="productNumberSettingSpan">
										<input type="text"
										<c:if test="${oi.status !='0' }"> disabled </c:if>
										data-oiid="${oi.orderItemId }" value="${oi.quantity }"
										class="productNumberSetting">
								</span> <c:if test="${oi.status=='0' }">
										<span class="arrow"> <a class="increaseNumber"
											href="#nowhere"> <span class="updown"> <img
													src="${ctx}/img/fore/increase.png">
											</span>
										</a> <span class="updownMiddle"> </span> <a class="decreaseNumber"
											href="#nowhere"> <span class="updown"> <img
													src="${ctx}/img/fore/decrease.png">
											</span>
										</a>
										</span>
									</c:if>
								</span> <span><br>库存:<span class="restQuantity">${oi.productType.restQuantity }</span></span>
							</div>
						</td>
						<td valign="middle" width="120px"
							class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
							<div class="orderListItemProductRealPrice"
								data-oiid-total="${oi.orderItemId }">￥${oi.productType.salePrice * oi.quantity }</div>
							<div class="orderListItemPriceWithTransport">(含运费：￥0.00)</div>
						</td>
							<td valign="middle"
								class="orderListItemButtonTD orderItemOrderInfoPartTD"
								style="width: 160px;">
								<c:choose>
									<c:when test="${oi.productType.restQuantity eq 0 && oi.status eq 0}">
										<span>暂时无货</span>
									</c:when>
									<c:when test="${oi.status eq 0 }">
										<a href="${ctx }/common/order/payOrder/${o.orderId}.action">
											<button class="orderListItemConfirm">付款</button>
										</a>
									</c:when>
									<c:when test="${oi.status eq 1 }">
										<span>待发货</span>
									</c:when>
									<c:when test="${oi.status eq 2 }">
										<a href="confirmPay?order_id=${o.orderId}">
											<button class="orderListItemConfirm">确认收货</button>
										</a>
									</c:when>
									<c:when test="${oi.status eq 3 }">
										<span>派送中</span>
									</c:when>
									<c:when test="${oi.status eq 4 }">
										<a href="review?order_id=${o.orderId}">
											<button class="orderListItemReview">评价</button>
										</a>
									</c:when>
									<c:when test="${oi.status eq 5 }">
										<span>已完成</span>
									</c:when>
								</c:choose></td>
					</tr>
				</c:forEach>

			</table>
		</c:forEach>
			
	</div>
	<c:if test="${page_def.pageTotal != 0 && page_def.pageNo <= page_def.pageTotal }">
		<div class="pageBtn">
			<button  name="pre" class="col-md-1" <c:if test="${page_def.pageNo == 1 }">disabled</c:if>>上一页</button> 
				<div class="col-md-10">
				    ${page_def.pageNo }/${page_def.pageTotal }
				</div>
				<button  name="next" class="col-md-1" <c:if test="${page_def.pageNo == page_def.pageTotal }">disabled</c:if>>下一页</button>
		</div>
	</c:if>
	<div style="clear: both"></div>
	
	<script>
	     const pre = () =>{
	    	 let pageNo = ${param.pageNo==null?1:(param.pageNo)}
	    	 let orderStatus = $(".selectedOrderType a").attr('orderStatus');
	    	 window.location.href = "${ctx}/common/order.action?pageNo="+ (parseInt(pageNo)-1) + "&orderStatus=" +orderStatus;
	    	 };
	     const next = () =>{
	    	 let pageNo = ${param.pageNo==null?1:(param.pageNo)}
	    	 let orderStatus = $(".selectedOrderType a").attr('orderStatus');
	    	 window.location.href = "${ctx}/common/order.action?pageNo="+ (parseInt(pageNo)+1) + "&orderStatus=" +orderStatus;
	         };
	     $("[name=pre]").click(pre);
	     $("[name=next]").click(next);
	</script>
</div>
<%@include file="include/footer.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%@include file="include/header.jsp" %>
<%@include file="include/top.jsp" %>
<%@include file="include/mini-search.jsp" %>

<style>
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
        border: 2px solid #aaa !important;
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
    tr.orderItemProductInfoPartTR{
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

    $(function () {
    	
    	
        $(".productNumberSetting").keyup(function () {
        	var stock = parseInt($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div").children(1).children(0).text());
        	var num = $($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div > span:nth-child(1)").children(0).get(0)).children(0).val();
            num = parseInt(num);
            if (isNaN(num))
                num = 1;
            if (num <= 0)
                num = 1;
            if (num > stock)
                num = stock;
            $($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div > span:nth-child(1)").children(0).get(0)).children(0).val(num);
        });
        
        $(".increaseNumber").click(function () {
        	var stock = parseInt($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div").children(1).children(0).text());
            var num = $($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div > span:nth-child(1)").children(0).get(0)).children(0).val();
            parseInt(num);
            num++;
            if (num > stock)
                num = stock;
            $($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div  > span:nth-child(1)").children(0).get(0)).children(0).val(num);
        });
       
       
        $(".decreaseNumber").click(function () {
        	var stock = parseInt($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div").children(1).children(0).text());
            var num = $($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div > span:nth-child(1)").children(0).get(0)).children(0).val();
            parseInt(num);
            --num;
            if (num <= 0)
                num = 1;
            $($(this).parents("td.orderListItemNumberTD.orderItemOrderInfoPartTD > div  > span:nth-child(1)").children(0).get(0)).children(0).val(num);
        });
    	
    	
        $("a[orderStatus]").click(function () {
            var orderStatus = $(this).attr("orderStatus");
            if ('all' == orderStatus) {
                $("tr[orderStatus]").show();
            }
            else {
                $("tr[orderStatus]").hide();
                $("tr[orderStatus=" + orderStatus + "]").show();
            }

            $("div.orderType div").removeClass("selectedOrderType");
            $(this).parent("div").addClass("selectedOrderType");
        });

        $("a.deleteOrderLink").click(function () {
            deleteOrderid = $(this).attr("oid");
            deleteOrder = false;
            $("#deleteConfirmModal").modal("show");
        });

        $("button.deleteConfirmButton").click(function () {
            deleteOrder = true;
            $("#deleteConfirmModal").modal('hide');
        });

        $('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
            if (deleteOrder) {
                var page = "deleteOrder";
                $.post(
                    page,
                    {"order_id": deleteOrderid},
                    function (result) {
                        if ("success" == result) {
                            $("table.orderListItemTable[oid=" + deleteOrderid + "]").hide();
                        }
                        else {
                            location.href = "login.jsp";
                        }
                    }
                );

            }
        })

        $(".ask2delivery").click(function () {
            var link = $(this).attr("link");
            $(this).hide();
            page = link;
            $.ajax({
                url: page,
                success: function (result) {
                    alert("卖家已秒发，刷新当前页面，即可进行确认收货")
                }
            });

        });
    });

</script>
<div class="boughtDiv">
    <div class="orderType">
        <div class="selectedOrderType"><a orderStatus="all" href="#nowhere">所有订单</a></div>
        <div><a orderStatus="0" href="#nowhere">待付款</a></div>
        <div><a orderStatus="1" href="#nowhere">待发货</a></div>
        <div><a orderStatus="2" href="#nowhere">待收货</a></div>
         <div><a orderStatus="3" href="#nowhere">派送中</a></div>
        <div><a orderStatus="4" href="#nowhere" class="noRightborder">待评价</a></div>
         <div><a orderStatus="5" href="#nowhere">已完成</a></div>
        <div class="orderTypeLastOne"><a class="noRightborder"> </a></div>
    </div>
    <div style="clear:both"></div>
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

    <div class="orderListItem">
        <c:forEach items="${orders}" var="o">
            <table class="orderListItemTable"  oid="${o.orderId}" >
                <tr class="orderListItemFirstTR">
                    <td colspan="2">
                        <b>${order.orderCreateDate}</b>
                        <span>订单号: ${o.orderId}
                    </span>
                    </td>
                    <td colspan="2"><img width="13px" src="${ctx}/img/fore/orderItemTmall.png">天猫商场</td>
                    <td colspan="1">
                        <a class="wangwanglink" href="#nowhere">
                            <div class="orderItemWangWangGif"></div>
                        </a>

                    </td>
                    <td class="orderItemDeleteTD">
                        <a class="deleteOrderLink" oid="${o.orderId}" href="#nowhere">
                            <span class="orderListItemDelete glyphicon glyphicon-trash"></span>
                        </a>

                    </td>
                </tr>
                <c:forEach items="${o.orderItems}" var="oi" varStatus="st">
                    <tr class="orderItemProductInfoPartTR" orderStatus="${oi.status }">
                        <td class="orderItemProductInfoPartTD">
                        <img width="80" height="80" 
                        src="${ctx}/${oi.productType.productTypeImagePath}">
                        </td>
                        <td class="orderItemProductInfoPartTD">
                            <div class="orderListItemProductLinkOutDiv">
                                <a href="foreproduct?pid=${oi.productType.product.productId}">${oi.productType.productTypeName}</a>
                                <div class="orderListItemProductLinkInnerDiv">
                                    <img src="${ctx}/img/fore/creditcard.png" title="支持信用卡支付">
                                    <img src="${ctx}/img/fore/7day.png" title="消费者保障服务,承诺7天退货">
                                    <img src="${ctx}/img/fore/promise.png" title="消费者保障服务,承诺如实描述">
                                </div>
                            </div>
                        </td>
                        <td valign="middle" class="orderItemProductInfoPartTD" width="100px">

                            <div class="orderListItemProductOriginalPrice">￥${oi.productType.price}</div>
                            <div class="orderListItemProductPrice">￥${oi.productType.salePrice}</div>

                        </td>
                            <td valign="middle" class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
                                <!-- 显示数量 -->
                                <div class="productNumber" style="margin-top:20px;">
                                    <span data-p="p">
                                        <span class="productNumberSettingSpan">
                                            <input type="text" value="${oi.quantity }" class="productNumberSetting">
                                        </span>
                                        <c:if test="${'0'=='0' }">
	                                        <span class="arrow">
	                                            <a class="increaseNumber" href="#nowhere">
	                                                <span class="updown">
	                                                    <img src="${ctx}/img/fore/increase.png">
	                                                </span>
	                                            </a>
	                                            <span class="updownMiddle"> </span>
	                                            <a class="decreaseNumber" href="#nowhere">
	                                                <span class="updown">
	                                                    <img src="${ctx}/img/fore/decrease.png">
	                                                </span>
	                                            </a>
	                                        </span>
                                        </c:if>
                                    </span>
                                    <span>库存:<span class="restQuantity">${oi.productType.restQuantity }</span></span>
                                </div>
                            </td>
                            <td valign="middle" width="120px" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
                                <div class="orderListItemProductRealPrice">￥${oi.productType.salePrice * oi.quantity }</div>
                                <div class="orderListItemPriceWithTransport">(含运费：￥0.00)</div>
                            </td>
                            <td valign="middle" class="orderListItemButtonTD orderItemOrderInfoPartTD" width="100px">
                               <c:if test="${oi.status=='0' }">
                                    <a href="alipay.jsp?order_id=${o.orderId}&total=o.total">
                                        <button class="orderListItemConfirm">付款</button>
                                    </a>
                                </c:if>
                                <c:if test="${oi.status=='1' }">
                                    <span>待发货</span>
                                    <%--
                                    <button class="btn btn-info btn-sm ask2delivery" 
                                    link="admin_order_delivery?id=${o.orderId}">催卖家发货</button> 
                                    --%>
                                </c:if>
                                <c:if test="${oi.status=='2' }">
                                    <a href="confirmPay?order_id=${o.orderId}">
                                        <button class="orderListItemConfirm">确认收货</button>
                                    </a>
                                </c:if>
                                <c:if test="${oi.status=='3' }">
                                    <span>派送中</span>
                                </c:if>
                                <c:if test="${oi.status=='4' }">
                                    <a href="review?order_id=${o.orderId}">
                                        <button class="orderListItemReview">评价</button>
                                    </a>
                                </c:if>
                                <c:if test="${oi.status=='5' }">
                                    <span>已完成</span>
                                </c:if>
                            </td>
                    </tr>
                </c:forEach>

            </table>
        </c:forEach>

    </div>

</div>
<%@include file="include/footer.jsp" %>

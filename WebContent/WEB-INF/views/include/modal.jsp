<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog">
    <div class="modal-dialog deleteConfirmModalDiv">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">确认删除？</h4>
            </div>
             <div class="modal-body">
             <h3>删除后不可恢复！</h3>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="reviewModal" tabindex="-1" role="dialog">
    <div class="modal-dialog deleteConfirmModalDiv">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
             <div class="modal-body">
             输入评价: <input type="text" id="review" />
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary deleteConfirmButton" onclick="submitReview()" type="button">提交</button>
                <script type="text/javascript">
                    function submitReview(){
                    	let oiid = window.oiid;
                    	let oid = window.oid;
                    	window.oiid = window.oid = null;
                    	let review = $("#review").val();
                    	$.post('${ctx}/common/review/add.action',{'orderItemId':oiid,'orderId':oid,'review':review},function(data){
                    		if(eval(data) == 1){
                    			alert('评论成功!');
                    			window.location.reload();
                    		}else{
                    			alert('评论失败!');
                    		}
                    	})
                    }
                </script>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="addAddressModal" tabindex="-1" role="dialog">
    <div class="modal-dialog deleteConfirmModalDiv">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title">输入地址:</h4>
            </div>
             <div class="modal-body">
             <form id="addressForm">
                 地&nbsp;&nbsp;址:&nbsp;<input type="text" name="addressName"/><br><br>
                 收货人:&nbsp;<input type="text" name="consignee" /><br><br>
                 手机号:&nbsp;<input type="text" name="phone" /><br><br>
             </form>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary deleteConfirmButton" onclick="submit_address()" type="button">确认</button>
                <script>
                    function submit_address(){
                    	let data = $("#addressForm").serialize();
                    	$.post('${ctx}/address/add.action',data,function(result){
                    		if(eval(result) == 1){
                    			alert('添加成功!');
                    			window.location.reload();
                    		}else{
                    			alert('添加失败!');
                    		}
                    	},'JSON')
                    }
                </script>
            </div>
        </div>
    </div>
</div>
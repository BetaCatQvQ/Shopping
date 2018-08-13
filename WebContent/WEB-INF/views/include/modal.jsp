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
                <h4 class="modal-title">输入评价:</h4>
            </div>
             <div class="modal-body">
             <input type="text" id="review" />
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary deleteConfirmButton" onclick="submitReview" type="button">提交</button>
                <script type="text/javascript">
                    function submitReview(){
                    	let oiid = window.oiid;
                    	let review = $("#review").val();
                    	$.post('${ctx}/common/review/add.action',{'orderItemId':oiid,'review':review},function(data){
                    		if(eval(data) == 1){
                    			alert('评论成功!');
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

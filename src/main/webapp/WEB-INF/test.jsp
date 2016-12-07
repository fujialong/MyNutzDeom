<html lang="zh"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<meta name="renderer" content="webkit"><title>我是体育达人/文化达人</title><!--[if lte IE 9]>
 <script src="http://static.smartisanos.cn/common/js/update-browser.js"></script>
<![endif]-->
<link rel="stylesheet" href="{base!}/css/marketing/piaoliang/proud/asset1440599057840/css/style.css">
<script src="{base!}/js/hm.js">
	
</script><script async="" src="{base!}/js/analytics.js"></script><script>
(function(){
var mobilecheck = function() {
 if( navigator.userAgent.match(/Android/i)
  || navigator.userAgent.match(/webOS/i)
  || navigator.userAgent.match(/iPhone/i)
  || navigator.userAgent.match(/iPad/i)
  || navigator.userAgent.match(/iPod/i)
  || navigator.userAgent.match(/BlackBerry/i)
  || navigator.userAgent.match(/Windows Phone/i)
 ){
    return true;
  }
 else {
    return false;
  }
}
if( mobilecheck() ) {
    window.location.href = 'www.baidu.comproudm/';
}
})();
</script></head><body><div class="top_nav"><div class="username">梯田软件<i></i></div>
	<div class="account" style="width: 143px;"><div class="item"><a href="/proud/logout.php">切换账号</a></div></div>
	<a class="btn download disabled" href="javascript:;">下载为图片</a> 
	<a class="btn weibo disabled" href="javascript:;">发送到新浪微博</a> 
	<a class="btn share disabled" href="javascript:;">分享到朋友圈</a>
	<div class="weixin_share"><p>微信扫描二维码</p><div id="qrcode"></div>
	<i><b></b></i></div></div><div class="wrapper"><div class="preview_area" id="canvas"><div class="preview_area_w">
		<div class="img_bg"></div><a class="first_btn btn disabled" data-type="2" href="javascript:;">生成图片</a> 
		<i></i><div class="post_img_outer hidden"><img id="post_img"></div><div class="loading-bar hidden"><span class="loading-icon"></span> 
		<span class="loading-text">图片生成中</span></div><div class="update_tip">
			<p>您刚刚编辑了图片内容<br>请点击下方按钮更新图片</p><a class="close" href="javascript:;">&nbsp;</a> 
			<a class="update_btn btn" data-type="2" href="javascript:;">更新图片</a></div></div></div>
			<div class="edit_area"><span class="arrow"></span><div class="edit_area_w">
				<form id="upload_form" method="post" target="callback_frame" enctype="multipart/form-data" action="www.baidu.comproud/upload.php">
					<h3><i class="number number1"></i> <span>请上传人物照片</span></h3><div class="app_img">
						<label id="upload_bg" for="app_upload"><input type="file" id="app_upload" name="image" accept="image/*">
						</label> <span class="reload"><label for="app_upload">
							<img src="{base!}/css/marketing/piaoliang/proud/asset1440599057840/img/reload.png">换一张</label>
						</span> 
						<span class="edit"><label>
							<img src="{base}/css/marketing/piaoliang/proud/asset1440599057840/img/edit.png">调整图片</label></span></div>
				</form>
				<form id="main_form" method="post" target="callback_frame" action="${base}/MyNutzDeom/getInfo.php">
					<h3><i class="number number2"></i> <span>请输入人物描述</span></h3><div class="app_dec"><div class="dec_type"><span>
						<input type="radio" name="style" id="type_a" checked="" value="1"> <b>爱…还爱…</b></span>
						<span><input type="radio" name="style" id="type_b" value="2"> <b>会…还会…</b></span></div><div class="story">
							<div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off"></div>
							<div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off"></div>
							<div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off">
							</div><div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off"></div>
							<div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off">
							</div><div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off">
							</div><div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off"></div>
							<div class="dec_input"><input type="text" value="爱" name="word[]" class="dec_text default" autocomplete="off"></div>
							<div class="dec_input"><input type="text" value="还爱" name="word[]" class="dec_text default" autocomplete="off"></div>
							<div class="dec_input name"><div class="gender">他</div><input type="text" name="identity" class="dec_text" autocomplete="off">
							<div class="gender_list"><div><input type="radio" name="gender" id="boy" checked="" value="1"> 
								<b>他</b></div><div><input type="radio" name="gender" id="girl" value="2"> <b>她</b></div><div>
									<input type="radio" name="gender" id="obj" value="3"> <b>它</b></div></div></div></div><i>每行最多18个字</i></div>
									<input type="hidden" id="image_field" name="image"></form>
			</div></div><div class="crop_window hidden" unselectable="on">
										<div class="crop_tit">照片裁剪</div><div class="crop_main">
											<canvas id="crop_workplace"></canvas>
					<img class="sample" src="{base!}/css/marketing/piaoliang/proud/asset1440599057840/img/arrow.png">
					<div class="zoom">
					<img src="{base!}/css/marketing/piaoliang/proud/asset1440599057840/img/zoom_out.png" id="zoom_out">
					<div class="zoom_bar" id="zoom"><div class="zoom_bar_blue"></div><div id="zoom_handle"></div>
					</div><img src="{base!}/css/marketing/piaoliang/proud/asset1440599057840/img/zoom_in.png" id="zoom_in">
					</div><div class="colors"><span><input type="radio" name="color" class="color" checked="" value="1"> <b class="red"></b></span> 
					<span><input type="radio" name="color" class="color" value="2"> <b class="orange"></b></span> <span>
					<input type="radio" name="color" class="color" value="3"> <b class="yellow"></b></span> <span>
					<input type="radio" name="color" class="color" value="4"> <b class="green"></b></span> <span>
					<input type="radio" name="color" class="color" value="5"> <b class="cyan"></b></span> <span>
					<input type="radio" name="color" class="color" value="6"> <b class="blue"></b></span> <span>
					<input type="radio" name="color" class="color" value="7"> <b class="purple"></b></span></div>
					<div class="loading"><img id="loading_icon" src="{base!}/css/marketing/piaoliang/proud/asset1440599057840/img/loading.png"><p>加载中，请稍等…</p>
												
    </div><div class="too_small"><p>您选择的图片过小，请选择分辨率<br>不低于 470px × 768px 的图片</p></div></div><div class="crop_btn">
    	<button id="crop_cancel">取消</button><button id="crop_confirm">确认</button><button id="crop_reload"><label for="app_upload">换一张</label></button>
    </div></div></div><div class="gray_layer hidden"></div><canvas id="hidden_workplace" class="hidden">
    	
    </canvas><canvas id="gray_workplace" class="hidden"></canvas><iframe id="callback_frame" name="callback_frame" class="hidden"></iframe>
    <script src="js/main.js"></script><script>
    // Google
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','js/analytics.js','ga');

    ga('create', 'UA-49819160-1', 'smartisan.com');
    ga('send', 'pageview');

    // Baidu
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "{base!}/js/hm.js";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();

</script></body></html>
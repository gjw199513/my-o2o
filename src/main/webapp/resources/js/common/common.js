//点击图片切换验证码
function changeVerifyCode(img) {
    img.src = '../Kaptcha?' + Math.floor(Math.random()*100);
}
window.onload = function() {
    var name = /^([a-zA-Z]+)([a-zA-Z0-9]*)$/; //英文开头的用户名
    var emailReg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/; //邮箱
    var regpwd = /^[a-zA-Z0-9_-]{6,16}/; //密码
    var regCode = /^[a-zA-Z0-9]+$/; //验证码
    var form = document.querySelector("#userInfoform");
    var submitBtn = document.querySelector("#submit");
    var userName = document.querySelector("#userName");

    regxbp(email, emailReg, "您的邮箱", 1);
    submitBtn.onclick = checkSubmit
    var checkItem = [false]
    var inputItem = [email]
    var msg = ["邮箱格式有误", "请输入6-16位密码", "两次密码不一致"]



    function encodeMD5(str) {
        return CryptoJS.MD5(str).toString(); //Hash加密
    }

    function checkSubmit() {
        for (index in checkItem) {
            if (!checkItem[index]) {
                inputItem[index].nextElementSibling.className = 'error';
                inputItem[index].nextElementSibling.innerHTML = '<i class="error_icon"></i>' + msg[index];
                return;
            }
        }
        form.submit();
    }




    function regxbp(ele, reg, msg = "", index = 1) {
        ele.onblur = function() {
            if (this.value == "") {
                this.nextElementSibling.className = "success";
                this.nextElementSibling.innerHTML = msg;
                checkItem[index] = false;
            } else if (reg.test(this.value)) {

            } else {
                this.nextElementSibling.className = 'error';
                this.nextElementSibling.innerHTML = '<i class="error_icon"></i>' + msg;
                checkItem[index] = false;
            }
        }
    }



}
var com = {
	CURRENT_BROWSER: (function() {
		var ag = window.navigator.userAgent.toLowerCase();
		var obj = {CHROME: false, SAFARI: false, FIREFOX: false, MSIE: false};
		if (ag.indexOf("chrome") > -1) obj.CHROME = true;
		if (ag.indexOf("safari") > -1 && ag.indexOf("chrome") < 0) obj.SAFARI = true;
		if (ag.indexOf("firefox") > -1) obj.FIREFOX = true;
		if (ag.indexOf("msie") > -1 || ag.indexOf("trident") > -1 || ag.indexOf("edge") > -1) obj.MSIE = true;
		return obj;
	})(),

	//달력
	calendar : function(id){
		 $('#' + id).datepicker({
		    format: "yyyy-mm-dd",
		    todayBtn: "linked",
		    language: "kr",
		    keyboardNavigation: false,
		    forceParse: false,
		    todayHighlight: true,
		    autoclose : true
		});
		
	},
	//팝업 창
	popup : function(params){
		var left = (screen.width/2)-(params.width /2);
		if( params.left != undefined ) left = left +  params.left;
		var top = (screen.height/2)-( params.height /2);
		var scroll = (params.scrollbars == "yes") ? "yes" : "no";
		document.window.open(params.url, params.title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=' + scroll + ', width='+params.width+', height='+params.height+', top='+top+', left='+left);
	},

	/**
	 * 우편번호 zip1 zip2 addr1 아이디 찾아들어감
	 */
	zipCode : function(){
		this.popup({
			url : "/common/zipCode.do",
			title : "우편번호검색",
			width : 450,
			height :500
		});
	},

	// 화면프린트
	print : function(){
		$("#print").print({
			globalStyles: true,
			mediaPrint: false,
			stylesheet: null,
			noPrintSelector: ".no-print",
			iframe: true,
			append: null,
			prepend: null,
			manuallyCopyFormValues: true,
			deferred: $.Deferred(),
			timeout: 250
		});
	},

	/**
	 * checkMsg : 공백체크, checkFile : 파일필수, checkEmail : 메일체크, checkNum : 숫자체크
	 * @param id
	 * @returns {Boolean}
	 */
	formCheck : function(id){

		var exit = false;

		 $("#"+id+" input[type=text], #" +id+" textarea").each(function() {

			  if( $(this).attr("checkMsg") != undefined && !com.trim($(this).val()) ){
				  alert($(this).attr("checkMsg") + " 입력해주세요")
				  $(this).focus();
				  exit = false;
				  return false;
			  }else{
				  exit = true;
			  }

			  if( $(this).attr("checkEmail") != undefined && !com.emailCheck($(this).val()) ){
				  alert("메일형식이 옳바르지 않습니다.")
				  $(this).focus();
				  exit = false;
				  return false;
			  }else{
				  exit = true;
			  }

			  if( $(this).attr("checkNum") != undefined && !com.numberCheck($(this).val()) ){
				  alert("숫자만 입력해주세요.")
				  $(this).focus();
				  exit = false;
				  return false;
			  }else{
				  exit = true;
			  }
        });

		 if (exit) {
			$("#"+id+" select").each(function() {
//				  if( $(this).attr("checkMsg") != undefined  && ($(this).val() == ""|| $(this).val() == "00" ) ){
				  if( $(this).attr("checkMsg") != undefined  && ($(this).val() == "") ){
					  alert($(this).attr("checkMsg") + " 선택해주세요");
					  $(this).focus();
					  exit = false;
					  return false;
				  }else{
					  exit = true;
				  }
			});
		}

		if (exit) {
			$("#"+id+" input[type=checkbox]").each(function() {
				  if( $(this).attr("checkMsg") != undefined  && $(this).prop("checked" ) == false ){
					  alert($(this).attr("checkMsg") + " 체크해주세요");
					  $(this).focus();
					  exit = false;
					  return false;
				  }else{
					  exit = true;
				  }
			});
		}

		return exit;

	},

	//공백제거
	trim : function(str){
		re = /^\s+|\s+$/g;
		return str.replace(re, '');
	},

	//숫자만
	numberCheck : function(str){
	//	var reg = /^[-0-9]/g ;
		var reg =  /^[0-9]+$/ ;
		return reg.test(str);
	},

	//메일체크
	emailCheck : function(str){
		var reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/ ;
		return reg.test(str);
	},

	accountCheck: function(str) {
		var reg = /^([0-9_-]+)$/;
		return reg.test(str);
	},

	//테이블 로스팬 id: 테이블아이디, colIdx 컬럼
	rowspan : function(id,colIdx, isStats) {
		return $("#" + id).each(function(){
			var that;
			$('tr', this).each(function(row) {
				$('td:eq('+colIdx+')', this).filter(':visible').each(function(col) {

					if ($(this).html() == $(that).html()
						&& (!isStats
								|| isStats && $(this).prev().html() == $(that).prev().html()
								)
						) {
						rowspan = $(that).attr("rowspan") || 1;
						rowspan = Number(rowspan)+1;

						$(that).attr("rowspan",rowspan);

						// do your action for the colspan cell here
						$(this).hide();

						//$(this).remove();
						// do your action for the old cell here

					} else {
						that = this;
					}

					// set the that if not already set
					that = (that == null) ? this : that;
				});
			});
		});

	},

	toolTip : function(params){
		$("#" + params.id).bt(params.content,{
			width : params.width,
			fill: params.fill,
			strokeStyle: '#B7B7B7',
			spikeLength: 10,
			spikeGirth: 10,
			padding: 8,
			cornerRadius: 5,
			cssStyles: {  fontSize: '9pt' },
			positions: params.position
		});
	},

	ieCheck : function(){

		var ua = window.navigator.userAgent;
	    var msie = ua.indexOf('MSIE ');
	    if (msie > 0) {
	        // IE 10 or older => return version number
	        return parseInt(ua.substring(msie + 5, ua.indexOf('.', msie)), 10);
	    }
	    var trident = ua.indexOf('Trident/');
	    if (trident > 0) {
	        // IE 11 => return version number
	        var rv = ua.indexOf('rv:');
	        return parseInt(ua.substring(rv + 3, ua.indexOf('.', rv)), 10);
	    }
	    var edge = ua.indexOf('Edge/');
	    if (edge > 0) {
	       // IE 12 => return version number
	       return parseInt(ua.substring(edge + 5, ua.indexOf('.', edge)), 10);
	    }
	},

	reset : function(id){
		$("#"+id+" input[type=text]").each(function() {
				$(this).val("");
		});

		$("#"+id+" select").each(function() {
			 if( $(this).attr("id") != "endRow" ){
				this.selectedIndex = 0;
			 }
		});
	}

};

var bizEvent = {

	KEY_CODE: {
		BACKSPACE: 8
		, TAB: 9
		, ALT: 18
		, LEFT: 37
		, UP: 38
		, RIGHT: 39
		, DOWN: 40
		, DELETE: 46
		, NUMBER: [48, 49, 50, 51, 52, 53, 54, 55, 56, 57]
		, NUMBER_PAD: [96, 97, 98, 99, 100, 101, 102, 103, 104, 105]
		, WINDOW: 91
		, KOREAN: 229
	},

	onlyNumberAndMove: function(target_id, next_move_id) {
		if (com.CURRENT_BROWSER.MSIE) {
			$("#" + target_id).attr("style", $("#" + target_id).attr("style") + "ime-mode: disabled;");
		}
		$("#" + target_id).bind("keydown",  function(e) {
			var kc = e.keyCode;
			if (bizEvent.isNumberKeyCode(kc)
					|| bizEvent.isFunctionKeyCode(kc)) return true;
			return false;
		}).bind("keyup", {next_move_id: next_move_id}, function(e) {
			var kc = e.keyCode, t = $(this);
			var v = t.val().trim();
			if (!bizEvent.isNumberKeyCode(kc)) {
				if (!com.numberCheck(v)) $(this).val($(this).val().replaceStringToEmpty());
			}
			if (bizEvent.isNumberKeyCode(kc)) {
				var mx = t.attr("maxlength");
				if (v.length >= mx) {
					if (v.length > mx) t.val(v.substr(0, 4));
					$("#" + e.data.next_move_id).focus();
				}
			}
		});
	},

	onlyNumber: function(target_id) {
		if (com.CURRENT_BROWSER.MSIE) {
			$("#" + target_id).attr("style", $("#" + target_id).attr("style") + "ime-mode: disabled;");
		}
		$("#" + target_id).bind("keydown",  function(e) {
			var kc = e.keyCode;
			if (bizEvent.isNumberKeyCode(kc)
					|| bizEvent.isFunctionKeyCode(kc)) return true;
			return false;
		}).bind("keyup", function(e) {
			var kc = e.keyCode, t = $(this);
			var v = t.val().trim();
			var mx = t.attr("maxlength");
			if (!bizEvent.isNumberKeyCode(kc)) {
				if (!com.numberCheck(v)) $(this).val($(this).val().replaceStringToEmpty());
			}
			if (bizEvent.isNumberKeyCode(kc)) {
				if (v.length > mx) t.val(v.substr(0, 4));
			}
		});
	},

	isNumberKeyCode: function(key_code) {
		if ((key_code >= this.KEY_CODE.NUMBER[0] && key_code <= this.KEY_CODE.NUMBER[9])
			|| (key_code >= this.KEY_CODE.NUMBER_PAD[0] && key_code <= this.KEY_CODE.NUMBER_PAD[9])) return true;
		return false;
	},

	isFunctionKeyCode: function(key_code) {
		if (bizEvent.KEY_CODE.BACKSPACE == key_code
				|| bizEvent.KEY_CODE.TAB == key_code
				|| bizEvent.KEY_CODE.ALT == key_code
				|| bizEvent.KEY_CODE.LEFT == key_code
				|| bizEvent.KEY_CODE.RIGHT == key_code
				|| bizEvent.KEY_CODE.DELETE == key_code
				|| bizEvent.KEY_CODE.WINDOW == key_code) return true;
		return false;
	}
};

var bizForm = {
	checkInput: function(id, permitEmpty /* optional[default:false] */) {
		var target = $("#" + id);
		var title = this.getTitle(id);
		if (!permitEmpty) {
			if (this.isNullOrEmpty(id)) {
				if (title == '')
					alert("필수 입력값을 입력하세요.");
				else
					alert(title + "은(는) 필수입니다.");
				target.focus();
				return false;
			}
		}

		if (this.isOverMaxLength(id)) {
			if (title == '')
				alert("입력할 수 있는 최대 길이를 초과하였습니다.");
			else
				alert(title + "에 입력할 수 있는 최대 길이를 초과하였습니다.");
			target.focus();
			return false;
		}
		return true;
	},

	checkInputNumber: function(id, permitEmpty /* optional[default:true] */) {
		var title = this.getTitle(id);
		var target = $("#" + id);
		if (this.checkInput(id, permitEmpty)) {
			if (!com.numberCheck(target.val())) {
				if (title == '')
					alert("숫자만 입력가능합니다.");
				else
					alert(title + "은(는) 숫자만 입력가능합니다.");
				target.focus();
				return false;
			}
		} else {
			return false;
		}
		return true;
	},

	checkInputEmail: function(id, permitEmpty /* optional[default:true] */) {
		var title = this.getTitle(id);
		var target = $("#" + id);
		if (this.checkInput(id, permitEmpty)) {
			if (!com.emailCheck(target.val())) {
				if (title == '')
					alert("정확한 이메일주소를 입력하세요.");
				else
					alert(title + "에 정확한 이메일주소를 입력하세요.");
				target.focus();
				return false;
			}
		} else {
			return false;
		}
		return true;
	},

	checkInputAccount: function(id, permitEmpty /* optional[default:true] */) {
		var title = this.getTitle(id);
		var target = $("#" + id);
		if (this.checkInput(id, permitEmpty)) {
			if (!com.accountCheck(target.val())) {
				if (title == '')
					alert("정확한 계좌번호를 입력하세요.");
				else
					alert(title + "에 정확한 계좌번호를 입력하세요.");
				target.focus();
				return false;
			}
		} else {
			return false;
		}
		return true;
	},

	isNullOrEmpty: function(id) {
		var tag = $("#" + id).prop("tagName").toLowerCase();
		var target = $(tag + "#" + id);
		var type = target.attr("type");
		if (type == "checkbox" || type == "radio") {
			return !$(tag + "[name=" + target.attr("name") + "]").is(":checked");
		}
		return (target.val().trim() == '');
	},

	isOverMaxLength: function(id) {
		var tag = $("#" + id).prop("tagName").toLowerCase();
		var target = $(tag + "#" + id);
		if (target.attr("maxlength")) {
			if (this.getByteLength(target.val()) > target.attr("maxlength")) {
				return true;
			}
		}
		return false;
	},

	getTitle: function(id) {
		var target = $("#" + id);
		return target.attr("title") ? target.attr("title") : (target.attr("checkMsg") ? target.attr("checkMsg") : '');
	},

	getByteLength: function(str) {
		if(!str) return 0;
		var byte = 0;
		var one_char = "";
		for (var x = 0; x < str.length; x++) {
			one_char = str.charAt(x);
			if(escape(one_char).length > 4)
				byte += 3;
			else
				byte++;
		}
		return byte;
	}
};

/* String prototypes */
String.prototype.replaceStringToEmpty = function () {
	return this.replace(/[^0-9]/g, "");
};

String.prototype.fillToLeft = function(length, char) {
	var s = this.toString();
	while (s.length < length) {
		s = char + s;
	}
	return s;
};
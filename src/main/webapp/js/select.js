/**
 * 
 */
/* 泊数（チェックインとチェックアウトの差し引き）を出力する関数　*/
function dayCal(){
  var val_from = document.getElementsByName("checkIN")[0].value;
  var val_to = document.getElementsByName("checkOUT")[0].value;

  if(val_from != "" && val_to != ""){

    // 日付オブジェクトを生成
    var day_from = new Date(val_from);
    var day_to = new Date(val_to);

    //日数の計算  86,400,000ミリ秒＝1日（1000ミリ秒×60秒×60分×24時間×365日）
    var termDay = (( day_to - day_from ) / 86400000);
    document.getElementsByName("hakusuu")[0].value = termDay;
  }else{
    document.getElementsByName("hakusuu")[0].value = "0";
  }
  
  

/*function noRoom(){

	var roomList =  window.sessionStorage.getItem(['']);

  }

*/
  
  
}



/**
 * 
 */

	var topImg = document.querySelector("#topImg");
	
	let images = ['img/room.jpg','img/bath.jpg','img/spa.jpg'];
	
	var count = 0;
	//アニメーション制御カウント(imagsの列数)
	var counter = 0;
	//総合アニメーションカウント（一定以上でアニメーション停止）
		
	let z1 = setInterval(topImgButton,10000);

 
 	 topImg.innerHTML = "<button  class='topAnimeButton' type='button' onClick='topImgButton()'> "
 	 		+"<img class='topAnimeImg' src='"+ images[count] +"' alt='ホテルイメージ写真'></button>";
 
 
 	function topImgButton(){
 		count++; counter++;	
 		if(count == images.length){ count = 0;}
 		
		topImg.innerHTML =  "<button  class='topAnimeButton' type='button' onClick='topImgButton()'>"
			+"<img class='topAnimeImg' src='"+ images[count] +"' alt='ホテルイメージ写真'></button>";

		if(counter == 1000){
			clearInterval(z1);}
		
	}
	


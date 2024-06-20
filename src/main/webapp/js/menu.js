
document.addEventListener("DOMContentLoaded", function() {
    const menubutton = document.getElementById("menubutton");
    const menu = document.getElementById("menu");

    menubutton.addEventListener("click", function() {
        if (menu.classList.contains("show")) {
            menu.classList.remove("show");
            setTimeout(() => {
                menu.style.display = "none";
            }, 500); // アニメーションが終わるまで待つ
        } else {
            menu.style.display = "block";
            setTimeout(() => {
                menu.classList.add("show");
            }, 10); // display: block; が適用された後にクラスを追加
        }
    });
    
     document.addEventListener("click", function(event) {
        if (!menu.contains(event.target) && !menubutton.contains(event.target)) {
            // メニューとメニューアイコンの外側をクリックした場合にメニューを閉じる
            if (menu.classList.contains("show")) {
                menu.classList.remove("show");
                setTimeout(() => {
                    menu.style.display = "none";
                }, 500); // アニメーションが終わるまで待つ
            }
        }
    });
    
    
});
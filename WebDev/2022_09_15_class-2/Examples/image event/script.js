let btn = document.getElementById("btn1");
let image = document.getElementById("naruto");

function myfunc(e) {
    if(btn.innerText === "Before Learning JS"){
        image.src = "./legend.jpg";
        btn.innerText = "After Learning JS";
    }
    else{
        image.src = "./child.jpg";
        btn.innerText = "Before Learning JS";
    }
    
}

btn.addEventListener('click', myfunc);



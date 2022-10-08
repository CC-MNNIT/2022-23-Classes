//let btn1 = document.getElementsByClassName("testbtn");
let btn1 = document.getElementById("test1");
let btn2 = document.getElementsByClassName("testbyclass");
let example = document.getElementById("ex");

const heading = document.querySelector("h1");

example.addEventListener('click', myfunc);


btn1.addEventListener('click', myfunc);

for (var i = 0; i < btn2.length; i++) {
  btn2[i].addEventListener("mouseover", myfunc);
}

const nameInput = document.getElementById("name");

nameInput.addEventListener("keyup", function () {
  console.log(nameInput.value);
});
// btn2.addEventListener("mouseenter", myfunc);
//btn2.addEventListener('click', myfunc);

function myfunc(e) {
    console.log(e);
    alert("Hello World");
}

btn1.addEventListener("click", function () {
  console.log("you clicked me");
});
btn1.addEventListener("mousedown", function () {
  console.log("down");
});
btn1.addEventListener("mouseup", function () {
  console.log("up");
});

heading.addEventListener("mouseenter", function () {
  heading.classList.add("blue");
});
// heading.addEventListener("mouseleave", function () {
//   heading.classList.remove("blue");
// });
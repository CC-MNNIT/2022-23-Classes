function load_car() {
  // Creating Our XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Making our connection
  var url = "../data/car.html";
  xhr.open("GET", url, true);

  // function execute after request is successful
  xhr.onload = function () {
    console.log(this.responseText);
    document.getElementById("disp").innerHTML = this.responseText;
  };
  // Sending our request
  xhr.send();
}

function load_bus() {
  // Creating Our XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Making our connection
  var url = "../data/bus.html";
  xhr.open("GET", url, true);

  // function execute after request is successful
  xhr.onload = function () {
    console.log(this.responseText);
    document.getElementById("disp").innerHTML = this.responseText;
  };
  // Sending our request
  xhr.send();
}

function load_cycle() {
  // Creating Our XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Making our connection
  var url = "../data/cycle.html";
  xhr.open("GET", url, true);

  // function execute after request is successful
  xhr.onload = function () {
    console.log(this.responseText);
    document.getElementById("disp").innerHTML = this.responseText;
  };
  // Sending our request
  xhr.send();
}

function clearScreen() {
  document.getElementById("disp").innerText = "";
}

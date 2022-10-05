function load(callback, url){
  callback(url)
  alert(url+ " has been loaded. Click ok to display");
}

function ajax_loader(url) {
  // Creating Our XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Making our connection
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

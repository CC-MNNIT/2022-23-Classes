async function load(url) {
  const response = await fetch(url);
  console.log(response);
  if(response.status === 200){
    const data = await response.text();
    document.getElementById("disp").innerHTML = data;
  } else{
    alert("error with error code : " + errCode);
  }
}
function clearScreen() {
  document.getElementById("disp").innerText = "";
}

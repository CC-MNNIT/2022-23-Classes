const num = 5;

if(num > 5){
    console.log("if got executed");
} else if(num < 5){
    console.log("1st else if got executed");
} else {
    console.log("else got executed");
}


const numbers = [90, 45, 15, 60, 30, 75];

for(let i = 0; i<numbers.length; i++){
    console.log(numbers[i]);
}

for(x in numbers){
    console.log(numbers[x]);
}

numbers.forEach(e => {
    console.log(e);
})

for (let x of numbers) {
  console.log(x);
}

let i=0;
while (i < numbers.length) {
  console.log(numbers[i]);
  i++;
}

do {
  console.log(numbers[i-1]);
} while (i < numbers.length);


//Functions
function square(x) {
    return x*x;
}

console.log(square(4));
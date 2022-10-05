const calculator = (x, y, operation, display_callback) => { 
    const result = operation(x, y);
    display_callback(result);
}

const alert_displayer = (output) => {
    alert(output);
}

const console_displayer = (output) => {
    console.log(output);
}

const html_displayer = (output) => {
    document.getElementById("disp").innerText = output
}

const sum = (x, y) => {
    return x+y;
}

const multiply = (x, y) => {
    return x*y;
}

const divide = (x, y) => {
    return x/y;
}

const subtract = (x, y) => {
    return x-y;
}
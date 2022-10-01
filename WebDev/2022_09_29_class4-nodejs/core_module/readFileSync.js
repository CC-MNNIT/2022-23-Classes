const fs = require("fs");

var text = fs.readFileSync("sample.json", "utf-8");
console.log(text);
console.log(`Organization: ${text.organization}; Location: ${text.location}`);
const fs = require("fs");

// reads the file sample.json
fs.readFile("sample.json", "utf-8", fileOutputHandler);

function fileOutputHandler(error, text) {
    if(error) console.log(error);
    else {
        console.log(text);
        console.log(`Organization: ${text.organization}; Location: ${text.location}`);
    }
}
/*
Example of a web app, which prints anything that it gets from a localhost network page.

 */

const express = require('express'),
    app = express(),
    bodyParser = require("body-parser"),
    LCD = require("../../LCD.js");

LCD.init(); //initialize display
LCD.autoNextRow = true;

app.get('/', (req, res) => {
    res.sendFile(__dirname + "/index.html");
});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post("/reset", async function (req, res) { //reset button
    LCD.init();
    res.sendFile(__dirname + "/index.html");
});

app.post("/", (req, res) => { //if written in textbox
    let response = "";
    req.on('data', function (text) {
        response += text;
    });
    req.on('end', async function () {
        await LCD.clear();
        await LCD.writeText(response); //add text to screen
        res.end(); //ready
    });
});

app.listen(8080);

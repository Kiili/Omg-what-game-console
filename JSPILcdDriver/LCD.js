
const Gpio = require("onoff").Gpio;

/**
 * This describes all pin numbers connected to the LCD from raspberryPI.
 */
var DB4 = new Gpio(2, 'out'),
    DB5 = new Gpio(18, 'out'),
    DB6 = new Gpio(15, 'out'),
    DB7 = new Gpio(14, 'out'),
    ENABLE = new Gpio(3, 'out'),
    RS = new Gpio(4, 'out'),
    RW = new Gpio(17, 'out'),
    charAmt = 0,
    cursorPos = 0;

module.exports = {

    /**
     * Toggles changing row automatically when writing text.
     */
    autoNextRow: this.var = true,

    /**
     * Helper function
     */
    strToChar: function (str) { //converts text to a custom character array
        let char = [];

        for (let i = 0; i < str.length; i++) {
            //check where new row starts
            if (str.charAt(i) == "B") {
                let row = new Uint8Array(5);
                for (let j = 0; j < 5; j++) {
                    if (str.charAt(i + j + 1) == "B") {
                        j = 5;
                    } else {
                        row[j] = parseInt(str.charAt(i + j + 1));
                    }

                }
                char.push(row);
            }
        }
        return char;
    },

    /**
     * Creating custom chars:
     * each character has 8 rows, 5 columns
     * B indicates next row. Total of 8 rows.
     * 1-s and 0-s after each row indicate, is pixel active or not.
     * The last row should always have all columns described.
     *
     * "B00000B00000B00000B00000B00000B00000B00000B00000" -> empty(space) character [same as "BBBBBBBB00000"]
     * "B11111B11111B11111B11111B11111B11111B11111B11111" -> block(full) character
     *
     * https://maxpromer.github.io/LCD-Character-Creator/  - Can be used for design
     *
     * Each character is saved with a id. (starting from 1)
     * They can be printed as text:
     * "|[characterId]|"
     * for example
     * await LCD.text("|1|");
     * @param str Custom character string.
     * @returns {Promise} if the action is done.
     */
    customChar: function (str) { //creates a custom character at CGRAM address 0x40
        return new Promise(async function (resolve) {

            charAmt++;

            //create char array
            char = module.exports.strToChar(str);

            //create address according to empty CGRAM space
            let address = ((charAmt - 1) * 8).toString(2)
            while (address.length != 6) {
                address = "0" + address;
            }

            //set CGRAM address to (A, A, A, A, A, A, 1, 0) (0-63)
            await module.exports.command(
                parseInt(address.charAt(5)),
                parseInt(address.charAt(4)),
                parseInt(address.charAt(3)),
                parseInt(address.charAt(2)),
                parseInt(address.charAt(1)),
                parseInt(address.charAt(0)), 1, 0);


            //save character rows to CGRAM
            RS.writeSync(1);
            for (let i = 0; i < 8; i++) {
                await module.exports.command(char[i][4], char[i][3], char[i][2], char[i][1], char[i][0], 0, 0, 0);
            }
            RS.writeSync(0);
            await module.exports.clear();

            resolve();
        });
    },

    sleep: function (time) {
        return new Promise(async function (resolve) {
            setTimeout(() => {
                resolve();
            }, time);
        });
    },

    /**
     * Write text to screen including custom characters in the text. Characters dont need to be saved to the LCD.
     * "@cH[CustomCharacterText]" should be the format. For creating custom characters, look at function customChar.
     * For example:
     * await LCD.writeText("Hello, underscore@cHBBBBBBBB11111!"); -> "Hello, underscore_!"
     * @param str
     * @returns {Promise} if the action is done.
     */
    writeText: function (str) { //write text on screen, including custom chars, starting with "@cH"
        return new Promise(async function (resolve) {

            charAmt = 0;
            //search for custom characters
            for (let i = 0; i < str.length - 2; i++) {
                if (str.charAt(i) == "@" && str.charAt(i + 1) == "c" && str.charAt(i + 2) == "H") { //if "@cH", then see if its a custom char
                    let Bcount = 0;
                    for (let j = i; j < str.length; j++) {

                        //search for all B-s to see, where character description ends
                        if (str.charAt(j) == "B") {
                            Bcount++;
                        }
                        if (Bcount == 8) { //if all B-s are found
                            for (let k = 0; k < 5; k++) { //check how many digits from last "B" are present
                                if (str.charAt(j + 1 + k) != "0" && str.charAt(j + 1 + k) != "1") { //if there are 0-4 digits
                                    //create custom character. End where last digit is.
                                    await module.exports.customChar(str.substring(i + 3, j + 1 + k));

                                    //replace char code with char index for easier managing
                                    str = str.replace(str.substring(i, j + 1 + k), "|" + charAmt + "|")

                                    //end loops
                                    j = str.length;
                                    k = 5;
                                    
                                } else if (k == 4) { //if all 5 digits are present
                                    //create custom character
                                    await module.exports.customChar(str.substring(i + 3, j + 6));

                                    //replace char code with char index for easier managing
                                    str = str.replace(str.substring(i, j + 6), "|" + charAmt + "|")

                                    j = str.length; //end loop
                                }
                            }
                        }
                    }
                }
            }
            await module.exports.text(str);
            resolve();
        });
    },

    /**
     * Sets the current cursor location.
     * @param row Row number. (0 or 1)
     * @param col Column number. (0 - 15)
     * @returns {Promise} if the action is done.
     */
    cursor: function (row, col){
        return new Promise(async function (resolve) {
            col = col.toString(2); //to Binary
            while(col.length < 4){
                col = "0" + col;
            }
            await module.exports.command(
                parseFloat(col.charAt(3)),
                parseFloat(col.charAt(2)),
                parseFloat(col.charAt(1)),
                parseFloat(col.charAt(0)), 0, 0, row, 1);

            resolve();
        });
    },

    /**
     * Shift display to: ("L" or "R") - left, right accordingly
     */
    displayShift: function(dir) {
        return new Promise(async function (resolve) {
            if(dir == "R"){
                await module.exports.command(0, 0, 1, 1, 1, 0, 0, 0, 0);
                resolve();
            }else if(dir == "L"){
                await module.exports.command(0, 0, 0, 1, 1, 0, 0, 0, 0);
                resolve();
            }
        });
    },

    /**
     * Shift cursor to: ("L" or "R") - left, right accordingly
     */
    cursorShift: function(dir) {
        return new Promise(async function (resolve) {
            if(dir == "R"){
                await module.exports.command(0, 0, 1, 0, 1, 0, 0, 0, 0);
                resolve();
            }else if(dir == "L"){
                await module.exports.command(0, 0, 0, 0, 1, 0, 0, 0, 0);
                resolve();
            }
        });
    },

    /**
     * Writes text on the screen at current cursor position.
     * @param str text to write.
     * @returns {Promise} if the action is done.
     */
    text: function (str) {
        return new Promise(async function (resolve) {
            cursorPos = 0;
            for (let i = 0; i < str.length; i++) {

                //if a custom character is next
                if (str.charAt(i) == "|" && str.charAt(i + 2) == "|" && parseFloat(str.charAt(i + 1)) <= 8 && parseFloat(str.charAt(i + 1)) >= 1) {
                    
                    //address of needed custom char (0-7 in bin)
                    let address = (parseFloat(str.charAt(i + 1))-1).toString(2); 
                    while(address.length < 3){
                        address = "0" + address;
                    }
                    
                    //add char to screen
                    RS.writeSync(1);
                    await module.exports.command(
                        parseFloat(address.charAt(2)), 
                        parseFloat(address.charAt(1)), 
                        parseFloat(address.charAt(0)),0, 0, 0, 0, 0);
                    RS.writeSync(0);

                    //cut the |x| out of text
                    str = str.replace(str.substring(i, i + 2), "");

                } else {
                    //get binary values from characters
                    let bin = str.charCodeAt(i).toString(2);

                    //set all bytes to have 8 bits
                    while (bin.length != 8) {
                        bin = "0" + bin;
                    }

                    //write characters to LCD
                    RS.writeSync(1);
                    await module.exports.command(
                        parseInt(bin.charAt(7)),
                        parseInt(bin.charAt(6)),
                        parseInt(bin.charAt(5)),
                        parseInt(bin.charAt(4)),
                        parseInt(bin.charAt(3)),
                        parseInt(bin.charAt(2)),
                        parseInt(bin.charAt(1)),
                        parseInt(bin.charAt(0)));
                    RS.writeSync(0);
                }

                //move cursor after writing
                cursorPos++;

                if (cursorPos == 16 && module.exports.autoNextRow) { //if first line full, go to 2nd
                    await module.exports.cursor(1, 0);
                }
                if (cursorPos == 80 && module.exports.autoNextRow) { //if screen full
                    i = str.length;
                }

            }
            resolve();
        });

    },

    /**
     * Initializes the display in 4-bit operating mode.
     * @returns {Promise} if the action is done.
     */
    init: function () { //initialize or reset display
        return new Promise(async function (resolve) {
            charAmt = 0;
            cursorPos = 0;
            //initialize 4bit mode
            module.exports.write(1, 1, 0, 0);
            await module.exports.enable(10);
            await module.exports.enable(10);
            await module.exports.enable(10);
            module.exports.write(0, 1, 0, 0);
            await module.exports.enable(10);

            await module.exports.command(1, 1, 0, 1, 0, 1, 0, 0); //initialize display

            await module.exports.display(true, true, true); //screen on

            await module.exports.clear();
            resolve();
        });
    },

    /**
     * Set LCD display operation mode.
     * @param toggle Toggle display.
     * @param cursor Toggle cursor.
     * @param blink Toggle cursor blink.
     * @returns {Promise} if the action is done.
     */
    display: function (toggle, cursor, blink){
        return new Promise(async function (resolve) {
            await module.exports.command(
                blink ? 1 : 0,
                cursor ? 1 : 0,
                toggle ? 1 : 0, 1, 0, 0, 0, 0);
            resolve();
        });
    },

    /**
     * Clears the screen.
     * @returns {Promise} if the action is done.
     */
    clear: function () { //clear screen, return cursor
        return new Promise(async function (resolve) {
            await module.exports.command(1, 0, 0, 0, 0, 0, 0, 0)
            resolve();
        });
    },

    /**
     * Sends an enable signal to the display.
     * @param delay The time that pin is enabled
     * @returns {Promise} if the action is done.
     */
    enable: function (delay = 0.5) {
        return new Promise(resolve => {
            setTimeout(() => {
                ENABLE.writeSync(1);
                setTimeout(() => {
                    ENABLE.writeSync(0);
                    resolve();
                }, delay);
            }, delay);
        })

    },

    /**
     * Helper function for the 4-bit control method.
     */
    write: function (a, b, c, d) { //set pin states
        DB4.writeSync(a);
        DB5.writeSync(b);
        DB6.writeSync(c);
        DB7.writeSync(d);
    },

    /**
     * Sends an 8-bit signal to the display. DB0-DB8 accordingly
     * @returns {Promise} if the action is done.
     */
    command: function (DB0, DB1, DB2, DB3, DB4, DB5, DB6, DB7) {
        return new Promise(async function (resolve) {
            module.exports.write(DB4, DB5, DB6, DB7); //first DB4-DB7
            await module.exports.enable();
            module.exports.write(DB0, DB1, DB2, DB3); //then DB0-DB3
            await module.exports.enable();
            resolve();
        });
    }
};

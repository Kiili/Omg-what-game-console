/*
Example of a console game, with animations of a guy jumping over obstacles, that are moving towards him.
 */

const LCD = require("../../LCD.js");
const readline = require("readline");

//custom chars
let human1 = "B00110B00110B11101B10111B00100B01110B10010B10010";
let human2 = "B00110B00110B01100B01110B00100B01100B01100B01100";
let ground = "BBBBBBBB11111";
let spike = "B001B0111B001B001B001B001B0111B11111"
let jump1 = "BBBBB00110B00110B11101B01111";
let jump2 = "B00100B00100B01110B11010B00110BBB11111";
let death = "B11111B10101B11111B01110B00000B01010B00100B01010";

let spikes = [];

let jump = 0;
let alive = true;
let score = 0;
let speed = 200;

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

run();
input();

async function run() {
    await LCD.init();
    await LCD.display(true, false, false); //disable cursor
    
    //make custom chars
    await LCD.customChar(human1);//1
    await LCD.customChar(human2);//2
    await LCD.customChar(ground);//3
    await LCD.customChar(spike);//4
    await LCD.customChar(jump1);//5
    await LCD.customChar(jump2);//6
    await LCD.customChar(death);//7

    //game loop
    while (alive) {
        score++;

        await LCD.sleep(speed);

        if (jump == 0) { //draw human, if not jumping
            await LCD.cursor(0, 0);
            await LCD.text(" ");
            await LCD.cursor(1, 0);
            await LCD.text("|2|");
            await LCD.sleep(speed);
            await LCD.cursorShift("L");
            await LCD.text("|1|");
        } else if (jump == 2) { //draw human while midair
            await LCD.sleep(speed);
            await LCD.cursor(1, 0);
            await LCD.text(" ");
            await LCD.cursor(0, 0);
            await LCD.text("|1|");
            jump--;
        } else { // draw human while jumping animation
            await LCD.sleep(speed);
            await LCD.cursor(0, 0);
            await LCD.text("|5|");
            await LCD.cursor(1, 0);
            await LCD.text("|6|");
            jump--;
        }

        //show score
        await LCD.cursor(0, 12);
        await LCD.text(score.toString());


        //draw ground and spikes
        await LCD.cursor(1, 0);
        for (let i = 0; i < 16; i++) {

            //if human not jumping, dont draw ground/spike under him
            if (i == 0 && jump != 1) {
                i++;
                await LCD.cursorShift("R");
            }

            //if no spikes
            if (spikes.length == 0) {
                await LCD.text("|3|");
            }

            for (let j = 0; j < spikes.length; j++) {
                if (i == spikes[j]) { //if a spike is on i
                    await LCD.text("|4|");
                    j = spikes.length;
                } else if (j == spikes.length - 1) { //if no spikes on i, draw ground
                    await LCD.text("|3|");
                    j = spikes.length;
                }
            }
        }

        //spawn spikes randomly
        if (Math.random() < 0.1) spikes.push(15);


        for (let i = 0; i < spikes.length; i++) {
            
            if (spikes[i] == 0) { //if spike at human
                spikes.splice(i, 1); //remove
                if (jump != 1) { //if human isnt jumping, end game
                    //end loop & add death character
                    alive = false;
                    await LCD.cursor(1, 0);
                    await LCD.text("|7|");

                    //game over sign
                    await LCD.cursor(0, 0);
                    await LCD.text("      GAME OVER!");

                    //score text
                    await LCD.cursor(1, 6);
                    await LCD.text("SCORE:" + score + "         ");
                }
            }
            spikes[i]--; //all spikes get closer to human
        }
    }
}

function input(){ //take output from terminal

    rl.question("", (a) => { //if enter is pressed
        
        if(!alive){ //on death, reset all
            alive = true;
            score = 0;
            jump = 0;
            spikes = [];
            run();
        }else if (jump == 0) { //jump if not jumping already
            score++;
            jump = 3;
        }

        input(); //wait for another input
    });
}

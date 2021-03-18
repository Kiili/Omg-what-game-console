import java.util.Random;
import java.util.Scanner;
public class ClassMain {
    public static void main(String args[]){
        System.out.println("Tere.");
        System.out.println("Mis su nimi on?");
        Scanner poop = new Scanner(System.in);
        String nimi = poop.nextLine();
        System.out.print("Meeldiv tutvuda, ");
        System.out.print(nimi);
        System.out.println(".");
        System.out.println("Kui vana sa oled?");
        Scanner reeet = new Scanner(System.in);
        int vanus = reeet.nextInt();
        if (vanus < 3){
            System.out.println("Ohoh, sa oled alles väga noor!");
        }else{if (vanus < 7){
            System.out.println("Head lasteaeda :)");
        }else{if (vanus < 18){
            System.out.println("Head kooli :/");
        }else{if (vanus < 30){
            System.out.println("Head töölkäimist! :/");
        }else{if (vanus < 50){
            System.out.println("Head töölkäimist! :/");
        }else{if (vanus < 70){
            System.out.println("Vanadus tuleb..");
        }else{if (vanus <= 100){
            System.out.println("Oled juba väga väga vana :O");
        }else{if (vanus > 100){
            System.out.println("Elad päris hästi..");
        }else{
        }	}	}	}	}	}	}	}
        System.out.println("Kui palju raha sul on?");
        Scanner papp = new Scanner(System.in);
        int raha = papp.nextInt();
        System.out.println("Väga tore.");
        int staatus = 1;
        int j=0, s=0, p=0, t=0, ja=0, a=0, uhd=0, m=0, i=0, v=0, r=0, svaike=0;
        double maksta = 0;
        int laen = 0;
        int kell = 12;
        int xp = 0;
        int tunne = 100;
        String nagu = ":D";
        int päev = 1;
        do{	staatus = 0;
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(60);
            if (kell > 23){kell = 0;päev++;}else{}
            if (tunne <= 0){
                System.out.println("Su enesetunne oli liiga madal.");
                System.out.println("Sa surid ära x(");
            }else{}
            if (tunne > 100){tunne = 100;}else{}
            if (tunne >= 90){
                nagu = ":D";
            }else{}
            if (tunne < 90){
                nagu = ":)";
            }else{}
            if (tunne < 60){
                nagu = ":/";
            }else{}
            if (tunne < 40){
                nagu = ":(";
            }else{}
            if (tunne < 20){
                nagu = ":'(";
            }else{}
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("                 Enesetunne: "+ tunne +" "+ nagu);
            if (kell > 9){
                if (randomInt < 10){
                    System.out.println("                 Päev "+päev+"  Kell "+kell+":0"+randomInt);
                }else{System.out.println("                 Päev "+päev+"  Kell "+kell+":"+randomInt);}
            }else{
                if (randomInt < 10){
                    System.out.println("                 Päev "+päev+"  Kell 0"+kell+":0"+randomInt);
                }else{System.out.println("                 Päev "+päev+"  Kell 0"+kell+":"+randomInt);}
            }
            System.out.println("                 "+xp+"xp   "+raha+"€");
            System.out.println("                 Kas soovid midagi?");
            System.out.println("                 Kalkulaator    (1)");
            System.out.println("                 Pood           (2)");
            System.out.println("                 Pank           (3)");
            System.out.println("                 Raha teenida   (4)");
            System.out.println("                 Magada         (5)");
            System.out.println("                 Info enda kohta(6)");
            System.out.println("                 Midagi teha    (7)");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            Scanner huuba = new Scanner(System.in);
            int numberr = huuba.nextInt();
            if (numberr == 1){
                kell++;
                System.out.print("Tere. Ma olen kalkulaator.");
                System.out.println("Ütle, kas tahad ");
                System.out.println("liita(1) lahutada(2) korrutada(3) või jagada(4)");
                Scanner tehe = new Scanner(System.in);
                int number = tehe.nextInt();
                if (number < 1){
                    System.out.println("Sisestasid vale arvu.");
                    staatus = 1;
                }else{
                    if (number > 4){
                        System.out.println("Sisestasid vale arvu.");
                        staatus = 1;
                    }else{System.out.println("Sisesta 2 arvu.");
                        Scanner arvsc1 = new Scanner(System.in);
                        Double arv1 = arvsc1.nextDouble();
                        Scanner arvsc2 = new Scanner(System.in);
                        Double arv2 = arvsc2.nextDouble();
                        if (number == 1){System.out.println(arv1 + arv2);staatus = 1;}else{staatus = 1;}
                        if (number == 2){System.out.println(arv1 - arv2);staatus = 1;}else{staatus = 1;}
                        if (number == 3){System.out.println(arv1 * arv2);staatus = 1;}else{staatus = 1;}
                        if (number == 4){System.out.println(arv1 / arv2);staatus = 1;}else{staatus = 1;}}}
            }else{}
            if (numberr == 2){
                kell++;
                System.out.println("Sisenesid poodi.");
                System.out.println("Mida soovid osta?");
                System.out.println(" ");
                System.out.println("Jäätis         (1) 2€");
                System.out.println("Suur kommikarp (2) 5€");
                System.out.println("Pall           (3) 15€");
                System.out.println("Teler          (4) 50€");
                System.out.println("Jalgratas      (5) 120€");
                System.out.println("Arvuti         (6) 700€");
                System.out.println("4k UHD Teler   (7) 1 500€");
                System.out.println("Moodne auto    (8) 9 000€");
                System.out.println("Ilus maja      (9) 26 000€");
                System.out.println("Villa          (10)92 000€");
                System.out.println("Reis Mars'ile  (11)72 666 000€");
                System.out.println("Ma ei soovi midagi osta. (12)");
                System.out.println(" ");
                System.out.println("Kirjuta valiku number.");
                Scanner vuuk = new Scanner(System.in);
                int nomero = vuuk.nextInt();
                if (nomero == 1){
                    if (raha >= 2){
                        System.out.println("Soovite osta jäätist. Kas olete kindel?");
                        Scanner verify1 = new Scanner(System.in);
                        String v1 = verify1.nextLine();
                        if (v1.equals("jah")){System.out.println("Ostsite jäätise.");staatus = 1;
                            raha-=2;j++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 2){
                    if (raha >= 5){
                        System.out.println("Soovite osta suurt kommikarpi. Kas olete kindel?");
                        Scanner verify2 = new Scanner(System.in);
                        String v2 = verify2.nextLine();
                        if (v2.equals("jah")){System.out.println("Ostsite suure kommikarbi.");staatus = 1;
                            raha-=5;s++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 3){
                    if (raha >= 15){
                        System.out.println("Soovite osta palli. Kas olete kindel?");
                        Scanner verify3 = new Scanner(System.in);
                        String v3 = verify3.nextLine();
                        if (v3.equals("jah")){System.out.println("Ostsite palli.");staatus = 1;
                            raha-=15;p++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 4){
                    if (raha >= 50){
                        System.out.println("Soovite osta telerit. Kas olete kindel?");
                        Scanner verify4 = new Scanner(System.in);
                        String v4 = verify4.nextLine();
                        if (v4.equals("jah")){System.out.println("Ostsite teleri.");staatus = 1;
                            raha-=50;t++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 5){
                    if (raha >= 120){
                        System.out.println("Soovite osta jalgratastt. Kas olete kindel?");
                        Scanner verify5 = new Scanner(System.in);
                        String v5 = verify5.nextLine();
                        if (v5.equals("jah")){System.out.println("Ostsite jalgratta.");staatus = 1;
                            raha-=120;ja++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 6){
                    if (raha >= 700){
                        System.out.println("Soovite osta arvutit. Kas olete kindel?");
                        Scanner verify6 = new Scanner(System.in);
                        String v6 = verify6.nextLine();
                        if (v6.equals("jah")){System.out.println("Ostsite arvuti.");staatus = 1;
                            raha-=700;a++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 7){
                    if (raha >= 1500){
                        System.out.println("Soovite osta 4k UHD telerit. Kas olete kindel?");
                        Scanner verify7 = new Scanner(System.in);
                        String v7 = verify7.nextLine();
                        if (v7.equals("jah")){System.out.println("Ostsite 4k UHD teleri.");staatus = 1;
                            raha-=1500;uhd++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 8){
                    if (raha >= 9000){
                        System.out.println("Soovite osta moodsat autot. Kas olete kindel?");
                        Scanner verify8 = new Scanner(System.in);
                        String v8 = verify8.nextLine();
                        if (v8.equals("jah")){System.out.println("Ostsite moodsa auto.");staatus = 1;
                            raha-=9000;m++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 9){
                    if (raha >= 26000){
                        System.out.println("Soovite osta ilusat maja. Kas olete kindel?");
                        Scanner verify9 = new Scanner(System.in);
                        String v9 = verify9.nextLine();
                        if (v9.equals("jah")){System.out.println("Ostsite ilusa maja.");staatus = 1;
                            raha-=26000;i++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 10){
                    if (raha >= 92000){
                        System.out.println("Soovite osta villat. Kas olete kindel?");
                        Scanner verify10 = new Scanner(System.in);
                        String v10 = verify10.nextLine();
                        if (v10.equals("jah")){System.out.println("Ostsite villa.");staatus = 1;
                            raha-=92000;v++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 11){
                    if (raha >= 72666000){
                        System.out.println("Soovite osta reisi Mars'ile. Kas olete kindel?");
                        Scanner verify11 = new Scanner(System.in);
                        String v11 = verify11.nextLine();
                        if (v11.equals("jah")){System.out.println("Ostsite reisi Mars'ile.");staatus = 1;
                            raha-=72666000;r++;}else{staatus = 1;}
                    }else{System.out.println("Sul ei ole piisavalt raha.");staatus = 1;}
                }else{}
                if (nomero == 12){staatus = 1;}else{staatus = 1;}
            }else{}
            if (numberr == 3){
                kell++;
                System.out.println("Oled pangas.");
                if (maksta < 1){System.out.println("Sa pole pangale võlgu.");
                }else{System.out.println("Oled pangale võlgu "+maksta+"€");}
                System.out.println("");
                System.out.println("Võtan/tagastan laenu (1)");
                System.out.println("Väljun pangast       (2)");
                Scanner lipa = new Scanner(System.in);
                int jutaa = lipa.nextInt();
                if (jutaa == 1){
                    if (maksta < 1){
                        System.out.println("Kui võtate laenu, peate selle 10 päeva jooksul tagasi maksma.");
                        System.out.println("Muidu saate karistuse.");
                        System.out.println("Laenu intress on 5%");
                        System.out.println("Kui palju tahad laenuks võtta?");
                        Scanner lerts = new Scanner(System.in);
                        int liist = lerts.nextInt();
                        System.out.println("Kas olete kindel et tahate " + liist + "€ laenata?");
                        Scanner ciita = new Scanner(System.in);
                        String huuy = ciita.nextLine();
                        if (huuy.equals("jah")){
                            double laaks = liist;
                            laen+=laaks;
                            raha+=laen;
                            maksta = laen*1.05;
                            System.out.println(laen + "€ on laenatud. Teil on " + raha + "€");
                            staatus = 1;
                        }else{staatus = 1;}
                    }else{
                        System.out.println("Teil on laenu maksta "+ maksta + "€");
                        System.out.println("Palun ärge sente makske.");
                        System.out.println("Kui palju te tahate maksta?");
                        Scanner hayyu = new Scanner(System.in);
                        int maksanob = hayyu.nextInt();
                        maksta-=maksanob;
                        raha-=maksanob;
                        System.out.println("Makse sooritatud.");
                        staatus = 1;
                    }
                }else{staatus = 1;}
            }
            if (numberr == 4){
                System.out.println("Tahad raha teenida. Kuidas?");
                System.out.println("Korvilükkajana    (5h = 10€,   20xp) (1)");
                System.out.println("Koristajana       (3h = 12€,   25xp) (2)");
                System.out.println("Taksojuhina       (6h = 40€,   50xp) (3)");
                System.out.println("Õpetajana         (8h = 70€,   100xp)(4)");
                System.out.println("Uue firma loojana (8h = -20€,  800xp)(5)");
                System.out.println("Firma omanik      (6h = 150€,  220xp)(6)");
                System.out.println("Firma suurendajana(8h = -100€,2400xp)(7)");
                System.out.println("Suure firma omanik(4h = 600€,  300xp)(8)");
                System.out.println("Jumalana          (2h = 4200€, 420xp)(9)");
                System.out.println("Tagasi                               (10)");
                Scanner yuuk = new Scanner(System.in);
                int huuta = yuuk.nextInt();
                if (huuta == 1){
                    if (xp < 0){System.out.println("Sul on vaja selleks 0 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 5h?");
                        Scanner tööle1 = new Scanner(System.in);
                        String Tööle1 = tööle1.nextLine();
                        if (Tööle1.equals("jah")){
                            kell+=5;
                            xp+=20;
                            raha+=10;
                            System.out.println("Teenisid 10€");
                            tunne-=15;
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 2){
                    if (xp < 100){System.out.println("Sul on vaja selleks 100 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 3h?");
                        Scanner tööle2 = new Scanner(System.in);
                        String Tööle2 = tööle2.nextLine();
                        if (Tööle2.equals("jah")){
                            kell+=3;
                            xp+=25;
                            raha+=12;
                            tunne-=14;
                            System.out.println("Teenisid 12€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 3){
                    if (xp < 450){System.out.println("Sul on vaja selleks 450 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 6h?");
                        Scanner tööle3 = new Scanner(System.in);
                        String Tööle3 = tööle3.nextLine();
                        if (Tööle3.equals("jah")){
                            kell+=6;
                            xp+=50;
                            raha+=40;
                            tunne-=7;
                            System.out.println("Teenisid 40€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 4){
                    if (xp < 1200){System.out.println("Sul on vaja selleks 1200 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 8h?");
                        Scanner tööle4 = new Scanner(System.in);
                        String Tööle4 = tööle4.nextLine();
                        if (Tööle4.equals("jah")){
                            kell+=8;
                            xp+=100;
                            raha+=70;
                            tunne-=9;
                            System.out.println("Teenisid 70€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 5){
                    if (xp < 2400){System.out.println("Sul on vaja selleks 2400 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 8h?");
                        Scanner tööle5 = new Scanner(System.in);
                        String Tööle5 = tööle5.nextLine();
                        if (Tööle5.equals("jah")){
                            kell+=8;
                            xp+=800;
                            raha-=20;
                            tunne-=6;
                            System.out.println("Kaotasid 20€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 6){
                    if (xp < 12000){System.out.println("Sul on vaja selleks 12 000 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 6h?");
                        Scanner tööle6 = new Scanner(System.in);
                        String Tööle6 = tööle6.nextLine();
                        if (Tööle6.equals("jah")){
                            kell+=6;
                            xp+=220;
                            raha+=150;
                            tunne-=5;
                            System.out.println("Teenisid 150€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 7){
                    if (xp < 23000){System.out.println("Sul on vaja selleks 23 000 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 8h?");
                        Scanner tööle7 = new Scanner(System.in);
                        String Tööle7 = tööle7.nextLine();
                        if (Tööle7.equals("jah")){
                            kell+=8;
                            xp+=2400;
                            raha-=100;
                            tunne-=7;
                            System.out.println("Kaotasid 100€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 8){
                    if (xp < 78000){System.out.println("Sul on vaja selleks 78 000 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 4h?");
                        Scanner tööle8 = new Scanner(System.in);
                        String Tööle8 = tööle8.nextLine();
                        if (Tööle8.equals("jah")){
                            kell+=4;
                            xp+=300;
                            raha+=600;
                            tunne-=4;
                            System.out.println("Teenisid 600€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 9){
                    if (xp < 420420){System.out.println("Sul on vaja selleks 420 420 xp");
                        staatus = 1;
                    }else{
                        System.out.println("Kas oled kindel, et tahad töötata 2h?");
                        Scanner tööle9 = new Scanner(System.in);
                        String Tööle9 = tööle9.nextLine();
                        if (Tööle9.equals("jah")){
                            kell+=2;
                            xp+=420;
                            raha+=4200;
                            tunne-=2;
                            System.out.println("Teenisid 4200€");
                            staatus = 1;
                        }else{}
                    }
                }else{}
                if (huuta == 10){kell++; staatus = 1;}else{}
            }else{}
            if (numberr == 5){
                if (tunne == 100){
                    System.out.print("Sa ei suuda magama jääda");
                    kell++;
                    staatus = 1;
                }else{
                    System.out.print("Sa magasid 8h");
                    kell+=8;
                    tunne+=20;
                    staatus = 1;
                }
            }else{}
            if (numberr == 6){
                kell++;
                System.out.print("Sina, ");
                System.out.print(nimi);
                System.out.print(" oled ");
                System.out.print(vanus);
                System.out.println(" aastat vana.");
                System.out.println("Sul on:           "+raha+"€");
                System.out.println("Jäätiseid:        "+j);
                System.out.println("Suuri kommikarpe: "+s);
                System.out.println("Palle:            "+p);
                System.out.println("Telereid:         "+t);
                System.out.println("Jalgrattaid:      "+ja);
                System.out.println("4k UHD Telereid:  "+uhd);
                System.out.println("Moodsaid autosid: "+a);
                System.out.println("Ilusaid maju:     "+i);
                System.out.println("Villasid:         "+v);
                System.out.println("Reise Mars'ile:   "+r);
                staatus = 1;
            }else{}
            if (numberr == 7){
                System.out.println("Mis teha tahad?");
                System.out.println("Söön jäätise         (1)");
                System.out.println("Söön kommi           (2)");
                System.out.println("Mängin palli         (3)");
                System.out.println("Vaatan telekat       (4)");
                System.out.println("Lähen rattaga sõitma (5)");
                System.out.println("Vaatan telekat       (6)");
                System.out.println("Lähen autoga sõitma  (7)");
                System.out.println("Magan                (8)");
                System.out.println("Reisin MARSILE       (9)");
                System.out.println("Tagasi               (10)");
                Scanner puuyi = new Scanner(System.in);
                int munju = puuyi.nextInt();
                if(munju == 1){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{
                        System.out.println("Sõid jäätise");
                        tunne += 5;
                        j--;
                        kell++;
                        staatus = 1;
                    }
                }else if(munju == 2){
                    if(svaike == 0){
                        if(s == 0){
                            System.out.println("Sul pole :(");
                            staatus = 1;
                        }else{
                            svaike +=2;
                            System.out.println("Tegid karbi lahti ja sõid pooled ära");
                            svaike --;
                            s--;
                            tunne +=5;
                            kell++;
                            staatus = 1;
                        }
                    }else{
                        System.out.println("Sõid teise poole pakist ära");
                        svaike--;
                        tunne +=5;
                        kell++;
                        staatus = 1;
                    }
                }else if(munju == 3){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 4){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 5){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 6){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 7){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 8){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 9){
                    if(j == 0){
                        System.out.println("Sul pole :(");
                        staatus = 1;
                    }else{}


                }else if(munju == 10){
                    staatus = 1;
                }







                //SIIA PEAKS SOOMISE TELEKA VAATAMISE JNE TEGEMA
















            }else{staatus = 1;}
            if (numberr > 7){staatus = 1;}else{}
            if (numberr < 1){staatus = 1;}else{}
        }while(staatus == 1);
    }
}
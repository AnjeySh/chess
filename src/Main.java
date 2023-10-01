import java.awt.image.ImageProducer;
import java.util.Scanner;

public class Main {
    static String[][] map = {{"T","H","B","K","Q","B","H","T"},{"П","П","П","П","П","П","П","П"},{"_","_","_","_","_","_","_","_"},{"_","_","_","_","_","_","_","_"},{"_","_","_","_","_","_","_","_"},{"_","_","_","_","_","_","_","_"},{"П","П","П","П","П","П","П","П"},{"T","H","B","K","Q","B","H","T"}};
    static boolean sideStep = false;
    static int figure;
    static int ex;
    static String let;
    static int ig;
    static int bi, bj;
    static boolean CONTINUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Sides white, black;
        Sides[] sides = new Sides[2];
        sides[0] = new Sides(true);
        sides[1] = new Sides(false);


//        white = new Sides(false);
//        black = new Sides(true);


        CONTINUE = true;
        while(CONTINUE==true){
            show();
            if(sideStep){
                System.out.println("Ход Черных...                                   BLM хуев");
            } else {
                System.out.println("Ход Белых...                                 WHITE POWER");
            }
            figure = sc.nextInt();
            let = sc.next();
            ex = sc.nextInt();
            ig=Let_to_num(let);
//            ig = sc.nextInt();
            if(sideStep){
                sideSteping(sides[0],sides[1]);
            } else {
                sideSteping(sides[1],sides[0]);
            }
        }
        System.out.println("Fuck you");
        if(sideStep){
            System.out.println("Победа БЕЛЫХ                    ...власть белым");
        } else {
            System.out.println("Победа Черных                   ...как будто жизни черных важны ");
        }
    }
    public static void step(int bi, int bj, int i, int j, String let){
        map[i][j]=let;
        map[bi][bj]="-";
    }

    public static void show() {
        System.out.println("A    B    C    D    E    F    G    H");
        System.out.println();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(map[i][j]+"    ");
            }
            System.out.println(" "+i);
        }
    }
    public static void sideSteping(Sides side1, Sides side2){
        if(figure<8){
            if(side1.pawns[figure].status==true){
                bi=side1.pawns[figure].x; bj=side1.pawns[figure].y;
                if(side1.pawns[figure].step(ex,ig)){
                    step(bi,bj,ex,ig,"П");
                } else {
                    System.out.println("Недопустимый ход");
                    if(sideStep==false)
                        sideStep=true;
                    else sideStep=false;
                }
                side2.tryKill(ex,ig);
            }
        }
        switch (figure){
            case 8:
                if(side1.leftRook.status==true){
                    bi=side1.leftRook.x; bj=side1.leftRook.y;
                    if(side1.leftRook.step(ex,ig)){
                        step(bi,bj,ex,ig, "T");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 9:
                if(side1.rightRook.status==true){
                    bi=side1.rightRook.x; bj=side1.rightRook.y;
                    if(side1.rightRook.step(ex,ig)){
                        step(bi,bj,ex,ig, "T");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 10:
                if(side1.leftKnight.status==true){
                    bi=side1.leftKnight.x; bj=side1.leftKnight.y;
                    if(side1.leftKnight.step(ex,ig)){
                        step(bi,bj,ex,ig, "Г");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 11:
                if(side1.rightKnight.status==true) {
                    bi=side1.rightKnight.x; bj=side1.rightKnight.y;
                    if(side1.rightKnight.step(ex,ig)){
                        step(bi,bj,ex,ig, "Г");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 12:
                if(side1.leftBishop.status==true){
                    bi=side1.leftBishop.x; bj=side1.leftBishop.y;
                    if(side1.leftBishop.step(ex,ig)){
                        step(bi,bj,ex,ig, "B");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 13:
                if(side1.rightBishop.status==true){
                    bi=side1.rightBishop.x; bj=side1.rightBishop.y;
                    if(side1.rightBishop.step(ex,ig)){
                        step(bi,bj,ex,ig, "B");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 14:
                if(side1.queen.status==true) {
                    bi=side1.queen.x; bj=side1.queen.y;
                    if(side1.queen.step(ex,ig)){
                        step(bi,bj,ex,ig, "Q");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
            case 15:
                if(side1.king.status==true) {
                    bi=side1.king.x; bj=side1.king.y;
                    if(side1.king.step(ex,ig)){
                        step(bi,bj,ex,ig, "K");
                    }else {
                        System.out.println("Недопустимый ход");
                        if(sideStep==false)
                            sideStep=true;
                        else sideStep=false;
                    }
                }
                side2.tryKill(ex,ig);
                break;
        }
        if(side2.king.status==false){
            CONTINUE=false;
        }
        if(sideStep==false)
            sideStep=true;
        else sideStep=false;
    }
    public static int Let_to_num(String s){
        int num=0;
        switch (s){
            case "A":
                num=0;
                break;
            case "B":
                num=1;
                break;
            case "C":
                num=2;
                break;
            case "D":
                num=3;
                break;
            case "E":
                num=4;
                break;
            case "F":
                num=5;
                break;
            case "G":
                num=6;
                break;
            case "H":
                num=7;
                break;
            default:
                System.out.println("Неправильный ввод позиции фигуры");
                break;
        }
        return num;
    }
}

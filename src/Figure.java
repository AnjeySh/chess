import static java.lang.Math.abs;

public abstract class Figure{
    boolean status = true;
    void kill(int ex, int ig){
        if (ex==x&&ig==y){
            status=false;
        }
    }
    int x, y;
    boolean step(int let, int num){
        return false;
    }
}

class Pawn extends Figure{
    Pawn(int let, int num) {
            x=let;
            y=num;
    }

    @Override
    boolean step(int let, int num) {
        if(abs(let-x)==1&&((num==y+1||num==y-1)||num-y==0)){
            // НЕ ЗАБЫТЬ, Сделать так, чтобы у пешек черных передавалось отрицательное х
            x=let;  y=num;
            return true;
        } else return false;
    }
}
class Bishop extends Figure{
    Bishop(int let, int num) {
        x=let;
        y=num;
    }
    @Override
    boolean step(int let, int num) {
        if(abs(let-x)==abs(num-y)){
            x=let;  y=num;
            return true;
        } else return false;
    }
}
class Rook extends Figure{
    Rook(int let, int num) {
        x=let;
        y=num;
    }
    @Override
    boolean step(int let, int num) {
        if(let==x||num==y){
            x=let;  y=num;
            return true;
        } else return false;
    }
}
class King extends Figure{
    King(int let, int num) {
        x=let;
        y=num;
    }
    @Override
    boolean step(int let, int num) {
        if(abs(let-x)<=1&&abs(num-y)<=1){
            x=let;  y=num;
            return true;
        } else return false;
    }
}
class Queen extends Figure{
    Queen(int let, int num) {
        x=let;
        y=num;
    }
    @Override
    boolean step(int let, int num) {
        if((abs(let-x)==abs(num-y))||(let==x||num==y)){
            x=let;  y=num;
            return true;
        } else return false;
    }
}
class Knight extends Figure{
    Knight(int let, int num) {
        x=let;
        y=num;
    }
    @Override
    boolean step(int let, int num) {
        if((abs(let-x)==2&&abs(num-y)==1)||(abs(let-x)==1&&abs(num-y)==2)){
            x=let;  y=num;
            return true;
        } else return false;
    }
}
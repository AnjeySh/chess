public class Sides {
    Pawn[] pawns= new Pawn[8];
    Rook leftRook, rightRook;
    Knight leftKnight, rightKnight;
    Bishop leftBishop, rightBishop;
    King king;
    Queen queen;
    void tryKill(int ex, int ig){
        for(int i=0; i<pawns.length; i++){
            pawns[i].kill(ex,ig);
        }
        leftRook.kill(ex,ig);
        rightRook.kill(ex,ig);
        leftKnight.kill(ex,ig);
        rightKnight.kill(ex,ig);
        leftBishop.kill(ex,ig);
        rightBishop.kill(ex,ig);
        queen.kill(ex,ig);
        king.kill(ex,ig);
    }
    Sides(boolean side){
        int adder = 0, sideCoor = 0;
        if(side==true){
            adder=5;
            sideCoor = 7;
        }
        for(int i=0; i<8; i++){
            pawns[i] = new Pawn(1+adder, i);
        }
        leftRook = new Rook(sideCoor,0);
        rightRook = new Rook(sideCoor,7);
        leftKnight = new Knight(sideCoor, 1);
        rightKnight = new Knight(sideCoor, 6);
        leftBishop = new Bishop(sideCoor, 2);
        rightBishop = new Bishop(sideCoor,5);
        king = new King(sideCoor, 3);
        queen = new Queen(sideCoor, 4);
    }
}

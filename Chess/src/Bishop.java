class Bishop extends Piece{

    String name;

    Bishop(Position position) {
        super(position);
        this.name = "bishop";
    }

    boolean isValidMove(Position newPosition){
        if(!super.isValidMove(newPosition)){
            return false;
        }
        if(Math.abs(newPosition.column - position.column) == Math.abs(newPosition.row - position.row)){
            return true;
        }
        else{
            return false;
        }
    }
}
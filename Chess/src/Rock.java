class Rock extends Piece{

    String name;

    Rock(Position position) {
        super(position);
        this.name = "rock";
    }

    boolean isValidMove(Position newPosition){
        if(!super.isValidMove(newPosition)){
            return false;
        }
        if(newPosition.column == position.column || newPosition.row == position.row){
            return true;
        }
        else{
            return false;
        }
    }
}
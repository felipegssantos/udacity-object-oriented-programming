class Queen extends Piece {

    String name;

    Queen(Position position) {
        super(position);
        this.name = "queen";
    }

    boolean isValidMove(Position newPosition) {
        if(!super.isValidMove(newPosition)){
            return false;
        }
        if ((newPosition.column == position.column || newPosition.row == position.row)
            && Math.abs(newPosition.column - position.column) == Math.abs(newPosition.row - position.row)) {
            return true;
        } else {
            return false;
        }
    }
}

class Piece{
    Position position;

//    Piece() {
//        Position defaultPosition = new Position(0, 0);
//        new Piece(defaultPosition);
//    }

    Piece(Position position) {
        this.position = position;
    }

    boolean isValidMove(Position newPosition) {
        if(newPosition.row > 0 && newPosition.row < 8
           && newPosition.column > 0 && newPosition.column < 8) {
            return true;
        } else {
            return false;
        }
    }
}
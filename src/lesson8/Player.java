package lesson8;

public class Player {
    GameField gameField;
    char sign;
    public Player(char sign){
        this.sign = sign;
    }
    boolean turn(int x, int y){
        gameField = GameField.getInstance();
        if(gameField.isCellValid(x, y)){
            gameField.map[x][y] = sign;
            return true;
        }
        return false;
    }

    boolean win()
    {
        gameField = GameField.getInstance();
        return gameField.isWinner(this.sign);
    }
}

package lesson8;

import java.util.Random;

public class AI {
    GameField gameField;
    char sign;
    char playerSign;

    public AI(char sign, char playerSign){
        this.sign = sign;
        this.playerSign = playerSign;
    }

    boolean turn(){
        Random random = new Random();
        gameField = GameField.getInstance();
        int x = -1;
        int y = -1;
        boolean aiWin = false;
        boolean humanWin = false;

        for (int i = 0; i < gameField.winCon; i++) {
            for (int j = 0; j < gameField.winCon; j++) {
                if(gameField.isCellValid(i, j)){
                    gameField.map[i][j] = sign;
                    if (gameField.isWinner(sign)){
                        x = i;
                        y = j;
                        aiWin = true;
                    }
                    gameField.map[i][j] = gameField.DOT_EMPTY;
                }
            }
        }
        if(!aiWin){
            for (int i = 0; i < gameField.winCon; i++) {
                for (int j = 0; j < gameField.winCon; j++) {
                    if(gameField.isCellValid(i, j)){
                        gameField.map[i][j] = this.playerSign;
                        if (gameField.isWinner(this.playerSign)){
                            x = i;
                            y = j;
                            humanWin = true;
                        }
                        gameField.map[i][j] = gameField.DOT_EMPTY;

                    }
                }
            }
        }
        if (!aiWin && !humanWin) {
            do {
                x = random.nextInt(gameField.winCon);
                y = random.nextInt(gameField.winCon);

            } while (!gameField.isCellValid(x, y));
        }
        gameField.map[x][y] = sign;
        return true;
    }

    boolean win()
    {
        gameField = GameField.getInstance();
        return gameField.isWinner(this.sign);
    }
}

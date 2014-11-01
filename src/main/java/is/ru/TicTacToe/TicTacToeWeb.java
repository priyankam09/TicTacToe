package is.ru.TicTacToe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;
import is.ru.TicTacToe.TicTacToe;
public class TicTacToeWeb implements SparkApplication {
    public static void main(String[] args){
        staticFileLocation("/public");
        SparkApplication tictactoe = new TicTacToeWeb();
        String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }
        tictactoe.init();
    }

    private TicTacToe game;
    
    public void init() {
	   if(game == null) {
	       game = new TicTacToe();
        }
        post(new Route("/playGame") {
            @Override
            public Object handle(Request request, Response response) {
                game = new TicTacToe();
                return true;
            }
        });

        post(new Route("/id"){
            @Override
            public Object handle(Request request, Response response){
                Integer number = Integer.valueOf(request.queryParams("id"));

                if(game.isGameOver()) {
                    return game.whoIsWinner();
                }
                else {
                    return game.play(number);
                }
            }
        });

        post(new Route("/gameOver"){
            @Override
            public Object handle(Request request, Response response){
                if(game.isGameOver()) {
                    return game.whoIsWinner();
                }
                else{
                    return "";
                }
            }
        });
    }
}

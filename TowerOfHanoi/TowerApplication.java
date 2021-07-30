
package TowerOfHanoi;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class TowerApplication extends Application {

    public static final int PLAYING = 1;
    public static final int GAMEOVER = 2;
    public static final int Selecting = 0;
    private int status;
    private int numBlocks;
    private int moves;
    private int towerSelected;
    private int totalBLockHeight = 200; //from 250 to 50
    private int lowestBlockLocation = 250;
    private int maxBlockWidth = 100;
    private int minBlockWidth = 40;
    private int stackOneLocation = 92;  //only for reference dont change
    private int stackTwoLocation = 242; //only for reference dont change
    private int stackThreeLocation = 392; //only for reference dont change
    private boolean addBlocks = false;
    Canvas canvas;


    TowerStack<TowerBlock> towerOne = new TowerStack<>();
    TowerStack<TowerBlock> towerTwo = new TowerStack<>();
    TowerStack<TowerBlock> towerThree = new TowerStack<>();


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Tower of Hanoi");

        Group group = new Group();

        canvas = new Canvas(500, 300);

        Scanner scanner = new Scanner(System.in);
        while (status == Selecting) {
            System.out.println("How many blocks do you want to play with(3-7)");
            int s = scanner.nextInt();
            if (s >= 3 && s <= 7) {
                addBlocks = true;
                numBlocks = s;
                status = PLAYING;
            } else {
                System.out.println("Value inputted is not in the 3-7 range. Please select a value in the 3-7 range.");
            }

        }

        canvas.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                String keypress = event.getCharacter();
                int intKeypressed = Integer.parseInt(keypress);

                if ((intKeypressed == 1 || intKeypressed == 2 || intKeypressed == 3) && status == PLAYING) {

                    gamePlay(keypress);
                    isGameOver();
                }

                paint(canvas.getGraphicsContext2D());

            }
        });

        group.getChildren().add(canvas);

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        if (addBlocks) {
            addStackBlocks();
        }
        paint(canvas.getGraphicsContext2D());


        canvas.requestFocus();

        primaryStage.show();


    }

    private void reset() {

        status = Selecting;
        numBlocks = 0;

        for (int a = towerThree.size(); a > 0; a--) {

            towerThree.pop();
        }

    }

    private void addStackBlocks() {
        //adds blocks to first stack

        for (int x = numBlocks; x > 0; x--) {

            double blockHeight = totalBLockHeight / numBlocks;
            double blockWidthChange = (maxBlockWidth - minBlockWidth) / numBlocks;
            double blockWidth = minBlockWidth + ((x - 1) * blockWidthChange);

            TowerBlock newBlock = new TowerBlock(blockWidth, blockHeight, x);
            towerOne.push(newBlock);

        }
        addBlocks = false;

    }

    private void gamePlay(String keypress) {

        int intKeypress = Integer.parseInt(keypress);

        if (towerSelected == 0) {

            towerSelected = intKeypress;
        }



        if (towerSelected > 0) {


            if (towerSelected == 1 && towerSelected != intKeypress) {

                if (towerOne.size() == 0) {

                    towerSelected = 0;
                }

                if (intKeypress == 2) {

                    if (towerTwo.size() > 0) {
                        if (towerOne.peek().getBlockSize() < towerTwo.peek().getBlockSize()) {

                            TowerBlock movedBlock = towerOne.peek();
                            towerOne.pop();
                            towerTwo.push(movedBlock);
                            towerSelected = 0;
                        }
                    } else {
                        TowerBlock movedBlock = towerOne.peek();
                        towerOne.pop();
                        towerTwo.push(movedBlock);
                        towerSelected = 0;
                    }
                }
                if (intKeypress == 3) {

                    if (towerThree.size() > 0) {
                        if (towerOne.peek().getBlockSize() < towerThree.peek().getBlockSize()) {

                            TowerBlock movedBlock = towerOne.peek();
                            towerOne.pop();
                            towerThree.push(movedBlock);
                            towerSelected = 0;
                        }
                    } else {
                        TowerBlock movedBlock = towerOne.peek();
                        towerOne.pop();
                        towerThree.push(movedBlock);
                        towerSelected = 0;
                    }
                }

            }


            if (towerSelected == 2 && towerSelected != intKeypress) {

                if (towerTwo.size() == 0) {

                    towerSelected = 0;
                }

                if (intKeypress == 1) {

                    if (towerOne.size() > 0) {
                        if (towerTwo.peek().getBlockSize() < towerOne.peek().getBlockSize()) {

                            TowerBlock movedBlock = towerTwo.peek();
                            towerTwo.pop();
                            towerOne.push(movedBlock);
                            towerSelected = 0;
                        }
                    } else {
                        TowerBlock movedBlock = towerTwo.peek();
                        towerTwo.pop();
                        towerOne.push(movedBlock);
                        towerSelected = 0;
                    }
                }
                if (intKeypress == 3) {

                    if (towerThree.size() > 0) {
                        if (towerTwo.peek().getBlockSize() < towerThree.peek().getBlockSize()) {

                            TowerBlock movedBlock = towerTwo.peek();
                            towerTwo.pop();
                            towerThree.push(movedBlock);
                            towerSelected = 0;
                        }
                    } else {
                        TowerBlock movedBlock = towerTwo.peek();
                        towerTwo.pop();
                        towerThree.push(movedBlock);
                        towerSelected = 0;
                    }
                }

            }


            if (towerSelected == 3 && towerSelected != intKeypress) {

                if (towerThree.size() == 0) {

                    towerSelected = 0;
                }

                if (intKeypress == 1) {

                    if (towerOne.size() > 0) {
                        if (towerThree.peek().getBlockSize() < towerOne.peek().getBlockSize()) {

                            TowerBlock movedBlock = towerThree.peek();
                            towerThree.pop();
                            towerOne.push(movedBlock);
                            towerSelected = 0;
                        } else {
                            TowerBlock movedBlock = towerThree.peek();
                            towerThree.pop();
                            towerOne.push(movedBlock);
                            towerSelected = 0;
                        }
                    }
                }
                if (intKeypress == 2) {

                    if (towerTwo.size() > 0) {

                        if (towerThree.peek().getBlockSize() < towerTwo.peek().getBlockSize()) {

                            TowerBlock movedBlock = towerThree.peek();
                            towerThree.pop();
                            towerTwo.push(movedBlock);
                            towerSelected = 0;
                        }
                    } else {
                        TowerBlock movedBlock = towerThree.peek();
                        towerThree.pop();
                        towerTwo.push(movedBlock);
                        towerSelected = 0;
                    }
                }

            }

        }


    }

    private void isGameOver() {

        if (towerThree.size() == numBlocks) {
            status = GAMEOVER;
        }

    }

    private void paint(GraphicsContext gc) {

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 300);

        gc.setFill(Color.WHITE);
        gc.fillRect(85, 25, 15, 275);
        gc.fillRect(235, 25, 15, 275);
        gc.fillRect(385, 25, 15, 275);
        gc.fillRect(25, 250, 450, 50);

        if (towerSelected == 1) {
            gc.setFill(Color.GREEN);
            gc.fillRect(85, 25, 15, 275);
        }
        if (towerSelected == 2) {
            gc.setFill(Color.GREEN);
            gc.fillRect(235, 25, 15, 275);
        }
        if (towerSelected == 3) {
            gc.setFill(Color.GREEN);
            gc.fillRect(385, 25, 15, 275);
        }

        int blockLocationHeight1 = lowestBlockLocation;
        int blockLocationHeight2 = lowestBlockLocation;
        int blockLocationHeight3 = lowestBlockLocation;



        for (int a = towerOne.size() - 1; a >= 0; a--) {

            gc.setFill(Color.RED);
            gc.fillRect(stackOneLocation - ((towerOne.get(a).getBlockLength()) / 2), blockLocationHeight1 - towerOne.get(a).getBlockHeight(), towerOne.get(a).getBlockLength(), towerOne.get(a).getBlockHeight());

            blockLocationHeight1 -= towerOne.get(a).getBlockHeight();
        }

        for (int a = towerTwo.size() - 1; a >= 0; a--) {

            gc.setFill(Color.RED);
            gc.fillRect(stackTwoLocation - ((towerTwo.get(a).getBlockLength()) / 2), blockLocationHeight2 - towerTwo.get(a).getBlockHeight(), towerTwo.get(a).getBlockLength(), towerTwo.get(a).getBlockHeight());

            blockLocationHeight2 -= towerTwo.get(a).getBlockHeight();
        }

        for (int a = towerThree.size() - 1; a >= 0; a--) {

            gc.setFill(Color.RED);
            gc.fillRect(stackThreeLocation - ((towerThree.get(a).getBlockLength()) / 2), blockLocationHeight3 - towerThree.get(a).getBlockHeight(), towerThree.get(a).getBlockLength(), towerThree.get(a).getBlockHeight());

            blockLocationHeight3 -= towerThree.get(a).getBlockHeight();
        }

        if (status == GAMEOVER) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, 500, 300);
            gc.fillText("You Won in" + moves + "Moves!", 200, 100);
        }

    }

}


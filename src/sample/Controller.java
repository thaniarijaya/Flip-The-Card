package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Controller extends Function {
    //X=50, Y=10
    ArrayList<String> nameHighScore = new ArrayList<>();
    ArrayList<Integer> tenHighScore = new ArrayList<>();
    int movement = 0;
    String nama = "";
    ArrayList<Integer> openCard = new ArrayList<>();
    ArrayList<String> card = new ArrayList<>();

    @FXML
    TextField show, move, score;
    @FXML
    TextArea name, highScore;
    @FXML
    Button play, ok, showHS;
    @FXML
    Button zeroCard, oneCard, twoCard, threeCard, fourCard, fiveCard, sixCard, sevenCard, eightCard,
            nineCard, tenCard, elevenCard, twelveCard, thirteenCard, fourteenCard, fifteenCard;

    public void start (ActionEvent event) throws FileNotFoundException {
        win = 0;
        scoreTmp = 0;
        movement = 0;
        nama = "";
        openCard = new ArrayList<>();
        name.setText("");
        card = new ArrayList<>();
        show.setText("Please enter your name!");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/cakes.jpg");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/cakes.jpg");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/cupcakes.jpg");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/cupcakes.jpg");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/sandwich.jpg");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/sandwich.jpg");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/hamburger.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/hamburger.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/pizza.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/pizza.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/chicken.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/chicken.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/bread.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/bread.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/fries.png");
        card.add("D:\\Sem 2\\Praktikum\\Prak101/fries.png");

        open0 = false;
        open1 = false;
        open2 = false;
        open3 = false;
        open4 = false;
        open5 = false;
        open6 = false;
        open7 = false;
        open8 = false;
        open9 = false;
        open10 = false;
        open11 = false;
        open12 = false;
        open13 = false;
        open14 = false;
        open15 = false;

        FileInputStream input = new FileInputStream("D:\\Sem 2\\Praktikum\\Prak101/kartu belakang.png");
        Image image = new Image(input);
        one.setImage(image);
        zero.setImage(image);
        two.setImage(image);
        three.setImage(image);
        four.setImage(image);
        five.setImage(image);
        six.setImage(image);
        seven.setImage(image);
        eight.setImage(image);
        nine.setImage(image);
        ten.setImage(image);
        eleven.setImage(image);
        twelve.setImage(image);
        thirteen.setImage(image);
        fourteen.setImage(image);
        fifteen.setImage(image);

        String temp = "";
        for (int n = 0; n < tenHighScore.size(); n++) {
            temp += nameHighScore.get(n) + "\t" + tenHighScore.get(n) + "\n";
        }

        highScore.setText(temp);
        score.setText(String.valueOf(scoreTmp));
        move.setText(String.valueOf(movement));
    }

    public void enterName (ActionEvent event) {
        if (!name.getText().equalsIgnoreCase("")) {
            show.setText("Challenge Starts Now!");
            nama = name.getText();
            //mengacak kartu
            Collections.shuffle(card);
        }
    }

    public void printHS (ActionEvent event){
        String temp = "";
        for (int n = 0; n < tenHighScore.size(); n++) {
            temp += nameHighScore.get(n) + "\t" + tenHighScore.get(n) + "\n";
        }

        highScore.setText(temp);
    }

    public void clickZero (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open0 && !nama.equalsIgnoreCase("")) {
                openCard.add(0);
                String filename = card.get(0);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                zero.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickOne (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open1 && !nama.equalsIgnoreCase("")) {
                openCard.add(1);
                String filename = card.get(1);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                one.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));

                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);

                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }

            }
        }
    }

    public void clickTwo (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open2 && !nama.equalsIgnoreCase("")) {
                openCard.add(2);
                String filename = card.get(2);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                two.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }
                    score.setText(String.valueOf(scoreTmp));
                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                }

                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }

            }
        }
    }

    public void clickThree (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open3 && !nama.equalsIgnoreCase("")) {
                openCard.add(3);
                String filename = card.get(3);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                three.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);

                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickFour (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open4 && !nama.equalsIgnoreCase("")) {
                openCard.add(4);
                String filename = card.get(4);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                four.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickFive (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open5 && !nama.equalsIgnoreCase("")) {
                openCard.add(5);
                String filename = card.get(5);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                five.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickSix (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open6 && !nama.equalsIgnoreCase("")) {
                openCard.add(6);
                String filename = card.get(6);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                six.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickSeven (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open7 && !nama.equalsIgnoreCase("")) {
                openCard.add(7);
                String filename = card.get(7);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                seven.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickEight (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open8 && !nama.equalsIgnoreCase("")) {
                openCard.add(8);
                String filename = card.get(8);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                eight.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickNine (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open9 && !nama.equalsIgnoreCase("")) {
                openCard.add(9);
                String filename = card.get(9);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                nine.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickTen (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open10 && !nama.equalsIgnoreCase("")) {
                openCard.add(10);
                String filename = card.get(10);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                ten.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickEleven (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open11 && !nama.equalsIgnoreCase("")) {
                openCard.add(11);
                String filename = card.get(11);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                eleven.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickTwelve (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open12 && !nama.equalsIgnoreCase("")) {
                openCard.add(12);
                String filename = card.get(12);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                twelve.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickThirteen (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open13 && !nama.equalsIgnoreCase("")) {
                openCard.add(13);
                String filename = card.get(13);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                thirteen.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickFourteen (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open14 && !nama.equalsIgnoreCase("")) {
                openCard.add(14);
                String filename = card.get(14);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                fourteen.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }

    public void clickFifteen (ActionEvent event) throws FileNotFoundException {
        if (win < 8) {
            if (!open15 && !nama.equalsIgnoreCase("")) {
                openCard.add(15);
                String filename = card.get(15);
                FileInputStream input1 = new FileInputStream(filename);
                Image image1 = new Image(input1);
                fifteen.setImage(image1);
                check(openCard);
                if (openCard.size() == 2) {
                    movement++;
                    move.setText(String.valueOf(movement));
                    if (card.get(openCard.get(0)).equalsIgnoreCase(card.get(openCard.get(1)))) {
                        equals(card, openCard);
                    } else {
                        scoreTmp -= 10;
                    }

                    score.setText(String.valueOf(scoreTmp));

                } else if (openCard.size() == 3) {
                    flipTheCard(openCard);
                    for (int n = 0; n < openCard.size(); n++) {
                        System.out.println(openCard.get(n));
                        System.out.println();
                    }
                }
                if (win == 8) {
                    tenHighScore.add(scoreTmp);
                    nameHighScore.add(nama);

                    sort(tenHighScore, nameHighScore);

                    if (tenHighScore.size() > 10) {
                        tenHighScore.remove(10);
                    }

                    if (tenHighScore.get(0) == scoreTmp) {
                        show.setText("Congratulations, you break the high score! Press the play button to reset the game!");
                    } else {
                        show.setText("You win! Press the play button to reset the game!");
                    }
                }
            }
        }
    }
}

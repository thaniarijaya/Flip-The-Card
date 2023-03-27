package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Function {
    @FXML
    ImageView zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen;

    int win = 0;
    int scoreTmp = 0;
    boolean open0, open1, open2, open3, open4, open5, open6, open7, open8, open9, open10, open11, open12,
            open13, open14, open15 = false;

    public void flipTheCard(ArrayList<Integer> a) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("D:\\Sem 2\\Praktikum\\Prak101/kartu belakang.png");
        Image image = new Image(input);

        //menutup kartu
        for (int n = 0; n < 2; n++) {
            if (a.get(n) == 0 && !open0) {
                zero.setImage(image);
            }else if (a.get(n) == 1 && !open1) {
                one.setImage(image);
            } else if (a.get(n) == 2 && !open2) {
                two.setImage(image);
            } else if (a.get(n) == 3 && !open3) {
                three.setImage(image);
            } else if (a.get(n) == 4 && !open4) {
                four.setImage(image);
            } else if (a.get(n) == 5 && !open5) {
                five.setImage(image);
            } else if (a.get(n) == 6 && !open6) {
                six.setImage(image);
            } else if (a.get(n) == 7 && !open7) {
                seven.setImage(image);
            } else if (a.get(n) == 8 && !open8) {
                eight.setImage(image);
            } else if (a.get(n) == 9 && !open9) {
                nine.setImage(image);
            } else if (a.get(n) == 10 && !open10) {
                ten.setImage(image);
            } else if (a.get(n) == 11 && !open11) {
                eleven.setImage(image);
            } else if (a.get(n) == 12 && !open12) {
                twelve.setImage(image);
            } else if (a.get(n) == 13 && !open13) {
                thirteen.setImage(image);
            } else if (a.get(n) == 14 && !open14) {
                fourteen.setImage(image);
            } else if (a.get(n) == 15 && !open15) {
                fifteen.setImage(image);
            }
        }
        a.remove(0);
        a.remove(0);
    }

    public void equals(ArrayList<String> a, ArrayList<Integer> b) throws FileNotFoundException {
        scoreTmp += 100;
        win++;
        String filename1 = a.get(b.get(0));
        String filename2 = a.get(b.get(1));
        FileInputStream input = new FileInputStream(filename1);
        FileInputStream input2 = new FileInputStream(filename2);
        Image image = new Image(input);
        Image image2 = new Image(input2);

        if (b.get(0) == 0) {
            zero.setImage(image);
        } else if (b.get(0) == 1) {
            one.setImage(image);
        } else if (b.get(0) == 2) {
            two.setImage(image);
        } else if (b.get(0) == 3) {
            three.setImage(image);
        } else if (b.get(0) == 4) {
            four.setImage(image);
        } else if (b.get(0) == 5) {
            five.setImage(image);
        } else if (b.get(0) == 6) {
            six.setImage(image);
        } else if (b.get(0) == 7) {
            seven.setImage(image);
        } else if (b.get(0) == 8) {
            eight.setImage(image);
        } else if (b.get(0) == 9) {
            nine.setImage(image);
        } else if (b.get(0) == 10) {
            ten.setImage(image);
        } else if (b.get(0) == 11) {
            eleven.setImage(image);
        } else if (b.get(0) == 12) {
            twelve.setImage(image);
        } else if (b.get(0) == 13) {
            thirteen.setImage(image);
        } else if (b.get(0) == 14) {
            fourteen.setImage(image);
        } else if (b.get(0) == 15) {
            fifteen.setImage(image);
        }

        if (b.get(1) == 0) {
            zero.setImage(image2);
        } else if (b.get(1) == 1) {
            one.setImage(image2);
        } else if (b.get(1) == 2) {
            two.setImage(image2);
        } else if (b.get(1) == 3) {
            three.setImage(image2);
        } else if (b.get(1) == 4) {
            four.setImage(image2);
        } else if (b.get(1) == 5) {
            five.setImage(image2);
        } else if (b.get(1) == 6) {
            six.setImage(image2);
        } else if (b.get(1) == 7) {
            seven.setImage(image2);
        } else if (b.get(1) == 8) {
            eight.setImage(image2);
        } else if (b.get(1) == 9) {
            nine.setImage(image2);
        } else if (b.get(1) == 10) {
            ten.setImage(image2);
        } else if (b.get(1) == 11) {
            eleven.setImage(image2);
        } else if (b.get(1) == 12) {
            twelve.setImage(image2);
        } else if (b.get(1) == 13) {
            thirteen.setImage(image2);
        } else if (b.get(1) == 14) {
            fourteen.setImage(image2);
        } else if (b.get(1) == 15) {
            fifteen.setImage(image2);
        }

        for (int n = 0; n < 2; n++) {
            if (b.get(n) == 0) {
                open0 = true;
            } else if (b.get(n) == 1) {
                open1 = true;
            } else if (b.get(n) == 2) {
                open2 = true;
            } else if (b.get(n) == 3) {
                open3 = true;
            } else if (b.get(n) == 4) {
                open4 = true;
            } else if (b.get(n) == 5) {
                open5 = true;
            } else if (b.get(n) == 6) {
                open6 = true;
            } else if (b.get(n) == 7) {
                open7 = true;
            } else if (b.get(n) == 8) {
                open8 = true;
            } else if (b.get(n) == 9) {
                open9 = true;
            } else if (b.get(n) == 10) {
                open10 = true;
            } else if (b.get(n) == 11) {
                open11 = true;
            } else if (b.get(n) == 12) {
                open12 = true;
            } else if (b.get(n) == 13) {
                open13 = true;
            } else if (b.get(n) == 14) {
                open14 = true;
            } else if (b.get(n) == 15) {
                open15 = true;
            }
        }
    }

    public void sort (ArrayList <Integer> a, ArrayList <String> b){
        for (int i = 0; i < (a.size() - 1); i++) {
            for (int j = 0; j < (a.size() - i - 1); j++) {
                if (a.get(j) < a.get(j + 1)) {
                    int tmp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, tmp);
                    String tmp1 = b.get(j);
                    b.set(j, b.get(j + 1));
                    b.set(j + 1, tmp1);
                }
            }
        }
    }

    public void check (ArrayList <Integer> a){
        for(int i = 0; i < a.size(); i++){
            for (int j = i + 1; j < a.size(); j++){
                if (a.get(i).equals(a.get(j))){
                    a.remove(j);
                }
            }
        }
    }

}

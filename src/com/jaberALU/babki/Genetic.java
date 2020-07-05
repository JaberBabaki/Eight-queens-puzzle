package com.jaberALU.babki;

import java.util.Random;


public class Genetic {

    private int[][] currentGeneration = new int[200][9]; //خونه اخری جهت قرار گیر  تعداد برخورد 
    private int[][] newGeneration     = new int[200][9];


    public int[][] runAlgoritm() {
        randomQueen();
        fitnees(currentGeneration);
        newGeneration = Cross(currentGeneration);
        sort(currentGeneration);
        int yy = 0;
        while (newGeneration[0][8] != 0) {
            currentGeneration = newGeneration;
            newGeneration = Cross(currentGeneration);
            fitnees(newGeneration);
            sort(newGeneration);
            yy++;

        }
        int[][] newG = new int[8][8];
        for (int j = 0; j < 8; j++) {
            newG[j][newGeneration[0][j]] = 1;
        }

        return newG;
    }


    // ـولید عدد تصادفی در یک ارایه 8 در 200
    private void randomQueen() {
        Random r = new Random();
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 8; j++) {

                int i1 = r.nextInt(7 - 0 + 1) + 0;// تولید عدد رندم
                currentGeneration[i][j] = i1;
            }
        }
    }


    //تابع ارزیابی تعداد برخورد ها
    private void fitnees(int[][] x) {

        int count = 0;
        for (int i = 0; i < 200; i++) {// دو تا حلقه برای پیمایش در ارایه دو بعدی
            count = 0;
            for (int j = 0; j < 8; j++) {
                for (int l = j + 1; l < 8; l++) {//برای بررسی برخورد خونه موردنظر با خونه های بعدی
                    if (x[i][j] == x[i][l]) {// برخورد ستونی
                        count++;
                    }

                    if (Math.abs(j - l) == Math.abs(x[i][j] - x[i][l])) {//برخورد مورب
                        count++;
                    }
                }
            }
            x[i][8] = count;//قرار دادن در خونه آخر به عنوان تعداد برخورد
        }
    }


    // مرتب سازی کروموزم ها
    private void sort(int[][] x) {

        int temp;
        for (int i = 0; i < 199; i++) {
            for (int j = i + 1; j < 200; j++) {
                if (x[i][8] > x[j][8]) {
                    for (int l = 0; l <= 8; l++) {// جابه جا کردن تک تک ژن ها
                        temp = x[i][l];
                        x[i][l] = x[j][l];
                        x[j][l] = temp;

                    }
                }

            }

        }

    }


    // ترکیب و ایجاد جهش
    private int[][] Cross(int[][] x) {
        Random r = new Random();

        int[][] newG = new int[200][9];

        //  منتقل کردن پنچاه تای اول بعد از  
        //مرتب کردن ، به نسل بعدی
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= 8; j++) {
                // Log.i("LOJ", "  " + i + "  " + j);
                newG[i][j] = x[i][j];
            }

        }

        // ترکیب کردن کروموزم ها
        for (int i = 0; i < 100; i = i + 2) {// حلقه دو تا دوتا میره جلو به دلیل اینکه جفت کروموزوم ها گرفته شود
            for (int j = 0; j <= 8; j++) {
                if (j < (8 / 2)) {
                    newG[i + (200 / 2)][j] = x[i][j];//اولی نیمه اول
                    newG[i + (200 / 2) + 1][j] = x[i + 1][j];//دومی نیمه دوم

                } else {
                    newG[i + (200 / 2)][j] = x[i + 1][j];//اولین نیمه دوم
                    newG[i + (200 / 2) + 1][j] = x[i][j];//دومی نیمه اول

                }

            }

            int i1 = r.nextInt(7 - 0 + 1) + 0;//  ایجاد جهش به صورت جایگزین کردن یک عدد به صورت تصادفی
            int i2 = r.nextInt(7 - 0 + 1) + 0;// در هر کدام از کروموزم های به وجود آمده 
            newG[i][i1] = i2;
            newG[i + 1][i1] = i2;
        }

        return newG;
    }
}

package com.jaberALU.babki;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ActivityQueen extends Activity {

    public ImageView[] imgChe = new ImageView[64];
    public int[][]     cell   = new int[8][8];
    private int        count  = 0;
    private Button     btnReset;
    private TextView   txtCount;
    private boolean    user   = true;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maint_root);

        imgChe[0] = (ImageView) findViewById(R.id.img1_1);
        imgChe[1] = (ImageView) findViewById(R.id.img1_2);
        imgChe[2] = (ImageView) findViewById(R.id.img1_3);
        imgChe[3] = (ImageView) findViewById(R.id.img1_4);
        imgChe[4] = (ImageView) findViewById(R.id.img1_5);
        imgChe[5] = (ImageView) findViewById(R.id.img1_6);
        imgChe[6] = (ImageView) findViewById(R.id.img1_7);
        imgChe[7] = (ImageView) findViewById(R.id.img1_8);

        imgChe[8] = (ImageView) findViewById(R.id.img2_1);
        imgChe[9] = (ImageView) findViewById(R.id.img2_2);
        imgChe[10] = (ImageView) findViewById(R.id.img2_3);
        imgChe[11] = (ImageView) findViewById(R.id.img2_4);
        imgChe[12] = (ImageView) findViewById(R.id.img2_5);
        imgChe[13] = (ImageView) findViewById(R.id.img2_6);
        imgChe[14] = (ImageView) findViewById(R.id.img2_7);
        imgChe[15] = (ImageView) findViewById(R.id.img2_8);

        imgChe[16] = (ImageView) findViewById(R.id.img3_1);
        imgChe[17] = (ImageView) findViewById(R.id.img3_2);
        imgChe[18] = (ImageView) findViewById(R.id.img3_3);
        imgChe[19] = (ImageView) findViewById(R.id.img3_4);
        imgChe[20] = (ImageView) findViewById(R.id.img3_5);
        imgChe[21] = (ImageView) findViewById(R.id.img3_6);
        imgChe[22] = (ImageView) findViewById(R.id.img3_7);
        imgChe[23] = (ImageView) findViewById(R.id.img3_8);

        imgChe[24] = (ImageView) findViewById(R.id.img4_1);
        imgChe[25] = (ImageView) findViewById(R.id.img4_2);
        imgChe[26] = (ImageView) findViewById(R.id.img4_3);
        imgChe[27] = (ImageView) findViewById(R.id.img4_4);
        imgChe[28] = (ImageView) findViewById(R.id.img4_5);
        imgChe[29] = (ImageView) findViewById(R.id.img4_6);
        imgChe[30] = (ImageView) findViewById(R.id.img4_7);
        imgChe[31] = (ImageView) findViewById(R.id.img4_8);

        imgChe[32] = (ImageView) findViewById(R.id.img5_1);
        imgChe[33] = (ImageView) findViewById(R.id.img5_2);
        imgChe[34] = (ImageView) findViewById(R.id.img5_3);
        imgChe[35] = (ImageView) findViewById(R.id.img5_4);
        imgChe[36] = (ImageView) findViewById(R.id.img5_5);
        imgChe[37] = (ImageView) findViewById(R.id.img5_6);
        imgChe[38] = (ImageView) findViewById(R.id.img5_7);
        imgChe[39] = (ImageView) findViewById(R.id.img5_8);

        imgChe[40] = (ImageView) findViewById(R.id.img6_1);
        imgChe[41] = (ImageView) findViewById(R.id.img6_2);
        imgChe[42] = (ImageView) findViewById(R.id.img6_3);
        imgChe[43] = (ImageView) findViewById(R.id.img6_4);
        imgChe[44] = (ImageView) findViewById(R.id.img6_5);
        imgChe[45] = (ImageView) findViewById(R.id.img6_6);
        imgChe[46] = (ImageView) findViewById(R.id.img6_7);
        imgChe[47] = (ImageView) findViewById(R.id.img6_8);

        imgChe[48] = (ImageView) findViewById(R.id.img7_1);
        imgChe[49] = (ImageView) findViewById(R.id.img7_2);
        imgChe[50] = (ImageView) findViewById(R.id.img7_3);
        imgChe[51] = (ImageView) findViewById(R.id.img7_4);
        imgChe[52] = (ImageView) findViewById(R.id.img7_5);
        imgChe[53] = (ImageView) findViewById(R.id.img7_6);
        imgChe[54] = (ImageView) findViewById(R.id.img7_7);
        imgChe[55] = (ImageView) findViewById(R.id.img7_8);

        imgChe[56] = (ImageView) findViewById(R.id.img8_1);
        imgChe[57] = (ImageView) findViewById(R.id.img8_2);
        imgChe[58] = (ImageView) findViewById(R.id.img8_3);
        imgChe[59] = (ImageView) findViewById(R.id.img8_4);
        imgChe[60] = (ImageView) findViewById(R.id.img8_5);
        imgChe[61] = (ImageView) findViewById(R.id.img8_6);
        imgChe[62] = (ImageView) findViewById(R.id.img8_7);
        imgChe[63] = (ImageView) findViewById(R.id.img8_8);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ImageView imgMen = (ImageView) findViewById(R.id.men);
        LinearLayout lay_hill = (LinearLayout) findViewById(R.id.lay_message);
        LinearLayout lay_program = (LinearLayout) findViewById(R.id.lay_program);
        LinearLayout lay_idea = (LinearLayout) findViewById(R.id.lay_idea);

        txtCount = (TextView) findViewById(R.id.txt_count);
        btnReset = (Button) findViewById(R.id.btn_reset);

        btnReset.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                reset(1);
            }
        });

        imgMen.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
        lay_idea.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                user = false;

                int[][] temp = new int[8][8];
                reset(1);
                int yy = 0;
                reset(2);
                Genetic genetic = new Genetic();
                temp = genetic.runAlgoritm();
                for (int n = 0; n < 8; n++) {
                    for (int b = 0; b < 8; b++) {
                        int tag = (Integer) imgChe[yy].getTag();
                        int row = (int) Math.floor(tag / 8);
                        int col = tag % 8;
                        if (temp[row][col] == 1)
                        {
                            recColor(row, col, imgChe[yy], 1);
                        }
                        yy++;
                    }
                }
                drawerLayout.closeDrawers();
            }
        });
        lay_hill.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

            }
        });
        lay_program.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                user = false;

                int[][] temp = new int[8][8];
                reset(1);
                randomeQueen();
                AIHill ai = new AIHill();
                ai.setTer(cell);
                int cc = ai.eval();
                ai.setTer(cell);
                temp = ai.heu();
                ai.setTer(cell);
                int tt = ai.eval();
                while (tt < cc && tt != 0) {
                    ai.setTer(cell);
                    temp = ai.heu();
                    cc = tt;
                    ai.setTer(cell);
                    tt = ai.eval();
                }
                ai.setTer(cell);
                temp = ai.heu();

                int yy = 0;
                reset(2);
                for (int n = 0; n < 8; n++) {
                    for (int b = 0; b < 8; b++) {
                        int tag = (Integer) imgChe[yy].getTag();
                        int row = (int) Math.floor(tag / 8);
                        int col = tag % 8;
                        if (temp[row][col] == 1)
                        {
                            recColor(row, col, imgChe[yy], 1);
                        }
                        yy++;
                    }
                }
                drawerLayout.closeDrawers();
            }
        });

        OnClickListener click = new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (user) {
                    ImageView img = (ImageView) view;
                    int tag = (Integer) img.getTag();
                    int row = (int) Math.floor(tag / 8);
                    int col = tag % 8;

                    if (cell[row][col] == 1 || cell[row][col] == 2) {
                        recColor(row, col, img, 0);
                        count--;
                        txtCount.setText("" + count);
                        cell[row][col] = 0;
                        return;
                    }
                    if (count != 8) {
                        // Toast.makeText(ActivityQueen.this, "" + row + "   " + col + "    " + row % 2, Toast.LENGTH_SHORT).show();
                        recColor(row, col, img, 1);
                        count++;
                        txtCount.setText("" + count);
                        int s = check(row, col, img, 2);

                        cell[row][col] = 1;

                    }

                }
            }
        };

        setColor(1);

        for (int i = 0; i < 64; i++) {

            imgChe[i].setTag(i);
            imgChe[i].setOnClickListener(click);
        }

    }


    private int check(int row, int col, ImageView img, int r) {
        for (int i = 0; i < 8; i++) {
            if (cell[row][i] != 0 && col != i) {
                cell[row][i] = 2;
                recColor(row, col, img, r);
                //recColor(i, col, img, r);
            }
        }

        for (int i = 0; i < 8; i++) {
            if (cell[i][col] != 0 && row != i) {
                cell[i][col] = 2;
                recColor(row, col, img, r);
                //recColor(i, col, img, r);
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((row - i) >= 0 && (col + i) <= 7) {
                // Toast.makeText(ActivityQueen.this, "" + (row - i) + "   " + (col + i) + "    " + row % 2, Toast.LENGTH_SHORT).show();
                if (cell[row - i][col + i] != 0) {
                    cell[row][col] = 2;
                    recColor(row, col, img, r);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((row + i) <= 7 && (col - i) >= 0) {
                //Toast.makeText(ActivityQueen.this, "" + (row - i) + "   " + (col + i) + "    " + row % 2, Toast.LENGTH_SHORT).show();
                if (cell[row + i][col - i] != 0) {
                    cell[row][col] = 2;
                    recColor(row, col, img, r);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((row - i) >= 0 && (col - i) >= 0) {
                //Toast.makeText(ActivityQueen.this, "" + (row - i) + "   " + (col + i) + "    " + row % 2, Toast.LENGTH_SHORT).show();
                if (cell[row - i][col - i] != 0) {
                    cell[row][col] = 2;
                    recColor(row, col, img, r);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            if ((row + i) <= 7 && (col + i) <= 7) {
                //Toast.makeText(ActivityQueen.this, "" + (row - i) + "   " + (col + i) + "    " + row % 2, Toast.LENGTH_SHORT).show();
                if (cell[row + i][col + i] != 0) {
                    cell[row][col] = 2;
                    recColor(row, col, img, r);
                }
            }
        }

        return 0;
    }


    private void randomeQueen() {

        Random r = new Random();

        int i1 = r.nextInt(7 - 0 + 1) + 0;
        recColor(0, i1, imgChe[i1], 1);
        int tag = (Integer) imgChe[i1].getTag();
        int row = (int) Math.floor(tag / 8);
        int col = tag % 8;
        cell[row][col] = 1;

        int i2 = r.nextInt(15 - 8 + 1) + 8;
        recColor(1, i2, imgChe[i2], 1);
        int tag2 = (Integer) imgChe[i2].getTag();
        int row2 = (int) Math.floor(tag2 / 8);
        int col2 = tag2 % 8;
        cell[row2][col2] = 1;

        int i3 = r.nextInt(23 - 16 + 1) + 16;
        recColor(2, i3, imgChe[i3], 1);
        int tag3 = (Integer) imgChe[i3].getTag();
        int row3 = (int) Math.floor(tag3 / 8);
        int col3 = tag3 % 8;
        cell[row3][col3] = 1;

        int i4 = r.nextInt(31 - 24 + 1) + 24;
        recColor(3, i4, imgChe[i4], 1);
        int tag4 = (Integer) imgChe[i4].getTag();
        int row4 = (int) Math.floor(tag4 / 8);
        int col4 = tag4 % 8;
        cell[row4][col4] = 1;

        int i5 = r.nextInt(39 - 32 + 1) + 32;
        recColor(4, i5, imgChe[i5], 1);
        int tag5 = (Integer) imgChe[i5].getTag();
        int row5 = (int) Math.floor(tag5 / 8);
        int col5 = tag5 % 8;
        cell[row5][col5] = 1;

        int i6 = r.nextInt(47 - 40 + 1) + 40;
        recColor(5, i6, imgChe[i6], 1);
        int tag6 = (Integer) imgChe[i6].getTag();
        int row6 = (int) Math.floor(tag6 / 8);
        int col6 = tag6 % 8;
        cell[row6][col6] = 1;

        int i7 = r.nextInt(55 - 48 + 1) + 48;
        recColor(6, i7, imgChe[i7], 1);
        int tag7 = (Integer) imgChe[i7].getTag();
        int row7 = (int) Math.floor(tag7 / 8);
        int col7 = tag7 % 8;
        cell[row7][col7] = 1;

        int i8 = r.nextInt(63 - 56 + 1) + 56;
        recColor(7, i8, imgChe[i8], 1);
        int tag8 = (Integer) imgChe[i8].getTag();
        int row8 = (int) Math.floor(tag8 / 8);
        int col8 = tag8 % 8;
        cell[row8][col8] = 1;

    }


    private void recColor(int row, int col, ImageView img, int r) {
        if (r == 1) {
            if (row % 2 != 0 && col % 2 == 0) {
                img.setImageResource(R.drawable.bq);
            }
            if (row % 2 != 0 && col % 2 != 0) {
                img.setImageResource(R.drawable.wq);
            }

            if (row % 2 == 0 && col % 2 == 0) {
                img.setImageResource(R.drawable.wq);
            }
            if (row % 2 == 0 && col % 2 != 0) {
                img.setImageResource(R.drawable.bq);
            }
        } else if (r == 0) {
            if (row % 2 != 0 && col % 2 == 0) {
                img.setImageResource(R.drawable.black);
            }
            if (row % 2 != 0 && col % 2 != 0) {
                img.setImageResource(R.drawable.w);
            }

            if (row % 2 == 0 && col % 2 == 0) {
                img.setImageResource(R.drawable.w);
            }
            if (row % 2 == 0 && col % 2 != 0) {
                img.setImageResource(R.drawable.black);
            }
        } else if (r == 2) {
            if (row % 2 != 0 && col % 2 == 0) {
                img.setImageResource(R.drawable.rb);
            }
            if (row % 2 != 0 && col % 2 != 0) {
                img.setImageResource(R.drawable.rw);
            }

            if (row % 2 == 0 && col % 2 == 0) {
                img.setImageResource(R.drawable.rw);
            }
            if (row % 2 == 0 && col % 2 != 0) {
                img.setImageResource(R.drawable.rb);
            }
        }
    }


    private void reset(int r) {
        setColor(r);
        count = 0;
        txtCount.setText("" + 0);
    }


    private void setColor(int r) {
        if (r == 1) {
            int t = 0;
            for (int n = 0; n < 8; n++) {
                for (int m = 0; m < 8; m++) {
                    imgChe[t].setTag(t);
                    cell[n][m] = 0;
                    t++;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.black);
            } else {
                imgChe[i].setImageResource(R.drawable.w);
            }
        }

        for (int i = 8; i < 16; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.w);
            } else {
                imgChe[i].setImageResource(R.drawable.black);
            }
        }
        for (int i = 16; i < 24; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.black);
            } else {
                imgChe[i].setImageResource(R.drawable.w);
            }
        }
        for (int i = 24; i < 32; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.w);
            } else {
                imgChe[i].setImageResource(R.drawable.black);
            }
        }
        for (int i = 32; i < 40; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.black);
            } else {
                imgChe[i].setImageResource(R.drawable.w);
            }
        }
        for (int i = 40; i < 48; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.w);
            } else {
                imgChe[i].setImageResource(R.drawable.black);
            }
        }
        for (int i = 48; i < 56; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.black);
            } else {
                imgChe[i].setImageResource(R.drawable.w);
            }
        }
        for (int i = 56; i < 64; i++) {
            if ((i + 1) % 2 == 0) {
                imgChe[i].setImageResource(R.drawable.w);
            } else {
                imgChe[i].setImageResource(R.drawable.black);
            }
        }
    }
}
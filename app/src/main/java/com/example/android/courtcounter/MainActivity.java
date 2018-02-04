package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    /*
    * called onCreate
    * manipulates the nunmberpicker range
    * enables the selectorwheel
    */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberPicker np = (NumberPicker) findViewById(R.id.numpick);
        np.setMinValue(4);
        np.setMaxValue(12);
        np.setWrapSelectorWheel(true);
    }

    /*
    * called by onClick on start button
    * rearranges the layout
    */
    public void getSettings(View v) {
        /*
        * gets the empty LinearLayout below the settings
        * changes the titles to the fighter name
        * adds statistics title
        * adds a linear layout for every selected row
        * in every two buttons and a point text view is added
        * a onClickListener is added for every button
        */
        final LinearLayout roundsLayout = findViewById(R.id.roundStats);

        TextView fightTitle = new TextView(this);

        fightTitle.setText("statistics");

        fightTitle.setTextSize(35);

        fightTitle.setGravity(Gravity.CENTER_HORIZONTAL);

        roundsLayout.addView(fightTitle);

        NumberPicker np = (NumberPicker) findViewById(R.id.numpick);

        int rounds = np.getValue();

        EditText lCorn = (EditText) findViewById(R.id.lcorner);

        EditText rCorn = (EditText) findViewById(R.id.rcorner);

        String lc = lCorn.getText().toString();

        String rc = rCorn.getText().toString();

        final TextView leftTitle = findViewById(R.id.leftTitle);

        final TextView rightTitle = findViewById(R.id.rightTitle);

        leftTitle.setText(lc);

        rightTitle.setText(rc);

        for (int l = 1; l <= rounds; l++) {

            LinearLayout roundLayout = new LinearLayout(this);

            roundLayout.setOrientation(LinearLayout.VERTICAL);

            roundsLayout.addView(roundLayout);

            LinearLayout statsLeft = new LinearLayout(this);

            LinearLayout btnsLeft = new LinearLayout(this);

            LinearLayout statsRight = new LinearLayout(this);

            LinearLayout btnsRight = new LinearLayout(this);

            TextView ptsRight = new TextView(this);

            LinearLayout.LayoutParams lpPts = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            lpPts.setMargins(10, 0, 10, 0);

            ptsRight.setGravity(Gravity.CENTER_VERTICAL);

            ptsRight.setTextSize(75);

            TextView ptsLeft = new TextView(this);

            ptsLeft.setGravity(Gravity.CENTER_VERTICAL);

            ptsLeft.setTextSize(75);

            btnsLeft.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

            btnsLeft.setOrientation(LinearLayout.VERTICAL);

            btnsLeft.setGravity(Gravity.LEFT);

            btnsRight.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));

            btnsRight.setOrientation(LinearLayout.VERTICAL);

            btnsRight.setGravity(Gravity.RIGHT);

            TextView round = new TextView(this);

            LinearLayout roundRow = new LinearLayout(this);

            LinearLayout.LayoutParams lpRoundRow = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            lpRoundRow.setMargins(0, 0, 0, 100);

            Button plButtonLeft = new Button(this);

            Button minButtonLeft = new Button(this);

            Button plButtonRight = new Button(this);

            Button minButtonRight = new Button(this);

            round.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            plButtonLeft.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

            plButtonLeft.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

            plButtonRight.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

            plButtonRight.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

            LinearLayout.LayoutParams lpStats = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);

            lpStats.weight = 1;

            statsLeft.setLayoutParams(lpStats);


            roundsLayout.addView(round);

            roundsLayout.addView(roundRow, lpRoundRow);

            roundRow.addView(statsLeft);

            roundRow.addView(statsRight);

            statsLeft.addView(btnsLeft);

            statsLeft.addView(ptsLeft, lpPts);

            statsRight.addView(ptsRight, lpPts);

            statsRight.addView(btnsRight);

            ptsLeft.setId(R.id.roundLeft);

            ptsRight.setId(R.id.roundRight);

            ptsRight.setText("10");

            ptsLeft.setText("10");

            btnsLeft.addView(plButtonLeft);

            btnsLeft.addView(minButtonLeft);

            btnsRight.addView(plButtonRight);

            btnsRight.addView(minButtonRight);

            LinearLayout.LayoutParams lpRound = (LinearLayout.LayoutParams) round.getLayoutParams();

            lpRound.setMargins(0, 10, 0, 10);

            round.setText("Round " + l);

            round.setTextSize(25);

            round.setAllCaps(true);

            round.setGravity(Gravity.CENTER_HORIZONTAL);

            plButtonLeft.setText("+");

            minButtonLeft.setText("-");

            plButtonRight.setText("+");

            minButtonRight.setText("-");
            /*
            * onClickListener for the increment button for the first fighter
            */
            plButtonLeft.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    View vp = (View) v.getParent().getParent();
                    TextView points = vp.findViewById(R.id.roundLeft);
                    String PtsBefore = points.getText().toString();
                    int ptsBefore = Integer.parseInt(PtsBefore);
                    if (ptsBefore >= 10) {
                        int ptsAfter = 10;
                        points.setText("" + ptsAfter);
                    } else {
                        int ptsAfter = ptsBefore + 1;
                        points.setText("" + ptsAfter);
                    }
                }
            });
            /*
            * onClickListener for the decrement button for the first fighter
            */
            minButtonLeft.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    View vp = (View) v.getParent().getParent();
                    TextView points = vp.findViewById(R.id.roundLeft);
                    String PtsBefore = points.getText().toString();
                    int ptsBefore = Integer.parseInt(PtsBefore);
                    if (ptsBefore <= 7) {
                        int ptsAfter = 7;
                        points.setText("" + ptsAfter);
                    } else {
                        int ptsAfter = ptsBefore - 1;
                        points.setText("" + ptsAfter);
                    }
                }
            });
            /*
            * onClickListener for the increment button for the second fighter
            */
            plButtonRight.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    View vp = (View) v.getParent().getParent();
                    TextView points = vp.findViewById(R.id.roundRight);
                    String PtsBefore = points.getText().toString();
                    int ptsBefore = Integer.parseInt(PtsBefore);
                    if (ptsBefore >= 10) {
                        int ptsAfter = 10;
                        points.setText("" + ptsAfter);
                    } else {
                        int ptsAfter = ptsBefore + 1;
                        points.setText("" + ptsAfter);
                    }
                }
            });
            /*
            * onClickListener for the decrement button for the second fighter
            */
            minButtonRight.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    View vp = (View) v.getParent().getParent();
                    TextView points = vp.findViewById(R.id.roundRight);
                    String PtsBefore = points.getText().toString();
                    int ptsBefore = Integer.parseInt(PtsBefore);
                    if (ptsBefore <= 7) {
                        int ptsAfter = 7;
                        points.setText("" + ptsAfter);
                    } else {
                        int ptsAfter = ptsBefore - 1;
                        points.setText("" + ptsAfter);
                    }
                }
            });
        }
        /*
        * create a reset button below statistics
        */
        Button reset = new Button(this);

        LinearLayout.LayoutParams lpResetBtn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        lpResetBtn.setMargins(0, 100, 0, 40);

        reset.setAllCaps(true);

        reset.setText("reset");

        /*
        * set the visibility of the settings layout to gone
        */
        roundsLayout.addView(reset, lpResetBtn);

        final LinearLayout linearParent = (LinearLayout) v.getParent();

        linearParent.setVisibility(View.GONE);
        /*
        * creates onClickListener for the reset button
        * reset visibility of the settings layout to visible
        * removes all created statistics
        */
        reset.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                roundsLayout.removeAllViews();
                linearParent.setVisibility(View.VISIBLE);
                leftTitle.setText("Ringside");
                rightTitle.setText("Counter");
            }
        });
    }
}
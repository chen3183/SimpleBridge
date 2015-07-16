package com.example.jiadongchen.simplebridge;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    final BridgeState initialState = new BridgeState(Position.WEST, Position.WEST,Position.WEST,Position.WEST,Position.WEST,0);
    final BridgeState finalState = new BridgeState(Position.EAST,Position.EAST,Position.EAST,Position.EAST,Position.EAST,0);

    BridgeProblem problem = new BridgeProblem();
    private ArrayList<BridgeMove> moves;
    private TextView text;

    private int moveCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        moves = problem.getMoves();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final Button button0 = (Button) findViewById(R.id.button0);
        text = (TextView) findViewById(R.id.text);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button0.getText().equals("Show Instruction")){
                    button0.setText("Start");
                    text.setText(problem.getIntroduction());
                }
                else
                {
                    button0.setText("Show Instruction");
                    text.setText(problem.getCurrentState().toString());
                }
            }
        });

        Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                problem.setCurrentState(initialState);
                text.setText(problem.getCurrentState().toString());
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        setButton(button1,1);
        Button button2 = (Button) findViewById(R.id.button2);
        setButton(button2,2);
        Button button3 = (Button) findViewById(R.id.button3);
        setButton(button3,3);
        Button button4 = (Button) findViewById(R.id.button4);
        setButton(button4,4);
        Button button5 = (Button) findViewById(R.id.button5);
        setButton(button5,5);
        Button button6 = (Button) findViewById(R.id.button6);
        setButton(button6,6);
        Button button7 = (Button) findViewById(R.id.button7);
        setButton(button7,7);
        Button button8 = (Button) findViewById(R.id.button8);
        setButton(button8,8);
        Button button9 = (Button) findViewById(R.id.button9);
        setButton(button9,9);
        Button button10 = (Button) findViewById(R.id.button10);
        setButton(button10,10);
    }

    public void setButton(Button button, final int i){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BridgeState newState = moves.get(i - 1).doMove(problem.getCurrentState());
                if (newState == null) {
                    builder.setTitle("Illegal move");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                } else {
                    problem.setCurrentState(newState);
                    moveCount++;
                    text.setText(problem.getCurrentState().toString());
                }
                if (problem.success()) {
                    builder.setTitle("Congratulations! You solved the problem in " + moveCount + " moves!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            problem.setCurrentState(initialState);
                            text.setText(initialState.toString());
                        }
                    });
                }
                builder.create().show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

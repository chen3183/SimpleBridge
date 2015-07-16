package com.example.jiadongchen.simplebridge;

import java.util.ArrayList;


/**
 * Created by Jiadong Chen on 7/16/2015.
 */
public class BridgeProblem {
    private BridgeState CState;
    private ArrayList<BridgeMove> aBridgeMoveList = new ArrayList<BridgeMove>();
    private final BridgeState finalBridgeState = new BridgeState(Position.EAST,Position.EAST,Position.EAST,Position.EAST,Position.EAST,0);
    String introduction=
            "\n\nWelcome to the Bridge Crossing Problem.\n\n" +
                    "Person Pn can cross the bridge in n minutes." +
                    "Only one or two persons can cross at a time because it is dark," +
                    "and the flashlight must be taken on every crossing." +
                    "When two people cross, they travel at the speed of the slowest person." +
                    "Devise a sequence of crossings so that all four people get across" +
                    "the bridge in no more than 17 minutes.\n";

    public BridgeProblem()
    {
        CState=new BridgeState(Position.WEST,Position.WEST,Position.WEST,Position.WEST,Position.WEST,0);
        aBridgeMoveList.add(new BridgeMove("P1 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P2 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P5 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P10 crosses alone"));
        aBridgeMoveList.add(new BridgeMove("P1 crosses with P2"));
        aBridgeMoveList.add(new BridgeMove("P1 crosses with P5"));
        aBridgeMoveList.add(new BridgeMove("P1 crosses with P10"));
        aBridgeMoveList.add(new BridgeMove("P2 crosses with P5"));
        aBridgeMoveList.add(new BridgeMove("P2 crosses with P10"));
        aBridgeMoveList.add(new BridgeMove("P5 crosses with P10"));
    }

    public String getIntroduction()
    {
        return introduction;
    }

    public ArrayList<BridgeMove> getMoves()
    {
        return aBridgeMoveList;
    }

    public boolean success()
    {
        if(CState.equals(finalBridgeState)&&CState.getTimeSoFar()<=17)
            return true;
        else
        {
            return false;
        }
    }

    public BridgeState getCurrentState()
    {
        return CState;
    }

    public void setCurrentState(BridgeState currentState)
    {
        CState=currentState;
    }
}

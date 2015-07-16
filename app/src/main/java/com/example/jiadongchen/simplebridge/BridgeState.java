package com.example.jiadongchen.simplebridge;

/**
 * Created by Jiadong Chen on 7/16/2015.
 */

import java.lang.StringBuilder;

public class BridgeState {
    private Position p1,p2,p5,p10,f;
    private int time;

    public BridgeState(Position p1Position,
                       Position p2Position,
                       Position flashlightPosition,
                       Position p5Position,
                       Position p10Position,
                       int timeSoFar)
    {
        p1=p1Position;
        p2=p2Position;
        p5=p5Position;
        p10=p10Position;
        f=flashlightPosition;
        time=timeSoFar;
    }

    public boolean equals(BridgeState other)
    {
        if(other.getFlashlightPosition()==f&&other.getP1Position()==p1
                &&other.getP2Position()==p2&&other.getP5Position()==p5
                &&other.getP10Position()==p10)
            return true;
        else
            return false;
    }

    @Override
    public String toString()
    {
        StringBuilder astring = new StringBuilder();
        astring.append("\n\n");
        if(p1==Position.WEST)
            astring.append ("  P1  |      |\n");
        else
            astring.append ("               |      |  P1\n");
        if(p2==Position.WEST)
            astring.append ("  P2  |      |\n");
        else
            astring.append ("               |      |  P2\n");
        if(f ==Position.WEST)
            astring.append ("    f  |===|\n");
        else
            astring.append ("             |===|  f\n");
        if(p5==Position.WEST)
            astring.append ("  P5  |      |\n");
        else
            astring.append ("               |      |  P5\n");
        if(p10==Position.WEST)
            astring.append ("P10  |      |\n");
        else
            astring.append ("                 |      |  P10\n");
        astring.append("\n");
        astring.append("Time elapsed so far: ");
        astring.append(time);
        astring.append(" minutes.\n");
        return astring.toString();
    }

    public Position getFlashlightPosition()
    {
        return f;
    }

    public Position getP10Position()
    {
        return p10;
    }

    public Position getP1Position()
    {
        return p1;
    }

    public Position getP2Position()
    {
        return p2;
    }

    public Position getP5Position()
    {
        return p5;
    }

    public int getTimeSoFar()
    {
        return time;
    }
}

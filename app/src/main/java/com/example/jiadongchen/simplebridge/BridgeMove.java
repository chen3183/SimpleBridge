package com.example.jiadongchen.simplebridge;

/**
 * Created by Jiadong Chen on 7/16/2015.
 */
public class BridgeMove {
    private String MName;
    public BridgeMove(String moveName)
    {
        if("P1 crosses alone"==moveName ||
                "P2 crosses alone"==moveName ||
                "P5 crosses alone"==moveName ||
                "P10 crosses alone"==moveName ||
                "P1 crosses with P2"==moveName ||
                "P1 crosses with P5"==moveName ||
                "P1 crosses with P10"==moveName ||
                "P2 crosses with P5"==moveName ||
                "P2 crosses with P10"==moveName ||
                "P5 crosses with P10"==moveName )
            MName=moveName;
        else
        {
            System.out.println("error");
            System.exit(0);
        }
    }

    public String getMoveName()
    {
        return MName;
    }

    public BridgeState doMove(BridgeState state)
    {
        switch (MName)
        {
            case "P1 crosses alone":
                if(state.getP1Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,state.getP2Position(),Position.EAST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+1);
                    else
                        return new BridgeState(Position.WEST,state.getP2Position(),Position.WEST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+1);
                }
                else
                    return null;
            case "P2 crosses alone":
                if(state.getP2Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),Position.EAST,Position.EAST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                    else
                        return new BridgeState(state.getP1Position(),Position.WEST,Position.WEST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                }
                else
                    return null;
            case "P5 crosses alone":
                if(state.getP5Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.EAST,Position.EAST,state.getP10Position(),state.getTimeSoFar()+5);
                    else
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.WEST,Position.WEST,state.getP10Position(),state.getTimeSoFar()+5);
                }
                else
                    return null;
            case "P10 crosses alone":
                if(state.getP10Position()==state.getFlashlightPosition())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.EAST,state.getP5Position(),Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.WEST,state.getP5Position(),Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            case "P1 crosses with P2":
                if(state.getP1Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP2Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,Position.EAST,Position.EAST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                    else
                        return new BridgeState(Position.WEST,Position.WEST,Position.WEST,state.getP5Position(),state.getP10Position(),state.getTimeSoFar()+2);
                }
                else
                    return null;
            case "P1 crosses with P5":
                if(state.getP1Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP5Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,state.getP2Position(),Position.EAST,Position.EAST,state.getP10Position(),state.getTimeSoFar()+5);
                    else
                        return new BridgeState(Position.WEST,state.getP2Position(),Position.WEST,Position.WEST,state.getP10Position(),state.getTimeSoFar()+5);
                }
                else
                    return null;
            case "P1 crosses with P10":
                if(state.getP1Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP10Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(Position.EAST,state.getP2Position(),Position.EAST,state.getP5Position(),Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(Position.WEST,state.getP2Position(),Position.WEST,state.getP5Position(),Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            case "P2 crosses with P5":
                if(state.getP2Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP5Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),Position.EAST,Position.EAST,Position.EAST,state.getP10Position(),state.getTimeSoFar()+5);
                    else
                        return new BridgeState(state.getP1Position(),Position.WEST,Position.WEST,Position.WEST,state.getP10Position(),state.getTimeSoFar()+5);
                }
                else
                    return null;
            case "P2 crosses with P10":
                if(state.getP2Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP10Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),Position.EAST,Position.EAST,state.getP5Position(),Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(state.getP1Position(),Position.WEST,Position.WEST,state.getP5Position(),Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            case "P5 crosses with P10":
                if(state.getP5Position()==state.getFlashlightPosition()&&state.getFlashlightPosition()==state.getP10Position())
                {
                    if(state.getFlashlightPosition()==Position.WEST)
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.EAST,Position.EAST,Position.EAST,state.getTimeSoFar()+10);
                    else
                        return new BridgeState(state.getP1Position(),state.getP2Position(),Position.WEST,Position.WEST,Position.WEST,state.getTimeSoFar()+10);
                }
                else
                    return null;
            default:
                return null;
        }
    }
}

package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;
import java.util.Random;



public class WallFollowerPlayerImp implements Player {

    private Direction whereIAmlooking;
    private boolean isLookForRightHand;

    @Override
    public Direction nextMove(Labyrinth l) {
        if (whereIAmlooking == null) {
            whereIAmlooking = l.possibleMoves().get(new Random().nextInt(l.possibleMoves().size()));
            isLookForRightHand = Math.random() >= 0.5;
            return whereIAmlooking;
        }
        if (isLookForRightHand) {
            whereIAmlooking = checkRightWalls(whereIAmlooking, l);
        } else {
            whereIAmlooking = checkLeftWalls(whereIAmlooking, l);
        }
        return whereIAmlooking;
    }

    private Direction checkRightWalls(Direction whereIAmlooking, Labyrinth l) {
        if (l.possibleMoves().size() > 1) {
            switch (whereIAmlooking) {
                case EAST:
                    if (l.possibleMoves().contains(Direction.SOUTH)) {
                        return Direction.SOUTH;
                    }
                    if (l.possibleMoves().contains(Direction.EAST)) {
                        return Direction.EAST;
                    }
                    return Direction.NORTH;
                case NORTH:
                    if (l.possibleMoves().contains(Direction.EAST)) {
                        return Direction.EAST;
                    }
                    if (l.possibleMoves().contains(Direction.NORTH)) {
                        return Direction.NORTH;
                    }
                    return Direction.WEST;
                case SOUTH:
                    if (l.possibleMoves().contains(Direction.WEST)) {
                        return Direction.WEST;
                    }
                    if (l.possibleMoves().contains(Direction.SOUTH)) {
                        return Direction.SOUTH;
                    }
                    return Direction.EAST;
                case WEST:
                    if (l.possibleMoves().contains(Direction.NORTH)) {
                        return Direction.NORTH;
                    }
                    if (l.possibleMoves().contains(Direction.WEST)) {
                        return Direction.WEST;
                    }
                    return Direction.SOUTH;

            }
        }
        return l.possibleMoves().get(0);
    }

    private Direction checkLeftWalls(Direction whereIAmlooking, Labyrinth l) {
        if (l.possibleMoves().size() > 1) {
            switch (whereIAmlooking) {
                case EAST:
                    if (l.possibleMoves().contains(Direction.NORTH)) {
                        return Direction.NORTH;
                    }
                    if (l.possibleMoves().contains(Direction.EAST)) {
                        return Direction.EAST;
                    }
                    return Direction.SOUTH;
                case NORTH:
                    if (l.possibleMoves().contains(Direction.WEST)) {
                        return Direction.WEST;
                    }
                    if (l.possibleMoves().contains(Direction.NORTH)) {
                        return Direction.NORTH;
                    }
                    return Direction.EAST;
                case SOUTH:
                    if (l.possibleMoves().contains(Direction.EAST)) {
                        return Direction.EAST;
                    }
                    if (l.possibleMoves().contains(Direction.SOUTH)) {
                        return Direction.SOUTH;
                    }
                    return Direction.WEST;
                case WEST:
                    if (l.possibleMoves().contains(Direction.SOUTH)) {
                        return Direction.SOUTH;
                    }
                    if (l.possibleMoves().contains(Direction.WEST)) {
                        return Direction.WEST;
                    }
                    return Direction.NORTH;

            }
        }
        return l.possibleMoves().get(0);
    }
}

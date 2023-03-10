package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        board = new Board(size);
        score = maxScore = 0;
        gameOver = false;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        int size = rawValues.length;
        board = new Board(rawValues, score);
        this.score = score;
        this.maxScore = maxScore;
        this.gameOver = gameOver;
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return board.size();
    }

    public static void printSide(Side s){
        System.out.println(s);
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

    /** Return the current score. */
    public int score() {
        return score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }
    public int CheckTheSameNum(Board board,int col,int row) {

        for(int r=row+1;r<board.size();r+=1){


//            System.out.println("col ,r tile is "+board.tile(col,r)+" ||| col ,row tile is "+board.tile(col,row));
            if (board.tile(col,r)!=null){

                if(board.tile(col,r).value()==board.tile(col,row).value()){
//                    System.out.println("found same tile on row "+r);
//                    System.out.println("moving "+board.tile(col,row)+" to "+board.tile(col,r));
                    return r;

                }

            }


        }
        return -1;

        }

    public int CheckTheNull(Board board,int col,int row) {

        int row_of_null=-1;

        for(int r=row+1;r<board.size();r+=1){
            if(board.tile(col,r)==null){
//                System.out.println("moving "+board.tile(col,row)+" to col "+col+ " row "+r+"where it's " +board.tile(col,r));

                row_of_null=r;


            }
        }
        return row_of_null;

    }





    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;
        int null_row;
        int same_num_row;
        int row_taken = -1;

        // TODO: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board changed, set the
        // changed local variable to true.

//        printSide(Side.NORTH);
//        Side s = Side.WEST;



        for (int c =0; c<board.size();c+=1){
            for (int r = board.size()-2; r>=0;r-=1){
                if (board.tile(c,r)!=null) {
                    if (side==Side.SOUTH){
                        System.out.println("changing perspective to south ");

                        board.setViewingPerspective(Side.SOUTH);
                    } else if (side==Side.WEST) {
                        System.out.println("changing perspective to west ");
                        board.setViewingPerspective(Side.WEST);

                    }else if (side==Side.EAST) {
                        System.out.println("changing perspective to east ");
                        board.setViewingPerspective(Side.EAST);

                    }
                    null_row=CheckTheNull(board,c,r);
                    same_num_row=CheckTheSameNum(board,c,r);
                    Tile t = board.tile(c,r);
                    System.out.println("col is "+c+" row is "+r+"tile is "+t);
//                    System.out.println("null_row returns "+null_row);



                    if (same_num_row>r && same_num_row!=row_taken){
                        System.out.println("same_num_row returns "+same_num_row);
                        System.out.println("row_taken is "+row_taken);
                        score += 2*board.tile(c,same_num_row).value();
                        board.move(c,same_num_row,t);
                        board.setViewingPerspective(Side.NORTH);



                        row_taken=same_num_row;

                    }
                    else if (null_row>r){

                        board.move(c,null_row,t);
                        board.setViewingPerspective(Side.NORTH);

                    }
                    changed=true;
                    System.out.println("changing perspective to north ");


                }


                }
            }
//
//
//
//
//                if (board.tile(c,r)!=null){
////                    System.out.println("col "+c+" row "+r+t);
////                    System.out.println("want to move it to col "+c+" row "+(r+1));
//
//                    if (r==2) {
//
//
//                        if (board.tile(c,r+1)==null || board.tile(c,r+1)==board.tile(c,r)){
//                            board.move(c,r+1,t);
//                            changed=true;
//
//                        }
//
//                    }
//
//
//                }
////                if (r==2){
////                    if (board.tile(c,r+1)==null){
////                        board.move(c,r,t);
////                        changed=true;
////                        score += 7;
////
////                }
////
////
////                }
//            }
//        }

        checkGameOver();
        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {
        // TODO: Fill in this function.
        for(int i=0;i<b.size();i+=1){
            for (int j=0;j<b.size();j+=1){
                if (b.tile(i,j) == null){
                    return true;

                };
            }

        }


        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        // TODO: Fill in this function.

        for(int i=0;i<4;i+=1){
            for (int j=0;j<4;j+=1){
                if (b.tile(i,j) != null){
                    if (b.tile(i,j).value() == MAX_PIECE) {
                        return true;

                    };

                };

                };
            }



        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: Fill in this function.
        for(int i=0;i<4;i+=1){
            for (int j=0;j<4;j+=1){
                if (b.tile(i,j) == null){
                    return true;
                }
                if (j ==3){
                    continue;
                }
                if (b.tile(i,j).value()==b.tile(i,j+1).value()){
                    return true;
                }

                if (i==1 || i==2){
                    if (b.tile(i,j).value()==b.tile(i-1,j).value() || b.tile(i,j).value()==b.tile(i+1,j).value()){
                        return true;
                    }

                }

//                if (i==2){
//                    if (b.tile(i,j).value()==b.tile(i-1,j).value() || b.tile(i,j).value()==b.tile(i+1,j).value()){
//                        return true;
//                    }
//
//                }


            };
        }
        return false;
    }


    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}

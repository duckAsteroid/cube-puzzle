package org.asteroid.duck.cube;

import org.junit.Test;

import static org.asteroid.duck.cube.Block.BLACK;
import static org.asteroid.duck.cube.Block.WHITE;
import static org.junit.Assert.*;

/**
 * Created by Chris on 19/03/2016.
 */
public class PieceTest {

    @Test
    public void parse() throws Exception {

    }

    @Test
    public void parseLine() throws Exception {

        Block[] blocks = Piece.parseLine("B,W,0");
        assertArrayEquals(new Block[]{BLACK, WHITE, null}, blocks);
        blocks = Piece.parseLine("B,W,");
        assertArrayEquals(new Block[]{BLACK, WHITE}, blocks);
        blocks = Piece.parseLine(",B,W");
        assertArrayEquals(new Block[]{BLACK, WHITE}, blocks);
        blocks = Piece.parseLine(", ,");
        assertArrayEquals(new Block[]{null}, blocks);
    }
}
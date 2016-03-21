package org.asteroid.duck.cube;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents one of the 2D pieces in the cube puzzle
 */
public class Piece {
    private Block[][] layout;

    public Piece(Block[][] layout) {
        this.layout = layout;
        int size = -1;
        for(int i=0; i < layout.length; i++) {
            if (size >= 0) {
                if(layout[i].length != size) {
                    throw new IllegalArgumentException("All rows must be the same size ("+size+") row "+i+" is "+layout[i].length);
                }
            }
            else {
                size = layout[i].length;
            }
        }
    }

    /**
     * Parse a series of lines describing this piece
     * @param lines
     * @return
     */
    public static Piece parse(String[] lines) {
        Block[][] layout = new Block[lines.length][];
        for(int i=0; i < lines.length; i++) {
            layout[i] = parseLine(lines[i]);
        }
        return new Piece(layout);
    }

    /**
     * Parse a single line of a piece descriptor
     * @param line A comma separated list of blocks (or nulls)
     * @return a line of blocks
     */
    public static Block[] parseLine(String line) {
        String[] blockNames = line.split(",");
        List<Block> result = new ArrayList<>(blockNames.length);
        for(int i=0; i < blockNames.length; i++) {
            String name = blockNames[i].trim();
            if (name.length() > 0) {
                result.add(Block.parse(name.charAt(0)));
            }
        }
        return result.toArray(new Block[result.size()]);
    }

}

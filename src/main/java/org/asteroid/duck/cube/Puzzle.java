package org.asteroid.duck.cube;

/**
 * A set of pieces and a desired state/rules
 */
public class Puzzle {
    private final Piece[][][] cube;

    public Puzzle(int size) {
        this.cube = new Piece[size][size][size];
    }

    public Puzzle copy() {
        Puzzle copy = new Puzzle(cube.length);
        for(int x=0; x < cube.length; x++) {
            for(int y=0; y < cube[x].length; y++) {
                for(int z=0; z < cube[x][y].length; z++) {
                    copy.cube[x][y][z] = this.cube[x][y][z];
                }
            }
        }
        return copy;
    }

    public Piece get(Coord c) {
        return cube[c.x][c.y][c.z];
    }
}

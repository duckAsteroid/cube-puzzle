package org.asteroid.duck.cube;

/**
 * An individual block (cube) that makes up the puzzle
 */
public enum Block {

    BLACK('B','\u2591'), WHITE('W', '\u2593');

    private char symbol;
    private char depiction;

    Block(char symbol, char depiction) {
        this.symbol = symbol;
        this.depiction = depiction;
    }

    /**
     * Parse a symbol into a Block
     * @param c the symbol character
     * @return the corresponding block
     */
    public static Block parse(char c) {
        switch(c) {
            case 'B':
                return BLACK;
            case 'W':
                return WHITE;
            default:
                return null;
        }
    }
}

package org.asteroid.duck.cube;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Chris on 21/03/2016.
 */
public class CoordTest {
    
    public static final Coord subject_X = new Coord(1,0,0);
    public static final Coord subject_Y = new Coord(0,1,0);
    public static final Coord subject_Z = new Coord(0,0,1);

    public static final Coord subject_123 = new Coord(1,2,3);

    @Test
    public void position() throws Exception {
        assertEquals(3, subject_123.position(Axis.Z));
        assertEquals(2, subject_123.position(Axis.Y));
        assertEquals(1, subject_123.position(Axis.X));
    }

    @Test
    public void translate() throws Exception {
        Coord test = subject_X.translate(Axis.X, 3);
        assertEquals(new Coord(4,0,0), test);

        test = subject_X.translate(Axis.Y, 3);
        assertEquals(new Coord(1,3,0), test);

        test = subject_X.translate(Axis.Z, 3);
        assertEquals(new Coord(1,0,3), test);
    }

    @Test
    public void add() throws Exception {
        Coord test = subject_X.add(subject_Y);
        assertEquals(new Coord(1,1,0), test);
    }

    @Test
    public void inverse() throws Exception {
        Coord test = subject_123.inverse();
        assertEquals(new Coord(-1,-2,-3), test);
    }
}
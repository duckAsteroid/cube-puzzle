package org.asteroid.duck.cube;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 3D coordinate in a cube
 */
public class Coord {
    /** actual integer coordinates */
    public final int x, y, z;

    /** 0,0,0 */
    public static final Coord ORIGIN = new Coord(0,0,0);

    /**
     * Create coordinate with X, Y and Z positions
     * @param x position on the X axis
     * @param y position on the Y axis
     * @param z position on the Z axis
     */
    public Coord(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Get the position of this coordinate in the given axis
     * @param d axis for the position
     * @return the position
     */
    public int position(Axis d) {
        switch (d) {
            case X:
                return x;
            case Y:
                return y;
            case Z:
                return z;
        }
        throw new IllegalArgumentException("Unexpected axis " + d);
    }

    /**
     * Translate this coordinate by an offset along a single given axis/dimension
     * @param d The dimension/axis to translate along
     * @param offset the offset to apply
     * @return A new coordinate at the translated position
     */
    public Coord translate(Axis d, int offset) {
        int x = this.x;
        int y = this.y;
        int z = this.z;
        switch (d) {
            case X:
                x += offset;
                break;
            case Y:
                y += offset;
                break;
            case Z:
                z += offset;
                break;
        }
        return new Coord(x, y, z);
    }

    /**
     * Add one co-ordinate to another
     * @param other the other co-ordinate to add to this
     * @return a new coordinate that is
     */
    public Coord add(Coord other) {
        return new Coord(x + other.x, y + other.y, z + other.z);
    }

    public Coord inverse() {
        return new Coord( x * -1, y * -1, z * -1);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(x).append(y).append(z);
        return hcb.build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Coord) {
                Coord other = (Coord) obj;
                return this.x == other.x && this.y == other.y && this.z == other.z;
            }
        }
        return false;
    }
}

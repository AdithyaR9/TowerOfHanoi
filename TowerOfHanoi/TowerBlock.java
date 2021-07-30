
package TowerOfHanoi;

public class TowerBlock {

    private double blockX;
    private double blockY;
    private double blockLength;
    private double blockHeight;
    private double blockSize;

    public TowerBlock(double bL, double bH, double bZ) {

        blockLength = bL;
        blockHeight = bH;
        blockSize = bZ;

    }

    public double getBlockHeight() {
        return blockHeight;
    }

    public double getBlockLength() {
        return blockLength;
    }

    public double getBlockSize() {
        return blockSize;
    }

    public void setBlockHeight(double blockHeight) {
        this.blockHeight = blockHeight;
    }

    public void setBlockLength(double blockLength) {
        this.blockLength = blockLength;
    }

    public void setBlockSize(double blockSize) {
        this.blockSize = blockSize;
    }
}

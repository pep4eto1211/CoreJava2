public class Pixel {
    private float m_r;
    private float m_g;
    private float m_b;

    public Pixel(float red, float green, float blue) {
        this.m_r = red;
        this.m_g = green;
        this.m_b = blue;
    }

    public float getR() {
        return m_r;
    }

    public float getG() {
        return m_g;
    }

    public float getB() {
        return m_b;
    }

    public void setR(float value) {
        this.m_r = value;
    }

    public void setG(float value) {
        this.m_g = value;
    }

    public void setB(float value) {
        this.m_b = value;
    }

    public static Pixel fromStrng(String pixelString){
        String[] values = pixelString.split(",");
        return new Pixel(Float.valueOf(values[0]), Float.valueOf(values[1]), Float.valueOf(values[2]));
    }

    @Override
    public String toString() {
        return String.valueOf(m_r) + "," + String.valueOf(m_g) + "," + String.valueOf(m_b);
    }
}

/**
 * Created by Character on 26.02.2016.
 */
public class AllCases {
    public int publicInt = 3;
    protected int protectedInt = 2;
    byte aByte = 10;
    short aShort = 111;
    int aInt = 1213;
    long aLong = 1225324234;
    float aFloat = 21432.1f;
    double aDouble = 12345.5678;
   // char aChar = 'A';
    boolean aBoolean = true;
    private int privateInt = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AllCases)) return false;

        AllCases allCases = (AllCases) o;

        if (publicInt != allCases.publicInt) return false;
        if (protectedInt != allCases.protectedInt) return false;
        if (aByte != allCases.aByte) return false;
        if (aShort != allCases.aShort) return false;
        if (aInt != allCases.aInt) return false;
        if (aLong != allCases.aLong) return false;
        if (Float.compare(allCases.aFloat, aFloat) != 0) return false;
        if (Double.compare(allCases.aDouble, aDouble) != 0) return false;
        if (aBoolean != allCases.aBoolean) return false;
        return privateInt == allCases.privateInt;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = publicInt;
        result = 31 * result + protectedInt;
        result = 31 * result + (int) aByte;
        result = 31 * result + (int) aShort;
        result = 31 * result + aInt;
        result = 31 * result + (int) (aLong ^ (aLong >>> 32));
        result = 31 * result + (aFloat != +0.0f ? Float.floatToIntBits(aFloat) : 0);
        temp = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (aBoolean ? 1 : 0);
        result = 31 * result + privateInt;
        return result;
    }
}
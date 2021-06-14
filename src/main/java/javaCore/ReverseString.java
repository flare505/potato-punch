package javaCore;

public class ReverseString {
    public static void main(String[] args) {
        //String is immutable in java
        String str = "abc";
        System.out.println(str);

        //assignment
        str = "xyz";
        System.out.println(str);
        str = new String("abc");
        System.out.println(str);

        //String builder is mutable
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.reverse());

        //Same as string builder but thread-safe. thread-safety comes at the cost of performance.
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer.reverse());

        //both stringBuilder and buffer support functions like append, replace, substring
        System.out.println(stringBuilder.append("abc"));
        System.out.println(stringBuilder.replace(0,1, "abcd"));

        System.out.println(stringBuilder.substring(1, 4));

    }
}

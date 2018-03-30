package cn.xingoo.jdk.commons;

public class UUIDTest {
    public static void main(String[] args) {
        System.out.println("0c312388-5d09-4f44-b670-5461605f0bee".hashCode()& 0x7fffffffffffffffL);
//        UUID uuid1 = UUID.fromString("6814E1EE19D94A72A0AFED2F5636FE7C");
//        System.out.println(uuid1.getLeastSignificantBits()& 0x7fffffffffffffffL);
//        System.out.println("6814E1EE19D94A72A0AFED2F5636FE7C".toCharArray()[0]);
//        for (int i = 0; i < 100; i++) {
//            System.out.println(UUID.randomUUID());
//        }
        System.out.println("abc".hashCode());
    }
}

package cn.xingoo.book.netty2.chap6;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private int userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public byte[] codec(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.userID = 1;
        info.userName = "lisi";

        // 测试java序列化占用的空间
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();

        byte[] b = bos.toByteArray();
        System.out.println(b.length);
        bos.close();

        // 测试自定义序列化占用的空间
        System.out.println("------");
        System.out.println(info.codec().length);

        // 测试Java序列化的时间
        long startTime = System.currentTimeMillis();
        for(int i=0; i< 1000000; i++){
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        // 测试自定义的时间
        startTime = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            byte[] bbb = info.codec();
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);


    }
}

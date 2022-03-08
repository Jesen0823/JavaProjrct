package javabasereview.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
* 管道流的示例
* 两个线程通信，发送线程定义管道输出流，接受线程使用管道输入流
* */

class Send implements Runnable{
    private PipedOutputStream pPos = null;

    public Send() {
        this.pPos = new PipedOutputStream();
    }

    @Override
    public void run() {
        String str = "收到请回电";
        try { // 输出信息
            this.pPos.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getpPos() {
        return pPos;
    }
}

class Receive implements Runnable{
    private PipedInputStream pPis = null;

    public Receive() {
        this.pPis = new PipedInputStream();
    }

    @Override
    public void run() {
        byte b[] = new byte[1024];
        int len = 0;
        try {
            len = this.pPis.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.pPis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接受到："+new String(b,0,len));
    }

    public PipedInputStream getpPis() {
        return pPis;
    }
}

public class PipedDemo13 {


    public static void main(String[] args) {
        Send sR = new Send();
        Receive rR = new Receive();
        try {
            sR.getpPos().connect(rR.getpPis());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(rR).start();
        new Thread(sR).start();
    }
}

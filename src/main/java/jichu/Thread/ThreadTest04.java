package jichu.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 练习Thread，实现多线程同步下载图片
 */
public class ThreadTest04 implements Runnable{
    private String url;  //网络图片地址
    private String name; //保存文件名

    public ThreadTest04(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片的执行体
    public void run(){
        WebDownLoader02 webDownLoader = new WebDownLoader02();
        webDownLoader.downloader(url,name);
        System.out.println("下载了文件名： "+name);
    }

    public static void main(String[] args) {
        ThreadTest02 t1 = new ThreadTest02("https://img.diyijuzi.com/uploadfile/2020/0313/1584096698316.jpg","1.jpg");
        ThreadTest02 t2 = new ThreadTest02("https://img.diyijuzi.com/uploadfile/2020/0313/1584096713746.jpg","2.jpg");
        ThreadTest02 t3 = new ThreadTest02("https://img.diyijuzi.com/uploadfile/2020/0313/1584096706532.jpg","3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }

}

//下载器
class WebDownLoader02{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
package utils;

import java.io.*;
import java.util.Arrays;

/**
 * 图片操作的工具类
 */
public class PictureUtils {

    /**
     *  图片转为二进制数组
     * @param path 图片路径
     */
    public static byte[] pictureToArray(String path){
        byte [] buf ;
        buf = new byte[1034*8];
        File img = new File(path);
        if(img.isFile()){
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(img);
                StringBuffer sb = new StringBuffer();
                int len = 0;
                while ((len = fis.read(buf))!=-1){
                    sb.append(new String(buf,0,len,"utf-8"));
                }
                return buf;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在，请检查路径！");
        }
        return buf;
    }


   public static void arrayToPicture(byte [] buf ){
        String path = "web/image";
        FileOutputStream fos = null;
       try {
           fos = new FileOutputStream(path);
           fos.write(buf);
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               fos.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }

    /**
     * 测试转数组成功
     * @param args
     */
    public static void main(String[] args) {
        String path = "web/images/s58.jpg";
        byte buf [] = PictureUtils.pictureToArray(path);
        System.out.println(Arrays.toString(buf));
        PictureUtils.arrayToPicture(buf);
    }

}

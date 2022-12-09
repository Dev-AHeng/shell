package aheng.shell.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author AHeng
 * @date 2022/06/24 21:59
 */
public class UtilsCopy {
    /**
     * @param context   context
     * @param assetName asset文件
     * @param saveName  目标文件名
     */
    public static void copyFileFromAssets(Context context, String assetName, String saveName) {
        // 若目标文件夹不存在，则创建
        // File dir = new File(Environment.getExternalStorageDirectory() + "/" + savePath);
        // if (!dir.exists()) {
        //     if (!dir.mkdir()) {
        //         Log.d("FileUtils", "mkdir error: " + savePath);
        //         return;
        //     }
        // }
        
        // 拷贝文件
        String filename = context.getFilesDir() + saveName;
        File file = new File(filename);
        if (!file.exists()) {
            try {
                InputStream inStream = context.getAssets().open(assetName);
                FileOutputStream fileOutputStream = new FileOutputStream(filename);
                
                int byteread;
                byte[] buffer = new byte[1024];
                while ((byteread = inStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteread);
                }
                fileOutputStream.flush();
                inStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("FileUtils", "[copyFileFromAssets] copy asset file: " + assetName + " to : " + filename);
        } else {
            Log.d("FileUtils", "[copyFileFromAssets] file is exist: " + filename);
        }
        Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();
    }
    
}

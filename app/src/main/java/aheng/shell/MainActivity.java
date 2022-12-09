package aheng.shell;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Shell.CommandResult;
import android.os.Shell.ShellManageHelper;
import android.os.Shell.ShellUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.DataUtils;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Dev_Heng
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "日志";
    private final static String CONFIG = "[{\"aodStyle\":0,\"aodType\":0,\"bold\":0,\"color\":[-1,-1],\"colorIndex\":0,\"composing\":0,\"fontSize\":0,\"index\":0,\"isShowBattery\":0,\"isShowCalendar\":0,\"isShowFootstep\":0,\"isShowLunarCalendar\":0,\"isShowNotification\":0,\"isShowRaiseTime\":0,\"isShowTime\":0,\"isShowWeather\":0,\"personalImage\":\"/data/aod/image/myImage.jpg\",\"subStyle\":0,\"typeString\":\"自定义图案\"},{\"aodStyle\":0,\"aodType\":1,\"bold\":0,\"color\":[-1,-1],\"colorIndex\":0,\"composing\":0,\"fontSize\":0,\"index\":0,\"isShowBattery\":1,\"isShowCalendar\":1,\"isShowFootstep\":0,\"isShowLunarCalendar\":0,\"isShowNotification\":0,\"isShowRaiseTime\":0,\"isShowTime\":0,\"isShowWeather\":0,\"subStyle\":0,\"typeString\":\"经典简约\",\"zkPathString\":\"data/aod/zkAod/classictime/.cache/chorizontaltime\"}]";
    private TextView textView;
    private EditText editTextTextPersonName;
    private EditText editTextTextPersonName2, editTextTextPersonName3;
    private TextView textView2;
    private RadioGroup radioGroup1;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button button, button2;
    private ImageView imageView;
    private int 显示模式 = 0;
    private String aod_current_style = "{\"aodStyle\":0,\"aodType\":0,\"bold\":0,\"color\":[-1,-1],\"colorIndex\":0,\"composing\":0,\"fontSize\":0,\"index\":0,\"isShowBattery\":0,\"isShowCalendar\":0,\"isShowFootstep\":0,\"isShowLunarCalendar\":0,\"isShowNotification\":0,\"isShowRaiseTime\":0,\"isShowTime\":0,\"isShowWeather\":0,\"personalImage\":\"/data/aod/image/myImage.jpg\",\"subStyle\":0,\"typeString\":\"自定义图案\"}";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        
        
        // 息屏显示当前状态  不发起root请求
        ShellManageHelper.requestSuperMaster(true);
        // if (ShellUtils.checkRootPermission()) { //发起请求
        //     CommandResult commandResult = ForeverShellUtils.getInstance().execCommand("getprop persist.sys.meizu.aod"); // 发起请求
        //     if (commandResult.isSuccessful()) {
        //         toast("息屏显示当前状态:" + ("1".equals(commandResult.getSuccessText()) ? "开" : "关"));
        //
        //         CommandResult commandResult1 = ForeverShellUtils.getInstance().execCommand("settings get system my_aod");
        //         editTextTextPersonName3.setText(commandResult1.getSuccessText());
        //
        //         File file = bitmapSaveToAndroidData(R.drawable.aod_bg, 479, 479);
        //         if (file != null && file.exists() && file.length() > 0) {
        //             // dd拷贝  dd if=<input file> of=<output file>
        //             // /storage/emulated/0/Pictures/QQ图片20220624133514.jpg
        //             // /data/aod/image/
        //             List<String> strings = new ArrayList<>();
        //             // 挂载data
        //             strings.add("mount -o remount,rw /data");
        //             strings.add("mkdir -p /data/aod/image");
        //             String dd = "dd if=" + file.getAbsolutePath() + " of=/data/aod/image/" + file.getName();
        //             System.out.println("dd = " + dd);
        //             // 拷贝
        //             strings.add(dd);
        //
        //             CommandResult commandResult2 = ForeverShellUtils.getInstance().execCommand(strings);
        //             System.out.println("commandResult2.getSuccessText() = " + commandResult2.getSuccessText());
        //
        //         }
        //
        //     }
        // }
        
        // 单选
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        显示模式 = 0;
                        break;
                    case R.id.radioButton2:
                        显示模式 = 1;
                        break;
                    case R.id.radioButton3:
                        显示模式 = 2;
                        break;
                    case R.id.radioButton4:
                        显示模式 = 3;
                        break;
                    default:
                        显示模式 = 0;
                        break;
                }
            }
        });
        
        // aod_display_mode
        // aod_timing_mode_start_time 00:00
        // aod_timing_mode_end_time 00:01
        
        // settings put system key value
        // settings get system key
        
        // 开启
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    assetsSaveToDataUser("Settings.apk", "Settings.apk");
                    assetsSaveToDataUser("AlwaysOnDisplay.apk", "AlwaysOnDisplay.apk");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                ShellManageHelper.requestSuperMaster(true);
                if (ShellUtils.checkRootPermission()) {
                    List<String> commandsArrayList = new ArrayList<>();
                    
                    // 挂载system
                    commandsArrayList.add("mount -o remount,rw /system");
                    // 创建目录
                    commandsArrayList.add("mkdir -p /system/priv-app/Settings");
                    commandsArrayList.add("mkdir -p /system/app/AlwaysOnDisplay");
                    // 拷贝
                    String dd1 = "dd if=/data/user/0/aheng.shell/files/Settings.apk of=/system/priv-app/Settings/Settings.apk";
                    commandsArrayList.add(dd1);
                    String dd2 = "dd if=/data/user/0/aheng.shell/files/AlwaysOnDisplay.apk of=/system/app/AlwaysOnDisplay/AlwaysOnDisplay.apk";
                    commandsArrayList.add(dd2);
                    
                    // 开启息屏
                    commandsArrayList.add("setprop persist.sys.meizu.aod 1");
                    
                    // 显示模式
                    commandsArrayList.add("settings put system aod_display_mode 1");
                    // 显示模式开始时间
                    commandsArrayList.add("settings put system aod_timing_mode_start_time " + editTextTextPersonName.getText().toString().trim());
                    // 显示模式结束时间
                    commandsArrayList.add("settings put system aod_timing_mode_end_time " + editTextTextPersonName2.getText().toString().trim());
                    
                    // 挂载data
                    commandsArrayList.add("mount -o remount,rw /data");
                    // 创建目录
                    commandsArrayList.add("mkdir -p /data/aod/image");
                    File file = bitmapSaveToAndroidData(R.drawable.ww, 479, 479);
                    
                    // 拷贝自定义图案
                    String dd = "dd if=" + file.getAbsolutePath() + " of=/data/aod/image/" + file.getName();
                    commandsArrayList.add(dd);
                    
                    // 更新自定义图案配置
                    String replace = CONFIG.replace("/data/aod/image/myImage.jpg", "/data/aod/image/" + file.getName());
                    System.out.println("replace = " + replace);
                    commandsArrayList.add("settings put system my_aod '" + replace + "'");
                    
                    String replaceAodCurrentStyle = aod_current_style.replace("/data/aod/image/myImage.jpg", "/data/aod/image/" + file.getName());
                    commandsArrayList.add("settings put system aod_current_style '" + replaceAodCurrentStyle + "'");
                    
                    commandsArrayList.add("settings put system aod_current_preview " + "/data/aod/image/" + file.getName());
                    
                    // 息屏来通知效果 默认0  0不亮屏  1亮屏  2触碰显示  3内容将在触碰手机后显示一段时间
                    commandsArrayList.add("settings put system notification_wakeup_screen " + 显示模式);
                    
                    CommandResult commandResult = ShellUtils.execCommand(commandsArrayList, true);
                    if (commandResult.isSuccessful()) {
                        toast("开启成功:" + commandResult.getSuccessText());
    
                        AlertDialog.Builder mad = new MaterialAlertDialogBuilder(MainActivity.this);
                        mad.setTitle("提示");
                        mad.setMessage("是否重启");
                        mad.setPositiveButton("重启", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 重启
                                ShellUtils.execCommand("reboot", true);
                            }
                        });
                        mad.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                toast("取消");
                            }
                        });
                        mad.show();
                        
    
                    } else {
                        toast("开启失败:" + commandResult.getErrorText());
                    }
                } else {
                    toast("没有权限");
                }
            }
        });
        
        
        // 关闭
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShellManageHelper.requestSuperMaster(true);
                CommandResult commandResult = ShellUtils.execCommand("setprop persist.sys.meizu.aod 0", true);
                if (commandResult.isSuccessful()) {
                    toast("关闭成功:" + commandResult.getSuccessText());
                } else {
                    toast("关闭失败:" + commandResult.getErrorText());
                }
            }
        });
        
    }
    
    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = (EditText) findViewById(R.id.editTextTextPersonName2);
        textView2 = (TextView) findViewById(R.id.textView2);
        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        editTextTextPersonName3 = (EditText) findViewById(R.id.editTextTextPersonName3);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    
    
    /**
     * 将assets里的文件保存到/data/user/0/{包名}/files目录下
     *
     * @param assetsFileName assets文件名
     * @param saveFileName   保存后的文件命名
     */
    public void assetsSaveToDataUser(String assetsFileName, String saveFileName) throws IOException {
        InputStream inputStream = this.getAssets().open(assetsFileName);
        FileOutputStream fileOutputStream = MainActivity.this.openFileOutput(saveFileName, Context.MODE_PRIVATE);
        
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, length);
        }
        
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();
    }
    
    
    private File bitmapSaveToAndroidData(int id, int newWidth, int newHeight) {
        File file = null;
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
            bitmap = scaleBitmap(bitmap, newWidth, newHeight);
            
            // 显示图片
            imageView.setImageBitmap(bitmap);
            
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
            String myDate = format.format(new Date());
            System.out.println(myDate + ".jpg");
            
            file = new File(getExternalCacheDir().toString() + "/" + myDate + ".jpg");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            // 将图片复制到私有空间
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            file = null;
        }
        return file;
    }
    
    /**
     * Toast
     *
     * @param content 提示内容
     */
    public void toast(Object content) {
        Toast.makeText(this, content.toString(), Toast.LENGTH_SHORT).show();
    }
    
    
    /**
     * 格式化插入命令
     *
     * @param uri
     * @param contentValues
     * @return
     */
    public String formatInsertCommands(Uri uri, ContentValues contentValues) {
        List<String> commands = new ArrayList<>();
        commands.add("content insert --uri " + uri);
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            if (entry.getKey() == null) {
                continue;
            }
            commands.add("\t--bind " + entry.getKey() + ":s:" + entry.getValue());
        }
        return DataUtils.getListToString(commands, "");
    }
    
    
    /**
     * 根据给定的宽和高进行拉伸
     *
     * @param origin    原图
     * @param newWidth  新图的宽
     * @param newHeight 新图的高
     * @return new Bitmap
     */
    private Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        int height = origin.getHeight();
        int width = origin.getWidth();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return bitmap;
    }
    
}

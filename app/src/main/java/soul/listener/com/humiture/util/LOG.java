package soul.listener.com.humiture.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@description  日志管理类
 */
public class LOG {

    private static final int LEVEL_I = 1;
    private static final int LEVEL_D = 2;
    private static final int LEVEL_W = 3;
    private static final int LEVEL_E = 4;

    // 日志加密开关: true 加密，false 不加密
    public static final boolean IS_ENCRYPT = true;

    private static final long LOGSIZE = 1024 * 50;// 日志文件最大50KB

    public static final String LOGFILE = "log.txt";

    private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void logD(String msg) {
        log(LEVEL_D, msg);
    }

    public static void logI(String msg) {
        log(LEVEL_I, msg);
    }

    public static void logW(String msg) {
        log(LEVEL_W, msg);
    }

    public static void logE(String msg) {
        log(LEVEL_E, msg);
    }

    private static void log(int level, String msg) {
        //        if (!Constants.DEBUG) {
        //            return;
        //        }
        final Throwable t = Constants.DEBUG ? new Throwable() : null;
        final StackTraceElement[] elements = t != null ? t.getStackTrace() : null;
        String callerClassName = t != null ? elements[2].getClassName() : "N/A";
        String callerMethodName = t != null ? elements[2].getMethodName() : "N/A";
        int pos = callerClassName.lastIndexOf('.');
        if (pos >= 0) {
            callerClassName = callerClassName.substring(pos + 1);
        }
        final String tag = callerClassName;
        final StringBuffer buf = new StringBuffer();
        buf.append("[").append(callerMethodName).append("]  ").append(msg);

        if (Constants.DEBUG) { // 开发阶段，打印日志，发布上线关闭日志
            switch (level) {
                case LEVEL_I:
                    Log.i(tag, buf.toString());
                    break;
                case LEVEL_D:
                    Log.d(tag, buf.toString());
                    break;
                case LEVEL_W:
                    Log.w(tag, buf.toString());
                    break;
                case LEVEL_E:
                    Log.e(tag, buf.toString());
                    break;
                default:
                    break;
            }
        }
        try {
            writeLog(tag, buf.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将日志写入文件中
     *
     * @param tag
     * @param log
     * @throws IOException
     */
    public static void writeLog(String tag, String log) throws IOException {
        String time = formatter.format(new Date(System.currentTimeMillis()));
        String logger = time + ">>>>>" + tag + ">>>>>" + ">>>>>" + log;
        boolean isWrite = true;// 默认append写入文件
        String dir = FileUtils.getLogDir(MyApplication.getContext());
        File file = new File(dir, LOGFILE);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        //        Log.i("size : ", channel.size()+"");
        // 判断文件的大小
        if (channel.size() >= LOGSIZE) {
            // 覆盖从头开始写
            isWrite = false;
        }
        FileOutputStream fos = new FileOutputStream(file, isWrite);
        if (IS_ENCRYPT && !Constants.DEBUG) { // 对外发布，日志加密
            logger = AESEncoder.encrypt(logger) + "\r\n";
        }
        fos.write(logger.getBytes());
        fos.close();

    }


    /**
     * 读取日志文件
     *
     * @return
     */
    public static String readLog(String fileName) {
        String dir = FileUtils.getLogDir(MyApplication.getContext());
        File file = new File(dir, fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String result;
            while ((result = reader.readLine()) != null) {
                sb.append(result);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    reader = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "未读取到日志文件...";
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



/**
 * mp4转gif
 *
 * @author jinx
 *
 */
public class GifUtils {


    // Windows下 ffmpeg.exe的路径
    // private static String ffmpegEXE =
    // "D:\\Downloads\\ffmpeg-20180528-ebf85d3-win64-static\\bin\\ffmpeg.exe";

    // Linux与mac下 ffmpeg的路径
    private static String ffmpegEXE = "/usr/local/Cellar/ffmpeg/4.1.4_1/bin/ffmpeg";

//    private static String ffmpegEXE = "/usr/local/bin/ffmpeg";

    /**
     * 开辟线程处理流
     * @param process
     */
    private static void dealStream(Process process) {
        if (process == null) {
            return;
        }
        // 处理InputStream的线程
        new Thread() {
            @Override
            public void run() {
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                try {
                    while ((line = in.readLine()) != null) {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        // 处理ErrorStream的线程
        new Thread() {
            @Override
            public void run() {
                BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line = null;
                try {
                    while ((line = err.readLine()) != null) {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        err.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public static boolean covMp4(String inputPath) throws Exception {
        List<String> command = new ArrayList<String>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(inputPath);
        command.add("-c:v");
        command.add("copy");
        command.add("-c:a");
        command.add("aac");
        command.add("-q");
        command.add("1");
        String outPath = inputPath.split("_.mp4")[0] + ".mp4";
        command.add(outPath);
        try {
            Process videoProcess = new ProcessBuilder(command).start();
            dealStream(videoProcess);
            videoProcess.waitFor();
            return true;
        } catch (Exception e) {
        }
        return false;
        // covGif(outPath);
    }

    /**
     * mp4转gif
     * @param inputPath
     * @throws Exception
     */
    public static void covGif(String inputPath) throws Exception {
        List<String> command = new ArrayList<String>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(inputPath);
        command.add("-r");
        command.add("15");
        command.add("-vf");
        command.add("scale=-1:360");
        command.add(inputPath.split(".mp4")[0] + ".gif");
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = null;
        try {
            process = builder.start();
        } catch (IOException e) {
        }
        // 使用这种方式会在瞬间大量消耗CPU和内存等系统资源，所以这里我们需要对流进行处理
        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);

        String line = "";
        while ((line = br.readLine()) != null) {
        }
        if (br != null) {
            br.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }

    }

    public static void main(String[] args) {
        try {
            covPic("/Users/jinx/Downloads/xxxx","00:00:21","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 截取一帧作为图片
     * @param fileName
     * ffmpeg -i /Users/jinx/Downloads/test.mp4 -y -f image2 -ss 00:00:01 -vframes 1 /Users/jinx/Downloads/test.jpeg
     * @return
     */
    public static boolean covPic(String fileName,String time,String outName) {
        List<String> command = new ArrayList<String>();
        command.add(ffmpegEXE);
        command.add("-i");
        command.add(fileName);
        command.add("-y");
        command.add("-f");
        command.add("image2");
        command.add("-ss");
        command.add(time);
        command.add("-vframes");
        command.add("1");
        command.add("-s");
        command.add("544x960");
        if(StringUtil.isNotBlank(outName)){
            command.add(outName);
        }else{
            command.add(fileName+".jpeg");
        }
        System.out.println(command);
        try {
            Process videoProcess = new ProcessBuilder(command).start();
            dealStream(videoProcess);
            videoProcess.waitFor();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}


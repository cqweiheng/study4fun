import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 小电影下载
 * @date 2019/9/15 16:27
 * @author wei.heng
 */
public class FilmDownload {

    public static void main(String[] args) {
        // 下载到哪个目录下
        final String root = "G:/haha";
        String path = "C:/Users/Thinkpad/Desktop/test.txt";
        String prefixAlia = "D_";
        List<String> pathList = getFilePath(path);
        for (String p : pathList) {
            System.out.println(p);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 60L
                        , TimeUnit.SECONDS, new LinkedBlockingQueue<>(50), new NameTreadFactory());
            executor.execute(() -> downloadTs(prefixAlia, root, p));
        }
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    private static List<String> getFilePath(String filePath){
        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 按文件名建立目录，下载远程文件（网上这些个电影全是分块加载的，后续下载完还要做合并）
     * @param dirAlias 目录别名（下载的数据太多了，我按电影类型分类吧）
     * @param targetPath 输出的目标文件目录
     * @param path 远程文件地址
     * @date 2019/9/15 15:06
     * @author wei.heng
     */
    private static void downloadTs(String dirAlias, String targetPath, String path) {
        final String fileSeperator = "/";
        int speratorIndex = path.lastIndexOf(fileSeperator);
        // 获取远程文件名
        String filename = path.substring(speratorIndex + 1);
        // 远程文件目录
        String remoteDir = path.substring(0, speratorIndex);
        // 获取远程文件目录名称
        String dir = remoteDir.substring(remoteDir.lastIndexOf(fileSeperator) + 1);
        // 文件太多，前缀加个别名吧
        dir = dirAlias + dir;
        // 分块文件名称
        String dynamicFileName = filename.substring(0,filename.length() - 4);
        String suffix = ".ts";

        BufferedInputStream bis = null;
        HttpURLConnection conn = null;
        // 这里随意给了个值，保证文件能够全部读取完就成
        int filePartSize = 3000;
        for (int partIndex = 0; partIndex < filePartSize; partIndex++) {
            try {
                System.out.println("partIndexIndex:" + partIndex);
                // 检查文件是否已存在，避免浪费资源，重复请求
                // 文件名 = 本地目录（入参） + 文件名命名的目录（程序常见） + 分块文件名称（dynamicFileName + partIndex + suffix）
                String outputFile = targetPath + fileSeperator + dir + fileSeperator + dynamicFileName + partIndex + suffix;
                File f = new File(outputFile);
                if(f.exists()){
                    System.out.println("文件已存在：" + f);
                    continue;
                }
                String targetUrl = remoteDir + fileSeperator + dynamicFileName + partIndex + suffix;
                URL url = new URL(targetUrl);
                conn = (HttpURLConnection)url.openConnection();
                // 设置通用的请求属性
                setRequestProperties(conn);
                // 建立连接
                conn.connect();
                // 获取响应码
                int httpResult = conn.getResponseCode();
                System.out.println("httpResult::"+httpResult);
                if(httpResult==HttpURLConnection.HTTP_OK){
                    // 创建文件目录
                    File direction = new File(targetPath + fileSeperator + dir);
                    if(!direction.exists()){
                        if(!direction.mkdirs()){
                            throw new RuntimeException("创建文件目录失败");
                        }
                    }
                    Files.copy(conn.getInputStream(), Paths.get(outputFile));
                    System.out.println("real length::"+conn.getContentLength());
                } else if(httpResult==HttpURLConnection.HTTP_NOT_FOUND){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                releaseSource(bis, conn);
            }
        }

    }

    private static void releaseSource(BufferedInputStream bis, HttpURLConnection conn) {
        if(bis != null){
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            conn.disconnect();
        }
    }

    private static void setRequestProperties(HttpURLConnection conn) throws ProtocolException {
        // 使用 URL 连接进行输出
        conn.setDoOutput(true);
        // 使用 URL 连接进行输入
        conn.setDoInput(true);
        // 忽略缓存
        conn.setUseCaches(false);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
        conn.setRequestProperty("Host", "video7.achxc.com:8083");
    }

}

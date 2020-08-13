import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 合并文件
 * @date 2019/9/15 15:04
 * @author wei.heng
 */
public class MergeFile {

	public static void main(String[] args) {

		String dir = "G:/haha/J_GC1211GTH";
		String suffix = ".ts";
		String fileSeperator = "/";
		List<File> files = getFiles(dir, suffix);
		// 按文件名排序
		reSortList(files);

		// 合并文件
		File newFile = new File(dir + fileSeperator + dir	.split("_")[1]  + suffix);
		RandomAccessFile accessFile = null;
		long totalSize = 0;
		for (File file : files) {

			// 这里由于每个文件的大小都是不固定的，无法得知下一个文件写入的起始位置，只有用同步线程处理了
			FileInputStream fis = null;
			try {
				// 目标文件地址
				accessFile = new RandomAccessFile(newFile, "rw");
				// 移动到写入的节点
				accessFile.seek(totalSize);

				fis = new FileInputStream(file);
				byte[] bytes = new byte[1024*100];
				int r;
				while((r = fis.read(bytes)) != -1){
					accessFile.write(bytes, 0, r);
				}
				long fileSize = file.length();
				totalSize += fileSize;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fis != null){
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if(accessFile != null){
			try {
				accessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 * 按文件末尾数字进行升序排列
	 * @param files 文件列表集合
	 * @date 2019/9/15 16:09
	 * @author wei.heng
	 */
	private static void reSortList(List<File> files) {
		files.sort((o1, o2) -> {
			String firstName = o1.getName();
			String secondName = o2.getName();
			// 正则匹配，获取文件末尾的数字
			String regex = "\\d+\\.ts";
			Pattern pattern = Pattern.compile(regex);

			Matcher m1 = pattern.matcher(firstName);
			Matcher m2 = pattern.matcher(secondName);

			if(m1.find() && m2.find()){
				String firstStr = m1.group();
				String secondStr = m2.group();
				if(firstStr != null && secondStr != null){
					int firstIndex = Integer.parseInt(firstStr.substring(0, firstStr.length() - 3));
					int secondIndex = Integer.parseInt(secondStr.substring(0, secondStr.length() - 3));
					if( firstIndex < secondIndex){
						return -1;
					} else if (firstIndex > secondIndex){
						return 1;
					}
				}
			}
			return 0;
		});
	}

	/**
	 *
	 * * 获取目录下的所有文件
	 * @param path 目录路径
	 * @param suffix 文件后缀
	 * @date 2019/9/15 15:05
	 * @author wei.heng
	 */
	private static List<File> getFiles(String path, String suffix){
		File root = new File(path);
		List<File> files = new ArrayList<>(0);
		if(!root.isDirectory()){
			if(root.getName().endsWith(suffix)){
				files.add(root);
			}
		}else{
			File[] subFiles = root.listFiles();
			assert subFiles != null;
			for(File f : subFiles){
				files.addAll(getFiles(f.getAbsolutePath(), suffix));
			}
		}
		return files;
	}
}

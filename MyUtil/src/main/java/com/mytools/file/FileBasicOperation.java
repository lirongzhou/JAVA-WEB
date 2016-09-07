package com.mytools.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.mytools.base.ToolsBase;
/**
 * 文件的基本操作
 * @author dell
 *
 */
public class FileBasicOperation extends ToolsBase {

	/**
	 * 获取一个文件
	 * @param fileName
	 * @return 如果获取成功返回该文件 否则返回 null
	 */
	public File redFile(String fileName) {

		if (super.isNull(fileName))
			return null;
		File file = new File(fileName);
		if (fileExists(file))
			return file;
		else
			return null;

	};

	/**
	 * 根据一个文件的路径读取一个文件 返回String 类型文件内容
	 * @param fileName
	 * @return  返回文件内容
	 * @throws IOException
	 */
	public String redFileToString(String fileName) throws IOException {
		if (super.isNull(fileName))
			return null;
		File file = new File(fileName);

		if (fileExists(file)) {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			StringBuffer strBuffer = new StringBuffer();
			String temp = null;
			temp = reader.readLine();

			while (temp != null) {
				strBuffer.append(temp + "\r\n");
				temp = reader.readLine();
			}
			reader.close();
			return strBuffer.toString();
		}
		return null;
	};

	/**
	 * 根据一个文件的路径读取一个文件 返回List<byte[]>类型文件内容
	 * @param fileName
	 * @return 
	 * @throws IOException
	 */
	public List<byte[]> redFileToByBytes(String fileName) throws IOException {
		if (super.isNull(fileName))
			return null;
		File file = new File(fileName);
		List<byte[]> bytes = new ArrayList<byte[]>();
		if (fileExists(file)) {

			FileInputStream fis = new FileInputStream(file);
			byte[] buf = new byte[1024];
			StringBuffer sb = new StringBuffer();
			if ((fis.read(buf)) == -1) {
				return null;
			}
			while ((fis.read(buf)) != -1) {
				bytes.add(buf);
				buf = new byte[1024];// 锟斤拷锟斤拷锟斤拷桑锟斤拷锟斤拷锟斤拷锟较次讹拷取锟斤拷锟斤拷锟斤拷馗锟�
			}
			return bytes;
		}

		return null;
	}

	/**
	 * copy 一个文件 按照数据流的方式
	 * @param oldFilePath 旧文件
	 * @param newFilePath 目标文件
	 * @return
	 * @throws IOException
	 */
	public boolean copyFileInputStream(String oldFilePath, String newFilePath) throws IOException {
		if (super.isNull(oldFilePath))
			return false;
		if (super.isNull(newFilePath))
			return false;
		if (!fileExists(new File(oldFilePath)))
			return false;
		List list = redFileToByBytes(oldFilePath);

		File file = new File(newFilePath);

		if (!file.exists())
			file.createNewFile();

		return setFile(list, newFilePath);
	}

	/**
	 * copy 一个文件 按照字符串的方式
	 * @param oldFilePath
	 * @param newFilePath
	 * @return
	 * @throws IOException
	 */
	public boolean copyFileBufferedWrite(String oldFilePath, String newFilePath) throws IOException {
		if (super.isNull(oldFilePath))
			return false;
		if (super.isNull(newFilePath))
			return false;
		if (!fileExists(new File(oldFilePath)))
			return false;
		File file = new File(newFilePath);

		if (!file.exists())
			file.createNewFile();
		else
			return false;

		return setFile(redFileToString(oldFilePath), newFilePath);
	}

	/**
	 * 把内容写入到目标文件
	 * @param content  文件内容
	 * @param filePath  目标文件
	 * @return  返回是否执行成功
	 * @throws IOException
	 */
	public boolean setFile(String content, String filePath) throws IOException {
		if (super.isNull(content))
			return false;
		if (super.isNull(filePath))
			return false;
		File file = new File(filePath);
		if (!file.exists())
			file.createNewFile();

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
		bufferedWriter.write(content);
		bufferedWriter.flush();
		bufferedWriter.close();
		return true;
	}

	/**
	 * 把List<byte[]> listByte内容写入到目标文件
	 * @param listByte byte类型的数据
	 * @return 返回执行结果 true| false
	 * @throws IOException
	 */
	public boolean setFile(List<byte[]> listByte, String filePath) throws IOException {
		if (super.isNull(listByte))
			return false;
		if (super.isNull(filePath))
			return false;
		File file = new File(filePath);

		if (!file.exists())
			file.createNewFile();

		FileOutputStream out = new FileOutputStream(file);

		byte buffer[];
		for (int i = 0; i < listByte.size(); i++) {
			buffer = (byte[]) listByte.get(i);
			for (int y = 0; y < buffer.length; y++)
				out.write(buffer[y]);
		}

		out.close();
		return false;
	}

	/**
	 * 文件的重新命名
	 * @param path 文件路径
	 * @param oldname 旧名
	 * @param newname 新名
	 * @return
	 */
	public boolean renameFile(String path, String oldname, String newname) {
		if (super.isNull(path))
			return false;
		if (super.isNull(oldname))
			return false;
		if (super.isNull(newname))
			return false;
		if (!oldname.equals(newname)) {
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (newfile.exists())
				System.out.println(newname + "这个名字的文件已经存在");
			else {
				oldfile.renameTo(newfile);
			}
		}
		return false;
	}

	/**
	 * 移动文件
	 * @param filename
	 * @param oldpath 旧文件地址
	 * @param newpath 目标文件地址
	 * @param cover   是否覆盖
	 * @return boolean 
	 */
	public boolean removeFile(String filename, String oldpath, String newpath, boolean cover) {
		System.out.println("oldpath" + oldpath);
		System.out.println("newpath" + newpath);
		if (super.isNull(filename))
			return false;
		if (super.isNull(oldpath))
			return false;
		if (super.isNull(newpath))
			return false;
		if (!oldpath.equals(newpath)) {
			File oldfile = new File(oldpath + "/" + filename);
			File newfile = new File(newpath + "/" + filename);
			if (newfile.exists()) {
				if (cover) {
					oldfile.renameTo(newfile);
					oldfile.delete();
					return true;
				} else {
					System.out.println("已经存在这个文件" + filename);
					return false;
				}
			} else {
				oldfile.renameTo(newfile);
				oldfile.delete();
				return true;
			}
		}
		return false;
	}
    /**
     * 移动文件夹 
     * @param from
     * @param to
     * @throws Exception
     */
	public static void fileMove(String from, String to) throws Exception {
		try {
			File dir = new File(from);
			File[] files = dir.listFiles();
			if (files == null)
				return;
			File moveDir = new File(to);
			if (!moveDir.exists()) {
				moveDir.mkdirs();
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					fileMove(files[i].getPath(), to + "\\" + files[i].getName());
					files[i].delete();
				}
				File moveFile = new File(moveDir.getPath() + "\\"
						+ files[i].getName());
				if (moveFile.exists()) {
					moveFile.delete();
				}
				files[i].renameTo(moveFile);
				System.out.println(files[i] + "");
			}
		} catch (Exception e) {
			throw e;
		}
	}


	public boolean fileExists(File file) {
		if (super.isNull(file))
			return false;
		if (file.exists() || !file.isDirectory()) {
			return true;
		}
		return false;
	}

}

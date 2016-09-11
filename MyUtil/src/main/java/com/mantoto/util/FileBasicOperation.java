package com.mantoto.util;

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

public class FileBasicOperation  {
	public  boolean isNull(Object o) {

		if (null == o || "".equals(o))
			return true;
		else
			return false;
	}
	/**
	 * ��ȡ�ļ�����
	 * 
	 * @param fileName
	 * @return ����һ���ļ���ʵ��
	 */
	public File redFile(String fileName) {

		if (isNull(fileName))
			return null;
		File file = new File(fileName);
		if (fileExists(file))
			return file;
		else
			return null;

	};

	/**
	 * ��ȡ�ļ�����
	 * 
	 * @param fileName
	 * @return �����ļ����� string ����
	 * @throws IOException
	 */
	public String redFileToString(String fileName) throws IOException {
		if (isNull(fileName))
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
	public String redFileToString(File file) throws IOException {
		if (isNull(file))
			return null;
		

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
	 * ��ȡ�ļ�����
	 * 
	 * @param fileName
	 * @return ����һ��list byte ��
	 * @throws IOException
	 */
	public List<byte[]> redFileToByBytes(String fileName) throws IOException {
		if (isNull(fileName))
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
				buf = new byte[1024];// ������ɣ�������ϴζ�ȡ������ظ�
			}
			return bytes;
		}

		return null;
	}

	/**
	 * ����һ���ļ�
	 * 
	 * @param oldFilePath
	 *            Ҫ���Ƶ��ļ�λ��
	 * @param newFilePath
	 *            ���ƺõ��ļ�λ��
	 * @return
	 * @throws IOException
	 */
	public boolean copyFilenputStream(String oldFilePath, String newFilePath) throws IOException {
		if (isNull(oldFilePath))
			return false;
		if (isNull(newFilePath))
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
	 * ����һ���ļ� ��BuffereWriteʵ��
	 * 
	 * @param oldFilePath
	 * @param newFilePath
	 * @return
	 * @throws IOException
	 */
	public boolean copyFileBufferedWrite(String oldFilePath, String newFilePath) throws IOException {
		if (isNull(oldFilePath))
			return false;
		if (isNull(newFilePath))
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
	 * д�ļ�
	 * 
	 * @param content
	 *            д���ļ�������
	 * @param filePath
	 * @return �Ƿ�д��ɹ�
	 * @throws IOException
	 */
	public boolean setFile(String content, String filePath) throws IOException {
		if (isNull(content))
			return false;
		if (isNull(filePath))
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
	 * д�ļ�
	 * 
	 * @param listByte
	 * @return
	 * @throws IOException
	 */
	public boolean setFile(List<byte[]> listByte, String filePath) throws IOException {
		if (isNull(listByte))
			return false;
		if (isNull(filePath))
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
	 * ���������ļ�����
	 * 
	 * @param path
	 * @param oldname
	 * @param newname
	 * @return
	 */
	public boolean renameFile(String path, String oldname, String newname) {
		if (isNull(path))
			return false;
		if (isNull(oldname))
			return false;
		if (isNull(newname))
			return false;
		if (!oldname.equals(newname)) {// �µ��ļ������ǰ�ļ���ͬʱ,���б�Ҫ����������
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (newfile.exists())// ���ڸ�Ŀ¼���Ѿ���һ���ļ������ļ�����ͬ��������������
				System.out.println(newname + "�Ѿ����ڣ�");
			else {
				oldfile.renameTo(newfile);
			}
		}
		return false;
	}

	/**
	 * �ƶ��ļ�
	 * 
	 * @param filename
	 *            �ļ�����
	 * @param oldpath
	 *            �ɵĵ�ַ
	 * @param newpath
	 *            �µĵ�ַ
	 * @param cover
	 *            �Ƿ񸲸�
	 * @return boolean �Ƿ��ƶ��ɹ�
	 */
	public boolean removeFile(String filename, String oldpath, String newpath, boolean cover) {
		System.out.println("oldpath" + oldpath);
		System.out.println("newpath" + newpath);
		if (isNull(filename))
			return false;
		if (isNull(oldpath))
			return false;
		if (isNull(newpath))
			return false;
		if (!oldpath.equals(newpath)) {
			File oldfile = new File(oldpath + "/" + filename);
			File newfile = new File(newpath + "/" + filename);
			if (newfile.exists()) {// ���ڴ�ת��Ŀ¼�£��Ѿ����ڴ�ת���ļ�
				if (cover) {// 是否覆盖

					oldfile.renameTo(newfile);
					oldfile.delete();
					return true;
				} else {
					System.out.println("����Ŀ¼���Ѿ����ڣ�" + filename);
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

	public static void fileMove(String from, String to) throws Exception {// 移动指定文件夹内的全部文件
		try {
			File dir = new File(from);
			File[] files = dir.listFiles();// 将文件或文件夹放入文件集
			if (files == null)// 判断文件集是否为空
				return;
			File moveDir = new File(to);// 创建目标目录
			if (!moveDir.exists()) {// 判断目标目录是否存在
				moveDir.mkdirs();// 不存在则创建
			}
			for (int i = 0; i < files.length; i++) {// 遍历文件集
				if (files[i].isDirectory()) {// 如果是文件夹或目录,则递归调用fileMove方法，直到获得目录下的文件
					fileMove(files[i].getPath(), to + "\\" + files[i].getName());// 递归移动文件
					files[i].delete();// 删除文件所在原目录
				}
				File moveFile = new File(moveDir.getPath() + "\\"// 将文件目录放入移动后的目录
						+ files[i].getName());
				if (moveFile.exists()) {// 目标文件夹下存在的话，删除
					moveFile.delete();
				}
				files[i].renameTo(moveFile);// 移动文件
				System.out.println(files[i] + " 移动成功");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * �ж�����ļ��Ƿ���� �Ƿ����ļ���
	 * 
	 * @param file
	 * @return
	 */
	public boolean fileExists(File file) {
		if (isNull(file))
			return false;
		if (file.exists() || !file.isDirectory()) {
			return true;
		}
		return false;
	}

}

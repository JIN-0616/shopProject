package com.springlesson.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Mode;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImgFileUploadUtil {
	private MultipartFile file;
	private String savePath;
	private String fileName; //board_, member_, product
	private String newFileName; //person.jpg
	private String extention; // jpg, png
	private boolean newFileFlag = false;
	private File newFile = null;
	private File thumbFile = null;

	public File getNewFile() {
		return newFile;
	}//end
	
	public String getNewFileName() {
		return newFileName;
	}//end
	
	public ImgFileUploadUtil(String savePath, MultipartFile file, String fileName){
		this.file = file;
		this.fileName = fileName;
		this.savePath = savePath;
		this.extention = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf(".")+1); //.jpg 확장자 찾기
		this.newFileName = fileName+"_"+System.currentTimeMillis()+"."+extention;
	}//end
	
	public boolean newFile(){
		//File.separstor = "\\";
	/*try(FileOutputStream fos = new FileOutputStream(savePath + File.separator + newFileName)){
		byte fileData[] = file.getBytes();
		fos.write(fileData);
	}catch(Exception e){
		e.printStackTrace();
	}*/
		try{
			newFile = new File(savePath, newFileName);
			FileCopyUtils.copy(file.getBytes(), new File(savePath, newFileName));
			newFileFlag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return newFileFlag;
	}
	public String makeThumbnail(int thumbnail_height){ //높이 비율로 가로를 고정
		String thumbnailName = null;
		if(newFileFlag){
			try{
				//file중에서 속성이 image인 파일을 이미지로 사용할 수 있도록 가져온다.
				BufferedImage originImage = ImageIO.read(newFile);
				//기존 이미지가 썸네일보다 작으면 수정 할 필요가 없다.
				if(originImage.getHeight()>thumbnail_height){
					thumbnailName = "thumb_"+newFileName;
					thumbFile = new File(savePath, thumbnailName);
					BufferedImage thumbImage = Scalr.resize(originImage, Scalr.Method.QUALITY, Mode.FIT_TO_HEIGHT, thumbnail_height);
					ImageIO.write(thumbImage, extention, thumbFile);
					//썸네일로 만든 이미지를 담을 그릇
					/*Graphics2D graphics = thumbImage.createGraphics();
					graphics.drawImage(originImage, 0, 0, thumbnail_width, thumbnail_height, null);
					ImageIO.write(thumbImage, extention, thumbFile);*/
				}else{
					/*방법1*/
					/*FileInputStream fis = new FileInputStream(newFile);
					FileOutputStream fos = new FileOutputStream(thumbFile);
					int data = 0;
					while((data = fis.read())!=-1){
						fos.write(data);
					}
					fis.close();
					fos.close();*/
					
					/*방법2*/
					//저장한 이미지 파일이 바꿔야 할 thumbnail보다 작을 시 그냥 복사함.
					byte[] newFiledata = FileCopyUtils.copyToByteArray(newFile);
					FileCopyUtils.copy(newFiledata, thumbFile);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return thumbnailName;
	}//end
	
	public boolean newFileDelete(){
		boolean delete = false;
		if(newFile!=null){
			delete = newFile.delete();
		}
		return delete;
	}//end
	
	public boolean thumbFileDelete(){
		boolean delete = false;
		if(thumbFile!=null){
			delete = thumbFile.delete();
		}
		return delete;
	}//end
	
}//class END

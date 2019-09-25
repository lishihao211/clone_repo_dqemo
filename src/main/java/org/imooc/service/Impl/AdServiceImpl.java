package org.imooc.service.Impl;

import java.io.File;
import java.io.IOException;

import org.imooc.bean.Ad;
import org.imooc.dao.AdDao;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {

	@Autowired
	public AdDao adDao;

	@Value("${adImage.savePath}")
	private String adImageSavePath;

	@Value("${adImage.url}")
	private String adImageUrl;

	@Override
	//TODO 可以改成获取失败详情原因
	public boolean add(AdDto adDto) {
		Ad ad = new Ad();
		ad.setTitle(adDto.getTitle());
		ad.setLink(adDto.getLink());
		ad.setWeight(adDto.getWeight());
		if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
			//以防相同名字存不进去时间搓当前时间 + 图片名
            String fileName = (System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename());
			/** file当前目录 .*/
			/** 图片的文件夹.*/
			File file = new File(adImageSavePath + fileName);
			File fileFolder = new File(adImageSavePath);
			if (!fileFolder.exists()){
				/** 如果这个目录不存在的话,多级目录一并创建 .*/
				fileFolder.mkdirs();
			}
			try {
				/** 把图片转移到一个文件 .*/
				adDto.getImgFile().transferTo(file);
				ad.setImgFileName(fileName);
				adDao.insert(ad);
				return true;

			} catch (IllegalStateException | IOException e) {
				//TODO 需要添加日志
				return false;
			}

		}else {
			return false;
		}
	}
}

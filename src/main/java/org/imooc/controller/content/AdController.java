package org.imooc.controller.content;

import org.imooc.constant.PageCodeEnum;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad")
public class AdController {

	@Autowired
	private AdService adService;

	@RequestMapping
	public String init() {
		return "/content/adList";
	}

	@RequestMapping("/addInit")
	public String addInit() {
		return "/content/adAdd";
	}

	@RequestMapping("/add")
	public String add(AdDto adDto, Model model){
		if (adService.add(adDto)){
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);
		}else {
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAIL);
		}
		return "/content/adAdd";
	}
}

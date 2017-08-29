package com.ningbo.garbage.controller;

/**
 * Created by qiuch on 2017/8/9.
 */


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ningbo.garbage.GarbageApplication;
import com.ningbo.garbage.dao.ClassificationDao;
import com.ningbo.garbage.dao.GarbageDao;
import com.ningbo.garbage.dao.KeywordsDao;
import com.ningbo.garbage.po.GarbagePo;
import com.ningbo.garbage.po.KeywordsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class FrontController {
    @Autowired
    KeywordsDao keywordsDao;

    @Autowired
    GarbageDao garbageDao;

    @Autowired
    ClassificationDao classificationDao;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("chuyu", classificationDao.findByParentName("厨余垃圾"));
        model.addAttribute("huishou", classificationDao.findByParentName("可回收垃圾"));
        model.addAttribute("youhai", classificationDao.findByParentName("有害垃圾"));
        model.addAttribute("qita", classificationDao.findByParentName("其他垃圾"));
        return "index";
    }

    @RequestMapping("/classifaction")
    @ResponseBody
    String classifaction(String type) {
        if (StringUtils.isEmpty(type)) {
            return "{\"success\":0}";
        }
        Map<String, Object> result = new HashMap<>();
        switch (type) {
            case "green":
                result.put("success", 1);
                result.put("cat_title", "厨余垃圾");
                result.put("cat_description", GarbageApplication.BASIC_CLASSIFICATION.get("厨余垃圾"));
                break;
            case "blue":
                result.put("success", 1);
                result.put("cat_title", "可回收垃圾");
                result.put("cat_description", GarbageApplication.BASIC_CLASSIFICATION.get("可回收垃圾"));
                break;
            case "red":
                result.put("success", 1);
                result.put("cat_title", "有害垃圾");
                result.put("cat_description", GarbageApplication.BASIC_CLASSIFICATION.get("有害垃圾"));
                break;
            case "black":
                result.put("success", 1);
                result.put("cat_title", "其他垃圾");
                result.put("cat_description", GarbageApplication.BASIC_CLASSIFICATION.get("其他垃圾"));
                break;
            default:
                result.put("success", 0);
                result.put("msg", "暂无结果");
                break;
        }

        try {
            return new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"success\":0}";
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    String search(String keywords) {
        if (StringUtils.isEmpty(keywords)) {
            return "{\"success\":0}";
        }
        Map<String, Object> result = new HashMap<>();

        GarbagePo garbagePo = garbageDao.findByName(keywords);
        if (garbagePo == null) {
            if (keywordsDao.existKeywords(keywords) == 0) {
                KeywordsPo keywordsPo = new KeywordsPo();
                keywordsPo.setKeywords(keywords);
                keywordsDao.save(keywordsPo);
            }
            result.put("success", 0);
            result.put("msg", "暂无结果");
        } else {
            result.put("success", 1);
            result.put("cat_title", garbagePo.getpName());
            result.put("cat_description", GarbageApplication.BASIC_CLASSIFICATION.get(garbagePo.getpName()));
        }

        try {
            return new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"success\":0}";
        }
    }

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(FrontController.class, args);
//    }
}

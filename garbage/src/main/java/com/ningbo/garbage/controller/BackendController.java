package com.ningbo.garbage.controller;

/**
 * Created by qiuch on 2017/8/9.
 */


import com.ningbo.garbage.GarbageApplication;
import com.ningbo.garbage.dao.ClassificationDao;
import com.ningbo.garbage.dao.GarbageDao;
import com.ningbo.garbage.dao.KeywordsDao;
import com.ningbo.garbage.po.ClassificationPo;
import com.ningbo.garbage.po.GarbagePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@EnableAutoConfiguration
public class BackendController {

    final String sessionKey = "login_session";

    @Autowired
    KeywordsDao keywordsDao;
    @Autowired
    ClassificationDao classificationDao;
    @Autowired
    GarbageDao garbageDao;

    @RequestMapping("/login")
    String adminLogin(String username, String password, String is_submit, Model model, HttpSession session) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            session.setAttribute(sessionKey, UUID.randomUUID().toString());
            return "redirect:/admin/classify";
        } else {
            if ("true".equals(is_submit)) {
                if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
                    model.addAttribute("msg", "请输入用户名或密码");
                } else {
                    model.addAttribute("msg", "用户名或密码有误");
                }
            }
            return "backend/login";
        }
    }

    @RequestMapping("/classify")
    String classificationList(Model model, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "pName");
        model.addAttribute("clist", classificationDao.findAll(sort));
        model.addAttribute("plist", GarbageApplication.BASIC_CLASSIFICATION.keySet());
        return "backend/classification";
    }

    @RequestMapping("/classify_edit")
    String editClassify(ClassificationPo classificationPo, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        classificationDao.save(classificationPo);
        return "redirect:/admin/classify";
    }

    @RequestMapping("/classify_del")
    String delClassify(Long cid, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        if (cid != null) {
            classificationDao.delete(cid);
        }
        return "redirect:/admin/classify";
    }

    @RequestMapping("/garbage")
    String garbageList(Model model, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "gName");
        model.addAttribute("clist", garbageDao.findAll(sort));
        model.addAttribute("plist", GarbageApplication.BASIC_CLASSIFICATION.keySet());
        return "backend/garbage";
    }

    @RequestMapping("/garbage_edit")
    String editGarbage(GarbagePo garbagePo, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        garbageDao.save(garbagePo);
        return "redirect:/admin/garbage";
    }

    @RequestMapping("/garbage_del")
    String delGarbage(Long gid, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        if (gid != null) {
            garbageDao.delete(gid);
        }
        return "redirect:/admin/garbage";
    }

    @RequestMapping("/keywords")
    String keywords(Model model, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        model.addAttribute("klist",keywordsDao.findAll());
        return "backend/keywords";
    }

    @RequestMapping("/keywords_del")
    String delKeywords(Long kid, HttpSession session) {
        if (session.getAttribute(sessionKey) == null) {
            return "redirect:/admin/login";
        }
        if (kid != null) {
            keywordsDao.delete(kid);
        }
        return "redirect:/admin/keywords";
    }

}

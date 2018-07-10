package com.zhihu.controller;


import com.zhihu.model.Comment;
import com.zhihu.model.EntityType;
import com.zhihu.model.HostHolder;
import com.zhihu.service.CommentService;
import com.zhihu.service.LikeService;
import com.zhihu.util.ZhihuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {
    @Autowired
    LikeService likeService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    CommentService commentService;

    @RequestMapping(path = {"/like"}, method = {RequestMethod.POST})
    @ResponseBody
    public String like(@RequestParam("commentId") int commentId) {
        if (hostHolder.getUser() == null) {
            return ZhihuUtil.getJSONString(999);
        }

        long likeCount = likeService.like(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, commentId);
        return ZhihuUtil.getJSONString(0, String.valueOf(likeCount));
    }

    @RequestMapping(path = {"/dislike"}, method = {RequestMethod.POST})
    @ResponseBody
    public String dislike(@RequestParam("commentId") int commentId) {
        if (hostHolder.getUser() == null) {
            return ZhihuUtil.getJSONString(999);
        }
        long likeCount = likeService.disLike(hostHolder.getUser().getId(), EntityType.ENTITY_COMMENT, commentId);
        return ZhihuUtil.getJSONString(0, String.valueOf(likeCount));
    }
}

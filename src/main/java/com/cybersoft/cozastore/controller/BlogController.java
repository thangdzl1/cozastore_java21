package com.cybersoft.cozastore.controller;

import com.cybersoft.cozastore.entity.ArchiveEntity;
import com.cybersoft.cozastore.entity.TagEntity;
import com.cybersoft.cozastore.payload.response.BaseResponse;
import com.cybersoft.cozastore.payload.response.BlogResponse;
import com.cybersoft.cozastore.service.BlogService;
import com.cybersoft.cozastore.service.Imp.ArchiveServiceImp;
import com.cybersoft.cozastore.service.Imp.BlogServiceImp;
import com.cybersoft.cozastore.service.Imp.TagServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogServiceImp blogServiceImp;

    @GetMapping("")
    ResponseEntity<?> findAllBlog(){
        List<BlogResponse> list = blogServiceImp.findAllBlog();

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        baseResponse.setStatusCode(200);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}

package com.cybersoft.cozastore.service;

import com.cybersoft.cozastore.entity.TagEntity;
import com.cybersoft.cozastore.exception.CustomException;
import com.cybersoft.cozastore.repository.BlogRepository;
import com.cybersoft.cozastore.repository.TagRepository;
import com.cybersoft.cozastore.service.Imp.TagServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements TagServiceImp {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<TagEntity> findAll(){
        try{
            return tagRepository.findAll();
        }catch (Exception e){
            throw new CustomException("Error findAll in TagService " + e.getMessage());
        }
    }

    @Override
    public List<TagEntity> findAllTagByBlogId(int id){
        try{
            return tagRepository.findAllByBlogId(id);
        }catch (Exception e){
            throw new CustomException("Error findAll in TagService " + e.getMessage());
        }
    }
}

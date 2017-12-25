package com.stalary.controller;

import com.stalary.aspect.HttpAspect;
import com.stalary.domain.Girl;
import com.stalary.domain.Result;
import com.stalary.repository.GirlRepository;
import com.stalary.service.GirlService;
import com.stalary.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Stalary
 * @description
 * @date 2017/10/21
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            // 当有错误时获取错误信息
            return null;
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    // 查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(
            @PathVariable("id") Integer id,
            HttpServletRequest request,
            HttpServletResponse response) {
        logger.info("URL: " + request.getRequestURL());
        logger.info("URI: " + request.getRequestURI());
        return girlRepository.findOne(id);
    }

    // 更新一个女生
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            logger.error(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Girl newGirl = new Girl();
        newGirl.setId(girl.getId());
        newGirl.setCupSize(girl.getCupSize());
        newGirl.setAge(girl.getAge());

        return girlRepository.save(girl);
    }

    // 删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    // 通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 添加两个女生，测试事务是否回滚
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    @GetMapping(value = "/testCreate")
    public Result create() {
        Girl girl = new Girl();
        girl.setCupSize("B");
        girl.setAge(20);
        girl.setMoney(200.0);
        girlRepository.save(girl);
        int id = girl.getId();
        return ResultUtil.success(id);
    }
}

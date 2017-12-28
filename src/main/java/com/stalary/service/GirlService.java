package com.stalary.service;

import com.stalary.domain.Girl;
import com.stalary.enums.ResultEnum;
import com.stalary.exception.MyException;
import com.stalary.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Stalary
 * @description
 * @date 2017/10/21
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlA.setMoney(200.0);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new MyException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new MyException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 通过用户id，查找名下的女生
     */
    public List<Girl> findByUserId(Integer id) {
        return girlRepository.findByUserId(id);
    }
}

package com.hgz.optim;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hgz.optim.dao.OptimUserDao;
import com.hgz.optim.dao.UserDao;
import com.hgz.optim.entity.OptimUser;
import com.hgz.optim.entity.UserEntity;
import com.hgz.optim.entity.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/21 20:31
 */
@Slf4j
@SpringBootTest
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void selectById() {
        UserEntity userEntity = userDao.selectById(1L);
        log.info("查询数据:{}", userEntity);
    }

    @Test
    public void list() {
        List<UserEntity> list = userDao.getList("丘福");
        log.info("查询数据个数:{}，第一个数据:{}", list.size(), list.get(0));
    }

    @Test
    public void get() {
        List<UserEntity> list = userDao.get("丘福", "052J22");
        log.info("查询数据个数:{}，第一个数据:{}", list.size(), list.get(0));
    }

    @Test
    public void count() {
        Long count = userDao.count();
        log.info("查询数据个数:{}", count);
    }

    @Test
    public void like() {
        List<UserEntity> list = userDao.selectLike("丘福", "5");
        log.info("查询数据个数:{}，第一个数据:{}", list.size(), list.get(0));
    }


    /**
     * 分页查询
     */
    @Test
    public void selectList() {
       /* List<UserEntity> list = userDao.selectList("丘福", "5");
        log.info("查询数据个数:{}，第一个数据:{}", list.size(), list.get(0));

        Page<UserEntity> page = PageHelper.startPage(1, 4);
        List<UserEntity> list2 = userDao.selectList("丘福", null);
        log.info("查询数据个数:{}，第一个数据:{}", list2.size(), list.get(0));
        log.info("分页数据:{}", page);*/


        Page<UserEntity> page1 = PageHelper.startPage(1, 500);
        List<UserEntity> list3 = userDao.selectList(null, null);
        log.info("查询数据个数:{}，第一个数据:{}", list3.size(), list3.get(0));
        log.info("分页数据:{}", page1);
    }

    @Test
    public void select() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("丘福");
        userEntity.setPassWord("5");
        List<UserEntity> list = userDao.selectEntity(userEntity);
        log.info("查询到数据:{}", list);

        UserVo userVo = new UserVo();
        userVo.setUserName("丘福");
        userVo.setPassWord("5");
        List<UserEntity> list1 = userDao.selectEntity2(userVo);
        log.info("查询到数据:{}", list1);
    }

    @Test
    public void selectIn() {
        List<Long> list=new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        List<UserEntity> list1 = userDao.selectIn(list);
        log.info("查询到数据:{}", list1);
    }


    @Test
    public void selectMobileIn() {
        List<String> list=new ArrayList<>();
        list.add("15102098916");
        list.add("13207093652");
        List<UserEntity> list1 = userDao.selectMobileIn(list);
        log.info("查询到数据:{}", list1);
    }

    @Autowired
    private OptimUserDao optimUserDao;

    @Test
    public void insert(){
        OptimUser optimUser=new OptimUser();
        optimUser.setUserName("孙悟空");
        optimUser.setPassWord("694454");
        optimUser.setAddress("上海");
        optimUser.setMobile("18039317141");
        optimUser.setCeratedBy("system");
        optimUser.setCreatedTime(LocalDateTime.now());
        optimUser.setUpdateBy("system");
       // optimUser.setUpdateTime(LocalDateTime.now());
        Long aLong = optimUserDao.insert(optimUser);
        log.info("id:{}",optimUser.getId());
    }


    @Test
    public void insertList(){
        OptimUser optimUser=new OptimUser();
        optimUser.setUserName("孙悟空");
        optimUser.setPassWord("694454");
        optimUser.setAddress("上海");
        optimUser.setMobile("18039317141");
        optimUser.setCeratedBy("system");
        optimUser.setCreatedTime(LocalDateTime.now());
        optimUser.setUpdateBy("system");

        List<OptimUser> list=new ArrayList<>();
        list.add(optimUser);
        OptimUser optimUser1=new OptimUser();
        optimUser1.setUserName("孙悟饭");
        optimUser1.setPassWord("99999");
        optimUser1.setAddress("上海");
        optimUser1.setMobile("18039317141");
        optimUser1.setCeratedBy("system");
        optimUser1.setCreatedTime(LocalDateTime.now());
        optimUser1.setUpdateBy("system");
        list.add(optimUser1);
        Long aLong = optimUserDao.insertList(list);
        log.info("保存成功:{}",aLong);
        log.info("id:{}",optimUser.getId());
    }

    @Test
    public void update(){
        OptimUser optimUser=new OptimUser();
        optimUser.setId(5L);
        optimUser.setUserName("孙悟天");
        optimUser.setPassWord("888888");
        int update = optimUserDao.update(optimUser);
        log.info("update:{}",update);
    }


}

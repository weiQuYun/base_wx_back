package com.wqy.wx.back.plus2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqy.wx.back.common.util.ParamUtils;
import com.wqy.wx.back.common.util.dozer.IGenerator;
import com.wqy.wx.back.configer.Req;
import com.wqy.wx.back.configer.exception.BizException;
import com.wqy.wx.back.dto.LoginDto;
import com.wqy.wx.back.plus2.entity.TMenber;
import com.wqy.wx.back.plus2.entity.TUser;
import com.wqy.wx.back.plus2.service.ILoginService;
import com.wqy.wx.back.plus2.service.ITMenberService;
import com.wqy.wx.back.plus2.service.ITUserService;
import com.wqy.wx.back.plus2.service.ITokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 成都微趣云网络科技有限公司
 *
 * @ClassName: LoginServiceImpl
 * @Description: TODO
 * @Author licm
 * @Date 2020/4/6 11:39
 * @Version V1.0
 */
@Slf4j
@Primary
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ITMenberService itMenberService;
    @Autowired
    private ITokenService tokenService;
    @Autowired
    private  ITUserService userService;
    @Autowired
    private IGenerator generator;
    @Override
    public Req vxLogin(String phoneNumber, HttpServletRequest request, HttpServletResponse response) {
        TMenber tMenber = new TMenber();
        tMenber.setPhoneNumber(phoneNumber);
        List<TMenber> list =  itMenberService.getList(tMenber);
        if(CollectionUtils.isNotEmpty(list)&&list.size()==1){
            tMenber = list.get(0);
            HttpSession session = request.getSession();
            Req vxLoginDto1 = (Req)session.getAttribute(tMenber.getId());
            if(vxLoginDto1!=null){
                if(vxLoginDto1.getIp().equals((request.getRemoteAddr()))){
                    return vxLoginDto1;
                }else{
                    throw new BizException("单点登陆，此用户已在其他设备上登陆");
                }
            }
            Req req = new Req();
            req.setToken(tokenService.getToken(phoneNumber));
            req.setUserId(tMenber.getId());
            req.setUserName(tMenber.getUserName());
            req.setIp(request.getRemoteAddr());
            session.setAttribute(request.getRemoteAddr(), req);
            session.setAttribute(tMenber.getId(), req);
            Cookie cookie = new Cookie("token", req.getToken());
            cookie.setPath("/");
            response.addCookie(cookie);
            return req;
        }else if(CollectionUtils.isEmpty(list)){
            throw new BizException("用户不存在");
        }else if(list.size()>1){
            throw new BizException("W005","存在相同的用户");
        }
        return null;
    }

    @Override
    public Req backLogin(LoginDto dto, HttpServletRequest request, HttpServletResponse response) {
        TUser tUser = generator.convert(dto,TUser.class);
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper = ParamUtils.reflect(tUser,queryWrapper);
        List<TUser> list =  userService.list(queryWrapper);
        if(CollectionUtils.isNotEmpty(list)&&list.size()==1){
            tUser = list.get(0);
            HttpSession session = request.getSession();
            Req vxLoginDto1 = (Req)session.getAttribute(tUser.getId());
            if(vxLoginDto1!=null){
                if(vxLoginDto1.getIp().equals((request.getRemoteAddr()))){
                    return vxLoginDto1;
                }else{
                    throw new BizException("单点登陆，此用户已在其他设备上登陆");
                }
            }
            Req req = new Req();
            req.setToken(tokenService.getToken(tUser.getUserName(),tUser.getPassword()));
            req.setUserId(tUser.getId());
            req.setUserName(tUser.getUserName());
            req.setIp(request.getRemoteAddr());
            session.setAttribute(request.getRemoteAddr(), req);
            session.setAttribute(tUser.getId(), req);
            Cookie cookie = new Cookie("token", req.getToken());
            cookie.setPath("/");
            response.addCookie(cookie);
            return req;
        }else if(CollectionUtils.isEmpty(list)){
            throw new BizException("W004","");
        }else if(list.size()>1){
            throw new BizException("W005","存在相同的用户");
        }
        return null;
    }

    @Override
    public Boolean logOut(String userId, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(request.getRemoteAddr());
        session.removeAttribute(userId);
        return true;
    }
}

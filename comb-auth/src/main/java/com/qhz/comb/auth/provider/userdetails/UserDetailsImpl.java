package com.qhz.comb.auth.provider.userdetails;

import com.qhz.comb.framework.core.constant.GlobalConstant;
import com.qhz.comb.provider.common.api.vo.SysRoleVo;
import com.qhz.comb.provider.common.api.vo.SysUserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * UserDetails 实现
 *
 * @author jiangting
 * @since 1.0, 2018/5/28
 */
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String status;
    private List<SysRoleVo> roleList = new ArrayList<>();

    public UserDetailsImpl(SysUserVo userVo) {
        this.username = userVo.getUsername();
        this.password = userVo.getPassword();
        this.status = userVo.getDelFlag();
        roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (SysRoleVo role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return StringUtils.equals(GlobalConstant.STATUS_LOCK, status) ? false : true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StringUtils.equals(GlobalConstant.STATUS_NORMAL, status) ? true : false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRoleVo> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRoleVo> roleList) {
        this.roleList = roleList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
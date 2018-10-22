package com.pinyougou.manager.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/21.
 * 认证类
 * @author  gengzi
 * @date 2018年10月21日20:29:46
 */
public class UserDeatilsServiceImpl  implements UserDetailsService {


    //商家登陆服务
    private SellerService service ;

    public void setService(SellerService service) {
        this.service = service;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantAuths= new ArrayList<>();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLR"));

        TbSeller one = service.findOne(username);

        if(one != null){
            if(one.getStatus().equals("1")){
                return new User(username,one.getPassword(),grantAuths);
            }else{
                return null;
            }
        }else{
            return null;
        }

    }
}

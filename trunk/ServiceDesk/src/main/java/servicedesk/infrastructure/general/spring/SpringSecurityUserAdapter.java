/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.spring;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import servicedesk.infrastructure.security.domain.Privilege;
import servicedesk.infrastructure.security.domain.Role;
import servicedesk.infrastructure.security.domain.User;

/**
 *
 * @author Adrian
 */
public class SpringSecurityUserAdapter implements UserDetails {
    private static final long serialVersionUID = 1L;

    private User adapted;
    private Collection<GrantedAuthority> authorities;

    public SpringSecurityUserAdapter(User adapted) {
        this.adapted = adapted;
        this.authorities = Collections.unmodifiableSet(prepareAuthorities());
    }

    protected final Set<GrantedAuthority> prepareAuthorities() {
        Set<GrantedAuthority> result = new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for(Role role: getUser().getRoles())
            for(Privilege privilege: role.getPrivileges())
                result.add(new GrantedAuthorityImpl(privilege.getCode()));

        return result;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return getUser().getPassword();
    }

    @Override
    public String getUsername() {
        return getUser().getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getUser().isEnabled();
    }

    /**
     * @return the adapted
     */
    public User getUser() {
        return adapted;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = 1L;
        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }

}

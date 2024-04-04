package org.bz.app.mspeople.security.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLE_SECURITIES")
public class RoleSecurity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4381713981219682243L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "role")
    private Set<UserSecurity> users;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "ROLE_AUTHORITY_MAPPING", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<AuthoritySecurity> securityAuthorities;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserSecurity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserSecurity> users) {
        this.users = users;
    }

    public Set<AuthoritySecurity> getSecurityAuthorities() {
        return securityAuthorities;
    }

    public void setSecurityAuthorities(Set<AuthoritySecurity> securityAuthorities) {
        this.securityAuthorities = securityAuthorities;
    }
}
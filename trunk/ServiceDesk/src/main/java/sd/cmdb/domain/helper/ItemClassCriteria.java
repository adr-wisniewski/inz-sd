/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain.helper;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

/**
 *
 * @author Adrian
 */
public class ItemClassCriteria {
    private Integer id;
    private String parentName;
    private String name;
    private String description;
    private Boolean abstraction;

    public void setId(Integer id) {
            this.id = id;
    }

    public Integer getId() {
            return id;
    }

    public void setParentName(String parentName) {
            this.parentName = parentName;
    }

    public String getParentName() {
            return parentName;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getName() {
            return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAbstraction(Boolean abstraction) {
            this.abstraction = abstraction;
    }

    public Boolean getAbstraction() {
            return abstraction;
    }

    public void initCriteria(Criteria criteria) {
        if(id != null)
            criteria.add(Restrictions.eq("id", id));

        if(StringUtils.hasText(parentName))
        {
            criteria.createAlias("parent", "p");
            criteria.add(Restrictions.like("p.name", parentName));
        }

        if(StringUtils.hasText(name))
            criteria.add(Restrictions.like("name", name));

        if(StringUtils.hasText(description))
            criteria.add(Restrictions.like("description", description));

        if(abstraction != null)
            criteria.add(Restrictions.eq("abstraction", abstraction));
    }

    public boolean isInitialized()
    {
        return
            id != null
            || StringUtils.hasText(parentName)
            || StringUtils.hasText(name)
            || StringUtils.hasText(description)
            || abstraction != null;
    }
}

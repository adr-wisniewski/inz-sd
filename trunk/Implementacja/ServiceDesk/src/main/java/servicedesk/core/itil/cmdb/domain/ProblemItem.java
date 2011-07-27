/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.core.itil.cmdb.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import servicedesk.core.itil.cmdb.domain.helper.ItemVisitor;
import servicedesk.core.itil.pm.domain.Problem;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_PROBLEM")
public class ProblemItem extends Item {
    private static final long serialVersionUID = 1L;
    private Problem problem;
    private ProblemItemClass problemItemClass;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "PROBLEM_ID")
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    @Transient
    public ProblemItemClass getItemClass() {
        return problemItemClass;
    }

    public void setItemClass(ProblemItemClass problemItemClass) {
        this.problemItemClass = problemItemClass;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }

    @Transient
    @Override
    public String getOverview() {
        StringBuilder builder = new StringBuilder();
        builder.append(problem.getDescription()).append(" ");
        return builder.toString();
    }
}

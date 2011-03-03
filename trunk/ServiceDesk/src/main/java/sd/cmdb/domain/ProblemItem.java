/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import sd.pm.domain.Problem;

/**
 *
 * @author Adrian
 */
@javax.persistence.Entity
@Table(name="C2_ITEMS_PROBLEM")
public class ProblemItem extends Item {
    private Problem problem;

    /**
     * @return the problem
     */
    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "PROBLEM_ID")
    public Problem getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}

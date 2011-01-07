/**
 * 
 */
package sd.pm.service;

import sd.domain.Comment;
import sd.im.domain.SupportGroup;
import sd.pm.domain.Problem;
import java.util.List;
import java.util.Set;

import sd.pm.domain.KnownError;
import sd.pm.domain.ProblemCategory;
import sd.pm.domain.ProblemStatus;
import sd.pm.domain.ProblemUrgency;
import sd.pm.domain.ProblemImpact;
import sd.pm.domain.ProblemPriority;
import sd.pm.domain.Solution;
import sd.pm.app.KnownErrorSearchCriteria;
import sd.pm.app.ProblemSearchCriteria;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface ProblemService {

	/** 
	 * <!-- begin-UML-doc -->
	 * Dodaje nowy problem
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void add(Problem problem);

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie kategorie problemow
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<ProblemCategory> getAllCategories();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie statusu problemow
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<ProblemStatus> getAllStatuses();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie typy pilnosci
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<ProblemUrgency> getAllUrgencies();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie rodzaje wplywow
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<ProblemImpact> getAllImpacts();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie priorytety
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<ProblemPriority> getAllPriorities();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca problem po id
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Problem getById(Integer problemId);

	/** 
	 * <!-- begin-UML-doc -->
	 * Dokonuje edycji problemu
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void edit(Problem problem);

	/** 
	 * <!-- begin-UML-doc -->
	 * Dodaje rozwiazanie dla problemu
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @param solution
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addSolution(Problem problem, Solution solution);

	/** 
	 * <!-- begin-UML-doc -->
	 * Powiazuje problem z incydentem
	 * <!-- end-UML-doc -->
	 * @param problem
	 * @param incidentIds
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void associate(Problem problem, Set<String> incidentIds);

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca problemy spelniajace podane kryterium
	 * <!-- end-UML-doc -->
	 * @param searchCriteria
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Problem> search(ProblemSearchCriteria searchCriteria);
	
	/**
	 * 
	 * @param problem
	 * @param comment
	 */
	public void addComment(Problem problem, Comment comment);
	/**
	 * Usuwa polaczenie miedzy incydentem a problemem
	 * 
	 * @param problem problem
	 * @param incidentId id incydentu do usuniecie
	 */
	public void deleteIncident(Problem problem, Integer incidentId);

	/**
	 * 
	 * @return zwraca wszsytkie grupy wsparcia
	 */
	public List<SupportGroup> getAllGroups();
	
	/**
	 * 
	 * @param searchCriteria kryterium wyszukiwania znanych bledow
	 * @return zwraca lsite znanych bledow spelniajacych podane kryterium
	 */
	public List<KnownError> search(KnownErrorSearchCriteria searchCriteria);
}
/**
 * 
 */
package sd.im.service;

import java.util.List;

import sd.domain.Comment;
import sd.domain.HistoryActions;
import sd.im.app.IncidentSearchCriteria;
import sd.im.domain.Incident;
import sd.im.domain.IncidentCategory;
import sd.im.domain.IncidentImpact;
import sd.im.domain.IncidentPriority;
import sd.im.domain.IncidentSource;
import sd.im.domain.IncidentStatus;
import sd.im.domain.IncidentUrgency;
import sd.im.domain.SupportGroup;

/** 
 * <!-- begin-UML-doc -->
 * Klasa uslugowa dla incydentow.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface IncidentService {
	/** 
	 * <!-- begin-UML-doc -->
	 * <p>
	 *     Zwraca incydenty spelniajace podane kryterium.
	 * </p>
	 * <!-- end-UML-doc -->
	 * @param searchCriteria
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Incident> search(IncidentSearchCriteria searchCriteria);

	/** 
	 * <!-- begin-UML-doc -->
	 * Dodaje nowy incydent
	 * <!-- end-UML-doc -->
	 * @param incident
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void add(Incident incident);

	/** 
	 * <!-- begin-UML-doc -->
	 * Dokonuje edycji incydentu.
	 * <!-- end-UML-doc -->
	 * @param incident
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void edit(Incident incident);

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca incydent na podstawie id.
	 * <!-- end-UML-doc -->
	 * @param incidentId
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Incident getById(Integer incidentId);

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie rodzaje wplywow.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentImpact> getAllImpacts();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca wszystkie rodzaje priorytetow.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentPriority> getAllPriorities();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca&nbsp;wszystkie&nbsp;rodzaje typow pilnosci.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentUrgency> getAllUrgencies();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca&nbsp;wszystkie&nbsp;rodzaje kategorii.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentCategory> getAllCategories();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca&nbsp;wszystkie&nbsp;rodzaje statusow.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentStatus> getAllStatuses();

	/** 
	 * <!-- begin-UML-doc -->
	 * Zwraca&nbsp;wszystkie&nbsp;rodzaje zrodel.
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<IncidentSource> getAllSources();

	/** 
	 * <!-- begin-UML-doc -->
	 * <p>
	 *     Dodaje nowy komentarz dla incydentu.
	 * </p>
	 * <!-- end-UML-doc -->
	 * @param incident
	 * @param comment
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addComment(Incident incident, Comment comment);
	
	/**
	 * 
	 * @return kryterium do wyszukania otwartych incydentow aktualnie zalogowanego uzytkownika
	 */
	public IncidentSearchCriteria getCurrentUserOpenIncidentsSearchCriteria();
	
	/**
	 * 
	 * @return kryterium do wyszukania zamknietych incydentow aktualnie zalogowanego uzytkownika
	 */
	public IncidentSearchCriteria getCurrentUserClosedIncidentsSearchCriteria();
	
	/**
	 * 
	 * @return zwraca wszystkie grupy wsparcia
	 */
	public List<SupportGroup> getAllGroups();
	
	/**
	 * @param groupId identyfikator grupy
	 * @return zwraca grupe po id
	 */
	public SupportGroup getGroupById(Integer groupId);
	/**
	 * @param incident 
	 * @return zwraca historie incydentu
	 */
	public List<HistoryActions> getHistory(Incident incident);
        
        /**
         * Dokonuje przypisania incydentu do aktualnego uzytkownika
         * @param incident
         */
        public void accept(Incident incident);

        /**
         * 
         * @return kryterium wyszukiwania dla incydentow przypisanych do aktualnego uzytkownika
         */
        public IncidentSearchCriteria getCurrentUserAssignedIncidentsSearchCriteria();
}
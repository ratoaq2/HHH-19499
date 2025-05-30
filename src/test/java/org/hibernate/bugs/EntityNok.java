package org.hibernate.bugs;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTITY_NOK")
public class EntityNok {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;

	@ElementCollection(targetClass = MyType.class)
	@CollectionTable(name = "ENTITY_NOK_TO_MY_TYPE", joinColumns = @JoinColumn(name = "ENTITY_NOK", nullable = false))
	@Column(name = "MY_TYPE")
	Collection<MyType> myTypes = new ArrayList<MyType>();

}